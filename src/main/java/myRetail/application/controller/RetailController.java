package myRetail.application.controller;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import myRetail.application.model.ErrorDTO;
import myRetail.application.model.PriceMaster;
import myRetail.application.model.PriceMasterDTO;
import myRetail.application.model.ResponseDTO;
import myRetail.application.repo.PriceRepository;

@RestController
public class RetailController {
	
	@Autowired
	PriceRepository repo;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/api/products")
    public Map<String, PriceMaster> GetAll(){
       return repo.findAll();
    }

	@GetMapping("/api/products/{id}")
	public ResponseEntity getDetail(@PathVariable int id)
	{
//		String baseUrl = "http://externalRetail:8080/api/name/"+id;
		String baseUrl = "http://localhost:8080/api/name/"+id;
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		String name = response.getBody();
		PriceMaster pm = repo.findById(id);
		ResponseDTO dt;
		if(name=="")
		{
			 dt = new ResponseDTO(id, "No data present", new PriceMasterDTO());
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dt);
		}
		else if(pm==null)
		{
			 dt = new ResponseDTO(id, name, new PriceMasterDTO());
			 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dt);
		}
		else
		{
			dt = new ResponseDTO(id, name, new PriceMasterDTO(pm.getValue(), pm.getCurrency()));
			return ResponseEntity.status(HttpStatus.OK).body(dt);
		}
		
	}
	
	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
	
	@PostMapping("/api/add")
    public PriceMaster add(@RequestBody PriceMaster price){
        repo.save(new PriceMaster(price.getId(), price.getValue(), price.getCurrency()));
        return repo.findById(price.getId());
    }
	
	@PutMapping("/api/products/{id}")
    public ResponseDTO update(@PathVariable int id, @RequestBody ResponseDTO dto){
		repo.update(new PriceMaster(id, dto.getPrice().getValue(), dto.getPrice().getCurrency_code()));
		return dto;
        
    }
}

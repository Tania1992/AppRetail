package myRetail.application.repo;

import java.util.Map;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import myRetail.application.model.PriceMaster;

@Repository
public class PriceImpl implements PriceRepository{
	
	private RedisTemplate<String, PriceMaster> redisTemplate;
    private HashOperations hashOperations; 
    
    public PriceImpl(RedisTemplate<String, PriceMaster> redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = redisTemplate.opsForHash();
    }

	@Override
	public void save(PriceMaster price) {
		hashOperations.put("PRICE",price.getId(),price);
		
	}

	@Override
	public Map<String, PriceMaster> findAll() {
		// TODO Auto-generated method stub
		return hashOperations.entries("PRICE");
	}

	@Override
	public PriceMaster findById(int id) {
		// TODO Auto-generated method stub
		return (PriceMaster)hashOperations.get("PRICE",id);
	}

	@Override
	public void update(PriceMaster master) {
		// TODO Auto-generated method stub
		save(master);
	}

}

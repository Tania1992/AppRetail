package myRetail.application.repo;

import java.util.Map;

import myRetail.application.model.PriceMaster;

public interface PriceRepository {

	void save(PriceMaster user);
    Map<String,PriceMaster> findAll();
    PriceMaster findById(int id);
    void update(PriceMaster user);
}

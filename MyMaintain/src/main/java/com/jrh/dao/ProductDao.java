package com.jrh.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jrh.pojo.EPIMaterialNew;
import com.jrh.pojo.EPIStoreInfo;
import com.jrh.pojo.Product;
import com.jrh.pojo.TechnologySpecification;

@Repository("productDao")
public interface ProductDao {
	
	List<Product> getAllWorkInProducts();
	
	List<EPIMaterialNew> getDataOfEPIMaterialNew();
	
	List<EPIStoreInfo> getErrorStoreInfo();
	
	List<EPIMaterialNew> getEPIMaterialNews();
	
	List<TechnologySpecification> getTechnologySpecification();
}

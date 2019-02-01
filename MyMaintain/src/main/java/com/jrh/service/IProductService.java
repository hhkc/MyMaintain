package com.jrh.service;

import java.util.List;

import com.jrh.pojo.EPIMaterialNew;
import com.jrh.pojo.Product;
import com.jrh.pojo.TechnologySpecification;

public interface IProductService {
	List<Product> getAllWorkInProducts();
	
	List<EPIMaterialNew> getDataOfEPIMaterialNew();
	
	List<TechnologySpecification> checkTechnologySpecification();
}

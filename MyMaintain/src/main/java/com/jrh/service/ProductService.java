package com.jrh.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.jrh.dao.ProductDao;
import com.jrh.pojo.EPIMaterialNew;
import com.jrh.pojo.Product;
import com.jrh.pojo.TechnologySpecification;

@Service("productService")
public class ProductService implements IProductService{

	@Resource
	private ProductDao productDao;
	
	@Override
	public List<Product> getAllWorkInProducts() {
		List<Product> products = productDao.getAllWorkInProducts();
		return products;
	}

	@Override
	public List<EPIMaterialNew> getDataOfEPIMaterialNew() {
		List<EPIMaterialNew> epiMaterialNews = productDao.getDataOfEPIMaterialNew();
		return epiMaterialNews;
	}

	@Override
	public List<TechnologySpecification> checkTechnologySpecification() {
		List<TechnologySpecification> technologySpecifications = productDao.getTechnologySpecification();
		List<TechnologySpecification> returnTechnologySpecifications = new ArrayList<>();
		if(technologySpecifications != null && technologySpecifications.size() > 0){
			for(int i = 0; i < technologySpecifications.size(); i++){
				TechnologySpecification technologySpecification = technologySpecifications.get(i);
				String epiCarrier = technologySpecification.getEPI_CARRIER();
				String epiLayerTextURE = technologySpecification.getEPILAYER_TEXTURE();
				int layerNum1 = 0;
				int layerNum2 = 0;
				if(epiCarrier != null && !epiCarrier.contains(";")){
					layerNum1 = 1;
				}else {
					
				}
				
				if(epiLayerTextURE != null){
					layerNum2 = epiLayerTextURE.length()-epiLayerTextURE.replace("/", "").length();
				}
				

				if(layerNum1 != layerNum2){
					returnTechnologySpecifications.add(technologySpecification);
				}
				
			}
		}
		return returnTechnologySpecifications;
	}

	
}

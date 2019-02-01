package com.jrh.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jrh.pojo.EPIMaterialNew;
import com.jrh.pojo.Product;
import com.jrh.pojo.TechnologySpecification;
import com.jrh.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	
	@Autowired
	private IProductService productService;
	
	@RequestMapping(value = "/getAllWorkInProducts",method=RequestMethod.GET)
	public ModelAndView getAllWorkInProducts(HttpServletRequest request){
		
		ModelAndView mav = new ModelAndView();
		
		List<Product> products = productService.getAllWorkInProducts();
		if(products != null && products.size() > 0){
			for(int i=0;i< products.size(); i++){
				System.out.println(products.get(i).toString());
			}
			mav.addObject("products", products);
			
		}else{
			mav.addObject("products", new ArrayList<>());
		}

		mav.setViewName("product");
		return mav;
	}
	
	@RequestMapping(value = "/getDataOfEPIMaterialNew",method=RequestMethod.GET)
	public void getDataOfEPIMaterialNew(HttpServletRequest request){
		ModelAndView mav = new ModelAndView();
		long t1 = System.currentTimeMillis();
		System.out.println(t1);
		List<EPIMaterialNew> epiMaterialNews = productService.getDataOfEPIMaterialNew();
		long t2 = System.currentTimeMillis();
		System.out.println(t2);
		
		System.out.println(t2-t1);
		
		
		
		if(epiMaterialNews != null && epiMaterialNews.size() > 0){
			/*for(int i=0;i<epiMaterialNews.size();i++){
				System.out.println(epiMaterialNews.get(i).toString());
			}*/
			mav.addObject("epiMaterialNews",epiMaterialNews);
		}else{
			mav.addObject("epiMaterialNews", new ArrayList<>());
		}

		
	}
	
	@Scheduled(cron = "0 0/1 * * * ?")  //每隔5秒执行一次定时任务
    public void consoleInfo(){
		List<TechnologySpecification> technologySpecifications = productService.checkTechnologySpecification();
		
		if(technologySpecifications != null && technologySpecifications.size() > 0){
			for (TechnologySpecification technologySpecification : technologySpecifications) {
				System.out.println(technologySpecification.toString());
			}
		}else {
			System.out.println("未发现异常");
		}
    }
}

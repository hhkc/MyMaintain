package com.jrh.task;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.jrh.dao.ProductDao;
import com.jrh.mail.PwdMailSender;
import com.jrh.pojo.EPIStoreInfo;

@Component
public class FlightTrainTask {
	
	@Autowired
    private PwdMailSender pwdMailSender;
	
	@Resource
	private ProductDao productDao;
	
	@Scheduled(cron = "0 0/1 * * * ? ") // 间隔5秒执行
    public void taskCycle() {
		
		List<EPIStoreInfo> epiStoreInfos = productDao.getErrorStoreInfo();
		StringBuffer sb = new StringBuffer("");
		if(epiStoreInfos != null && epiStoreInfos.size() > 0){
			for(int i = 0; i<epiStoreInfos.size();i++){
				String subId = epiStoreInfos.get(i).getSUB_ID();
				sb.append(subId + " ");
			}
			//pwdMailSender.send("刘国建", sb.toString(), "593052752@qq.com");
		}
    }
}

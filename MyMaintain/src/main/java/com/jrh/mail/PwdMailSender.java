package com.jrh.mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;


@Component
public class PwdMailSender {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private SimpleMailMessage simpleMailMessage;
	
	@Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;
	
	
	 /**
     * 
     * @Description: ��ģ���й����ʼ�����
     * @param nickName        �û��ǳ�
     * @param content        �ʼ�����
     * @param email            �����ʼ�
     * 
     * @author leechenxiang
     * @date 2017��2��5�� ����1:22:00
     */
    public void send(String nickName, String content, String email) {
        String to = email;
        String text = "";
        Map<String, String> map = new HashMap<String, String>(1);
        map.put("nickName", nickName);
        map.put("content", content);                                                                                                                                                                                                                                                                                                                                                                                        
        try {
            // ����ģ�����ݣ���̬��map�е���������ȥ������HTML
        	Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.ftl");
            // map�е�key����Ӧģ���е�${key}���ʽ
            text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        sendMail(to, null, text);
    }
    
    /**
     * 
     * @Description: ִ�з����ʼ�
     * @param to            �ռ�������
     * @param subject        �ʼ�����
     * @param content        �ʼ�����
     * 
     * @author leechenxiang
     * @date 2017��2��5�� ����1:22:34
     */
    public void sendMail(String to, String subject, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setFrom(simpleMailMessage.getFrom());
            if (subject != null) {
                messageHelper.setSubject(subject);
            } else {
                messageHelper.setSubject(simpleMailMessage.getSubject());
            }
            messageHelper.setTo(to);
            messageHelper.setText(content, true);        
           javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}

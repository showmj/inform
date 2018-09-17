package com.example.demo.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mainController {

	@GetMapping("/")
	public String main() {

		return "main";
	}
	@Autowired
	  private JavaMailSender mailSender;
	
	@PostMapping("/email")
	  public String mailSending(HttpServletRequest request) throws MailException {
	   
	    String setfrom = "chlalswo87@gmail.com";         
	    String tomail  = "newflavor@naver.com";     // 諛쏅뒗 �궗�엺 �씠硫붿씪
	    String title   = request.getParameter("text1");      // �젣紐�
	    String content1 = request.getParameter("text2");    // �궡�슜
	    String content2 = request.getParameter("text3");
	    String content3 = request.getParameter("text4");
	    try {
	      MimeMessage message = mailSender.createMimeMessage();
	      MimeMessageHelper messageHelper 
	                        = new MimeMessageHelper(message, true, "UTF-8");
	 
	      messageHelper.setFrom(setfrom);  // 蹂대궡�뒗�궗�엺 �깮�왂�븯嫄곕굹 �븯硫� �젙�긽�옉�룞�쓣 �븞�븿
	      messageHelper.setTo(tomail);     // 諛쏅뒗�궗�엺 �씠硫붿씪
	      messageHelper.setSubject(title); // 硫붿씪�젣紐⑹� �깮�왂�씠 媛��뒫�븯�떎
	      messageHelper.setText(content1+content2+content3);  // 硫붿씪 �궡�슜
	      
	      mailSender.send(message);
	    } catch(Exception e){
	      System.out.println(e);
	    }
	   
	    return "main";
	  }

}

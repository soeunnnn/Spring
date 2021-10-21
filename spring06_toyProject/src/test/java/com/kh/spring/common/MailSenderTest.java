package com.kh.spring.common;

import java.util.Date;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.spring.member.model.dto.Member;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
public class MailSenderTest {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired //bean에 등록했던 객체 주입받기
	JavaMailSenderImpl mailSender;
	
	@Autowired //bean에 등록했던 객체 주입받기
	RestTemplate http;
	
	@Test
	public void sendEmail()throws Exception{
		MimeMessage msg = mailSender.createMimeMessage();
		msg.setFrom("thdms12333@gmail.com"); 
		msg.setRecipients(Message.RecipientType.TO, "thdms12333@gmail.com");  //메일 받는 사람
		msg.setSubject("메일테스트"); //메일 제목
		msg.setSentDate(new Date());
		msg.setText("<h1>Email Test</h1>", "UTF-8", "html"); //html 양식에 맞춰 메일이 갈 수 있도록 지정(api참고) 메일 내용
		mailSender.send(msg);
	}

	@Test
	public void restTemplateTest() {
		//String naver = http.getForObject("https://www.naver.com", String.class);
		
		//MultiValueMap : 하나의 키값으로 여러개의 밸류값을 저장할 수 있도록 하는 객체
		MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
		body.add("userId", "test");
		body.add("password", "1234");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(body, headers);
		
		//RestTemplate에서 post메서드로 요청할때 사용하는 메서드
		String login = http.postForObject("http://localhost:8989/member/login", entity, String.class);
		
		logger.debug(login);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

package com.kh.spring.common.mail.handler;

import java.util.HashMap;
import java.util.Map;

public class MailTemplate {
	
	private String templateName;
	private Map<String,String> component = new HashMap<>();
	
	//메일템플릿이 생성되는 시점에 무조건 템플릿네임을 전달받도록
	public MailTemplate(String templateName) {
		this.templateName = templateName;
	}
	
	public void addMailComponent(String name, String comp) {
		component.put(name, comp);
	}
	
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public void setComponent(Map<String, String> component) {
		this.component = component;
	}

	public String getTemplateName() {
		return templateName;
	}

	public Map<String,String> getMailComp(){
		return component;
	}
}

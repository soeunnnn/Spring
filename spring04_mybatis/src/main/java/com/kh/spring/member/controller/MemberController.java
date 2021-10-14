package com.kh.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.spring.member.model.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//커밋잘되는건가..???????????????????
	
	
	@GetMapping("search-pw") //search-pw로 요청이 왔을 때 이 메서드가 실행되도록
	public String searchPassword() {
		System.out.println("비밀번호는 " + memberService.selectPasswordByUserId());
		return "home";
	}

}

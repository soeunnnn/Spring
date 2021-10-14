package test03;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test02.Week;

public class Run {

	public static void main(String[] args) {

		//ApplicationContext에 2021년 10월 9일 날짜를 가지는 java.util.Date 빈을 등록하고
		//main메서드에서 해당 빈을 호출해 toString메서드를 출력하세요.
		//해당 bean의 아이디는 date입니다.
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test03/applicationContext.xml");
		
		//System.out.println("오늘은 " + context.getBean("dateBean", Date.class) + " 입니다.");
		//System.out.println(context.getBean("scoreBean", Score.class));

	}

}

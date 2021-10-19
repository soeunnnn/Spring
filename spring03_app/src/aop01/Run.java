package aop01;

import java.util.Iterator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop01/applicationContext.xml");
		
		Man man = context.getBean("man", Man.class);
		Woman woman = context.getBean("woman", Woman.class);
		

		woman.develop();
		System.out.println("==========================");
		man.develop();

	}

}

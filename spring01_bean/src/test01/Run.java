package test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {

		ApplicationContext context 
				 = new ClassPathXmlApplicationContext("test01/applicationContext.xml");
		
		Address addr = (Address) context.getBean("hong"); //context에서 반환받고 싶은 아이디를 매개변수로 넣어주면 그것을 반환해줌
		Address lee = context.getBean("lee", Address.class); //타입을 지정해주면 해당 타입에 맞게 캐스팅해서 반환
		System.out.println(addr);
		System.out.println(lee);
		System.out.println(context.getBean("kim", Address.class));
	}

}

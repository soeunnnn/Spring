package aop02;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component  //applicationContext에서 등록할 수 있도록 Component 어노테이션 지정
public class MyAspect{
	
	public void before() {
		System.out.println("출근 카드를 찍는다.");
	}
	
	public void after() {
		System.out.println("집에 간다.");
	}
	
	public void afterReturning() {
		System.out.println("퇴근 카드를 찍는다.");
	}
	
	public void afterThrowing() {
		System.out.println("쉬는 날이었다.");
	}


}

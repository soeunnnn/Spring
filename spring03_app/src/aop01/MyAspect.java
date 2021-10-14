package aop01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component  //applicationContext에서 등록할 수 있도록 Component 어노테이션 지정
public class MyAspect implements MethodInterceptor{  //MethodInterceptor타입을 구현하면 advice 타입을 가지게 됨

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("출근 카드를 찍는다.");
		
		try {
			invocation.proceed(); 
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("집에 간다.");
		}
		
		return null; //반환할거없으니까 null
	}

}

package aop02;

import org.springframework.stereotype.Component;

@Component
public class Man {
	
	public void develop() {	
		//int i = 1/0;
		System.out.println("파이썬으로 개발한다.");
	}
	
	private void play() {
		System.out.println("리니지w를 플레이한다.");
	}

}

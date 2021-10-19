package proxy.client;

import proxy.framework.MyAspect;

public class Run {

	public static void main(String[] args) {

		new MyAspect("proxy.client.Man").develop(); //사용자가 입력하는 클래스명의 인스턴스를 제공
		System.out.println("====================");
		new MyAspect("proxy.client.Woman").develop();

	}

}

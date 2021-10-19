package proxy.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;

import proxy.client.Man;
import proxy.client.Woman;

public class MyAspect implements Developer{
	
	private Developer developer;
	
	//자바 Reflection : 객체 또는 클래스명을 통해 타입에 대한 정보를 조사할 수 있는 기법
	
	public MyAspect(String className) {
	
			try {
				developer = (Developer) Class.forName(className).getDeclaredConstructor().newInstance(); //사용자가 입력해준 클래스정보로 바로 인스턴스를 생성하도록
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException
					| ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	@Override
	public void develop() {
		System.out.println("출근 카드를 찍는다.");
		
		try {
			System.out.println(developer.getClass()); //현재 클래스객체가 뭔지 알아보기 위해
			Method play = developer.getClass().getDeclaredMethod("play");  
			play.setAccessible(true);
			play.invoke(developer);
			
			developer.develop();
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("집에 간다.");
		}
	}
		
	

}

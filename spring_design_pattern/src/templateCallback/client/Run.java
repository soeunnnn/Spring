package templateCallback.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Stream;

import templateCallback.framework.MemberDao;


public class Run {
	
	//자바 람다
	//Functional Interface : 추상메서드가 하나만 존재하는 인터페이스
	//						인터페이스 위에 @FunctionalInterface 어노테이션을 작성
	//Functional Interface의 추상메서드는 화살표함수 형태로 오버라이드 가능
	
	// * 자바의 화살표함수도 매개변수의 타입을 생략 가능
	// * 화살표 함수의 메서드 body block을 생략할 경우, ; 도 생략
	// * 매개변수가 하나만 있는 경우 () 생략 가ㅡㅇ
	// * return문 밖에 없는 경우, 메서드 body block과 return 생략
	// * 메서드 구문이 1줄인 경우 메서드 body block을 생략
	
	

	public static void main(String[] args) {
		
		String[] p = {"AA", "BB"};
		
		Stream stream = Arrays.stream(p).filter(a -> {
			boolean res = a.equals("AA");
			System.out.println(a + " : " + res);
			return res;
		});
		
		System.out.println(Arrays.toString(stream.toArray()));

		String password = new MemberDao().selectPassword("DEV", () -> { //익명클래스로 구현해서 넘기기(클래스를 새로 안만들어도 되는 장점이 있음) =>이것도 내부클래스임  =>화살표 함수로 변환 가능함
			//화살표함수를 사용하기 위해서는 익명클래스로 만든 인터페이스에 추상메서드가 하나만 있어야 함 (하나 이상이면 어떤 메서드를 오버라이드 할 지 모르기때문)	
			Connection conn = null;
				try {
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bm", "1234");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return conn;
			}
		);
		
		System.out.println("비밀번호는 " + password + "입니다.");
	}

}

package templateCallback.framework;

import java.sql.Connection;

@FunctionalInterface  //=>이 인터페이스의 메서드를 화살표함수의 추상메서드로 사용하기 위해 만들었다는 표시
public interface ConnectionMaker {

	Connection getConnection();
	
}

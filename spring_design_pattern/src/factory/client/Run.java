package factory.client;

import factory.framework.ConnectorFactory;
import factory.framework.SMTPConnector;

public class Run {
	
	public static void main(String[] args) {
		
		//네이버 SMTP서버에 연결을 해보자
		try {
			SMTPConnector conn = ConnectorFactory.builder() //커넥터팩토리에 의해 의존성을 주입받음
					.url("smtp.naver.com")
					.id("so-eun24@naver.com")
					.password("123456")
					.build()
					.getConnector();
			
			conn.connect();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package factory.framework;

import java.util.Date;

public class ConnectorFactory {
	
	private String url;
	private String id;
	private String password;
	private Date connectTime;
	
	//생성자 만들기
	public ConnectorFactory(ConnectorFactoryBuilder builder) {
		this.url = builder.url;
		this.id = builder.id;
		this.password = builder.password;
		this.connectTime = new Date();
	}
	
	//빌더를 반환받을 수 있는 메서드 생성
	public static ConnectorFactoryBuilder builder() {
		return new ConnectorFactoryBuilder();
	}
	
	public static class ConnectorFactoryBuilder{ //서브클래스 생성
		private String url;
		private String id;
		private String password;
		
		//자기자신을 반환하는 메서드들 생성
		public ConnectorFactoryBuilder url(String url) {
			this.url = url;
			return this; //리턴 this하면 빌더인스턴스가 반환
		}
		
		public ConnectorFactoryBuilder id(String id) {
			this.id = id;
			return this;
		}
		
		public ConnectorFactoryBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		//커넥터팩토리를 리턴 할 빌드메서드 생성 (위에서 입력한 값들로 생성되는 커넥터팩토리)
		public ConnectorFactory build() {
			return new ConnectorFactory(this);
		}
	}
	
	public SMTPConnector getConnector() throws Exception {
		
		if(url.equalsIgnoreCase("smtp.naver.com")) {
			return new NaverMailConnector(url, id, password, connectTime);
		}else if(url.equalsIgnoreCase("smtp.daum.net")) {
			return new DaumMailConnector(url, id, password, connectTime);
		}else if(url.equalsIgnoreCase("smtp.google.com")) {
			return new GoogleMailConnector(url, id, password, connectTime);
		}else {
			throw new Exception("잘못된 smtp host를 입력하였습니다.");
		}
	}

}

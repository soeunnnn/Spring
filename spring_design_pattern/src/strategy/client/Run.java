package strategy.client;

import strategy.framework.MemberDao;

public class Run {

	public static void main(String[] args) {

		String password = new MemberDao().selectPassword("DEV", new ConnectionFactory()); //사용자가 전략(ConnectionFactory)을 선택해서 넘겨줌
		System.out.println("비밀번호는 " + password + "입니다.");

	}

}

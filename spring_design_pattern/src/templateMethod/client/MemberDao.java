package templateMethod.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import templateMethod.framework.AbstractMemberDao;

public class MemberDao extends AbstractMemberDao{

	//사용자가 직접 커넥션을 작성해서 사용하도록 
	@Override
	public Connection getConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bm", "1234");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}

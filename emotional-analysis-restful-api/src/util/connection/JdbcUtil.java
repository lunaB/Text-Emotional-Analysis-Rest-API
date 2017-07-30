package util.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){	
		String connectionString = "jdbc:mysql://gondr.iptime.org/Y20109?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Seoul";
		String dbUser = "Y20109";
		String dbPass = "1234";
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionString, dbUser, dbPass);
		}catch (SQLException e){
			System.out.println("DB 연결실패");
		}
		return conn;
	}
}

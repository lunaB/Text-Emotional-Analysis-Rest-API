package common.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.model.jdbc.ConnectionProvider;
import common.model.jdbc.JdbcUtil;

public class UserDAO {
	
	private UserDAO(){}
	
	private static UserDAO userDAO = new UserDAO();
	
	public static UserDAO getInstance(){
		return userDAO;
	}
	
	// sign up
	public boolean insert(String id, String pw, String clientId, String clientSecret, int rating){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		if(!idIsOverlap(id)){
			try {
				conn = ConnectionProvider.getConnection();
				pstmt = conn.prepareStatement("INSERT INTO user VALUES(NULL, ?, ?, ?, ?, ?, 0)");
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, clientId);
				pstmt.setString(4, clientSecret);
				pstmt.setInt(5, rating);
				if(pstmt.executeUpdate()!=0){
					JdbcUtil.close(conn, pstmt, rs);
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JdbcUtil.close(conn, pstmt, rs);
			}
		}
		return false;
	}
	
	private boolean idIsOverlap(String id){
		//나중에 ajax로 id 중복체크 해줘야함 //후순위
		//현재는 중복시 false 반환함
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM user WHERE uid=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				JdbcUtil.close(conn, pstmt, rs);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return false;
	}
	
	//sign in
	public boolean select(String id, String pw){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM user WHERE uid=? AND upw=?");
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				JdbcUtil.close(conn, pstmt, rs);
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return false;
	}
}

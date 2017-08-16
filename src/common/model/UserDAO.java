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
	
	public void usageUpdate(int textLength, String clientId, String clientSecret){
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE user u SET u.usage=u.usage+? WHERE client_id=? AND client_secret=?";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, textLength);
			pstmt.setString(2, clientId);
			pstmt.setString(3, clientSecret);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt);
		}
	}
	
	// api 호출용
	public UsageVO usageSelectApi(String clientId, String clientSecret){
		UsageVO usageVO = new UsageVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT u.usage, r.total FROM user u, rate r WHERE u.client_id=? AND u.client_secret=? AND u.rating = r.rating";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, clientId);
			pstmt.setString(2, clientSecret);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				usageVO.setUsage(rs.getInt(1));
				usageVO.setTotal(rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return usageVO;
	}
	
	//설정 호출용
	public UsageVO usageSelect(String id){
		UsageVO usageVO = new UsageVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT u.usage, r.total FROM user u, rate r WHERE u.uid=? AND u.rating = r.rating";
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				usageVO.setUsage(rs.getInt(1));
				usageVO.setTotal(rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return usageVO;
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
	public boolean signInSelect(String id, String pw){
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
	
	// mypage
	public UserVO userSelect(String id){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO userVO = new UserVO();
		
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM user WHERE uid=?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				userVO.setNo(rs.getInt(1));
				userVO.setUid(rs.getString(2));
				userVO.setUpw(rs.getString(3));
				userVO.setClient_id(rs.getString(4));
				userVO.setClient_secret(rs.getString(5));
				userVO.setRating(rs.getInt(6));
				userVO.setUsage(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return userVO;
	}
}

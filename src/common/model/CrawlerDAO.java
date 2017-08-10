package common.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.model.jdbc.ConnectionProvider;
import common.model.jdbc.JdbcUtil;

public class CrawlerDAO {
	
	Connection conn = null;
	
	private static CrawlerDAO crawlerDAO = new CrawlerDAO();
	
	//커넥션 생성을 메서드안에서하면 풀 때문에 무한대기현상이 생겨서 빼놓음.
	private CrawlerDAO(){
		try {
			conn = ConnectionProvider.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static CrawlerDAO getInstance(){
		return crawlerDAO;
	}
	
	// (사용구현안함)
	public void insertLog(CrawlerLogVO vo){
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("INSERT INTO crawler_log VALUES(NULL,?,?)");
			pstmt.setInt(1, vo.getAc());
			pstmt.setTimestamp(2, vo.getDate());
			pstmt.executeUpdate();
			JdbcUtil.close(pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	public void insertWord(WordVO vo){
		PreparedStatement pstmt = null;
		try {
//			pstmt = conn.prepareStatement("INSERT INTO word VALUES ('예쁘', 8.0, 1) ON DUPLICATE KEY UPDATE cnt = cnt+1, point = ((point*cnt)+8.0)/(cnt+1)");
			pstmt = conn.prepareStatement("INSERT INTO word VALUES (?, ?, 1) ON DUPLICATE KEY UPDATE cnt = cnt+1, point = ((point*cnt)+?)/(cnt+1)");
			pstmt.setString(1, vo.getWord());
			pstmt.setFloat(2, vo.getPoint());
			pstmt.setFloat(3, vo.getPoint());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
	}
	
	// 아직 구현 안함
	public String lastCrawlerNo(){
		return null;
	}
}

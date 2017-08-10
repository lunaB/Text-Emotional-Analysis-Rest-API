package common.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.model.jdbc.ConnectionProvider;

public class CrawlerDAO {
	private CrawlerDAO(){}
	
	private static CrawlerDAO crawlerDAO = new CrawlerDAO();
	
	public static CrawlerDAO getInstance(){
		return crawlerDAO;
	}
	
	public void insertLog(CrawlerLogVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO crawler_log VALUES(NULL,?,?)");
			pstmt.setInt(1, vo.getAc());
			pstmt.setTimestamp(2, vo.getDate());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWord(WordVO vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionProvider.getConnection();
//			pstmt = conn.prepareStatement("INSERT INTO word VALUES ('예쁘', 8.0, 1) ON DUPLICATE KEY UPDATE cnt = cnt+1, point = ((point*cnt)+8.0)/(cnt+1)");
			pstmt = conn.prepareStatement("INSERT INTO word VALUES (?, ?, 1) ON DUPLICATE KEY UPDATE cnt = cnt+1, point = ((point*cnt)+?)/(cnt+1)");
			pstmt.setString(1, vo.getWord());
			pstmt.setFloat(2, vo.getPoint());
			pstmt.setFloat(3, vo.getPoint());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String lastCrawlerNo(){
		return null;
	}
}

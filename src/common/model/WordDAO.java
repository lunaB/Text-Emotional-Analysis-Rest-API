package common.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.model.jdbc.ConnectionProvider;
import common.model.jdbc.JdbcUtil;

public class WordDAO {
	
	private static WordDAO wordDAO = new WordDAO();
	
	public static WordDAO getInstance(){
		return wordDAO;
	}
	
	public double selectText(List<String> textList){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		if(textList.isEmpty()){
			return 0.0; //0은 나올 수 없는 수치임 1.0 ~ 10.0
		}
		try {
			conn = ConnectionProvider.getConnection();
			StringBuffer sql = new StringBuffer("SELECT AVG(point) FROM word WHERE word in(");
			sql.append("? ");
			for(int i=1;i<textList.size();i++){
				sql.append(",?");
			}
			sql.append(")");
			pstmt = conn.prepareStatement(sql.toString());
			for(int i=0;i<textList.size();i++){
				pstmt.setString(i+1, textList.get(i));
			}
			rs = pstmt.executeQuery();
			if(rs.next()){
				return rs.getFloat(1);
			}else {
				return 0.0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn, pstmt, rs);
		}
		return 0.0;
	}
}

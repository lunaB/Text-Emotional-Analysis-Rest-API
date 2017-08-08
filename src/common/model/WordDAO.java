package common.model;

public class WordDAO {
	private WordDAO(){}
	
	private static WordDAO wordDAO = new WordDAO();
	
	public static WordDAO getInstance(){
		return wordDAO;
	}
	
	public String lastCrawlerNo(){
		
		return null;
	}
	
}

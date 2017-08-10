package crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import common.model.CrawlerDAO;
import common.model.WordVO;
import crawler.util.NLP;
import crawler.util.TwitterNLP;

public class NaverMovieCrawler {
	
	NLP nlp;
	
	public NaverMovieCrawler() {
		nlp = new TwitterNLP();
	}
	
	public void process(){
		CrawlerDAO crawlerDAO = CrawlerDAO.getInstance();
		
		try {
			// naver 최대  1000페이지
			for(int i=0;i<100;i++){
				Document doc = Jsoup.connect("http://movie.naver.com/movie/point/af/list.nhn?&page="+i).get();
				Elements contents = doc.select("table.list_netizen>tbody>tr");
				for(Element ele : contents){
					int num = Integer.parseInt(ele.select("td.ac").text());
					int star = Integer.parseInt(ele.select("td.point").text());
					String comment = ele.select("td.title").text();
					comment = comment.substring(0,comment.length()-3); 	//뒤에 "(space)신고" 제거
					
					List<String> words = nlp.process(comment);		//필터로 거른 단어리스트
					Iterator<String> it = words.iterator();
					System.out.println(num);
					while(it.hasNext()){
						String word = it.next();
						WordVO vo = new WordVO();
						vo.setWord(word);
						vo.setPoint(star);
						crawlerDAO.insertWord(vo);
					}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

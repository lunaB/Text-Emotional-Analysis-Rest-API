package crawler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.util.NLP;
import crawler.util.TwitterNLP;

public class NaverMovieCrawler {
	
	NLP nlp;
	
	public NaverMovieCrawler() {
		nlp = new TwitterNLP();
	}
	
	public void process(){
		try {
			Document doc = Jsoup.connect("http://movie.naver.com/movie/point/af/list.nhn?&page=1").get();
			Elements contents = doc.select("table.list_netizen>tbody>tr");
			for(Element ele : contents){
				int num = Integer.parseInt(ele.select("td.ac").text());
				int star = Integer.parseInt(ele.select("td.point").text());
//				String title = ele.select("td.title>a.movie").text();
				String comment = ele.select("td.title").text();
				comment = comment.substring(0,comment.length()-3); 	//뒤에 "(space)신고" 제거
				
				List<String> words = nlp.getWordList(comment);		//필터로 거른 단어리스트
				Iterator<String> it = words.iterator();
				System.out.println(num);
				while(it.hasNext()){
					String word = it.next();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

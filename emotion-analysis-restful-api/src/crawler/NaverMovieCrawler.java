package crawler;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import crawler.util.TwitterNLP;

public class NaverMovieCrawler {
	
	public int run(){
		try {
			Document doc = Jsoup.connect("http://movie.naver.com/movie/point/af/list.nhn?&page=1").get();
			Elements contents = doc.select("table.list_netizen>tbody>tr");
			for(Element ele: contents){
				int star = Integer.parseInt(ele.select("td.point").text());
				String title = ele.select("td.title>a.movie").text();
				String comment = ele.select("td.title").text();
				comment = comment.substring(0,comment.length()-3); //뒤에 "(space)신고" 제거
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	
}

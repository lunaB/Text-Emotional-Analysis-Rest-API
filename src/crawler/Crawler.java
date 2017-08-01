package crawler;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class Crawler {
	
	final private String webDriverPath;
	
	public Crawler(String webDriverPath) {
		this.webDriverPath = webDriverPath;
	}
	
	public void init(){
		NaverMovieCrawler nmc = new NaverMovieCrawler();
		nmc.run();
	}
	
	private List<WebElement> getCommentList(){
		System.setProperty("phantomjs.binary.path",webDriverPath);
		WebDriver driver = new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://comic.naver.com/comment/comment.nhn?titleId=570503&no=182");
	    List<WebElement> ele = driver.findElements(By.className("u_cbox_contents"));
	    Iterator<WebElement> it = ele.iterator();
	    while(it.hasNext()){
	    	System.out.println(it.next().getText());
	    }
	    driver.quit();
		return null;
	}
}

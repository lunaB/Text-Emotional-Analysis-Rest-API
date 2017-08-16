package daemon;

import java.util.TimerTask;

import crawler.NaverMovieCrawler;

public class CrawlerJob extends TimerTask{

	private NaverMovieCrawler nmc;
	
	public CrawlerJob(String webDriverPath) {
		nmc = new NaverMovieCrawler();
		
	}
	
	@Override
	public void run() {
		//nmc.process();
	}
	
}

package daemon;

import java.util.TimerTask;

import crawler.Crawler;

public class CrawlerJob extends TimerTask{

	private Crawler wtc;
	
	public CrawlerJob(String webDriverPath) {
		wtc = new Crawler(webDriverPath);
	}
	
	@Override
	public void run() {
		wtc.init();
	}
	
}

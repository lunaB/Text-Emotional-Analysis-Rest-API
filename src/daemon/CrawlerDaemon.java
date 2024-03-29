package daemon;

import java.io.File;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class CrawlerDaemon extends HttpServlet{
	
	private Timer scheduler;
	private CrawlerJob job;
	
	@Override
	public void init() throws ServletException {
		String webDriverPath = getServletContext().getRealPath("/") + "exec" + File.separator + "phantomjs.exe";
		job = new CrawlerJob(webDriverPath);
		scheduler = new Timer();
		
		scheduler.scheduleAtFixedRate(job, 1000*10, 1000*60*60); //10초 뒤부터 60분에 1번씩
	}
	
	@Override
	protected void finalize() throws Throwable {
		scheduler.cancel();
		super.finalize();
	}
}

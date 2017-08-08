package common.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CrawlerLogVO implements Serializable{
	private int log_no;
	private int ac;
	private Timestamp date;
	
	public int getLog_no() {
		return log_no;
	}
	public void setLog_no(int log_no) {
		this.log_no = log_no;
	}
	public int getAc() {
		return ac;
	}
	public void setAc(int ac) {
		this.ac = ac;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
}

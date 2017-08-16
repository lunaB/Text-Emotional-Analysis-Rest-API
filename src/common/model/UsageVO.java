package common.model;

import java.io.Serializable;

public class UsageVO implements Serializable{
	private int total;
	private int usage;
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getUsage() {
		return usage;
	}
	public void setUsage(int usage) {
		this.usage = usage;
	}
}

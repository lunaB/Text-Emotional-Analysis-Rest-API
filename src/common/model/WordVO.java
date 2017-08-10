package common.model;

import java.io.Serializable;

public class WordVO implements Serializable{
	private String word;
	private int point;
	private float cnt;
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public float getCnt() {
		return cnt;
	}
	public void setCnt(float cnt) {
		this.cnt = cnt;
	}
}

package test;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		List<String> text = new ArrayList<String>();
		text.add("a");
		text.add("b");
		text.add("c");
		text.add("d");
		text.add("e");
		
		StringBuffer sql = new StringBuffer("SELECT AVG(point) FROM word WHERE word in(");
		sql.append("? ");
		for(int i=0;i<text.size()-1;i++){
			sql.append(",?");
		}
		sql.append(")");
		System.out.println(sql.toString());
		System.out.println(text.get(1));
	}
}

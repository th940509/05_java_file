package step5_02.file;
//2021/04/08 17:08 ~ 17:15

import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제2

public class FileEx04_내정답 {

	public static void main(String[] args) {
		
		// momk/1111/20000
		// megait/2222/30000
		// github/3333/40000
		
		String[] names = {"momk", "megait", "github"};
		String[] pws   = {"1111",   "2222",   "3333"};
		int[]    moneys= { 20000,    30000,    40000};
		
		String fileName = "fileTest02.txt";
		FileWriter fw = null;
		String data = "";
		
		for(int i=0; i<3; i++) {
			data += names[i];
			data += "/";
			data += pws [i];
			data += "/";
			data += Integer.toString(moneys[i]);
			data += "\n";
		}
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {fw.close();} catch (IOException e) {e.printStackTrace();} 
		}
		
	}

}

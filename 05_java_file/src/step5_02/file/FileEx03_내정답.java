package step5_02.file;
//2021/04/08 16:40 ~ 17:07
import java.io.FileWriter;
import java.io.IOException;

//# 파일 저장하기 : 연습문제1


public class FileEx03_내정답 {

	public static void main(String[] args) {
		
		// 김철수/20,이만수/30,이영희/40
		
		String[] names = {"김철수", "이만수", "이영희"};
		int[] ages     = {	   20,     30,     40};
		
		String fileName = "fileTest01.txt";
		FileWriter fw = null;
		String data = "";
		int size = names.length;
		for(int i=0; i<names.length; i++) {
			data += names[i];
			data += "/";
			data += Integer.toString(ages[i]);
			if(i != size -1) {
				data += ",";
			}
		}	
		try {
			fw = new FileWriter(fileName);	
			fw.write(data);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {fw.close();} catch (IOException e) {e.printStackTrace();}
		}
		
		
		
		}
		
	}



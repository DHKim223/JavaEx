package j15;

import java.io.File;
import java.io.IOException;

public class FileEx {
	public static void main(String[] args) throws IOException{
		String path = "c:\\";
		File f = new File(path);
		String files[] = f.list();
		
		for(String file:files) {
			File f1 = new File(path, file);
			
			if(f1.isFile()) {// file
				System.out.println("File : " + file + "(" + f1.length() + ")");
				
			} else { //directory
				System.out.println("Directory : " + file);
			}	
			System.out.println();
		}
	
		// 파일 생성
		File nf = new File("src/j15/a.txt"); 	// 파일생성(c drive) 이 아닌 프로그램내 객체생성(메모리)
		System.out.println(nf.createNewFile());	// IOException 
		
		//파일 이름변경
		File rename = new File("src/j15/b.txt");
		System.out.println(nf.renameTo(rename));
		
		//파일 삭제
		System.out.println(nf.delete());
		System.out.println(rename.delete());
				
	}
}

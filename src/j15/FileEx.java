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
	
		// ���� ����
		File nf = new File("src/j15/a.txt"); 	// ���ϻ���(c drive) �� �ƴ� ���α׷��� ��ü����(�޸�)
		System.out.println(nf.createNewFile());	// IOException 
		
		//���� �̸�����
		File rename = new File("src/j15/b.txt");
		System.out.println(nf.renameTo(rename));
		
		//���� ����
		System.out.println(nf.delete());
		System.out.println(rename.delete());
				
	}
}

package j15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//								입력						출력
//1byte					InputStream			OutputStream
//2byte					Reader					Writer

// Char Stream + file IO + buffer
// b.txt -> b1.txt

public class CharStringEx {
	public static void main(String[] args)  {
		FileReader fr = null;
		FileWriter fw = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		int data = 0;
		
		String msg = null;
		
		try {
			fr= new FileReader("src/j15/b");
			fw = new FileWriter("src/j15/b1");
			br = new BufferedReader(fr);
			bw=new BufferedWriter(fw);
			
//			while ((data = br.read()) != -1) {
//				System.out.print((char) data);
//				bw.write(data);
//			} 
			
			while ((msg = br.readLine()) != null){
				System.out.println(msg);
				bw.write(msg);
			}
			
			bw.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( fr!= null)fr.close();
				if(br!= null)br.close();
				
				if( fw != null) fw.close();
				if ( bw != null) bw.close();
			} catch( IOException e) {
				e.printStackTrace();				
			}
		}
		
	}
}
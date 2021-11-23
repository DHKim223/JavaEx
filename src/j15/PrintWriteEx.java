package j15;
// PrintWriter
// 1byte 2byte 모두 작업 가능
// PrintWriter(OutputStream out)
// PrintWriter(Writer out)

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
	
public class PrintWriteEx{
	public static void main(String[] args) {
		// 1byte
		FileOutputStream fos = null;
		PrintWriter pw1 = null;
	
		// 2byte
		FileWriter fw= null;
		PrintWriter pw2= null;
		
		// output
		PrintWriter pw3 =null;
		
		try {
			fos = new FileOutputStream("src/j15/c1");
			pw1 = new PrintWriter(fos);
			pw1.println(10);
			pw1.println("ABC");
			pw1.println('A');
			
			fw = new FileWriter("src/j15/c2");
			pw2 = new PrintWriter(fw,true);
			pw2.println(10);
			pw2.println("ABC");
			pw2.println('A');
			
			pw3 = new PrintWriter( "src/j15/c3" );
			pw3.println( 30 );
			pw3.println( "ABC" );
			pw3.println( 'C' );
			pw3.flush();
			
		} catch( FileNotFoundException e) {
			e.printStackTrace();
		} catch ( IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if ( fos != null) fos.close();
				if(pw1 != null) pw1.close();
				
				if( fw!= null) fw.close();
				if(pw2 != null) pw2.close();
				
				if(pw3 != null) pw3.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}

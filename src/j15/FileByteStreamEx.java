package j15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

// 스트림					통로
//								ByteSteam			1byte
//								CharStream			2byte

//								입력						출력
// 1byte					InputStream			OutputStream
//	2byte					Reader					Writer

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// 바이트스트림 + 파일입출력 + 버퍼

public class FileByteStreamEx {
	public static void main(String[] args)  {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data =0;	
		
		try {
			fis = new FileInputStream ( "src/j15/a");
			fos = new FileOutputStream("src/j15/a1");
			
			bis = new BufferedInputStream( fis );
			bos = new BufferedOutputStream(fos);
			
			while( ( data = bis.read() ) != -1 ) {
				System.out.print((char)data);
				bos.write(data);							// 메모리에만 써있는상태로    메모리에서 hdd로 내보내는 flush 가 필요
			}	bos.flush();		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// fis.close();  fis 가 null 인 경우가 있어서 이렇게 못쓴다. (nullpointException)
			try {
			if ( fis != null) fis.close();
			if ( fos != null) fos.close(); 				// try문 안에있는 예외만 catch 에서 잡는다....
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

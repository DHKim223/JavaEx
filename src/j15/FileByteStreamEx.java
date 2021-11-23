package j15;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

// ��Ʈ��					���
//								ByteSteam			1byte
//								CharStream			2byte

//								�Է�						���
// 1byte					InputStream			OutputStream
//	2byte					Reader					Writer

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// ����Ʈ��Ʈ�� + ��������� + ����

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
				bos.write(data);							// �޸𸮿��� ���ִ»��·�    �޸𸮿��� hdd�� �������� flush �� �ʿ�
			}	bos.flush();		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch ( IOException e ) {
			e.printStackTrace();
		} finally {
			// fis.close();  fis �� null �� ��찡 �־ �̷��� ������. (nullpointException)
			try {
			if ( fis != null) fis.close();
			if ( fos != null) fos.close(); 				// try�� �ȿ��ִ� ���ܸ� catch ���� ��´�....
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}

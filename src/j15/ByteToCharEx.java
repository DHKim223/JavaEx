package j15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//								1byte				=>			2byte
//입력					InputStream			+				Reader				InputStreamReader
//출력					OutputStream		+				Writer				OutputStreamReader

public class ByteToCharEx {
	
	public String input(String msg) throws IOException {
		System.out.println(msg);
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		//System.in // 키보드 연결 ( 1byte stream..... 키보드받을때 유일한 방법)
		//inputSteramreader // 한글받기위해 2byte
		// BufferedReader //	2byte 받은거 버퍼작업
		return br.readLine();	// 1줄입력받은거 통째로 리턴
	}
	
	public static void main(String[] args) throws IOException{
		ByteToCharEx btc = new ByteToCharEx();
		String id = btc.input("아이디 :" );
		String passwd = btc.input("비밀번호 : ");
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		
		fos = new FileOutputStream("src/j15/d.txt");
		osw = new OutputStreamWriter (fos);
		bw = new BufferedWriter(osw);
		
		bw.write("ID : " );
		bw.write(id);
		bw.newLine();
		
		bw.write("pwd: ");
		bw.write(passwd);
		bw.newLine();
		
		bw.flush();		// write이 끝나면 flush 필수..
		
		if( fos != null) fos.close();				// 항상 null이 아닌지 확인하고 닫아야함.
		if ( osw != null) osw.close();
		if ( bw != null) bw.close();
		
				
	}
}

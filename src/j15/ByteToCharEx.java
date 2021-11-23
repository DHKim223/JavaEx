package j15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//								1byte				=>			2byte
//�Է�					InputStream			+				Reader				InputStreamReader
//���					OutputStream		+				Writer				OutputStreamReader

public class ByteToCharEx {
	
	public String input(String msg) throws IOException {
		System.out.println(msg);
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		//System.in // Ű���� ���� ( 1byte stream..... Ű��������� ������ ���)
		//inputSteramreader // �ѱ۹ޱ����� 2byte
		// BufferedReader //	2byte ������ �����۾�
		return br.readLine();	// 1���Է¹����� ��°�� ����
	}
	
	public static void main(String[] args) throws IOException{
		ByteToCharEx btc = new ByteToCharEx();
		String id = btc.input("���̵� :" );
		String passwd = btc.input("��й�ȣ : ");
		
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
		
		bw.flush();		// write�� ������ flush �ʼ�..
		
		if( fos != null) fos.close();				// �׻� null�� �ƴ��� Ȯ���ϰ� �ݾƾ���.
		if ( osw != null) osw.close();
		if ( bw != null) bw.close();
		
				
	}
}

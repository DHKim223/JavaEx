package j10;
// ����� ���� ����
// ���� �ϳ� �Է� ������ ���
//	2~9 ���̸� �Է�

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class userException extends Exception {
}

public class ExceptionEx2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		try {
			System.out.print("���Է� : ");
			int dan = Integer.parseInt(br.readLine());
			
			if(dan < 2 || dan >9) {
				throw new userException(); // ������ ���ܸ� ����������� ó���ؾ���.
			}
			
			// ������ ���
			for (int i =1;  i<10; i++) {
				System.out.println(dan + "*" + i + "="+dan*i);
			}
			
		} catch(IOException e ) {
			e.printStackTrace();
		}	catch(userException e) {
			System.out.println("2~9 ���̸� �Է��ϼ���");
		}
		
		
		
		
	}
}

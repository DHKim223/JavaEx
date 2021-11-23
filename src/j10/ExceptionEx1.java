package j10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ������ ����¤� ����
public class ExceptionEx1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �Է��� �ޱ����ؼ� ���α׷��� ���ߴ� �ü���� ��������...
		// ����ó���� �Ϻη� ����Ŷ�� �˷���� ���α׷��� ����ȴ�.
		
		int a = 0;
		try {
			System.out.print("���� : ");
			a = Integer.parseInt(br.readLine()); 	
			System.out.println("a : " + (100/a));
		} catch(IOException e) {
			e.printStackTrace();
		}	catch(NumberFormatException e) {
			System.out.println(" ���ڸ� �Է��ϼ��� ! ");
		}	catch(ArithmeticException e) {
			System.out.println(" 0���� ���� �� �����ϴ�.");
		}	catch(Exception e) {			// ��ü���� �ѹ��� ���!
			e.printStackTrace(); 	
		} finally {
			System.out.println("���α׷� ��");
		}
		
		// ������ ��򰡿��� ó���ؾ���
		//System.out.println("a : " + (100/a));				// interrupt
	}
}

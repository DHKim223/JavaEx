package j08;

import java.util.StringTokenizer;

//	���ڿ� �ڸ��� Ŭ����
// ����Ʈ�� ����. ___ �Ű������� ���� ��������!!!

public class StringTokenizerEx {

	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("Hello Java!!!","a",true);	// �Ű������� ���ָ� false // True�� �ָ� delimeter �� ��ūȭ
		System.out.println("Token : " + st.countTokens());	// ��ū �??
		
		while(st.hasMoreTokens()) {
			System.out.println("Token : " + st.nextToken());
		}
		
		System.out.println("Token : " + st.countTokens());	// ������ ��ū �� ����ͼ� ����
				
	}
}

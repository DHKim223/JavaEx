package j07;

//import java.lang.Math; // lang package �� ���� import ���� �ʾƵ� ��.
public class RandomEx {

	public static void main(String[] args) {
//		Math m = new Math();					// private �̶� ����� �� ����. ---- ��ü �����ؼ� ������� ����
		
		// Ŭ���� ����
		// 1. ��ü ���� or ���
		// 2. ����� ��� static
		for (int i = 0 ; i<6 ; i++) {
		//System.out.println( (int) (Math.random( )*100) +1   ); // class.�Լ�()         // 0.0~1.0
		System.out.println( (int) (Math.random( )*45) +1   );   // 1~45 
		}
		
	}	
}

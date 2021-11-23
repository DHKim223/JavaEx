package j08;
// Data Type					Wrapper Class

//���� 								��ü__Method ��밡��!! ex Integer.parseInt("123")

// boolean						Boolean
//	byte								Byte
//	short							Short
//	int								Integer
// long								Long
//	float								Float
// double							Double
// char								Character
//	void								Void

// Wrapper Class �� method�� ��� �� �� �ִ�.
//	�⺻�ڷ����� ����ϸ� ������ ���� Wrapper Class �� ����ؾ� �ϴ� ��찡 ����...

public class WrapperEx {

	public static void main(String[] args) {
		// integer�� Default ����
		
		int a = 10;
		Integer b= new Integer(10); // Deprecated �� �ٰ�.

		System.out.println("a : " + a);
		System.out.println("b : " + b);
		
		System.out.println(Integer.parseInt("123"));
		System.out.println( Integer.toBinaryString(20));		//2����
		System.out.println( Integer.toHexString(15));			//16���� ____ 2������ 4ĭ�� ���� 
		System.out.println( Integer.toOctalString(20));		//8����	 ____ 2������ 3ĭ�� ����
		
		System.out.println(Integer.BYTES );
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		
		// ����ڽ� // ��ڽ�							jdk 1.5���� ���� - �Ϲ��ڷ��� Wrapper Ŭ���� ȣȯ ����
		int c = new Integer(10);					//���� room �� �ּ� ����....
		Integer d = 20;									//�ּ� room �� ���� ����....
		
		// ������ Integer e = new Integer(10);
		//				int e = 10;
		System.out.println("c : " + c);
		System.out.println("d : " + d);
	}
}

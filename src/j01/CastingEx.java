package j01;

//Casting
public class CastingEx {
	public static void main( String[] args ) {
		// �ڵ�����ȯ
		//int a = 3.5; // int �� ������ 4byte,,, 3.5(�Ǽ�)�� 8byte Therefore ����
		double b = 3;
		System.out.println("b : " + b); // 3 ������ 3.0���� �ٲ�� ��.
		
		
		// ��������ȯ
		int a = (int)3.5;
		System.out.println("a : " + a); // int�� ����ȯ�ؼ� .5 ©��.
		
		double c = (int)3.5;
		System.out.println("c : " + c);
		
		String f = "10";
		System.out.println("���ڿ� : " + f );
		
		//String �� ����ȯ ȣȯ �ȵ�.
		}
}
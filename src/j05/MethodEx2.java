package j05;

// �Ű����� �μ� ���� argument parameter       ������
// �� �� �� �� �� ���ϴ� �Լ� ����
public class MethodEx2 {
	//int a =5, b=2;	// �������� / �������( class �ȿ� �ִ� ���� .... �ڹ��� ���������� ������ ���������� �ƴ�) 
	
	public void hap(int a, int b) {			// �Ű����� .. ���� ��������
		//int a =5, b=2;												//��������
		System.out.println("�� : " + (a+b));
	}
	
	public void cha(int a, int b) {
		System.out.println("�� : " + (a-b));
	}
	
	public void gop(int a, int b) {
		System.out.println("�� : " + (a*b));
	}
	
	public void mok(int a, int b) {
		System.out.println("�� : " + ((double)a/b));
	}
	public static void main(String[] args) {
		MethodEx2 me = new MethodEx2();
		me.hap(5, 2 );
		me.cha( 4, 3);
		me.gop( 7, 3);
		me.mok( 7,3);
				
	}

}

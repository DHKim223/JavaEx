package j05;

//overload
//�޼ҵ��� �̸��� �����鼭 �Ű������� �ڷ����� �ٸ��ų� 
//������ �ٸ��ų� ������ �ٸ����
//�ٸ� �޼ҵ�� ����Ѵ�

public class MethodEx3 {

	public void hap(int a, int b) {
		System.out.println("�� : " + (a+b));
	}
	
	public void hap(double a, double b) {
		System.out.println("�� : " + (a+b));
	}
	
	public void hap(int a, int b, int c) {
		System.out.println("�� : " + (a+b+c));
	}
	
	public static void main(String[] args) {
		MethodEx3 me = new MethodEx3();
		me.hap( 5,2);
		me.hap(10, 20);
		
		me.hap(5.5, 2.3);
		me.hap(2, 3,4);
		
	}

}

package j09;

interface Inter1 { // �տ� ������ �ִ��� ������ ��������....
	int a =10;
	public int getA();
}

interface Inter2 {
	int b =20;
	public int getB();
}

interface Inter3 extends Inter1, Inter2{					// ���߻��
	int c =30;
	public int getC();
}

public class InterEx1 implements Inter3{
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public int getC() {
		return c;
	}
	public static void main(String[] args) {
		InterEx1 ie = new InterEx1();
		System.out.println(ie.getA());
		System.out.println(ie.getB());
		System.out.println(ie.getC());
		
	}
}

package j09;

// �������̽� Interface
// interface Ű���带 ����Ѵ�
// ���( final ����) �� �߻� �޼ҵ�θ����� �����ȴ�.
//	final, abstract Ű���带 ���� ������ �ʴ´�.
// interface�� ��ü�� ������ �� ����.
// ��� �� implements(����) Ű���带 ����Ѵ�.
// ��� �� �߻� �޼ҵ�� �������� �����ؾ� �Ѵ�.
// ���� ����� �����ϴ�.

interface Inter1 {
	int a = 10;										// final static �̱⶧���� �ʱ�ȭ �ݵ�� �ؾ��Ѵ�.
	public int getA();								// abstract 					  ������ �� ����.	
}



public class InterEx implements Inter1 {
	public int getA() {
		return a;
	}
	public static void main(String[] args) {
		//Inter1 in = new Inter1();						// ��ü�� ������ �� ����_____�̿ϼ��̱� ������
		InterEx ie = new InterEx();
		System.out.println(ie.getA());
	}
}

package j09;

// �������̽� ���
// ���� implements �ؼ� �߻�޼��带 ������ �ؼ� ���
// ��� ������ Ŭ������ extends �ؼ� �ʿ��� �޼��常 ������ �ؼ� ���

interface Inter4 { 
	int d= 40;
	public int getD();
}

interface Inter5 extends Inter4 { 
	int e= 50;
	public int getE();
}

// �ƴ��� Ŭ���� ____ �������̽��� ��� �����ϴ� Ŭ����
abstract class InterSuper implements Inter5{		// �������� ������ �߻�Ŭ������ �ǰ� ����Ŭ�������� �����ؾ���.
//	public int getD() {
//		return d;
//	}
//	public int getE() {
//		return e;
	
	// ��ý�� �������� ���� __ ��� ������ ���� ������ ���� �ʴ´�.
	public int getD() {
		return d;
	}
	public int getE() {
		return e;
	}
//	}
}

public class InterEx2 extends InterSuper{
	// ��� ������ Ŭ������ �ʿ��� �޼��常 ������
	public static void main(String[] args) {
		public int getD() {
			return d;
		}
		public int getE() {
			return e;
		}
	}
}

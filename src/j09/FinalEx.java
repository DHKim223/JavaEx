package j09;

// Ŭ�������� ���								�ٸ� Ŭ�������� ��ӹ��� �� ����.
//	�޼ҵ忡�� ���								��� ���迡 �ִ� Ŭ�������� ������ �� �� ����.
// �������� ���									������ �ִ� ���� ������ �� ����.

/*final */ class Finalsuper{
	final int a =10; 				//���ȭ.		//�ʱ�ȭ �ؾ� �Ѵ�. final �� ������ �����ڷ� �ʱ�ȭ �� �� ����.
	public final int getA() {
		return a;
	}
 }											// final �� static ���� �����ؾ� �޸� ���� ���� �� �ִ�...,.. ���� �ʿ����,, �ϳ��� ������ ����

public class FinalEx extends Finalsuper {		// final class �� ��ӹ��� �� ����.
	public int getA() { // final method �� ������ �Ұ�!
		return a;
	}
	public static void main(String[] args) {
		Finalsuper fs= new Finalsuper();
		//fs.a  =  20;				// final �� ���������� ����.... ���ο� �� �Ҵ� �Ұ��� ... Therefore ���ȭ!
		// �ڿ���� e, pi .... ���� final �� ���ȭ ���ִ�.
	}
}

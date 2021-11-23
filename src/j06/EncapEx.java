package j06;

// ��Ģ�� Ŭ���� �ϳ��� ������ �ϳ�
// Ŭ���� �տ��� public / default        * ���� �ϳ��� Ŭ������ ������ �����ϴ� ��� main �� public ���� 
// default �� �Ⱦ��°��� default 
// ��� �տ��� public / protected / default / private 
class Encap{										// default ��ǰ / main �޼��� ����
	private int a = 10;
	int b = 20;  // default 
	protected int c = 30;
	public int d = 40;
	
	public int getA() {         // �������� ���� �Լ��� ���� ȣ��
		return a;
	}
}

public class EncapEx {							//public ����
	
	private int aa =1;
	int bb =2;
	protected int cc = 3;
	public int dd =4; 
		
	
	public static void main(String[] args) {
		
		EncapEx ee = new EncapEx();
		System.out.println(" private : " + ee.aa);
		System.out.println(" default  : " + ee.bb);
		System.out.println(" protected  : " + ee.cc);
		System.out.println(" public : " + ee.dd);

		
		
		
		Encap ec = new Encap();
		System.out.println(" private : " + ec.getA());	//private		���� ����� ���� ,,, ��Ӱ� ������� Encap �ȿ����� ��밡��
		System.out.println(" default : " + ec.b);	//default		���� ��Ű���� ������ ���ٰ���
		System.out.println(" default : " + ec.c);	//protected	���� ��Ű�� �̰ų� ��� �޾��� ���
		System.out.println(" default : " + ec.d); // public 		����� ����
	}

}

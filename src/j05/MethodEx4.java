package j05;

// return
public class MethodEx4 {
	// ����� ���� �Լ�
	public int hap (int a, int b){
		// ��ȯ�Ǵ� �ڷ����� ���ش�
		//System.out.println("�� : " + (a+b));
		return a+b;      // ����� / ��ȯ�� 
	}
	
	public static void main(String[] args) { // main �� �ü���� ȣ���Ѵ�.
			// new create new object 
			MethodEx4 me = new MethodEx4();  // ��ü ���� (new. instance)  // heap������ ������ me�� ���� (me�� �����ּ�// . �� ~ �ӿ� ��� ��)
			System.out.println("�� : " + me.hap(5,2)); // ��ü.���(instance.member) or ��������.���
	}

}

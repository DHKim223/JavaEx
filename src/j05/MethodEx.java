package j05;

//Method
//������ ���α׷�
//�ݺ��Ǵ� ������ ��� ó��
//�ݵ�� ȣ���� ������ �ǵ��� �´�
//�μ��� ������ �������
// return ���� ������ void
//return ���� �� �� ���̴�

public class MethodEx {
// method �� ���� / ���� / ȣ�� �ؾ� ����� �� �ִ�.
	// ����Լ� / �޼ҵ�
	public void sub() {									// ���� / ���� 
		System.out.println(" Hello Java !!! ");
	}
	
	public static void main(String[] args) {		//main() method
		MethodEx me = new MethodEx();				// ��ü����
		me.sub();														// ��ü.�޼ҵ�  =  ȣ��
		me.sub();
		me.sub();
		
	}

}

package j02;

//���� �Է�
//���� 90�� �̻��̸� "A����" ���
//���� 80�� �̻��̸� "B����" ���
//���� 70�� �̻��̸� "C����" ���
//���� 60�� �̻��̸� "D����" ���
//���� 60�� �̸��̸� "F����" ���

public class ElseIfEx {
	public static void main(String[] args) {
		
		int a = Integer.parseInt(args[0]); // 98 85 75 65 55 105 -50
		
//		if( a>=90) System.out.println("A����");
//		if( a>=80) System.out.println("B����");
//		if( a>=70) System.out.println("C����");
//		if( a>=60) System.out.println("D����");
//		if( a< 60) System.out.println("F����");

		// ����	// �������� ���� ������ ���ʿ�
		// a >= 0 && a <= 100
		
		// �̷� �ڵ��� ���ʿ��� �۾��� ����Ѵ�.
//		if(a >= 90 && a <= 100) System.out.println("A����");
//		if(a >= 80 && a < 90) System.out.println("B����");
//		if(a >= 70 && a < 80) System.out.println("C����");
//		if(a >= 60 && a < 70) System.out.println("D����");
//		if(a >= 0  && a < 60) System.out.println("F����");
	
		if(a >= 90) System.out.println("A����");
		else if(a >= 80) System.out.println("B����");
		else if(a >= 70) System.out.println("C����");
		else if(a >= 60) System.out.println("D����");
		else System.out.println("F����");
		
	}
}

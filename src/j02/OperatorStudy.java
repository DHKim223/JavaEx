package j02;

// ���� ���� ���� ������ ����� �μ��� �Է¹޴´�
// ���� ����� ���� ��
// ��� 70�� �̻� "�հ�"�� ���
// �̸� "���հ� ���"

// �Է¹��� �� ���� ���� �ϳ��� 0~100 ���� ���̸�
// "�߸��Է� �߽��ϴ�."���

//���׿������� �ذ�
public class OperatorStudy {
	public static void main(String[] args) {
		int kor = Integer.parseInt(args[0]);
		int eng = Integer.parseInt(args[1]);
		int mat = Integer.parseInt(args[2]);
		
		int total = kor + eng + mat;
		double avg = total / 3;
		
		System.out.println(kor > 100 || kor < 0 || eng > 100 || eng < 0 || mat > 100 || mat < 0 
				? "�߸��Է� �߽��ϴ�" : (avg >= 70 ? "�հ�" : "���հ�") );
		

		
//		if(kor > 100 || kor < 0 || eng > 100 || eng < 0 || mat > 100 || mat < 0) System.out.println("�߸��Է� �߽��ϴ�");
//		else System.out.println(avg >= 70 ? "�հ�" : "���հ�");
		
//		if(kor >= 0 && kor <= 100 && eng >= 0 && eng <= 100 && mat >= 0 && mat <= 100) System.out.println(avg >= 70 ? "�հ�" : "���հ�");
//		else System.out.println("�߸��Է� �߽��ϴ�");
		
//		if(kor >= 0 && kor <= 100 && eng >= 0 && eng <= 100 && mat >= 0 && mat <= 100) System.out.println(avg >= 70 ? "�հ�" : "���հ�");
//		else System.out.println("�߸��Է� �߽��ϴ�");
						
	}
}

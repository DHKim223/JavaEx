package j02;

// �����ϳ� �Է�
// 2�� 3�� ������� "����� ���
// �ƴϸ� "�ƴϴ� ���"

public class IfEx1 {
	public static void main(String args[])
	//public static void main(String[] args) 
											{
		
		int a = Integer.parseInt(args[0]); // 6 10 12
		if (a % 2 == 0 && a % 3 == 0) {
			System.out.println("�����");
		} else {
			System.out.println("����� �ƴϴ�");
		}
				
	}
}


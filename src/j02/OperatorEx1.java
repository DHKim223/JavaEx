package j02;

// ����� �μ�
// ������ arguments�� args[] �� �� 
public class OperatorEx1 {
	public static void main( String[] args) {
		// Integer.parseInt �� ���ڸ� ������ �ٲ��ִ� �Լ�
		int a = Integer.parseInt(args[2]); // �迭�ȿ� �� �ֵ��� ���ڿ���.... ���ڰ� �ƴϴ�
		
		// (����) 4�� 2�� ���������� �������� 0�̳�? True �� Even, False�� Odd
		System.out.println(a % 2 == 0 ? "Even" : "Odd");
		System.out.println(a % 2 != 0 ? "Odd" : "Even");
		
		
	}
}

package j03;

// 0~9���� �������� �ϳ� �߻�
// ���ڸ� ���� �Է� �޾Ƽ� �¾����� ������� ��������� �˷� �� �� break�� �������´�
// Ʋ���� ��� �۴�/ũ�ٸ� �˷��ش�.

public class WhileStudy {

	public static void main(String[] args) throws Exception{
		int rand = (int) (Math.random() * 10);  // 0~9 ����
		int cnt = 0;
		
		while(true) {
			cnt++;	
			System.out.print("0~9 �Է� :  ");
			int a = System.in.read()-48;
			System.in.read();
			System.in.read();
		
			if (a>rand) {
				System.out.println("�Է��� ���� �� ŭ");			
			} else if (a<rand){
				System.out.println("�Է��� ���� �� ����");			
			} else {
				System.out.println(cnt + "�� ���� ����!"); 
				break;
			}
		}

	}
}
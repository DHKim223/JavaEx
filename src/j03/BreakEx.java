package j03;

public class BreakEx {

	public static void main(String[] args) {
		int i =0;
		
		//�ݺ����� �������� �ݺ��Ǵ��� �𸦶� ���ѷ��� ���� break�� ���´�
				
		while(true) {							// �� -> ����  |  ���� -> ���� X
			i++;
			
			if (i>10) break;
			
			if(i%2==1)continue; 			// Ȧ���϶� �ƹ��͵� ���� �ʰ� continue
														// continue�� ��������� �����ϰ� �ؼ� ����� �����Ұ�
			System.out.println("i : " + i);
						
		}
		
	}
}

package j04;

/*	1~100������ ������ 2�� �߻��Ͽ� ������ ���ߴ� ����
	10������ Ǯ��

	[1] 25 + 36 = 100
	Ʋ�ȴ�...���� : 61
	[2] 50 + 36 = 86
	�¾Ҵ�
	...
	���� ���� : XX��
	���� : XX��

	������ �� Ǯ���� ���´�.
	'Y' �Ǵ� 'y' �ԷµǸ� �ٽ� 10������ �����Ѵ�.
	'N' �Ǵ� 'n' ���α׷� ����
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

class WhileStudy1 {
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );		//��ü����
				
		char rep;
		int cnt=0;
		
		do {
			for(int i=0; i<10 ; i++) {
			
			int a =(int) (Math.random()*100) + 1;  // 1~100���� ����
			int b =(int) (Math.random()*100) + 1;
			System.out.print("["+ (i+1) +"]\t"+ a + "+" + b + " : ");
			int answer = Integer.parseInt(br.readLine()); // ������ ��ü�� ���� readLine() ��밡��!
			
			if (answer == (a+b)) {
				System.out.println("�¾Ҿ��");
				cnt++;
			}else System.out.println("Ʋ�Ⱦ��\t���� : "+(a+b));
			}
			
			System.out.println("���䰹�� : " + cnt);
			System.out.println("���� : " + (10*cnt));
			System.out.print("�� �ҷ���? (Y/y): ");
			
			rep = (char) System.in.read();						
			System.in.read();
			System.in.read();						
		} while (rep=='y' || rep=='Y');
		System.out.println("���� ��!");
				
	}
}

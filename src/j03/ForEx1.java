package j03;

public class ForEx1 {

	public static void main(String[] args) {
		int cnt = 0, sum=0;
		
		for (int i =1; i<101; i++) {
			
			// 3�� ����� �ƴϸ鼭 Ȧ���� ���� ���
			if (i%3 != 0 && i%2 == 1) {
			System.out.println("i	:"+"\t"+i);
			cnt++;
			sum += i;}
			}
		
		System.out.println("���� :  "  +cnt);
		System.out.println("�հ� : "+ sum);
	}
}

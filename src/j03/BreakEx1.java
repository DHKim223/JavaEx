package j03;

// 1���� ������ ���ٰ� ���ʷ� �հ谡 2000�� �Ѵ� ���� �հ踦 ����ض�


public class BreakEx1 {
	public static void main(String[] args) {
		int i=0, sum=0;
		
		while(true) {
			i++;
			sum += i;
			
			if (sum>=2000) break;
		}
		System.out.println(i);
		System.out.println(sum);
	}

}

package j03;

// 1부터 누적해 가다가 최초로 합계가 2000이 넘는 수와 합계를 출력해라


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

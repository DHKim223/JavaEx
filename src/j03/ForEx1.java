package j03;

public class ForEx1 {

	public static void main(String[] args) {
		int cnt = 0, sum=0;
		
		for (int i =1; i<101; i++) {
			
			// 3의 배수가 아니면서 홀수인 수만 출력
			if (i%3 != 0 && i%2 == 1) {
			System.out.println("i	:"+"\t"+i);
			cnt++;
			sum += i;}
			}
		
		System.out.println("개수 :  "  +cnt);
		System.out.println("합계 : "+ sum);
	}
}

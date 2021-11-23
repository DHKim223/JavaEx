package j04;

public class MultiForEx4 {

	public static void main(String[] args) {
		int sum = 50000;
		int cnt = 0;
		for (int i =0; i <= sum/10000 ; i++) {
			for ( int j=0; j <= sum/5000; j++) {
				for ( int k = 0; k<= sum/1000; k++) {
					if(i*10000 + j*5000 + k*1000 == sum) {
					System.out.println(sum + " : " + "	만원 " + i + "	오천원 : "+j+ "	천원 : " + k );
					cnt++;
				}
			}
		}
   } System.out.println(cnt);
}
}

package j03;

public class WhileEx1 {

	public static void main(String[] args) {
		int i = 0;
		
		int sum=0, sum_even=0, sum_odd=0;
		
		while (i<100) {
			i++;
			
			sum+=i;
			if(i%2 == 0) sum_even+=i;
			else sum_odd +=i;
			
			
			}
			System.out.println("��ü��: " +sum);
			System.out.println("¦����: " +sum_even);
			System.out.println("Ȧ����: " +sum_odd);
	}

}

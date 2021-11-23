package j03;

// 1+2+3+4+...+10 = 55

public class DoWhileEx2 {

	public static void main(String[] args) {
		int i=0;
		int sum = 0;
		
		do {
			i++;
			sum+=i;
			if (i <10) System.out.print(i + "+");	
			else System.out.print(i+"=");							
		}while(i<10);
			System.out.println(sum);
			
			
			
		sum = 0; 
		for (int a = 1; a<11; a++) {
			if (a<10)System.out.print(a + "+");
			else System.out.print(a + "=");
			sum += a;
		}System.out.println(sum);
	}

}

package j09;

public class Test {

	public static void main(String[] args) {
		
			int number[]= {0,0,0};
			number[0] = (int) (Math.random( )*9) +1;
			for (int i=1; i<3; i++) {
				
				number[i] = (int) (Math.random( )*9) +1;
				if(number[i] == number[i-1] || number[0] == number[i]) {
					i--;
				}
			}		
	
			for ( int i = 0; i < number.length ; i ++ ) {				
	 			System.out.print(number[i]);
	 		} 
		
	}
}

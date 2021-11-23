package j06;

// 오버로드 과제
public class MethodStudy {
	
	public void  disp(char symbol, int number) {		
		System.out.print(number +"\t");
		for( int i = 0; i<number; i++) {
			System.out.print(symbol);			
		}System.out.println();
	}
	 
	public void  disp(int number1, int number2, char symbol) {		
		int numb = number1 - number2;
		System.out.print(numb +"\t");
		for( int i = 0; i<numb; i++) {
			System.out.print(symbol);			
		}System.out.println();
	}
	
	public void  disp(char symbol1, char symbol2,  int number) {		
		int cnt = 0;
		System.out.print(number +"\t");
		for( int i = 0; i<number; i++) {
			System.out.print(symbol1);
			cnt++;
			if (cnt==number) break;
			System.out.print(symbol2);
			cnt++;
			if (cnt==number) break;
		}System.out.println();
	}
	
	
//	for ( ~ ) {
//		if (i %2 == 0) System.out.println(a);
//		else System.out.println(b);
//	}
	
	public static void main(String[] args) {
		MethodStudy ms = new MethodStudy();		
		ms.disp('@' ,3);			//3 	@@@
		ms.disp('#' , 5);			//5	##### 			
		ms.disp( '%', 7);			//7	%%%%%%%
		ms.disp( 9, 5, '&');		//4 &&&&
		ms.disp('@' , '#' , 7 ); //7	@#@#@#@
		
	}
}

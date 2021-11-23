package j05;

public class MethodEx1 {
	// Global variable

	public void  add() {
		int sum =0;							// local variable(지역변수) -- stack -- 속한 영역이 끝나면 사라진다.
		for (int i=1; i<11; i++) {			
			sum += i;					
		} System.out.println(sum);
	}
	
	public void mult() {
		int sum=1;
		for (int i=1; i<11; i++) {
			sum *=i;
		} System.out.println(sum);
	}
		
	public static void main(String[] args) {
		MethodEx1 calc = new MethodEx1();	
		System.out.print("합 : " ); // 55
		calc.add();
		System.out.print("곱 : "); // 3628800
		calc.mult();
		
		
	}

}

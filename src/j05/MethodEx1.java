package j05;

public class MethodEx1 {
	// Global variable

	public void  add() {
		int sum =0;							// local variable(��������) -- stack -- ���� ������ ������ �������.
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
		System.out.print("�� : " ); // 55
		calc.add();
		System.out.print("�� : "); // 3628800
		calc.mult();
		
		
	}

}

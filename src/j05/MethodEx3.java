package j05;

//overload
//메소드의 이름은 같으면서 매개변수의 자료형이 다르거나 
//갯수가 다르거나 순서가 다른경우
//다른 메소드로 취급한다

public class MethodEx3 {

	public void hap(int a, int b) {
		System.out.println("합 : " + (a+b));
	}
	
	public void hap(double a, double b) {
		System.out.println("합 : " + (a+b));
	}
	
	public void hap(int a, int b, int c) {
		System.out.println("합 : " + (a+b+c));
	}
	
	public static void main(String[] args) {
		MethodEx3 me = new MethodEx3();
		me.hap( 5,2);
		me.hap(10, 20);
		
		me.hap(5.5, 2.3);
		me.hap(2, 3,4);
		
	}

}

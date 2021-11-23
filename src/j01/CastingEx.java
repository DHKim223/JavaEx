package j01;

//Casting
public class CastingEx {
	public static void main( String[] args ) {
		// 자동형변환
		//int a = 3.5; // int 는 정수는 4byte,,, 3.5(실수)는 8byte Therefore 에러
		double b = 3;
		System.out.println("b : " + b); // 3 이지만 3.0으로 바뀌어 들어감.
		
		
		// 강제형변환
		int a = (int)3.5;
		System.out.println("a : " + a); // int로 형변환해서 .5 짤림.
		
		double c = (int)3.5;
		System.out.println("c : " + c);
		
		String f = "10";
		System.out.println("문자열 : " + f );
		
		//String 은 형변환 호환 안됨.
		}
}
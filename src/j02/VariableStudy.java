package j02;

public class VariableStudy {
	public static void main(String[] args) {
		int kor = 81, eng =75, mat=91;
		
		//국어 : 81점
		//영어 : 75점
		//수학 : 91점
		//총점 : ___점
		//평균 : ___._점
		
		int total = kor + eng + mat;
		
		//double avg = (double)total / 3;
		//double avg = total / 3.0;
		double avg = total / (double)3;
		
		System.out.println("국어 :"+ "\t" + kor +"점");
		System.out.println("영어 :" + "\t" + eng +"점");
		System.out.println("수학 :" + "\t"  + mat +"점");
		System.out.println("총점 :" + "\t"  + total +"점");
		System.out.println("국어 :" + "\t"  + avg +"점");
		
		System.out.printf("평균 : " + "\t"+ "%.2f점" , avg);  // 변환문자 %d , %f, %c, %s
		// 같은 코드 중복해서 쓰지 않는것이 좋다
		// 프로그램은 수정하기 쉽게!!!
		// 좋은 가독성!!!
	}
}

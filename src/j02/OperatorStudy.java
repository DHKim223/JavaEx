package j02;

// 국어 영어 수학 점수를 명령줄 인수로 입력받는다
// 총점 평균을 구한 후
// 평균 70점 이상 "합격"을 출력
// 미만 "불합격 출력"

// 입력받은 세 과목 점수 하나라도 0~100 범위 밖이면
// "잘못입력 했습니다."출력

//삼항연산으로 해결
public class OperatorStudy {
	public static void main(String[] args) {
		int kor = Integer.parseInt(args[0]);
		int eng = Integer.parseInt(args[1]);
		int mat = Integer.parseInt(args[2]);
		
		int total = kor + eng + mat;
		double avg = total / 3;
		
		System.out.println(kor > 100 || kor < 0 || eng > 100 || eng < 0 || mat > 100 || mat < 0 
				? "잘못입력 했습니다" : (avg >= 70 ? "합격" : "불합격") );
		

		
//		if(kor > 100 || kor < 0 || eng > 100 || eng < 0 || mat > 100 || mat < 0) System.out.println("잘못입력 했습니다");
//		else System.out.println(avg >= 70 ? "합격" : "불합격");
		
//		if(kor >= 0 && kor <= 100 && eng >= 0 && eng <= 100 && mat >= 0 && mat <= 100) System.out.println(avg >= 70 ? "합격" : "불합격");
//		else System.out.println("잘못입력 했습니다");
		
//		if(kor >= 0 && kor <= 100 && eng >= 0 && eng <= 100 && mat >= 0 && mat <= 100) System.out.println(avg >= 70 ? "합격" : "불합격");
//		else System.out.println("잘못입력 했습니다");
						
	}
}

package j03;

// 90점 이상이면 A학점
//80점 이상이면 B학점
//70점 이상이면 C학점
//60점 이상이면 D학점
//50점 미만이면 F학점

//0~100 사이가 아니면 잘못입력 출력
public class SwitchEx1 {
	public static void main( String[] args) {
		int score = Integer.parseInt(args[5]); // 110 95 85 75 65 55 -20
		char grade;
		
		if (score >=0 && score <=100) {
			if (score>=90) grade = 'A';
			else if (score >=80) grade = 'B';
			else if (score >= 70) grade = 'C';
			else if (score >= 60) grade = 'D'; 
			else grade = 'F';
		
			switch (grade) {
			case 'A':System.out.println("A학점"); break;
			case 'B':System.out.println("B학점"); break;
			case 'C':System.out.println("C학점");	break;
			case 'D':System.out.println("D학점");	break;
			default: System.out.println("F학점"); 
			}
		} else System.out.println("잘못된 인풋");
		
//		switch (score / 10) {
//		case 10:
//		case 9 :
//		case 8 :
//		case 7 :
//		case 6 :
//		default :
		}
		
		
	}


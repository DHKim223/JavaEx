package j03;

// 90�� �̻��̸� A����
//80�� �̻��̸� B����
//70�� �̻��̸� C����
//60�� �̻��̸� D����
//50�� �̸��̸� F����

//0~100 ���̰� �ƴϸ� �߸��Է� ���
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
			case 'A':System.out.println("A����"); break;
			case 'B':System.out.println("B����"); break;
			case 'C':System.out.println("C����");	break;
			case 'D':System.out.println("D����");	break;
			default: System.out.println("F����"); 
			}
		} else System.out.println("�߸��� ��ǲ");
		
//		switch (score / 10) {
//		case 10:
//		case 9 :
//		case 8 :
//		case 7 :
//		case 6 :
//		default :
		}
		
		
	}


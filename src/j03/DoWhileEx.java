package j03;

public class DoWhileEx {	
	public static void main(String[] args) {
		int i = 0;
		do {
			System.out.println("i = " + i);
			i++;
		}while(i<3);  // 조건이 거짓이더라도 한 번은 무조건 실행 한다.
	}

}

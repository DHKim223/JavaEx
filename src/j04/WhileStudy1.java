package j04;

/*	1~100사이의 난수를 2개 발생하여 덧셈을 맞추는 게임
	10문제만 풀기

	[1] 25 + 36 = 100
	틀렸다...정답 : 61
	[2] 50 + 36 = 86
	맞았다
	...
	정답 개수 : XX개
	점수 : XX점

	문제를 더 풀지를 묻는다.
	'Y' 또는 'y' 입력되면 다시 10문제를 출제한다.
	'N' 또는 'n' 프로그램 종료
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

class WhileStudy1 {
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );		//객체생성
				
		char rep;
		int cnt=0;
		
		do {
			for(int i=0; i<10 ; i++) {
			
			int a =(int) (Math.random()*100) + 1;  // 1~100까지 랜덤
			int b =(int) (Math.random()*100) + 1;
			System.out.print("["+ (i+1) +"]\t"+ a + "+" + b + " : ");
			int answer = Integer.parseInt(br.readLine()); // 생성한 객체를 통해 readLine() 사용가능!
			
			if (answer == (a+b)) {
				System.out.println("맞았어요");
				cnt++;
			}else System.out.println("틀렸어요\t정답 : "+(a+b));
			}
			
			System.out.println("정답갯수 : " + cnt);
			System.out.println("점수 : " + (10*cnt));
			System.out.print("더 할래요? (Y/y): ");
			
			rep = (char) System.in.read();						
			System.in.read();
			System.in.read();						
		} while (rep=='y' || rep=='Y');
		System.out.println("게임 끝!");
				
	}
}

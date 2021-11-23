package j09;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 숫자 야구 게임

// 컴퓨터가 임의의 숫자를 발생 (3자리)
// 숫자를 맞춰라
// 숫자도맞고 자리까지 맞는게 스트라이크.
// 숫자는 맞지만 자리가 다르면 볼.
// 다 맞으면 종료.

// 메서드로  입력/연산/출력 따로...


class Baseball {
	// 숫자발생
	public int[] randnumb() {
		int number[] = {0,0,0};
		for (int i=0; i<3; i++) {			
			number[i] = (int) (Math.random( )*9) +1;
			for (int j=0; j<i; j++)
			{
				if ( number[i] == number[j])	i--;			
			}
		}	System.out.println("컴퓨터가 숫자를 발생하였습니다!");
		return number;
	}
	
	// 사용자 입력
	public int input() throws Exception{
		int guess;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력 : ");
		guess = Integer.parseInt( br.readLine());		
		return guess;
	}
	
	// 연산
	public boolean compare(int guess, int number[]) {
		int convert[] = {0,0,0};
		
		int scnt=0;
		int bcnt=0;
		
		convert[0] = guess  / 100;
		convert[1] = (guess - convert[0]*100)/10;
		convert[2] = guess % 10;
		
		for( int i=0; i<3; i++) {
			for( int j=0; j<3; j++) {
				if (i==j) {
					if (number[i] == convert[j]) scnt ++;
				} else {
					if ( number[i] == convert[j]) bcnt ++;
				}
			}				 
		}
		System.out.print("Strike : " + scnt + "\t");
		System.out.println("Ball : " + bcnt);
		
		if(scnt ==3) { return true;}
		else {return false;}
	}						

}

public class BaseballEx {

	public static void main(String[] args) throws Exception {
		Baseball bb = new Baseball();		
		System.out.println("맞추어 보세요!");
		int m[] = bb.randnumb();		
		
		while(true) {				
		int guess = bb.input();		
		if( bb.compare(guess,m) == true) {
			System.out.println("정답입니다!");
			break;
			}
		}
		
	}
}

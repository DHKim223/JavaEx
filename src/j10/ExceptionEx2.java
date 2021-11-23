package j10;
// 사용자 정의 예외
// 정수 하나 입력 구구단 출력
//	2~9 사이만 입력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class userException extends Exception {
}

public class ExceptionEx2 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		try {
			System.out.print("단입력 : ");
			int dan = Integer.parseInt(br.readLine());
			
			if(dan < 2 || dan >9) {
				throw new userException(); // 강제로 예외를 방생시켰으니 처리해야함.
			}
			
			// 구구단 출력
			for (int i =1;  i<10; i++) {
				System.out.println(dan + "*" + i + "="+dan*i);
			}
			
		} catch(IOException e ) {
			e.printStackTrace();
		}	catch(userException e) {
			System.out.println("2~9 사이만 입력하세요");
		}
		
		
		
		
	}
}

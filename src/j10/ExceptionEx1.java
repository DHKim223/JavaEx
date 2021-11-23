package j10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 에러가 생기는ㅁ 예외
public class ExceptionEx1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력을 받기위해서 프로그램을 멈추니 운영체제가 에러를냄...
		// 예외처리로 일부러 멈춘거라고 알려줘야 프로그램이 진행된다.
		
		int a = 0;
		try {
			System.out.print("정수 : ");
			a = Integer.parseInt(br.readLine()); 	
			System.out.println("a : " + (100/a));
		} catch(IOException e) {
			e.printStackTrace();
		}	catch(NumberFormatException e) {
			System.out.println(" 숫자만 입력하세요 ! ");
		}	catch(ArithmeticException e) {
			System.out.println(" 0으로 나눌 수 없습니다.");
		}	catch(Exception e) {			// 전체예외 한번에 잡기!
			e.printStackTrace(); 	
		} finally {
			System.out.println("프로그램 끝");
		}
		
		// 던지면 어딘가에서 처리해야함
		//System.out.println("a : " + (100/a));				// interrupt
	}
}

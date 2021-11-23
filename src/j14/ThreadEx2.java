package j14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 쓰레드 동기화
public class ThreadEx2 implements Runnable {
	private static int money = 100000;			// 잔액
	private int won;
	
	public synchronized void run() {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		while( true ) {				
			if( ThreadEx2.money > 0 ) {
				try {
					System.out.print( Thread.currentThread().getName() + " 찾을 금액 : " );
					won = Integer.parseInt( br.readLine() );
				} catch( IOException e ) {
					e.printStackTrace();
				}
				
				ThreadEx2.money -= won;
				System.out.println( Thread.currentThread().getName() + won + " 원을 인출했습니다." );
				System.out.println( "잔액 : " + ThreadEx2.money );
			} else {
				System.out.println( "잔액이 없습니다." );
				break;
			}
		}		
	}	
	public static void main(String[] args) {
		ThreadEx2 te = new ThreadEx2();
		Thread father = new Thread( te, "아빠" );
		Thread mom = new Thread( te, "엄마" );
		Thread son = new Thread( te, "아들" );
		father.start();
		mom.start();
		son.start();		
	}
}
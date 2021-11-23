package j14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// ������ ����ȭ
public class ThreadEx2 implements Runnable {
	private static int money = 100000;			// �ܾ�
	private int won;
	
	public synchronized void run() {
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		while( true ) {				
			if( ThreadEx2.money > 0 ) {
				try {
					System.out.print( Thread.currentThread().getName() + " ã�� �ݾ� : " );
					won = Integer.parseInt( br.readLine() );
				} catch( IOException e ) {
					e.printStackTrace();
				}
				
				ThreadEx2.money -= won;
				System.out.println( Thread.currentThread().getName() + won + " ���� �����߽��ϴ�." );
				System.out.println( "�ܾ� : " + ThreadEx2.money );
			} else {
				System.out.println( "�ܾ��� �����ϴ�." );
				break;
			}
		}		
	}	
	public static void main(String[] args) {
		ThreadEx2 te = new ThreadEx2();
		Thread father = new Thread( te, "�ƺ�" );
		Thread mom = new Thread( te, "����" );
		Thread son = new Thread( te, "�Ƶ�" );
		father.start();
		mom.start();
		son.start();		
	}
}
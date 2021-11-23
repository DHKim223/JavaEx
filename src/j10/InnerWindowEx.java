package j10;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerWindowEx extends Frame {
	public InnerWindowEx() {
		setLocation(800,500);
		setSize(200,300);
		setVisible(true);
		
		// WindowAdapter 는 추상클래스라 객체생성이 안됨..... 상속받자니 frame 때문에 다중상속이라 불기.. 그래서
		
//		WindowAdapter wa = new WindowAdapter() {
//			// 필요한것만 재정의!!!
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		};
//		
//		addWindowListener(wa);
		
		// 위에꺼 한방에 만들기
		
		addWindowListener(						// 감지기
			new WindowAdapter() {
				public void windowClosing ( WindowEvent e) {
					System.exit(0);
				}
			}
		);
	}
	
	
	public static void main(String[] args) {
		new InnerWindowEx();
		
	}
}
// 윈도우의 가장 기본형식!!
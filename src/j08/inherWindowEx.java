package j08;

import java.awt.Frame;

// GUI				윈도우					 AWT / Swing
// TUI				콘솔							

 
//2. 상속 ___ inherWindowEx 가 Frame 의 자식 클래스로 들어간다. (1)
public class inherWindowEx extends Frame {

	public inherWindowEx() {	// 생성자의 용도 (1. 객체초기화 ).... 2. 객체 생성 시 1회만 실행될 작업. 
		setSize (300, 200);			// 그래서 생성자가 뚱뚱해진다.
		setVisible(true);
	} 	// 하지만 생성자를 호출하지 않았기 때문에 아무것도 안된다... 생성자를 호출하기위해서 객체생성한다. (3)
	
	public static void main(String[] args) {
		//1. 객체생성
//		Frame f = new Frame ();
//		f.setSize( 300, 200 );			// 윈도우 띄우는데 필수
//		f.setVisible(true);														
		
//		setSize	(300,200);		// non- static 이라 오류가 난다. 그래서 static 인 main 에서 호출이 안된다. (2)
//		setVisible(True);			// 자동호출 되는 메소드 __ 생성자 를 사용하면 굳!
		
		new inherWindowEx(); // 1회용 객체 생성!!! (4).. 한번만 실행하면 끝이기 때문에 이름이 필요없다.
	}
}

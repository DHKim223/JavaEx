package j14;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;

public class ImageEx1 extends JFrame{
	Toolkit tk;
	Image img;
	URL url;
	
	public ImageEx1() {
		try {
			tk = getToolkit();
			url = new URL("https://obj-sg.thewiki.kr/data/eba6aceba994ed82a4eba5b4ec95842e6a7067.jpg");
			img = tk.getImage(url);
		
			MediaTracker mt = new MediaTracker(this);
			System.out.println("이미지 로딩중.....");
			mt.waitForAll();
		
			if ( mt.isErrorAny()) {
				System.out.println("이미지 로딩 실패");
				System.exit(1); // 문제가 있을땐 1번,, 정상종료는 0,,,
			}
			System.out.println("이미지 로딩 성공");
		
			}catch (MalformedURLException e) {
				e.printStackTrace();
			}catch ( InterruptedException e ) {
				e.printStackTrace();
			}
		
		setBounds(600,200,400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	public void paint ( Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		g2.drawImage(img, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new ImageEx1();
		
	}
}

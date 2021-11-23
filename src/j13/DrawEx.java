package j13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

// paint event   <==== 윈도우를 그려야할 때 발생
public class DrawEx extends JFrame{
	public DrawEx() {
		setBounds(650,200,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void paint ( Graphics g) {		// paint event handler (재정의)
		Graphics2D g2 = (Graphics2D)g;
		super.paint( g2 );
		g2.setColor(Color.red);
		g2.drawLine(0, 31 , 300 , 31);
		g2.drawRect(10,50,50,50);
		g2.fillRect(10,110,50,50);
		g2.drawOval(70, 50, 50, 50);
		g2.fillOval(70, 110, 50, 50);
		
	}
	
	public static void main(String[] args) {
		new DrawEx();
	}
}

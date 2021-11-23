package j14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
// 마우스 찍고 움직일때 그림그리기
public class DrawMouseEx extends JFrame {
	
	Graphics2D g;
	int sx, sy, ex, ey;
	
	public DrawMouseEx() {
		setBounds(600,150,300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel p = new Panel();
		p.setBackground( Color.gray);
		add ( p ) ;
		g = (Graphics2D)p.getGraphics();
		g.setColor(Color.white);
		
		Font f = new Font(Font.SERIF, Font.BOLD, 20);
		g.setFont(f);
		
		p.addMouseListener(
				new MouseAdapter() {
					public void mousePressed(MouseEvent e) {
						sx = e.getX();
						sy = e.getY();
					}			
					public void mouseExited( MouseEvent e) {
						Rectangle r = p.getBounds();
						g.clearRect ( 0,0,r.width,r.height);
					}
				}
		);
		
		p.addMouseMotionListener(
			new MouseMotionAdapter() {
				public void mouseDragged(MouseEvent e) {
					ex = e.getX();
					ey = e.getY();
					g.drawLine(sx, sy, ex, ey);
					sx = ex;
					sy = ey;
				}
			}
		);
		
	}
	
	
	public static void main(String[] args) {
		new DrawMouseEx();
		
	}
}

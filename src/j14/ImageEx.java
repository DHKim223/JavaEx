package j14;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class ImageEx extends JFrame {
	Toolkit tk;
	Image img;
	int x = 10 , y =10 ;
	
	public ImageEx() {
		tk = getToolkit();
		img = tk.getImage("src\\j14\\wsulogo.png");
		
		
		setBounds(600,150,200,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		addKeyListener(
			new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch( e.getKeyCode() ) {
					case KeyEvent.VK_UP :
						y -= 5;
						break;
					case KeyEvent.VK_DOWN :
						y += 5;
						break;
					case KeyEvent.VK_LEFT :
						x -= 5;
						break;
					case KeyEvent.VK_RIGHT :
						x += 5;
						break;
					}repaint();
				}
			}				
		);
		
	}
	
	public void paint (Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paint(g2);
		g2.drawImage(img, x,  y, 50, 50, this);
	}
	
	public static void main(String[] args) {
		new ImageEx();
		
		
	}
}

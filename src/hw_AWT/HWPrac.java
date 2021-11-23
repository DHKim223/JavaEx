package hw_AWT;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HWPrac extends JFrame{
	
	private JTextArea ta;
	
	public HWPrac() {
		
		ta = new JTextArea();
		ta.setEditable(false);
		
		setTitle("°è»ê±â");
		setBounds( 650, 150, 200, 300 );
		setVisible( true );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new HWPrac();
		
	}
}

package j13;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GridLayoutEx extends Frame {
		private JPanel p, north;
		private JTextField tf;
		private JTextArea ta;

		public GridLayoutEx() {
		
		
		p =new JPanel(); // FlowLayout => GridLayout
		p.setLayout ( new GridLayout(3,0));		 // 행우선,,,, 사실 열의 갯수는 의미없다
		
		Button bt1 = new Button ("1");
		Button bt2 = new Button ("2");
		Button bt3 = new Button ("3");
		Button bt4 = new Button ("4");
		Button bt5 = new Button ("1");
		Button bt6 = new Button ("2");
		Button bt7 = new Button ("3");
		Button bt8 = new Button ("4");
		

		p.add(bt1);
		p.add(bt2);
		p.add(bt3);
		p.add(bt4);
		p.add(bt5);
		p.add(bt6);
		p.add(bt7);
		p.add(bt8);
	
		
		add(p);
		
		
		north = new JPanel();
	
		tf = new JTextField();
		north.setLayout( new BorderLayout());
		north.add(tf,"Center");
		
		add(north,"North");
		
		setBounds( 650, 150, 200, 300 );
		setVisible( true );
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					System.exit( 0 );
				}
			}				
		);
	}
	public static void main(String[] args) {
		new GridLayoutEx();
	}
}
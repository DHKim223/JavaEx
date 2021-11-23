package j11;

import java.awt.Color;

// Container

import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTEx extends Frame {
	public AWTEx() {
		setLocation(650, 400); // Frame �� setLocation.... 
		setSize(300, 400);
		setVisible(true);
		
		// Panel
		Panel p1 = new Panel();
		Panel p2 = new Panel();
		Panel p3 = new Panel();
		Panel p4 = new Panel();
		Panel p5 = new Panel();
		
		//	LayoutManager 			��ġ������
		//	BorderLayout				Frame �⺻  Layout
		// FlowLayout					Panel �⺻ Layout
		// GridLayout
		//	 CardLayout
		
		p1.setBackground(Color.red);
		p2.setBackground(Color.blue);
		p3.setBackground(Color.green);
		p4.setBackground(Color.MAGENTA);
		p5.setBackground(Color.CYAN);


		
		add(p1,"North");						// BorderLayout ��ġ�� �������� ������ center
		add(p2,"South");
		add(p3,"East");
		add(p4,"West");
		add(p5, "Center");
		
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}
		);
	}
	
	public static void main(String[] args) {
		new AWTEx();
		
	}
}

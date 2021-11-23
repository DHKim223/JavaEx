package j09;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class InterWindowEx extends WindowAdapter {

	public void windowClosing ( WindowEvent e) {
		System.exit(0);
	}
	public static void main (String [] args) {
		Frame f = new Frame();
		f.setSize(200,300);
		f.setVisible(true);
		f.addWindowListener(new InterWindowEx());
		
	}
}
// 	// 流立 备泅窍绰 版快
//public class InterWindowEx extends Frame implements WindowListener{
//	
//	public void windowOpened( WindowEvent e) {}
//	public void windowActivated( WindowEvent e) {}
//	public void windowDeactivated ( WindowEvent e) {}
//	public void windowClosing( WindowEvent e) {
//		System.exit(0);
//	}
//	public void windowClosed ( WindowEvent e) {}
//	public void windowIconified (WindowEvent e ) {}
//	public void windowDeiconified( WindowEvent e) {}
//
//	
//	public InterWindowEx() {
//		setSize(200,300);
//		setVisible(true);
//		addWindowListener(this);
//	}
//	
//	public static void main(String[] args) {
//		new InterWindowEx();
//		
//	}
//}

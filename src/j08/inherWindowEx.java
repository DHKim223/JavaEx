package j08;

import java.awt.Frame;

// GUI				������					 AWT / Swing
// TUI				�ܼ�							

 
//2. ��� ___ inherWindowEx �� Frame �� �ڽ� Ŭ������ ����. (1)
public class inherWindowEx extends Frame {

	public inherWindowEx() {	// �������� �뵵 (1. ��ü�ʱ�ȭ ).... 2. ��ü ���� �� 1ȸ�� ����� �۾�. 
		setSize (300, 200);			// �׷��� �����ڰ� �׶�������.
		setVisible(true);
	} 	// ������ �����ڸ� ȣ������ �ʾұ� ������ �ƹ��͵� �ȵȴ�... �����ڸ� ȣ���ϱ����ؼ� ��ü�����Ѵ�. (3)
	
	public static void main(String[] args) {
		//1. ��ü����
//		Frame f = new Frame ();
//		f.setSize( 300, 200 );			// ������ ���µ� �ʼ�
//		f.setVisible(true);														
		
//		setSize	(300,200);		// non- static �̶� ������ ����. �׷��� static �� main ���� ȣ���� �ȵȴ�. (2)
//		setVisible(True);			// �ڵ�ȣ�� �Ǵ� �޼ҵ� __ ������ �� ����ϸ� ��!
		
		new inherWindowEx(); // 1ȸ�� ��ü ����!!! (4).. �ѹ��� �����ϸ� ���̱� ������ �̸��� �ʿ����.
	}
}

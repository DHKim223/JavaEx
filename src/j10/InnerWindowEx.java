package j10;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerWindowEx extends Frame {
	public InnerWindowEx() {
		setLocation(800,500);
		setSize(200,300);
		setVisible(true);
		
		// WindowAdapter �� �߻�Ŭ������ ��ü������ �ȵ�..... ��ӹ��ڴ� frame ������ ���߻���̶� �ұ�.. �׷���
		
//		WindowAdapter wa = new WindowAdapter() {
//			// �ʿ��Ѱ͸� ������!!!
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		};
//		
//		addWindowListener(wa);
		
		// ������ �ѹ濡 �����
		
		addWindowListener(						// ������
			new WindowAdapter() {
				public void windowClosing ( WindowEvent e) {
					System.exit(0);
				}
			}
		);
	}
	
	
	public static void main(String[] args) {
		new InnerWindowEx();
		
	}
}
// �������� ���� �⺻����!!
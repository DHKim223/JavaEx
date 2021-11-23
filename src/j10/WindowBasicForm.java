package j10;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowBasicForm extends Frame {
	public WindowBasicForm() {
		setLocation(800,500);
		setSize(200,300);
		setVisible(true);
		
		// WindowAdapter �� �߻�Ŭ������ ��ü������ �ȵ�..... ��ӹ��ڴ� frame ������ ���߻���̶� �ұ�.. �׷���
		
		addWindowListener(
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

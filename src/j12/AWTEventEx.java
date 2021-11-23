package j12;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

/*	�̺�Ʈ ó�� 
�̺�Ʈ �ҽ�(Event Source) 			�̺�Ʈ�� �߻��Ǵ� ������Ʈ
�̺�Ʈ ������(Event Listener)		�̺�Ʈ�� �߻��ϴ����� �˻�.
													�̺�Ʈ�� ó���� �� �ֵ��� �ڵ鷯�� ȣ��
�̺�Ʈ �ڵ鷯(Event Handler)		�̺�Ʈ�� ó���ϴ¸޼���

ActionEvent				Button List MenuItem ���� Component�� �����ų� ������ �Ǿ��� ��
AdjustmentEvent		Scrollbar �� ���� ���� ������ ������Ʈ���� ������ �Ͼ ��
ComponentEvent		Component�� ����̳� ũ�Ⱑ �̵� ��ȭ�� ��
ItemEvent				List Choice Checkbox ���� Component�� �����׸��� ���õ� ��
TextEvent					TextField TextArea ���� ���� �Էµǰų� ������ ��
ContainerEvent		Container�� Component�� �߰��ǰų� ���ŵ� ��
FocusEvent				Component�� ������ ���� ��
PaintEvent				Component�� �׷����� �� ��
WindowEvent			Window�� Ȱ��ȭ�ǰų� ��Ȱ��ȭ �� �� �ּ� �ִ� ���� �� ��
KeyEvent					Ű����� ���� �Է��� �� ��															****
MouseEvent			���콺�� �������ų� ������ �� Ŀ���� �����ų� ���� ��					****
*/

public class AWTEventEx extends Frame implements ActionListener, ItemListener, TextListener{

	Panel North, South, Center;
	Button ok, cancel, exit;
	Checkbox cb1,cb2,cb3;
	TextArea ta;
	
	public AWTEventEx() {
		// �ϴ�
		South = new Panel();
		South.setBackground(new Color ( 50, 50 ,50));
		ok = new Button("Ȯ��");
		cancel = new Button("���");
		exit = new Button("����");
		
		ok.setBackground(new Color ( 100,100,100));
		cancel.setBackground(new Color ( 100,100,100));
		exit.setBackground(new Color ( 100,100,100));
		South.setForeground(Color.white);
		South.setFont( new Font( Font.SERIF, Font.BOLD, 15 ) );
		
		South.add(ok);
		South.add(cancel);
		South.add(exit);
		
		add(South,"South");
	
		
		// ���
		North = new Panel();
		North.setBackground(new Color ( 50,50 ,50));
		cb1 = new Checkbox("����");
		cb2 = new Checkbox("���");
		cb3 = new Checkbox("����");
		North.setForeground(Color.white);
		North.setFont( new Font( Font.SERIF, Font.BOLD, 15 ) );
		
		North.add(cb1);
		North.add(cb2);
		North.add(cb3);

		add(North,"North");
		
		// �ߴ�____  ��¿����� ����Ұ�.
		Center = new Panel();
		ta = new TextArea("",14,33,TextArea.SCROLLBARS_NONE);
		ta.setBackground(new Color(230,230,230));
		ta.setForeground(Color.black);
		ta.setFont(new Font (Font.SERIF, Font.BOLD, 15));
		ta.setEditable(false);
		
		Center.add(ta,"Center");	
		
		add(Center,"Center");
		
		// Window Event
		this.addWindowListener(
				new WindowAdapter() {		 
					public void windowClosing( WindowEvent e){
						System.exit(0);
					}
					public void windowIconified(WindowEvent e) {
						ta.append("������ȭ �ƴ�.\n");
					}
					public void windowDeiconified(WindowEvent e) { 
						ta.append("������ȭ �ƴ�.\n");
					}
				}
		);
				
		setTitle("�̺�Ʈ");
		setBounds(650,150,300,390);
		setVisible(true);
		
		// Action Event Listener,,,,,,,,, ok / cancel / exit �� �����⸦ ���̱�
		ok.addActionListener(this);// this.... Handler �� ������ ��ü... ��! => this
		cancel.addActionListener(this);
		exit.addActionListener(this);
		
		// Item Event Listener
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		
		// Text Event Listener
		cancel.setEnabled(false);
		ta.addTextListener(this);
		
		// Key Event Listener
		ta.requestFocus();	
		ta.addKeyListener(										//Focus �� �ִ� ��ġ���� �ԷµǴ� ������ �ν��Ѵ�..
			new KeyAdapter() {									// ���ϸ��� ���� ��ư�� 'Ȯ��'��ư�̶� ��Ŀ���� Ȯ�ι�ư�� �ִ�
				Rectangle r = getBounds(); // ���� �������� ��ġ�� �����Ͷ�..
				public void keyPressed(KeyEvent e) {
					switch( e.getKeyCode() ) {
						case KeyEvent.VK_LEFT:
							ta.append("��������\n");
							setLocation(r.x -=5 , r.y);
							break;
						case KeyEvent.VK_RIGHT:
							ta.append("����������\n");
							setLocation(r.x +=5 , r.y);
							break;
						case KeyEvent.VK_UP:
							ta.append("����\n");
							setLocation(r.x  , r.y -= 5);
							break;
						case KeyEvent.VK_DOWN:
							ta.append("�Ʒ���\n");
							setLocation(r.x  , r.y += 5);

							break;

					}
				}
			}
		);
		
		// Mouse Event Listener
		ta.addMouseListener(
				new MouseAdapter() {
					Random r = new Random();
					public void mouseEntered( MouseEvent e) {
						ta.append("���콺 ���Դ�\n");
					}
					public void mouseExited( MouseEvent e) {
						ta.append("���콺 ������\n");
						ta.setBackground(new Color(230,230,230));
					}
					public void mouseClicked(MouseEvent e) {
						ta.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
					}
				}
		);
		
		ta.addMouseWheelListener(
			new MouseAdapter() {
				Random r = new Random();
				public void mouseWheelMoved(MouseWheelEvent e) {
					ta.setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
				}
			}				
		);
		
		
		
	}// ������
	
	
	
	
	
	// Event �� �ϵ���� �۾��̶� ���� ó������ ����  ActionListener �� ����Ѵ�.
	// Text Event Handler
	public void textValueChanged(TextEvent e) {
		if (ta.getText().equals("") ) {
			cancel.setEnabled(false);
		} else {
			cancel.setEnabled(true);
		}
	}
	
	
	// Item Event Handler
	public void itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) {
			// ����
			ta.append(e.getItem()+"����\n");
		}else if (e.getStateChange() == ItemEvent.DESELECTED) {
			// ����
			ta.append(e.getItem()+"����\n");
		}
		
	}
	

	// Action Event ó���ϴ� Handler
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if(com.equals("Ȯ��")) {
			ta.append("Ȯ���߽��ϴ�.\n");
		}else if ( com.equals("���")) {
			ta.setText("");
		} else if(com.equals("����")) {
			System.exit(0);
		}
	}
	

	
	public static void main(String[] args) {
		new AWTEventEx();
		
	}
}

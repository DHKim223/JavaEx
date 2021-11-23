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

/*	이벤트 처리 
이벤트 소스(Event Source) 			이벤트가 발생되는 컴포넌트
이벤트 리스너(Event Listener)		이벤트가 발생하는지를 검사.
													이벤트를 처리할 수 있도록 핸들러를 호출
이벤트 핸들러(Event Handler)		이벤트를 처리하는메서드

ActionEvent				Button List MenuItem 등의 Component가 눌리거나 선택이 되었을 때
AdjustmentEvent		Scrollbar 와 같은 조정 가능한 컴포넌트에서 조정이 일어날 때
ComponentEvent		Component의 모습이나 크기가 이동 변화될 때
ItemEvent				List Choice Checkbox 같은 Component의 선택항목이 선택될 때
TextEvent					TextField TextArea 에서 값이 입력되거나 지워질 때
ContainerEvent		Container에 Component가 추가되거나 제거될 때
FocusEvent				Component에 초점이 들어올 때
PaintEvent				Component가 그려져야 할 때
WindowEvent			Window가 활성화되거나 비활성화 될 때 최소 최대 종료 될 때
KeyEvent					키보드로 부터 입력이 될 때															****
MouseEvent			마우스가 눌려지거나 움직일 때 커서가 들어오거나 나갈 때					****
*/

public class AWTEventEx extends Frame implements ActionListener, ItemListener, TextListener{

	Panel North, South, Center;
	Button ok, cancel, exit;
	Checkbox cb1,cb2,cb3;
	TextArea ta;
	
	public AWTEventEx() {
		// 하단
		South = new Panel();
		South.setBackground(new Color ( 50, 50 ,50));
		ok = new Button("확인");
		cancel = new Button("취소");
		exit = new Button("종료");
		
		ok.setBackground(new Color ( 100,100,100));
		cancel.setBackground(new Color ( 100,100,100));
		exit.setBackground(new Color ( 100,100,100));
		South.setForeground(Color.white);
		South.setFont( new Font( Font.SERIF, Font.BOLD, 15 ) );
		
		South.add(ok);
		South.add(cancel);
		South.add(exit);
		
		add(South,"South");
	
		
		// 상단
		North = new Panel();
		North.setBackground(new Color ( 50,50 ,50));
		cb1 = new Checkbox("독서");
		cb2 = new Checkbox("등산");
		cb3 = new Checkbox("게임");
		North.setForeground(Color.white);
		North.setFont( new Font( Font.SERIF, Font.BOLD, 15 ) );
		
		North.add(cb1);
		North.add(cb2);
		North.add(cb3);

		add(North,"North");
		
		// 중단____  출력용으로 사용할것.
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
						ta.append("아이콘화 됐다.\n");
					}
					public void windowDeiconified(WindowEvent e) { 
						ta.append("윈도우화 됐다.\n");
					}
				}
		);
				
		setTitle("이벤트");
		setBounds(650,150,300,390);
		setVisible(true);
		
		// Action Event Listener,,,,,,,,, ok / cancel / exit 에 감지기를 붙이기
		ok.addActionListener(this);// this.... Handler 가 구현된 객체... 나! => this
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
		ta.addKeyListener(										//Focus 가 있는 위치에서 입력되는 것으로 인식한다..
			new KeyAdapter() {									// 제일먼저 붙인 버튼이 '확인'버튼이라 포커스가 확인버튼에 있다
				Rectangle r = getBounds(); // 현재 프레임의 위치를 가져와라..
				public void keyPressed(KeyEvent e) {
					switch( e.getKeyCode() ) {
						case KeyEvent.VK_LEFT:
							ta.append("왼쪽으로\n");
							setLocation(r.x -=5 , r.y);
							break;
						case KeyEvent.VK_RIGHT:
							ta.append("오른쪽으로\n");
							setLocation(r.x +=5 , r.y);
							break;
						case KeyEvent.VK_UP:
							ta.append("위로\n");
							setLocation(r.x  , r.y -= 5);
							break;
						case KeyEvent.VK_DOWN:
							ta.append("아래로\n");
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
						ta.append("마우스 들어왔다\n");
					}
					public void mouseExited( MouseEvent e) {
						ta.append("마우스 나갔다\n");
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
		
		
		
	}// 생성자
	
	
	
	
	
	// Event 는 하드웨어 작업이라 직접 처리하지 못해  ActionListener 를 사용한다.
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
			// 선택
			ta.append(e.getItem()+"선택\n");
		}else if (e.getStateChange() == ItemEvent.DESELECTED) {
			// 해제
			ta.append(e.getItem()+"해제\n");
		}
		
	}
	

	// Action Event 처리하는 Handler
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if(com.equals("확인")) {
			ta.append("확인했습니다.\n");
		}else if ( com.equals("취소")) {
			ta.setText("");
		} else if(com.equals("종료")) {
			System.exit(0);
		}
	}
	

	
	public static void main(String[] args) {
		new AWTEventEx();
		
	}
}

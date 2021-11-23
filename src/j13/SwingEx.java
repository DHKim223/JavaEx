package j13;

import java.awt.BorderLayout;
import java.awt.Color;

//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;

public class SwingEx extends JFrame implements ActionListener{
	private JPanel south, north;
	private JLabel la;
	private JTextField tf;
	private JTextArea ta;
	private JButton ok, cancel;
	private JScrollPane sp;

	// 메뉴
	private JMenuBar mb;
	private JMenu mfile, medit, mview,mselect;
	private JMenuItem mnew, mopen,msave,mexit,
										minput, moutput, 
										mcolor, mred,mblue,myellow;
	
	
	public SwingEx() {
		// 메뉴
		// 메뉴바 생성
		mb = new JMenuBar();
		setJMenuBar(mb);
		
		// 메뉴 생성
		mfile = new JMenu("파일(F)");
		medit = new JMenu("편집(E)");
		mview = new JMenu("보기(V)");
		mselect = new JMenu("선택");
		mfile.setMnemonic(KeyEvent.VK_F);
		medit.setMnemonic(KeyEvent.VK_E);
		mview.setMnemonic(KeyEvent.VK_V);

		
		mb.add(mfile);
		mb.add(medit);
		mb.add(mview);
		mview.add(mselect);
		
		// 메뉴 아이템 생성
		mnew = new JMenuItem("새파일");
		mopen = new JMenuItem("열기");
		msave = new JMenuItem("저장");
		mexit  = new JMenuItem("종료");
		
		mfile.add(mnew);
		mfile.add(mopen);
		mfile.add(msave);
		mfile.addSeparator();
		mfile.add(mexit);
		
		minput = new JMenuItem("입력");
		moutput = new JMenuItem("출력");
		medit.add(minput);
		medit.add(moutput);
		
		mred = new JMenuItem("빨강");
		mblue = new JMenuItem("파랑");
		myellow = new JMenuItem("노랑");
		mselect.add(mred);
		mselect.add(mblue);
		mselect.add(myellow);
		
		mcolor = new JMenuItem("색상");
		mview.add(mcolor);

		
		// 하단
		south = new JPanel();
		ok = new JButton("확인");
		cancel = new JButton("취소");
		south.add(ok);
		south.add(cancel);
		add( south , "South");
		
		// 상단
		north = new JPanel();
		la = new JLabel(" 	입력 : 	");
		tf = new JTextField();
		north.setLayout( new BorderLayout());
		north.add(la,"West");
		north.add(tf,"Center");
		add(north,"North");
	
		
		// 중단
		ta = new JTextArea();
		sp = new  JScrollPane(ta);
		ta.setEditable(false);
		add(sp,"Center");
		
		setBounds(600,400,300,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Key Event Listner										// esc 나 enter 가 눌렸을때...
		tf.addKeyListener(
				new KeyAdapter() {
					public void keyPressed ( KeyEvent e) {
						switch( e.getKeyCode() ) {
						case KeyEvent.VK_ESCAPE:
							tf.setText("");
							break;
						case KeyEvent.VK_Q:
							if ( KeyEvent.CTRL_MASK == e.getModifiers() )
								System.exit(0);
							break;
						}
					}
				}								
		);
		
		
		// Action Event Listener							// 어떤 버튼이 눌렸을때........
		ok.addActionListener(this);
		tf.addActionListener(this);
		cancel.addActionListener(this);
		mexit.addActionListener(this);
		mred.addActionListener(this);
		mblue.addActionListener(this);
		myellow.addActionListener(this);
		mcolor.addActionListener(this);
		mnew.addActionListener(this);
		mopen.addActionListener(this);
		msave.addActionListener(this);
		minput.addActionListener(this);
		
	}// 생성자
	
		// Action Event Handler
	public void actionPerformed( ActionEvent e ) {
		// 누가 이벤트를 발생시켰는지 그 객체를 알려줌...getSource 
		Object obj = e.getSource();
		if ( obj == ok || obj == tf) {								///  엔터쳤을때 확인되게 만들기========> 2 *** 감지기 추가
			String msg = tf.getText();
			if( !msg.equals("")) {			
				ta.append( msg /*tf.getText()*/ + "\n");  //////////// 숫자 읽어오기~~~~!!!!!
				tf.setText(""); 							  ///////// 읽어온뒤 지워버리기~!!!!!!!			
			}	tf.requestFocus();  	///////// 포커스 입력창에 두기				
			} else if( obj == cancel ) {
				tf.setText("");
				ta.setText("");
			} else if ( obj == mexit) {
				
				int select = JOptionPane.showConfirmDialog(this, "종료할꺼니?","종료선택",JOptionPane.YES_NO_OPTION); // yes no cancel
				if(select == JOptionPane.YES_OPTION) {	
				JOptionPane.showMessageDialog(this, "종료합니다","종료메세지",JOptionPane.WARNING_MESSAGE);
				System.exit(0);
				} else if (select == JOptionPane.NO_OPTION) {
					
				}
			} else if ( obj == mred) {
				ta.setBackground(Color.red);
				ta.setForeground(Color.white);
			} else if ( obj == mblue) {
				ta.setBackground(Color.blue);
				ta.setForeground(Color.white);
			} else if ( obj == myellow) {
				ta.setBackground(Color.yellow);
				ta.setForeground(Color.black);
			} else if( obj == mcolor) {
				Color bg = JColorChooser.showDialog(this, "배경색을 선택하세요", Color.blue);
				ta.setBackground(bg);
				Color fg = JColorChooser.showDialog(this, "글자색을 선택하세요", Color.blue);
				ta.setForeground(fg);
			} else if ( obj == mnew) {
				tf.setText("");
				ta.setText("");
				ta.setBackground(Color.white);
				ta.setForeground(Color.black);
				tf.requestFocus();
			} else if( obj == mopen) {		// 열기
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(this);
				ta.append(fc.getName(fc.getSelectedFile())+"\n");
				
			} else if ( obj == msave) {		// 저장
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(this);
				ta.append(fc.getName(fc.getSelectedFile())+ "\n");
			} else if ( obj == minput) {
				String msg = JOptionPane.showInputDialog(
						this, " 입력하세요", "입력메세지", JOptionPane.QUESTION_MESSAGE);	
				if(msg != null && ! msg.equals("")) {
					ta.append(msg+"\n");
				} 
			}
				
		
	}
	
	public static void main(String[] args) {
		new SwingEx();
		
	}
	
}

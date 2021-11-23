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

	// �޴�
	private JMenuBar mb;
	private JMenu mfile, medit, mview,mselect;
	private JMenuItem mnew, mopen,msave,mexit,
										minput, moutput, 
										mcolor, mred,mblue,myellow;
	
	
	public SwingEx() {
		// �޴�
		// �޴��� ����
		mb = new JMenuBar();
		setJMenuBar(mb);
		
		// �޴� ����
		mfile = new JMenu("����(F)");
		medit = new JMenu("����(E)");
		mview = new JMenu("����(V)");
		mselect = new JMenu("����");
		mfile.setMnemonic(KeyEvent.VK_F);
		medit.setMnemonic(KeyEvent.VK_E);
		mview.setMnemonic(KeyEvent.VK_V);

		
		mb.add(mfile);
		mb.add(medit);
		mb.add(mview);
		mview.add(mselect);
		
		// �޴� ������ ����
		mnew = new JMenuItem("������");
		mopen = new JMenuItem("����");
		msave = new JMenuItem("����");
		mexit  = new JMenuItem("����");
		
		mfile.add(mnew);
		mfile.add(mopen);
		mfile.add(msave);
		mfile.addSeparator();
		mfile.add(mexit);
		
		minput = new JMenuItem("�Է�");
		moutput = new JMenuItem("���");
		medit.add(minput);
		medit.add(moutput);
		
		mred = new JMenuItem("����");
		mblue = new JMenuItem("�Ķ�");
		myellow = new JMenuItem("���");
		mselect.add(mred);
		mselect.add(mblue);
		mselect.add(myellow);
		
		mcolor = new JMenuItem("����");
		mview.add(mcolor);

		
		// �ϴ�
		south = new JPanel();
		ok = new JButton("Ȯ��");
		cancel = new JButton("���");
		south.add(ok);
		south.add(cancel);
		add( south , "South");
		
		// ���
		north = new JPanel();
		la = new JLabel(" 	�Է� : 	");
		tf = new JTextField();
		north.setLayout( new BorderLayout());
		north.add(la,"West");
		north.add(tf,"Center");
		add(north,"North");
	
		
		// �ߴ�
		ta = new JTextArea();
		sp = new  JScrollPane(ta);
		ta.setEditable(false);
		add(sp,"Center");
		
		setBounds(600,400,300,500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Key Event Listner										// esc �� enter �� ��������...
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
		
		
		// Action Event Listener							// � ��ư�� ��������........
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
		
	}// ������
	
		// Action Event Handler
	public void actionPerformed( ActionEvent e ) {
		// ���� �̺�Ʈ�� �߻����״��� �� ��ü�� �˷���...getSource 
		Object obj = e.getSource();
		if ( obj == ok || obj == tf) {								///  ���������� Ȯ�εǰ� �����========> 2 *** ������ �߰�
			String msg = tf.getText();
			if( !msg.equals("")) {			
				ta.append( msg /*tf.getText()*/ + "\n");  //////////// ���� �о����~~~~!!!!!
				tf.setText(""); 							  ///////// �о�µ� ����������~!!!!!!!			
			}	tf.requestFocus();  	///////// ��Ŀ�� �Է�â�� �α�				
			} else if( obj == cancel ) {
				tf.setText("");
				ta.setText("");
			} else if ( obj == mexit) {
				
				int select = JOptionPane.showConfirmDialog(this, "�����Ҳ���?","���ἱ��",JOptionPane.YES_NO_OPTION); // yes no cancel
				if(select == JOptionPane.YES_OPTION) {	
				JOptionPane.showMessageDialog(this, "�����մϴ�","����޼���",JOptionPane.WARNING_MESSAGE);
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
				Color bg = JColorChooser.showDialog(this, "������ �����ϼ���", Color.blue);
				ta.setBackground(bg);
				Color fg = JColorChooser.showDialog(this, "���ڻ��� �����ϼ���", Color.blue);
				ta.setForeground(fg);
			} else if ( obj == mnew) {
				tf.setText("");
				ta.setText("");
				ta.setBackground(Color.white);
				ta.setForeground(Color.black);
				tf.requestFocus();
			} else if( obj == mopen) {		// ����
				JFileChooser fc = new JFileChooser();
				fc.showOpenDialog(this);
				ta.append(fc.getName(fc.getSelectedFile())+"\n");
				
			} else if ( obj == msave) {		// ����
				JFileChooser fc = new JFileChooser();
				fc.showSaveDialog(this);
				ta.append(fc.getName(fc.getSelectedFile())+ "\n");
			} else if ( obj == minput) {
				String msg = JOptionPane.showInputDialog(
						this, " �Է��ϼ���", "�Է¸޼���", JOptionPane.QUESTION_MESSAGE);	
				if(msg != null && ! msg.equals("")) {
					ta.append(msg+"\n");
				} 
			}
				
		
	}
	
	public static void main(String[] args) {
		new SwingEx();
		
	}
	
}

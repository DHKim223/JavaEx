package j11;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Color;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComponentEx extends Frame {
	public ComponentEx() {
		// Button
		Panel p1 = new Panel();
		p1.setBackground( new Color( 30, 30, 30 ) );
		
		Button bt1 = new Button( "�� ��" );
		Button bt2 = new Button( "�� ��" );
		Button bt3 = new Button();
		bt3.setLabel( "  ��  " );
		
		bt1.setBackground(Color.red);
		bt2.setBackground(Color.green);
		bt3.setBackground(Color.blue);
		
		bt1.setFont(  new Font( Font.SERIF, Font.BOLD, 20));
		bt2.setFont(  new Font( Font.SANS_SERIF, Font.ITALIC, 20));
		bt3.setFont(  new Font( Font.MONOSPACED, Font.BOLD, 20));

		
		p1.setForeground(Color.white);
		
		p1.add( bt1 );
		p1.add( bt2 );
		p1.add( bt3 );		
		add( p1 );						// FlowLayout ��ġ�� ������ �� �ȴ�.
		
		// Label
		Panel p2 = new Panel();
		p2.setBounds(0,50,200,100);
		p2.setBackground(new Color (100,100,100));
		Label la1 = new Label("���");
		Label la2 = new Label("��", Label.CENTER);
		Label la3 = new Label ("�ٳ���",Label.RIGHT);
		
		la1.setBackground(Color.pink);
		la2.setBackground(Color.cyan);
		la3.setBackground(Color.magenta);


		p2.add(la1);
		p2.add(la2);
		p2.add(la3);
		
		
		add(p2);
						
		// List
		Panel p3 = new Panel();
		p3.setBackground(new Color (150,150,150));
		
		List list =  new List( 7 , true );		// ��� ���ϸ� false - �⺻��
		list.add("��⵵");
		list.add("������");
		list.add("��û��");
		list.add("����");
		list.add("���");
		list.add("���ֵ�");
		
		list.select(2);	// ó������ üũ�Ǿ� ������...
	
		p3.add(list);
		
		add(p3);
		
		// Choice							Combo box
		Panel p4 = new Panel();
		p4.setBackground(new Color(170,170,170));
		
		Choice ch = new Choice();
		ch.add("����");
		ch.add("����");
		ch.add("��õ");
		ch.add("����");
		ch.add("���");
		ch.add("�λ�");
		ch.add("����");
		ch.add("�뱸");
		ch.select("����");
		
		p4.add(ch);
		add(p4);
		
		// Checkbox
		Panel p5 = new Panel();
		p5.setBackground(new Color(200,200,200));  // 0~ 255
		
		Checkbox cb1 = new Checkbox("�౸");
		Checkbox cb2 = new Checkbox("�߱�", true);
		Checkbox cb3 = new Checkbox("�豸");
		
		p5.add(cb1);
		p5.add(cb2);
		p5.add(cb3);
	
		add(p5);
		
		// CheckboxGroup 						Radio Button
		Panel p6 = new Panel();
		p6.setBackground(new Color(220,220,220));
		CheckboxGroup group = new CheckboxGroup();
		Checkbox cb4 = new Checkbox("����", false, group);
		Checkbox cb5 = new Checkbox("���", false, group);
		Checkbox cb6 = new Checkbox("����", false, group);

		p6.add(cb4);			// p6�� ���̰�
		p6.add(cb5);
		p6.add(cb6);
		
		add(p6);				// �����ӿ� p6�� ���̰�,,
		
		// TextField
		Panel p7 = new Panel();
		TextField tf = new TextField("Hello",30);
		
		p7.add(tf);
		p7.setBackground(new Color(240,240,240));
		
		add(p7);
		
		//TextArea
		
		Panel p8 = new Panel();
		TextArea ta = new TextArea("",5,30,TextArea.SCROLLBARS_NONE);
		
		p8.add(ta);
		p8.setBackground(new Color(250,250,250));
		
		add(p8);
		
		// Layout
		setLayout( new FlowLayout() );
		setResizable( false );
		setTitle( "������Ʈ ����" );
		setBounds( 650, 150, 300, 500 );
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
		new ComponentEx();
	}
}

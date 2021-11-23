package hw_AWT;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTHW extends Frame implements ActionListener {
	Panel north, south;
	Button mod, ce, c, del, 
				inv, sqr, sqrt, div, 
				mult, sub, add, equl, 
				one,two, three, four, five, six, seven, eight, nine, zero, 
				dot, pm;  
	TextArea ta;
	
	// 숫자 저장을 위한 변수 선언필요함....
	
	public AWTHW() {
		// Text Area
		north = new Panel();
		ta = new TextArea("",5,47,TextArea.SCROLLBARS_NONE);
		ta.setBackground(new Color(230,230,230));
		ta.setForeground(Color.black);
		ta.setFont(new Font (Font.SERIF, Font.BOLD, 15));
		ta.setEditable(false);
		
		north.add(ta,"North");
		add(north,"North");
		
		// Button Area
		south = new Panel();
		
		mod = new Button("%");
		ce = new Button("CE");
		c = new Button("C");
		del = new Button("Del");
		inv = new Button("1/x");
		sqr = new Button("x^2");
		sqrt = new Button("x^(1/2)");
		div = new Button("/");
		mult = new Button("*");
		sub = new Button("-");
		add = new Button("+");
		equl = new Button("=");
		one = new Button("1");
		two = new Button("2");
		three = new Button("3");
		four = new Button("4");
		five = new Button("5");
		six = new Button("6");
		seven = new Button("7");
		eight = new Button("8");
		nine = new Button("9");
		zero = new Button("0");
		dot = new Button(".");
		pm = new Button("+/-");
		
		south.add(mod);south.add(ce);south.add(c);south.add(del);					
		south.add(inv);south.add(sqr);south.add(sqrt);south.add(div);					
		south.add(seven);south.add(eight);south.add(nine);south.add(mult);
		south.add(four);south.add(five);south.add(six);south.add(sub);
		south.add(one);south.add(two);south.add(three);south.add(add);
		south.add(pm);south.add(zero);south.add(dot);south.add(equl);
										
		add(south,"South");
		
		
		// Window Event
		this.addWindowListener(
				new WindowAdapter() {		 
					public void windowClosing( WindowEvent e){
						System.exit(0);
					}				
				}
		);
				
		south.setLayout( new GridLayout(6,4) );
		setTitle("계산기");
		setBounds(650,150,425,440);
		setVisible(true);
		
		mod.addActionListener(this); ce.addActionListener(this); c.addActionListener(this); del.addActionListener(this);
		inv.addActionListener(this); sqr.addActionListener(this); sqrt.addActionListener(this); div.addActionListener(this);
		seven.addActionListener(this); eight.addActionListener(this); nine.addActionListener(this); mult.addActionListener(this);
		four.addActionListener(this); five.addActionListener(this); six.addActionListener(this); sub.addActionListener(this);
		one.addActionListener(this); two.addActionListener(this); three.addActionListener(this); add.addActionListener(this);
		pm.addActionListener(this); zero.addActionListener(this); dot.addActionListener(this); equl.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		String com = e.getActionCommand();
		if(com.equals("%")) {
			//ta.append("%");
		}else if ( com.equals("CE")) {
			//ta.append("CE");
		} else if ( com.equals("C")) {
			//ta.append("C");
		} else if ( com.equals("Del")) {
			//ta.append("Del");
		} else if ( com.equals("1/x")) {
			//ta.append("1/x");
		} else if ( com.equals("x^2")) {
			//ta.append("x^2");
		} else if ( com.equals("x^(1/2)")) {
			//ta.append("x^(1/2)");
		} else if ( com.equals("/")) {
			//ta.append("/");
		} else if ( com.equals("7")) {
			ta.append("7");
		} else if ( com.equals("8")) {
			ta.append("8");
		} else if ( com.equals("9")) {
			ta.append("9");
		} else if ( com.equals("*")) {
			//ta.append("*");
		} else if ( com.equals("4")) {
			ta.append("4");
		} else if ( com.equals("5")) {
			ta.append("5");
		} else if ( com.equals("6")) {
			ta.append("6");
		} else if ( com.equals("-")) {
			//ta.append("-");
		} else if ( com.equals("1")) {
			ta.append("1");
		} else if ( com.equals("2")) {
			ta.append("2");
		} else if ( com.equals("3")) {
			ta.append("3");
		} else if ( com.equals("+")) {
			//ta.append("+");
		} else if ( com.equals("+/-")) {
			//ta.append("+/-");
		} else if ( com.equals("0")) {
			ta.append("0");
		} else if ( com.equals(".")) {
			ta.append(".");
		} else if ( com.equals("=")) {
			//ta.append("=");
		} else {}
	}
	
	
	public static void main(String[] args) {
		new AWTHW();
	}
}

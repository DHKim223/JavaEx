package hw_AWT;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;



class calculation{
	public void modulus(){
		
	}
	
	public void clearentry(){
		
	}
	
	public void clear(){
		
	}
		
	public void inverse() {
		
	}
	
	public void square() {
		
	}
	
	public void squareroot() {
		
	}
	
	public void division() {
		
	}
	
	public void multiplication() {
		
	}
	
	public void subtraction() {
		
	}
	
	public void addition() {
		
	}
	
	public void equal() {
			
	}
	
	public void plsign() {
		
	}
}

public class HW1 extends Frame  implements ActionListener {
		private JPanel btns, res;
		private JTextArea calc,answ;
		private Button mod, ce, c, del, 
								inv, sqr, sqrt, div, 
								mult, sub, add, eq, 
								one,two, three, four, five, six, seven, eight, nine, zero, 
								dot, pm;  
		double numb=0, ans=0;
		char op = ' ';
		
		public HW1() {
		
		// 버튼
		btns =new JPanel(); 
		//btns.setLayout ( new GridLayout(6,0));		
		btns.setLayout(null);
		
		mod = new Button("%");
		mod.setBackground(Color.black);
		mod.setForeground(Color.white);
		mod.setBounds(0,60,50,40);
		
		ce = new Button("CE");
		ce.setBackground(Color.black);
		ce.setForeground(Color.white);
		c = new Button("C");
		c.setBackground(Color.black);
		c.setForeground(Color.white);
		del = new Button("Del");
		del.setBackground(Color.black);
		del.setForeground(Color.white);
		inv = new Button("1/x");
		inv.setBackground(Color.black);
		inv.setForeground(Color.white);
		sqr = new Button("x^2");
		sqr.setBackground(Color.black);
		sqr.setForeground(Color.white);
		sqrt = new Button("√x");
		sqrt.setBackground(Color.black);
		sqrt.setForeground(Color.white);
		div = new Button("/");
		div.setBackground(Color.black);
		div.setForeground(Color.white);
		mult = new Button("*");
		mult.setBackground(Color.black);
		mult.setForeground(Color.white);
		sub = new Button("-");
		sub.setBackground(Color.black);
		sub.setForeground(Color.white);
		add = new Button("+");
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		eq = new Button("=");
		eq.setBackground(Color.black);
		eq.setForeground(Color.white);
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

		btns.add(mod);btns.add(ce);btns.add(c);btns.add(del);					
		btns.add(inv);btns.add(sqr);btns.add(sqrt);btns.add(div);					
		btns.add(seven);btns.add(eight);btns.add(nine);btns.add(mult);
		btns.add(four);btns.add(five);btns.add(six);btns.add(sub);
		btns.add(one);btns.add(two);btns.add(three);btns.add(add);
		btns.add(pm);btns.add(zero);btns.add(dot);btns.add(eq);
		
		add(btns);
		
		// TA
		res = new JPanel();		
//		north.setLayout( new BorderLayout());
//		north.add(ta,"Center");		
//		add(north,"North");	
		calc.setLayout(null);

		calc = new JTextArea();
		calc.setBounds(0,20,300,40);
		calc.setBackground(Color.black);
		
		answ = new JTextArea();
		answ.setBounds(0,0,300,40);
		answ.setBackground(Color.CYAN);
		
		calc.setEditable(false);
		answ.setEditable(false);
						
		res.add(calc);
		res.add(answ);		
		
		// Frame
		setBounds( 650, 150, 200, 300 );
		setVisible( true );
		addWindowListener(
			new WindowAdapter() {
				public void windowClosing( WindowEvent e ) {
					System.exit( 0 );
				}
			}				
		);
		
		// Action Event Listener
		
		mod.addActionListener(this); ce.addActionListener(this); c.addActionListener(this); del.addActionListener(this);
		inv.addActionListener(this); sqr.addActionListener(this); sqrt.addActionListener(this); div.addActionListener(this);
		seven.addActionListener(this); eight.addActionListener(this); nine.addActionListener(this); mult.addActionListener(this);
		four.addActionListener(this); five.addActionListener(this); six.addActionListener(this); sub.addActionListener(this);
		one.addActionListener(this); two.addActionListener(this); three.addActionListener(this); add.addActionListener(this);
		pm.addActionListener(this); zero.addActionListener(this); dot.addActionListener(this); eq.addActionListener(this);
		
		
	} // 생성자
		
	public void actionPerformed( ActionEvent e ) {
		
		ArrayList<Integer> number = new ArrayList<>();
	
		// number.add(1)
		Object obj = e.getSource();
		if( obj == one) {
			calc.append("1");
			
		} else if ( obj == two ) {
			calc.append("2");
			
		} else if ( obj == three ) {
			calc.append("3");
			
		} else if ( obj == four ) {
			calc.append("4");
			
		} else if ( obj == five ) {
			calc.append("5");
			
		} else if ( obj == six ) {
			calc.append("6");
			
		} else if ( obj == seven ) {
			calc.append("7");
			
		} else if ( obj == eight ) {
			calc.append("8");
			
		} else if ( obj == nine ) {
			calc.append("9");
			
		} else if ( obj == zero ) {
			calc.append("0");
			
		} else if ( obj == dot ) {
			String str = calc.getText();
			if (str.contains(".")==false) {
				calc.append(".");
			}		
		} else if ( obj == mod ) {
			
		} else if ( obj == ce ) {
			calc.setText("");
		} else if ( obj == c ) {
			calc.setText("");
		} else if ( obj == del ) {
			String str = calc.getText();
			str = str.substring(0, str.length() - 1);
			calc.setText(str);
		} else if ( obj == inv ) {
			
		} else if ( obj == sqr ) {
			
		} else if ( obj == sqrt ) {
			
		} else if ( obj == div ) {
			
		} else if ( obj == mult ) {
			
		} else if ( obj == sub ) {
			
		} else if ( obj == add ) {
			//BigDecimal a = new BigDecimal(Double.parseDouble(ta.getText()));			
			Object obj1 = e.getSource();
			if(obj1 == mod || obj1 == inv || obj1 == sqr || obj1== sqrt || obj1 == div || obj1==mult || obj1 == sub ) {
				obj = obj1;
			} else {
				numb = Double.parseDouble( calc.getText());
				calc.setText("");
				op = '+';
			}
		} else if ( obj == pm ) {
			
		} else if ( obj == eq ) {
			switch(op) {
			case '+': calc.setText(String.valueOf( numb + Double.parseDouble( calc.getText() )));
			break;
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		new HW1();
	}
}
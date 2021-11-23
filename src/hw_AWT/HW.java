package hw_AWT;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.MathContext;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class HW extends JFrame implements ActionListener {
	
	private JPanel btns;	
	private JTextArea ta, res;
	private JButton 	mod, ce, c, del, 
								inv, sqr, sqrt, div, 
								mult, sub, add, eq, 
								one,two, three, four, five, six, seven, eight, nine, zero, 
								dot, pm;  
	BigDecimal firstnumb, lastnumb, answer, answer2;
	String op;
	
	public HW() {
		// Buttons	
		btns = new JPanel();
		btns.setLayout(null);
		add(btns);
		
		mod = new JButton("%");
		mod.setBackground(Color.black);
		mod.setForeground(Color.white);
		mod.setBounds(0,90,80,60);
		
		ce = new JButton("CE");
		ce.setBackground(Color.black);
		ce.setForeground(Color.white);
		ce.setBounds(80,90,80,60);
		
		c = new JButton("C");
		c.setBackground(Color.black);
		c.setForeground(Color.white);
		c.setBounds(160,90,80,60);
		
		del = new JButton("Del");
		del.setBackground(Color.black);
		del.setForeground(Color.white);
		del.setBounds(240,90,80,60);
		
		inv = new JButton("1/x");
		inv.setBackground(Color.black);
		inv.setForeground(Color.white);
		inv.setBounds(0,150,80,60);
		
		sqr = new JButton("x^2");
		sqr.setBackground(Color.black);
		sqr.setForeground(Color.white);
		sqr.setBounds(80,150,80,60);
		
		sqrt = new JButton("¡îx");
		sqrt.setBackground(Color.black);
		sqrt.setForeground(Color.white);
		sqrt.setBounds(160,150,80,60);
		
		div = new JButton("/");
		div.setBackground(Color.black);
		div.setForeground(Color.white);
		div.setBounds(240,150,80,60);
		
		seven = new JButton("7");
		seven.setBackground(Color.white);
		seven.setForeground(Color.black);
		seven.setBounds(0,210,80,60);
		
		eight = new JButton("8");
		eight.setBackground(Color.white);
		eight.setForeground(Color.black);
		eight.setBounds(80,210,80,60);
		
		nine = new JButton("9");
		nine.setBackground(Color.white);
		nine.setForeground(Color.black);
		nine.setBounds(160,210,80,60);
		
		mult = new JButton("X");
		mult.setBackground(Color.black);
		mult.setForeground(Color.white);
		mult.setBounds(240,210,80,60);
		
		four = new JButton("4");
		four.setBackground(Color.white);
		four.setForeground(Color.black);
		four.setBounds(0,270,80,60);
		
		five = new JButton("5");
		five.setBackground(Color.white);
		five.setForeground(Color.black);
		five.setBounds(80,270,80,60);
		
		six = new JButton("6");
		six.setBackground(Color.white);
		six.setForeground(Color.black);
		six.setBounds(160,270,80,60);
			
		sub = new JButton("-");
		sub.setBackground(Color.black);
		sub.setForeground(Color.white);
		sub.setBounds(240,270,80,60);
		
		one = new JButton("1");
		one.setBackground(Color.white);
		one.setForeground(Color.black);
		one.setBounds(0,330,80,60);
		
		two = new JButton("2");
		two.setBackground(Color.white);
		two.setForeground(Color.black);
		two.setBounds(80,330,80,60);
		
		three = new JButton("3");
		three.setBackground(Color.white);
		three.setForeground(Color.black);
		three.setBounds(160,330,80,60);
		
		add = new JButton("+");
		add.setBackground(Color.black);
		add.setForeground(Color.white);
		add.setBounds(240,330,80,60);
		
		pm = new JButton("+/-");
		pm.setBackground(Color.white);
		pm.setForeground(Color.black);
		pm.setBounds(0,390,80,60);
		
		zero = new JButton("0");
		zero.setBackground(Color.white);
		zero.setForeground(Color.black);
		zero.setBounds(80,390,80,60);
		
		dot = new JButton(".");
		dot.setBackground(Color.white);
		dot.setForeground(Color.black);
		dot.setBounds(160,390,80,60);
			
		eq = new JButton("=");
		eq.setBackground(Color.black);
		eq.setForeground(Color.white);
		eq.setBounds(240,390,80,60);
		
		btns.add(mod);btns.add(ce);btns.add(c);btns.add(del);					
		btns.add(inv);btns.add(sqr);btns.add(sqrt);btns.add(div);					
		btns.add(seven);btns.add(eight);btns.add(nine);btns.add(mult);
		btns.add(four);btns.add(five);btns.add(six);btns.add(sub);
		btns.add(one);btns.add(two);btns.add(three);btns.add(add);
		btns.add(pm);btns.add(zero);btns.add(dot);btns.add(eq);
				
		// Windows
		res = new JTextArea();
		res.setBounds(0,0,320,45);
		res.setBackground(Color.gray);
		res.setForeground(Color.black);
		btns.add(res);
		res.setEditable(false);
		
		ta= new JTextArea();
		ta.setBounds(0,45,320,45);
		ta.setBackground(Color.gray);
		ta.setForeground(Color.black);
		btns.add(ta);
		ta.setEditable(false);
		
	
		res.setFont(new Font("Calibri",Font.BOLD,30));
		ta.setFont(new Font("Calibri",Font.BOLD,30));

		

			
		setBounds(1200,200,336,489);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Action Event Listener
		mod.addActionListener(this); ce.addActionListener(this); c.addActionListener(this); del.addActionListener(this);
		inv.addActionListener(this); sqr.addActionListener(this); sqrt.addActionListener(this); div.addActionListener(this);
		seven.addActionListener(this); eight.addActionListener(this); nine.addActionListener(this); mult.addActionListener(this);
		four.addActionListener(this); five.addActionListener(this); six.addActionListener(this); sub.addActionListener(this);
		one.addActionListener(this); two.addActionListener(this); three.addActionListener(this); add.addActionListener(this);
		pm.addActionListener(this); zero.addActionListener(this); dot.addActionListener(this); eq.addActionListener(this);
		
	} // »ý¼ºÀÚ
	
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		if( obj == one) {
			ta.append("1");	
		} else if ( obj == two ) {
			ta.append("2");
			
		} else if ( obj == three ) {
			ta.append("3");
			
		} else if ( obj == four ) {
			ta.append("4");
			
		} else if ( obj == five ) {
			ta.append("5");
			
		} else if ( obj == six ) {
			ta.append("6");
			
		} else if ( obj == seven ) {
			ta.append("7");
			
		} else if ( obj == eight ) {
			ta.append("8");
			
		} else if ( obj == nine ) {
			ta.append("9");
			
		} else if ( obj == zero ) {
			ta.append("0");
			
		} else if ( obj == dot ) {
			String str = ta.getText();
			if (str.contains(".")==false) {
				ta.append(".");				
			}		
		} else if ( obj == mod ) {
			op = "%";
			opdisp();
		} else if ( obj == ce || obj == c ) {	
			ta.setText("");
			res.setText("");
			firstnumb = new BigDecimal("");
			lastnumb = new BigDecimal("");
			answer = new BigDecimal("");			
		} else if ( obj == del ) {
			String str = ta.getText();
			str = str.substring(0, str.length() - 1);
			ta.setText(str);
		} else if ( obj == inv ) {
			op = "1/x";
			try {
				opdisp();
				opcalc();
				ta.setText(String.valueOf(answer));				
				} catch (Exception r){					
					opcalc2();
				} finally {
					res.setText(String.valueOf(answer));	
				}
		} else if ( obj == sqr ) {
			op = "x^2";			
			try {
			opdisp();
			opcalc();
			ta.setText(String.valueOf(answer));				
			} catch (Exception r){					
				opcalc2();		
			} finally {
				res.setText(String.valueOf(answer));	
			}
		} else if ( obj == sqrt ) {
			op = "¡îx";
			try {
				opdisp();
				opcalc();
				ta.setText(String.valueOf(answer));				
				} catch (Exception r){					
					opcalc2();		
				} finally {
					res.setText(String.valueOf(answer));	
				}
		} else if ( obj == div ) {
			op = "/";			
			opdisp();			
		} else if ( obj == mult ) {
			op = "X";
			opdisp();
		} else if ( obj == sub ) {
			op = "-";
			opdisp();
		} else if ( obj == add ) {
			op = "+";
			opdisp();

		} else if ( obj == pm ) {			
			String str = ta.getText();
			BigDecimal temp = new BigDecimal( str );
			BigDecimal negv;			
			negv = temp.negate();			
			negv = negv.stripTrailingZeros();
			ta.setText(String.valueOf(negv));
		} else if ( obj == eq ) {
			try {
				opcalc();
				res.setText(String.valueOf(answer));
			} catch(Exception r) {
				r.printStackTrace();
				opcalc2();
				res.setText(String.valueOf(answer));
			}
		}
	} 
	
	
	public void opdisp () {							
		
		try {
			String temp = ta.getText();
			ta.setText("");
			firstnumb = new BigDecimal( temp );
			res.setText(firstnumb + "( " + op+ " ) ");			
		} catch (Exception e) {
			e.printStackTrace();
			res.setText(firstnumb + "( " + op+ " ) ");				
		}
		
	}
	
	public BigDecimal opcalc() {
	
		switch(op) {
		case "%":  
			lastnumb = new BigDecimal(ta.getText()); 
			answer = firstnumb.remainder(lastnumb,MathContext.DECIMAL32);
			break;
		case "1/x":  			
			answer = BigDecimal.ONE.divide(firstnumb,MathContext.DECIMAL32); 
			break; 
		case "x^2":  
			answer = firstnumb.pow(2);	
			break;	
		case "¡îx":  
			MathContext mc = new MathContext(10);
			answer = firstnumb.sqrt(mc);	
			break;	
		case "/":  			
			lastnumb = new BigDecimal(ta.getText()); 
			answer = firstnumb.divide(lastnumb,MathContext.DECIMAL32);			
			break;	
		case "X":  
			lastnumb = new BigDecimal(ta.getText());  
			answer = firstnumb.multiply(lastnumb,MathContext.DECIMAL32);
			break;
		case "-":  
			lastnumb = new BigDecimal(ta.getText());  
			answer = firstnumb.subtract(lastnumb, MathContext.DECIMAL32);
			break;
		case "+":  
			lastnumb = new BigDecimal(ta.getText()); 
			answer = firstnumb.add(lastnumb,MathContext.DECIMAL32);
			break;
		default : break;
		}	
		ta.setText("");  
		answer = answer.stripTrailingZeros();
		return answer;		
	}
	
	public BigDecimal opcalc2() {
		firstnumb = answer;
		switch(op) {
		case "/":   	
			answer = firstnumb.divide(lastnumb);	
			break;
		case "X":  
			answer = firstnumb.multiply(lastnumb); 
			break;
		case "-":   
			answer = firstnumb.subtract(lastnumb);
			break;
		case "+":   
			answer = firstnumb.add(lastnumb);
			break;
			
		case "1/x":  		
			answer = BigDecimal.ONE.divide(firstnumb); 
			break;
		case "x^2":
			answer = firstnumb.pow(2);	
			break;
		case "¡îx":  
			MathContext mc = new MathContext(10);
			answer = firstnumb.sqrt(mc);	
			break;

		}
		answer = answer.stripTrailingZeros();
		return answer;
	}
		
	
	public static void main(String[] args) {
		new HW();
	}
	
	
}

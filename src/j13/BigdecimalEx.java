package j13;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigdecimalEx {
	public static void main(String[] args) {
		
		
		BigDecimal a = new BigDecimal( 4.0 );
		BigDecimal b = new BigDecimal( -2.0 );
		
		BigDecimal c =  a.add( b, MathContext.DECIMAL32 );
		BigDecimal d =  a.subtract( b, MathContext.DECIMAL32  );
		BigDecimal e = a.multiply( b, MathContext.DECIMAL32 ) ;
		BigDecimal f =   a.divide( b, MathContext.DECIMAL32 ) ;
		
		BigDecimal c2 =	c.stripTrailingZeros();
		BigDecimal d2 = d.stripTrailingZeros();
		BigDecimal e2 = e.stripTrailingZeros();
		BigDecimal f2 = f.stripTrailingZeros();
		System.out.println(c2);
		System.out.println(d2);
		System.out.println(e2);
		System.out.println(f2);

		String numb = "-123.105";
		BigDecimal numb1 = new BigDecimal(numb);
		System.out.println(numb1);
		
		MathContext mc = new MathContext(10);
		BigDecimal sqrt = a.sqrt(mc);
		System.out.println(sqrt);
		
		BigDecimal temp = new BigDecimal("50");
		System.out.println(temp.negate());
		
	
		
		
		
	}
}

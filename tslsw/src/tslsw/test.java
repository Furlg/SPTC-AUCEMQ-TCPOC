package tslsw;

import java.math.BigDecimal;

public class test {

	public static void main(String[] args) {
		String moneyString = "3455994";
		
		String [] s1 = moneyString.split("\\.");
		System.out.println(s1[0]);
		try {
			BigDecimal bigdecemal = new BigDecimal(moneyString);
		} catch (Exception e) {
			System.out.println("×ª»»Ê§°Ü");
		}
	}

}

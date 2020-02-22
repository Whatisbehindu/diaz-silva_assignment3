/*	Requirements
 * 		Class SavingsAccount
 * 		Private Static Variable annualInterestRate (Stores annual interest rate)
 * 		Private instance variable savingsBalance (How much user has in savings)
 * 		 
 * 	Methods
 * 		Public calculateMonthlyInterest( Calculates monthly interest)
 * 			(savingsBalance * annualInterestRate) / 12
 * 			Add this interest value to the savingsBalance
 * 		static method modifyInterestRate
 * 			Modifies annualInterestRate
 */

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;
import java.text.NumberFormat;

public class SavingsAccount {

		private static BigDecimal annualInterestRate = BigDecimal.ZERO;
		private BigDecimal savingsBalance;
		
		public SavingsAccount (BigDecimal savingsBalance) {
			this.savingsBalance = savingsBalance;
			annualInterestRate.setScale(3);
		}
		
		public void calculateMonthlyInterest() {
			BigDecimal monthlyInterest, annualInterest, rate;
			rate = annualInterestRate.divide(BigDecimal.valueOf(100));
			annualInterest = savingsBalance.multiply(rate);
			monthlyInterest = annualInterest.divide(BigDecimal.valueOf(12), 9, RoundingMode.HALF_UP);
			displayMonthlyBalance(monthlyInterest);
		}
		
		public static void modifyInterestRate(BigDecimal rate) {
			annualInterestRate = rate;
			System.out.printf("Annual Interest Rate set to %.2f",annualInterestRate);
			System.out.println("%");
			System.out.println(" ");
		}
		
		public void displayMonthlyBalance (BigDecimal monthlyInterestRate) {
			savingsBalance = savingsBalance.add(monthlyInterestRate);
			savingsBalance.setScale(9);
			System.out.printf(NumberFormat.getCurrencyInstance(Locale.US).format(savingsBalance));
		}
}

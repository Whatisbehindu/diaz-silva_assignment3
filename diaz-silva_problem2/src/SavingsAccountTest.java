import java.math.BigDecimal;
import java.text.NumberFormat;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(BigDecimal.valueOf(2000));
		SavingsAccount saver2 = new SavingsAccount(BigDecimal.valueOf(3000));
		
		SavingsAccount.modifyInterestRate(BigDecimal.valueOf(4));
		
		System.out.printf("Displaying Savings for both accounts. %n%s%20s%s%n", "Account 1"," ","Account 2");
		for (int i = 0; i<12; i++) {
		saver1.calculateMonthlyInterest();
		System.out.printf("%20s", " ");
		saver2.calculateMonthlyInterest();
		System.out.printf("%n");
		}
		
		System.out.println(" ");
		
		SavingsAccount.modifyInterestRate(BigDecimal.valueOf(5));
		
		System.out.printf("Displaying Savings for both accounts. %n%s%20s%s%n", "Account 1"," ","Account 2");
		for (int i = 0; i<12; i++) {
		saver1.calculateMonthlyInterest();
		System.out.printf("%20s", " ");
		saver2.calculateMonthlyInterest();
		System.out.printf("%n");
		}
	}

}

/*
Methods
		quiz
		askQuestion
		readResponse
		isAnswerCorrect
		displayCorrectResponse
		displayIncorrectResponse

Requirements
		Random numbers with SecureRandom
		Asks student to solve multiplication
			2 sampled 1 int numbers randomly
		Student inputs response
		Display correct or incorrect
			Random number generated response
		Repeat responses until student gives correct answer
*/
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI2 {

	public static void main(String[] args) {
		quiz();
	}

	public static void quiz() {
		int i = 1;
		SecureRandom rand = new SecureRandom();
		
		int rand1 = rand.nextInt(10);
		int rand2 = rand.nextInt(10);
		
		while (i !=0) {		
		askQuestion(rand1,rand2);
		int answer = readResponse();
		
		int correct = isAnswerCorrect(answer, rand1, rand2);
		if (correct == 1) {
			displayCorrectResponse();
			return;
		}
		else
			displayIncorrectResponse();
		}
	}
	
	public static void askQuestion(int a, int b) {
		System.out.printf("How much is %d times %d?%n",a,b);
	}
	
	public static int readResponse() {
		Scanner input = new Scanner(System.in);
		int answer = input.nextInt();
		return answer;
	}
	
	public static int isAnswerCorrect(int answer, int a, int b) {
		int solution = a*b;
		if (answer == solution)
			return 1;
		else
			return 0;
	}
	
	public static void displayCorrectResponse() {
		SecureRandom rand = new SecureRandom ();
		int choice = rand.nextInt(4);
		
		switch (choice) {
		case 0: System.out.println("Very good!");
			break;
		case 1: System.out.println("Excellent!");
			break;
		case 2: System.out.println("Nice work!");
			break;
		case 3: System.out.println("Keep up the good work!");
			break;
		}
	}
	
	public static void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom ();
		int choice = rand.nextInt(4);
		
		switch (choice) {
		case 0: System.out.println("No. Please try again.");
			break;
		case 1: System.out.println("Wrong. Try once more.");
			break;
		case 2: System.out.println("Don't give up!");
			break;
		case 3: System.out.println("No. Keep trying.");
			break;
		}
	}
}
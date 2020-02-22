/*
Methods
		quiz
		askQuestion
		readResponse
		isAnswerCorrect
		displayCorrectResponse
		displayIncorrectResponse
		displayCompletionMessage

Requirements
		Random numbers with SecureRandom
		Asks student to solve multiplication (10 questions)
			2 sampled 1 int numbers randomly
		Student inputs response
		Display correct or incorrect
			Random number generated response
		Repeat responses until student gives 10 answers
		Display percentage and condition
		Ask to restert program or to terminate
*/
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI3 {

	public static void main(String[] args) {
		quiz();
	}

	public static void quiz() {
		int i;
		int count=0 ;
		SecureRandom rand = new SecureRandom();
		
		for (i=0; i<10; i++) {	
		
		int rand1 = rand.nextInt(10);
		int rand2 = rand.nextInt(10);
		
		askQuestion(rand1,rand2);
		int answer = readResponse();
		
		int correct = isAnswerCorrect(answer, rand1, rand2);
		if (correct == 1) {
			displayCorrectResponse();
			count++;
		}
		else
			displayIncorrectResponse();
		}
		
		displayCompletionMessage(count);
		System.out.printf("Do you want to try a new problem set?%n1 for yes, 2 for no%n");
		Scanner input = new Scanner(System.in);
		int pick = input.nextInt();
		if (pick == 1)
			quiz();
	}
	
	public static void displayCompletionMessage(int a) {
		double average = (a/10.0)*100;
		System.out.printf("%.0f%% %n", average);
		if (average >= 75) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
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
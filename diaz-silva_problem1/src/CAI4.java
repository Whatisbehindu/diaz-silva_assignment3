/*
Methods
		quiz
		readDifficulty
		generateQuestionArgument
		askQuestion
		readResponse
		isAnswerCorrect
		displayCorrectResponse
		displayIncorrectResponse
		displayCompletionMessage

Requirements
		Random numbers with SecureRandom
			Difficulty rating changes number of digits per integer
		Asks student to solve multiplication (10 questions)
			2 sampled 1 int numbers randomly
		Student inputs response
		Display correct or incorrect
			Random number generated response
		Repeat responses until student gives 10 answers
		Display percentage and condition
		Ask to restart program or to terminate
*/
import java.util.Scanner;
import java.security.SecureRandom;

public class CAI4 {

	public static void main(String[] args) {
		quiz();
	}

	public static void quiz() {
		int i;
		int count=0 ;
		SecureRandom rand = new SecureRandom();
		int difficulty = readDifficulty();
		
		for (i=0; i<10; i++) {	
		
		int rand1 = generateQuestionArgument(difficulty);
		int rand2 = generateQuestionArgument(difficulty);
		
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
	
	public static int generateQuestionArgument(int difficulty) {
		int number;
		SecureRandom rand = new SecureRandom (); 
		switch (difficulty) {
		case 1: number = rand.nextInt(10);
			return number;
		case 2: number = rand.nextInt(100);
		return number;
		case 3: number = rand.nextInt(1000);
		return number;
		case 4: number = rand.nextInt(10000);
		return number;
		default: number = rand.nextInt(10);
		return number;		
		}
	}
	
	public static int readDifficulty() {
		System.out.println("Select difficulty setting. 1 for easy, 2 for medium, 3 for hard, 4 for hardest");
		Scanner input = new Scanner(System.in);
		int difficulty = input.nextInt();		
		return difficulty;
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
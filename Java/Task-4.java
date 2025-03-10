import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizAppConsole {
    private static String[][] questions = {
            {"What is the capital of France?", "Berlin", "Paris", "Rome", "Madrid", "2"},
            {"Who developed Java?", "Microsoft", "Oracle", "Sun Microsystems", "Google", "3"},
            {"Which data structure uses LIFO?", "Queue", "Stack", "Heap", "Graph", "2"},
            {"What is 10 + 5?", "12", "15", "20", "25", "2"},
            {"Which is a Java keyword?", "variable", "class", "define", "int", "4"}
    };

    private static int currentQuestion = 0, score = 0, timeLeft = 10;
    private static boolean answered = false;
    private static Timer timer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome to the Quiz! Answer before the timer runs out.");

        while (currentQuestion < questions.length) {
            displayQuestion();
            startTimer();

            int userAnswer = -1;
            while (timeLeft > 0 && !answered) {
                if (scanner.hasNextInt()) {
                    userAnswer = scanner.nextInt();
                    answered = true;
                }
            }

            timer.cancel();  // Stop the timer
            checkAnswer(userAnswer);
        }

        System.out.println("\nQuiz Over! Your final score: " + score + "/" + questions.length);
        scanner.close();
    }

    private static void displayQuestion() {
        answered = false;
        timeLeft = 10;
        System.out.println("\nQ" + (currentQuestion + 1) + ": " + questions[currentQuestion][0]);
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + ". " + questions[currentQuestion][i]);
        }
        System.out.print("Your answer (1-4): ");
    }

    private static void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (timeLeft > 0) {
                    timeLeft--;
                } else {
                    timer.cancel();
                    System.out.println("\nTime's up! Moving to next question...");
                    answered = true;
                }
            }
        }, 1000, 1000);
    }

    private static void checkAnswer(int userAnswer) {
        if (answered && userAnswer == Integer.parseInt(questions[currentQuestion][5])) {
            System.out.println("✅ Correct!");
            score++;
        } else {
            System.out.println("❌ Wrong! The correct answer was " + questions[currentQuestion][Integer.parseInt(questions[currentQuestion][5])]);
        }
        currentQuestion++;
    }
}
//Output:
/*Welcome to the Quiz! Answer before the timer runs out.

Q1: What is the capital of France?
1. Berlin
2. Paris
3. Rome
4. Madrid
Your answer (1-4): 2
? Correct!

Q2: Who developed Java?
1. Microsoft
2. Oracle
3. Sun Microsystems
4. Google
Your answer (1-4): 3
? Correct!

Q3: Which data structure uses LIFO?
1. Queue
2. Stack
3. Heap
4. Graph
Your answer (1-4): 2
? Correct!

Q4: What is 10 + 5?
1. 12
2. 15
3. 20
4. 25
Your answer (1-4): 2
? Correct!

Q5: Which is a Java keyword?
1. variable
2. class
3. define
4. int
Your answer (1-4): 3
? Wrong! The correct answer was int

Quiz Over! Your final score: 4/5 */

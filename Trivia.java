import java.util.Scanner;
import java.util.HashMap;

public class Trivia {

    HashMap<String, String> triviaQuestions = new HashMap<>();

    public int menu() { // Menu display / selection
        System.out.println("Please choose one (enter number of choice);");
        System.out.println("1: New Game");
        System.out.println("2: High Scores");
        System.out.println("3: Save Score");
        System.out.println("4: Quit");

        Scanner selection = new Scanner(System.in);
        int choice = selection.nextInt();

        return choice;
    }

    public void init() { //Set up the questions / answers
        triviaQuestions.put("What is the capital of France?", "Paris");
        triviaQuestions.put("Which planet is known as the Red Planet?", "Mars");
        triviaQuestions.put("Who wrote 'Romeo and Juliet'?", "William Shakespeare");
        triviaQuestions.put("What is the largest ocean on Earth?", "Pacific Ocean");
        triviaQuestions.put("How many continents are there?", "7");
        triviaQuestions.put("What is the chemical symbol for gold?", "Au");
        triviaQuestions.put("Who painted the Mona Lisa?", "Leonardo da Vinci");
        triviaQuestions.put("What is the tallest mammal in the world?", "Giraffe");
        triviaQuestions.put("In which year did humans first land on the Moon?", "1969");
        triviaQuestions.put("What is the smallest prime number?", "2");
        triviaQuestions.put("Which country is home to the Great Pyramid of Giza?", "Egypt");
        triviaQuestions.put("What is the hardest natural substance on Earth?", "Diamond");
        triviaQuestions.put("Who developed the theory of relativity?", "Albert Einstein");
        triviaQuestions.put("Which element has the atomic number 1?", "Hydrogen");
        triviaQuestions.put("What is the largest planet in our solar system?", "Jupiter");
    }

    public int gameLoop() {
        int score = 0; //Running total, starts at 0
        System.out.println("Alright then, let's play! (at any time, answer 'q' or 'Q' to quit)");
        System.out.println();
        Scanner selection = new Scanner(System.in);

        for (String question : triviaQuestions.keySet()) { //loop through questions
            System.out.println(question);

            System.out.println("Answer:");
            
            String answer = selection.nextLine();

            if (answer.toLowerCase().equals("q")) { //option to quit early
                System.out.println();
                System.out.println("Final score: " + score);
                System.out.println();
                return score;
            } else if (answer.toLowerCase().equals(triviaQuestions.get(question).toLowerCase())) { //actually check answer
                System.out.println("Correct!");
                score ++;
            } else { //answer's wrong
                System.out.println("Incorrect!");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Final score: " + score);
        System.out.println();
        return score; //Once all questions have been asked, return score
    }
}

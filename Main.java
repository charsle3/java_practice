import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

      Scanner userInput = new Scanner(System.in); //Create scanner object to get user input

      System.out.println("If your cranial capacity is something scary... Let's take a quiz!"); //Welcome message + username
      System.out.println("What's your name?");
      String userName = userInput.nextLine();
      System.out.println("");
      System.out.println("Welcome, " + userName + "!");

      System.out.println("Please Enter Name of Save File (.txt): ");
      String fileName = userInput.nextLine(); //prompt for and save the file name to be used for the save file

      SaveFile save = new SaveFile();
      save.init(fileName, userName); //Will create a new file if it doesn't exist already. If it exists, it reads it in.
      
      Trivia gameData = new Trivia(); //creates trivia class object
      gameData.init(); //saves trivia questions / answers in attribute
      int score = 0;

      boolean running = true;
      while (running) { //main menu loop
        System.out.println("");
        switch(gameData.menu()) { //call the menu selection in Trivia class
          case 1: //New Game
            score = gameData.gameLoop();
            if (score > save.saveData.get(userName)) { // after running a game, only store the score if it's higher than what's recorded
              save.saveData.put(userName, score);
            }
            break;
          case 2: //High Scores
            System.out.println("");

            for (String name : save.saveData.keySet()) { //display scores
                System.out.println(name + ": " + save.saveData.get(name));
            }

            break;
          case 3: //Save Score
            save.saveToFile(userName); //write to file
            break;
          case 4: //Quit
            running = false;
            break;
          default:
            System.out.println("Invalid choice. Please enter 1, 2, 3, or 4."); //invalid input handler
        }
      }

      userInput.close();
      System.out.println("Thanks for playing! Goodbye."); //exit message
    }
}
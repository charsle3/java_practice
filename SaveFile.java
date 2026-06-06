import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;
import java.util.TreeMap;

public class SaveFile {

    String fileName;
    TreeMap<String, Integer> saveData = new TreeMap<>();

    public void readFromFile() {
        File saveFile = new File(fileName);

        try (Scanner readFile = new Scanner(saveFile)) {
        while (readFile.hasNextLine()) { //get each line from the save file
            String data = readFile.nextLine();
            String splitExp = "[/]"; 
            String[] keyValue = data.split(splitExp); //split username and score apart
            int value = Integer.parseInt(keyValue[1]); //convert score to int
            saveData.put(keyValue[0], value); //store information in object attribute
        }
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }

    public void saveToFile(String userName) {

        try {
            FileWriter save = new FileWriter(fileName);
            
            for (String name : saveData.keySet()) {
                save.write(name + "/" + saveData.get(name) + "\n"); //store in "Username/score\n" format
            }

            save.close();
        } catch (IOException e) { //error handling
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }

    public void init(String fileName, String userName) {

        this.fileName = fileName;

        try {
            File saveFile = new File(fileName);
            if (saveFile.createNewFile()) { //make the file if it doesn't exist
                System.out.println("New Save File Created!");
            }
            else {
                System.out.println("File retrieved");
                readFromFile(); //read the file if it exists
            }
        } catch (IOException e) { // error handling
          System.out.println("An error occurred.");
          e.printStackTrace(); // Print error details
        }

        if (!saveData.containsKey(userName)) { //If the current user isn't recorded in the save data, record them with a score of 0
            saveData.put(userName, 0);
        }
    }
}

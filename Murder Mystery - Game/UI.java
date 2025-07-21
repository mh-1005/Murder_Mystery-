
import java.util.NoSuchElementException;
import java.util.Scanner;
// UI class to handle user input in the main method
// It provides methods to read characters and strings from the terminal
class UI{
    Scanner scanner = new Scanner(System.in);

    char readChar(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().charAt(0);
    }
    String readLine(String prompt){
        System.out.println(prompt);
      try {
        return scanner.nextLine();
    } catch (NoSuchElementException e) {
        System.out.println("No more input. Exiting gracefully...");
        System.exit(0); // Or return a default value
        return ""; // This won't be reached, but avoids compiler error
    }
    }


}
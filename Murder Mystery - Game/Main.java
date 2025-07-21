
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//main class
public class Main {
     UI ui = new UI();

     
  //intro to game
 String getPlayerName() {
      String playerName;
      
                while(true){
                    try{

                        playerName = ui.readLine("Set your player name:");
                        if(!playerName.matches("^[a-zA-Z\\s]+$")){
                         throw new InvalidInputException("Invalid input! Try again.");
                        }
                        else {
                              System.out.println("\nHi," + playerName); // greeting the player
              
                            break;
                        }
                    }
                    catch (InvalidInputException e){
                         System.out.println(e.getMessage());
                    }
                }
                     return playerName;
            }
        char getGender(Player player1){ 
  char playerGender;
    while(true){
                   playerGender= ui.readChar("\nWhat is your gender? (m/f)");

                    try{
                        if(playerGender=='f'||playerGender=='F'|| playerGender=='m' || playerGender=='M'){
                            player1.setGender(playerGender);
                            break;

                        }
                        else{
                            throw new InvalidInputException("Invalid Input! Try again.");

                        }
                    }
                   catch (InvalidInputException e){
                        System.out.println(e.getMessage());
                    
                   }


                }
            return playerGender;
            }
   
    
    void run_game(ArrayList<Utility> numberOfGamesPlayed ){
  System.out.println("\nWelcome to the Murder Mystery Game:");
        while(true){

            char input = ui.readChar("Do you want to play?(y/n)");
            if (input == 'y' || input == 'Y'){
               
               String playerName = getPlayerName(); // method to get player name and intro to game
               //player object
                Player player1 = new Player(playerName);
                getGender(player1); // get gender
                
                //utility object to control the game
                Utility Gamebegin = new Utility(player1);
                numberOfGamesPlayed.add(Gamebegin); 

                 // game description
                Utility.displayGameDescription(playerName);
                // game starts
                Gamebegin.hallway();
                while(!Utility.gameWon){
                playAgain(numberOfGamesPlayed,Gamebegin);}
                if(Utility.gameEnd){break;} 

            }
              // if user chooses to not play
            else if (input== 'n' || input == 'N') {
                System.out.println("Not playing? Brave choice. But don not worry, life has got bigger plot twists waiting for you!");
                break;
            }
            else{
                System.out.println("Invalid Input! Try again.");
                System.out.println();
        
            }

            }
    }

    void playAgain(ArrayList<Utility>numberOfGamesPlayed, Utility Gamebegin){
      
                    char userInput= ui.readChar("Do you want to play again? (y/n)");
                    if (userInput== 'y' || userInput == 'Y'){
                        // Use of copy constructor to start the game where it was ended
                        Utility playagain = new Utility(Gamebegin);
                        
                  

                        if(numberOfGamesPlayed.size()<3){
                         numberOfGamesPlayed.add(playagain);
                         playagain.hallway();
                             
                        }
                        else {
                            System.out.println("Alas! You ran out of turns! Good Bye...");
                            System.exit(0);
                        }
                            

                    }
                    else if(userInput== 'n' || userInput== 'N'){
                        System.out.println("You can go now..But next Mansion Mystery awaits you!");
                     System.exit(0);
                      
                    }
                    else{
                        System.out.println("Invalid Input. Please Try again.");
                    }
                
                

    }

    
     
    public static void main(String[] args) {


        List<Utility> numberOfGamesPlayed = new ArrayList<>();   //Array of object
        // everytime user plays again an object of game is added in the list
        // if user exceeds 2 turns(checked by size() method) , program ends ( only 2 times player can try again )

  
        Main main = new Main();
        main.run_game((ArrayList<Utility>) numberOfGamesPlayed); // running the game
}
}

import java.util.Scanner;
// Utility class is a "GOD CLASS" which has all the controlling methods of the game
class Utility {
    Scanner scanner = new Scanner(System.in);
    //Aggregation
    Player player;

    //Objects of classes
    Room kitchen;
    Room ThegreatHall;
    Room Crimescene;

    // static variable of Utility class
    static boolean gameEnd;
    static boolean gameWon;

    //static block to initialize tools of game
    static {
        gameEnd = false;
        gameWon = false;
    }

    // passing object in constructor;
    Utility(Player player) {
        this.player = player;
        // initializing objects declared above
        //these objects have name,themes,descriptions, pre-defined clues , choices etc
        ThegreatHall = new TheGreatHall("The Great Hall", "You're in a spacious, bright room,surrounded by paintings..Smell of fresh paint leads to you to an old man painting a wall", new String[]{"Talk to the painter", "Walk around", "Go back to the hallway"}, new String[]{"Great Hall is bright spacious room", "Great hall smells like fresh paint"},this);
        kitchen = new Kitchen("Kitchen", "You are in the kitchen..a strong,burning smell is hitting your senses.", new String[]{"Check the burning pot", "Look inside the drawer", "Talk to chef", "Go back to Hallway"}, new String[]{"Boiling bones in the pot"},this,this.ThegreatHall);
        Crimescene = new CrimeScene("Crime Scene", "You're in a foul-smelling room...In front of you stands a filthy bed", new String[]{"Investigate the bed", "Go back to the hallway"}, new String[]{"White hair strand on mattress", "Chopped tongue behind the pillow"},this);

    }


    //copy constructor
    // constructor Overloading
    Utility(Utility utility) {
        this(utility.player);
        gameEnd=false;
    }

    //Game Description
    static void displayGameDescription(String PlayerName) {
        System.out.println("\n" + PlayerName + ", you are a detective in the town of Wellsburry.");
        utilityMethods.delayed(1000);
        System.out.println("\nYou have received a letter: There has been a murder of Granny at Uncle George's Mansion.");
        utilityMethods.delayed(2000);
        System.out.println("Your task is to find the murderer!...Everyone in the mansion is a suspect!");

    }

    //Main hallway which control the game
      void hallway() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            utilityMethods.delayed(1500);
            System.out.println("\n--Choose a place for your investigation in the Mansion--");
            System.out.println();
            System.out.println("1.Crime Scene (Where granny was murdered)");
            System.out.println("2.Kitchen");
            System.out.println("3.The great hall");
            System.out.println();
            System.out.println("Choose any option from 1-3");
            if (scanner.hasNextInt()) {
                int userChoice = scanner.nextInt();
                if (userChoice == 1) {
                    Crimescene.enterRoom(player);
                    break;
                } else if (userChoice == 2) {
                    kitchen.enterRoom(player);
                    break;
                } else if (userChoice == 3) {
                    ThegreatHall.enterRoom(player);
                    break;
                } else {
                    System.out.println("Invalid Input! Try again. ");


                }
            } else {
                System.out.println("Invalid Input! Please Choose any option from (1-3)");
                scanner.next();
            }

        }

    }
    // method to display clues collected by the player at the end of the game
     void displayClues(){
        System.out.println("Clues you have collected: ");
        System.out.println();
        utilityMethods.delayed(800);
        if (Kitchen.chefclue) {
            utilityMethods.delayed(100);
            kitchen.timothy.Clues();
        }
        if (Painter.painterclue) {
            utilityMethods.delayed(100);
            ThegreatHall.Charlie.Clues();
        }
        if (BurningPot.potclue) {
            utilityMethods.delayed(100);
            kitchen.roomClues();
        }
        if (CrimeScene.crimesceneclue) {
            utilityMethods.delayed(100);
            Crimescene.roomClues();
        }
        if (TheGreatHall.greathallclue) {
            utilityMethods.delayed(100);
            ThegreatHall.roomClues();
        }
    }
    // method to accuse the suspect
    // player has to choose between Chef and Painter
     void AccuseSuspect(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nWhich one is the murderer among these suspects?");
            utilityMethods.delayed(90);
            System.out.println("1.Chef ");
            utilityMethods.delayed(90);
            System.out.println("2.Painter ");
            int finalChoice;
            if (scanner.hasNextInt()) {
                finalChoice = scanner.nextInt();
                if (finalChoice == 1) {
                    gameWon = true;
                    utilityMethods.delayed(100);
                    System.out.println("Aha! You are such a clever detective!");
                    utilityMethods.delayed(100);
                    System.out.println("Indeed Chef was the murderer.He was boiling the uncle george's granny bones!");
                    gameEnd = true;
                    break;
                } else if (finalChoice == 2) {
                    utilityMethods.delayed(100);
                    System.out.println("Alas! You lost! you are not a clever detective..");
                    utilityMethods.delayed(100);
                    System.out.println("--What distracted you? That white hair strand or chopped tongue?");
                    System.out.println("--It was granny's hair on the mattress");
                    System.out.println("--Chef was the murderer, he chopped his tongue to trick you");
                    gameEnd = true;
                    break;
                } else {
                    System.out.println("Invalid Input.Try again.");
                }
            } else {
                System.out.println("Invalid Input! Please choose any option from (1-2)");
                scanner.next();
            }
        }
        
    }


}

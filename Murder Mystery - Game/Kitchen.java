//Kitchen class is inherited from Room
//Composition Relation between  Kitchen,Chef and BurningPot class
class Kitchen extends Room implements utilityMethods{
    static boolean chefclue;
    BurningPot burningPot;
    Chef timothy;
    Utility utility;
    TheGreatHall greatHall;
    static{
        BurningPot.potclue = false;
        Kitchen.chefclue = false;
    }
    //constructor
    Kitchen(String name,String theme,String[] choices, String[] clues,Utility utility,TheGreatHall greatHall){
        super(name,theme,choices,clues);
        this.utility=utility;
        this.greatHall=greatHall;
        burningPot= new BurningPot("Burning pot","Ugly, cracked bones boiling in the pot, mixed with limp vegetables, giving off a nasty smell.");
        timothy= new Chef("timothy",false,new String[]{"Chef's tongue is chopped off"});
    }
    @Override  //overriding abstract class method
    void roomClues(){
        System.out.println("-------Kitchen Clues: ");
        for(String clue:clues){
            System.out.println("                        - "+ clue);
        }
    }
    @Override //overriding interface method
    public void enterRoom(Player player){
        System.out.println();
        //theme of the kitchen
        displayTheme();

        while (true) {
            utilityMethods.delayed(1000);
            //display of choices when the player enters the kitchen
            displayChoice();
            System.out.println();
            System.out.println("Choose any option from 1-4");
            int choiceA;
            if (scanner.hasNextInt()) {
                choiceA = scanner.nextInt();

                if (choiceA == 1) {
                    System.out.println("\n" + burningPot.description);
                    BurningPot.potclue = true;
                } else if (choiceA == 2) {
                    if (!JewelBox.JewelBoxkey) {
                        System.out.println("\nNice Move! You have found a Jewel Box key.");
                        JewelBox.JewelBoxkey = true;
                    } else {
                        System.out.println("\nThe drawer is empty..");
                    }
                } else if (choiceA == 3) {
                    Kitchen.chefclue = true;
                    utilityMethods.delayed(500);
                    timothy.talk(player);
                    utilityMethods.delayed(2000);
                    System.out.println();
                    timothy.showDirection();
                    utilityMethods.delayed(1000);
                    System.out.println("\n Type s to walk up the staircase");
                    char userInput = scanner.next().charAt(0);
                    if (userInput == 's' || userInput == 'S') {
                        greatHall.enterRoom(player);
                        break;
                    } else {
                        System.out.println("Invalid input! I suppose you are scared of the staircase..Coward");
                    }

                } else if (choiceA == 4) {
                    utility.hallway();
                    break;
                } else {
                    System.out.println("Invalid Input! Try again.");
                }
            } else {
                System.out.println("Invalid Input! Please choose any option from (1-4)");
                scanner.next();
            }
        }


    }

}
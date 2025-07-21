//TheGreatHall class is inherited from Room
//Composition Relation between class TheGreatHall and class Painter,Envelope,JewelBox
class TheGreatHall extends {
    static boolean greathallclue;
    Envelope envelope;
    JewelBox jewelbox;
    Painter Charlie;
    Utility utility;
    static {
        Painter.painterclue = false;
        TheGreatHall.greathallclue = false;
        Envelope.EnvelopeGlue = true;
        JewelBox.JewelBoxkey = false;
    }
    //constructor
    TheGreatHall(String name,String theme,String[] choices, String[] clues,Utility utility){
        super(name,theme,choices,clues);
        this.utility=utility;
        envelope = new Envelope("Envelope","[Inside there is a paper, It says..'Do not believe everything you see..']");
        jewelbox = new JewelBox("Jewel box","Voila! You are an amazing player.You have found the key to unlock Crime scene!");
        Charlie = new Painter("Charlie",new String[]{"Painter is an old man with white hairs"});
    }
    @Override  //overriding abstract class method
    void roomClues(){
        System.out.println("-------The Great Hall Clues: ");
        for(String clue:clues){
            System.out.println("                        - "+ clue);
        }
    }
    @Override // overriding interface method
    public void enterRoom(Player player){
        utilityMethods.delayed(500);
        System.out.println();
        //theme of the Crime Scene
       displayTheme();
        TheGreatHall.greathallclue = true;
        while (true) {
            utilityMethods.delayed(1500);
            //display of choices when the player enters the great hall
            displayChoice();
            System.out.println();
            System.out.println("Choose any option from 1-3");
            int choiceA;
            if (scanner.hasNextInt()) {
                choiceA = scanner.nextInt();
                if (choiceA == 1) {
                    Painter.painterclue = true;
                    utilityMethods.delayed(500);
                    System.out.println();
                    Charlie.talk(player);

                } else if (choiceA == 2) {
                    utilityMethods.delayed(500);
                    System.out.println("As you roam around the great hall, you find a rusty jewel box behind an envelop..");
                    while (true) {
                        utilityMethods.delayed(1500);
                        System.out.println();
                        System.out.println("1.Open the envelope");
                        System.out.println("2.Open the jewel box");
                        System.out.println("3.Go back to Hallway");
                        System.out.println("Choose any option from (1-3)");
                        int choiceB;
                        if (scanner.hasNextInt()) {


                            choiceB = scanner.nextInt();

                            if (choiceB == 1) {

                                if (!Envelope.EnvelopeGlue) {
                                    utilityMethods.delayed(500);
                                    System.out.println("You have already Opened the envelope");
                                } else {
                                    utilityMethods.delayed(500);
                                    System.out.println(envelope.description);
                                    Envelope.EnvelopeGlue = false;
                                }
                            } else if (choiceB == 2) {
                                if (!JewelBox.JewelBoxkey) {
                                    utilityMethods.delayed(500);
                                    System.out.println("The jewel box is locked, The key must be somewhere in the kitchen");
                                } else {
                                    if (!CrimeScene.CrimeScenekey) {
                                        System.out.println();
                                        utilityMethods.delayed(500);
                                        System.out.println("Unlocking the jewel box...");
                                        utilityMethods.delayed(500);
                                        System.out.println("...Inside the jewel box there is a key");
                                        for (int i = 0; i < 2; i++) {
                                            System.out.println();
                                        }
                                        utilityMethods.delayed(1000);
                                        System.out.println(jewelbox.description);
                                        CrimeScene.CrimeScenekey = true;
                                    } else {
                                        System.out.println("The jewel box is empty");
                                    }
                                }
                            } else if (choiceB == 3) {
                                System.out.println();
                                System.out.println("Story does not end here investigate more to find the murderer...");
                                utility.hallway();
                                break;
                            } else {
                                System.out.println("Invalid Input! Try again.");
                            }
                        } else {
                            System.out.println("Invalid Input! Please choose from (1-3)");
                            scanner.next();
                        }

                    }

                } else if (choiceA == 3) {
                    utility.hallway();
                    break;

                } else {
                    System.out.println("Invalid Input! Try again.");
                }
            } else {
                System.out.println("Invalid Input! Try again.");
                scanner.next();
            }
            if (Utility.gameEnd) {
                break;
            }

        }
    }
}

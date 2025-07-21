//CrimeScene class is inherited from Room
//Composition Relation between class CrimeScene and class Bedsheet,Pillow
class CrimeScene extends Room {
    static  boolean CrimeScenekey;
    static boolean crimesceneclue;
    static boolean isUnlocked=false;
    Bedsheet bedsheet;
    Pillow Pillow;
    Utility utility;
    static {
        CrimeScene.CrimeScenekey = false;
        CrimeScene.crimesceneclue = false;
        CrimeScene.isUnlocked = false;
    }
    //constructor
    CrimeScene(String name,String theme,String[] choices, String[] clues,Utility utility){
        super(name,theme,choices,clues);
        this.utility=utility;
        bedsheet= new Bedsheet("Bed sheet","Bed sheet furled up..and you find a white hair strand on the mattress.");
        Pillow = new Pillow("Pillow","Pillow moved aside..and what is it!?? Chopped,bloody tongue !!! ");

    }
    @Override  //overriding abstract class method
    void roomClues(){
        System.out.println("-------Crime Scene Clues: ");
        for(String clue:clues){
            System.out.println("                        - "+ clue);
        }
    }
    @Override //overriding interface method
    public void enterRoom(Player player){
        boolean bed = false;
        boolean pillow = false;

        //check whether the key to the crime scene is found or not
        if (!CrimeScene.CrimeScenekey) {
            System.out.println("STOP! The door is locked. Go Find the key!");
            utility.hallway();
        } else {
            if (!CrimeScene.isUnlocked) {
                System.out.println("Fantastic! You have unlocked the Crime scene.");
                CrimeScene.isUnlocked = true;
            }

            utilityMethods.delayed(2000);
            //theme of the Crime Scene
            System.out.println();
            displayTheme();
            while (true){
                utilityMethods.delayed(1000);
                //display of choices when the player enters the crime scene
               displayChoice();
                int choiceA;
                if (scanner.hasNextInt()) {
                    choiceA = scanner.nextInt();

                    if (choiceA == 1) {
                        CrimeScene.crimesceneclue = true;
                        while (true) {
                            utilityMethods.delayed(1000);
                            System.out.println();
                            System.out.println("1.Remove bed sheet");
                            System.out.println("2.Move the pillow");
                            System.out.println("3.Reach to a conclusion");
                            System.out.println();
                            System.out.println("Choose any option from 1-3");
                            int choiceB;
                            if (scanner.hasNextInt()) {
                                choiceB = scanner.nextInt();

                                if (choiceB == 1) {
                                    if (!bed) {
                                        utilityMethods.delayed(500);
                                        System.out.println(bedsheet.description);
                                        bed = true;

                                    } else {
                                        utilityMethods.delayed(500);
                                        System.out.println("You have already removed the bed sheet");

                                    }

                                } else if (choiceB == 2) {
                                    if (!pillow) {
                                        utilityMethods.delayed(500);
                                        System.out.println(Pillow.description);
                                        pillow = true;

                                    } else {
                                        utilityMethods.delayed(500);
                                        System.out.println("You have already moved the pillow");

                                    }

                                } else if (choiceB == 3) {
                                    // In the end,clues are shown but only those clues which user interacted with
                                    utility.displayClues();
                                    utility.AccuseSuspect();
                                    break;
                                } else {
                                    System.out.println("Invalid Input! Please choose any option from (1-3)");
                                }
                            } else {
                                System.out.println("Invalid Input! Please choose any option from (1-3)");
                                scanner.next();
                            }
                        }

                        System.out.println("\nThanks for playing the Mystery Game!");
                        return;
                    } else if (choiceA == 2) {
                        utility.hallway();
                        break;

                    } else {
                        System.out.println("Invalid Input! Try again.");
                    }
                } else {
                    System.out.println("Invalid Input! Please choose any option from (1-2)");
                    scanner.next();
                }
            }
        }
    }
}

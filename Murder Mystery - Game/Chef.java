// Chef is a subclass of Characters
class Chef extends Characters{
    //properties
    Boolean canSpeak;

    //constructor
    Chef(String name,Boolean canSpeak,String[] clues){
        super(name,clues);
        this.canSpeak=canSpeak;

    }

    //behaviours
    void talk(Player player){
        if(!canSpeak){
            System.out.println("Chef opens his mouth..Blood drips on the ground");
            System.out.println("...You notice his tongue is chopped off!");
        }
        else{
            System.out.println("hello"+player.getName());
        }
    }
    void showDirection(){
        System.out.println("Chef points towards..a dusty staircase");
    }
    @Override //overriding abstract class method
    void Clues(){
        System.out.println("-------Chef Clue: ");
        for(String clue:clues){
            System.out.println("                        - "+ clue);
        }
    }

}
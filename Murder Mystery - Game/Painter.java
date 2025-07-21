
//Painter is a subclass of Characters
class Painter extends Characters{
    static boolean painterclue;
    //constructor
    Painter(String name,String[] clues){
        super(name,clues);
    }
    //behaviours
    void talk(Player player){
        if(player.getGender()=='f'){
            System.out.println("Hello,Young Lady");
        }
        else{
            System.out.println("Hello,Gentleman");

        }
        System.out.println("I've grown old painting these mansion walls , my hair turned white long before the paint dried");

    }
    @Override //overriding abstract class method
    void Clues(){
        System.out.println("-------Painter Clue: ");
        for(String clue:clues){
            System.out.println("                        - "+ clue);
        }
    }

}
//base class represents characters in the game
abstract class Characters {
    //properties
    String name;
    String[] clues;
    //constructor
    Characters(String name,String[] clues){
        this.name=name;
        this.clues=clues;
    }
    // abstract method
    abstract void Clues();
}

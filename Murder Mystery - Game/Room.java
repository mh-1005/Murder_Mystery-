//Base class for rooms in the game
// It is an abstract class which is inherited by Kitchen,TheGreatHall,CrimeScene classes
abstract class Room{
    //attributes
    String name;
    String theme;
    String[] choices;
    String[] clues;

    //constructor
    Room(String name,String theme,String[] choices, String[] clues){
        this.name=name;
        this.theme=theme;
        this.choices=choices;
        this.clues=clues;
    }
    //methods
    void displayTheme(){
        System.out.println(theme);
    }
    void displayChoice(){
        System.out.println();
        for(int i=0;i<choices.length;i++){
            System.out.println((i+1)+" "+choices[i]);
        }
    }
    abstract void roomClues();

}
//class for user
class Player{
    //attributes
    private String name;
    private char gender;
    private int age;


    //constructor
    Player(String name){
        setName(name);
    }
    //Mutator
    public void setName(String name){
        this.name=name;
    }
    //Accessor
    public String getName(){
        return name;
    }
    public void setGender(char gender){
        this.gender=gender;
    }
    public char getGender(){
        return gender;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
import java.util.Scanner;
//behaviour which 3 different classes(Kitchen,TheGreatHall,CrimeScene implement differently
interface utilityMethods{
    //scanner object
    Scanner scanner = new Scanner(System.in);
    // abstract method
    void enterRoom(Player player);
    // static method for delayed response to enhance UX
    static void delayed(int seconds) {
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            System.out.println("....");
        }

    }
}

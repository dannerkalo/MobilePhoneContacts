import java.util.Scanner;

class App {
    // instance fields
    private Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilephone = new MobilePhone("09 06 09 06");



    public static void main(String[] args) {
        //
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {

        }

    }


    private static void startPhone() {
        System.out.println("Start phone.....");
    }

    private static void printActions() {
        System.out.println("\nAvailable actions:\npress");
        System.out.println("0 - to shutdown.\n" + 
                           "1 - to print phonecontacts.\n" + 
                           "2 - to add a new phonecontact.\n" + 
                           "3 - to update an existing phonecontact.\n" + 
                           "4 - to remove an existing phonecontact.\n" +
                           "5 - to query if an existing contact.\n" + 
                           "6 - to print a list of available actions.");
        System.out.println("Choose your action: ");
    }

    // instance methods

}
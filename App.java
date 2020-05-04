import java.util.Scanner;
import java.lang.String;

class App {
    // instance fields
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilephone = new MobilePhone("09 06 09 06");
    private static int counter = 0;

    public static void main(String[] args) {
        //
        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to see the available actions)");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                System.out.println("\nShutting down...");
                quit = true;
                break;
                case 1:
                mobilephone.printPhoneContacts();
                break;
                case 2:
                addNewPhoneContact();
                break;
                case 3:
                updatePhoneContact();
                break;
                case 4:
                removePhoneContact();
                break;
                case 5:
                queryPhoneContact();
                break;
                case 6:
                printActions();
                break;
            }
        }

    }

   /* instance methods */

    //Add new Phone contact
    private static void addNewPhoneContact(){
        System.out.println("Enter new contact name: ");
        String name = validatePhoneContactName(scanner.nextLine());
        System.out.println("Enter phone number: ");
        String phone = validatePhoneNumber(scanner.nextLine());

        //
        PhoneContact newPhoneContact = PhoneContact.createPhoneContact(name, phone);
        if((phone != null && name != null) && mobilephone.addNewPhoneContact(newPhoneContact)){
            System.out.println("New contact added: Name = " + name + ", & Phone: " + phone);
        }else{
            System.out.println("Unable to add this: Name = " + name + " and Phone = " + phone);
        }
       if(counter != 3){
        counter++;  
        System.out.println( counter + " - Name should be at least 3 charachtes long and not longer than 15 charachters.");
        System.out.println(" - Phonenumber should be 10 charachtes long.");
        addNewPhoneContact();
        }
    }
    

    //Update if contact exists 
    private static void updatePhoneContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        PhoneContact existingCountactrecordFound = mobilephone.queryPhoneContact(name);
        if(existingCountactrecordFound == null){
            System.out.println("Contact not found to update.");
            return;
        }

        System.out.print("Enter new contact name: ");
        String newName = scanner.nextLine();
        System.out.println("Enter a new contact phone number: ");
        String newNumber = scanner.nextLine();
        PhoneContact newPhoneContact = PhoneContact.createPhoneContact(newName, newNumber);
        if(mobilephone.updatePhoneContact(existingCountactrecordFound, newPhoneContact)){
            System.out.println("Succesfully updated");
        }else{
            System.out.println("Error updating record!");
        }
    
    }

    //remove method
    private static void removePhoneContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        PhoneContact existingCountactrecordFound = mobilephone.queryPhoneContact(name);
        if(existingCountactrecordFound == null){
            System.out.println("Contact not found to remove.");
            return;
        }

        if(mobilephone.removePhoneContact(existingCountactrecordFound)){
            System.out.println("Successfully deleted.");
        }else{
            System.out.println("Error deleting contact!");
        }
    }

    //Query contact info method
    private static void queryPhoneContact(){
        System.out.println("Enter existing contact name: ");
        String name = scanner.nextLine();
        PhoneContact existingCountactrecordFound = mobilephone.queryPhoneContact(name);
        if(existingCountactrecordFound == null){
            System.out.println("Contact not found to query.");
            return;
        }
        System.out.println("Name: " + existingCountactrecordFound.getPhoneContactName());
        System.out.println("Phone number is " + existingCountactrecordFound.getPhoneContactNumber());
    }


            //Validate contact name
       private static String validatePhoneContactName(String phoneContactName){
        //
        if((phoneContactName.length() > 2) && (phoneContactName.length() < 15)){   
          return phoneContactName;
        }
        return null;
      }

       //Validate phonenumber
       private static String validatePhoneNumber(String phonenContactNumber){
        //
        if(phonenContactNumber.length() == 10){ 
          return phonenContactNumber;
        }
        return null;
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

}
import java.util.ArrayList;

class MobilePhone {
    /* Instance fields */
    private String phoneNumber;
    private ArrayList<PhoneContact> phoneContacts;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.phoneContacts = new ArrayList<PhoneContact>();

    }

    /* Instance methods */

    // Update/Modify contact
    public boolean updatePhoneContact(PhoneContact existingPhoneContact, PhoneContact newPhoneContact) {
        int existingPhoneContactFound = findPhoneContact(existingPhoneContact);
        if (existingPhoneContactFound < 0) {
            System.out.print(existingPhoneContact.getPhoneContactName() + ", has not been found.");
            return false;
        } else if(findPhoneContact(newPhoneContact.getPhoneContactName()) != -1){
            System.out.println("Contact with name " + newPhoneContact.getPhoneContactName());
            System.out.println(" Already exists. Update was not successful.");
            return false;
        }

        this.phoneContacts.set(existingPhoneContactFound, newPhoneContact);
        System.out.print(existingPhoneContact.getPhoneContactName() + ", has been replaced with " + newPhoneContact.getPhoneContactNumber());
        return true;
    }

    // Add/Store contact
    public boolean addNewPhoneContact(PhoneContact newPhoneContact) {
        if (findPhoneContact(newPhoneContact.getPhoneContactNumber()) >= 0) {
            System.out.print("Phone-contact already exist!");
            return false;
        }
        phoneContacts.add(newPhoneContact);
        return true;

    }

    // Remove/Delete contact
    public boolean removePhoneContact(PhoneContact removePhoneContact) {
        int existingPhoneContactFound = findPhoneContact(removePhoneContact);
        if (existingPhoneContactFound < 0) {
            System.out.print(removePhoneContact.getPhoneContactName() + ", phonecontact couldn't be found!");
            return false;
        }
        this.phoneContacts.remove(existingPhoneContactFound);
        return true;
    }
    // Search/Find contact by possition. (info: method overloading)
    private int findPhoneContact(PhoneContact findPhoneContactIndexOf) {

        return this.phoneContacts.indexOf(findPhoneContactIndexOf);
    }

    // Search/Find contact by name. (info: method overloading)
    private int findPhoneContact(String findPhoneContactName) {
        for (int i = 0; i < this.phoneContacts.size(); i++) {
            PhoneContact findPhoneContactNamePosition = this.phoneContacts.get(i);
            if (findPhoneContactNamePosition.getPhoneContactName().equals(findPhoneContactName)) {
                return i;
            }
        }
        return -1;
    }

    //Quering on contact
    public String queryPhoneContact(PhoneContact phoneContact){
         if(findPhoneContact(phoneContact)>=0){
            return phoneContact.getPhoneContactNumber();
         }
         return null;
    }

    // Query contact. (info: method overloading)
    public PhoneContact queryPhoneContact(String phoneContactName){
        int position = findPhoneContact(phoneContactName);
        //
        if(position >=0){
           return this.phoneContacts.get(position);
        }
        return null;
   }

    // Print/Show contact
    public void printPhoneContacts(){
        System.out.println("Phone-contacts, list.");
        for(int i =0; i < this.phoneContacts.size(); i++){
            System.out.println(i+1 + ". " + 
                                this.phoneContacts.get(i).getPhoneContactName() + " => " + 
                                this.phoneContacts.get(i).getPhoneContactNumber());
        }
    }
}

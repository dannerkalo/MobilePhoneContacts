import java.util.ArrayList;

class MobilePhone {
    /* Instance fields */
    private String phoneNumber;
    private ArrayList<PhoneContact> phoneContact;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.phoneContact = new ArrayList<PhoneContact>();

    }

    /* Instance methods */

    // Update/Modify contact
    public boolean updatePhoneContact(PhoneContact existingPhoneContact, PhoneContact newPhoneContact) {
        int existingPhoneContactFound = findPhoneContact(existingPhoneContact);
        if (existingPhoneContactFound < 0) {
            System.out.print(existingPhoneContact.getContactName() + ", has not been found.");
            return false;
        }
        System.out.print(existingPhoneContact.getContactName() + ", has been replaced with " + newPhoneContact.getContactName());
        this.phoneContact.set(existingPhoneContactFound, newPhoneContact);
        return true;
    }

    // Add/Store contact
    public boolean addNewPhoneContact(PhoneContact newPhoneContact) {
        if (findPhoneContact(newPhoneContact.getContactName()) >= 0) {
            System.out.print("Phone-contact already exist!");
            return false;
        }
        phoneContact.add(newPhoneContact);
        return true;

    }

    // Remove/Delete contact
    public boolean removePhoneContact(PhoneContact removePhoneContact) {
        int existingPhoneContactFound = findPhoneContact(removePhoneContact);
        if (existingPhoneContactFound < 0) {
            System.out.print(removePhoneContact.getContactName() + ", phonecontact couldn't be found!");
            return false;
        }
        this.phoneContact.remove(existingPhoneContactFound);
        return true;
    }
    // Search/Find contact by possition. (info: method overloading)
    private int findPhoneContact(PhoneContact findPhoneContactIndexOf) {

        return this.phoneContact.indexOf(findPhoneContactIndexOf);
    }

    // Search/Find contact by name. (info: method overloading)
    private int findPhoneContact(String findPhoneContactName) {
        for (int i = 0; i < this.phoneContact.size(); i++) {
            PhoneContact findPhoneContactNamePosition = this.phoneContact.get(i);
            if (findPhoneContactNamePosition.getContactName().equals(findPhoneContactName)) {
                return i;
            }
        }
        return -1;
    }

    //Quering on contact
    public String queryPhoneContact(PhoneContact phoneContact){
         if(findPhoneContact(phoneContact)>=0){
            return phoneContact.getPhoneNumber();
         }
         return null;
    }

    // Query contact. (info: method overloading)
    public PhoneContact queryPhoneContact(String phoneContactName){
        int position = findPhoneContact(phoneContactName);
        if(position>0){
           return this.phoneContact.get(position);
        }
        return null;
   }

    // Print/Show contact
    public void printPhoneContacts(){
        System.out.println("Phone-contacts, list.");
        for(int i =0; i < this.phoneContact.size(); i++){
            System.out.println(i+1 + ". " + 
                                this.phoneContact.get(i).getContactName() + " => " + 
                                this.phoneContact.get(i).getPhoneNumber());
        }
    }
}

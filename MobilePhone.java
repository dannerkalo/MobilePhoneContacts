import java.util.ArrayList;

class MobilePhone {
    /* Instance fields */
    private String phoneNumber;
    private ArrayList<PhoneContact> phoneContact;

    public MobilePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        this.phoneContact = new ArrayList<PhoneContact>();

    }

    public static void main(String[] args) {
        // Print App purpose
        System.out.println("Mobile Phone Contacts management APP");
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
    // Print/Show contact
}

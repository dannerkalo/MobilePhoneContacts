
class PhoneContact {
    /* Instance fields */
    private String contactName;
    private String phoneNumber;

    // Construct contact info
    public PhoneContact(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {

        return contactName;

    }

    public String getPhoneNumber() {

        return phoneNumber;

    }

    // Create contact
    public static PhoneContact createPhoneContact(String contactPhone, String contactName) {
        return new PhoneContact(contactPhone, contactName);

    }
}

class PhoneContact {
    /* Instance fields */
    private String contactName;
    private String phoneNumber;

    // Construct contact info
    public PhoneContact(String contactName, String phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneContactName() {

        return contactName;

    }

    public String getPhoneContactNumber() {

        return phoneNumber;

    }

    // Create contact
    public static PhoneContact createPhoneContact(String contactName, String contactPhone) {
        return new PhoneContact(contactName, contactPhone);

    }
}
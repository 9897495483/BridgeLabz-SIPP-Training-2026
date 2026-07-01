// File Name: AddressBookApp.java

import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name : " + name +
               "\nPhone: " + phone +
               "\nEmail: " + email;
    }
}

public class AddressBookApp {

    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, Contact> contactMap = new HashMap<>();
    HashSet<String> phoneNumbers = new HashSet<>();

    // Add Contact
    public void addContact(String name, String phone, String email) {

        if (phoneNumbers.contains(phone)) {
            System.out.println("Duplicate phone number! Contact not added.");
            return;
        }

        Contact contact = new Contact(name, phone, email);

        contacts.add(contact);
        contactMap.put(name, contact);
        phoneNumbers.add(phone);

        System.out.println(name + " added successfully.\n");
    }

    // Search Contact
    public void searchContact(String name) {

        Contact contact = contactMap.get(name);

        if (contact != null) {
            System.out.println("Contact Found");
            System.out.println(contact);
        } else {
            System.out.println("Contact not found.");
        }

        System.out.println();
    }

    // Delete Contact
    public void deleteContact(String name) {

        Contact contact = contactMap.remove(name);

        if (contact != null) {

            contacts.remove(contact);
            phoneNumbers.remove(contact.phone);

            System.out.println(name + " deleted successfully.\n");
        } else {
            System.out.println("Contact not found.\n");
        }
    }

    // Display Contacts
    public void displayContacts() {

        Collections.sort(contacts, new Comparator<Contact>() {

            @Override
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });

        System.out.println("===== Address Book =====");

        for (Contact contact : contacts) {
            System.out.println(contact);
            System.out.println("------------------------");
        }
    }

    public static void main(String[] args) {

        AddressBookApp app = new AddressBookApp();

        app.addContact("Rahul", "9876543210", "rahul@gmail.com");
        app.addContact("Amit", "9123456789", "amit@gmail.com");
        app.addContact("Neha", "9988776655", "neha@gmail.com");

        // Duplicate phone number
        app.addContact("Riya", "9876543210", "riya@gmail.com");

        app.searchContact("Amit");

        app.deleteContact("Neha");

        app.displayContacts();
    }
}
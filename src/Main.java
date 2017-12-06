import util.Input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Input inp = new Input();
    public static String directory = "./";
    public static String fileName = "contacts.txt";
    public static Path dataFile;

    public static void enterToContinue() {
        inp.getNewLine();
        inp.getNewLine("Press Enter to continue");
    }

    public static void initializeFile() {
        dataFile = Paths.get(directory, fileName);

        if(!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                System.out.println("Create File IO Error Message: "+e.getMessage());
            } catch (Exception e) {
                System.out.println("Create File Other Exception: "+e.getMessage());
            }
        }
    }

    public static ArrayList<String> toArrayList() {
        List<String> lines;
        ArrayList<String> newList = new ArrayList<>();
        try {
            lines = Files.readAllLines(dataFile);
            for(String line : lines) {
                newList.add(line);
            }
        } catch (Exception e) {
            System.out.println("Read All Lines Error: "+e.getMessage());
        }
        return newList;
    }

    public static void toFile(ArrayList<String> al) {
        try {
            Files.write(dataFile, al);
        } catch (IOException e) {
            System.out.println("Write to File IO Error Message: "+e.getMessage());
        } catch (Exception e) {
            System.out.println("Write to File Other Exception: "+e.getMessage());
        }
    }

    public static void viewContacts() {
        ArrayList<String> al = toArrayList();
        int i = 0;
        for(String data : al) {
            System.out.println(i+")");
            Contact.toContact(data).prettyPrint();
            System.out.println("");
            i++;
        }
        enterToContinue();
    }

    public static void addContact() {
        String fname = inp.getAlphaString("Enter Contact First Name:");
        String lname = inp.getAlphaString("Enter Contact Last Name:");
        String phoneNumber;
        do {
            phoneNumber = inp.getNumString("Enter a 10 Digit Contact Phone Number Starting with Your Area Code:");
        } while(phoneNumber.length() > 10 || phoneNumber.length() < 10);
        Contact newContact = new Contact(fname, lname, phoneNumber);
        ArrayList<String> al = toArrayList();
        for(String item : al) {
            if(Contact.toContact(item).getFirstname().equals(fname) && Contact.toContact(item).getLastname().equals(lname) && Contact.toContact(item).getPhoneNumber().equals(phoneNumber)) {
                System.out.println("The Contact "+fname+" "+lname+" with the number "+phoneNumber+" already exists. ");
                enterToContinue();
                return;
            }
        }
        al.add(Contact.toString(newContact));
        toFile(al);
    }

    public static void editContact() {
        ArrayList<String> al = toArrayList();
        int i = 0;
        for(String data : al) {
            System.out.println(i+") "+Contact.toContact(data).getName());
            i++;
        }
        int userInputIndex = inp.getInt(0,i-1,"Enter the index number of the contact you would like to edit:");
        Contact contactPlaceholder = Contact.toContact(al.get(userInputIndex));
        contactPlaceholder.prettyPrint();
        int resp = inp.getInt(0,2,"What would you like to edit?\n0) First Name\n1) Last Name\n2) Phone Number");
        switch(resp) {
            case 0:
                contactPlaceholder.setFirstname(inp.getAlphaString("Enter a new first name:"));
                break;
            case 1:
                contactPlaceholder.setLastname(inp.getAlphaString("Enter a new last name"));
                break;
            case 2:
                contactPlaceholder.setPhoneNumber(inp.getNumString("Enter a new number"));
                break;
            default:
                editContact();
                break;
        }
        al.set(userInputIndex, Contact.toString(contactPlaceholder));
        toFile(al);
    }

    public static void searchContact() {
        ArrayList<String> al = toArrayList();
        ArrayList<String> retStr = new ArrayList<>();
        String userInput = inp.getAlphaString("Enter the name/number you would like to search");
        for(String item : al) {
            if(item.toLowerCase().contains(userInput.toLowerCase())) {
                retStr.add(item);
            }
        }
        if(retStr.size() == 0) {
            inp.getNewLine("No Matching Contacts Found That Contain \""+userInput+"\"...\nEnter Any Key To Continue");
        } else {
            for(String contact : retStr) {
                Contact.toContact(contact).prettyPrint();
            }
        }
    }

    public static void deleteContact() {
        ArrayList<String> al = toArrayList();
        int i = 0;
        for(String data : al) {
            System.out.println(i+") "+Contact.toContact(data).getName());
            i++;
        }
        System.out.println(i+") *Cancel*");
        int resp = inp.getInt(0,i,"Enter the index number of the contact you would like to delete");
        if(resp != i) {
            System.out.println("*************** REMOVED ***************");
            Contact.toContact(al.get(resp)).prettyPrint();
            al.remove(resp);
            toFile(al);
        }
    }

    public static void mainMenu() {
        initializeFile();

        System.out.println(
                "1. View contacts.\n" +
                "2. Search a contact by name.\n" +
                "3. Add a new contact.\n" +
                "4. Edit an existing contact.\n" +
                "5. Delete an existing contact.\n" +
                "6. Exit."
        );
        switch(inp.getInt(1,6,"Enter an option (1, 2, 3, 4 or 5):")) {
            case 1:
                viewContacts();
                mainMenu();
                break;
            case 2:
                searchContact();
                mainMenu();
                break;
            case 3:
                addContact();
                mainMenu();
                break;
            case 4:
                editContact();
                mainMenu();
                break;
            case 5:
                deleteContact();
                mainMenu();
                break;
            case 6:
                break;
            default:
                mainMenu();
        }
    }

    public static void main(String[] args) {
        mainMenu();
    }
}

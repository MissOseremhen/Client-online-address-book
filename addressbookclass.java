import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class AddressBook {
    private ArrayList<Entry> entries;

    public AddressBook() {
        entries = new ArrayList<>();
    }


    public void addEntry(Entry entry) {
        entries.add(entry);
        System.out.println("Added new entry!");
    }

    public void removeEntry(String emailAddress) {
        Iterator<Entry> iterator = entries.iterator();
        boolean entryFound = false;

        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.getEmailAddress().equals(emailAddress)) {
                iterator.remove();
                System.out.println("Deleted the following entry:\n" + entry);
                entryFound = true;
                break;
            }
        }

        if (!entryFound) {
            System.out.println("Entry not found!");
        }
    }

  
    public ArrayList<Entry> searchEntries(String searchType, String searchTerm) {
        ArrayList<Entry> searchResults = new ArrayList<>();

        switch (searchType) {
            case "1":
                for (Entry entry : entries) {
                    if (entry.getFirstName().contains(searchTerm)) {
                        searchResults.add(entry);
                    }
                }
                break;
            case "2":
                for (Entry entry : entries) {
                    if (entry.getLastName().contains(searchTerm)) {
                        searchResults.add(entry);
                    }
                }
                break;
            case "3":
                for (Entry entry : entries) {
                    if (entry.getPhoneNumber().contains(searchTerm)) {
                        searchResults.add(entry);
                    }
                }
                break;
            case "4":
                for (Entry entry : entries) {
                    if (entry.getEmailAddress().contains(searchTerm)) {
                        searchResults.add(entry);
                    }
                }
                break;
            default:
                System.out.println("Invalid search option.");
                break;
        }

        return searchResults;
    }

    public void printAddressBook() {
        if (entries.isEmpty()) {
            System.out.println("Address Book is empty!");
        } else {
            for (Entry entry : entries) {
                System.out.println("************");
                System.out.println(entry);
                System.out.println("************");
            }
        }
    }

    public void deleteBook() {
        entries.clear();
        System.out.println("Address book cleared!");
    }
}

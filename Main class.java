import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1) Add an Entry");
            System.out.println("2) Remove an Entry");
            System.out.println("3) Search for a Specific Entry");
            System.out.println("4) Print Address Book");
            System.out.println("5) Delete Book");
            System.out.println("6) Quit");
            System.out.print("Please choose what you'd like to do with the database: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Implement code to add an entry
                    System.out.print("First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Email Address: ");
                    String emailAddress = scanner.nextLine();

                    Entry newEntry = new Entry(firstName, lastName, phoneNumber, emailAddress);
                    addressBook.addEntry(newEntry);
                    break;

                case 2:
                    // Implement code to remove an entry
                    System.out.print("Enter an entry's email to remove: ");
                    String emailToRemove = scanner.nextLine();
                    addressBook.removeEntry(emailToRemove);
                    break;

                case 3:
                    // Implement code to search for an entry
                    System.out.println("1) First Name");
                    System.out.println("2) Last Name");
                    System.out.println("3) Phone Number");
                    System.out.println("4) Email Address");
                    System.out.print("Choose a search type: ");
                    String searchType = scanner.nextLine();
                    System.out.print("Enter your search: ");
                    String searchTerm = scanner.nextLine();

                    ArrayList<Entry> searchResults = addressBook.searchEntries(searchType, searchTerm);
                    if (searchResults.isEmpty()) {
                        System.out.println("No results found!");
                    } else {
                        for (Entry entry : searchResults) {
                            System.out.println(entry);
                        }
                    }
                    break;

                case 4:
                    // Implement code to print the address book
                    addressBook.printAddressBook();
                    break;

                case 5:
                    // Implement code to delete the address book
                    addressBook.deleteBook();
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid input. Please choose a valid option.");
                    break;
            }
        }
    }
}

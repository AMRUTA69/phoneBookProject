import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      📞 PHONE BOOK APPLICATION");
        System.out.println("========================================");

        boolean running = true;

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. List All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter phone number (10 digits): ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    phoneBook.addContact(phone, name);
                    break;

                case "2":
                    System.out.print("Enter phone number to search: ");
                    String searchPhone = scanner.nextLine();
                    phoneBook.searchContact(searchPhone);
                    break;

                case "3":
                    System.out.print("Enter phone number to delete: ");
                    String delPhone = scanner.nextLine();
                    phoneBook.deleteContact(delPhone);
                    break;

                case "4":
                    phoneBook.listContacts();
                    break;

                case "5":
                    running = false;
                    System.out.println("👋 Goodbye!");
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1-5.");
            }
        }

        scanner.close();
    }
}

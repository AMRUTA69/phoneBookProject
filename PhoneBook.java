import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    // HashMap: key = phone number, value = contact name
    private HashMap<String, String> contacts;

    public PhoneBook() {
        contacts = new HashMap<>();
    }

    // ---------- Add Contact (with duplicate check) ----------
    public void addContact(String phone, String name) {
        // Validation
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("❌ Error: Phone number cannot be empty.");
            return;
        }
        if (name == null || name.trim().isEmpty()) {
            System.out.println("❌ Error: Name cannot be empty.");
            return;
        }
        if (!phone.matches("\\d{10}")) {
            System.out.println("❌ Error: Phone number must be exactly 10 digits.");
            return;
        }

        phone = phone.trim();
        name = name.trim();

        // Duplicate key handling
        if (contacts.containsKey(phone)) {
            System.out.println("⚠ Duplicate phone number! Existing contact: "
                    + contacts.get(phone));
            System.out.print("Do you want to overwrite? (yes/no): ");
            // Main se confirm input milega — simple version mein overwrite maan lete hain
            // Yahan hum directly overwrite kar dete hain with a message
            contacts.put(phone, name);
            System.out.println("✔ Contact updated: " + name + " (" + phone + ")");
        } else {
            contacts.put(phone, name);
            System.out.println("✔ Contact added: " + name + " (" + phone + ")");
        }
    }

    // ---------- Search Contact ----------
    public void searchContact(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("❌ Error: Phone number cannot be empty.");
            return;
        }
        phone = phone.trim();

        if (contacts.containsKey(phone)) {
            System.out.println("🔍 Found: " + contacts.get(phone) + " (" + phone + ")");
        } else {
            System.out.println("❌ No contact found for phone number: " + phone);
        }
    }

    // ---------- Delete Contact ----------
    public void deleteContact(String phone) {
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("❌ Error: Phone number cannot be empty.");
            return;
        }
        phone = phone.trim();

        if (contacts.containsKey(phone)) {
            String removedName = contacts.remove(phone);
            System.out.println("🗑 Deleted: " + removedName + " (" + phone + ")");
        } else {
            System.out.println("❌ No contact found with phone number: " + phone);
        }
    }

    // ---------- List All Contacts ----------
    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("📭 PhoneBook is empty.");
            return;
        }
        System.out.println("\n--- All Contacts (" + contacts.size() + ") ---");
        int i = 1;
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(i + ". " + entry.getValue() + " → " + entry.getKey());
            i++;
        }
    }

    // ---------- Helper ----------
    public int getContactCount() {
        return contacts.size();
    }
}


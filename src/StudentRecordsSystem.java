import java.util.Scanner;

/**
 * Class representing a student record.
 */
class StudentRecord {
    String name;
    String studentID;
    String email;

    public StudentRecord(String name, String studentID, String email) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
    }

    // Return a formatted string as specified in the assignment.
    public String toString() {
        return name + ", " + studentID + ", " + email;
    }
}

/**
 * Node class for the Binary Search Tree.
 */
class BSTNode {
    StudentRecord record;
    BSTNode left;
    BSTNode right;

    public BSTNode(StudentRecord record) {
        this.record = record;
        this.left = null;
        this.right = null;
    }
}

/**
 * Binary Search Tree class.
 * NOTE: For simplicity, this skeleton does not differentiate between
 * BST keyed by name or student ID. You may create two separate instances
 * keyed on different fields or extend this class accordingly.
 */
class BST {
    BSTNode root;

    public BST() {
        root = null;
    }

    // TODO: Implement insertion based on a chosen key (name or studentID)
    public void insert(StudentRecord record, boolean keyByName) {
        // Use 'keyByName' to decide whether to compare using record.name or record.studentID
        // If input is invalid or duplicate, handle accordingly.
        // Insert into the BST and maintain BST properties.
    }

    // TODO: Implement search by key (name or studentID)
    public StudentRecord search(String key, boolean keyByName) {
        // Traverse the BST using the chosen key.
        // Return the found record, or null if not found.
        return null;
    }

    // TODO: Implement deletion by key (name)
    public boolean delete(String name) {
        // Delete the node with the matching student name.
        // Return true if deletion was successful, or false if not found.
        return false;
    }

    // TODO: Implement update of student ID for a given student name.
    public boolean update(String name, String newStudentID) {
        // Locate the record by name.
        // Validate newStudentID (must be numeric).
        // Update the record's studentID and adjust the BST if necessary.
        // Return true if update was successful, false otherwise.
        return false;
    }

    // TODO: Implement an in-order traversal to display all student records
    public void inOrderTraversal() {
        // Print the header exactly as specified:
        // "Displaying all records:"
        // "Name            | Student ID | Email"
        // "--------------------------------------------"
        System.out.println("Displaying all records:");
        System.out.println("Name            | Student ID | Email");
        System.out.println("--------------------------------------------");
        // Traverse the BST and for each node, print:
        // "<Name>   | <Student ID> | <Email>"
    }
}

/**
 * Main class to drive the Student Records System.
 */
public class StudentRecordsSystem {

    // Create two BST instances:
    // one for records keyed by name, and one for records keyed by studentID.
    static BST bstByName = new BST();
    static BST bstByID = new BST();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Display the main menu exactly once at startup.
        printMainMenu();

        while (!exit) {
            // Prompt the user for choice using the exact prompt.
            System.out.print("> ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    insertRecord(scanner);
                    break;
                case "2":
                    searchRecord(scanner);
                    break;
                case "3":
                    deleteRecord(scanner);
                    break;
                case "4":
                    updateRecord(scanner);
                    break;
                case "5":
                    displayRecords();
                    break;
                case "6":
                    System.out.println("Exiting the application.");
                    exit = true;
                    break;
                default:
                    // You may print an error message or simply re-display the menu.
                    break;
            }
            // After completing an operation (except exit), re-display the menu.
            if (!exit) {
                printMainMenu();
            }
        }
        scanner.close();
    }

    /**
     * Prints the main menu exactly as specified.
     */
    public static void printMainMenu() {
        System.out.println("Student Records System Menu:");
        System.out.println("1. Insert a new student record");
        System.out.println("2. Search for a student record");
        System.out.println("3. Delete a student record");
        System.out.println("4. Update a student record");
        System.out.println("5. Display all student records");
        System.out.println("6. Exit the application");
    }

    /**
     * Handles the insertion of a new student record.
     */
    public static void insertRecord(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter student ID: ");
        String studentID = scanner.nextLine().trim();

        System.out.print("Enter email address: ");
        String email = scanner.nextLine().trim();

        // Validate student ID and email.
        if (!studentID.matches("\\d+") || !email.contains("@") || !email.contains(".")) {
            System.out.println("Invalid input. Record not inserted.");
            return;
        }

        StudentRecord record = new StudentRecord(name, studentID, email);

        // TODO: Insert into both BSTs. For bstByName, use name as key;
        // for bstByID, use studentID as key.
        bstByName.insert(record, true);  // keyByName = true
        bstByID.insert(record, false);   // keyByName = false

        System.out.println("Record inserted successfully.");
    }

    /**
     * Handles the searching of a student record.
     */
    public static void searchRecord(Scanner scanner) {
        // Display the search sub-menu exactly as specified.
        System.out.println("Search by:");
        System.out.println("a. Name");
        System.out.println("b. Student ID");
        System.out.println("c. Email");
        System.out.print("> ");
        String subChoice = scanner.nextLine().trim();

        StudentRecord result = null;
        String key = "";
        switch (subChoice) {
            case "a":
                System.out.println("Enter student name to search:");
                key = scanner.nextLine().trim();
                // For search by name, use bstByName.
                result = bstByName.search(key, true);
                break;
            case "b":
                System.out.println("Enter student ID to search:");
                key = scanner.nextLine().trim();
                // For search by student ID, use bstByID.
                result = bstByID.search(key, false);
                break;
            case "c":
                System.out.println("Enter email to search:");
                key = scanner.nextLine().trim();
                // TODO: For search by email, perform a linear search.
                // For now, assume a method exists (implement it yourself).
                result = searchByEmail(key);
                break;
            default:
                // If the sub-choice is invalid, you may choose to do nothing.
                break;
        }

        if (result != null) {
            System.out.println("Record found: " + result.toString());
        } else {
            System.out.println("Record not found.");
        }
    }

    /**
     * Linear search for a student record by email.
     * TODO: Implement this method to search through one of the BSTs or a separate list.
     */
    public static StudentRecord searchByEmail(String email) {
        // For a simple implementation, you could perform an in-order traversal
        // of one of the BSTs and compare each record's email.
        // Return the matching StudentRecord or null if not found.
        return null;
    }

    /**
     * Handles the deletion of a student record by name.
     */
    public static void deleteRecord(Scanner scanner) {
        System.out.println("Enter student name to delete:");
        String name = scanner.nextLine().trim();

        // TODO: Delete from bstByName first.
        boolean deletedFromName = bstByName.delete(name);

        // TODO: Also delete from bstByID. You may need to search for the record first to get the studentID.
        boolean deletedFromID = false;
        // Example:
        // StudentRecord record = bstByName.search(name, true);
        // if(record != null) {
        //     deletedFromID = bstByID.delete(record.studentID); // You may need to implement deletion by ID
        // }

        // For now, assume deletion is successful if deleted from bstByName.
        if (deletedFromName) {
            System.out.println("Record deleted successfully.");
        } else {
            System.out.println("Record not found. Deletion failed.");
        }
    }

    /**
     * Handles updating a student record's student ID.
     */
    public static void updateRecord(Scanner scanner) {
        System.out.println("Enter student name to update:");
        String name = scanner.nextLine().trim();

        System.out.println("Enter new student ID:");
        String newStudentID = scanner.nextLine().trim();

        // Validate new student ID.
        if (!newStudentID.matches("\\d+")) {
            System.out.println("Update failed.");
            return;
        }

        // TODO: Update the record in bstByName and bstByID.
        boolean updated = bstByName.update(name, newStudentID);
        // You must also update bstByID accordingly.
        if (updated) {
            System.out.println("Record updated successfully.");
        } else {
            System.out.println("Update failed.");
        }
    }

    /**
     * Displays all student records in sorted order by name.
     */
    public static void displayRecords() {
        // Use the inOrderTraversal method of bstByName to display all records.
        bstByName.inOrderTraversal();
    }
}


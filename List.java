import java.util.Scanner;
import java.util.ArrayList;

public class List {
    Scanner sc = new Scanner(System.in);
    ArrayList<String> notes = new ArrayList<>();
    
    // ! Choose method to display options and handle user input
    // ! This method allows the user to choose between Notes and Todo
    // ! It also provides an option to exit the application
    public void Choose() {
        while (true) {
            System.out.println("Choose an Option");
            System.out.println("1.Creates/View Notes");
            System.out.println("2.Exit");
            System.out.println("------------------");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You chose Notes");
                    Notes();
                    break;

                case 2:
                    System.out.println("Exiting...");
                    System.exit(0); // Exit the application
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    Choose();
                    break;
            }
        }
    }

    // ! Notes method to handle Note operations
    public void Notes() {
        while (true) {
            System.out.println("------------------");
            System.out.println("1.Create Note +\n" + "2.View Notes\n" + "3.Delete Note\n" + "4.Back to Main Menu");
            System.out.println("------------------");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("New Note");
                    Createnote();
                    break;

                case 2:
                    System.out.println("View Notes");
                    ViewNotes();
                    break;

                case 3:
                    System.out.println("Delete Note");
                    Deletenote();
                    break;

                case 4:
                    System.out.println("Returning to Main Menu");
                    return; // Return to main menu
            }
        }
    }

    // ! Create a new Note
    public void Createnote() {
        System.out.println("Create a new note");
        sc.nextLine(); // Consume the newline character left by nextInt()
        String note = sc.nextLine();
        notes.add(note);
        System.out.println("Note created: " + note);
    }

    // ! View all Notes
    public void ViewNotes() {
        System.out.println("Viewing all notes:");
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i)); // Display notes with 1-based index
            }
        }
    }

    // ! Method for Delete a Note in Application
    public void Deletenote() {
        if (notes.isEmpty()) {
            System.out.println("No notes to delete.");
            return; // Exit if there are no notes
        }
        System.out.println("---- Notes ----");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i)); // Display notes with 1-based index
        }
        System.out.print("Enter the note number to delete: ");
        int index = sc.nextInt();
        sc.nextLine(); // consume newline
        if (index >= 1 && index <= notes.size()) {
            String removed = notes.remove(index - 1); // convert to 0-based index
            System.out.println("Note deleted: " + removed);
        } else {
            System.out.println("Invalid number.");
        }
    }
}
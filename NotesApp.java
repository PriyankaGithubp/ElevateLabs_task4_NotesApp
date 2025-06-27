package Task4;
import java.io.*;
import java.util.Scanner;
public class NotesApp {
	
	    private static final String FILE_NAME = "notes.txt";

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        do {
	            System.out.println("\n===== Notes App Menu =====");
	            System.out.println("1. Write a new note (overwrite)");
	            System.out.println("2. Append a note");
	            System.out.println("3. View all notes");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice (1-4): ");

	            choice = scanner.nextInt();
	            scanner.nextLine(); // consume newline

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter your note: ");
	                    String newNote = scanner.nextLine();
	                    writeNote(newNote, false);
	                    break;
	                case 2:
	                    System.out.print("Enter your note: ");
	                    String appendNote = scanner.nextLine();
	                    writeNote(appendNote, true);
	                    break;
	                case 3:
	                    readNotes();
	                    break;
	                case 4:
	                    System.out.println("Exiting the Notes App. Bye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Try again.");
	            }
	        } while (choice != 4);

	        scanner.close();
	    }

	    // Method to write or append note
	    private static void writeNote(String note, boolean append) {
	        try (FileWriter writer = new FileWriter(FILE_NAME, append)) {
	            writer.write(note + "\n");
	            System.out.println("Note saved successfully.");
	        } catch (IOException e) {
	            System.out.println("Error writing note: " + e.getMessage());
	        }
	    }

	    // Method to read and display all notes
	    private static void readNotes() {
	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
	            String line;
	            System.out.println("\n===== Your Notes =====");
	            while ((line = reader.readLine()) != null) {
	                System.out.println(line);
	            }
	            System.out.println("======================");
	        } catch (FileNotFoundException e) {
	            System.out.println("No notes found. Start writing some!");
	        } catch (IOException e) {
	            System.out.println("Error reading notes: " + e.getMessage());
	        }
	    }
	}



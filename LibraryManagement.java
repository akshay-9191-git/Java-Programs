import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean available;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    static Book inputBook(Scanner sc) {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        return new Book(id, title, author);
    }

    void issueBook() {
        if (available) {
            available = false;
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    void returnBook() {
        if (!available) {
            available = true;
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book was not issued.");
        }
    }

    void displayBook() {
        System.out.println("Book Details");
        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);

        if (available)
            System.out.println("Status: Available");
        else
            System.out.println("Status: Issued");
    }
}

public class LibraryManagement {
    static void runLibrary(Book book) {

        book.displayBook();

        System.out.println("\nIssuing book.");
        book.issueBook();

        book.displayBook();

        System.out.println("\nTrying to issue again.");
        book.issueBook();

        System.out.println("\nReturning book.");
        book.returnBook();

        book.displayBook();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Book book = Book.inputBook(sc);

        runLibrary(book);

        sc.close();
    }
}
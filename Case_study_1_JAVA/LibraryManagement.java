class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public void issueBook() {
        if (available) {
            available = false;
            System.out.println("'" + title + "' issued successfully.");
        } else {
            System.out.println("Sorry, '" + title + "' is already issued.");
        }
    }

    public void returnBook() {
        if (!available) {
            available = true;
            System.out.println("'" + title + "' returned successfully.");
        } else {
            System.out.println("'" + title + "' was not issued.");
        }
    }

    public void displayBook() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Status  : " + (available ? "Available" : "Issued"));
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Book b1 = new Book(101, "Head First Java", "Kathy Sierra");
        Book b2 = new Book(102, "Clean Code", "Robert C. Martin");

        b1.displayBook();
        b1.issueBook();
        b1.issueBook();   // already issued
        b1.displayBook();
        b1.returnBook();

        System.out.println();
        b2.displayBook();
    }
}

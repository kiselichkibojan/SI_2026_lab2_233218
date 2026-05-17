package mk.ukim.finki.wp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SI2026Lab2Test {

    @Test
    public void searchBookEveryStatementTest() {

        Library library = new Library();

        Book book1 = new Book("Clean Code", "Robert Martin", "Programming");
        Book book2 = new Book("Harry Potter", "Rowling", "Fantasy");

        library.addBook(book1);
        library.addBook(book2);

        // TEST 1
        List<Book> result = library.searchBookByTitle("Clean Code");

        assertNotNull(result);
        assertEquals(1, result.size());

        // TEST 2
        List<Book> result2 = library.searchBookByTitle("Unknown");

        assertNull(result2);

        // TEST 3
        assertThrows(IllegalArgumentException.class, () -> {
            library.searchBookByTitle("");
        });
    }
    @Test
    public void borrowBookEveryBranchTest() {

        // TEST 1 -> invalid input
        Library library1 = new Library();

        assertThrows(IllegalArgumentException.class, () -> {
            library1.borrowBook("", "");
        });

        // TEST 2 -> successful borrow
        Library library2 = new Library();

        Book book1 = new Book("Clean Code", "Robert Martin", "Programming");

        library2.addBook(book1);

        library2.borrowBook("Clean Code", "Robert Martin");

        assertTrue(book1.isBorrowed());

        // TEST 3 -> already borrowed
        Library library3 = new Library();

        Book book2 = new Book("Java", "James", "Programming");

        book2.setBorrowed(true);

        library3.addBook(book2);

        assertThrows(RuntimeException.class, () -> {
            library3.borrowBook("Java", "James");
        });

        // TEST 4 -> book not found
        Library library4 = new Library();

        assertThrows(RuntimeException.class, () -> {
            library4.borrowBook("Unknown", "Unknown");
        });
    }
    @Test
    public void borrowBookMultipleConditionTest() {

        Library library = new Library();

        // T T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "");
        });

        // T F
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("", "Author");
        });

        // F T
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("Book", "");
        });

        // F F
        assertThrows(RuntimeException.class, () -> {
            library.borrowBook("Book", "Author");
        });
    }
    @Test
    public void searchBookMultipleConditionTest() {

        // T T
        Library library1 = new Library();

        Book book1 = new Book("Clean Code", "Martin", "Programming");

        library1.addBook(book1);

        assertNotNull(library1.searchBookByTitle("Clean Code"));

        // T F
        Library library2 = new Library();

        Book book2 = new Book("Clean Code", "Martin", "Programming");

        book2.setBorrowed(true);

        library2.addBook(book2);

        assertNull(library2.searchBookByTitle("Clean Code"));

        // F T
        Library library3 = new Library();

        Book book3 = new Book("Java", "James", "Programming");

        library3.addBook(book3);

        assertNull(library3.searchBookByTitle("Python"));

        // F F
        Library library4 = new Library();

        Book book4 = new Book("Java", "James", "Programming");

        book4.setBorrowed(true);

        library4.addBook(book4);

        assertNull(library4.searchBookByTitle("Python"));
    }
}
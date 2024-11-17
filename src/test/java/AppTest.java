import org.example.Book;
import org.example.BookCollection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private BookCollection bookCollection;

    @BeforeEach
    void setUp() {
        bookCollection = new BookCollection();

        bookCollection.addBook(new Book("Title1", "Author1", "Fiction", 2020));
        bookCollection.addBook(new Book("Title2", "Author2", "Fantasy", 2019));
        bookCollection.addBook(new Book("Title3", "Author1", "Fiction", 2021));
        bookCollection.addBook(new Book("Title4", "Author3", "Mystery", 2020));
    }

    @Test
    void testAddBook() {
        Book book = new Book("NewTitle", "NewAuthor", "Sci-Fi", 2022);
        bookCollection.addBook(book);

        List<Book> result = bookCollection.createSubCollectionByGenre("Sci-Fi");
        assertEquals(1, result.size());
        assertEquals("NewTitle", result.get(0).getTitle());
    }

    @Test
    void testPrintAuthors() {
        assertDoesNotThrow(() -> bookCollection.printAuthors());
    }

    @Test
    void testPrintAuthorsByGenre() {
        assertDoesNotThrow(() -> bookCollection.printAuthorsByGenre("Fiction"));
    }

    @Test
    void testFindBookByAuthor() {
        assertDoesNotThrow(() -> bookCollection.findBookByAuthor("Author1"));
    }

    @Test
    void testFindBooksByYear() {
        assertDoesNotThrow(() -> bookCollection.findBooksByYear(2020));
    }

    @Test
    void testFindBooksByGenre() {
        assertDoesNotThrow(() -> bookCollection.findBooksByGenre("Fantasy"));
    }

    @Test
    void testRemoveBooksByAuthor() {
        bookCollection.removeBooksByAuthor("Author1");
        assertTrue(bookCollection.createSubCollectionByGenre("Fiction").isEmpty());
    }

    @Test
    void testSortByCriterionTitle() {
        bookCollection.sortByCriterion("title");
        List<Book> books = bookCollection.createSubCollectionByGenre("Fiction");
        assertEquals("Title1", books.get(0).getTitle());
    }

    @Test
    void testMergeCollections() { BookCollection otherCollection = new BookCollection();
        otherCollection.addBook(new Book("ExtraTitle", "ExtraAuthor", "Horror", 2023));

        bookCollection.mergeCollections(otherCollection);

        List<Book> horrorBooks = bookCollection.createSubCollectionByGenre("Horror");
        assertEquals(1, horrorBooks.size());
        assertEquals("ExtraTitle", horrorBooks.get(0).getTitle());
    }

    @Test
    void testCreateSubCollectionByGenre() {
        List<Book> result = bookCollection.createSubCollectionByGenre("Mystery");
        assertEquals(1, result.size());
        assertEquals("Title4", result.get(0).getTitle());
    }

    @Test
    void testFindBooksByInvalidYear() {
        List<Book> result = bookCollection.createSubCollectionByGenre("Nonexistent");
        assertTrue(result.isEmpty());
    }

    @Test
    void testFindBooksByInvalidAuthor() {
        assertDoesNotThrow(() -> bookCollection.findBookByAuthor("UnknownAuthor"));
    }

    @Test
    void testSortByInvalidCriterion() {
        bookCollection.sortByCriterion("invalidCriterion");
        List<Book> books = bookCollection.createSubCollectionByGenre("Fiction");
        assertEquals("Title1", books.get(0).getTitle());
    }

}

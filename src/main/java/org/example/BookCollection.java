package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookCollection {
    private List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAuthors() {
        books.stream()
                .map(book -> book.getAuthor())
                .distinct()
                .sorted()
                .forEach(x -> System.out.println(x));
    }

    public void printAuthorsByGenre(String genre) {
        books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .map(book1 -> book1.getAuthor())
                .distinct()
                .sorted()
                .forEach(x -> System.out.println(x));
    }

    public void printAuthorsByYear(int year) {
        books.stream()
                .filter(book -> book.getYear() == year)
                .map(book1 -> book1.getAuthor())
                .distinct()
                .sorted()
                .forEach(x -> System.out.println(x));
    }

    public void findBookByAuthor(String author) {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        foundBooks.forEach(x -> System.out.println(x));
    }

    public void findBooksByYear(int year) {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getYear() == year)
                .collect(Collectors.toList());

        foundBooks.forEach(x -> System.out.println(x));
    }

    public void findBooksByGenre(String genre) {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());

        foundBooks.forEach(x -> System.out.println(x));
    }

    public void removeBooksByAuthor(String author) {
        books.removeIf(book -> book.getAuthor().equalsIgnoreCase(author));
    }

    public void sortByCriterion(String criterion) {
        Comparator<Book> comparator;

        if (criterion.equalsIgnoreCase("title")) {
            comparator = Comparator.comparing(book -> book.getTitle());
        } else if (criterion.equalsIgnoreCase("author")) {
            comparator = Comparator.comparing(book -> book.getAuthor());
        } else if (criterion.equalsIgnoreCase("year")) {
            comparator = Comparator.comparingInt(book -> book.getYear());
        } else {
            System.out.println("Invalid criterion. Sorting by title by default.");
            comparator = Comparator.comparing(book -> book.getTitle());
        }

        Collections.sort(books, comparator);
    }

    public void mergeCollections(BookCollection otherCollection) {
        this.books.addAll(otherCollection.books);
    }

    public List<Book> createSubCollectionByGenre(String genre) {
        return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .collect(Collectors.toList());
    }

    public void printAllBooks() {
        books.forEach(x -> System.out.println(x));
    }
}

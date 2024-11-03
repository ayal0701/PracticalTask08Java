package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookCollection bookCollection = new BookCollection();

        bookCollection.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 1925));
        bookCollection.addBook(new Book("1984", "George Orwell", "Dystopian", 1949));
        bookCollection.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "Fiction", 1960));
        bookCollection.addBook(new Book("Moby Dick", "Herman Melville", "Fiction", 1851));
        bookCollection.addBook(new Book("Brave New World", "Aldous Huxley", "Dystopian", 1932));
        bookCollection.addBook(new Book("The Road", "Cormac McCarthy", "Post-apocalyptic", 2006));
        bookCollection.addBook(new Book("The Night Circus", "Erin Morgenstern", "Fantasy", 2011));
        bookCollection.addBook(new Book("The Underground Railroad", "Colson Whitehead", "Historical Fiction", 2016));
        bookCollection.addBook(new Book("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", "Fiction", 2017));
        bookCollection.addBook(new Book("The Light We Lost", "Jill Santopolo", "Contemporary Fiction", 2017));
        bookCollection.addBook(new Book("A Gentleman in Moscow", "Amor Towles", "Historical Fiction", 2016));
        bookCollection.addBook(new Book("Where the Crawdads Sing", "Delia Owens", "Mystery/Drama", 2018));
        bookCollection.addBook(new Book("Circe", "Madeline Miller", "Fantasy/Mythology", 2018));
        bookCollection.addBook(new Book("The Vanishing Half", "Brit Bennett", "Fiction", 2020));
        bookCollection.addBook(new Book("The Midnight Library", "Matt Haig", "Fiction", 2020));

        boolean running = true;
        while (running) {
            System.out.println("\n==================Choose an operation==================");
            System.out.println("1. Print list of authors");
            System.out.println("2. List authors by genre");
            System.out.println("3. List authors by publication year");
            System.out.println("4. Find book by author");
            System.out.println("5. Find books by publication year");
            System.out.println("6. Find books by genre");
            System.out.println("7. Remove books by author");
            System.out.println("8. Sort collection by criterion");
            System.out.println("9. Merge book collections");
            System.out.println("10. Create a subcollection of books by genre");
            System.out.println("11. Print all books");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("List of Authors:");
                    bookCollection.printAuthors();
                    break;
                case 2:
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.println("Authors in genre " + genre + ":");
                    bookCollection.printAuthorsByGenre(genre);
                    break;
                case 3:
                    System.out.print("Enter publication year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.println("Authors who published in " + year + ":");
                    bookCollection.printAuthorsByYear(year);
                    break;
                case 4:
                    System.out.print("Enter author name: ");
                    String authorToFind = scanner.nextLine();
                    System.out.println("Books by " + authorToFind + ":");
                    bookCollection.findBookByAuthor(authorToFind);
                    break;
                case 5:
                    System.out.print("Enter publication year: ");
                    int yearToFind = Integer.parseInt(scanner.nextLine());
                    System.out.println("Books published in " + yearToFind + ":");
                    bookCollection.findBooksByYear(yearToFind);
                    break;
                case 6:
                    System.out.print("Enter genre: ");
                    String genreToFind = scanner.nextLine();
                    System.out.println("Books in genre " + genreToFind + ":");
                    bookCollection.findBooksByGenre(genreToFind);
                    break;
                case 7:
                    System.out.print("Enter author name: ");
                    String authorToRemove = scanner.nextLine();
                    bookCollection.removeBooksByAuthor(authorToRemove);
                    System.out.println("Removed all books by " + authorToRemove + ".");
                    break;
                case 8:
                    System.out.print("Enter sorting criterion (title/author/year): ");
                    String criterion = scanner.nextLine();
                    bookCollection.sortByCriterion(criterion);
                    System.out.println("Collection sorted by " + criterion + ".");
                    break;
                case 9:
                    BookCollection otherCollection = new BookCollection();
                    otherCollection.addBook(new Book("Fahrenheit 451", "Ray Bradbury", "Dystopian", 1953));
                    otherCollection.addBook(new Book("The Catcher in the Rye", "J.D. Salinger", "Fiction", 1951));
                    bookCollection.mergeCollections(otherCollection);
                    System.out.println("Merged another collection into the main collection.");
                    break;
                case 10:
                    System.out.print("Enter genre for subcollection: ");
                    String subGenre = scanner.nextLine();
                    System.out.println("Subcollection of books in genre " + subGenre + ":");
                    bookCollection.createSubCollectionByGenre(subGenre).forEach(System.out::println);
                    break;
                case 11:
                    System.out.println("All Books:");
                    bookCollection.printAllBooks();
                    break;
                case 0:
                    running = false;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}

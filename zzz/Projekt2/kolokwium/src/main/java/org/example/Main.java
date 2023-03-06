package org.example;

import org.example.data.Book;
import org.example.data.BooksSample;
import org.example.model.BooksManager;
import org.example.model.ClassDescriptor;
import org.example.model.Library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Zaczynamy. Życzę powodzenia :)");

        Library library = new Library(BooksSample.books);
        library.showData();

        ClassDescriptor bookDescriptor = new ClassDescriptor(Book.class);
        System.out.println(bookDescriptor.getInfo());
    }

    private static double getPriceOfJavaBooksPublicizedIn2002(List<Book> books){
        BooksManager manager = new BooksManager();
        List<Book> booksJava = manager.getByTitle(books,"java");
        List<Book> books2002 = manager.groupByPublicationYear(booksJava).get(2002);
        return manager.getTotalPrice(books2002);
    }

    private static void showNetBooksPublicizedIn2001(){
        BooksManager manager = new BooksManager();
        List<Book> booksNet = manager.getByTitle(BooksSample.books, "net");
        List<Book> books2001 = manager.groupByPublicationYear(booksNet).get(2001);
        System.out.println(manager.getDescriptions(books2001));
    }
}
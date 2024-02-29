package java实验.lab5_19;

import java.util.*;
public class Library {
    Map<String, Book> books;

    public Library() {
        books = new HashMap<String, Book>();
    }
    public boolean addBook(Book bookIn) {
        String keyIn = bookIn.getIsbn();
        if (books.containsKey(keyIn))
            return false;
        else {
            books.put(keyIn, bookIn);
            return true;
        }
    }
    public boolean removeBook(String isbnIn) {
        if (books.remove(isbnIn) != null)
            return true;
        else return false;
    }

    public int getTotalNumberOfBooks() {
        return books.size();
    }

    public Book getBook(String isbnIn)
    {
        return books.get(isbnIn);
    }
    public Set<Book> getAllBooks()
    {
        Set<Book> bookSet = new HashSet<Book>();
        Set<String> thekeys = books.keySet();
        for (String isbn : thekeys)
        {
            Book theBook = books.get(isbn);
            bookSet.add(theBook);
        }
        return bookSet;
    }
}
class Book {
    private String isbn;
    private String title;
    private String author;
    public Book (String isbnIn, String titleIn, String authorIn)
    {
        isbn = isbnIn;
        title = titleIn;
        author = authorIn;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String toString() {
        return "(" + isbn + ", " + author + ", " + title + ")\n";
    }
}





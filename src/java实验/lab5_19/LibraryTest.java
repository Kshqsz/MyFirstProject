package java实验.lab5_19;

import java.util.*;
public class LibraryTest {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        Book book1 = new Book("978-1-283", "Java", "JD");
        Book book2 = new Book("925-6-257", "Database", "MQ");
        Book book3 = new Book("421-8-925", "NetWork", "SU");
        if (myLibrary.addBook(book1))
        {
            System.out.println("添加成功");
        }
        else System.out.println("添加失败");
        if (myLibrary.addBook(book2))
        {
            System.out.println("添加成功");
        }
        else System.out.println("添加失败");
        if (myLibrary.addBook(book3))
        {
            System.out.println("添加成功");
        }
        else System.out.println("添加失败");
        System.out.print(myLibrary.getBook("978-1-283"));
        System.out.println("Total Number is:" + myLibrary.getTotalNumberOfBooks() );
        Set<Book> myAllBooks;
        myAllBooks = myLibrary.getAllBooks();
        System.out.print(myAllBooks);
    }
}

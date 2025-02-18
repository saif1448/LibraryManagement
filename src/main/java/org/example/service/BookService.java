package org.example.service;

import org.example.enums.Genre;
import org.example.models.Book;
import org.example.models.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class BookService {

    Logger logger = LoggerFactory.getLogger(BookService.class);

    List<Book> bookList;

    public BookService(){

        bookList = new ArrayList<>();

        Book book1 = new Book(1L, "George Orwell", 1, Genre.FICTION);
        Book book2 = new Book(2L, "J.K. Rowling", 1, Genre.FANTASY);
        Book book3 = new Book(3L, "Agatha Christie", 2, Genre.MYSTERY);
        Book book4 = new Book(4L, "J.R.R. Tolkien", 3, Genre.FANTASY);
        Book book5 = new Book(5L, "Isaac Asimov", 1, Genre.SCIFI);
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);
        bookList.add(book5);

    }

    public void addBook(Book newBook) {
        bookList.add(newBook);
    }

    public void updateBook(int id, Book updatedBook){
        int index = id-1;
        bookList.set(index, updatedBook);
    }

    public void deleteBook(int id){
//        int index = id - 1;
        Book book = findByBookId(id);
        bookList.remove(book);

        logger.info("Book List {}", bookList);

    }

    public Book findByBookId(int id){
        for(var book: bookList){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public List<Book> getBookList() {
        return bookList;
    }
}

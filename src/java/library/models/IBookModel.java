/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.Book;
import library.models.entities.Category;

/**
 *
 * @author julien
 */
public interface IBookModel {
    public void add(Book book);
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public List<Book> getBooksByCategory(Category cat);
    public void addBook(Book book);
    public void deleteBook(Book book);
}

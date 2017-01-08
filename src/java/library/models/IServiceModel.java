/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.Author;
import library.models.entities.Book;
import library.models.entities.Category;
import library.models.entities.LibraryUser;
import library.models.entities.Loan;

/**
 *
 * @author julien
 */
public interface IServiceModel {
    //Author
    public void add(Author author);
    public List<Author> getAllAuthors();
    public Author getAuthorById(int id);
    public void update(Author author);
    public void delete(Author author);
   //End Author
    
    //Book
    public void add(Book book);
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public List<Book> getBooksByCategory(Category cat);
    public void addBook(Book book);
    public void deleteBook(Book book);
    //End Book
    
    //Category
    public void add(Category cat);
    public List<Category> getAllCategory();
    public Category getCategoryById(int id);
    public void update(Category cat);
    public void delete(Category cat);
    //End Category
    
    //UserLibrary
    public void add(LibraryUser user);
    public List<LibraryUser> getAllLibraryUsers();
    public LibraryUser getLibraryUserById(int id);
    public void update(LibraryUser user);
    public void delete(LibraryUser user);
    public LibraryUser connect(String login, String password);
    //End UserLibrary
    
    //Loan
    public void add(Loan loan);
    public List<Loan> getListLoanByUser(int userId);
    public List<Loan> getAllLoans();
    public void addLoan(Loan loan);
    public void update(Loan loan);
    public void delete(Loan loan);
    //End Loan
}

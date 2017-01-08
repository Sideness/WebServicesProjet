/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import javax.ejb.Local;
import library.models.entities.Author;
import library.models.entities.Book;
import library.models.entities.Category;
import library.models.entities.LibraryUser;
import library.models.entities.Loan;

/**
 *
 * @author julien
 */

@Local
public interface IServiceModel {
    //Author
    public void addAuthor(Author author);
    public List<Author> getAllAuthors();
    public Author getAuthorById(int id);
    public void updateAuthor(Author author);
    public void deleteAuthor(Author author);
   //End Author
    
    //Book
    public void addBook(Book book);
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public List<Book> getBooksByCategory(Category cat);
    public void updateBook(Book book);
    public void deleteBook(Book book);
    //End Book
    
    //Category
    public void addCategory(Category cat);
    public List<Category> getAllCategory();
    public Category getCategoryById(int id);
    public void updateCategory(Category cat);
    public void deleteCategory(Category cat);
    //End Category
    
    //UserLibrary
    public void addUser(LibraryUser user);
    public List<LibraryUser> getAllLibraryUsers();
    public LibraryUser getLibraryUserById(int id);
    public void updateUser(LibraryUser user);
    public void deleteUser(LibraryUser user);
    public LibraryUser connect(String login, String password);
    //End UserLibrary
    
    //Loan
    public void addLoan(Loan loan);
    public Loan getLoanById(int id);
    public List<Loan> getListLoanByUser(int userId);
    public List<Loan> getAllLoans();
    public void updateLoan(Loan loan);
    public void deleteLoan(Loan loan);
    //End Loan
}

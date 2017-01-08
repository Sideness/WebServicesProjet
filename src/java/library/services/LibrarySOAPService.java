/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.services;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebParam;
import javax.jws.WebMethod;
import javax.jws.WebService;
import library.models.IServiceModel;
import library.models.entities.Author;
import library.models.entities.Book;
import library.models.entities.Category;
import library.models.entities.LibraryUser;
import library.models.entities.Loan;

/**
 *
 * @author julien
 */
@WebService
public class LibrarySOAPService {
    
    @EJB
    private IServiceModel metier;
    
    //Author
    @WebMethod
    public void addAuthor(
        @WebParam(name="author")Author author){
        metier.addAuthor(author);
    }
    
    @WebMethod
    public List<Author> getAllAuthors(){
        return metier.getAllAuthors();
    }
            
            
    @WebMethod
    public Author getAuthorById(
        @WebParam(name="id")int id){
        return metier.getAuthorById(id);
    }
    
    @WebMethod
    public void updateAuthor(@WebParam(name="author")Author author){
        metier.updateAuthor(author);
    }
    
    @WebMethod
    public void deleteAuthor(@WebParam(name="author")Author author){
        metier.deleteAuthor(author);
    }
   //End Author
    
    //Book
    @WebMethod
    public void addBook(@WebParam(name="book")Book book){
        metier.addBook(book);
    }
    
    @WebMethod
    public List<Book> getAllBooks(){
        return metier.getAllBooks();
    }
    
    @WebMethod
    public Book getBookById(@WebParam(name="id")int id){
        return metier.getBookById(id);
    }
    
    @WebMethod
    public List<Book> getBooksByCategory(@WebParam(name="cat")Category cat){
        return metier.getBooksByCategory(cat);
    }
    
    @WebMethod
    public void updateBook(@WebParam(name="book")Book book){
        metier.updateBook(book);
    }
    
    @WebMethod
    public void deleteBook(@WebParam(name="book")Book book){
        metier.deleteBook(book);
    }
    //End Book
    
    @WebMethod
    public List<Category> getAllCategory(){
        return metier.getAllCategory();
    }

    @WebMethod
    public Category getCategoryById(@WebParam(name="id")int id){
        return metier.getCategoryById(id);
    }
    
    @WebMethod
    public void updateCategory(@WebParam(name="cat")Category cat){
        metier.updateCategory(cat);
    }
    
    @WebMethod
    public void deleteCategory(@WebParam(name="cat")Category cat){
        metier.deleteCategory(cat);
    }
    
    @WebMethod
    public void addCategory(@WebParam(name="cat")Category cat){
        metier.addCategory(cat);
    }
    //End Category
    
    //UserLibrary
    @WebMethod
    public void addUser(@WebParam(name="user")LibraryUser user){
        metier.addUser(user);
    }
    
    @WebMethod
    public List<LibraryUser> getAllLibraryUsers(){
        return metier.getAllLibraryUsers();
    }
    
    @WebMethod
    public LibraryUser getLibraryUserById(@WebParam(name="id")int id){
        return metier.getLibraryUserById(id);
    }
    
    @WebMethod
    public void updateUser(@WebParam(name="user")LibraryUser user){
        metier.updateUser(user);
    }
    
    @WebMethod
    public void deleteUser(@WebParam(name="user")LibraryUser user){
        metier.deleteUser(user);
    }
    
    @WebMethod
    public LibraryUser connect(@WebParam(name="login")String login, @WebParam(name="password")String password){
        return metier.connect(login, password);
    }
    //End UserLibrary
    
    //Loan
    @WebMethod
    public void addUser(@WebParam(name="loan")Loan loan){
        metier.addLoan(loan);
    }
    
    @WebMethod
    public List<Loan> getListLoanByUser(@WebParam(name="userId")int userId){
        return metier.getListLoanByUser(userId);
    }
    
    @WebMethod
    public List<Loan> getAllLoans(){
        return metier.getAllLoans();
    }
    
    @WebMethod
    public void addLoan(@WebParam(name="loan")Loan loan){
        metier.addLoan(loan);
    }
    
    @WebMethod
    public void updateLoan(@WebParam(name="loan")Loan loan){
        metier.updateLoan(loan);
    }
    @WebMethod
    public void deleteLoan(@WebParam(name="loan")Loan loan){
        metier.deleteLoan(loan);
    }
    //End Loan
}

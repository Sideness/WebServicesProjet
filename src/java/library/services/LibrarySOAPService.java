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
    public void add(
        @WebParam(name="author")Author author){
        metier.add(author);
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
    public void update(@WebParam(name="author")Author author){
        metier.update(author);
    }
    
    @WebMethod
    public void delete(@WebParam(name="author")Author author){
        metier.delete(author);
    }
   //End Author
    
    //Book
    @WebMethod
    public void add(@WebParam(name="book")Book book){
        metier.add(book);
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
    public void addBook(@WebParam(name="book")Book book){
        metier.add(book);
    }
    
    @WebMethod
    public void deleteBook(@WebParam(name="book")Book book){
        metier.deleteBook(book);
    }
    //End Book
    
    //Category
    @WebMethod
    public void add(@WebParam(name="cat")Category cat){
        metier.add(cat);
    }
    
    @WebMethod
    public List<Category> getAllCategory(){
        return metier.getAllCategory();
    }

    @WebMethod
    public Category getCategoryById(@WebParam(name="id")int id){
        return metier.getCategoryById(id);
    }
    
    @WebMethod
    public void update(@WebParam(name="cat")Category cat){
        metier.update(cat);
    }
    
    @WebMethod
    public void delete(@WebParam(name="cat")Category cat){
        metier.delete(cat);
    }
    //End Category
    
    //UserLibrary
    @WebMethod
    public void add(@WebParam(name="user")LibraryUser user){
        metier.add(user);
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
    public void update(@WebParam(name="user")LibraryUser user){
        metier.update(user);
    }
    
    @WebMethod
    public void delete(@WebParam(name="user")LibraryUser user){
        metier.delete(user);
    }
    
    @WebMethod
    public LibraryUser connect(@WebParam(name="login")String login, @WebParam(name="password")String password){
        return metier.connect(login, password);
    }
    //End UserLibrary
    
    //Loan
    @WebMethod
    public void add(@WebParam(name="loan")Loan loan){
        metier.add(loan);
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
    public void update(@WebParam(name="loan")Loan loan){
        metier.update(loan);
    }
    @WebMethod
    public void delete(@WebParam(name="loan")Loan loan){
        metier.delete(loan);
    }
    //End Loan
}

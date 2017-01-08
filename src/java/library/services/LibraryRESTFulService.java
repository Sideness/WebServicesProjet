/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.services;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import library.models.IServiceModel;
import library.models.entities.Author;
import library.models.entities.Book;
import library.models.entities.Category;
import library.models.entities.LibraryUser;
import library.models.entities.Loan;
import library.models.entities.TypeAuthor;

/**
 *
 * @author julien
 */
@Stateless
@Path("rest")
public class LibraryRESTFulService {
    
    @EJB
    private IServiceModel metier;
    
    //Author
    @POST
    @Path("/authors/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Author addAuthor(
        @PathParam(value="about")String about,
        @PathParam(value="birthdate")String birthdate,
        @PathParam(value="email")String email,
        @PathParam(value="firstname")String firstname,
        @PathParam(value="gender")String gender,
        @PathParam(value="lastname")String lastname,
        @PathParam(value="nationality")String nationality,
        @PathParam(value="profilepicture")String profilepicture,
        @PathParam(value="type")int type){
        
        Author author = new Author();
        author.setAbout(about);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        author.setBirthDate(spl.parse(birthdate));
        }catch(Exception e){
            e.printStackTrace();
        }
        author.setEmail(email);
        author.setFirstName(firstname);
        author.setGender(gender);
        author.setLastName(lastname);
        author.setNationality(nationality);
        author.setProfilePicture(profilepicture);
        author.setType(TypeAuthor.values()[type]);
        metier.addAuthor(author);
        
        return author;
    }
    
    @GET
    @Path("/authors")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Author> getAllAuthors(){
        return metier.getAllAuthors();
    }
            
            
    @GET
    @Path("/authors/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Author getAuthorById(
        @PathParam(value="id")int id){
        return metier.getAuthorById(id);
    }
    
    @POST
    @Path("/authors/update/{author}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateAuthor(@PathParam(value="author")Author author){
        metier.updateAuthor(author);
    }
    
    @DELETE
    @Path("/authors/delete/{author}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteAuthor(@PathParam(value="author")Author author){
        metier.deleteAuthor(author);
    }
   //End Author
    
    //Book
    @POST
    @Path("/books/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addBook(@PathParam(value="book")Book book){
        metier.addBook(book);
    }
    
    @GET
    @Path("/books/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getAllBooks(){
        return metier.getAllBooks();
    }
    
    @GET
    @Path("/books/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book getBookById(@PathParam(value="id")int id){
        return metier.getBookById(id);
    }
    
    @GET
    @Path("/categories/{cat}/books/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getBooksByCategory(@PathParam(value="cat")Category cat){
        return metier.getBooksByCategory(cat);
    }
    
    @POST
    @Path("/books/update/{book}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateBook(@PathParam(value="book")Book book){
        metier.updateBook(book);
    }
    
    @DELETE
    @Path("/books/delete/{book}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteBook(@PathParam(value="book")Book book){
        metier.deleteBook(book);
    }
    //End Book
    
    @GET
    @Path("/categories")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Category> getAllCategory(){
        return metier.getAllCategory();
    }

    @GET
    @Path("/categories/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Category getCategoryById(@PathParam(value="id")int id){
        return metier.getCategoryById(id);
    }
    
    @POST
    @Path("/categories/update/{cat}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateCategory(@PathParam(value="cat")Category cat){
        metier.updateCategory(cat);
    }
    
    @DELETE
    @Path("/categories/delete/{cat}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteCategory(@PathParam(value="cat")Category cat){
        metier.deleteCategory(cat);
    }
    
    @POST
    @Path("/categories/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addCategory(@PathParam(value="cat")Category cat){
        metier.addCategory(cat);
    }
    //End Category
    
    //UserLibrary
    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<LibraryUser> getAllLibraryUsers(){
        return metier.getAllLibraryUsers();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public LibraryUser getLibraryUserById(@PathParam(value="id")int id){
        return metier.getLibraryUserById(id);
    }
    
    @POST
    @Path("/users/update/{user}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateUser(@PathParam(value="user")LibraryUser user){
        metier.updateUser(user);
    }
    
    @DELETE
    @Path("/users/delete/{user}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteUser(@PathParam(value="user")LibraryUser user){
        metier.deleteUser(user);
    }
    
    @POST
    @Path("/connect")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public LibraryUser connect(@PathParam(value="login")String login, @PathParam(value="password")String password){
        return metier.connect(login, password);
    }
    //End UserLibrary
    
    //Loan
    @POST
    @Path("/users/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addUser(@PathParam(value="loan")Loan loan){
        metier.addLoan(loan);
    }
    
    @GET
    @Path("/{userId}/loans")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Loan> getListLoanByUser(@PathParam(value="userId")int userId){
        return metier.getListLoanByUser(userId);
    }
    
    @GET
    @Path("/loans")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Loan> getAllLoans(){
        return metier.getAllLoans();
    }
    
    @POST
    @Path("/loans/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addLoan(@PathParam(value="loan")Loan loan){
        metier.addLoan(loan);
    }
    
    @POST
    @Path("/loans/update/{loan}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateLoan(@PathParam(value="loan")Loan loan){
        metier.updateLoan(loan);
    }
    @DELETE
    @Path("/loans/delete/{loan}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void deleteLoan(@PathParam(value="loan")Loan loan){
        metier.deleteLoan(loan);
    }
    //End Loan
}

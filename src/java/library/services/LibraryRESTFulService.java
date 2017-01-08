/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.services;

import java.text.ParseException;
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
import library.models.entities.AccountType;
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
    public Author updateAuthor(@PathParam(value="id")int id,
        @PathParam(value="about")String about,
        @PathParam(value="birthdate")String birthdate,
        @PathParam(value="email")String email,
        @PathParam(value="firstname")String firstname,
        @PathParam(value="gender")String gender,
        @PathParam(value="lastname")String lastname,
        @PathParam(value="nationality")String nationality,
        @PathParam(value="profilepicture")String profilepicture,
        @PathParam(value="type")int type){
        Author author = metier.getAuthorById(id);
        
        author.setAbout(about);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        author.setBirthDate(spl.parse(birthdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        author.setEmail(email);
        author.setFirstName(firstname);
        author.setGender(gender);
        author.setLastName(lastname);
        author.setNationality(nationality);
        author.setProfilePicture(profilepicture);
        author.setType(TypeAuthor.values()[type]);
        metier.updateAuthor(author);
        
        return author;
    }
    
    @DELETE
    @Path("/authors/delete/{author}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteAuthor(@PathParam(value="id")int id){
        Author author = metier.getAuthorById(id);
        metier.deleteAuthor(author);
        return true;
    }
   //End Author
    
    //Book
    @POST
    @Path("/books/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book addBook(@PathParam(value="isbn")String isbn,
            @PathParam(value="picture")String picture,
            @PathParam(value="publicationdate")String publicationdate,
            @PathParam(value="quantity")int quantity,
            @PathParam(value="resume")String resume,
            @PathParam(value="title")String title,
            @PathParam(value="category_id")int category_id){
        Book book = new Book();
        
        book.setIsbn(isbn);
        book.setPicture(picture);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        book.setPublicationDate(spl.parse(publicationdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        book.setQuantity(quantity);
        book.setResume(resume);
        book.setTitle(title);
        book.setCategory(metier.getCategoryById(category_id));
        
        metier.addBook(book);
        return book;
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
    @Path("/categories/{id}/books/")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Book> getBooksByCategory(@PathParam(value="id")int id){
        Category cat = metier.getCategoryById(id);
        return metier.getBooksByCategory(cat);
    }
    
    @POST
    @Path("/books/update/{book}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Book updateBook(@PathParam(value="id")int id,
            @PathParam(value="isbn")String isbn,
            @PathParam(value="picture")String picture,
            @PathParam(value="publicationdate")String publicationdate,
            @PathParam(value="quantity")int quantity,
            @PathParam(value="resume")String resume,
            @PathParam(value="title")String title,
            @PathParam(value="category_id")int category_id){
        Book book = metier.getBookById(id);
       
        book.setIsbn(isbn);
        book.setPicture(picture);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        book.setPublicationDate(spl.parse(publicationdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        book.setQuantity(quantity);
        book.setResume(resume);
        book.setTitle(title);
        book.setCategory(metier.getCategoryById(category_id));
        
        metier.updateBook(book);
        return book;
    }
    
    @DELETE
    @Path("/books/delete/{book}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteBook(@PathParam(value="id")int id){
        Book book = metier.getBookById(id);
        metier.deleteBook(book);
        return true;
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
    public Category updateCategory(@PathParam(value="id")int id,
            @PathParam(value="description")String description,
            @PathParam(value="name")String name){
        Category cat = metier.getCategoryById(id);
        
        cat.setDescription(description);
        cat.setName(name);
        
        metier.updateCategory(cat);
        return cat;
    }
    
    @DELETE
    @Path("/categories/delete/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteCategory(@PathParam(value="id")int id){
        Category cat = metier.getCategoryById(id);
        metier.deleteCategory(cat);
        return true;
    }
    
    @POST
    @Path("/categories/add")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean addCategory(@PathParam(value="id")int id){
        Category cat = metier.getCategoryById(id);
        metier.deleteCategory(cat);
        return true;
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
    public LibraryUser updateUser(@PathParam(value="id")int id,
            @PathParam(value="accountstate")int accountstate,
            @PathParam(value="birthdate")String birthdate,
            @PathParam(value="email")String email,
            @PathParam(value="firstname")String firstname,
            @PathParam(value="gender")String gender,
            @PathParam(value="isadmin")boolean isadmin,
            @PathParam(value="lastconnection")String lastconnection,
            @PathParam(value="lastname")String lastname,
            @PathParam(value="login")String login,
            @PathParam(value="password")String password,
            @PathParam(value="profilepicture")String profilepicture){
        LibraryUser user = metier.getLibraryUserById(id);
        
        user.setAccountState(AccountType.values()[accountstate]);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        user.setBirthDate(spl.parse(birthdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setGender(gender);
        user.setIsAdmin(isadmin);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        user.setLastConnection(spl.parse(lastconnection));
        }catch(ParseException e){
            e.printStackTrace();
        }
        user.setLastName(lastname);
        user.setLogin(login);
        user.setPassword(password);
        user.setProfilePicture(profilepicture);
        
        metier.updateUser(user);
        return user;
    }
    
    @DELETE
    @Path("/users/delete/{user}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteUser(@PathParam(value="id")int id){
        LibraryUser user = metier.getLibraryUserById(id);
        metier.deleteUser(user);
        return true;
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
    public LibraryUser addUser(@PathParam(value="accountstate")int accountstate,
            @PathParam(value="birthdate")String birthdate,
            @PathParam(value="email")String email,
            @PathParam(value="firstname")String firstname,
            @PathParam(value="gender")String gender,
            @PathParam(value="isadmin")boolean isadmin,
            @PathParam(value="lastconnection")String lastconnection,
            @PathParam(value="lastname")String lastname,
            @PathParam(value="login")String login,
            @PathParam(value="password")String password,
            @PathParam(value="profilepicture")String profilepicture){
        LibraryUser user = new LibraryUser();
        
        user.setAccountState(AccountType.values()[accountstate]);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        user.setBirthDate(spl.parse(birthdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        user.setEmail(email);
        user.setFirstName(firstname);
        user.setGender(gender);
        user.setIsAdmin(isadmin);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        user.setLastConnection(spl.parse(lastconnection));
        }catch(ParseException e){
            e.printStackTrace();
        }
        user.setLastName(lastname);
        user.setLogin(login);
        user.setPassword(password);
        user.setProfilePicture(profilepicture);
        
        metier.addUser(user);
        return user;
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
    public Loan addLoan(@PathParam(value="duration")int duration,
            @PathParam(value="isreturned")boolean isreturned,
            @PathParam(value="startdate")String startdate,
            @PathParam(value="book")int book,
            @PathParam(value="libraryuser")int libraryuser){
        Loan loan = new Loan();
        
        loan.setDuration(duration);
        loan.setIsReturned(isreturned);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        loan.setStartDate(spl.parse(startdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        loan.setBorrowedBook(metier.getBookById(book));
        loan.setUser(metier.getLibraryUserById(libraryuser));
        
        metier.addLoan(loan);
        return loan;
    }
    
    @POST
    @Path("/loans/update/{loan}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Loan updateLoan(@PathParam(value="id")int id,
            @PathParam(value="duration")int duration,
            @PathParam(value="isreturned")boolean isreturned,
            @PathParam(value="startdate")String startdate,
            @PathParam(value="book")int book,
            @PathParam(value="libraryuser")int libraryuser){
        Loan loan = metier.getLoanById(id);
        
        loan.setDuration(duration);
        loan.setIsReturned(isreturned);
        try{
        SimpleDateFormat spl = new SimpleDateFormat("dd/MM/yyyy");
        loan.setStartDate(spl.parse(startdate));
        }catch(ParseException e){
            e.printStackTrace();
        }
        loan.setBorrowedBook(metier.getBookById(book));
        loan.setUser(metier.getLibraryUserById(libraryuser));
        
        metier.updateLoan(loan);
        return loan;
    }
    @DELETE
    @Path("/loans/delete/{loan}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public boolean deleteLoan(@PathParam(value="id")int id){
        Loan loan = metier.getLoanById(id);
        metier.deleteLoan(loan);
        return true;
    }
    //End Loan
}

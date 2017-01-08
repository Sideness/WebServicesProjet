/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import library.models.entities.Book;
import library.models.entities.Category;

/**
 *
 * @author julien
 */
@Stateless(name="BOOK")
public class IBookModelImpl implements IBookModel {
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;
   
    @Override
    public List<Book> getAllBooks(){
        Query req=em.createQuery("select b from Book b");
        return req.getResultList();
    }
    
    @Override
    public Book getBookById(int id){
        Book b = em.find(Book.class, id);
        return b;
    }
    
    @Override
    public void addBook(Book book){
        em.persist(book);
    }
    
    @Override
    public void deleteBook(Book book){
        Book b = em.find(Book.class, book.getId());
        em.remove(b);
    }

    @Override
    public List<Book> getBooksByCategory(Category cat) {
        Query req=em.createQuery("select b from Book b, Category c where b.id = c.id and c.id = :param");
        req.setParameter("param", cat.getId());
        return req.getResultList();
    }
}

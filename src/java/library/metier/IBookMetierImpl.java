/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.metier;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import library.metier.entities.Book;

/**
 *
 * @author julien
 */
@Stateless(name="BOOK")
public class IBookMetierImpl implements IBookMetier {
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;
   
    @Override
    public List<Book> getAllBooks(){
        return new ArrayList<Book>();
    }
    
    @Override
    public Book getBookById(int id){
        return new Book();
    }
}

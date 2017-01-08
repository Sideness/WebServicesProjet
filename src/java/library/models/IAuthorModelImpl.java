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
import library.models.entities.Author;
import library.models.entities.LibraryUser;

/**
 *
 * @author julien
 */
@Stateless(name="LIBRARYUSER")
public class IAuthorModelImpl implements IAuthorModel {
    
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;

    @Override
    public List<Author> getAllAuthors() {
        Query req=em.createQuery("select a from Author a");
        return req.getResultList();
    }

    @Override
    public Author getAuthorById(int id) {
        Author a = em.find(Author.class, id);
        return a;
    }

    @Override
    public void update(Author author) {
        em.persist(author);
    }

    @Override
    public void delete(Author author) {
        Author a = em.find(Author.class, author.getId());
        em.remove(a);
    }
    
}

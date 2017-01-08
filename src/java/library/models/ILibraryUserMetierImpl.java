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
import library.models.entities.LibraryUser;

/**
 *
 * @author julien
 */
@Stateless(name="LIBRARYUSER")
public class ILibraryUserMetierImpl implements ILibraryUserMetier {
    
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;

    @Override
    public List<LibraryUser> getAllLibraryUsers() {
        Query req=em.createQuery("select lu from LibraryUser lu");
        return req.getResultList();
    }

    @Override
    public LibraryUser getLibraryUserById(int id) {
        LibraryUser lu = em.find(LibraryUser.class, id);
        return lu;
    }

    @Override
    public void update(LibraryUser user) {
        em.persist(user);
    }

    @Override
    public void delete(LibraryUser user) {
        LibraryUser lu = em.find(LibraryUser.class, user.getId());
        em.remove(lu);
    }
    
}

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
import library.models.entities.Category;

/**
 *
 * @author julien
 */
@Stateless(name="CATEGORY")
public class ICategoryModelImpl implements ICategoryModel {
    
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;

    @Override
    public List<Category> getAllCategory() {
        Query req=em.createQuery("select c from Category c");
        return req.getResultList();
    }

    @Override
    public Category getCategoryById(int id) {
        Category c = em.find(Category.class, id);
        return c;
    }

    @Override
    public void update(Category cat) {
        em.persist(cat);
    }

    @Override
    public void delete(Category cat) {
        Category c = em.find(Category.class, cat.getId());
        em.remove(c);
    }
    
}

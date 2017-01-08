/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.metier;

import java.util.ArrayList;
import javax.ejb.Local;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import library.metier.entities.Loan;

/**
 *
 * @author SidenessPC
 */
@Stateless(name="LOAN")
public class ILoanMetierImpl implements ILoanMetier {
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;
    
    @Override
    public List<Loan> getListLoanByUser(int id) {
        //TODO Changer pour get ceux qui correspondent
        Query req=em.createQuery("select l from Loan l");
        return req.getResultList();
    }

    @Override
    public List<Loan> getAllLoans(){
        Query req=em.createQuery("select l from Loan l");
        return req.getResultList();
    }
    
    
    @Override
    public void update(Loan loan) {
        em.persist(loan);
    }

    @Override
    public void delete(int id) {
        Loan m = em.find(Loan.class, id);
        em.remove(m);
    }
    
}

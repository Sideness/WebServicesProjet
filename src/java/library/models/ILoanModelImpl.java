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
import library.models.entities.Loan;

/**
 *
 * @author SidenessPC
 */
@Stateless(name="LOAN")
public class ILoanModelImpl implements ILoanModel {
    @PersistenceContext(name="LibraryDS")
    
    EntityManager em;
    
    @Override
    public List<Loan> getListLoanByUser(int id) {
        Query req=em.createQuery("select l from Loan l, LibraryUser u where l.user = u.id and u.id = :param");
        req.setParameter("param", id);
        return req.getResultList();
    }

    @Override
    public List<Loan> getAllLoans(){
        Query req=em.createQuery("select l from Loan l");
        return req.getResultList();
    }
    
    @Override
    public void addLoan(Loan loan){
        em.persist(loan);
    }
    
    @Override
    public void update(Loan loan) {
        em.persist(loan);
    }

    @Override
    public void delete(Loan loan) {
        Loan m = em.find(Loan.class, loan.getId());
        em.remove(m);
    }
    
}

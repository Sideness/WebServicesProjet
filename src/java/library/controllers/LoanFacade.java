/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.controllers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import library.metier.entities.Loan;

/**
 *
 * @author Nicolas_2
 */
@Stateless
public class LoanFacade extends AbstractFacade<Loan> {

    @PersistenceContext(unitName = "_Projet_WS_REVOIL_REMISE_STEFANIPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LoanFacade() {
        super(Loan.class);
    }
    
}

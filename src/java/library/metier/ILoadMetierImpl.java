/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.metier;

import java.util.ArrayList;
import java.util.List;
import library.metier.entities.Loan;

/**
 *
 * @author SidenessPC
 */
public class ILoadMetierImpl implements ILoanMetier {

    @Override
    public List<Loan> getListLoanByUser(int userId) {
        List<Loan> ret = new ArrayList<Loan>();
        
        return ret;
    }

    
    
    @Override
    public void update(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Loan loan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

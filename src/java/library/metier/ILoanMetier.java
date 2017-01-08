/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.metier;

import java.util.List;
import library.metier.entities.Loan;

/**
 *
 * @author SidenessPC
 */
public interface ILoanMetier {
    public List<Loan> getListLoanByUser(int userId);
    public void update(Loan loan);
    public void delete(Loan loan);
}

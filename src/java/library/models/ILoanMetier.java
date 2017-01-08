/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.Loan;

/**
 *
 * @author SidenessPC
 */
public interface ILoanMetier {
    public List<Loan> getListLoanByUser(int userId);
    public List<Loan> getAllLoans();
    public void addLoan(Loan loan);
    public void update(Loan loan);
    public void delete(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.LibraryUser;

/**
 *
 * @author julien
 */
public interface ILibraryUserMetier {
    public List<LibraryUser> getAllLibraryUsers();
    public LibraryUser getLibraryUserById(int id);
    public void update(LibraryUser user);
    public void delete(LibraryUser user);
}

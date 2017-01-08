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
public interface ILibraryUserModel {
    public List<LibraryUser> getAllLibraryUsers();
    public LibraryUser getLibraryUserById(int id);
    public void update(LibraryUser user);
    public void delete(LibraryUser user);
    public LibraryUser connect(String login, String password);
}

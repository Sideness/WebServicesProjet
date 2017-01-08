/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.Author;

/**
 *
 * @author julien
 */
public interface IAuthorModel {
    public void add(Author author);
    public List<Author> getAllAuthors();
    public Author getAuthorById(int id);
    public void update(Author author);
    public void delete(Author author);
}

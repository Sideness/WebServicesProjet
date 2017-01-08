/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.Book;

/**
 *
 * @author julien
 */
public interface IBookMetier {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
}

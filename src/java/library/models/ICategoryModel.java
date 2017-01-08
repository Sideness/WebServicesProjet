/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models;

import java.util.List;
import library.models.entities.Category;

/**
 *
 * @author julien
 */
public interface ICategoryModel {
    public List<Category> getAllCategory();
    public Category getCategoryById(int id);
    public void update(Category cat);
    public void delete(Category cat);
}

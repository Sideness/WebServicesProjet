/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.models.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Nicolas_2
 */
@Entity
@Table(name="AUTHOR")
public class Author extends Person implements Serializable {

    @Id
    @Column(name="ID")
    private static final long serialVersionUID = 1L;
    private String about;
    private String nationality;
    private TypeAuthor type;
    private List<Book> writtenBooks;

    public Author() {
        super();
    }

    public Author(String about, String nationality, TypeAuthor type) {
        super();
        this.about = about;
        this.nationality = nationality;
        this.type = type;
        this.writtenBooks = new ArrayList<Book>();
    }
    
    public Author(String about, String nationality, TypeAuthor type, List<Book> wB) {
        super();
        this.about = about;
        this.nationality = nationality;
        this.type = type;
        this.writtenBooks = wB;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public TypeAuthor getType() {
        return type;
    }

    public void setType(TypeAuthor type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Author)) {
            return false;
        }
        Author other = (Author) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "library.entities.Author[ id=" + id + " ]";
    }
    
}

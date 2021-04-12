package edu.eci.arsw.ecibastas.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subasta")
public class Subasta implements Serializable {
    private static final long serialVersionUID = 6153949052673072585L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int subastaId;

    @Column(name = "name")
    private String name;

    @Column(name = "creator")
    private String creator;
/*
    pendiente
    @Column(name = "image")
    private String image;
*/
    public Subasta() {

    }

    public Subasta(String name, String creator, String image) {
        this.name = name;
        this.creator = creator;
        //this.image = image;
    }


    public int getSubastaId() {
        return subastaId;
    }

    public void setSubastaId(int subastaId) {
        this.subastaId = subastaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
/*
    public String getImage() { return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

 */
}
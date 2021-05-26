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
    private int creator;

    @Column(name = "isActive")
    private Boolean isActive;

    public Subasta() {

    }

    public Subasta(String name, int creator) {
        this.name = name;
        this.creator = creator;
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

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
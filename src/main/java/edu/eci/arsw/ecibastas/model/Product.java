package edu.eci.arsw.ecibastas.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    private static final long serialVersionUID = 6153949052673072585L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int product_id;

    @Column(name = "name")
    private String name;

    @Column(name = "subasta")
    private int subasta;

    @Column(name = "description")
    private String description;

    @Column(name = "initialprice")
    private int initialprice;

    @Column(name = "actualprice")
    private int actualprice;

    @Column(name = "owner_user")
    private Integer owner_user;

    public Product() {

    }

    public Product(String name, int subasta, String description, int initialprice, int actualprice) {
        this.name = name;
        this.subasta = subasta;
        this.description = description;
        this.initialprice = initialprice;
        this.actualprice = actualprice;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSubasta() {
        return subasta;
    }

    public void setSubasta(int subasta) {
        this.subasta = subasta;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInitialprice() {
        return initialprice;
    }

    public void setInitialprice(int initialprice) {
        this.initialprice = initialprice;
    }

    public int getActualprice() {
        return actualprice;
    }

    public void setActualprice(int actualprice) {
        this.actualprice = actualprice;
    }

    public Integer getOwner_user() {
        return owner_user;
    }

    public void setOwner_user(Integer owner_user) {
        this.owner_user = owner_user;
    }
}

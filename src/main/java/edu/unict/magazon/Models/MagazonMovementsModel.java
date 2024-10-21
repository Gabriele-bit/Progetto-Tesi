package edu.unict.magazon.Models;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "movements")

public class MagazonMovementsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movement_id;
    private int quantity;
    private Date movement_date;

    public enum TYPE {
        ingresso,
        uscita
    }

    private TYPE movement_type;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private MagazonProductsModel product_id;

    public Integer getMovement_id() {
        return movement_id;
    }

    public void setMovement_id(Integer movement_id) {
        this.movement_id = movement_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getMovement_date() {
        return movement_date;
    }

    public void setMovement_date(Date movement_date) {
        this.movement_date = movement_date;
    }

    public TYPE getMovement_type() {
        return movement_type;
    }

    public void setMovement_type(TYPE movement_type) {
        this.movement_type = movement_type;
    }

    public MagazonProductsModel getProduct_id() {
        return product_id;
    }

    public void setProduct_id(MagazonProductsModel product_id) {
        this.product_id = product_id;
    }

}

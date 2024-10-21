package edu.unict.magazon.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class MagazonCartItemsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private MagazonProductsModel product_id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private MagazonCartsModel cart_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MagazonProductsModel getProduct_id() {
        return product_id;
    }

    public void setProduct_id(MagazonProductsModel product_id) {
        this.product_id = product_id;
    }

    public MagazonCartsModel getCart_id() {
        return cart_id;
    }

    public void setCart_id(MagazonCartsModel cart_id) {
        this.cart_id = cart_id;
    }
}

package edu.unict.magazon.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "order_details")

public class MagazonOrderDetailsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_detail_id;
    private int quantity;
    private int price;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private MagazonOrdersModel order_id;

    public MagazonOrdersModel getOrder_id() {
        return order_id;
    }

    public void setOrder_id(MagazonOrdersModel order_id) {
        this.order_id = order_id;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private MagazonProductsModel product_id;

    public Integer getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(Integer order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public MagazonProductsModel getProduct_id() {
        return product_id;
    }

    public void setProduct_id(MagazonProductsModel product_id) {
        this.product_id = product_id;
    }
}

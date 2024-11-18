package edu.unict.magazon.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class MagazonProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String name;
    @Column(length = 500)
    private String description;
    private float price;
    private int quantity;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MagazonCategoriesModel category;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private MagazonSuppliersModel supplier;

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public MagazonCategoriesModel getCategory() {
        return category;
    }

    public void setCategory(MagazonCategoriesModel category) {
        this.category = category;
    }

    public MagazonSuppliersModel getSupplier() {
        return supplier;
    }

    public void setSupplier(MagazonSuppliersModel supplier) {
        this.supplier = supplier;
    }
}

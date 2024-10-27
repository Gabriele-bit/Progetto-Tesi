package edu.unict.magazon.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class MagazonProductsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String name;
    private String description;
    private float price;
    private int quantity;
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MagazonCategoriesModel category_id;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private MagazonSuppliersModel supplier_id;

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

    public MagazonCategoriesModel getCategory_id() {
        return category_id;
    }

    public void setCategory_id(MagazonCategoriesModel category_id) {
        this.category_id = category_id;
    }

    public MagazonSuppliersModel getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(MagazonSuppliersModel supplier_id) {
        this.supplier_id = supplier_id;
    }

    
    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String image_url) {
        this.image_url = image_url;
    }

}

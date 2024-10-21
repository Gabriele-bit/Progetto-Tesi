package edu.unict.magazon.Models;
import jakarta.persistence.*;


public class MagazonWishlistItemsModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlistItem_id;

    @ManyToOne
    @JoinColumn(name = "wishlist_id")
    private MagazonWishlistsModel wishlist_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private MagazonProductsModel product_id;

    public Integer getWishlistItem_id() {
        return wishlistItem_id;
    }

    public void setWishlistItem_id(Integer wishlistItem_id) {
        this.wishlistItem_id = wishlistItem_id;
    }

    public MagazonWishlistsModel getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(MagazonWishlistsModel wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public MagazonProductsModel getProduct_id() {
        return product_id;
    }

    public void setProduct_id(MagazonProductsModel product_id) {
        this.product_id = product_id;
    }
}

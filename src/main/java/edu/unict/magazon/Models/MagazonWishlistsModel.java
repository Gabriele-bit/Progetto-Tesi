package edu.unict.magazon.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "wishlists")
public class MagazonWishlistsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer wishlist_id;
    private String wishlist_name;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private MagazonUsersModel user;

    public Integer getWishlist_id() {
        return wishlist_id;
    }

    public void setWishlist_id(Integer wishlist_id) {
        this.wishlist_id = wishlist_id;
    }

    public String getWishlist_name() {
        return wishlist_name;
    }

    public void setWishlist_name(String wishlist_name) {
        this.wishlist_name = wishlist_name;
    }

    public MagazonUsersModel getUser() {
        return user;
    }

    public void setUser(MagazonUsersModel user) {
        this.user = user;
    }

}

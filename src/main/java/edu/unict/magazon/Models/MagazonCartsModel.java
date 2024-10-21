package edu.unict.magazon.Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "carts")
public class MagazonCartsModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cart_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MagazonUsersModel user_id;

    public enum Status {
        ACTIVE,
        COMPLETED
    }

    private Status status;

    @OneToMany(mappedBy = "cart_id", cascade = CascadeType.ALL)
    private List<MagazonCartItemsModel> items = new ArrayList<>();

    public List<MagazonCartItemsModel> getItems() {
        return items;
    }

    public void setItems(List<MagazonCartItemsModel> items) {
        this.items = items;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public MagazonUsersModel getUser_id() {
        return user_id;
    }

    public void setUser_id(MagazonUsersModel user_id) {
        this.user_id = user_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

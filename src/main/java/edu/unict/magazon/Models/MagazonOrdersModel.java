package edu.unict.magazon.Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class MagazonOrdersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer order_id;
    private LocalDate order_date;
    private float totalAmount;

    public enum STATUS {
        pending,
        completed,
        canceled
    }

    private STATUS status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MagazonUsersModel user_id;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL)
    private List<MagazonOrderDetailsModel> orderDetails = new ArrayList<>();

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public LocalDate getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDate order_date) {
        this.order_date = order_date;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public MagazonUsersModel getUser_id() {
        return user_id;
    }

    public void setUser_id(MagazonUsersModel user_id) {
        this.user_id = user_id;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
}

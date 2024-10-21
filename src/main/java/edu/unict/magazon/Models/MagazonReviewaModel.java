package edu.unict.magazon.Models;
import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="reviews")
public class MagazonReviewaModel {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer review_id;
    private int rating;
    private String comment;
    private LocalDate review_date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private MagazonUsersModel user_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private MagazonProductsModel product_id;

    public Integer getReview_id() {
        return review_id;
    }

    public void setReview_id(Integer review_id) {
        this.review_id = review_id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getReview_date() {
        return review_date;
    }

    public void setReview_date(LocalDate review_date) {
        this.review_date = review_date;
    }

    public MagazonUsersModel getUser_id() {
        return user_id;
    }

    public void setUser_id(MagazonUsersModel user_id) {
        this.user_id = user_id;
    }

    public MagazonProductsModel getProduct_id() {
        return product_id;
    }

    public void setProduct_id(MagazonProductsModel product_id) {
        this.product_id = product_id;
    }
}

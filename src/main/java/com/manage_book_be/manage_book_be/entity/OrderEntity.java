package com.manage_book_be.manage_book_be.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "addressUser")
    private String addressUser;

    private double total;

    @Column(name = "dayOrder")
    private LocalDate dayOrder;

    @Column(name = "dayRecive")
    private LocalDate dayRecive;

    @OneToMany(mappedBy = "order" , fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BookEntity> booksOrder;

    public OrderEntity() {
    }

    public OrderEntity(int id, String addressUser, double total, LocalDate dayOrder, LocalDate dayRecive, Set<BookEntity> booksOrder) {
        this.id = id;
        this.addressUser = addressUser;
        this.total = total;
        this.dayOrder = dayOrder;
        this.dayRecive = dayRecive;
        this.booksOrder = booksOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddressUser() {
        return addressUser;
    }

    public void setAddressUser(String addressUser) {
        this.addressUser = addressUser;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDayOrder() {
        return dayOrder;
    }

    public void setDayOrder(LocalDate dayOrder) {
        this.dayOrder = dayOrder;
    }

    public LocalDate getDayRecive() {
        return dayRecive;
    }

    public void setDayRecive(LocalDate dayRecive) {
        this.dayRecive = dayRecive;
    }

    public Set<BookEntity> getBooksOrder() {
        return booksOrder;
    }

    public void setBooksOrder(Set<BookEntity> booksOrder) {
        this.booksOrder = booksOrder;
    }
}

package com.manage_book_be.manage_book_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name_author")
    private String nameAuthor;
    private int age;
    private String address;

    // đặt tên mappedBy phải giống tên bảng
    @JsonIgnore
    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<BookEntity> books;

    public AuthorEntity() {
    }

    public AuthorEntity(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public AuthorEntity(int id, String nameAuthor, int age, String address) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.age = age;
        this.address = address;
    }

    public AuthorEntity(int id, String nameAuthor, int age, String address, Set<BookEntity> books) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.age = age;
        this.address = address;
        this.books = books;
    }


    public Set<BookEntity> getBooks() {
        return books;
    }

    public void setBooks(Set<BookEntity> books) {
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                ", nameAuthor='" + nameAuthor + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}

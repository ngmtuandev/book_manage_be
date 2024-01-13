package com.manage_book_be.manage_book_be.Request;

public class AuthorRequest {

    private String nameAuthor;
    private int age;
    private String address;

    public AuthorRequest(String nameAuthor, int age, String address) {
        this.nameAuthor = nameAuthor;
        this.age = age;
        this.address = address;
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
}

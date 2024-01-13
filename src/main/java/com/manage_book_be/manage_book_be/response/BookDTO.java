package com.manage_book_be.manage_book_be.response;

public class BookDTO {
    private String nameBook;
    private int priceBook;

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getPriceBook() {
        return priceBook;
    }

    public void setPriceBook(int priceBook) {
        this.priceBook = priceBook;
    }

    public BookDTO() {
    }

    public BookDTO(String nameBook, int priceBook) {
        this.nameBook = nameBook;
        this.priceBook = priceBook;
    }
}

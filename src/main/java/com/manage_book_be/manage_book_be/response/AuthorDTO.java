package com.manage_book_be.manage_book_be.response;

import java.util.List;

public class AuthorDTO {

    private String nameAuthor;
    private String address;

    private List<BookDTO> bookDTO;

    public AuthorDTO(String nameAuthor, String address, List<BookDTO> bookDTO) {
        this.nameAuthor = nameAuthor;
        this.address = address;
        this.bookDTO = bookDTO;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<BookDTO> getBookDTO() {
        return bookDTO;
    }

    public void setBookDTO(List<BookDTO> bookDTO) {
        this.bookDTO = bookDTO;
    }

    public AuthorDTO() {
    }




}

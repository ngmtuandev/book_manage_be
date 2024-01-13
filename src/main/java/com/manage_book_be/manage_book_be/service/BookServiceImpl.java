package com.manage_book_be.manage_book_be.service;

import com.manage_book_be.manage_book_be.Request.BookRequest;
import com.manage_book_be.manage_book_be.entity.AuthorEntity;
import com.manage_book_be.manage_book_be.entity.BookEntity;
import com.manage_book_be.manage_book_be.repostory.BookDTO;
import com.manage_book_be.manage_book_be.repostory.BookRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositories bookRepositories;

    @Autowired
    AuthorService authorService;

    @Override
    public String save_book(BookEntity book) {

        System.out.println("book get author >>>>" + book.toString());

        AuthorEntity authorOfBook = book.getAuthor();

        System.out.println("authorOfBook " + authorOfBook.getNameAuthor());

        AuthorEntity checkExistAuthor = authorService.getAuthorInfo(authorOfBook.getNameAuthor());
        if (checkExistAuthor == null) {
            return "Author not found";
        }

        book.setAuthor(checkExistAuthor);
        bookRepositories.save(book);

        return "Book save success fully";

    }

    @Override
    public List<BookEntity> listBook() {
        System.out.println("get all");
        return bookRepositories.findAll();
    }

    @Override
    public BookEntity getItemBook(String book) {
        List<BookEntity> book_item = bookRepositories.findByName(book);
        if (book_item.isEmpty()) {
            return  null;
        }
        return book_item.get(0);
    }

    @Override
    public BookEntity editBook(String name, BookRequest bookRequest) {
        List<BookEntity> book_edit = bookRepositories.findByName(name);
        if (!book_edit.isEmpty()) {

            book_edit.get(0).setName(bookRequest.getName());
            book_edit.get(0).setPrice(bookRequest.getPrice());

        }
        bookRepositories.save(book_edit.get(0));
        return book_edit.get(0);
    }

    @Override
    public List<BookDTO> getAllBooksWithAuthorInfo() {
        List<BookEntity> books = bookRepositories.findAll();
        List<BookDTO> bookDtos = new ArrayList<>();

        for (BookEntity book : books) {
            BookDTO bookdto = new BookDTO();
            bookdto.setBookId(book.getId());
            bookdto.setAuthorId(book.getAuthor().getId());
            bookdto.setAuthorName(book.getAuthor().getNameAuthor());
            bookdto.setBookPrice(book.getPrice());
            bookdto.setBookTitle(book.getName());

            bookDtos.add(bookdto);

        }
    return bookDtos;
    }
}

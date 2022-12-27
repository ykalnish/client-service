package yk.clientservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yk.clientservice.model.Book;
import yk.clientservice.service.BooksService;

import java.util.List;

@RestController
@RequestMapping("/")
public class BooksController {
    @Autowired
    private BooksService booksService;

    @GetMapping(path = "/getAllBooksByFeignClient")
    public List<Book> getAllBooks() {
        return booksService.getAllBooks();
    }

    @GetMapping(path = "/getAllBooksByRestTemplate")
    public List<Book> data() {
        return booksService.data();
    }

}

package yk.clientservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import yk.clientservice.connector.BooksServiceConnector;
import yk.clientservice.model.Book;
import java.util.Arrays;
import java.util.List;

@Service
public class BooksService {

    private final BooksServiceConnector booksServiceConnector;
    private final RestTemplate restTemplate;

    public BooksService(BooksServiceConnector booksServiceConnector, RestTemplate restTemplate) {
        this.booksServiceConnector = booksServiceConnector;
        this.restTemplate = restTemplate;
    }

    public List<Book> getAllBooks() {
        return booksServiceConnector.getAllBooksList();
    }

    public List<Book> data() {
        ResponseEntity<Book[]> response =
                restTemplate.getForEntity(
                        "http://localhost:8081/data",
                        Book[].class);
        Book[] books = response.getBody();
        return Arrays.stream(books).toList();
    }

}

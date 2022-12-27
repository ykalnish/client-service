package yk.clientservice.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import yk.clientservice.config.FeignConfig;
import yk.clientservice.model.Book;
import java.util.List;

@FeignClient(name="book-service",
             url="localhost:8081",
             configuration = FeignConfig.class)
public interface BooksServiceConnector {

    @GetMapping("/show")
    List<Book> getAllBooksList();
}

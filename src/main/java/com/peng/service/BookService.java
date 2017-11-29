package com.peng.service;

import com.peng.model.Book;
import com.peng.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;

@Component
public class BookService {

    private String url;
    private RestTemplate restTemplate;

    @Autowired
    public BookService(@Value("${book_service_url}") String url) {
        this.url = url;
        this.restTemplate = new RestTemplate();
    }

    public Books getBook() {
        return getBooks();
    }

    private Books getBooks() {
        return restTemplate.exchange(url + "/books/v1/volumes?q=Pact&maxResults=1", GET, null, Books.class).getBody();
    }
}

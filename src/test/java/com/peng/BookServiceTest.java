package com.peng;

import au.com.dius.pact.consumer.*;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.peng.service.BookService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class BookServiceTest {

    @Rule
    public PactProviderRuleMk2 provider = new PactProviderRuleMk2("googleBookApi", "localhost", 8080, this);

    @Pact(provider="googleBookApi", consumer="consumer")
    public RequestResponsePact createFragment(PactDslWithProvider builder)
    {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json;charset=UTF-8");

        return builder.given("")
                .uponReceiving("a request to search book named 'Pact'")
                .path("/books/v1/volumes")
                .method("GET")
                .query("q=Pact&maxResults=1")
                .willRespondWith()
                .headers(headers)
                .status(200)
                .body(new PactDslJsonBody()
                        .stringValue("kind", "books#volumes")
                        .integerType("totalItems"))
                .toPact();
    }

    @Test
    @PactVerification("googleBookApi")
    public void runTest() throws IOException {
        Assert.assertNotNull(new BookService(provider.getUrl())
                .getBook().getTotalItems());
    }
}
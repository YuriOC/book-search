package io.github.yuri.book_search.main;

import io.github.yuri.book_search.models.Book;
import io.github.yuri.book_search.models.BookData;
import io.github.yuri.book_search.services.DataConvercy;
import io.github.yuri.book_search.services.DataFromAPI;

public class Main {
    private DataFromAPI api = new DataFromAPI();
    private final String ENDERECO = "http://gutendex.com/books/84";
    private DataConvercy convercy = new DataConvercy();

    public void test() {
        var json = api.getData(ENDERECO);
        BookData bookData = convercy.getData(json, BookData.class);
        Book book = new Book(bookData);
        System.out.println(book);
    }



}

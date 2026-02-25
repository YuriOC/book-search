package io.github.yuri.book_search.main;

import io.github.yuri.book_search.models.Book;
import io.github.yuri.book_search.models.BookDTO;
import io.github.yuri.book_search.models.BookResultsDTO;
import io.github.yuri.book_search.services.DataConvercy;
import io.github.yuri.book_search.services.DataFromAPI;

import java.util.List;
import java.util.Scanner;

public class Main {
    private DataFromAPI api = new DataFromAPI();
    private final String ENDERECOID = "http://gutendex.com/books/84";
    private final String ENDERECOTITLE = "http://gutendex.com/books?search=frankenstein%20shelley";
    private DataConvercy convercy = new DataConvercy();
    private Scanner scanner = new Scanner(System.in);

    public void test() {

        var option = -1;
        while (option != 0){
            var menu = """
                    1 - Buscar serie por ID
                    2 - Buscar serie por titulo
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    searchBookID();
                    break;
                case 2:
                    searchBookTitle();
                    break;
                case 0:
                    System.out.println("Closing...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void searchBookID() {
        var json = api.getData(ENDERECOID);
        BookDTO bookDTO = convercy.getData(json, BookDTO.class);
        Book book = new Book(bookDTO);
        System.out.println(book);
    }

    public void searchBookTitle() {
        var json = api.getData(ENDERECOTITLE);
        BookResultsDTO bookDTOS = convercy.getData(json, BookResultsDTO.class);
        List<Book> bookDTOList = bookDTOS.books()
                .stream()
                .map(Book::new)
                .toList();
        bookDTOList
                .stream()
                .forEach(System.out::println);

        //List<BookDTO> bookDTOList = convercy.getList(String.valueOf(bookDTOS), BookDTO.class);

    }


}

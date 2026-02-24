package io.github.yuri.book_search.main;

import io.github.yuri.book_search.models.Book;
import io.github.yuri.book_search.models.BookDTO;
import io.github.yuri.book_search.services.DataConvercy;
import io.github.yuri.book_search.services.DataFromAPI;

import java.util.Scanner;

public class Main {
    private DataFromAPI api = new DataFromAPI();
    private final String ENDERECO = "http://gutendex.com/books/84";
    private DataConvercy convercy = new DataConvercy();
    private Scanner scanner = new Scanner(System.in);

    public void test() {

        var option = -1;
        while (option != 0){
            var menu = """
                    1 - Buscar serie
                    
                    0 - Sair
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    searchBook();
                    break;
                case 0:
                    System.out.println("Closing...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public void searchBook() {
        var json = api.getData(ENDERECO);
        BookDTO bookDTO = convercy.getData(json, BookDTO.class);
        Book book = new Book(bookDTO);
        System.out.println(book);
    }


}

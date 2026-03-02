package io.github.yuri.book_search.main;

import io.github.yuri.book_search.models.Authors;
import io.github.yuri.book_search.models.Book;
import io.github.yuri.book_search.models.BookResultsDTO;
import io.github.yuri.book_search.repository.BookRepository;
import io.github.yuri.book_search.services.DataConvercy;
import io.github.yuri.book_search.services.DataFromAPI;

import java.util.Scanner;

public class Main {
    private final DataFromAPI api = new DataFromAPI();
    private final String ENDERECO = "http://gutendex.com/books?search=";
    private final DataConvercy convercy = new DataConvercy();
    private final Scanner scanner = new Scanner(System.in);
    private final BookRepository repository;

    public Main(BookRepository repository) {
        this.repository = repository;
    }

    public void test() {

        var option = -1;
        while (option != 0){
            var menu = """
                    1 - Buscar livro
                    2 - listar livros
                    3 - listar autores
                    4 - listar autores vivos
                                      
                    0 - Sair
                    """;

            System.out.println(menu);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite um titulo");
                    String userInput = scanner.nextLine();
                    searchBook(userInput);
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    showAuthors();
                    break;
                case 4:
                    System.out.println("Digite um ano");
                    Integer year = scanner.nextInt();
                    showAliveAuthors(year);
                    break;
                case 0:
                    System.out.println("Closing...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void showBooks() {
        repository.findAll().forEach(System.out::println);
    }

    public void searchBook(String userInput) {
        String endereco = ENDERECO + userInput;
        var json = api.getData(endereco);
        BookResultsDTO bookDTOS = convercy.getData(json, BookResultsDTO.class);
        Book book = bookDTOS.books()
                .stream()
                .findFirst()
                .map(Book::new)
                .orElse(null);

        if (book == null) {
            System.out.println("Book not found");
        } else {
            repository.save(book);
            System.out.println(book);
        }
    }

    public void showAuthors() {
        repository.findAll().stream()
                .map(Book::getAutores)
                .forEach(System.out::println);
    }

    public void showAliveAuthors(Integer authoryear) {
        repository.findAll().stream().filter(book -> {
            Authors autores = book.getAutores();

            return autores.getDeath() == null || autores.getDeath() > authoryear;
        }).forEach(System.out::println);
    }

}


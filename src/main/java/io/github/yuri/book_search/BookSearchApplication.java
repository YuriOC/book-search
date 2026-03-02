package io.github.yuri.book_search;

import io.github.yuri.book_search.main.Main;
import io.github.yuri.book_search.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookSearchApplication implements CommandLineRunner {
    @Autowired
    private BookRepository repository;

	static void main(String[] args) {SpringApplication.run(BookSearchApplication.class, args);}

    @Override
    public void run(String... args) throws Exception {
        Main main = new Main(repository);
        main.test();
    }
}

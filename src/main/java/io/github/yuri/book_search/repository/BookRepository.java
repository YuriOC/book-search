package io.github.yuri.book_search.repository;

import io.github.yuri.book_search.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

package io.github.yuri.book_search.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookResultsDTO(@JsonAlias("results") List<BookDTO> books) {
}

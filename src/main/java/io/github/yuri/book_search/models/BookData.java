package io.github.yuri.book_search.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(@JsonAlias("title") String titulo,
                       @JsonAlias("download_count") Integer sumario
                       ) {
}

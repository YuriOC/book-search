package io.github.yuri.book_search.models;

import java.util.List;

public class Book {
    private String titulo;
    private List<Authors> autores;
    private List<String> idiomas;
    private Integer downloads;

    public Book (BookDTO bookDTO){
        this.titulo = bookDTO.titulo();
        this.autores = bookDTO.autores()
                .stream()
                .map(Authors::new)
                .toList();
        this.idiomas = bookDTO.idiomas();
        this.downloads = bookDTO.downloads();
    }

    @Override
    public String toString() {
        return
                "titulo: " + titulo + ", autores: " + autores + ", idiomas: " + idiomas + ", downloads: " + downloads;
    }
}

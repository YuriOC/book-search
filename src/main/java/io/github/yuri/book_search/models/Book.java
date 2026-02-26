package io.github.yuri.book_search.models;

import java.util.List;

public class Book {
    private String titulo;
    private Authors autores;
    private String idiomas;
    private Integer downloads;

    public Book (BookDTO bookDTO){
        this.titulo = bookDTO.titulo();
        this.autores = bookDTO.autores()
                .stream()
                .findFirst()
                .map(Authors::new)
                .orElse(null);
        this.idiomas = bookDTO.idiomas()
                .stream()
                .findFirst()
                .orElse(null);
        this.downloads = bookDTO.downloads();
    }

    public Authors getAutores() {
        return autores;
    }

    @Override
    public String toString() {
        return
                "titulo: " + titulo + ", autor: " + autores + ", idioma: " + idiomas + ", downloads: " + downloads + '\'';
    }
}

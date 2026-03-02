package io.github.yuri.book_search.models;

import jakarta.persistence.*;


@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "author_id")
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

    public Book() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public void setAutores(Authors autores) {
        this.autores = autores;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    @Override
    public String toString() {
        return
                "titulo: " + titulo + ", autor: " + autores + ", idioma: " + idiomas + ", downloads: " + downloads + '\'';
    }
}

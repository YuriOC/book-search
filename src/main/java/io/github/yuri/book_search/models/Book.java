package io.github.yuri.book_search.models;

public class Book {
    private String titulo;
    private Integer sumario;

    public Book (BookData bookData){
        this.titulo = bookData.titulo();
        this.sumario = bookData.sumario();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return
                "titulo: " + titulo + ", sumario: " + sumario;
    }
}

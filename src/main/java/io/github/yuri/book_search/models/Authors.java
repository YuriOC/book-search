package io.github.yuri.book_search.models;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Authors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer birth;
    private Integer death;

    public Authors(AuthorsDTO authorsDTO) {
        this.name = authorsDTO.name();
        this.birth = authorsDTO.birth();
        this.death = authorsDTO.death();
    }

    public Authors() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirth() {
        return birth;
    }

    public void setBirth(Integer birth) {
        this.birth = birth;
    }

    public Integer getDeath() {
        return death;
    }

    public void setDeath(Integer death) {
        this.death = death;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", birth: " + birth +
                ", death: " + death;
    }
}

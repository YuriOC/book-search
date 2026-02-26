package io.github.yuri.book_search.models;

public class Authors {
    private String name;
    private Integer birth;
    private Integer death;

    public Authors(AuthorsDTO authorsDTO) {
        this.name = authorsDTO.name();
        this.birth = authorsDTO.birth();
        this.death = authorsDTO.death();
    }

    public String getName() {
        return name;
    }

    public Integer getBirth() {
        return birth;
    }

    public Integer getDeath() {
        return death;
    }

    @Override
    public String toString() {
        return "name: " + name +
                ", birth: " + birth +
                ", death: " + death;
    }
}

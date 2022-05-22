package pl.rybczynski.demo.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Category category;
    @NotNull
    private Boolean isAvailable;

    public Movie() {};

    public Movie(String title, Category category) {
        this.title = title;
        this.category = category;
    }

    public Movie(Long id, String title, Category category) {
        this.id = id;
        this.title = title;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

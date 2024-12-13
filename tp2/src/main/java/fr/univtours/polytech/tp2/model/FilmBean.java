package fr.univtours.polytech.tp2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FilmBean {
    @Id
    private Integer id;
    private String title;
    private Integer note;

    public FilmBean() {
        super();
    }
    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNote() {
        return note;
    }

    public void setNote(Integer note) {
        this.note = note;
    }
}

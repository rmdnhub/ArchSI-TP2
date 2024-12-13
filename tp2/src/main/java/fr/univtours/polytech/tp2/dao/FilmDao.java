package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.FilmBean;

public interface FilmDao {
    void createFilm(FilmBean film);

    List<FilmBean> getFilms();

    FilmBean getFilm(Integer id);

    void updateFilm(FilmBean film);

    void deleteFilm(FilmBean film);
}

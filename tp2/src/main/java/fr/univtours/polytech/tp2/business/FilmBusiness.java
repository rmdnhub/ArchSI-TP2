package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.model.FilmBean;

public interface FilmBusiness {
    void addFilm(FilmBean film);

    List<FilmBean> getAllFilms();

    FilmBean getFilmById(Integer id);

    void incrementNote(Integer id);

    void decrementNote(Integer id);

    void updateFilm(FilmBean film);

    void deleteFilm(Integer id);
}

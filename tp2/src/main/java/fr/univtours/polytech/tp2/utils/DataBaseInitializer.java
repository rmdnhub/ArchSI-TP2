package fr.univtours.polytech.tp2.utils;

import fr.univtours.polytech.tp2.business.FilmBusiness;
import fr.univtours.polytech.tp2.model.FilmBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class DataBaseInitializer {

    @Inject
    private FilmBusiness filmBusiness;

    @PostConstruct
    public void init() {
        FilmBean film1 = createFilm(1, "Inception", null);
        filmBusiness.addFilm(film1);

        FilmBean film2 = createFilm(2, "The Matrix", 4);
        filmBusiness.addFilm(film2);

        FilmBean film3 = createFilm(3, "Interstellar", 3);
        filmBusiness.addFilm(film3);

        FilmBean film4 = createFilm(4, "The Dark Knight", 5);
        filmBusiness.addFilm(film4);
    }

    /**
     * Helper method to create and populate a FilmBean instance.
     * 
     * @param id    The unique identifier of the film.
     * @param title The title of the film.
     * @param note  The initial note of the film (can be null).
     * @return A populated FilmBean object.
     */
    private FilmBean createFilm(Integer id, String title, Integer note) {
        FilmBean film = new FilmBean();
        film.setId(id);
        film.setTitle(title);
        film.setNote(note);
        return film;
    }
}
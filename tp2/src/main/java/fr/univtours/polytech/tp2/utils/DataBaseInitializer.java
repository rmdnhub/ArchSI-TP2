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
        // Ne définissez pas l'ID manuellement, laissez-le null
        FilmBean film1 = createFilm("Inception", null); // Note initiale = null
        filmBusiness.addFilm(film1);

        FilmBean film2 = createFilm("The Matrix", 4);
        filmBusiness.addFilm(film2);

        FilmBean film3 = createFilm("Interstellar", 3);
        filmBusiness.addFilm(film3);

        FilmBean film4 = createFilm("The Dark Knight", 5);
        filmBusiness.addFilm(film4);
    }

    /**
     * Helper method to create and populate a FilmBean instance.
     * 
     * @param title The title of the film.
     * @param note  The initial note of the film (can be null).
     * @return A populated FilmBean object.
     */
    private FilmBean createFilm(String title, Integer note) {
        FilmBean film = new FilmBean();
        // Ne pas définir l'ID manuellement
        film.setTitle(title);
        film.setNote(note);
        return film;
    }
}

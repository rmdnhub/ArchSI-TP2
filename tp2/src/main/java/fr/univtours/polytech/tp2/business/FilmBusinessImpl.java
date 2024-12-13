package fr.univtours.polytech.tp2.business;

import java.util.List;

import fr.univtours.polytech.tp2.dao.FilmDao;
import fr.univtours.polytech.tp2.model.FilmBean;
import jakarta.inject.Inject;
import jakarta.ejb.Stateless;

@Stateless
public class FilmBusinessImpl implements FilmBusiness {

    @Inject
    private FilmDao filmDao;

    @Override
    public void addFilm(FilmBean film) {
        filmDao.createFilm(film);
    }

    @Override
    public List<FilmBean> getAllFilms() {
        return filmDao.getFilms();
    }

    @Override
    public FilmBean getFilmById(Integer id) {
        return filmDao.getFilm(id);
    }

    @Override
    public void incrementNote(Integer id) {
        FilmBean film = getFilmById(id);
        if (film != null) {
            if (film.getNote() == null) {
                film.setNote(1); // RG1
            } else if (film.getNote() < 5) {
                film.setNote(film.getNote() + 1); // RG2
            }
            filmDao.updateFilm(film);
        }
    }

    @Override
    public void decrementNote(Integer id) {
        FilmBean film = getFilmById(id);
        if (film != null) {
            if (film.getNote() == null) {
                film.setNote(5); // RG3
            } else if (film.getNote() > 1) {
                film.setNote(film.getNote() - 1); // RG4
            }
            filmDao.updateFilm(film);
        }
    }

    @Override
    public void updateFilm(FilmBean film) {
        filmDao.updateFilm(film);
    }

    @Override
    public void deleteFilm(Integer id) {
        FilmBean film = getFilmById(id);
        if (film != null) {
            filmDao.deleteFilm(film);
        }
    }
}

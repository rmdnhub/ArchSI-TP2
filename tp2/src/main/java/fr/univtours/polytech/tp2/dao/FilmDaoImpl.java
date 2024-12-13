package fr.univtours.polytech.tp2.dao;

import java.util.List;

import fr.univtours.polytech.tp2.model.FilmBean;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.ejb.Stateless;

@Stateless
public class FilmDaoImpl implements FilmDao{

    @PersistenceContext(unitName = "tp2")
    private EntityManager em;

    @Override
    public void createFilm(FilmBean film) {
        em.persist(film);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<FilmBean> getFilms() {
        Query query = em.createQuery("SELECT f FROM FilmBean f");
        return query.getResultList();
    }

    @Override
    public FilmBean getFilm(Integer id) {
        return em.find(FilmBean.class, id);
    }

    @Override
    public void updateFilm(FilmBean film) {
        em.merge(film);
    }

    @Override
    public void deleteFilm(FilmBean film) {
        em.remove(em.contains(film) ? film : em.merge(film));
    }
}

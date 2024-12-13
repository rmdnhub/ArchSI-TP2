package fr.univtours.polytech.tp2.controller;

import java.io.IOException;
import java.util.List;

import fr.univtours.polytech.tp2.business.FilmBusiness;
import fr.univtours.polytech.tp2.business.ImdbBusiness;
import fr.univtours.polytech.tp2.model.FilmBean;
import fr.univtours.polytech.tp2.model.imdb.WsImdb;
import fr.univtours.polytech.tp2.model.imdb.Description;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/films")
public class FilmServlet extends HttpServlet {
    @Inject
    private FilmBusiness filmBusiness;
    @Inject
    private ImdbBusiness imdbBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            // Display form to add a new film
            req.getRequestDispatcher("/createFilm.jsp").forward(req, resp);
        } else {
            // Display list of films
            List<FilmBean> films = filmBusiness.getAllFilms();
            for (FilmBean film : films) {
                try {
                    // Fetch IMDb data for each film
                    WsImdb imdbData = imdbBusiness.searchMovieByTitle(film.getTitle());
                    if (imdbData != null && imdbData.getDescription() != null && !imdbData.getDescription().isEmpty()) {
                        Description description = imdbData.getDescription().get(0); // Get the first description
                        
                        // Populate IMDb data into FilmBean
                        film.setYear(String.valueOf(description.getYear()));
                        film.setActors(description.getActors());
                        film.setImgPoster(description.getImgPoster());
                    }
                } catch (Exception e) {
                    e.printStackTrace();  // Handle exception if IMDb API call fails
                }
            }

            req.setAttribute("films", films);
            req.getRequestDispatcher("/films.jsp").forward(req, resp);
        }
    }

    // Handle POST actions (creating, incrementing, decrementing ratings)
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            String title = req.getParameter("title");
            String noteStr = req.getParameter("note");

            Integer note = (noteStr != null && !noteStr.isEmpty()) ? Integer.valueOf(noteStr) : null;

            FilmBean newFilm = new FilmBean();
            newFilm.setTitle(title);
            newFilm.setNote(note);

            // Add the film to the database
            filmBusiness.addFilm(newFilm);

            resp.sendRedirect(req.getContextPath() + "/films");
        } else if ("increment".equals(action)) {
            Integer filmId = Integer.valueOf(req.getParameter("filmId"));
            filmBusiness.incrementNote(filmId);
            resp.sendRedirect(req.getContextPath() + "/films");
        } else if ("decrement".equals(action)) {
            Integer filmId = Integer.valueOf(req.getParameter("filmId"));
            filmBusiness.decrementNote(filmId);
            resp.sendRedirect(req.getContextPath() + "/films");
        }
    }
}

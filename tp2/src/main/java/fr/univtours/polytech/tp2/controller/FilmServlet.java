package fr.univtours.polytech.tp2.controller;

import java.io.IOException;

import fr.univtours.polytech.tp2.business.FilmBusiness;
import fr.univtours.polytech.tp2.model.FilmBean;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/films")
public class FilmServlet extends HttpServlet{
    @Inject
    private FilmBusiness filmBusiness;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            // Affiche le formulaire pour ajouter un film
            req.getRequestDispatcher("/createFilm.jsp").forward(req, resp);
        } else {
            // Affiche la liste des films
            req.setAttribute("films", filmBusiness.getAllFilms());
            req.getRequestDispatcher("/films.jsp").forward(req, resp);
        }
    }

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

            // Ajoute le film à la base de données
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

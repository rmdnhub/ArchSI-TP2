package fr.univtours.polytech.tp2.controller;

import java.io.IOException;
import java.util.List;

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
        List<FilmBean> films = filmBusiness.getAllFilms();
        req.setAttribute("films", films);
        req.getRequestDispatcher("/films.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        Integer filmId = Integer.valueOf(req.getParameter("filmId"));

        if ("increment".equals(action)) {
            filmBusiness.incrementNote(filmId);
        } else if ("decrement".equals(action)) {
            filmBusiness.decrementNote(filmId);
        }

        resp.sendRedirect(req.getContextPath() + "/films");
    }
}

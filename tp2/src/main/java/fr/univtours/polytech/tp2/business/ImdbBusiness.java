package fr.univtours.polytech.tp2.business;

import fr.univtours.polytech.tp2.model.imdb.WsImdb;

public interface ImdbBusiness {
    WsImdb searchMovieByTitle(String title);
}

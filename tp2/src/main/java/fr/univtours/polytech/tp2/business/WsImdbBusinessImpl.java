package fr.univtours.polytech.tp2.business;

import fr.univtours.polytech.tp2.model.imdb.WsImdb;
import jakarta.ejb.Stateless;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;

@Stateless
public class WsImdbBusinessImpl implements ImdbBusiness {

    @Override
    public WsImdb searchMovieByTitle(String title) {
        Client client = ClientBuilder.newClient();
        String apiUrl = "https://imdb.iamidiotareyoutoo.com/search?q=" + title;
        WebTarget target = client.target(apiUrl);
        Response response = target.request().get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            return response.readEntity(WsImdb.class);
        } else {
            throw new RuntimeException("Failed to fetch movie data from IMDb");
        }
    }
}

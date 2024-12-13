package fr.univtours.polytech.tp2.rest;

import fr.univtours.polytech.tp2.business.ImdbBusiness;
import fr.univtours.polytech.tp2.model.imdb.WsImdb;
import jakarta.ejb.EJB;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("v1")
public class ImdbRest {

    @EJB
    private ImdbBusiness imdbBusiness;

    @GET
    @Path("/{title}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response searchMovieByTitle(@PathParam("title") String title) {
        try {
            WsImdb wsImdb = imdbBusiness.searchMovieByTitle(title);
            return Response.ok(wsImdb).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Failed to fetch movie data from IMDb: " + e.getMessage())
                           .build();
        }
    }
}

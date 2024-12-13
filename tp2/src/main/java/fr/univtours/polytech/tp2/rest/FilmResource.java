// package fr.univtours.polytech.tp2.rest2;

// import fr.univtours.polytech.tp2.business.FilmBusiness;
// import fr.univtours.polytech.tp2.model.FilmBean;
// import fr.univtours.polytech.tp2.model.FilmFilter;
// import jakarta.ejb.EJB;
// import jakarta.ws.rs.*;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;
// import java.util.List;

// @Path("/films")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class FilmResource {

//     @EJB
//     private FilmBusiness filmBusiness;

//     // Afficher la liste des films avec des filtres
//     @GET
//     public Response getFilms(
//             @QueryParam("title") String title,
//             @QueryParam("rating") Integer rating,
//             @QueryParam("sort") String sort) {

//         FilmFilter filter = new FilmFilter(title, rating, sort);
//         List<FilmBean> films = filmBusiness.getFilmsWithFilter(filter);
//         return Response.ok(films).build();
//     }

//     // Afficher un film particulier avec son ID
//     @GET
//     @Path("/{id}")
//     public Response getFilm(@PathParam("id") Integer id) {
//         FilmBean film = filmBusiness.getFilmById(id);
//         if (film != null) {
//             return Response.ok(film).build();
//         } else {
//             return Response.status(Response.Status.NOT_FOUND).entity("Film not found").build();
//         }
//     }

//     // Créer un nouveau film
//     @POST
//     public Response createFilm(FilmBean film) {
//         filmBusiness.createFilm(film);
//         return Response.status(Response.Status.CREATED).entity(film).build();
//     }

//     // Mise à jour partielle des informations d'un film
//     @PATCH
//     @Path("/{id}")
//     public Response updateFilm(@PathParam("id") Integer id, FilmBean film) {
//         FilmBean existingFilm = filmBusiness.getFilmById(id);
//         if (existingFilm == null) {
//             return Response.status(Response.Status.NOT_FOUND).entity("Film not found").build();
//         }
//         film.setId(id);
//         filmBusiness.updateFilm(film);
//         return Response.ok(film).build();
//     }

//     // Mise à jour totale des informations d'un film
//     @PUT
//     @Path("/{id}")
//     public Response updateFilmComplete(@PathParam("id") Integer id, FilmBean film) {
//         FilmBean existingFilm = filmBusiness.getFilmById(id);
//         if (existingFilm == null) {
//             return Response.status(Response.Status.NOT_FOUND).entity("Film not found").build();
//         }
//         film.setId(id);
//         filmBusiness.updateFilm(film);
//         return Response.ok(film).build();
//     }

//     // Supprimer un film
//     @DELETE
//     @Path("/{id}")
//     public Response deleteFilm(@PathParam("id") Integer id) {
//         FilmBean film = filmBusiness.getFilmById(id);
//         if (film == null) {
//             return Response.status(Response.Status.NOT_FOUND).entity("Film not found").build();
//         }
//         filmBusiness.deleteFilm(film);
//         return Response.status(Response.Status.NO_CONTENT).build();
//     }
// }

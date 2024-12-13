<%@ page contentType="text/html;charset=ISO-8859-1" language="java"
pageEncoding="ISO-8859-1" %> <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="ISO-8859-1" />
    <title>Liste des Films</title>
    <style>
      a {
        text-decoration: none;
        padding: 10px 20px;
        background-color: #4caf50;
        color: white;
        border-radius: 5px;
        font-size: 16px;
        font-weight: bold;
        transition: background-color 0.3s ease, transform 0.2s ease;
      }
      table {
        width: 70%;
        margin: 20px auto;
        border-collapse: collapse;
      }
      th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
      }
      th {
        background-color: #f4f4f4;
      }
      td.actions button {
        margin: 0 5px;
        padding: 5px 10px;
        font-size: 14px;
      }
      td.actions {
        text-align: center;
      }
      .filmCliquable {
        cursor: pointer;
        background-color: #f9f9f9;
      }
      .filmCliquable:hover {
        background-color: #e0e0e0;
      }
    </style>
  </head>
  <body>
    <a href="films?action=create">Ajouter un Film</a>
    <h1 style="text-align: center">Liste des Films</h1>
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Titre</th>
          <th>Annee</th> <!-- Display year -->
          <th>Acteurs</th> <!-- Display actors -->
          <th>Note</th>
          <th>Poster</th>  <!-- Display poster image -->
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="film" items="${films}">
          <tr class="filmCliquable">
            <td>${film.id}</td>
            <td>${film.title}</td>
            <td>${film.year}</td>  <!-- Display year -->
            <td>${film.actors}</td>  <!-- Display actors -->
            <td>${film.note != null ? film.note : '-'}</td>
            <td>
              <img src="${film.imgPoster}" alt="Poster" width="100"/>
            </td>
            
            <td class="actions">
              <form method="post" action="${pageContext.request.contextPath}/films" style="display: inline">
                <input type="hidden" name="filmId" value="${film.id}" />
                <input type="hidden" name="action" value="decrement" />
                <button type="submit">-</button>
              </form>
              <span>${film.note != null ? film.note : '-'}</span>
              <form method="post" action="${pageContext.request.contextPath}/films" style="display: inline">
                <input type="hidden" name="filmId" value="${film.id}" />
                <input type="hidden" name="action" value="increment" />
                <button type="submit">+</button>
              </form>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </body>
</html>

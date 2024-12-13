package fr.univtours.polytech.tp2.model;

public class FilmFilter {

    private String title;
    private Integer rating;
    private String sort;

    public FilmFilter(String title, Integer rating, String sort) {
        this.title = title;
        this.rating = rating;
        this.sort = sort;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}

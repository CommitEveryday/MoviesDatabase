package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Movie {
    private Integer id;
    private String title;
    private Date premiere;
    private Set<Review> reviews = new HashSet<Review>();
    private Set<Genre> genres = new HashSet<Genre>();
    private Set<Person> actors = new HashSet<Person>();
    private Set<Person> directors = new HashSet<Person>();

    public Set<Person> getDirectors() {
        return directors;
    }

    public void setDirectors(Set<Person> directors) {
        this.directors = directors;
    }

    public Set<Person> getActors() {
        return actors;
    }

    public void setActors(Set<Person> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPremiere() {
        return premiere;
    }

    public void setPremiere(Date premiere) {
        this.premiere = premiere;
    }
}

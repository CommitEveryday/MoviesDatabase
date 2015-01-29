package entity;

import java.util.HashSet;
import java.util.Set;

public class Genre {
    private Integer id;
    private String name;

    public Set<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }

    private Set<Movie> movies = new HashSet<Movie>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

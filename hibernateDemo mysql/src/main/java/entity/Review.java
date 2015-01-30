package entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "message", unique = false, nullable = false)
    @Type(type="text")
    private String message;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user_acount")
    private User_acount user_acount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_movie")
    private Movie movie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_rating")
    private Rating rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User_acount getUser_acount() {
        return user_acount;
    }

    public void setUser_acount(User_acount user_acount) {
        this.user_acount = user_acount;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}

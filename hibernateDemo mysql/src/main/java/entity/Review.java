package entity;

public class Review {
    private Integer id;
    private String message;
    private User_acount user_acount;
    private Movie movie;
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

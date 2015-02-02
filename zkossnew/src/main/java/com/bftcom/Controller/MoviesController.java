package com.bftcom.Controller;

import com.bft.bstu.pv41.bezkrovnuy.entity.Movie;
import com.bft.bstu.pv41.bezkrovnuy.entity.Rating;
import com.bft.bstu.pv41.bezkrovnuy.entity.Review;
import com.bft.bstu.pv41.bezkrovnuy.entity.User_acount;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import  org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;
import com.bft.bstu.pv41.bezkrovnuy.Service.HibernateFactory;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

public class MoviesController  extends SelectorComposer<Component> {
    @Wire
    private Grid moviesTable;
    @Wire
    private Vbox reviewsVBox;
    @Wire
    private Vbox selReviewVBox;
    @Wire
    private Label reviewsLabel;
    @Wire
    private Grid reviewsTable;
    @Wire
    private Combobox userComboBox;
    @Wire
    private Combobox ratingComboBox;
    @Wire
    private Textbox messageTextBox;

    private Movie selectMovie;


    @Override
    public void doAfterCompose(Component comp) throws Exception{
        super.doAfterCompose(comp);

//        Calendar cal = Calendar.getInstance();
//        cal.getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        Clients.showNotification(sdf.format(cal.getTime()));

        List<Movie> movies = HibernateFactory.movieHiber.getAll(Movie.class);
        fillTable(movies);
    }

    private void fillTable(List<Movie> movies) {
        Listbox lb = new Listbox();
        Rows rows = moviesTable.getRows();
        for (Movie movie: movies) {
            rows.appendChild(constructRow(movie));
        }
    }

    private Row constructRow(final Movie movie) {
        Row row = new Row();
        row.appendChild(new Label(movie.getId().toString()));
        row.appendChild(new Label(movie.getTitle()));
        row.appendChild(new Label(movie.getPremiere().toString()));
        row.appendChild(new Label(join(", ", movie.getGenres())));
        row.appendChild(new Label(join(", ", movie.getDirectors())));
        row.appendChild(new Label(join(", ", movie.getActors())));

        Button editBtn = new Button("Показать рецензии");
        row.appendChild(editBtn);
        editBtn.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
//                Clients.showNotification(movie.getId().toString());
                ShowReviews(movie);
            }
        });
        return row;
    }

    private String join(String separator, Collection col) {
        StringBuilder sb = new StringBuilder();
        if (col == null)
            return sb.toString();
        Iterator<Object> iter = col.iterator();
        if (iter.hasNext()) {
            sb.append(iter.next().toString());
            while (iter.hasNext()) {
                sb.append(separator).append(iter.next().toString());
            }
        }
        return sb.toString();
    }

    private void ShowReviews(Movie movie) {
        selectMovie = movie;
        reviewsVBox.setVisible(true);
        reviewsLabel.setValue("Рецензии на фильм " + movie.getTitle());
        Rows allMyRows = reviewsTable.getRows();
//        if (allMyRows!=null)
//            reviewsTable.removeChild(allMyRows);
//
        allMyRows.getChildren().clear();
        allMyRows = reviewsTable.getRows();
        for (Review review: movie.getReviews()) {
            allMyRows.appendChild(constructReviewRow(review));
        }
    }

    private Row constructReviewRow(final Review review) {
        Row row = new Row();
        row.appendChild(new Label(review.getUser_acount().getLogin()));
        row.appendChild(new Label(review.getRating().getDescription()));
        row.appendChild(new Label(review.getMessage()));

//        Button editBtn = new Button("Редактировать");
//        row.appendChild(editBtn);
//        editBtn.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
//            @Override
//            public void onEvent(Event event) throws Exception {
//                //
//            }
//        });

        Button deleteBtn = new Button("Удалить");
        row.appendChild(deleteBtn);
        deleteBtn.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
            @Override
            public void onEvent(Event event) throws Exception {
                HibernateFactory.reviewHiber.remove(review);
                selectMovie.getReviews().remove(review);
                ShowReviews(selectMovie);
            }
        });
        return row;
    }

    @Listen("onClick = #addedReview")
    public void addedReview(){
        if (selectMovie==null) {
            Clients.showNotification("Не выбран фильм!");
            return;
        }
        selReviewVBox.setVisible(true);
        userComboBox.setModel(new ListModelList<User_acount>(HibernateFactory.user_acountHiber.getAll(User_acount.class)));
        ratingComboBox.setModel(new ListModelList<Rating>(HibernateFactory.ratingHiber.getAll(Rating.class)));

    }

    @Listen("onClick = #cancelReviewBt")
    public void cancelReview(){
        selReviewVBox.setVisible(false);
    }

    @Listen("onClick = #okReviewBt")
    public void okReview(){
        if (selectMovie==null) {
            Clients.showNotification("Не выбран фильм!");
            return;
        }
        selReviewVBox.setVisible(false);
        Review newReview = new Review();
        newReview.setMovie(selectMovie);
        newReview.setRating((Rating) ratingComboBox.getSelectedItem().getValue());
        newReview.setUser_acount((User_acount) userComboBox.getSelectedItem().getValue());
        newReview.setMessage(messageTextBox.getValue());
        HibernateFactory.reviewHiber.add(newReview);
        selectMovie.getReviews().add(newReview);
        ShowReviews(selectMovie);
    }
}

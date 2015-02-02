package com.bft.bstu.pv41.bezkrovnuy.Service;

import com.bft.bstu.pv41.bezkrovnuy.entity.*;

public final class HibernateFactory {
    public static HibernateUtil<Genre, Integer> genreHiber = new HibernateUtil<Genre, Integer>();
    public static HibernateUtil<Movie, Integer> movieHiber = new HibernateUtil<Movie, Integer>();
    public static HibernateUtil<Person, Integer> personHiber = new HibernateUtil<Person, Integer>();
    public static HibernateUtil<Rating, Integer> ratingHiber = new HibernateUtil<Rating, Integer>();
    public static HibernateUtil<Review, Integer> reviewHiber = new HibernateUtil<Review, Integer>();
    public static HibernateUtil<User_acount, Integer> user_acountHiber = new HibernateUtil<User_acount, Integer>();
}

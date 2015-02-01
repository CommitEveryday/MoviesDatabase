import dao.entity.AuthorDAO;
import dao.entity.BookDAO;
import dao.hibernate.AuthorDAOImpl;
import dao.hibernate.BookDAOImpl;
import entity.*;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            List<Movie> movies=(List<Movie>)session.createCriteria(Movie.class).list();
            System.out.println(movies.size());
            Movie newMovie = new Movie();
            newMovie.setTitle("The Matrix");
            SimpleDateFormat textFormat = new SimpleDateFormat("yyyy-MM-dd");
            String paramDateAsString = "1999-03-31";
            Date myDate = null;
            myDate = textFormat.parse(paramDateAsString);
            newMovie.setPremiere(myDate);
            List<Person> persons=(List<Person>)session.createCriteria(Person.class).list();
//            System.out.println(persons.size());
//            newMovie.getActors().add(persons.get(0));

            Rating rating1 = new Rating();
            rating1.setDescription("отлично");
            rating1.setId(5);
            User_acount account1 = new User_acount();
            account1.setLogin("test");
            account1.setPassword("password");

            Review rev = new Review();
            rev.setMessage("отличный фильм!");
            rev.setUser_acount(account1);
            rev.setRating(rating1);
            rev.setMovie(movies.get(0));

            List<Rating> ratings=(List<Rating>)session.createCriteria(Rating.class).list();

            session.beginTransaction();
//            session.save(newMovie);
//            Person keano = persons.get(0);
//
//           session.delete(persons.get(0));
            session.delete(ratings.get(0));
//            session.save(rating1);
//            session.save(account1);
//            session.save(rev);

            session.getTransaction().commit();
//            for (Movie movie : keano.getActorIn())
//                System.out.println(movie.getTitle());

        } catch (Exception ex) {
            System.out.println("exception");
            System.out.println(ex.toString());
        }
        System.out.println(HibernateUtil.getSessionFactory().isClosed());
        HibernateUtil.getSessionFactory().close();
        if (1==1)
            return;

        BookDAO bookDAO = new BookDAOImpl();

        Book book = new Book();
        book.setTitle("book1");
        book.setDescription("book1");
        book.setIsbn(1);
        bookDAO.addBook(book);
        Book book2 = new Book();
        book2.setTitle("book2");
        book2.setDescription("book2");
        book2.setIsbn(2);
        bookDAO.addBook(book2);
        Book book3 = new Book();
        book3.setTitle("book3");
        book3.setDescription("book3");
        book3.setIsbn(3);
        bookDAO.addBook(book3);

        List<Book> books  = bookDAO.getBooks();

        AuthorDAO authorDAO = new AuthorDAOImpl();
        Author author = new Author();
        author.setLastName("A");
        author.setFirstName("A");
        author.setAge(1);
        author.setBooks(new HashSet<Book>(books));

        authorDAO.addAuthor(author);



    }
}

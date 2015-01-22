package dao.hibernate;

import dao.entity.BookDAO;
import entity.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;

/**
 * Created by user on 14.10.2014.
 */
public class BookDAOImpl implements BookDAO {

    @Override
    public void addBook(Book book) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void deleteBook(Book book) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(book);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Book getBook(Integer id) {
        Session session = null;
        Book book = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            book = (Book) session.get(Book.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> getBooks() {
        Session session = null;
        List<Book> books = Collections.emptyList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            books = session.createCriteria(Book.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return books;
    }
}

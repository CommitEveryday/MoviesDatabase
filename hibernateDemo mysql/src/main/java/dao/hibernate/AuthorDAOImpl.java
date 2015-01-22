package dao.hibernate;

import dao.entity.AuthorDAO;
import entity.Author;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.Collections;
import java.util.List;

/**
 * Created by user on 14.10.2014.
 */
public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public void addAuthor(Author author) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(author);
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
    public void deleteAuthor(Author author) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(author);
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
    public Author getAuthor(Long id) {
        Session session = null;
        Author author = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            author = (Author) session.get(Author.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return author;
    }

    @Override
    public List<Author> getAuthors() {
        Session session = null;
        List<Author> authors = Collections.emptyList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            authors = session.createCriteria(Author.class).list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return authors;
    }
}

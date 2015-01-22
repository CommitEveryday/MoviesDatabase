package dao.entity;

import entity.Book;

import java.util.List;

/**
 * Created by user on 14.10.2014.
 */
public interface BookDAO {
    public void addBook(Book book);
    public void deleteBook(Book book);
    public Book getBook(Integer id);
    public List<Book> getBooks();
}

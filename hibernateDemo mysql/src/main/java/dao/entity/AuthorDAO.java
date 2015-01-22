package dao.entity;

import entity.Author;

import java.util.List;

/**
 * Created by user on 14.10.2014.
 */
public interface AuthorDAO {
    public void addAuthor(Author author);
    public void deleteAuthor(Author author);
    public Author getAuthor(Long id);
    public List<Author> getAuthors();
}

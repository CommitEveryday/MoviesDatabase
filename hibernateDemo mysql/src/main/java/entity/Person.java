package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Person {
    private Integer id;
    private String name;
    private String surname;
    private Date birth;
    private Set<Movie> actorIn = new HashSet<Movie>();
    private Set<Movie> directorIn = new HashSet<Movie>();

    public Set<Movie> getActorIn() {
        return actorIn;
    }

    public void setActorIn(Set<Movie> actorIn) {
        this.actorIn = actorIn;
    }

    public Set<Movie> getDirectorIn() {
        return directorIn;
    }

    public void setDirectorIn(Set<Movie> directorIn) {
        this.directorIn = directorIn;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}

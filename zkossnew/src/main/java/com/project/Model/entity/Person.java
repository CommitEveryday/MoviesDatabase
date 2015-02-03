package com.project.Model.entity;


import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name", unique = false, nullable = false, length = 100)
    private String name;
    @Column(name = "surname", unique = false, nullable = true, length = 100)
    private String surname;
    @Column(name = "birth", unique = false, nullable = false)
    @Type(type="date")
    private Date birth;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "actor",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_movie"))
    private Set<Movie> actorIn = new HashSet<Movie>();
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "director",
            joinColumns = @JoinColumn(name = "id_person"),
            inverseJoinColumns = @JoinColumn(name = "id_movie"))
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

    @Override
    public String toString() {
        return name + ((surname!=null)?" " + surname:"");
    }
}

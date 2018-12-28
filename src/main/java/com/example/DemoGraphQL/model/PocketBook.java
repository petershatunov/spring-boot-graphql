package com.example.DemoGraphQL.model;

import javax.persistence.*;

@Entity
@Table(name = "PocketBook")
public class PocketBook implements GenericBook{

    @Id
    @Column(name="book_id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="inn", nullable = false)
    private String inn;

    @ManyToOne
    @JoinColumn(name = "author_id",
                    nullable = false, updatable = false)
    private Author author;

    public PocketBook(String title, String inn, Author author) {
        this.title = title;
        this.inn = inn;
        this.author = author;
    }

    public PocketBook() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInn() {
        return inn;
    }

    public String getIsbn() {
        return null;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public Integer getPageCount() {
        return null;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

}

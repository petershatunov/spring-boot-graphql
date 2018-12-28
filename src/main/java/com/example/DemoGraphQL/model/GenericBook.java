package com.example.DemoGraphQL.model;

public interface GenericBook {

    Long getId();

    String getTitle();

    String getInn();

    String getIsbn();

    Author getAuthor();

    Integer getPageCount();
    
}

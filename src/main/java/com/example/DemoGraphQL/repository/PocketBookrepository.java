package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.PocketBook;
import org.springframework.data.repository.CrudRepository;

public interface PocketBookrepository extends CrudRepository<PocketBook, Long> {

    PocketBook findByTitle(String title);

}

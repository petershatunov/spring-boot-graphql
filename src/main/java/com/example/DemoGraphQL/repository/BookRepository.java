package com.example.DemoGraphQL.repository;

import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByAuthor(Author author);

    Book findByTitle(String title);

}

package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.*;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.OrganizationRepository;
import com.example.DemoGraphQL.repository.PocketBookrepository;

import java.util.Collections;
import java.util.List;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PocketBookrepository pocketBookrepository;
    private OrganizationRepository organizationRepository;

    public Query(AuthorRepository authorRepository, BookRepository bookRepository, PocketBookrepository pocketBookrepository, OrganizationRepository organizationRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.pocketBookrepository = pocketBookrepository;
        this.organizationRepository = organizationRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public Book findBookById(Long id) {
        return bookRepository.findOne(id);
    }

    public long countAuthors() {
        return authorRepository.count();
    }

    public Book findByAuthor(Long authorId) {
        Author authorDTO = authorRepository.findOne(authorId);
        return bookRepository.findByAuthor(authorDTO);
    }

    public Organization getOrganizationByInn(String inn) {
        return organizationRepository.findByInn(inn);
    }

    public Iterable<Organization> getOrganizations() {
        return organizationRepository.findAll();
    }

    public GenericBook findByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        PocketBook pocketBook = pocketBookrepository.findByTitle(title);
        //GenericBook genericBook = new GenericBook();
        if (book!=null) {
//            genericBook.id = book.getId();
//            genericBook.isbn = book.getIsbn();
//            genericBook.title = book.getTitle();
//            genericBook.author = book.getAuthor();
//            genericBook.pageCount = book.getPageCount();
//            return genericBook;
            return book;
        }

//        genericBook.id = pocketBook.getId();
//        genericBook.title = pocketBook.getTitle();
//        genericBook.inn = pocketBook.getInn();
//        genericBook.author = pocketBook.getAuthor();
//        return genericBook;
        return pocketBook;
    }
}

package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.exception.BookNotFoundException;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Organization;
import com.example.DemoGraphQL.model.Party;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.OrganizationRepository;
import com.example.DemoGraphQL.repository.PartyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Slf4j
public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private OrganizationRepository organizationRepository;
    private PartyRepository partyRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, OrganizationRepository organizationRepository, PartyRepository partyRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.organizationRepository = organizationRepository;
        this.partyRepository = partyRepository;
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }

//    public Organization createOrganization(String fullName,
//                    String ogrn,
//                    String ogrnAssignDate,
//                    String ogrnAuthority,
//                    String isAuthority,
//                    String isPublicOwnership,
//                    String isPublicPayer,
//                    String legalCapacity,
//                    String isTerminated){
//
//        Party party = new Party();
//        party.setPartyTypeId("3"); // todo
//        partyRepository.save(party);
//
//        Organization organization = new Organization();
//        organization.setId(party.getPartyId());
//        organization.setFullName(fullName);
//        organization.setOgrn(ogrn);
//        organization.setOgrnAssignDate(new Date());
//        organization.setOgrnAuthority(ogrnAuthority);
//        organization.setIsAuthority(isAuthority);
//        organization.setIsPublicOwnership(isPublicOwnership);
//        organization.setIsPublicPayer(isPublicPayer);
//        organization.setLegalCapacity(legalCapacity);
//        organization.setIsTerminated(isTerminated);
//        organization.setDateFrom(new Date());
//        return organizationRepository.save(organization);
//    }

    @Transactional
    public Organization createOrganization(Organization organization){
        Party party = new Party();
        party.setPartyTypeId("3"); // todo
        partyRepository.save(party);

        log.info(party.toString());

        organization.setId(party.getPartyId());
//        organization.setDateFrom(organization.getDateFrom());
//        organization.setOgrnAssignDate(organization.getOgrnAssignDate());

        return organizationRepository.save(organization);
    }

}

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class Mutation implements GraphQLMutationResolver {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private PartyRepository partyRepository;

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

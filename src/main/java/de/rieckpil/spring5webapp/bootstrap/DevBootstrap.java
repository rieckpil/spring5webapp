package de.rieckpil.spring5webapp.bootstrap;

import de.rieckpil.spring5webapp.model.Author;
import de.rieckpil.spring5webapp.model.Book;
import de.rieckpil.spring5webapp.model.Publisher;
import de.rieckpil.spring5webapp.repositories.AuthorRepository;
import de.rieckpil.spring5webapp.repositories.BookRepository;
import de.rieckpil.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){

        Publisher oreily= new Publisher("OReiley", "America");

        publisherRepository.save(oreily);

        Author eric2 = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123", oreily);
        eric2.getBooks().add(ddd);
        ddd.getAuthors().add(eric2);

        authorRepository.save(eric2);
        bookRepository.save(ddd);

        Author rod = new Author("rod", "johnson");
        Book noEJB = new Book("J2EE Development without EJB", "12121", oreily);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}

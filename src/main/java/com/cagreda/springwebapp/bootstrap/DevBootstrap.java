package com.cagreda.springwebapp.bootstrap;

import com.cagreda.springwebapp.model.Author;
import com.cagreda.springwebapp.model.Book;
import com.cagreda.springwebapp.model.Publisher;
import com.cagreda.springwebapp.repositories.AuthorRepository;
import com.cagreda.springwebapp.repositories.BookRepository;
import com.cagreda.springwebapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        iniData();
    }

    private void iniData() {

        Publisher hc = new Publisher("Harper Collin", "siempreviva");
        Author cris = new Author("Jess", "Cortes");
        Book ddd = new Book("Domain Driven Model", "999", hc);
        cris.getBooks().add(ddd);
        ddd.getAuthors().add(cris);
        saveEntity(hc,cris, ddd);

        Publisher tt = new Publisher("TOM AND TOM", "NUNCA VIVA");
        Author juan = new Author("Memo", "Ceballos");
        Book noEjb = new Book("J2EE Development Without EJB", "888", tt);
        juan.getBooks().add(noEjb);
        noEjb.getAuthors().add(juan);
        saveEntity(tt,juan,noEjb);

    }

    private void saveEntity(Publisher publisher, Author author, Book book){
        publisherRepository.save(publisher);
        authorRepository.save(author);
        bookRepository.save(book);
    }

}

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.common.Address;
import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jRowling = new Author("JK", "Rowling");
        Book harryPotter = new Book("Harry Potter", "12345");
        jRowling.getBooks().add(harryPotter);
        harryPotter.getAuthors().add(jRowling);

        authorRepository.save(jRowling);
        bookRepository.save(harryPotter);

        Author jTolkien =  new Author("JRR", "Tolkien");
        Book lordOfTheRings = new Book("LordOfTheRings", "12346");
        jTolkien.getBooks().add(lordOfTheRings);
        lordOfTheRings.getAuthors().add(jTolkien);


        authorRepository.save(jTolkien);
        bookRepository.save(lordOfTheRings);

        Publisher bPublishing = new Publisher("bonusPublishing",
                "310 New Street, Birmingham, West Midlands, 3 4DH");

        lordOfTheRings.setPublisher(bPublishing);
        harryPotter.setPublisher(bPublishing);
        publisherRepository.save(bPublishing);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        Iterator<Book> books = bookRepository.findAll().iterator();
        System.out.println("Books:");
        while(books.hasNext()) {
            System.out.println(books.next());
        }

        System.out.println("Publisher Count: " + publisherRepository.count());


    }
}

package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        Iterator<Book> books = bookRepository.findAll().iterator();
        System.out.println("Books:");
        while(books.hasNext()) {
            System.out.println(books.next());
        }


    }
}

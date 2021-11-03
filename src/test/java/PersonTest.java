import model.Books;
import model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import services.LibraryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {
    LibraryServiceImpl libraryService;
    Person person;


    @BeforeEach
    void setUp(){

        Books books1 = new Books("Biology");
        Person person = new Person();
        libraryService = new LibraryServiceImpl();
    }


    @Test
    void stackBook(){
      assertNotNull(libraryService.getBookList());
    }

    @Test
    void borrowBook(){
        Person person1 = new Person();

        Books books = new Books("Physics");

        libraryService.stackBook(books,2);
        assertTrue(libraryService.getBookList().containsKey(books));
    }
}

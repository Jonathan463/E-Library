package services;

import model.Books;
import model.Person;

public interface LibraryService {
    void stackBook(Books book, int size);
    void borrowBookOnPriority(Person person, String bookName);
}

package model;

import services.LibraryServiceImpl;

import java.util.Map;
import java.util.Objects;

public class Books {
    private String bookName;

    public Books(String bookName){
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return Objects.equals(bookName, books.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }


    @Override
    public String toString() {
        return bookName ;
    }
}

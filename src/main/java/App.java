import enums.PersonType;
import model.Books;
import model.Person;
import services.LibraryServiceImpl;

public class App {
    public static void main(String [] args) throws Exception {

        Books book1 = new Books("Physics");
        Books book2 = new Books("Biology");


        LibraryServiceImpl lib = new LibraryServiceImpl();
        lib.stackBook(book1,1);
        lib.stackBook(book2,1);
        //lib.stackBook(book2,2);





        System.out.println("There are "+lib.getBookList().get(book1)+" " +book1+ " Book left");
        Person student = new Person("Jonathan", PersonType.STUDENT);
        Person teacher = new Person("CHijioke",PersonType.TEACHER);

        lib.joinQueue(student);
        lib.joinQueue(teacher);
        lib.borrowBookOnPriority(student,"Biology");
        lib.borrowBookOnPriority(teacher,"Biology");

//        lib.borrowBookOnFIFO(student,"Biology");
//        lib.borrowBookOnFIFO(teacher,"Biology");

//        lib.borrowBookOnFIFO(student,"Physics");
//        lib.borrowBookOnFIFO(teacher,"Physics");
        //System.out.println("Jonathan Borrowed " +book1);
        //System.out.println("We have "+lib.getBookList().get(book1)+" " +book1+ " Book left " + lib.getBookList());
    }
}

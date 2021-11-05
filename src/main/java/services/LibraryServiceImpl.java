package services;

import model.Books;
import model.Person;

import java.util.*;

public class LibraryServiceImpl implements LibraryService {
    //private Person person;
    public LibraryServiceImpl(){

    }

     private static Map<Books,Integer> bookList = new HashMap<>();
    Queue<Person> personQueue = new LinkedList<>();
    Queue<Person> priorityQueue = new PriorityQueue<>(new Comparator<Person>() {
        @Override
        public int compare(Person person1, Person person2) {
            if(person1.getPriority()>person2.getPriority()){
                return 1;
            }
            else if(person1.getPriority()<person2.getPriority())    {
                return -1;
            }

            else {
                return 0;
            }
        }
    });

    public void joinQueue(Person person){
        if(person != null && (!personQueue.contains(person))){

            personQueue.add(person);
        }
        if(person != null && (!priorityQueue.contains(person))){
            priorityQueue.add(person);
        }
    }


    public Map<Books, Integer> getBookList() {
        return bookList;
    }

    @Override
    public void stackBook(Books book, int size) {

        bookList.merge(book, size, Integer::sum);
         //bookList.put(book,bookList.getOrDefault(book,0) +1);
        System.out.println(bookList);
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryServiceImpl that = (LibraryServiceImpl) o;
        return Objects.equals(bookList, that.bookList) && Objects.equals(personQueue, that.personQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookList, personQueue);
    }

    @Override
    public void borrowBookOnPriority(Person person,String book) throws Exception {

         String whoToGetBook = priorityQueue.remove().getName();
         if(!this.getBookList().isEmpty()){
             if(this.getBookList().containsKey(new Books(book))){
                 int currentBookCount = this.getBookList().get(new Books(book));
                 this.getBookList().put(new Books(book), currentBookCount - 1);
                 // System.out.println(currentBookCount);
                 if(currentBookCount == 0) {
                     System.out.println(whoToGetBook +" The Book YOu Request For IS Not Available");
                 }
                 // System.out.println(currentBookCount);


                 else {
                     System.out.println(whoToGetBook + " Has Succesfully Borrowed " + book + " Book.");
                 }
             }
         }

         else{
             throw new Exception("There is no Book in the library");
         }



        }


        @Override
    public void borrowBookOnFIFO(Person person, String bookName) throws Exception {

            if(!this.getBookList().isEmpty()){

                String whoToGetBook = personQueue.remove().getName();
                if(this.getBookList().containsKey(new Books(bookName))){
                    int currentBookCount = this.getBookList().get(new Books(bookName));
                    this.getBookList().put(new Books(bookName), currentBookCount - 1);
                    // System.out.println(currentBookCount);
                    if(currentBookCount == 0) {
                        System.out.println(whoToGetBook +" The Book You Request For Is Not Available");
                    }
                    // System.out.println(currentBookCount);


                    else{
                        System.out.println(whoToGetBook + " Has Succesfully Borrowed " + bookName + " Book.");
                    }

                }
            }

            else{
                throw new Exception("There is no Book in the library");
            }


    }
}

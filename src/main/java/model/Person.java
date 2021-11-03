package model;

import enums.PersonType;
import services.LibraryServiceImpl;

import java.util.Map;

public class Person {
    private String name;
    private PersonType personType;
    private int priority;

    public Person(){

    }
    public Person(String name, PersonType personType){
        this.name = name != null && name.length()>2 ? name : "Name is Default";
        this.personType = personType != null ? personType : personType.TEACHER;
        setPriority();
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(){
        if(this.personType == personType.TEACHER){

            this.priority = PersonType.TEACHER.getPriority();
        }
        else if (this.personType == personType.STUDENT){

            this.priority = PersonType.STUDENT.getPriority();
        }
        else if(this.personType == personType.SENIOR){

            this.priority = PersonType.SENIOR.getPriority();
        }
        else{

            this.priority = PersonType.JUNIOR.getPriority();
        }

    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }


    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", personType=" + personType +
                '}';
    }
}

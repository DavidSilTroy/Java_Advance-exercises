package it.factory.lambdasearching.model;

import java.util.List;

public class Student {
    String firstName;
    String lastName;
    int age;
    List<Course> courses;

    Student(String firstName, String lastName, int age, List<Course> courses){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public List<Course>  getCourseList(){
        return  courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

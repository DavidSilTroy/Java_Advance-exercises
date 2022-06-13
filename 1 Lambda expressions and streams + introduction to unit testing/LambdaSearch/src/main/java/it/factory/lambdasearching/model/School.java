package it.factory.lambdasearching.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class School {
    List<Course> courseList;
    List<Student> studentList;

    public School(){
        Course programmerI = new Course("Programmer I", 5);
        Course sqlDatabases = new Course("SQL Databases", 3);
        Course linux = new Course("Linux", 8);
        courseList = Arrays.asList(programmerI, sqlDatabases, linux);
        studentList = Arrays.asList(
                new Student("Amber", "Akkermans", 21, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Bert", "Bergmans", 18, Arrays.asList(linux)),
                new Student("Carly", "Coopman", 25, Arrays.asList(programmerI, linux)),
                new Student("Dirk", "Dieltjens", 19, Arrays.asList(programmerI, sqlDatabases)),
                new Student("Erik", "Eyken", 17, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Fré", "Frederickx", 23, Arrays.asList(linux)),
                new Student("Gust", "Grevers", 20, Arrays.asList(sqlDatabases, linux)),
                new Student("Hans", "Hooimans", 22, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Isis", "Ilsen", 19, Arrays.asList(sqlDatabases, linux)),
                new Student("Joris", "Jonkers", 25, Arrays.asList(programmerI, linux)),
                new Student("Kim", "Keuppens", 31, Arrays.asList(programmerI)),
                new Student("Laura", "Liekens", 21, Arrays.asList(sqlDatabases)),
                new Student("Merel", "Meulemans", 18, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Nele", "Nauwelaers", 19, Arrays.asList(linux)),
                new Student("Oscar", "Oppens", 18, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Pieter", "Peters", 21, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Quinten", "Qwards", 22, Arrays.asList(sqlDatabases, linux)),
                new Student("Rik", "Rubens", 20, Arrays.asList(programmerI, sqlDatabases)),
                new Student("Stef", "Stekker", 20, Arrays.asList(programmerI)),
                new Student("Toon", "Timmers", 21, Arrays.asList(programmerI, linux)),
                new Student("Ursula", "Uyterhoeven", 22, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Viktor", "Van der Veken", 20, Arrays.asList(programmerI, linux)),
                new Student("Wim", "Winkers", 21, Arrays.asList(programmerI)),
                new Student("Xanty", "Xanders", 19, Arrays.asList(programmerI, sqlDatabases, linux)),
                new Student("Yael", "Ysebaert", 18, Arrays.asList(linux)),
                new Student("Zuster", "Zulma", 22, Arrays.asList(sqlDatabases, linux)));
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    //create the filter
    public List<Student> getFilteredList(String lname,String fname,int age, int numberOfCourses, String course){
        List<Student> filteredList = studentList.stream().sorted((x,y) -> x.getLastName().compareTo(y.getLastName())).toList();
        filteredList = filteredList.stream().filter(x -> x.getAge()>age).toList();
        filteredList = filteredList.stream().filter(x -> x.getCourseList().size() > numberOfCourses).toList();

        if (lname != ""){
            filteredList = filteredList.stream().filter(x -> x.getLastName().contains(lname) || x.getLastName().contains(lname.toUpperCase())).toList();
        }
        if (fname != ""){
            filteredList = filteredList.stream().filter(x -> x.getFirstName().contains(fname) || x.getLastName().contains(fname.toUpperCase())).toList();
        }
        if (course != ""){
            filteredList = filteredList
                    .stream()
                    .filter(student ->
                            getFilteredOnCourse(student.getCourseList().stream(),course).count()>0
                    )
                    .collect(Collectors.toList());

        }
        return filteredList;
    }
    //create the filter
    public  Stream<Course> getFilteredOnCourse(Stream<Course> filteredList, String course){
        return filteredList.filter(c-> c.getName().equals(course));
    }
}

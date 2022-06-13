package it.factory.lambdasearching.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchoolTest {

    private  School school = new School();
    @Test
    void getResultLengthOfSearchingStudentsByNoInput() {
        //26 because of the number of the list in the constructor
        assertEquals(26, school.getFilteredList("","",0,0,"").size());
    }
    @Test
    void getResultLengthOfSearchingStudentsByFirstName(){
        //when it is the a in the FirstName
        assertEquals(8, school.getFilteredList("","a",0,0,"").size());
    }
    @Test
    void getResultLengthOfSearchingStudentsByLastName(){
        //when it is the a in the FirstName
        assertEquals(11, school.getFilteredList("a","",0,0,"").size());
    }
    @Test
    void ExampleOneFromExercise(){
        //when it is the a in the FirstName
        assertEquals(4, school.getFilteredList("r","a",0,0,"").size());
    }
    @Test
    void ExampleTwoFromExercise(){
        //when it is the a in the FirstName
        assertEquals(4, school.getFilteredList("","",20,2,"").size());
    }
    @Test
    void ExampleThreeFromExercise(){
        //when it is the a in the FirstName
        assertEquals(4, school.getFilteredList("u","",0,0,"SQL Databases").size());
    }

}
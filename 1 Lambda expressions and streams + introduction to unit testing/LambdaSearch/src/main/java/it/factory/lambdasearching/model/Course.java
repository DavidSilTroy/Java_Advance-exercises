package it.factory.lambdasearching.model;

public class Course {
    String name;
    Integer studyPoints;
    Course(String name, Integer studyPoints){
        this.name = name;
        this.studyPoints = studyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(Integer studyPoints) {
        this.studyPoints = studyPoints;
    }
}

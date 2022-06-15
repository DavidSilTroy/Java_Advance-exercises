package fact.it.examplebicycledebbugging.model;

public class Student {
    private String rnumber, firstname, surname;
    private boolean foreigner;

    public Student() {
    }

    public Student(String rnumber, String firstname, String surname) {
        this.rnumber = rnumber;
        this.firstname = firstname;
        this.surname = surname;
    }



    public String getRnumber() {
        return rnumber;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getSurname() {
        return surname;
    }
    public boolean isForeigner() {
        return foreigner;
    }

    public void setRnumber(String rnumber) {
        this. rnumber = rnumber;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setForeigner(boolean foreigner) {
        this. foreigner = foreigner;
    }

    public String getEmailAddress() {
        return rnumber + "@student.thomasmore.be ";
    }

    public String getInitials(){
        return firstname.charAt(1) + surname.substring(0,2);
    }

    public String getFullName() {
        return firstname + " " + surname.toUpperCase() + " (" + getInitials() + ")";
    }


}

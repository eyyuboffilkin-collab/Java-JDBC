package az.company.entity;

public class Student {
    private Integer studentID;
    private String name;
    private String surname;
    private Integer birthdate;
    private String studentNumber;

    public Student(Integer studentID, String name, String surname, Integer birthdate, String studentNumber) {
        this.studentID = studentID;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.studentNumber = studentNumber;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Integer birthdate) {
        this.birthdate = birthdate;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
}

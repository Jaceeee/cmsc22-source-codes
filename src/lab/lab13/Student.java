package lab.lab13;

/*
 *	Lab 10: File Reading and Writing with Lists
 *	performed by Michael Loewe L. Alivio, Michael Ervin B. Pacana, and Juan Carlos T. Roldan
 */

import java.io.Serializable;

public class Student implements Serializable {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private Course faveCourse;
    private String crushName;

    public Student() {
        super();
    }

    public Student(String studentNumber, String firstName, char middleInitial,
                   String lastName, String course, int yearLevel, Course faveCourse, String crushName) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
        this.faveCourse = faveCourse;
        this.crushName = crushName;
    }

    public Course getFaveCourse() {
        return faveCourse;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setFaveCourse(Course faveCourse) {
        this.faveCourse = faveCourse;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(int yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String toString() {
        return "Student Number: " + getStudentNumber() +
                "\nName: " + getLastName() + ", " + getFirstName() + " " + getMiddleInitial() + "."
                + "\nProgram: " + getCourse()
                + "\nYear Level: " + getYearLevel()
                + "\nMy Favorite Course is: " + faveCourse + "\nMy Crush is: "
                + crushName + '\n';
    }

}
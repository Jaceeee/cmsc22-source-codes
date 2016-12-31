package lab.lab10;

/*
 *	Lab 10: File Reading and Writing with Lists
 *	performed by Michael Loewe L. Alivio, Michael Ervin B. Pacana, and Juan Carlos T. Roldan
 */

public class Student {
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;

    public Student(){
        super();
    }

    public Student(String studentNumber, String firstName, char middleInitial,
                   String lastName, String course, int yearLevel) {
        super();
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.course = course;
        this.yearLevel = yearLevel;
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
    public String toString(){
        return "Student Number: "+getStudentNumber()+
                "\nName: "+getLastName()+", " + getFirstName() + " "+ getMiddleInitial()+"."
                +"\nProgram: "+getCourse()
                +"\nYear Level: " +getYearLevel() + "\n";
    }
    public String toString(boolean a){
        return studentNumber + '\n' + firstName + '\n' + middleInitial + '\n' + lastName + '\n' + course + '\n' + yearLevel;
    }
}
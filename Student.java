/*
 * ============================================================
 * DAY 3 — Student.java  (extends Member)
 * ============================================================
 *
 * Student IS-A Member IS-A Person.
 * This is called a chain of inheritance.
 *
 * Student automatically has:
 *   From Person  → id, name, email, getters, setters, toString()
 *   From Member  → borrowedBooks, maxBorrowLimit, borrowBook(), returnBook()
 *   Own          → grade, rollNumber
 *
 * HOW MUCH CODE does Student need to write?
 * Almost none. The heavy lifting is done by Person and Member.
 * Student only adds what makes it uniquely a student.
 */

public class Student extends Member {

    // Fields unique to Student
    private String grade;       // e.g. "10th", "B.Tech 2nd Year"
    private String rollNumber;


    // =========================================================
    // CONSTRUCTOR — chains two super() calls
    // =========================================================
    // Student → Member → Person
    // When you call super(id, name, email, "STUDENT"):
    //   Member's constructor runs → calls super(id, name, email)
    //     → Person's constructor runs → sets id, name, email
    //   → back to Member → sets memberType = STUDENT, limit = 3
    // → back to Student → sets grade, rollNumber

    public Student(int id, String name, String email, String grade, String rollNumber) {
        super(id, name, email, "STUDENT");  // calls Member constructor
        this.grade      = grade;
        this.rollNumber = rollNumber;
    }


    // Getters for Student's own fields
    public String getGrade()      { return this.grade; }
    public String getRollNumber() { return this.rollNumber; }

    // Setters for Student's own fields
    public void setGrade(String grade)           { this.grade = grade; }
    public void setRollNumber(String rollNumber) { this.rollNumber = rollNumber; }


    // =========================================================
    // @Override displayInfo()
    // =========================================================
    // Student overrides it to show grade and roll number too.
    // Notice: we call super.displayInfo() to reuse Member's output
    // and just ADD the student-specific lines after.

    @Override
    public void displayInfo() {
        super.displayInfo();    // prints everything Member prints
        // Then add Student's extra info
        System.out.println("Grade        : " + this.grade);
        System.out.println("Roll Number  : " + this.rollNumber);
        System.out.println("=============================");
    }
}
/*
 * ============================================================
 * DAY 2 — Member.java  (Brand new class)
 * ============================================================
 *
 * A Member is anyone who has a library card — student or teacher.
 * For now they're the same class. On Day 3 (Inheritance) we'll
 * split them into Student and Teacher subclasses.
 *
 * NEW CONCEPT TODAY: ArrayList
 * A Member holds a LIST of borrowed books.
 * We can't use a plain array (int[]) because arrays have fixed size.
 * ArrayList grows automatically as books are added/removed.
 *
 * import java.util.ArrayList;  ← we need this to use ArrayList
 */
 
import java.util.ArrayList;

public class Member {
 
    // =========================================================
    // FIELDS — all private
    // =========================================================
 
    private int id;
    private String name;
    private String email;
    private String memberType;          // "STUDENT" or "TEACHER"
    private int maxBorrowLimit;         // students=3, teachers=5
 
    // ArrayList<String> means: a list that holds String values
    // Each String will be a book title the member has borrowed
    // We'll upgrade this to List<Book> on Day 6
    private ArrayList<String> borrowedBooks;
 
 
    // =========================================================
    // CONSTRUCTOR — Parameterized
    // =========================================================
    // We set maxBorrowLimit automatically based on memberType
    // so the caller doesn't have to worry about the rules
 
    public Member(int id, String name, String email, String memberType) {
        setId(id);
        setName(name);
        setEmail(email);
        setMemberType(memberType);     // this also sets maxBorrowLimit
        this.borrowedBooks = new ArrayList<>();  // start with empty list
    }
    // =========================================================
    // GETTERS
    // =========================================================
 
    public int getId()                          { return this.id; }
    public String getName()                     { return this.name; }
    public String getEmail()                    { return this.email; }
    public String getMemberType()               { return this.memberType; }
    public int getMaxBorrowLimit()              { return this.maxBorrowLimit; }
    public ArrayList<String> getBorrowedBooks() { return this.borrowedBooks; }
 
    // Calculated — how many books are currently borrowed
    public int getBorrowedCount() {
        return this.borrowedBooks.size();
    }
 
    // Calculated — can this member borrow more books?
    public boolean canBorrow() {
        return this.borrowedBooks.size() < this.maxBorrowLimit;
    }

    // =========================================================
    // SETTERS — with validation
    // =========================================================
 
    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Warning: Member ID must be positive. Ignoring: " + id);
            return;
        }
        this.id = id;
    }
 
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Warning: Member name cannot be empty. Ignoring.");
            return;
        }
        // Only letters and spaces allowed in a name
        // matches() checks if the string fits a pattern
        // "[a-zA-Z ]+" means: one or more letters or spaces
        if (!name.trim().matches("[a-zA-Z ]+")) {
            System.out.println("Warning: Name should contain only letters. Ignoring: " + name);
            return;
        }
        this.name = name.trim();
    }
 
    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Warning: Email cannot be empty. Ignoring.");
            return;
        }
        // Basic email check: must contain "@" and a "."
        // contains() checks if a string includes a substring
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Warning: Invalid email format. Must contain '@' and '.'. Ignoring: " + email);
            return;
        }
        this.email = email.trim().toLowerCase();
    }
 
    public void setMemberType(String memberType) {
        if (memberType == null) {
            this.memberType  = "STUDENT";
            this.maxBorrowLimit = 3;
            return;
        }
        // toUpperCase() so "student", "Student", "STUDENT" all work
        String type = memberType.toUpperCase();
        if (type.equals("TEACHER")) {
            this.memberType     = "TEACHER";
            this.maxBorrowLimit = 5;   // teachers get higher limit
        } else {
            this.memberType     = "STUDENT";
            this.maxBorrowLimit = 3;
        }
    }
    
    
}

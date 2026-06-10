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
    
    
}

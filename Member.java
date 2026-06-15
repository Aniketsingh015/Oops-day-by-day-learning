/*
 * ============================================================
 * DAY 3 — Member.java  (Refactored to extend Person)
 * ============================================================
 *
 * WHAT CHANGED FROM DAY 2:
 *   - "extends Person" added
 *   - id, name, email fields REMOVED (they live in Person now)
 *   - setId/setName/setEmail REMOVED (inherited from Person)
 *   - Constructor now calls super(...) first
 *   - displayInfo() now has @Override annotation
 *   - Everything else stays the same
 *
 * KEY CONCEPT — super(...):
 * The very first line of a child constructor MUST call super(...)
 * to initialize the parent's fields. Java actually enforces this:
 * if you don't write super(...), Java inserts super() automatically —
 * but only if the parent has a no-arg constructor. Since Person's
 * constructor requires id/name/email, we MUST call it explicitly.
 *
 * Order of execution when you write "new Member(201, "Aniket", ...)":
 *   1. Member constructor starts
 *   2. super(id, name, email) → jumps to Person constructor
 *   3. Person sets id, name, email
 *   4. Returns to Member constructor
 *   5. Member sets its own extra fields (borrowedBooks, maxBorrowLimit)
 */

import java.util.ArrayList;

public class Member extends Person {

    // =========================================================
    // FIELDS — only what's UNIQUE to Member
    // =========================================================
    // id, name, email are gone — Person owns them now.
    // Member only declares what Person doesn't have.

    private String memberType;
    private int maxBorrowLimit;
    private ArrayList<String> borrowedBooks;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Member(int id, String name, String email, String memberType) {
        // super() must be the FIRST statement — no exceptions
        // This calls Person(int id, String name, String email)
        super(id, name, email);

        // Now handle Member's own fields
        setMemberType(memberType);
        this.borrowedBooks = new ArrayList<>();
    }


    // =========================================================
    // GETTERS — only for Member's own fields
    // =========================================================
    // getId(), getName(), getEmail() are inherited from Person
    // No need to write them here at all

    public String getMemberType()               { return this.memberType; }
    public int getMaxBorrowLimit()              { return this.maxBorrowLimit; }
    public ArrayList<String> getBorrowedBooks() { return this.borrowedBooks; }
    public int getBorrowedCount()               { return this.borrowedBooks.size(); }
    public boolean canBorrow()                  { return this.borrowedBooks.size() < this.maxBorrowLimit; }


    // =========================================================
    // SETTERS — only for Member's own fields
    // =========================================================

    public void setMemberType(String memberType) {
        if (memberType != null && memberType.toUpperCase().equals("TEACHER")) {
            this.memberType     = "TEACHER";
            this.maxBorrowLimit = 5;
        } else {
            this.memberType     = "STUDENT";
            this.maxBorrowLimit = 3;
        }
    }


    // =========================================================
    // BORROW / RETURN — unchanged from Day 2
    // =========================================================

    public boolean borrowBook(String bookTitle) {
        if (!canBorrow()) {
            System.out.println(getName() + " has reached the borrow limit of " + this.maxBorrowLimit + ".");
            return false;
        }
        if (this.borrowedBooks.contains(bookTitle)) {
            System.out.println(getName() + " already has '" + bookTitle + "'.");
            return false;
        }
        this.borrowedBooks.add(bookTitle);
        System.out.println(getName() + " borrowed '" + bookTitle + "'.");
        return true;
    }

    public boolean returnBook(String bookTitle) {
        if (this.borrowedBooks.remove(bookTitle)) {
            System.out.println(getName() + " returned '" + bookTitle + "'.");
            return true;
        }
        System.out.println(getName() + " does not have '" + bookTitle + "'.");
        return false;
    }


    // =========================================================
    // displayInfo() — OVERRIDING the abstract method from Person
    // =========================================================
    // @Override tells the compiler: "I am intentionally replacing
    // a method from the parent class."
    //
    // If you misspell the method name, @Override catches it:
    // @Override
    // public void displayinFo() { ... }  ← compile error! No such method in parent.
    // Without @Override, Java would silently create a NEW method instead.
    // Always use @Override when overriding — it's a safety net.

    @Override
    public void displayInfo() {
        System.out.println("=============================");
        System.out.println("Member ID    : " + getId());       // inherited getter
        System.out.println("Name         : " + getName());     // inherited getter
        System.out.println("Email        : " + getEmail());    // inherited getter
        System.out.println("Type         : " + this.memberType);
        System.out.println("Borrow Limit : " + this.maxBorrowLimit);
        System.out.println("Borrowed     : " + getBorrowedCount() + " / " + this.maxBorrowLimit);
        if (this.borrowedBooks.isEmpty()) {
            System.out.println("Books        : (none)");
        } else {
            System.out.println("Books        :");
            for (String book : this.borrowedBooks) {
                System.out.println("               - " + book);
            }
        }
        System.out.println("=============================");
    }
}
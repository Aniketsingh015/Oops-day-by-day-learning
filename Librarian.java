/*
 * ============================================================
 * DAY 3 — Librarian.java  (extends Person directly)
 * ============================================================
 *
 * WHY does Librarian extend Person and NOT Member?
 *
 * Think about what Member adds: borrowedBooks, maxBorrowLimit,
 * borrowBook(), returnBook(). A Librarian does NOT borrow books.
 * They manage the library. If Librarian extended Member, it would
 * inherit a borrow limit and a borrowed books list — which makes
 * no sense for a librarian.
 *
 * Inheritance should model an IS-A relationship:
 *   Student IS-A Member ✓  (a student is a type of member)
 *   Teacher IS-A Member ✓  (a teacher is a type of member)
 *   Librarian IS-A Member ✗ (a librarian is NOT a member — they work there)
 *   Librarian IS-A Person ✓ (a librarian is still a person with id/name/email)
 *
 * Always ask: "Does the IS-A relationship actually make sense?"
 * If it doesn't, don't use inheritance — it will cause more harm than good.
 */

public class Librarian extends Person {

    // Fields unique to Librarian
    private String employeeCode;    // e.g. "LIB-001"
    private String shift;           // "MORNING" or "EVENING"


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Librarian(int id, String name, String email, String employeeCode, String shift) {
        super(id, name, email);     // calls Person constructor directly
        this.employeeCode = employeeCode;
        setShift(shift);
    }


    // Getters
    public String getEmployeeCode() { return this.employeeCode; }
    public String getShift()        { return this.shift; }

    // Setters
    public void setEmployeeCode(String employeeCode) {
        if (employeeCode == null || employeeCode.trim().isEmpty()) {
            System.out.println("Warning: Employee code cannot be empty.");
            return;
        }
        this.employeeCode = employeeCode.trim().toUpperCase();
    }

    public void setShift(String shift) {
        if (shift != null && shift.toUpperCase().equals("EVENING")) {
            this.shift = "EVENING";
        } else {
            this.shift = "MORNING"; // default
        }
    }


    // =========================================================
    // Librarian-specific actions
    // =========================================================
    // These are things ONLY a librarian can do.
    // For now they just print messages — the real logic
    // will connect to the Library class on Day 6.

    public void addBook(String bookTitle) {
        System.out.println("Librarian " + getName() + " added book: '" + bookTitle + "'");
    }

    public void registerMember(String memberName) {
        System.out.println("Librarian " + getName() + " registered member: " + memberName);
    }

    public void processBorrow(String memberName, String bookTitle) {
        System.out.println("Librarian " + getName() + " processed borrow: "
                + memberName + " ← '" + bookTitle + "'");
    }

    public void processReturn(String memberName, String bookTitle) {
        System.out.println("Librarian " + getName() + " processed return: "
                + memberName + " → '" + bookTitle + "'");
    }


    // =========================================================
    // @Override displayInfo()
    // =========================================================

    @Override
    public void displayInfo() {
        System.out.println("*****************************");
        System.out.println("LIBRARIAN");
        System.out.println("ID           : " + getId());
        System.out.println("Name         : " + getName());
        System.out.println("Email        : " + getEmail());
        System.out.println("Employee Code: " + this.employeeCode);
        System.out.println("Shift        : " + this.shift);
        System.out.println("*****************************");
    }
}
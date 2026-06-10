/*
 * ============================================================
 * DAY 2 — Main.java
 * ============================================================
 * Tests both Book (refactored) and Member (new)
 * Specifically demonstrates:
 *   1. Validation rejecting bad data
 *   2. Member borrowing and returning books
 *   3. Borrow limit enforcement
 */
 
public class main {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println("  LIBRARY MANAGEMENT SYSTEM — Day 2    ");
        System.out.println("========================================\n");
 
 
        // =====================================================
        // PART 1: Testing Book validation (encapsulation)
        // =====================================================
        System.out.println("--- PART 1: Book Validation ---\n");
 
        Books book1 = new Books(101, "The Alchemist",     "Paulo Coelho",     "Fiction",   3);
        Books book2 = new Books(102, "Harry Potter",      "J.K. Rowling",     "Fantasy",   5);
        Books book3 = new Books(103, "Clean Code",        "Robert C. Martin", "Tech",      2);
        Books book4 = new Books(104, "Wings of Fire",     "A.P.J. Abdul Kalam","Biography",1);
 
        book1.displayInfo();
          // Try to SET invalid values — watch validation kick in
        System.out.println("Trying to set empty title:");
        book1.setTitle("");                  // should warn and reject
 
        System.out.println("Trying to set negative ID:");
        book1.setId(-5);                     // should warn and reject
 
        System.out.println("Trying to set 999 available copies:");
        book1.setAvailableCopies(999);       // should warn and reject
 
        System.out.println("\nbook1 after all invalid attempts (unchanged):");
        book1.displayInfo();
 
 
        // =====================================================
        // PART 2: Creating Members with validation
        // =====================================================
        System.out.println("\n--- PART 2: Member Creation ---\n");
 
        Member student1 = new Member(201, "Aniket Sharma",  "aniket@email.com",  "STUDENT");
        Member student2 = new Member(202, "Priya Singh",    "priya@email.com",   "STUDENT");
        Member teacher1 = new Member(301, "Dr. Roy",        "droy@school.edu",   "TEACHER");
 
        student1.displayProfile();
        teacher1.displayProfile();
 
        // Test bad member data
        System.out.println("Trying invalid email:");
        Member bad1 = new Member(203, "Test User", "notanemail", "STUDENT"); // bad email
        System.out.println();
 
        System.out.println("Trying empty name:");
        Member bad2 = new Member(204, "", "test@email.com", "STUDENT");      // empty name
        System.out.println();
 
 
        // =====================================================
        // PART 3: Borrow logic — limit enforcement
        // =====================================================
        System.out.println("\n--- PART 3: Borrow Logic ---\n");
 
        // student1 can borrow max 3 books
        student1.borrowBook("The Alchemist");
        student1.borrowBook("Harry Potter");
        student1.borrowBook("Clean Code");
 
        // This 4th one should be REJECTED — limit is 3
        student1.borrowBook("Wings of Fire");
 
        System.out.println();
        student1.displayProfile();
 
        // teacher1 can borrow max 5 books
        System.out.println("\nTeacher borrowing (limit = 5):");
        teacher1.borrowBook("The Alchemist");
        teacher1.borrowBook("Harry Potter");
        teacher1.borrowBook("Clean Code");
        teacher1.borrowBook("Wings of Fire");
        teacher1.borrowBook("Atomic Habits");
        // 6th should be rejected
        teacher1.borrowBook("Extra Book");
 
        System.out.println();
        teacher1.displayProfile();
 
 
        // =====================================================
        // PART 4: Return a book
        // =====================================================
        System.out.println("\n--- PART 4: Return a book ---\n");
 
        student1.returnBook("Harry Potter");
        System.out.println();
        student1.displayProfile();
 
        // Try returning something they don't have
        student1.returnBook("Wings of Fire");
 
 
        // =====================================================
        // PART 5: Borrow + Book together
        // =====================================================
        System.out.println("\n--- PART 5: Book + Member working together ---\n");
 
        System.out.println("book4 before borrow:");
        book4.displayInfo();
 
        // Step 1: check if member can borrow
        // Step 2: check if book has copies
        // Step 3: update both
        if (student2.canBorrow() && book4.borrow()) {
            student2.borrowBook(book4.getTitle());
            System.out.println("Transaction successful!");
        }
 
        System.out.println("\nbook4 after borrow:");
        book4.displayInfo();
 
        System.out.println("\nstudent2 after borrow:");
        student2.displayProfile();
    }
}
 
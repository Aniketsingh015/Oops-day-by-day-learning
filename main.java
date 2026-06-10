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
 
public class Main {
 
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println("  LIBRARY MANAGEMENT SYSTEM — Day 2    ");
        System.out.println("========================================\n");
 
 
        // =====================================================
        // PART 1: Testing Book validation (encapsulation)
        // =====================================================
        System.out.println("--- PART 1: Book Validation ---\n");
 
        Book book1 = new Book(101, "The Alchemist",     "Paulo Coelho",     "Fiction",   3);
        Book book2 = new Book(102, "Harry Potter",      "J.K. Rowling",     "Fantasy",   5);
        Book book3 = new Book(103, "Clean Code",        "Robert C. Martin", "Tech",      2);
        Book book4 = new Book(104, "Wings of Fire",     "A.P.J. Abdul Kalam","Biography",1);
 
        book1.displayInfo();
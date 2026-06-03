public class main {
    public static void main(String[] args) {
 
        System.out.println("========================================");
        System.out.println("  LIBRARY MANAGEMENT SYSTEM — Day 1    ");
        System.out.println("========================================\n");
 
 
        // =====================================================
        // Creating books using the Parameterized Constructor
        // =====================================================
        // Signature: Book(int id, String title, String author, String genre, int totalCopies)
        // Note: availableCopies is set automatically = totalCopies inside the constructor
 
        Books book1 = new Books(101, "The Alchemist",     "Paulo Coelho",      "Fiction",  3);
        Books book2 = new Books(102, "Harry Potter",      "J.K. Rowling",      "Fantasy",  5);
        Books book3 = new Books(103, "Clean Code",        "Robert C. Martin",  "Tech",     2);
        Books book4 = new Books(104, "Wings of Fire",     "A.P.J. Abdul Kalam","Biography",1);

        System.out.println("=== All books when first added to library ===");
        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();
        book4.displayInfo();
 
 
        // =====================================================
        // Demonstrating borrow() — availableCopies decreases
        // =====================================================
        System.out.println("\n=== Borrowing books ===\n");
 
        // book1 has 3 copies — borrow 2 of them
        boolean result1 = book1.borrow();
        System.out.println("Borrow book1 (attempt 1): " + (result1 ? "Success" : "Failed"));
 
        boolean result2 = book1.borrow();
        System.out.println("Borrow book1 (attempt 2): " + (result2 ? "Success" : "Failed"));
 
        System.out.println("\nBook1 after 2 borrows:");
        book1.displayInfo();
 
        // book4 has only 1 copy — borrow it, then try again
        boolean result3 = book4.borrow();
        System.out.println("Borrow book4 (attempt 1): " + (result3 ? "Success" : "Failed"));

        boolean result4 = book4.borrow(); // This should FAIL — no copies left
        System.out.println("Borrow book4 (attempt 2): " + (result4 ? "Success" : "Failed — no copies left!"));
 
        System.out.println("\nBook4 after borrow attempts:");
        book4.displayInfo();
 
 
        // =====================================================
        // Demonstrating returnBook() — availableCopies increases
        // =====================================================
        System.out.println("\n=== Returning books ===\n");
 
        boolean returned = book4.returnBook();
        System.out.println("Return book4: " + (returned ? "Success" : "Failed"));
 
        System.out.println("\nBook4 after return:");
        book4.displayInfo();
 
 
        // =====================================================
        // Demonstrating isAvailable() — calculated, not stored
        // =====================================================
        System.out.println("\n=== Checking availability ===\n");
        System.out.println("Is book1 available? " + book1.isAvailable());  // true  (1 copy left)
        System.out.println("Is book3 available? " + book3.isAvailable());  // true  (2 copies untouched)
        System.out.println("Is book4 available? " + book4.isAvailable());  // true  (just returned)
 
 
        // =====================================================
        // Default Constructor + setters
        // =====================================================
        System.out.println("\n=== Default constructor + setters ===\n");
 
        Books book5 = new Books();          // All fields set to defaults
        System.out.println("Before setters:");
        book5.displayInfo();
 
        book5.setId(105);
        book5.setName("Atomic Habits");
        book5.setAuthor("James Clear");
        book5.setGenre("Self-Help");
        book5.setTotalCopies(4);
        book5.setAvailableCopies(4);
 
        System.out.println("After setters:");
        book5.displayInfo();
}
}
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
}
}
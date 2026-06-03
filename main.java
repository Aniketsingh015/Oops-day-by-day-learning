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
}
}
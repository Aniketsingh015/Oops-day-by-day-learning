public class Books {
    int id;
    String name;
    String author;
    String genre;
    int totalCopies;
    int availableCopies;


    //constructor which is default when there is not more information we will use it then

    Books(){
        this.id=0;
        this.name="Unknown name";
        this.author="Unknown author";
        this.genre="Unknown genre";
        this.totalCopies=0;
        this.availableCopies=0;
    }



    // =========================================================
    // CONSTRUCTOR 2 — Parameterized Constructor
    // =========================================================
    // Creates a book with all values provided upfront.
    //
    // IMPORTANT DESIGN DECISION:
    // We take totalCopies as a parameter, but NOT availableCopies.
    // WHY? Because when a book is first added to the library,
    // ALL copies are available. It would be a mistake to let
    // someone accidentally say availableCopies > totalCopies.
    // So we set availableCopies = totalCopies automatically.

    Books(int id, String name, String author, String genre, int totalCopies){
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.totalCopies = totalCopies;
        this.availableCopies = totalCopies;
    }


    // =========================================================
    // CONSTRUCTOR 3 — Copy Constructor
    // =========================================================
    // Creates a NEW Book object by copying all values from another Book.
    // Changing this new book will NOT affect the original.
    //
    // Use case: you want to create a "duplicate entry" of an existing book.
 
    Books(Books other) {
        this.id              = other.id;
        this.name           = other.name;
        this.author          = other.author;
        this.genre           = other.genre;
        this.totalCopies     = other.totalCopies;
        this.availableCopies = other.availableCopies;
    }
 
 
    // =========================================================
    // GETTERS
    // =========================================================
 
    int getId()               { return this.id; }
    String getName()         { return this.name; }
    String getAuthor()        { return this.author; }
    String getGenre()         { return this.genre; }
    int getTotalCopies()      { return this.totalCopies; }
    int getAvailableCopies()  { return this.availableCopies; }
 
 
    // =========================================================
    // isAvailable() — CALCULATED method, not a stored field
    // =========================================================
    // This used to be a stored boolean field: boolean isAvailable
    // Now it is a METHOD that COMPUTES the answer on the spot.
    //
    // Think of it like asking: "Is the shop open?"
    // You don't store the answer — you check the clock and calculate it.
    //
    // RETURN TYPE: boolean (true = at least 1 copy on shelf)
 
    boolean isAvailable() {
        return this.availableCopies > 0;
    }
 
 
    // =========================================================
    // SETTERS
    // =========================================================
 
    void setId(int id)                       { this.id = id; }
    void setName(String name)              { this.name = name; }
    void setAuthor(String author)            { this.author = author; }
    void setGenre(String genre)              { this.genre = genre; }
    void setTotalCopies(int totalCopies)     { this.totalCopies = totalCopies; }
    void setAvailableCopies(int availableCopies) {
        // Basic guard: available copies can never exceed total copies
        // and can never go below 0
        if (availableCopies < 0) {
            this.availableCopies = 0;
        } else if (availableCopies > this.totalCopies) {
            this.availableCopies = this.totalCopies;
        } else {
            this.availableCopies = availableCopies;
        }
    }
 
 
    // =========================================================
    // borrow() — reduces availableCopies by 1
    // =========================================================
    // Called when a member borrows this book.
    // Returns true if borrow was successful, false if no copies left.
    //
    // WHY return boolean?
    // The caller (Main or Librarian) needs to know if the borrow worked.
    // If we returned void, they'd have no way to know it failed silently.
 
    boolean borrow() {
        if (this.availableCopies > 0) {
            this.availableCopies--;   // availableCopies = availableCopies - 1
            return true;              // Borrow succeeded
        }
        return false;                 // No copies available, borrow failed
    }
 
 
    // =========================================================
    // returnBook() — increases availableCopies by 1
    // =========================================================
    // Called when a member returns this book.
    // Returns true if return was successful.
 
    boolean returnBook() {
        if (this.availableCopies < this.totalCopies) {
            this.availableCopies++;   // One more copy back on the shelf
            return true;
        }
        return false; // All copies already on shelf — something went wrong
    }
 
 
    // =========================================================
    // displayInfo() — prints a summary of this book
    // =========================================================
 
    void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Book ID          : " + this.id);
        System.out.println("Name             : " + this.name);
        System.out.println("Author           : " + this.author);
        System.out.println("Genre            : " + this.genre);
        System.out.println("Total Copies     : " + this.totalCopies);
        System.out.println("Available Copies : " + this.availableCopies);
        System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
        System.out.println("-----------------------------");
    }
 
}
 


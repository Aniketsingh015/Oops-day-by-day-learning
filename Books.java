/*
 * ============================================================
 * DAY 2 — Book.java  (Refactored for Encapsulation)
 * ============================================================
 *
 * WHAT CHANGED FROM DAY 1:
 *   - All fields changed from default access → private
 *   - Setters now have VALIDATION (they reject bad data)
 *   - Nothing else changes — same fields, same methods
 *
 * WHY private?
 *   Before:  book1.title = "";   <-- anyone could corrupt the data
 *   After:   book1.title = "";   <-- COMPILE ERROR. Forced to use setTitle()
 *            book1.setTitle(""); <-- setter rejects empty string
 *
 * This is encapsulation: hide the data, control access through methods.
 */

/*
 * ============================================================
 * DAY 4 — Book.java  (Refactored to extend LibraryItem)
 * ============================================================
 *
 * WHAT CHANGED:
 *   - "extends LibraryItem" added
 *   - id, title, totalCopies, availableCopies REMOVED (live in LibraryItem now)
 *   - Book's own fields: author, genre
 *   - displayInfo() and getLoanPeriod() OVERRIDDEN
 *   - searchItem() OVERLOADED 3 ways (by id, by title, by author)
 */

// public class Books {

//     // =========================================================
//     // FIELDS — all private now
//     // =========================================================
//     // The keyword "private" means: only code INSIDE this class
//     // can read or write these fields directly.
//     // Everyone else MUST go through getters and setters.

//     private int id;
//     private String title;
//     private String author;
//     private String genre;
//     private int totalCopies;
//     private int availableCopies;


//     // =========================================================
//     // CONSTRUCTORS — unchanged from Day 1
//     // =========================================================

//     public Books() {
//         this.id              = 0;
//         this.title           = "Unknown Title";
//         this.author          = "Unknown Author";
//         this.genre           = "Uncategorized";
//         this.totalCopies     = 1;
//         this.availableCopies = 1;
//     }

//     public Books(int id, String title, String author, String genre, int totalCopies) {
//         // Use setters here so validation runs even during construction
//         setId(id);
//         setTitle(title);
//         setAuthor(author);
//         setGenre(genre);
//         setTotalCopies(totalCopies);
//         this.availableCopies = this.totalCopies;
//     }

//     public Books(Books other) {
//         this.id              = other.id;
//         this.title           = other.title;
//         this.author          = other.author;
//         this.genre           = other.genre;
//         this.totalCopies     = other.totalCopies;
//         this.availableCopies = other.availableCopies;
//     }


//     // =========================================================
//     // GETTERS — public so anyone can READ the fields
//     // =========================================================
//     // Notice: getters have no validation — reading is always safe.
//     // Only writing (setters) needs to be controlled.

//     public int getId()               { return this.id; }
//     public String getTitle()         { return this.title; }
//     public String getAuthor()        { return this.author; }
//     public String getGenre()         { return this.genre; }
//     public int getTotalCopies()      { return this.totalCopies; }
//     public int getAvailableCopies()  { return this.availableCopies; }

//     public boolean isAvailable() {
//         return this.availableCopies > 0;
//     }


//     // =========================================================
//     // SETTERS — public but with VALIDATION
//     // =========================================================
//     // This is the heart of Day 2.
//     // Each setter now checks if the value makes sense
//     // before actually storing it.
//     //
//     // PATTERN used: if invalid → print warning and return early
//     //               if valid   → store the value

//     public void setId(int id) {
//         if (id <= 0) {
//             System.out.println("Warning: Book ID must be positive. Ignoring value: " + id);
//             return; // exit the method without changing the field
//         }
//         this.id = id;
//     }

//     public void setTitle(String title) {
//         // Rule: title cannot be null or empty/blank
//         if (title == null || title.trim().isEmpty()) {
//             System.out.println("Warning: Book title cannot be empty. Ignoring.");
//             return;
//         }
//         // trim() removes leading/trailing spaces: "  Harry Potter  " → "Harry Potter"
//         this.title = title.trim();
//     }

//     public void setAuthor(String author) {
//         if (author == null || author.trim().isEmpty()) {
//             System.out.println("Warning: Author name cannot be empty. Ignoring.");
//             return;
//         }
//         this.author = author.trim();
//     }

//     public void setGenre(String genre) {
//         if (genre == null || genre.trim().isEmpty()) {
//             this.genre = "Uncategorized"; // default fallback instead of warning
//             return;
//         }
//         this.genre = genre.trim();
//     }

//     public void setTotalCopies(int totalCopies) {
//         if (totalCopies <= 0) {
//             System.out.println("Warning: Total copies must be at least 1. Ignoring value: " + totalCopies);
//             return;
//         }
//         this.totalCopies = totalCopies;
//     }

//     public void setAvailableCopies(int availableCopies) {
//         if (availableCopies < 0) {
//             System.out.println("Warning: Available copies cannot be negative.");
//             return;
//         }
//         if (availableCopies > this.totalCopies) {
//             System.out.println("Warning: Available copies cannot exceed total copies.");
//             return;
//         }
//         this.availableCopies = availableCopies;
//     }


//     // =========================================================
//     // BORROW / RETURN — unchanged logic, now use private fields
//     // =========================================================

//     public boolean borrow() {
//         if (this.availableCopies > 0) {
//             this.availableCopies--;
//             return true;
//         }
//         System.out.println("Cannot borrow '" + this.title + "': no copies available.");
//         return false;
//     }

//     public boolean returnBook() {
//         if (this.availableCopies < this.totalCopies) {
//             this.availableCopies++;
//             return true;
//         }
//         System.out.println("Cannot return '" + this.title + "': all copies already on shelf.");
//         return false;
//     }


//     // =========================================================
//     // displayInfo()
//     // =========================================================

//     public void displayInfo() {
//         System.out.println("-----------------------------");
//         System.out.println("Book ID          : " + this.id);
//         System.out.println("Title            : " + this.title);
//         System.out.println("Author           : " + this.author);
//         System.out.println("Genre            : " + this.genre);
//         System.out.println("Total Copies     : " + this.totalCopies);
//         System.out.println("Available Copies : " + this.availableCopies);
//         System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
//         System.out.println("-----------------------------");
//     }
// }
public class Books extends LibraryItem {
 
    // Fields unique to Book
    private String author;
    private String genre;
 
 
    // =========================================================
    // CONSTRUCTOR
    // =========================================================
 
    public Books(int id, String title, String author, String genre, int totalCopies) {
        super(id, title, totalCopies);   // LibraryItem handles id/title/copies
        setAuthor(author);
        setGenre(genre);
    }
 
 
    // Getters/setters for Book's own fields
    public String getAuthor() { return this.author; }
    public String getGenre()  { return this.genre; }
 
    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Warning: Author cannot be empty. Ignoring.");
            return;
        }
        this.author = author.trim();
    }
 
    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            this.genre = "Uncategorized";
            return;
        }
        this.genre = genre.trim();
    }
 
 
    // =========================================================
    // @Override getLoanPeriod()
    // =========================================================
    // Books can be kept for 14 days — the standard loan period.
 
    @Override
    public int getLoanPeriod() {
        return 14;
    }
 
 
    // =========================================================
    // @Override displayInfo()
    // =========================================================
    // Books need to show author and genre, which LibraryItem
    // doesn't know about. So we replace the parent's version entirely.
 
    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("[BOOK]");
        System.out.println("ID               : " + getId());
        System.out.println("Title            : " + getTitle());
        System.out.println("Author           : " + this.author);
        System.out.println("Genre            : " + this.genre);
        System.out.println("Total Copies     : " + getTotalCopies());
        System.out.println("Available Copies : " + getAvailableCopies());
        System.out.println("Loan Period      : " + getLoanPeriod() + " days");
        System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
        System.out.println("-----------------------------");
    }
 
 
    // =========================================================
    // OVERLOADED searchItem() methods — 3 versions
    // =========================================================
    // These are STATIC because searching doesn't belong to one
    // specific book — it's a general utility that checks if THIS
    // book matches some criteria. We'll use these properly
    // inside the Library class on Day 6.
    //
    // Notice: same method name "searchItem", but Java tells them
    // apart by their PARAMETER TYPES. This is overloading.
 
    // Version 1: search by ID
    public boolean searchItem(int searchId) {
        return this.getId() == searchId;
    }
 
    // Version 2: search by title (case-insensitive, partial match)
    public boolean searchItem(String searchTitle) {
        if (searchTitle == null) return false;
        return this.getTitle().toLowerCase().contains(searchTitle.toLowerCase());
    }
 
    // Version 3: search by title AND author together
    public boolean searchItem(String searchTitle, String searchAuthor) {
        boolean titleMatches  = searchItem(searchTitle); // reuse Version 2!
        boolean authorMatches = this.author.toLowerCase().contains(searchAuthor.toLowerCase());
        return titleMatches && authorMatches;
    }
}
 
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

public class Books {

    // =========================================================
    // FIELDS — all private now
    // =========================================================
    // The keyword "private" means: only code INSIDE this class
    // can read or write these fields directly.
    // Everyone else MUST go through getters and setters.

    private int id;
    private String title;
    private String author;
    private String genre;
    private int totalCopies;
    private int availableCopies;


    // =========================================================
    // CONSTRUCTORS — unchanged from Day 1
    // =========================================================

    public Books() {
        this.id              = 0;
        this.title           = "Unknown Title";
        this.author          = "Unknown Author";
        this.genre           = "Uncategorized";
        this.totalCopies     = 1;
        this.availableCopies = 1;
    }

    public Books(int id, String title, String author, String genre, int totalCopies) {
        // Use setters here so validation runs even during construction
        setId(id);
        setTitle(title);
        setAuthor(author);
        setGenre(genre);
        setTotalCopies(totalCopies);
        this.availableCopies = this.totalCopies;
    }

    public Books(Books other) {
        this.id              = other.id;
        this.title           = other.title;
        this.author          = other.author;
        this.genre           = other.genre;
        this.totalCopies     = other.totalCopies;
        this.availableCopies = other.availableCopies;
    }


    // =========================================================
    // GETTERS — public so anyone can READ the fields
    // =========================================================
    // Notice: getters have no validation — reading is always safe.
    // Only writing (setters) needs to be controlled.

    public int getId()               { return this.id; }
    public String getTitle()         { return this.title; }
    public String getAuthor()        { return this.author; }
    public String getGenre()         { return this.genre; }
    public int getTotalCopies()      { return this.totalCopies; }
    public int getAvailableCopies()  { return this.availableCopies; }

    public boolean isAvailable() {
        return this.availableCopies > 0;
    }


    // =========================================================
    // SETTERS — public but with VALIDATION
    // =========================================================
    // This is the heart of Day 2.
    // Each setter now checks if the value makes sense
    // before actually storing it.
    //
    // PATTERN used: if invalid → print warning and return early
    //               if valid   → store the value

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Warning: Book ID must be positive. Ignoring value: " + id);
            return; // exit the method without changing the field
        }
        this.id = id;
    }

    public void setTitle(String title) {
        // Rule: title cannot be null or empty/blank
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Warning: Book title cannot be empty. Ignoring.");
            return;
        }
        // trim() removes leading/trailing spaces: "  Harry Potter  " → "Harry Potter"
        this.title = title.trim();
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Warning: Author name cannot be empty. Ignoring.");
            return;
        }
        this.author = author.trim();
    }

    public void setGenre(String genre) {
        if (genre == null || genre.trim().isEmpty()) {
            this.genre = "Uncategorized"; // default fallback instead of warning
            return;
        }
        this.genre = genre.trim();
    }

    public void setTotalCopies(int totalCopies) {
        if (totalCopies <= 0) {
            System.out.println("Warning: Total copies must be at least 1. Ignoring value: " + totalCopies);
            return;
        }
        this.totalCopies = totalCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies < 0) {
            System.out.println("Warning: Available copies cannot be negative.");
            return;
        }
        if (availableCopies > this.totalCopies) {
            System.out.println("Warning: Available copies cannot exceed total copies.");
            return;
        }
        this.availableCopies = availableCopies;
    }


    // =========================================================
    // BORROW / RETURN — unchanged logic, now use private fields
    // =========================================================

    public boolean borrow() {
        if (this.availableCopies > 0) {
            this.availableCopies--;
            return true;
        }
        System.out.println("Cannot borrow '" + this.title + "': no copies available.");
        return false;
    }

    public boolean returnBook() {
        if (this.availableCopies < this.totalCopies) {
            this.availableCopies++;
            return true;
        }
        System.out.println("Cannot return '" + this.title + "': all copies already on shelf.");
        return false;
    }


    // =========================================================
    // displayInfo()
    // =========================================================

    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Book ID          : " + this.id);
        System.out.println("Title            : " + this.title);
        System.out.println("Author           : " + this.author);
        System.out.println("Genre            : " + this.genre);
        System.out.println("Total Copies     : " + this.totalCopies);
        System.out.println("Available Copies : " + this.availableCopies);
        System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
        System.out.println("-----------------------------");
    }
}
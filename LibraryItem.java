/*
 * ============================================================
 * DAY 4 — LibraryItem.java  (New parent class)
 * ============================================================
 *
 * WHY does this class exist?
 * Book, Magazine, and DVD are all things a library lends out.
 * They share: id, title, totalCopies, availableCopies, borrow(), returnItem()
 * They differ in: loan period (how many days you can keep it),
 *                  and how displayInfo() looks
 *
 * This is the SAME pattern as Person on Day 3:
 *   - put shared stuff in the parent
 *   - force children to implement what's different (abstract methods)
 *
 * NOT abstract yet — that comes on Day 5. For today it's a normal
 * parent class that Book/Magazine/DVD extend.
 */
public class LibraryItem {
 
    // =========================================================
    // FIELDS — shared by every type of library item
    // =========================================================
 
    private int id;
    private String title;
    private int totalCopies;
    private int availableCopies;
 
 
    // =========================================================
    // CONSTRUCTOR
    // =========================================================
 
    public LibraryItem(int id, String title, int totalCopies) {
        setId(id);
        setTitle(title);
        setTotalCopies(totalCopies);
        this.availableCopies = this.totalCopies; // all copies available at first
    }
 
 
    // =========================================================
    // GETTERS
    // =========================================================
 
    public int getId()              { return this.id; }
    public String getTitle()        { return this.title; }
    public int getTotalCopies()     { return this.totalCopies; }
    public int getAvailableCopies() { return this.availableCopies; }
 
    public boolean isAvailable() {
        return this.availableCopies > 0;
    }
 
 
    // =========================================================
    // SETTERS — with validation, same pattern as Book on Day 2
    // =========================================================
 
    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Warning: ID must be positive. Ignoring: " + id);
            return;
        }
        this.id = id;
    }
 
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Warning: Title cannot be empty. Ignoring.");
            return;
        }
        this.title = title.trim();
    }
 
    public void setTotalCopies(int totalCopies) {
        if (totalCopies <= 0) {
            System.out.println("Warning: Total copies must be at least 1. Ignoring: " + totalCopies);
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
    // borrow() / returnItem() — shared logic, same for all items
    // =========================================================
 
    public boolean borrow() {
        if (this.availableCopies > 0) {
            this.availableCopies--;
            return true;
        }
        System.out.println("Cannot borrow '" + this.title + "': no copies available.");
        return false;
    }
 
    public boolean returnItem() {
        if (this.availableCopies < this.totalCopies) {
            this.availableCopies++;
            return true;
        }
        System.out.println("Cannot return '" + this.title + "': all copies already on shelf.");
        return false;
    }
 
 
    // =========================================================
    // getLoanPeriod() — WILL BE OVERRIDDEN by every child
    // =========================================================
    // This is a placeholder default. Each child class
    // (Book, Magazine, DVD) overrides this with their own number.
    //
    // On Day 5, this becomes abstract — for now it's concrete
    // with a generic fallback value so the parent class still compiles
    // on its own if a future item type forgets to override it.
 
    public int getLoanPeriod() {
        return 14; // default: 14 days
    }
 
 
    // =========================================================
    // displayInfo() — WILL BE OVERRIDDEN by every child
    // =========================================================
    // Same idea — generic version here, each child replaces it.
 
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("Item ID          : " + this.id);
        System.out.println("Title            : " + this.title);
        System.out.println("Total Copies     : " + this.totalCopies);
        System.out.println("Available Copies : " + this.availableCopies);
        System.out.println("Loan Period      : " + getLoanPeriod() + " days");
        System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
        System.out.println("-----------------------------");
    }
}


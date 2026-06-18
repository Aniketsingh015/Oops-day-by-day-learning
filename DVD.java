/*
 * ============================================================
 * DAY 4 — DVD.java  (New, extends LibraryItem)
 * ============================================================
 *
 * DVDs have the SHORTEST loan period — high demand, limited copies.
 */

public class DVD extends LibraryItem {
 
    private int durationMinutes;
    private String director;
 
 
    public DVD(int id, String title, String director, int durationMinutes, int totalCopies) {
        super(id, title, totalCopies);
        setDirector(director);
        setDurationMinutes(durationMinutes);
    }
 
 
    public int getDurationMinutes() { return this.durationMinutes; }
    public String getDirector()     { return this.director; }
 
    public void setDirector(String director) {
        if (director == null || director.trim().isEmpty()) {
            System.out.println("Warning: Director cannot be empty. Ignoring.");
            return;
        }
        this.director = director.trim();
    }
 
    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            System.out.println("Warning: Duration must be positive. Ignoring: " + durationMinutes);
            return;
        }
        this.durationMinutes = durationMinutes;
    }
 
 
    // =========================================================
    // @Override getLoanPeriod()
    // =========================================================
    // DVDs only get 3 days.
 
    @Override
    public int getLoanPeriod() {
        return 3;
    }
 
 
    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("[DVD]");
        System.out.println("ID               : " + getId());
        System.out.println("Title            : " + getTitle());
        System.out.println("Director         : " + this.director);
        System.out.println("Duration         : " + this.durationMinutes + " mins");
        System.out.println("Total Copies     : " + getTotalCopies());
        System.out.println("Available Copies : " + getAvailableCopies());
        System.out.println("Loan Period      : " + getLoanPeriod() + " days");
        System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
        System.out.println("-----------------------------");
    }
}
 

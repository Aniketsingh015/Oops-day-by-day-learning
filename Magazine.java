/*
 * ============================================================
 * DAY 4 — Magazine.java  (New, extends LibraryItem)
 * ============================================================
 *
 * Magazines have a SHORTER loan period than books — they're meant
 * to be read quickly and circulate fast.
 */

public class Magazine extends LibraryItem {

    private String publisher;
    private int issueNumber;


    public Magazine(int id, String title, String publisher, int issueNumber, int totalCopies) {
        super(id, title, totalCopies);
        setPublisher(publisher);
        setIssueNumber(issueNumber);
    }


    public String getPublisher()  { return this.publisher; }
    public int getIssueNumber()   { return this.issueNumber; }

    public void setPublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            System.out.println("Warning: Publisher cannot be empty. Ignoring.");
            return;
        }
        this.publisher = publisher.trim();
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            System.out.println("Warning: Issue number must be positive. Ignoring: " + issueNumber);
            return;
        }
        this.issueNumber = issueNumber;
    }


    // =========================================================
    // @Override getLoanPeriod()
    // =========================================================
    // Magazines only get 7 days — half of a book's loan period.
    // This is the SAME method name as in Book, but a DIFFERENT
    // implementation. That's overriding.

    @Override
    public int getLoanPeriod() {
        return 7;
    }


    @Override
    public void displayInfo() {
        System.out.println("-----------------------------");
        System.out.println("[MAGAZINE]");
        System.out.println("ID               : " + getId());
        System.out.println("Title            : " + getTitle());
        System.out.println("Publisher        : " + this.publisher);
        System.out.println("Issue Number     : " + this.issueNumber);
        System.out.println("Total Copies     : " + getTotalCopies());
        System.out.println("Available Copies : " + getAvailableCopies());
        System.out.println("Loan Period      : " + getLoanPeriod() + " days");
        System.out.println("Status           : " + (isAvailable() ? "Available" : "All Copies Borrowed"));
        System.out.println("-----------------------------");
    }
}
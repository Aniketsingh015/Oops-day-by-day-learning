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
    
}

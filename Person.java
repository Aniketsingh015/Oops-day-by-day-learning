/*
 * ============================================================
 * DAY 3 — Person.java  (Abstract Parent Class)
 * ============================================================
 *
 * WHY abstract?
 * A "Person" in real life is too vague to exist on its own in our system.
 * Every person in the library is either a Member or a Librarian.
 * Nobody is just a "Person". So we mark it abstract — it cannot be
 * instantiated directly. You CANNOT write: new Person(...)
 * You CAN write: new Member(...), new Librarian(...), new Student(...)
 *
 * WHAT goes here?
 * Only the fields and methods that are 100% common to ALL persons:
 *   - id, name, email → every person has these
 *   - getters/setters with validation → same rules for everyone
 *   - displayInfo() → abstract, because each person type displays differently
 */

public abstract class Person {

    // =========================================================
    // FIELDS — private, same as always
    // =========================================================
    // These now live HERE instead of being duplicated in every child class.
    // Member, Librarian, Student, Teacher all get these for free.

    private int id;
    private String name;
    private String email;


    // =========================================================
    // CONSTRUCTOR
    // =========================================================
    // Abstract classes CAN have constructors — but you can't call them
    // with "new Person()" directly. They're called by child constructors
    // using the "super(...)" keyword.

    public Person(int id, String name, String email) {
        setId(id);
        setName(name);
        setEmail(email);
    }


    // =========================================================
    // GETTERS — inherited by all children
    // =========================================================

    public int getId()      { return this.id; }
    public String getName() { return this.name; }
    public String getEmail(){ return this.email; }


    // =========================================================
    // SETTERS with validation — written ONCE, used by everyone
    // =========================================================
    // This is the payoff of inheritance:
    // Student, Teacher, Librarian all share this exact validation
    // without any of them writing it themselves.

    public void setId(int id) {
        if (id <= 0) {
            System.out.println("Warning: ID must be positive. Ignoring: " + id);
            return;
        }
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Warning: Name cannot be empty. Ignoring.");
            return;
        }
        if (!name.trim().matches("[a-zA-Z ]+")) {
            System.out.println("Warning: Name should contain only letters. Ignoring: " + name);
            return;
        }
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            System.out.println("Warning: Email cannot be empty. Ignoring.");
            return;
        }
        if (!email.contains("@") || !email.contains(".")) {
            System.out.println("Warning: Invalid email format. Ignoring: " + email);
            return;
        }
        this.email = email.trim().toLowerCase();
    }


    // =========================================================
    // ABSTRACT METHOD — displayInfo()
    // =========================================================
    // This forces EVERY child class to provide their own version.
    // No body here — just the signature.
    //
    // WHY abstract and not a concrete method?
    // Because how a Member displays their profile is different from
    // how a Librarian displays theirs. We can't write one version
    // that works for both — so we just declare "you must have this method"
    // and let each child decide how it looks.
    //
    // If a child class does NOT implement displayInfo(), Java gives
    // a compile error. It's a contract that cannot be broken.

    public abstract void displayInfo();


    // =========================================================
    // CONCRETE method — toString()
    // =========================================================
    // This IS shared and the same for everyone — just a basic summary.
    // Children inherit this exactly as-is.

    public String toString() {
        return "[" + this.id + "] " + this.name + " (" + this.email + ")";
    }
}
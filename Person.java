
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
 
public class Person {
    
}

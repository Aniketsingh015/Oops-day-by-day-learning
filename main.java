/*
 * ============================================================
 * DAY 3 — Main.java
 * ============================================================
 * Tests all inheritance concepts:
 *   1. Creating Student, Teacher, Librarian objects
 *   2. Demonstrating inherited fields/methods
 *   3. Polymorphic reference (Person p = new Student(...))
 *   4. super.displayInfo() chaining
 *   5. Showing what you CANNOT do with abstract Person
 */

public class main {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("  LIBRARY MANAGEMENT SYSTEM — Day 3    ");
        System.out.println("========================================\n");


        // =====================================================
        // PART 1: Creating objects — notice the constructors
        // =====================================================
        System.out.println("--- PART 1: Creating all person types ---\n");

        // Student: uses Person's id/name/email + Member's borrowedBooks + Student's grade
        Student student1 = new Student(201, "Aniket Sharma", "aniket@email.com", "B.Tech 2nd Year", "CS-2024-01");
        Student student2 = new Student(202, "Priya Singh",   "priya@email.com",  "B.Tech 3rd Year", "CS-2023-07");

        // Teacher: uses Person + Member(TEACHER limit=5) + Teacher's department
        Teacher teacher1 = new Teacher(301, "Dr. Roy",    "droy@school.edu",  "Computer Science", "TCH-001");
        Teacher teacher2 = new Teacher(302, "Prof. Gupta","gupta@school.edu", "Mathematics",      "TCH-002");

        // Librarian: uses Person only + Librarian's own fields
        Librarian lib1 = new Librarian(401, "Mrs. Das", "das@library.edu", "LIB-001", "MORNING");

        student1.displayInfo();
        teacher1.displayInfo();
        lib1.displayInfo();


        // =====================================================
        // PART 2: Inherited methods — no code duplication
        // =====================================================
        System.out.println("\n--- PART 2: Inherited fields and methods ---\n");

        // getName(), getEmail() are defined in Person
        // Student didn't write them, but can use them
        System.out.println("student1 name  (inherited): " + student1.getName());
        System.out.println("teacher1 email (inherited): " + teacher1.getEmail());
        System.out.println("lib1 toString  (inherited): " + lib1.toString());

        // borrowBook() is defined in Member
        // Student didn't write it, but inherits it
        student1.borrowBook("The Alchemist");
        student1.borrowBook("Clean Code");
        student1.borrowBook("Harry Potter");

        // 4th book should be rejected — limit is 3 (set in Member for STUDENT)
        student1.borrowBook("Wings of Fire");

        System.out.println();
        student1.displayInfo();

        // Teacher gets 5 books
        System.out.println("\nTeacher borrow limit = 5:");
        teacher1.borrowBook("The Alchemist");
        teacher1.borrowBook("Clean Code");
        teacher1.borrowBook("Harry Potter");
        teacher1.borrowBook("Wings of Fire");
        teacher1.borrowBook("Atomic Habits");
        teacher1.borrowBook("Extra Book"); // 6th — rejected
        System.out.println();
        teacher1.displayInfo();


        // =====================================================
        // PART 3: Polymorphic reference — KEY CONCEPT
        // =====================================================
        System.out.println("\n--- PART 3: Polymorphic reference ---\n");

        // You can store a Student object in a Person variable
        // because Student IS-A Person
        //
        // Person p = new Person(...); ← COMPILE ERROR: Person is abstract
        // Person p = new Student(...); ← WORKS: Student is a concrete Person
        //
        // WHY is this useful?
        // You can write methods that work with Person, and pass
        // Student, Teacher, or Librarian — all work.

        Person p1 = new Student(203, "Ravi Kumar", "ravi@email.com", "B.Sc 1st Year", "SC-2025-01");
        Person p2 = new Teacher(303, "Dr. Mehta",  "mehta@school.edu", "Physics", "TCH-003");
        Person p3 = new Librarian(402, "Mr. Sen",  "sen@library.edu", "LIB-002", "EVENING");

        // displayInfo() is called — but WHICH version runs?
        // Java checks the ACTUAL object type at runtime and calls
        // the right displayInfo(). This is called runtime polymorphism.
        // We'll deep dive into this on Day 4.
        System.out.println("Calling displayInfo() on Person references:");
        p1.displayInfo();   // runs Student's displayInfo()
        p2.displayInfo();   // runs Teacher's displayInfo()
        p3.displayInfo();   // runs Librarian's displayInfo()


        // =====================================================
        // PART 4: Librarian actions
        // =====================================================
        System.out.println("\n--- PART 4: Librarian managing the library ---\n");

        lib1.addBook("Design Patterns");
        lib1.registerMember("Sona Das");
        lib1.processBorrow("Aniket Sharma", "Design Patterns");
        lib1.processReturn("Aniket Sharma", "Design Patterns");


        // =====================================================
        // PART 5: Validation inherited from Person
        // =====================================================
        System.out.println("\n--- PART 5: Validation works for all types ---\n");

        // Validation in Person.setName() protects ALL subclasses
        Student badStudent = new Student(204, "", "valid@email.com", "10th", "S-001");
        // name was empty → Person's setName() rejected it → name stays null/default
        System.out.println("Bad student name: '" + badStudent.getName() + "'");

        Teacher badTeacher = new Teacher(304, "Dr. Valid", "notanemail", "Science", "TCH-004");
        // email had no @ → Person's setEmail() rejected it → email stays null/default
        System.out.println("Bad teacher email: '" + badTeacher.getEmail() + "'");


        // =====================================================
        // INHERITANCE CHAIN SUMMARY — printed for clarity
        // =====================================================
        System.out.println("\n--- Inheritance chain summary ---\n");
        System.out.println("student1 instanceof Student  : " + (student1 instanceof Student));
        System.out.println("student1 instanceof Member   : " + (student1 instanceof Member));
        System.out.println("student1 instanceof Person   : " + (student1 instanceof Person));
        System.out.println("teacher1 instanceof Member   : " + (teacher1 instanceof Member));
        System.out.println("lib1     instanceof Member   : " + (lib1 instanceof Member));   // false!
        System.out.println("lib1     instanceof Person   : " + (lib1 instanceof Person));   // true
        // instanceof tells you: "is this object an instance of this type or any parent type?"
    }
}
/*
 * ============================================================
 * DAY 3 — Teacher.java  (extends Member)
 * ============================================================
 *
 * Same structure as Student, but:
 *   - memberType = "TEACHER" → maxBorrowLimit = 5 (set inside Member)
 *   - Unique field: department
 *
 * Notice how clean this class is — because Person and Member
 * already handle everything common. Teacher only writes what's new.
 */

public class Teacher extends Member {

    private String department;  // e.g. "Computer Science", "Mathematics"
    private String employeeId;  // teachers have a school employee ID


    public Teacher(int id, String name, String email, String department, String employeeId) {
        super(id, name, email, "TEACHER");  // calls Member constructor with TEACHER type
        this.department = department;
        this.employeeId = employeeId;
    }


    public String getDepartment() { return this.department; }
    public String getEmployeeId() { return this.employeeId; }

    public void setDepartment(String department) { this.department = department; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }


    @Override
    public void displayInfo() {
        super.displayInfo();    // reuse Member's output
        System.out.println("Department   : " + this.department);
        System.out.println("Employee ID  : " + this.employeeId);
        System.out.println("=============================");
    }
}
package version5;

public class EmployeesInfo {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster();

        // Instantiate employees using requested custom names
        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Alex", "M.", "Hatdog", ""), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Tekken", "Jr"), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        CommissionEmployee emp3 = new CommissionEmployee(301, new Name("Arjoes", "L.", "Marata", ""), new MyDate(12, 9, 1995), new MyDate(10, 3, 2021), 120000.0);
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(401, new Name("Kevins", "S.", "Tanninator", ""), new MyDate(22, 11, 1990), new MyDate(5, 7, 2020), 80000.0, 15000.0);

        // Adding an extra worker to match the sample expected output context cleanly
        HourlyEmployee emp5 = new HourlyEmployee(102, new Name("David", "A.", "Yap", ""), new MyDate(3, 2, 1993), new MyDate(20, 8, 2023), 40.0f, 200.0);

        roster.addEmployee(emp1);
        System.out.println("Enrolled: " + emp1.getEmpName() + " (Hourly)");

        roster.addEmployee(emp2);
        System.out.println("Enrolled: " + emp2.getEmpName() + " (Piece Worker)");

        roster.addEmployee(emp3);
        System.out.println("Enrolled: " + emp3.getEmpName() + " (Commission)");

        roster.addEmployee(emp4);
        System.out.println("Enrolled: " + emp4.getEmpName() + " (Base Plus Commission)");

        // Optional additional worker to see auto-growth in action
        roster.addEmployee(emp5);

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        // Pure Polymorphic Payroll Report via Dynamic Method Dispatch
        System.out.println("\n======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        // Collection Removal Test
        System.out.println("\n======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        int removeID = 201;
        Employee removedEmp = roster.removeEmployee(removeID);
        if (removedEmp != null) {
            System.out.println("Removing Employee ID " + removeID + "... Successfully removed.");
        }
        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println("\nCurrent Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}
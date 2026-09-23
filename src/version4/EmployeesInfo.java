package version4;

public class EmployeesInfo {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        // 1. Initialize Roster with capacity 6
        EmployeeRoster roster = new EmployeeRoster(6);

        // 2. Add Employees
        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Alex", "M.", "Hatdog", ""), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Tekken", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 15.0);
        CommissionEmployee emp3 = new CommissionEmployee(301, new Name("Arjoes", "L.", "Marata", ""), new MyDate(12, 9, 1995), new MyDate(10, 3, 2021), 120000.0);
        BasePlusCommissionEmployee emp4 = new BasePlusCommissionEmployee(401, new Name("Kevins", "S.", "Tanninator", ""), new MyDate(22, 11, 1990), new MyDate(5, 7, 2020), 80000.0, 15000.0);
        HourlyEmployee emp5 = new HourlyEmployee(102, new Name("David", "A.", "Yap", ""), new MyDate(3, 2, 1993), new MyDate(20, 8, 2023), 40.0f, 200.0);

        System.out.println("Added: " + emp1.getEmpName() + " (Hourly) -> " + (roster.addEmployee(emp1) ? "Success" : "Failed"));
        System.out.println("Added: " + emp2.getEmpName() + " (Piece Worker) -> " + (roster.addEmployee(emp2) ? "Success" : "Failed"));
        System.out.println("Added: " + emp3.getEmpName() + " (Commission) -> " + (roster.addEmployee(emp3) ? "Success" : "Failed"));
        System.out.println("Added: " + emp4.getEmpName() + " (Base Plus Commission) -> " + (roster.addEmployee(emp4) ? "Success" : "Failed"));
        System.out.println("Added: " + emp5.getEmpName() + " (Hourly) -> " + (roster.addEmployee(emp5) ? "Success" : "Failed"));

        // Capacity Boundary Check Guard Test
        HourlyEmployee empExtra = new HourlyEmployee(103, new Name("Extra", "", "Worker", ""), new MyDate(1, 1, 2000), new MyDate(1, 1, 2024), 10.0f, 100.0);
        roster.addEmployee(empExtra); // Fills up to capacity 6
        HourlyEmployee empOverflow = new HourlyEmployee(104, new Name("Overflow", "", "Worker", ""), new MyDate(1, 1, 2000), new MyDate(1, 1, 2024), 10.0f, 100.0);
        boolean overflowResult = roster.addEmployee(empOverflow);
        // Remove the extra one to restore expected flow for sample tests
        roster.removeEmployee(103);

        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + roster.getCount() + " / " + roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        // 3. Polymorphic Downcast Payroll Report
        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        // 4. Removal & Array Compaction Test
        System.out.println("\n======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");
        int targetRemoveID = 201;
        Employee removed = roster.removeEmployee(targetRemoveID);
        if (removed != null) {
            System.out.printf("Removing Employee ID %d (%s)... Successfully removed.\n", targetRemoveID, removed.getEmpName());
        }
        System.out.println("Current Employee Count: " + roster.getCount());

        System.out.println("\nRemaining Employees in Roster:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}
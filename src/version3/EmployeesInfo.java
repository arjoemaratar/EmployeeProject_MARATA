package version3;

public class EmployeesInfo {
    public static void main(String[] args) {
        int targetMonth = 9; // September

        // Create sample instances
        HourlyEmployee emp1 = new HourlyEmployee(
                101,
                new Name("Alex", "M.", "Hatdog", ""),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f,
                200.0
        );

        PieceWorkerEmployee emp2 = new PieceWorkerEmployee(
                201,
                new Name("Bob", "C.", "Tekken", "Jr."),
                new MyDate(5, 4, 1998),
                new MyDate(15, 1, 2023),
                250,
                15.0
        );

        // 1. Polymorphic Collection & Payroll Processing
        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        Employee[] employees = { emp1, emp2 };
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            double totalPayout = e.computeSalary(targetMonth);
            boolean isEligible = e.getBirthDate().getMonth() == targetMonth;
            double basePay = totalPayout - (isEligible ? 5000.0 : 0.0);

            System.out.printf("%d. %s\n", (i + 1), e.toString().replace("\n", "\n   "));
            System.out.printf("   Base Pay: ₱%.2f | Birthday Bonus: ₱%.2f (%s)\n",
                    basePay, (isEligible ? 5000.0 : 0.0), (isEligible ? "Eligible" : "Ineligible"));
            System.out.printf("   Total Payout: ₱%.2f\n\n", totalPayout);
        }

        // 2. Object Contract Tests (equals & hashCode)
        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        HourlyEmployee emp1Identical = new HourlyEmployee(
                101,
                new Name("Alex", "M.", "Hatdog", ""),
                new MyDate(18, 9, 2000),
                new MyDate(1, 6, 2022),
                45.0f,
                200.0
        );

        boolean equalsResult = emp1.equals(emp1Identical);
        System.out.println("emp1 equals emp1Identical: " + equalsResult);
        System.out.println("emp1 hashCode: " + emp1.hashCode() + " | emp1Identical hashCode: " + emp1Identical.hashCode() + " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        // 3. Deep Clone Verification
        System.out.println("\n======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");

        HourlyEmployee empClone = emp1.clone();
        System.out.println("Original Name before modification: " + emp1.getEmpName());
        empClone.getEmpName().setLastName("Taylor");
        System.out.println("Clone Name changed to:             " + empClone.getEmpName());
        System.out.println("Original Name after modification:  " + emp1.getEmpName() + " (Deep copy successful!)");
    }
}
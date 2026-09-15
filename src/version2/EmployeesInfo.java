```java
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package version2;

/**
 *
 * @author User
 */
public class EmployeesInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // NOTE: Netbeans does not allow the ₱ symbol, it displays a ?

        System.out.println("--- Hourly Employee Test ---");

        HourlyEmployee hEmp1 =
                new HourlyEmployee(101, new Name("Daniel", "Sanding"));

        hEmp1.setTotalHoursWorked(45.0f);
        hEmp1.setRatePerHour(200.0);

        HourlyEmployee hEmp2 =
                new HourlyEmployee(102, new Name("Neil", "Villarito"), 38.0f, 180.0);

        System.out.println("[displayHourlyEmployee() - Instance 1]");
        hEmp1.displayHourlyEmployee();

        System.out.println("\n[displayHourlyEmployee() - Instance 2]");
        hEmp2.displayHourlyEmployee();

        System.out.println("\n[toString() - Instance 1]");
        System.out.println(hEmp1);

        System.out.println("\n[toString() - Instance 2]");
        System.out.println(hEmp2);


        System.out.println("\n--- Piece Worker Employee Test ---");

        PieceWorkerEmployee pEmp1 =
                new PieceWorkerEmployee();

        pEmp1.setEmpID(201);
        pEmp1.setEmpName("Bob Job");
        pEmp1.setTotalPieceFinished(250);
        pEmp1.setRatePerPiece(15.0);

        PieceWorkerEmployee pEmp2 = new PieceWorkerEmployee(202, new Name("Sofia", "the", "First"), new MyDate(12, 12, 2018), new MyDate(3, 5, 2000), 120, 20.0);

        System.out.println("[displayPieceWorkerEmployee() - Instance 1]");
        pEmp1.displayPieceWorkerEmployee();

        System.out.println("\n[displayPieceWorkerEmployee() - Instance 2]");
        pEmp2.displayPieceWorkerEmployee();

        System.out.println("\n[toString() - Instance 1]");
        System.out.println(pEmp1);

        System.out.println("\n[toString() - Instance 2]");
        System.out.println(pEmp2);


        System.out.println("\n--- Commission Employee Test ---");

        CommissionEmployee cEmp1 =
                new CommissionEmployee(301, new Name("Vanoss", "Gaming"));

        cEmp1.setTotalSale(75000.0);

        CommissionEmployee cEmp2 =
                new CommissionEmployee(302, new Name("Phoenix", "Wright"), 120000.0);

        System.out.println("[displayCommissionEmployee() - Instance 1]");
        cEmp1.displayCommissionEmployee();

        System.out.println("\n[displayCommissionEmployee() - Instance 2]");
        cEmp2.displayCommissionEmployee();

        System.out.println("\n[toString() - Instance 1]");
        System.out.println(cEmp1);

        System.out.println("\n[toString() - Instance 2]");
        System.out.println(cEmp2);


        System.out.println("\n--- Base Plus Commission Employee Test ---");

        BasePlusCommissionEmployee bEmp1 =
                new BasePlusCommissionEmployee();

        bEmp1.setEmpID(401);
        bEmp1.setEmpName("Super Man");
        bEmp1.setTotalSale(600000.0);
        bEmp1.setBaseSalary(15000.0);

        BasePlusCommissionEmployee bEmp2 =
                new BasePlusCommissionEmployee(
                        402,
                        new Name("Joe", "Marata"),
                        new MyDate(3, 7, 2020),
                        new MyDate(13, 9, 1994),
                        45000.0,
                        10000.0
                );

        System.out.println("[displayBasePlusCommissionEmployee() - Instance 1]");
        bEmp1.displayBasePlusCommissionEmployee();

        System.out.println("\n[displayBasePlusCommissionEmployee() - Instance 2]");
        bEmp2.displayBasePlusCommissionEmployee();

        System.out.println("\n[toString() - Instance 1]");
        System.out.println(bEmp1);

        System.out.println("\n[toString() - Instance 2]");
        System.out.println(bEmp2);
    }
}
```

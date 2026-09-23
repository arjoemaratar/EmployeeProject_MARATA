package version4;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary >= 0 ? baseSalary : 0.0;
    }

    @Override
    public double computeSalary(int currentMonth) {
        // Includes baseSalary + commission from super + birthday bonus managed via super or logic
        double bonus = (getBirthDate().getMonth() == currentMonth) ? 5000.0 : 0.0;
        return baseSalary + (getTotalSale() * getCommissionRate()) + bonus;
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s] Base Salary: ₱%.2f | Total Sales: ₱%.2f",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), baseSalary, getTotalSale());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
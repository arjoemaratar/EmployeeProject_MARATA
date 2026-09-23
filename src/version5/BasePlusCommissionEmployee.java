package version5;

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
        double bonus = (getBirthDate().getMonth() == currentMonth) ? 5000.0 : 0.0;
        return baseSalary + (getTotalSale() * getCommissionRate()) + bonus;
    }

    @Override
    public String toString() {
        double baseCalculatedSalary = baseSalary + (getTotalSale() * getCommissionRate());
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName(), baseCalculatedSalary);
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
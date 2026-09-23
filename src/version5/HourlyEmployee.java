package version5;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked >= 0 ? totalHoursWorked : 0.0f;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour >= 0 ? ratePerHour : 0.0;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double regularPay = 0.0;
        double overtimePay = 0.0;
        if (totalHoursWorked <= 40) {
            regularPay = totalHoursWorked * ratePerHour;
        } else {
            regularPay = 40 * ratePerHour;
            overtimePay = (totalHoursWorked - 40) * (ratePerHour * 1.5);
        }
        double bonus = (getBirthDate().getMonth() == currentMonth) ? 5000.0 : 0.0;
        return regularPay + overtimePay + bonus;
    }

    @Override
    public String toString() {
        double baseCalculatedSalary = (totalHoursWorked <= 40 ? totalHoursWorked * ratePerHour : 40 * ratePerHour + (totalHoursWorked - 40) * (ratePerHour * 1.5));
        return String.format("HourlyEmployee [ID: %d, Name: %s, Total Salary: ₱%.2f]",
                getEmpID(), getEmpName(), baseCalculatedSalary);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0 &&
                Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}
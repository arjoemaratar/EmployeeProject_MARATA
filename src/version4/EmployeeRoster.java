package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[max];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count++] = emp;
        return true;
    }

    public Employee removeEmployee(int empID) {
        int indexToRemove = -1;
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove == -1) {
            return null;
        }

        Employee removed = empList[indexToRemove];

        // Shift elements to the left (compaction)
        for (int i = indexToRemove; i < count - 1; i++) {
            empList[i] = empList[i + 1];
        }
        empList[count - 1] = null;
        count--;

        return removed;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                c++;
            }
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                c++;
            }
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            // Strict CommissionEmployee (excluding BasePlusCommissionEmployee)
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                c++;
            }
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                ((HourlyEmployee) empList[i]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) empList[i]).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.printf("%d. ID: %d | Name: %s | Type: %s\n",
                    (i + 1), empList[i].getEmpID(), empList[i].getEmpName(), empList[i].getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            double salary = 0.0;
            String typeLabel = "";
            boolean hasBonus = false;

            // Introspection and Downcasting since Employee doesn't declare computeSalary()
            if (e instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) e;
                salary = bpce.computeSalary(currentMonth);
                typeLabel = "Base Plus Commission";
                hasBonus = bpce.getBirthDate().getMonth() == currentMonth;
            } else if (e instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) e;
                salary = ce.computeSalary(currentMonth);
                typeLabel = "Commission";
                hasBonus = ce.getBirthDate().getMonth() == currentMonth;
            } else if (e instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) e;
                salary = he.computeSalary(currentMonth);
                typeLabel = "Hourly";
                hasBonus = he.getBirthDate().getMonth() == currentMonth;
            } else if (e instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) e;
                salary = pwe.computeSalary(currentMonth);
                typeLabel = "Piece Worker";
                hasBonus = pwe.getBirthDate().getMonth() == currentMonth;
            }

            String bonusText = hasBonus ? " (Birthday Bonus Applied)" : "";
            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%.2f%s\n",
                    typeLabel, e.getEmpID(), e.getEmpName(), salary, bonusText);
        }
    }

    public int getCount() { return count; }
    public int getMax() { return max; }
}
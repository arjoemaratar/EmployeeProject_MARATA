/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0.0;
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, String empName, double totalSale, double baseSalary) {
        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public double computeSalary(){
        double commissionRate;
        if(totalSale < 50000){
            commissionRate = 0.05;
        } 
        else if(totalSale < 100000){
            commissionRate = 0.10;
        } 
        else if(totalSale < 500000){
            commissionRate = 0.15;
        } 
        else{
            commissionRate = 0.20;
        }
        return baseSalary + (totalSale * commissionRate);
    }


    public void displayBasePlusCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | Total Sales: ₱%.2f | Base Salary: ₱%.2f\n", empID, empName, totalSale, baseSalary);
    }


    @Override
    public String toString(){
        double commissionRate = 0.05;
        if(totalSale >= 500000){commissionRate = 0.20;}
        else if(totalSale >= 100000){commissionRate = 0.15;}
        else if(totalSale >= 50000){commissionRate = 0.10;}

        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Sales: ₱%.2f, Commission Rate: %.0f%%, Base Salary: ₱%.2f, Total Salary: ₱%.2f]", 
                empID, empName, totalSale, commissionRate * 100, baseSalary, computeSalary());
    }
    
}

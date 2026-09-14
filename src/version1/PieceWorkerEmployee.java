/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPieceFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPieceFinished = 0;
        this.ratePerPiece = 0.0;
    }

    
    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPieceFinished = 0;
        this.ratePerPiece = 0.0;
    }

 
    public PieceWorkerEmployee(int empID, String empName, int totalPieceFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        setTotalPieceFinished(totalPieceFinished);
        setRatePerPiece(ratePerPiece);
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

    public int getTotalPieceFinished() {
        return totalPieceFinished;
    }

    public void setTotalPieceFinished(int totalPieceFinished) {
        this.totalPieceFinished = totalPieceFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }
    
    public double computeSalary() {
        double basePay = totalPieceFinished * ratePerPiece;
        int bonusFactor = totalPieceFinished / 100;
        double bonusPay = bonusFactor * (10 * ratePerPiece);
        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee(){
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f\n", empID, empName, totalPieceFinished, ratePerPiece);
    }

    @Override
    public String toString(){
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%.2f]", 
                empID, empName, totalPieceFinished, ratePerPiece, computeSalary());
    }
    
}
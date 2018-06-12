/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package d14125.webapp;

/**
 *
 * @author d14125
 */
public class D14125Subject {
    public String name;
    public int numOfCredit;
    public double score;
    public int numOfAttendance;
    public int numOfAbsence;
    public boolean isCompulsory;
    
    public D14125Subject () {
        name = new String();
    }
    
    public boolean isEarnable() {
        return (score >= 60) && (numOfAttendance >= (numOfAttendance+numOfAbsence)*4/5);
    }
    
    public boolean canGraduate() {
        return isEarnable() || !isCompulsory;
    }
}

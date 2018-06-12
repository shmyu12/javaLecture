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
public class D00000Grades {
    public String name;
    public int english;
    public int japanese;
    public int math;
    public int sum;
    
    public D00000Grades() {
        name = new String();
        english = 0;
        japanese = 0;
        math = 0;
        sum = 0;
    }
    
    public void sum() {
        sum = english + japanese + math;
    }
    
    public boolean haveF() {
        return (english < 60) || (japanese < 60) || (math < 60);
    }

    public void clear() {
        english = 0;
        japanese = 0;
        math = 0;
        sum();
    }
}

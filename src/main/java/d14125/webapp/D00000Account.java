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
public class D00000Account {
    final String userName;
    final String password;
    public boolean duplication;
    
    public D00000Account(String name , String pass) {
        userName = name;
        password = pass;
        duplication = false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Titan.model;

/**
 *
 * @author Lenovo
 */
public class Developpers {
    int id;
    String firstname;
    String lastname;

    public Developpers() {
    }

    public Developpers(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Developpers{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
   
    
    
    
}

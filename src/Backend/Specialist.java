/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;


import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 *
 * @author Eric Sullivan
 */
public class Specialist implements Serializable
{
    private static final long serialVersionUID = 1L;
    ImageIcon photo;
    String email;
    String fName; 
    String lName;
    String role;
    String phone;

    public Specialist(ImageIcon photo, String email, String fName, String lname, String role, String phone) {
        this.photo = photo;
        this.email = email;
        this.fName = fName;
        this.lName = lname;
        this.role = role;
        this.phone =  phone;
    }
    public Specialist(String email, String fName, String lname, String role, String phone) {
        this.photo = null;
        this.email = email;
        this.fName = fName;
        this.lName = lname;
        this.role = role;
        this.phone =  phone;
        
    }
     public ImageIcon getPhoto() {
        return photo;
    }

    public void setPhoto(ImageIcon photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getLname() {
        return lName;
    }

    public void setLname(String lname) {
        this.lName = lname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public String getFullName(){
        return fName + " " + lName;
    }
    
}

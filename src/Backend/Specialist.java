/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Backend;


import javax.swing.ImageIcon;

/**
 *
 * @author Eric Sullivan
 */
public class Specialist{
    ImageIcon photo;
    String email;
    String fName; 
    String lname;
    String role;
    String phone;

    public Specialist(ImageIcon photo, String email, String fName, String lname, String role, String phone) {
        this.photo=photo;
        this.email =email;
        this.fName=fName;
        this.lname=lname;
        
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
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
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
    
    
}

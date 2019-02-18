/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class RegisteredStudentInformation {
    private SimpleStringProperty sid,sname,saddress,contact,email,aid;
    public RegisteredStudentInformation(String aid,String sid,String sname,String saddress,String contact,String email){
        this.aid=new SimpleStringProperty(aid);
        this.sid=new SimpleStringProperty(sid);
        this.sname=new SimpleStringProperty(sname);
        this.saddress=new SimpleStringProperty(saddress);
        this.contact=new SimpleStringProperty(contact);
        this.email=new SimpleStringProperty(email);
    }
    public String getAid(){
        return aid.get();
    }
    public String getSid(){
        return sid.get();
    }
    public String getSname(){
        return sname.get();
    }
    public String getSaddress(){
        return saddress.get();
    }
    public String getContact(){
        return contact.get();
    }
    public String getEmail(){
        return email.get();
    }
}

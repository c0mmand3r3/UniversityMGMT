/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class EnquiryInformation {
    private StringProperty eid,name,email,contact,address,status,nation,degree,intrest;
    private IntegerProperty book_quant,book_left;
    public EnquiryInformation(String eid,String name,String email,String contact,String address
                                ,String status,String nation,String degree,String intrest){
        this.eid=new SimpleStringProperty(eid);
        this.name=new SimpleStringProperty(name);
        this.email=new SimpleStringProperty(email);
        this.contact=new SimpleStringProperty(contact);
        this.address=new SimpleStringProperty(address);
        this.status=new SimpleStringProperty(status);
        this.nation=new SimpleStringProperty(nation);
        this.degree=new SimpleStringProperty(degree);
        this.intrest=new SimpleStringProperty(intrest);
    }
    public EnquiryInformation(String eid,String name,String email,String contact,int book_quant,String address,int book_left){
        this.eid=new SimpleStringProperty(eid);
        this.name=new SimpleStringProperty(name);
        this.email=new SimpleStringProperty(email);
        this.contact=new SimpleStringProperty(contact);
        this.book_quant=new SimpleIntegerProperty(book_quant);
        this.address=new SimpleStringProperty(address);
        this.book_left=new SimpleIntegerProperty(book_left);
    }
    public int getBook_quant(){
        return book_quant.get();
    }
    public int getBook_left(){
        return book_left.get();
    }
    public String getEid(){
        return eid.get();
    }
    public String getName(){
        return name.get();
    }
    public String getEmail(){
        return email.get();
    }
    public String getContact(){
        return contact.get();
    }
    public String getAddress(){
        return address.get();
    }
    public String getStatus(){
        return status.get();
    }
    public String getNation(){
        return nation.get();
    }
    public String getDegree(){
        return degree.get();
    }
    public String getIntrest(){
        return intrest.get();
    }
}

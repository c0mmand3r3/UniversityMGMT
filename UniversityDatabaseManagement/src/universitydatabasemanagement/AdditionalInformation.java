/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class AdditionalInformation {
    private StringProperty website,contact,email,post;
    public AdditionalInformation(String website,String contact,String email,String post){
        this.website=new SimpleStringProperty(website);
        this.contact=new SimpleStringProperty(contact);
        this.email=new SimpleStringProperty(email);
        this.post=new SimpleStringProperty(post);
    }
    public String getWebsite(){
        return website.get();
    }
    public String getContact(){
        return contact.get();
    }
    public String getEmail(){
        return email.get();
    }
    public String getPost(){
        return post.get();
    }
}

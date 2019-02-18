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
public class CollegeCollectionInformation {
    private StringProperty cid;
    private StringProperty college_name;
    private StringProperty college_type;
    private StringProperty full_address,town,district,state,country;
    private StringProperty website,contact,email,post;
    public CollegeCollectionInformation(String cid,String college_name,String college_type,
            String full_address,String town,String district,String state,String country,
            String website,String contact,String email,String post){
        this.cid=new SimpleStringProperty(cid);
        this.college_name=new SimpleStringProperty(college_name);
        this.college_type=new SimpleStringProperty(college_type);
        this.full_address=new SimpleStringProperty(full_address);
        this.town=new SimpleStringProperty(town);
        this.district=new SimpleStringProperty(district);
        this.state=new SimpleStringProperty(state);
        this.country=new SimpleStringProperty(country);
        this.website=new SimpleStringProperty(website);
        this.contact=new SimpleStringProperty(contact);
        this.email=new SimpleStringProperty(email);
        this.post=new SimpleStringProperty(post);
    }
    public String getCid(){
        return cid.get();
    }
    public String getCollege_name(){
        return college_name.get();
    }
    public String getCollege_type(){
        return college_type.get();
    }
    public void setCid(String value){
        cid.set(value);
    }
    public void setCollege_name(String value){
        college_name.set(value);
    }
    public void setCollege_type(String value){
        college_type.set(value);
    }
    public StringProperty cidProperty(){
        return cid;
    }
    public StringProperty college_nameProperty(){
        return college_name;
    }
    public StringProperty college_typeProperty(){
        return college_type;
    }
    public String getFull_address(){
        return full_address.get();
    }
    public String getTown(){
        return town.get();
    }
    public String getDistrict(){
        return district.get();
    }
    public String getState(){
        return state.get();
    }
    public String getCountry(){
        return country.get();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class CollegeInformation {
    private StringProperty cid;
    private StringProperty college_name;
    private StringProperty college_type;
    public CollegeInformation(String cid,String college_name,String college_type){
        this.cid=new SimpleStringProperty(cid);
        this.college_name=new SimpleStringProperty(college_name);
        this.college_type=new SimpleStringProperty(college_type);
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
}

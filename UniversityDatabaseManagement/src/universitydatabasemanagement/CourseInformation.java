/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class CourseInformation {
    private SimpleStringProperty pid;
    private SimpleStringProperty cid,coursename;
    private SimpleFloatProperty credit;
    public CourseInformation(String pid,String cid,String coursename,Float credit){
        this.pid=new SimpleStringProperty(pid);
        this.cid=new SimpleStringProperty(cid);
        this.coursename=new SimpleStringProperty(coursename);
        this.credit=new SimpleFloatProperty(credit);
    }
    public CourseInformation(String cid,String coursename,Float credit){
        this.cid=new SimpleStringProperty(cid);
        this.coursename=new SimpleStringProperty(coursename);
        this.credit=new SimpleFloatProperty(credit);
    }
    public String getPid(){
        return pid.get();
    }
    public String getCid(){
        return cid.get();
    }
    public String getCoursename(){
        return coursename.get();
    }
    public Float getCredit(){
        return credit.get();
    }
}

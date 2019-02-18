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
public class AcademicRegistrationTable {
    private SimpleStringProperty sid,sname,pid,pname;
    public AcademicRegistrationTable(String sid,String sname,String pid,String pname){
        this.sid=new SimpleStringProperty(sid);
        this.sname=new SimpleStringProperty(sname);
        this.pid=new SimpleStringProperty(pid);
        this.pname=new SimpleStringProperty(pname);
    }
    public String getSid(){
        return sid.get();
    }
    public String getSname(){
        return sname.get();
    }
    public String getPid(){
        return pid.get();
    }
    public String getPname(){
        return pname.get();
    }
}

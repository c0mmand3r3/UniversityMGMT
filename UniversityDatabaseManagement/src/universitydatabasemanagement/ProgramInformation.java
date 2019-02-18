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
public class ProgramInformation {
    private SimpleStringProperty id;
    private SimpleStringProperty title;
    public ProgramInformation(){
        this.id=null;
        this.title=null;
    }
    public ProgramInformation(String id,String title){
        this.id=new SimpleStringProperty(id);
        this.title=new SimpleStringProperty(title);
        System.out.println(this.id.get());
    }
    public String getId(){
        return id.get();
    }
    public String getTitle(){
        return title.get();
    }
    public void setId(String value){
        id.set(value);
    }
    public void setTitle(String value){
        title.set(value);
    }
    public StringProperty idProperty(){
        return id;
    }
    public StringProperty titleProperty(){
        return title;
    }
}

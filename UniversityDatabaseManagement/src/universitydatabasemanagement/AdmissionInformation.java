/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Mathew_Anish
 */
public class AdmissionInformation {
    private SimpleStringProperty aid,fullname,fulladdress,nationality,email,contact_no,admission_type;
    private SimpleStringProperty selected_program,marks_details,selection_status;
    private SimpleIntegerProperty process_status,checker;
    public AdmissionInformation(String aid,int process_staus,int checker){
        this.aid=new SimpleStringProperty(aid);
        this.process_status=new SimpleIntegerProperty(process_staus);
        this.checker=new SimpleIntegerProperty(checker);
    }
    public AdmissionInformation(String aid,String fullname,String fulladdress,String nationality
        ,String email,String contact_no){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.fulladdress=new SimpleStringProperty(fulladdress);
        this.nationality=new SimpleStringProperty(nationality);
        this.email=new SimpleStringProperty(email);
        this.contact_no=new SimpleStringProperty(contact_no);
    }
    public AdmissionInformation(String aid,String fullname,String fulladdress,String nationality
        ,String email,String contact_no,String admission_type){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.fulladdress=new SimpleStringProperty(fulladdress);
        this.nationality=new SimpleStringProperty(nationality);
        this.email=new SimpleStringProperty(email);
        this.contact_no=new SimpleStringProperty(contact_no);
        this.admission_type=new SimpleStringProperty(admission_type);
    }
    public AdmissionInformation(String aid,String fullname,String fulladdress,String nationality
        ,String email,String contact_no,String admission_type,String selected_program){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.fulladdress=new SimpleStringProperty(fulladdress);
        this.nationality=new SimpleStringProperty(nationality);
        this.email=new SimpleStringProperty(email);
        this.contact_no=new SimpleStringProperty(contact_no);
        this.admission_type=new SimpleStringProperty(admission_type);
        this.selected_program=new SimpleStringProperty(selected_program);
    }
    public AdmissionInformation(String aid,String fullname,String fulladdress,String nationality
        ,String email,String contact_no,String admission_type,String selected_program,String marks_details
        ,String selection_status){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.fulladdress=new SimpleStringProperty(fulladdress);
        this.nationality=new SimpleStringProperty(nationality);
        this.email=new SimpleStringProperty(email);
        this.contact_no=new SimpleStringProperty(contact_no);
        this.admission_type=new SimpleStringProperty(admission_type);
        this.selected_program=new SimpleStringProperty(selected_program);
        this.marks_details=new SimpleStringProperty(marks_details);
        this.selection_status=new SimpleStringProperty(selection_status);
    }
    public AdmissionInformation(String aid,String fullname,String admission_type,String selected_program,String marks_details){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.admission_type=new SimpleStringProperty(admission_type);
        this.selected_program=new SimpleStringProperty(selected_program);
        this.marks_details=new SimpleStringProperty(marks_details);
    }
    public AdmissionInformation(String aid,String fullname,String selected_program){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.selected_program=new SimpleStringProperty(selected_program);
    }
    public AdmissionInformation(String aid,String selection_status){
        this.aid=new SimpleStringProperty(aid);
        this.selection_status=new SimpleStringProperty(selection_status);
    }
    public AdmissionInformation(String aid,String fullname,String admission_type,String selected_program){
        this.aid=new SimpleStringProperty(aid);
        this.fullname=new SimpleStringProperty(fullname);
        this.admission_type=new SimpleStringProperty(admission_type);
        this.selected_program=new SimpleStringProperty(selected_program);
    }
    public String getAid(){
        return aid.get();
    }
    public String getFullname(){
        return fullname.get();
    }
    public String getFulladdress(){
        return fulladdress.get();
    }
    public String getNationality(){
        return nationality.get();
    }
    public String getEmail(){
        return email.get();
    }
    public String getContact_no(){
        return contact_no.get();
    }
    public String getAdmission_type(){
        return admission_type.get();
    }
    public String getSelected_program(){
        return selected_program.get();
    }
    public String getMarks_details(){
        return marks_details.get();
    }
    public String getSelection_status(){
        return selection_status.get();
    }
    public int getProcess_status(){
        return process_status.get();
    }
    public int getChecker(){
        return checker.get();
    }
}

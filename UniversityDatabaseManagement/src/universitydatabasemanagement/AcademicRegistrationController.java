/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class AcademicRegistrationController implements Initializable {

    @FXML
    private ComboBox<String> selected_program_combo_1_list;
    @FXML
    private TableView<CourseInformation> program_course_tableview_1;
    @FXML
    private TableColumn<CourseInformation, String> course_id_col_1;
    @FXML
    private TableColumn<CourseInformation, String> course_name_col_1;
    @FXML
    private TableColumn<CourseInformation, Float> credit_hours_col_1;
    @FXML
    private TextField student_id_text_map_1;
    @FXML
    private TextField course_id_text_map_1;
    @FXML
    private Button add_button_map_1;
    @FXML
    private Button clear_button_map_1;
    @FXML
    private TableView<AcademicRegistrationTable> student_program_course_mapped_tableview_2;
    @FXML
    private TableColumn<AcademicRegistrationTable, String> student_id_col_2_mapped;
    @FXML
    private TableColumn<AcademicRegistrationTable, String> student_name_col_2_mapped;
    @FXML
    private TableColumn<AcademicRegistrationTable, String> program_id_col_2_mapped;
    @FXML
    private TableColumn<AcademicRegistrationTable, String> program_name_col_2_mapped;
    @FXML
    private TableView<AdmissionInformation> student_program_course_to_be_mapped_tableview_2;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_col_2_tobe;
    @FXML
    private TableColumn<AdmissionInformation, String> student_name_col_2_tobe;
    @FXML
    private TableColumn<AdmissionInformation, String> selected_program_col_2_tobe;
    @FXML
    private TextField search_student_id_text_2_mapped;
    @FXML
    private Button delete_whole_button_2;
    @FXML
    private Button clear_button_2_mapped;
    @FXML
    private TableView<CourseInformation> student_courses_tableview_2;
    @FXML
    private TableColumn<CourseInformation,String> courses_id_col_2_student_courses;
    @FXML
    private TableColumn<CourseInformation,String> course_name_col_2_student_courses;
    @FXML
    private TableColumn<CourseInformation,Float> credit_hours_col_2_student_courses;
    @FXML
    private TextField course_id_show_courses_text_2;
    @FXML
    private Button delete_button_2_show_courses;
    @FXML
    private Button clear_button_2_show_courses;
    @FXML
    private TextField student_id_show_courses_text_2;
    @FXML
    private Button show_courses_button_2_show_course;
    
    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"student_course_mapping_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("CREATE table student_course_mapping_info(\n" +
                    "    student_id varchar(50),\n" +
                    "    course_id varchar(50),\n" +
                    "    foreign key(student_id) REFERENCES student_registration_info(student_id) on DELETE CASCADE on UPDATE CASCADE,\n" +
                    "    foreign key(course_id) REFERENCES course_info(course_id) on DELETE CASCADE on UPDATE CASCADE,\n" +
                    "    primary key(student_id,course_id)    \n" +
                    ");");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        setAllComboBox();
        fill1stTableNow();
        fill2ndTableNow();
        course_id_show_courses_text_2.setEditable(false);
    }
    
    
    
    
    
    //related methods of the fullfillment
    private void setAllComboBox(){
        ObservableList<String> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select program_id,title from program_info");
            while(rs.next()){
                list.add(rs.getString("program_id")+"+"+rs.getString("title"));
            }
            selected_program_combo_1_list.setItems(list);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private ObservableList<CourseInformation> getValuesForCourseList(String value){
        ObservableList<CourseInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from course_info where program_id=\""+value+"\"");
            while(rs.next()){
                list.add(new CourseInformation(rs.getString("course_id"),rs.getString("course_name"),rs.getFloat("credit_hour")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private ObservableList<AdmissionInformation> getValuesFor1stTable(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select applicant_id,student_id from student_registration_info where process_status=0");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select full_name,selected_program from application_form_details where aid=\""+rs.getString("applicant_id")+"\"");
                if(rss.next()){
                    list.add(new AdmissionInformation(rs.getString("student_id"),rss.getString("full_name"),rss.getString("selected_program")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private void fill1stTableNow(){
        student_id_col_2_tobe.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_name_col_2_tobe.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        selected_program_col_2_tobe.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        student_program_course_to_be_mapped_tableview_2.setItems(getValuesFor1stTable());
        student_program_course_to_be_mapped_tableview_2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try{
                    Statement smt=conn.createStatement();
                    ResultSet rst=smt.executeQuery("select applicant_id from student_registration_info where student_id=\""+student_program_course_to_be_mapped_tableview_2.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");
                    if(rst.next()){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                                rst.getString("applicant_id")+"\"");
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("select * from student_registration_info where student_id=\""+student_program_course_to_be_mapped_tableview_2.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");                    
                        if(rs.next()&&rss.next()){
                            JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                + "Application ID : "+rs.getString("aid")+"\n"
                                + "Student ID : "+rss.getString("student_id")+"\n"
                                + "Full Name : "+rs.getString("full_name")+"\n"
                                + "DOB : "+rss.getString("dob_year")+"\\"+rss.getString("dob_month")+"\\"+rss.getString("dob_day")+"\n"
                                + "Gender : "+rss.getString("gender")+"\n"
                                + "Full Address : "+rs.getString("full_address")+"\n"
                                + "Nationality : "+rs.getString("nationality")+"\n"
                                + "Student Email : "+rs.getString("email")+"\n"
                                + "Student Contact No. : "+rs.getString("contact_no")+"\n"
                                + "Admission Type : "+rs.getString("admission_type")+"\n"
                                + "Selected Program : "+rs.getString("selected_program")+"\n"
                                + "Marks Details : "+rs.getString("marks_details")+"\n"
                                + "Selection Status : "+rs.getString("selection_status")+"\n"
                                + "Guardian Name : "+rss.getString("guardian_name")+"\n"
                                + "Guardian Contact No. : "+rss.getString("guardian_contact")+"\n"
                                + "Bank Name : "+rss.getString("bank_name")+"\n"
                                + "Bank A/C No. : "+rss.getString("bank_ac")+"\n"
                                + "PAN No. : "+rss.getString("PAN_no")+"\n"
                                + "Enrolment Date : "+rss.getString("enrolment_year")+"\\"+rss.getString("enrolment_month")+"\\"+rss.getString("enrolment_day"));
                            student_id_text_map_1.setText(rss.getString("student_id"));
                            ResultSet rsts=st.executeQuery("select program_id,title from program_info where title=\""+rs.getString("selected_program")+"\"");
                            if(rsts.next()){
                                selected_program_combo_1_list.setValue(rsts.getString("program_id")+"+"+rsts.getString("title"));
                                course_id_col_1.setCellValueFactory(new PropertyValueFactory<>("cid"));
                                course_name_col_1.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                                credit_hours_col_1.setCellValueFactory(new PropertyValueFactory<>("credit"));
                                program_course_tableview_1.setItems(getValuesForCourseList(rsts.getString("program_id")));
                            }
                        }
                    }
                }catch(SQLException ex){
                    
                }
            }
            
        });
    }
    private ObservableList<AcademicRegistrationTable> getValuesForAlreadyMappedList(){
        ObservableList<AcademicRegistrationTable> list=FXCollections.observableArrayList();
        Statement st;
        try {
            st=conn.createStatement();
            ResultSet rs=st.executeQuery("select applicant_id,student_id from student_registration_info where process_status=1");
            while(rs.next()){
               Statement stt=conn.createStatement();
               ResultSet rss=stt.executeQuery("select full_name,selected_program from application_form_details where aid=\""+rs.getString("applicant_id")+"\"");
               if(rss.next()){
                   Statement sttt=conn.createStatement();
                   ResultSet rsss=sttt.executeQuery("select program_id from program_info where title=\""+rss.getString("selected_program")+"\"");
                   if(rsss.next()){
                       list.add(new AcademicRegistrationTable(rs.getString("student_id"),rss.getString("full_name"),rsss.getString("program_id"),rss.getString("selected_program")));
                   }
               }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private void fill2ndTableNow(){
        student_id_col_2_mapped.setCellValueFactory(new PropertyValueFactory<>("sid"));
        student_name_col_2_mapped.setCellValueFactory(new PropertyValueFactory<>("sname"));
        program_id_col_2_mapped.setCellValueFactory(new PropertyValueFactory<>("pid"));
        program_name_col_2_mapped.setCellValueFactory(new PropertyValueFactory<>("pname"));
        student_program_course_mapped_tableview_2.setItems(getValuesForAlreadyMappedList());
        student_program_course_mapped_tableview_2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try{
                    Statement smt=conn.createStatement();
                    ResultSet rst=smt.executeQuery("select applicant_id from student_registration_info where student_id=\""+student_program_course_mapped_tableview_2.getSelectionModel().getSelectedItem().getSid().toString().toUpperCase()+"\"");
                    if(rst.next()){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                                rst.getString("applicant_id")+"\"");
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("select * from student_registration_info where student_id=\""+student_program_course_mapped_tableview_2.getSelectionModel().getSelectedItem().getSid().toString().toUpperCase()+"\"");                    
                        if(rs.next()&&rss.next()){
                            JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                + "Application ID : "+rs.getString("aid")+"\n"
                                + "Student ID : "+rss.getString("student_id")+"\n"
                                + "Full Name : "+rs.getString("full_name")+"\n"
                                + "DOB : "+rss.getString("dob_year")+"\\"+rss.getString("dob_month")+"\\"+rss.getString("dob_day")+"\n"
                                + "Gender : "+rss.getString("gender")+"\n"
                                + "Full Address : "+rs.getString("full_address")+"\n"
                                + "Nationality : "+rs.getString("nationality")+"\n"
                                + "Student Email : "+rs.getString("email")+"\n"
                                + "Student Contact No. : "+rs.getString("contact_no")+"\n"
                                + "Admission Type : "+rs.getString("admission_type")+"\n"
                                + "Selected Program : "+rs.getString("selected_program")+"\n"
                                + "Marks Details : "+rs.getString("marks_details")+"\n"
                                + "Selection Status : "+rs.getString("selection_status")+"\n"
                                + "Guardian Name : "+rss.getString("guardian_name")+"\n"
                                + "Guardian Contact No. : "+rss.getString("guardian_contact")+"\n"
                                + "Bank Name : "+rss.getString("bank_name")+"\n"
                                + "Bank A/C No. : "+rss.getString("bank_ac")+"\n"
                                + "PAN No. : "+rss.getString("PAN_no")+"\n"
                                + "Enrolment Date : "+rss.getString("enrolment_year")+"\\"+rss.getString("enrolment_month")+"\\"+rss.getString("enrolment_day"));
                            search_student_id_text_2_mapped.setText(rss.getString("student_id"));
                            student_id_text_map_1.setText(rss.getString("student_id"));
                            student_id_show_courses_text_2.setText(rss.getString("student_id"));
                            ResultSet rsts=st.executeQuery("select program_id,title from program_info where title=\""+rs.getString("selected_program")+"\"");
                            if(rsts.next()){
                                selected_program_combo_1_list.setValue(rsts.getString("program_id")+"+"+rsts.getString("title"));
                                course_id_col_1.setCellValueFactory(new PropertyValueFactory<>("cid"));
                                course_name_col_1.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                                credit_hours_col_1.setCellValueFactory(new PropertyValueFactory<>("credit"));
                                program_course_tableview_1.setItems(getValuesForCourseList(rsts.getString("program_id")));
                            }
                            FillCourseListTable(rss.getString("student_id"));
                        }
                    }
                }catch(SQLException ex){
                    
                }
            }
            
        });
    }
    
    private ObservableList<CourseInformation> getValuesForCourseListMapped(String sid){
        ObservableList<CourseInformation> list=FXCollections.observableArrayList();
        Statement st;
        try {
            st=conn.createStatement();
            ResultSet rs=st.executeQuery("select course_id from student_course_mapping_info where student_id=\""+sid+"\"");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select course_name,credit_hour from course_info where course_id=\""+rs.getString("course_id")+"\"");
                if(rss.next()){
                    list.add(new CourseInformation(rs.getString("course_id"),rss.getString("course_name"),rss.getFloat("credit_hour")));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private static String svid="";
    private void FillCourseListTable(String str){
        courses_id_col_2_student_courses.setCellValueFactory(new PropertyValueFactory<>("cid"));
        course_name_col_2_student_courses.setCellValueFactory(new PropertyValueFactory<>("coursename"));
        credit_hours_col_2_student_courses.setCellValueFactory(new PropertyValueFactory<>("credit"));
        student_courses_tableview_2.setItems(getValuesForCourseListMapped(str));
        student_courses_tableview_2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                course_id_show_courses_text_2.setText(student_courses_tableview_2.getSelectionModel().getSelectedItem().getCid());
                svid=str;
            }
            
        });
    }
    
    
    
    
    
    
    //all the event occurs in the admission management
    @FXML
    public void DeleteButton2ButtonClickedListener(ActionEvent ae){
        if(course_id_show_courses_text_2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Course is not selected from the table! Select the Course Row.");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to delete this Course Record?","Delete Record Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    int count=0;
                    Statement stv=conn.createStatement();
                    ResultSet rsv=stv.executeQuery("select * from student_course_mapping_info where student_id=\""+svid+"\"");
                    while(rsv.next()){
                        count=count+1;
                    }
                    System.out.println(count);
                    System.out.println(svid);
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from student_course_mapping_info where course_id=\""+course_id_show_courses_text_2.getText().toUpperCase()+"\" and student_id=\""+svid+"\"");
                    if(rs.next()){
                        if(count==1){
                            stv.executeUpdate("UPDATE student_registration_info SET process_status=0 where student_id=\""+svid+"\"");
                            fill1stTableNow();
                        }                       
                        st.executeUpdate("DELETE FROM `student_course_mapping_info` WHERE course_id=\""+course_id_show_courses_text_2.getText()+"\" and student_id=\""+svid+"\"");
                        JOptionPane.showMessageDialog(null, "Deleted Sucessfully!");
                        fill2ndTableNow();
                        FillCourseListTable(svid);
                        clearButton2ButtonClickedListener(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Course ID doesn't match!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButton2ButtonClickedListener(ActionEvent ae){
        student_id_show_courses_text_2.setText("");
        course_id_show_courses_text_2.setText("");
        FillCourseListTable("");
        svid="";
    }
    @FXML
    public void showCourses2ButtonClickedListener(ActionEvent ae){
        if(student_id_show_courses_text_2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Student ID is Blank!");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select course_id from student_course_mapping_info where student_id=\""+student_id_show_courses_text_2.getText().toUpperCase()+"\"");
                if(rs.next()){
                    FillCourseListTable(student_id_show_courses_text_2.getText().toUpperCase());
                }else{
                    JOptionPane.showMessageDialog(null, "Student ID is not Matched!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void DeleteWhole2ButtonClickedListener(ActionEvent ae){
        if(search_student_id_text_2_mapped.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Student ID Search field is blank.");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to delete this Record?","Delete Record Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select student_id from student_course_mapping_info where student_id=\""+search_student_id_text_2_mapped.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM `student_course_mapping_info` WHERE student_id=\""+search_student_id_text_2_mapped.getText().toUpperCase()+"\"");
                        stt.executeUpdate("UPDATE `student_registration_info` SET process_status=0 where student_id=\""+search_student_id_text_2_mapped.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        fill1stTableNow();
                        fill2ndTableNow();
                        FillCourseListTable("");
                    }else{
                        JOptionPane.showMessageDialog(null, "Student ID Courses doesn't find.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButton2MappedButtonClickedListener(ActionEvent ae){
        search_student_id_text_2_mapped.setText("");
    }
    
    @FXML
    public void ComboBoxEventOccurWhenSelected(ActionEvent ae){
        String value=selected_program_combo_1_list.getSelectionModel().getSelectedItem();
        String[] parts=value.split("\\+");
        course_id_col_1.setCellValueFactory(new PropertyValueFactory<>("cid"));
        course_name_col_1.setCellValueFactory(new PropertyValueFactory<>("coursename"));
        credit_hours_col_1.setCellValueFactory(new PropertyValueFactory<>("credit"));
        program_course_tableview_1.setItems(getValuesForCourseList(parts[0]));
    }
    @FXML
    public void ClearButtonMap1ButtonClickedListener(ActionEvent ae){
        student_id_text_map_1.setText("");
        course_id_text_map_1.setText("");
    }
    @FXML
    public void AddButtonMap1ButtonClickedListener(ActionEvent ae){
        if(student_id_text_map_1.getText().equals("")||course_id_text_map_1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "TextField's are clear. Nothing is inserted in the blank");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Record Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select applicant_id from student_registration_info where student_id=\""+student_id_text_map_1.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        ResultSet rss=st.executeQuery("select selected_program from application_form_details where aid=\""+rs.getString("applicant_id")+"\"");
                        if(rss.next()){
                            ResultSet rsss=st.executeQuery("select program_id from program_info where title=\""+rss.getString("selected_program")+"\"");
                            if(rsss.next()){
                                ResultSet rssss=st.executeQuery("select * from course_info where program_id=\""+rsss.getString("program_id")+"\" and course_id=\""+course_id_text_map_1.getText().toUpperCase()+"\"");
                                if(rssss.next()){
                                    //add now
                                    st.executeUpdate("INSERT INTO `student_course_mapping_info`(`student_id`, `course_id`) VALUES (\""+ student_id_text_map_1.getText().toUpperCase()+"\",\""+course_id_text_map_1.getText().toUpperCase()+"\")");
                                    st.executeUpdate("update student_registration_info set process_status=1 where student_id=\""+student_id_text_map_1.getText().toUpperCase()+"\"");
                                    JOptionPane.showMessageDialog(null, "Successfully Mapped!");
                                    ClearButtonMap1ButtonClickedListener(ae);
                                    fill1stTableNow();
                                    fill2ndTableNow();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Invalid Course ID according to Selected Program! Try Valid One!");
                                }
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Student ID doesn't matched for course mapping.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    

    
    
    //color changes of the buttons
    @FXML
    public void AddMap1buttonEntered(MouseEvent me){
        add_button_map_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddMap1buttonExited(MouseEvent me){
        add_button_map_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    @FXML
     public void ClearMap1buttonEntered(MouseEvent me){
        clear_button_map_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMap1buttonExited(MouseEvent me){
        clear_button_map_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void DeleteWhole2buttonEntered(MouseEvent me){
        delete_whole_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteWhole2buttonExited(MouseEvent me){
        delete_whole_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMapped2buttonEntered(MouseEvent me){
        clear_button_2_mapped.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMapped2buttonExited(MouseEvent me){
        clear_button_2_mapped.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ShowCourses2buttonEntered(MouseEvent me){
        show_courses_button_2_show_course.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ShowCourses2buttonExited(MouseEvent me){
        show_courses_button_2_show_course.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteShowCourses2buttonEntered(MouseEvent me){
        delete_button_2_show_courses.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteShowCourses2buttonExited(MouseEvent me){
        delete_button_2_show_courses.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearShowCourses2buttonEntered(MouseEvent me){
        clear_button_2_show_courses.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearShowCourses2buttonExited(MouseEvent me){
        clear_button_2_show_courses.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
}

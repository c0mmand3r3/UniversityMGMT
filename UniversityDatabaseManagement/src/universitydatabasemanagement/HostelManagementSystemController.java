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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class HostelManagementSystemController implements Initializable {

    @FXML
    private TextField hostel_id_text_1_HM;
    @FXML
    private TextField hostel_name_text_1_HM;
    @FXML
    private TextField warden_name_text_1_HM;
    @FXML
    private Button add_button_1_HM;
    @FXML
    private Button clear_button_1_HM;
    @FXML
    private TextField room_number_text_2_HRM;
    @FXML
    private Button assign_button_2_HRM;
    @FXML
    private Button clear_button_2_HRM;
    @FXML
    private TextField room_capacity_text_2_HRM;
    @FXML
    private ComboBox<String> hostel_id_combo_3_RA;
    @FXML
    private ComboBox<String> hostel_id_combo_2_HRM;
    @FXML
    private TextField student_id_text_3_RA;
    @FXML
    private TextField room_no_text_3_RA;
    @FXML
    private ComboBox<Integer> join_date_year_combo_3_RA;
    @FXML
    private ComboBox<Integer> join_date_month_combo_3_RA;
    @FXML
    private ComboBox<Integer> join_date_day_combo_3_RA;
    @FXML
    private Button assign_button_3_RA;
    @FXML
    private Button clear_button_3_RA;
    @FXML
    private TableView<AdmissionInformation> hostel_table_tableview_middle_HT;
    @FXML
    private TableColumn<AdmissionInformation, String> hostel_id_col_middle_HT;
    @FXML
    private TableColumn<AdmissionInformation, String> hostel_name_col_middle_HT;
    @FXML
    private TableColumn<AdmissionInformation, String> warden_name_col_middle_HT;
    @FXML
    private TableView<AdmissionInformation> hostel_room_information_tableview_middle_HRI;
    @FXML
    private TableColumn<AdmissionInformation, String> room_no_col_middle_HRI;
    @FXML
    private TableColumn<AdmissionInformation, String> room_capacity_col_middle_HRI;
    @FXML
    private TableColumn<AdmissionInformation, String> room_available_col_middle_HRI;
    @FXML
    private TableView<AdmissionInformation> student_list_tableview_middle_SL;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_col_middle_SL;
    @FXML
    private TableColumn<AdmissionInformation, String> student_name_col_middle_SL;
    @FXML
    private ComboBox<String> hostel_id_combo_middle_HRI;
    @FXML
    private TextField room_no_text_middle_SL;
    @FXML
    private Button show_list_button_middle_SL;
    @FXML
    private Button clear_button_middle_SL;
    @FXML
    private TextField room_no_text_middle_HRI;
    @FXML
    private Button delete_button_middle_HRI;
    @FXML
    private Button clear_button_middle_HRI;
    @FXML
    private TextField search_student_id_text_middle_ST;
    @FXML
    private TableView<AdmissionInformation> student_table_tableview_middle_ST;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_col_middle_ST;
    @FXML
    private TableColumn<AdmissionInformation, String> hostel_id_col_middle_ST;
    @FXML
    private TableColumn<AdmissionInformation, String> room_no_col_middle_ST;
    @FXML
    private ComboBox<String> hostel_id_combo_4_RC;
    @FXML
    private TextField student_id_text_4_RC;
    @FXML
    private TextField old_room_no_text_4_RC;
    @FXML
    private TextField new_room_no_text_4_RC;
    @FXML
    private Button change_button_4_RC;
    @FXML
    private Button clear_button_4_RC;
    @FXML
    private TextField room_no_text_5_ERC;
    @FXML
    private TextField room_capacity_text_5_ERC;
    @FXML
    private Button edit_button_5_ERC;
    @FXML
    private Button clear_button_5_ERC;
    @FXML
    private ComboBox<String> hostel_id_combo_6_LH;
    @FXML
    private TextField student_id_text_6_LH;
    @FXML
    private TextField room_no_text_6_LH;
    @FXML
    private ComboBox<Integer> leave_date_year_combo_6_LH;
    @FXML
    private ComboBox<Integer> leave_date_month_combo_6_LH;
    @FXML
    private ComboBox<Integer> leave_date_day_combo_6_LH;
    @FXML
    private Button leave_button_6_LH;
    @FXML
    private Button clear_button_6_LH;
    private Connection conn;
    @FXML
    private TextField hostel_id_text_middle_HT;
    @FXML
    private Button delete_button_middle_HT;
    @FXML
    private ComboBox<String> hostel_id_combo_5_ERC;
    @FXML
    private ComboBox<String> new_hostel_id_combo_4_RC;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"hostel_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create TABLE hostel_info(\n" +
                    "    hid varchar(50) PRIMARY KEY,\n" +
                    "    hname varchar(200) not null,\n" +
                    "    warden_name varchar(100) not null\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"hostel_room_capacity_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table hostel_room_capacity_info (\n" +
                    "    hostel_id varchar(50),\n" +
                    "    room_id varchar(50),\n" +
                    "    room_capacity int not null,\n" +
                    "    bed_available int not null,\n"+
                    "    foreign key(hostel_id) REFERENCES hostel_info(hid) on DELETE CASCADE on UPDATE CASCADE,\n" +
                    "    PRIMARY KEY(hostel_id,room_id)\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"room_assignation_leaving_details",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table room_assignation_leaving_details(\n" +
                "    hostel_id varchar(50),\n" +
                "    r_id varchar(50),\n" +
                "    std_id varchar(50),\n" +
                "    joindate date,\n" +
                "    leavedate date,\n" +
                "    PRIMARY KEY(std_id),\n" +
                "    FOREIGN key(std_id) REFERENCES student_registration_info(student_id) on DELETE cascade on UPDATE CASCADE,\n" +
                "    foreign key(hostel_id,r_id) REFERENCES hostel_room_capacity_info(hostel_id,room_id) on DELETE CASCADE on UPDATE CASCADE\n" +
                "    )");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        tableFillHostelTable();
        join_date_year_combo_3_RA.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        leave_date_year_combo_6_LH.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        join_date_day_combo_3_RA.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        leave_date_day_combo_6_LH.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        join_date_month_combo_3_RA.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        leave_date_month_combo_6_LH.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        FillStudentTableST();
    } 

    //leave hostel event occurs
    
    public void leaveButton6LHButtonClickedListener(ActionEvent ae){
        if(hostel_id_combo_6_LH.getValue().equals("")||student_id_text_6_LH.getText().equals("")||
                room_no_text_6_LH.getText().equals("")||leave_date_year_combo_6_LH.getValue().equals("")||
                leave_date_month_combo_6_LH.getValue().equals("")||leave_date_day_combo_6_LH.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Leave Hostel?","Hostel Leaving Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                String parts[]=hostel_id_combo_6_LH.getValue().split("\\+");
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM `room_assignation_leaving_details` where hostel_id=\""+parts[0]+"\" and r_id=\""+room_no_text_6_LH.getText().toUpperCase()+"\" and std_id=\""+student_id_text_6_LH.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        if(rs.getDate("leavedate")==null){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("update room_assignation_leaving_details set leavedate=\""+String.valueOf(leave_date_year_combo_6_LH.getValue())+"-"+String.valueOf(leave_date_month_combo_6_LH.getValue())+"-"+String.valueOf(leave_date_day_combo_6_LH.getValue())+"\" where "
                                    + "hostel_id=\""+parts[0]+"\" and r_id=\""+room_no_text_6_LH.getText().toUpperCase()+"\" and std_id=\""+student_id_text_6_LH.getText().toUpperCase()+"\"");
                            stt.executeUpdate("UPDATE hostel_room_capacity_info SET bed_available=bed_available+1 where hostel_id=\""+parts[0]+"\" and room_id=\""+room_no_text_6_LH.getText().toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Leave the Hostel!");
                            FillHostelRoomInformationTableHRI(parts[0]);
                            FillStudentTableST();
                        }else{
                            JOptionPane.showMessageDialog(null, "Student already Leave the hostel!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Hostel information and room ID corresponding to student id is invalid!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void clearButton6LHButtonClickedListener(ActionEvent ae){
        student_id_text_6_LH.setText("");
        room_no_text_6_LH.setText("");
    }
    
    
    
    
    
    //edit room capacity event occurs
    public void editButton5ERCButtonClickedListener(ActionEvent ae){
        if(hostel_id_combo_5_ERC.getValue().equals("")||room_no_text_5_ERC.getText().equals("")||
                room_capacity_text_5_ERC.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Edit room Record Capacity?","Room Capacity Edit Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                String parts[]=hostel_id_combo_5_ERC.getValue().split("\\+");
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from hostel_room_capacity_info where hostel_id=\""+parts[0]+"\" and room_id=\""+room_no_text_5_ERC.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        if(checkCapacityNumber(room_capacity_text_5_ERC.getText())){
                            int bedcap=rs.getInt("room_capacity")-rs.getInt("bed_available");
                            if(bedcap<=Integer.parseInt(room_capacity_text_5_ERC.getText())){
                                Statement stt=conn.createStatement();
                                stt.executeUpdate("update hostel_room_capacity_info set room_capacity="+Integer.parseInt(room_capacity_text_5_ERC.getText())+",bed_available="+(Integer.parseInt(room_capacity_text_5_ERC.getText())-bedcap)+" where hostel_id=\""+parts[0]+"\" and room_id=\""+room_no_text_5_ERC.getText().toUpperCase()+"\"");
                                JOptionPane.showMessageDialog(null, "Sucessfully Edited!");
                                FillHostelRoomInformationTableHRI(parts[0]);
                                clearButton5ERCButtonClickedListener(ae);
                            }else{
                                JOptionPane.showMessageDialog(null, "Sorry Can't Edit First empty the room!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Room Capacity Must be in Number!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Hostel ID and corresponding Room ID is invalid!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void clearButton5ERCButtonClickedListener(ActionEvent ae){
       room_no_text_5_ERC.setText("");
       room_capacity_text_5_ERC.setText("");
    }
    
    
    //Edit Room capacity Methods
    private boolean checkCapacityNumber(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    
    
    
    
    
    
    
    //room change event occurs
    @FXML
    public void changeButton4RCButtonClickedListener(ActionEvent ae){
        if(new_hostel_id_combo_4_RC.getValue().equals("")||hostel_id_combo_4_RC.getValue().equals("")||student_id_text_4_RC.getText().equals("")||
                old_room_no_text_4_RC.getText().equals("")||new_room_no_text_4_RC.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Change this room Record?","Room Change Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    String parts[]=hostel_id_combo_4_RC.getValue().split("\\+");
                    String sparts[]=new_hostel_id_combo_4_RC.getValue().split("\\+");
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from room_assignation_leaving_details where hostel_id=\""+parts[0]+"\" and "
                            + "r_id=\""+old_room_no_text_4_RC.getText().toUpperCase()+"\" and std_id=\""+student_id_text_4_RC.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        if(rs.getDate("leavedate")==null){                                                
                                Statement stvx=conn.createStatement();
                                ResultSet rmsx=stvx.executeQuery("select * from hostel_room_capacity_info where hostel_id=\""+sparts[0]+"\" and room_id=\""+new_room_no_text_4_RC.getText().toUpperCase()+"\"");
                                if(rmsx.next()){
                                    if(rmsx.getInt("bed_available")>0){
                                        //true assign
                                        Statement stt=conn.createStatement();
                                        stt.executeUpdate("UPDATE `room_assignation_leaving_details` SET `hostel_id`=\""+sparts[0]+"\",r_id=\""+new_room_no_text_4_RC.getText().toUpperCase()+"\" where hostel_id=\""+parts[0]+"\" and "
                                        +"std_id=\""+student_id_text_4_RC.getText().toUpperCase()+"\" and r_id=\""+old_room_no_text_4_RC.getText().toUpperCase()+"\"");
                                        stt.executeUpdate("UPDATE hostel_room_capacity_info SET bed_available=bed_available-1 where hostel_id=\""+sparts[0]+"\" and room_id=\""+new_room_no_text_4_RC.getText().toUpperCase()+"\"");
                                        stt.executeUpdate("UPDATE hostel_room_capacity_info SET bed_available=bed_available+1 where hostel_id=\""+parts[0]+"\" and room_id=\""+old_room_no_text_4_RC.getText().toUpperCase()+"\"");
                                        JOptionPane.showMessageDialog(null, "Sucessfully Changed!");
                                        FillHostelRoomInformationTableHRI(sparts[0]);
                                        clearButton4RCButtonClickedListner(ae);
                                        FillStudentTableST();
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Bed Full in this room! Try new One to change!");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "New Room ID or Hostel ID is invalid!");
                                }
                        }else{
                            JOptionPane.showMessageDialog(null, "Student Already Leave the hostel");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry Provided Information of hostel, Room and student information may be fault!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButton4RCButtonClickedListner(ActionEvent ae){
        student_id_text_4_RC.setText("");
        old_room_no_text_4_RC.setText("");
        new_room_no_text_4_RC.setText("");
    }
    
    
    
    
    
    
    
    //Student List Table Fill Method
    private ObservableList<AdmissionInformation> getValuesForStudentListTableSL(String roomid){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select std_id from room_assignation_leaving_details where r_id=\""+roomid+"\" and hostel_id=\""+first_part+"\" and leavedate is null");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select applicant_id from student_registration_info where student_id=\""+rs.getString("std_id")+"\"");
                if(rss.next()){
                    Statement stv=conn.createStatement();
                    ResultSet rsv=stv.executeQuery("select full_name from application_form_details where aid=\""+rss.getString("applicant_id")+"\"");
                    if(rsv.next()){
                        list.add(new AdmissionInformation(rs.getString("std_id"),rsv.getString("full_name")));
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private void FillStudentListTableSL(String value){
        student_id_col_middle_SL.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_name_col_middle_SL.setCellValueFactory(new PropertyValueFactory<>("selection_status"));
        student_list_tableview_middle_SL.setItems(getValuesForStudentListTableSL(value));
    }
    
    //Student List Table Events
    @FXML
    public void showListMiddleButtonSLButtonClickedListener(ActionEvent ae){
        if(room_no_text_middle_SL.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Room ID Textfield is empty! ");
        }else{
            try {
                Statement stt=conn.createStatement();
                ResultSet rsv=stt.executeQuery("select * from hostel_room_capacity_info where room_id=\""+room_no_text_middle_SL.getText().toUpperCase()+"\" and hostel_id=\""+first_part+"\"");
                if(rsv.next()){
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select std_id from room_assignation_leaving_details where r_id=\""+room_no_text_middle_SL.getText().toUpperCase()+"\" and hostel_id=\""+first_part+"\"");
                    if(rs.next()){
                        FillStudentListTableSL(room_no_text_middle_SL.getText().toUpperCase());
                    }else{
                        FillStudentListTableSL("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Room ID is invalid with respect to Hostel ID ");
                }
            } catch (SQLException ex) {
                Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void clearButtonMiddleSLButtonClickedListener(ActionEvent ae){
        room_no_text_middle_SL.setText("");
        FillStudentListTableSL("");
    }
    
    
    
    
    //room assination method
    private ObservableList<AdmissionInformation> getValuesForStudentTableST(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select hostel_id,r_id,std_id from room_assignation_leaving_details");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("std_id"),rs.getString("hostel_id"),rs.getString("r_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private void FillStudentTableST(){
        student_id_col_middle_ST.setCellValueFactory(new PropertyValueFactory<>("aid"));
        hostel_id_col_middle_ST.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        room_no_col_middle_ST.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        student_table_tableview_middle_ST.setItems(getValuesForStudentTableST());
        student_table_tableview_middle_ST.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    Statement smt=conn.createStatement();
                    ResultSet rst=smt.executeQuery("select applicant_id from student_registration_info where student_id=\""+student_table_tableview_middle_ST.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");
                    if(rst.next()){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                                rst.getString("applicant_id")+"\"");
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("select * from student_registration_info where student_id=\""+student_table_tableview_middle_ST.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");                    
                        Statement svvt=conn.createStatement();
                        ResultSet rvvs=svvt.executeQuery("select joindate,leavedate from room_assignation_leaving_details where std_id=\""+student_table_tableview_middle_ST.getSelectionModel().getSelectedItem().getAid()+"\"");                       
                        if(rs.next()&&rss.next()&&rvvs.next()){
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
                                + "Enrolment Date : "+rss.getString("enrolment_year")+"\\"+rss.getString("enrolment_month")+"\\"+rss.getString("enrolment_day")+"\n"
                                + "\n\n\nHostel Join Date : "+rvvs.getDate("joindate")+"\n"+
                                                            "Hostel Leave Date : "+rvvs.getDate("leavedate"));
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    private ObservableList<AdmissionInformation> getValuesForStudentTableST(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select hostel_id,r_id,std_id from room_assignation_leaving_details where std_id like \""+value+"%\"");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("std_id"),rs.getString("hostel_id"),rs.getString("r_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //room assination event
    @FXML
    public void searchStudentTableSTKeyPressedEventListener(KeyEvent ke){
        student_id_col_middle_ST.setCellValueFactory(new PropertyValueFactory<>("aid"));
        hostel_id_col_middle_ST.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        room_no_col_middle_ST.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        student_table_tableview_middle_ST.setItems(getValuesForStudentTableST(search_student_id_text_middle_ST.getText().toUpperCase()));
    }
    
    @FXML
    public void assignButton3ButtonClickedListener(ActionEvent ae){
        if(hostel_id_combo_3_RA.getValue().equals("")||student_id_text_3_RA.getText().equals("")||
                room_no_text_3_RA.getText().equals("")||String.valueOf(join_date_year_combo_3_RA.getValue()).equals("")||
                String.valueOf(join_date_month_combo_3_RA.getValue()).equals("")||String.valueOf(join_date_day_combo_3_RA.getValue()).equals("")){
            JOptionPane.showMessageDialog(null, "Either of the form is blank!");
        }else{
            
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Assign this room Record?","Room Record Assign Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    String parts[]=hostel_id_combo_3_RA.getValue().toUpperCase().split("\\+");
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from hostel_room_capacity_info where hostel_id=\""+parts[0]+"\" and room_id=\""+room_no_text_3_RA.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stv=conn.createStatement();
                        ResultSet rsv=stv.executeQuery("select student_id from student_registration_info where student_id=\""+student_id_text_3_RA.getText().toUpperCase()+"\"");
                        if(rsv.next()){
                            if(rs.getInt("bed_available")>0){
                                //true assign
                                Statement stt=conn.createStatement();
                                stt.executeUpdate("INSERT INTO `room_assignation_leaving_details`(`hostel_id`, `r_id`, `std_id`, `joindate`) VALUES (\""
                                +parts[0]+"\",\""+room_no_text_3_RA.getText().toUpperCase()+"\",\""+student_id_text_3_RA.getText().toUpperCase()+"\",\""
                                +join_date_year_combo_3_RA.getValue().toString()+"-"+join_date_month_combo_3_RA.getValue().toString()+"-"+join_date_day_combo_3_RA.getValue()+"\")");
                                stt.executeUpdate("UPDATE hostel_room_capacity_info SET bed_available=bed_available-1 where hostel_id=\""+parts[0]+"\" and room_id=\""+room_no_text_3_RA.getText().toUpperCase()+"\"");
                                JOptionPane.showMessageDialog(null, "Sucessfully Assigned!");
                                FillHostelRoomInformationTableHRI(parts[0]);
                                clearButton3ButtonClickedListener(ae);
                                FillStudentTableST();
                            }else{
                                JOptionPane.showMessageDialog(null, "Bed Full in this room! Try new One!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Student ID is not vaild!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Room ID as Hostel ID");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Student is already in the hostel! Can't assign again!");
                }
            }
        }
    }
    @FXML
    public void clearButton3ButtonClickedListener(ActionEvent ae){
        student_id_text_3_RA.setText("");
        room_no_text_3_RA.setText("");
    }
    
    
    
    
    //extra method for hostel room manager
    
    public boolean checkFirstRoomCapacity(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    private ObservableList<AdmissionInformation> getValuesForHostelRoomInformationTableHRI(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select room_id,room_capacity,bed_available from hostel_room_capacity_info where hostel_id=\""+value+"\"");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("room_id"),rs.getInt("room_capacity"),rs.getInt("bed_available")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void FillHostelRoomInformationTableHRI(String value){
        room_no_col_middle_HRI.setCellValueFactory(new PropertyValueFactory<>("aid"));
        room_capacity_col_middle_HRI.setCellValueFactory(new PropertyValueFactory<>("process_status"));
        room_available_col_middle_HRI.setCellValueFactory(new PropertyValueFactory<>("checker"));
        hostel_room_information_tableview_middle_HRI.setItems(getValuesForHostelRoomInformationTableHRI(value));
        hostel_room_information_tableview_middle_HRI.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                room_no_text_middle_HRI.setText(hostel_room_information_tableview_middle_HRI.getSelectionModel().getSelectedItem().getAid());
                room_no_text_middle_SL.setText(hostel_room_information_tableview_middle_HRI.getSelectionModel().getSelectedItem().getAid());
                room_no_text_3_RA.setText(hostel_room_information_tableview_middle_HRI.getSelectionModel().getSelectedItem().getAid());
                room_no_text_5_ERC.setText(hostel_room_information_tableview_middle_HRI.getSelectionModel().getSelectedItem().getAid());
                room_no_text_6_LH.setText(hostel_room_information_tableview_middle_HRI.getSelectionModel().getSelectedItem().getAid());
            }
            
        });
    }
    
    
    
    
    
    
    
    //event occur in hostel room manager
    
    @FXML
    public void deleteButtonMiddleHRIButtonClickedListener(ActionEvent ae){
        if(room_no_text_middle_HRI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Room No. TextField is empty");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Assign this room Record?","Room Record Assign Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from hostel_room_capacity_info where room_id=\""+room_no_text_middle_HRI.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM hostel_room_capacity_info WHERE room_id=\""+room_no_text_middle_HRI.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        String parts[]=hostel_id_combo_2_HRM.getValue().toUpperCase().split("\\+");
                        FillHostelRoomInformationTableHRI(parts[0]);
                    }else{
                        JOptionPane.showMessageDialog(null, "Room ID is invalid!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButtonMiddleHRIButtonClickedListener(ActionEvent ae){
        room_no_text_middle_HRI.setText("");
    }
    private static String first_part="";
    @FXML
    public void hostelIDClickedEventListenerHRIMiddle(ActionEvent ae){
        String[] part=hostel_id_combo_middle_HRI.getValue().split("\\+");
        FillHostelRoomInformationTableHRI(part[0]);
        first_part=part[0];
    }
    @FXML
    public void assign2HRMButtonClickedListener(ActionEvent ae){
        if(hostel_id_combo_2_HRM.getValue().equals("")||room_number_text_2_HRM.getText().equals("")||
                room_capacity_text_2_HRM.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Assign this room Record?","Room Record Assign Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkFirstRoomCapacity(room_capacity_text_2_HRM.getText())){
                   String parts[]=hostel_id_combo_2_HRM.getValue().toUpperCase().split("\\+");
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from hostel_info where hid=\""+parts[0]+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("INSERT INTO hostel_room_capacity_info(hostel_id, room_id, room_capacity, bed_available) VALUES (\""+parts[0]+"\",\""+room_number_text_2_HRM.getText().toUpperCase()+"\","+Integer.parseInt(room_capacity_text_2_HRM.getText())+","+Integer.parseInt(room_capacity_text_2_HRM.getText())+")");
                            JOptionPane.showMessageDialog(null, "Sucessfully Assigned!");
                            clear2HRMButtonClickedListener(ae);
                            FillHostelRoomInformationTableHRI(parts[0]);
                        }else{
                            JOptionPane.showMessageDialog(null, "Sorry! Hostel ID is invalid. Not found in the database!");
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Room ID already assigned. Try new One!");
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Room Capcity should be in number");
                }
            }
        }
    }
    @FXML
    public void clear2HRMButtonClickedListener(ActionEvent ae){
        room_number_text_2_HRM.setText("");
        room_capacity_text_2_HRM.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //extra method for hostel manager
    private ObservableList<AdmissionInformation> getValuesForHostelTableHT(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        ObservableList<String> listForCombo=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from hostel_info");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("hid"),rs.getString("hname"),rs.getString("warden_name")));
                listForCombo.add(rs.getString("hid")+"+"+rs.getString("hname"));
            }
            hostel_id_combo_3_RA.setItems(listForCombo);
            hostel_id_combo_2_HRM.setItems(listForCombo);
            hostel_id_combo_middle_HRI.setItems(listForCombo);
            hostel_id_combo_4_RC.setItems(listForCombo);
            hostel_id_combo_6_LH.setItems(listForCombo);
            hostel_id_combo_5_ERC.setItems(listForCombo);
            new_hostel_id_combo_4_RC.setItems(listForCombo);
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void tableFillHostelTable(){
        hostel_id_col_middle_HT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        hostel_name_col_middle_HT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        warden_name_col_middle_HT.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        hostel_table_tableview_middle_HT.setItems(getValuesForHostelTableHT());
        hostel_table_tableview_middle_HT.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                hostel_id_combo_3_RA.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_2_HRM.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_middle_HRI.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_4_RC.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_6_LH.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                new_hostel_id_combo_4_RC.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_text_middle_HT.setText(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid());
                first_part=hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid();
            }
            
        });
    }
    private ObservableList<AdmissionInformation> getValuesForHostelTableHT(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from hostel_info where hid like \""+value+"%\"";                       
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("hid"),rs.getString("hname"),rs.getString("warden_name")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    //event occurs in the Hostel Manager 
    @FXML
    public void deleteMiddleHTButtonClickedListener(ActionEvent ae){
        if(hostel_id_text_middle_HT.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Hostel ID text field is blank.");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Hostel Record?","Delete Record Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from hostel_info where hid=\""+hostel_id_text_middle_HT.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM hostel_info WHERE hid=\""+hostel_id_text_middle_HT.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted from the datebase!");
                        hostel_id_text_middle_HT.setText("");
                        tableFillHostelTable();
                    }else{
                        JOptionPane.showMessageDialog(null, "Hostel ID doesn't found in the database. Try Valid one!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void searchHostelIdKeyPressedEventListener(KeyEvent ke){
        hostel_id_col_middle_HT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        hostel_name_col_middle_HT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        warden_name_col_middle_HT.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        hostel_table_tableview_middle_HT.setItems(getValuesForHostelTableHT(hostel_id_text_middle_HT.getText().toUpperCase()));
        hostel_table_tableview_middle_HT.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                hostel_id_combo_3_RA.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_2_HRM.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_middle_HRI.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_4_RC.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_6_LH.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_combo_5_ERC.setValue(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid()+"+"+hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getFullname());
                hostel_id_text_middle_HT.setText(hostel_table_tableview_middle_HT.getSelectionModel().getSelectedItem().getAid());
            }
            
        });
    }
    @FXML
    public void add1HMButtonClickedListener(ActionEvent ae){
        if(hostel_id_text_1_HM.getText().equals("")||hostel_name_text_1_HM.getText().equals("")||
                warden_name_text_1_HM.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Sorry! Fill all the blank to add Hostel Information.");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Hostel Record?","Add Record Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from hostel_info where hid=\""+hostel_id_text_1_HM.getText().toUpperCase()+"\"");
                    if(!rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("INSERT INTO hostel_info(hid, hname, warden_name) VALUES (\""+hostel_id_text_1_HM.getText().toUpperCase()+"\",\""+
                            hostel_name_text_1_HM.getText()+"\",\""+warden_name_text_1_HM.getText()+"\")");
                        JOptionPane.showMessageDialog(null, "Sucessfully Added to the database!");
                        clear1HMButtonClickedListener(ae);
                        tableFillHostelTable();
                    }else{
                        JOptionPane.showMessageDialog(null, "Duplicate Hostel ID do not allowed! Try Unique One.");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @FXML
    public void clear1HMButtonClickedListener(ActionEvent ae){
        hostel_id_text_1_HM.setText("");
        hostel_name_text_1_HM.setText("");
        warden_name_text_1_HM.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    private void AddButtonMap1ButtonClickedListener(ActionEvent event) {
    }
    
    
    
    
    
    
    
    
    
    //changes the color of the all button's 
    @FXML
    public void Add1HMbuttonEntered(MouseEvent me){
        add_button_1_HM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Add1HMbuttonExited(MouseEvent me){
        add_button_1_HM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1HMbuttonEntered(MouseEvent me){
        clear_button_1_HM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1HMbuttonExited(MouseEvent me){
        clear_button_1_HM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Assign2HRMbuttonEntered(MouseEvent me){
        assign_button_2_HRM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Assign2HRMbuttonExited(MouseEvent me){
        assign_button_2_HRM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear2HRMbuttonEntered(MouseEvent me){
        clear_button_2_HRM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear2HRMbuttonExited(MouseEvent me){
        clear_button_2_HRM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Assign3RAbuttonEntered(MouseEvent me){
        assign_button_3_RA.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Assign3RAbuttonExited(MouseEvent me){
        assign_button_3_RA.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear3RAbuttonEntered(MouseEvent me){
        clear_button_3_RA.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear3RAbuttonExited(MouseEvent me){
        clear_button_3_RA.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleHRIbuttonEntered(MouseEvent me){
        delete_button_middle_HRI.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleHRIbuttonExited(MouseEvent me){
        delete_button_middle_HRI.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleHRIbuttonEntered(MouseEvent me){
        clear_button_middle_HRI.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleHRIbuttonExited(MouseEvent me){
        clear_button_middle_HRI.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ShowListMiddleSLbuttonEntered(MouseEvent me){
        show_list_button_middle_SL.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ShowListMiddleSLbuttonExited(MouseEvent me){
        show_list_button_middle_SL.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleSLbuttonEntered(MouseEvent me){
        clear_button_middle_SL.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleSLbuttonExited(MouseEvent me){
        clear_button_middle_SL.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Change4RCbuttonEntered(MouseEvent me){
        change_button_4_RC.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Change4RCbuttonExited(MouseEvent me){
        change_button_4_RC.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear4RCbuttonEntered(MouseEvent me){
        clear_button_4_RC.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear4RCbuttonExited(MouseEvent me){
        clear_button_4_RC.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit5ERCbuttonEntered(MouseEvent me){
        edit_button_5_ERC.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit5ERCbuttonExited(MouseEvent me){
        edit_button_5_ERC.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear5ERCbuttonEntered(MouseEvent me){
        clear_button_5_ERC.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear5ERCbuttonExited(MouseEvent me){
        clear_button_5_ERC.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Leave6LHbuttonEntered(MouseEvent me){
        leave_button_6_LH.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Leave6LHbuttonExited(MouseEvent me){
        leave_button_6_LH.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear6LHbuttonEntered(MouseEvent me){
        clear_button_6_LH.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear6LHbuttonExited(MouseEvent me){
        clear_button_6_LH.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleHTbuttonEntered(MouseEvent me){
        delete_button_middle_HT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleHTbuttonExited(MouseEvent me){
        delete_button_middle_HT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }

  
}

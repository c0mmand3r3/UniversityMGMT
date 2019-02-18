/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class AdmissionManagementController implements Initializable {

    private Connection conn;
    @FXML
    private Button enquiry_form_button;
    @FXML
    private Button application_process_button;
    @FXML
    private Button student_registration_button;
    @FXML
    private AnchorPane enquiry_form_anchorpane_middle;
    @FXML
    private TableView<EnquiryInformation> enquiry_table_first;
    @FXML
    private TableColumn<EnquiryInformation, String> enquiry_id_col_first;
    @FXML
    private TableColumn<EnquiryInformation, String> full_name_col_first;
    @FXML
    private TableColumn<EnquiryInformation, String> email_col_first;
    @FXML
    private TableColumn<EnquiryInformation, String> contact_col_first;
    @FXML
    private TableColumn<EnquiryInformation, String> address_col_first;
    @FXML
    private TableView<EnquiryInformation> enquiry_table_second;
    @FXML
    private TableColumn<EnquiryInformation, String> enquiry_id_col_second;
    @FXML
    private TableColumn<EnquiryInformation, String> nationality_col_second;
    @FXML
    private TableColumn<EnquiryInformation, String> type_of_degree_col_second;
    @FXML
    private TableColumn<EnquiryInformation, String> intrested_in_col_second;
    @FXML
    private TableColumn<EnquiryInformation, String> status_col_second;
    @FXML
    private TextField search_enquiry_id_text_1;
    @FXML
    private Button edit_button_1;
    @FXML
    private Button delete_button_1;
    @FXML
    private Button clear_button_1;
    @FXML
    private AnchorPane enquiry_form_anchorpane_right;
    @FXML
    private TextField enquiry_id_text_1;
    @FXML
    private TextField full_name_text_1;
    @FXML
    private TextField email_text_1;
    @FXML
    private TextField contact_no_text_1;
    @FXML
    private TextArea full_address_textArea_1;
    @FXML
    private ComboBox<String> nationality_combo_1;
    @FXML
    private ComboBox<String> degree_combo_1;
    @FXML
    private TextArea intrested_in_textArea_1;
    @FXML
    private RadioButton choice_student_1;
    @FXML
    private RadioButton choice_none_1;
    @FXML
    private Button add_button_1;
    @FXML
    private Button clear_button_form_1;
    @FXML
    private Pane refresh_pane;
    @FXML
    private ImageView add_record_image_symbol;
    @FXML
    private AnchorPane leftAnchorPaneChooser;
    @FXML
    private AnchorPane application_process_anchorpane_middle;
    @FXML
    private TableView<AdmissionInformation> application_process_tableview_2;
    @FXML
    private TableColumn<AdmissionInformation, String> applicant_id_col_2;
    @FXML
    private TableColumn<AdmissionInformation, String> name_col_2;
    @FXML
    private TableColumn<AdmissionInformation, String> admission_type_col_2;
    @FXML
    private TableColumn<AdmissionInformation, String> selected_program_col_2;
    @FXML
    private TableColumn<AdmissionInformation, String> marks_details_col_2;
    @FXML
    private TableView<AdmissionInformation> processed_application_tableview;
    @FXML
    private TableColumn<AdmissionInformation, String> application_id_col_2_processed;
    @FXML
    private TableColumn<AdmissionInformation, String> selection_status_col_2_processed;
    @FXML
    private TextField search_application_id_text_2;
    @FXML
    private Button select_button_2;
    @FXML
    private Button reject_button_2;
    @FXML
    private Button edit_button_2;
    @FXML
    private Button delete_button_2;
    @FXML
    private Button show_full_application_button_2;
    @FXML
    private Button search_clear_button_2;
    @FXML
    private AnchorPane application_process_anchorpane_right;
    @FXML
    private TextField application_id_text_2;
    @FXML
    private Button add_button_2;
    @FXML
    private Button clear_button_2;
    @FXML
    private TextField full_name_text_2;
    @FXML
    private TextArea full_address_textarea_2;
    @FXML
    private ComboBox<String> nationality_combo_2;
    @FXML
    private TextField email_text_2;
    @FXML
    private TextField contact_no_text_2;
    @FXML
    private ComboBox<String> addmission_type_combo_2;
    @FXML
    private ComboBox<String> selected_program_combo_2;
    @FXML
    private TextArea marks_details_textarea_2;
    @FXML
    private Pane refresh_pane2;
    @FXML
    private ImageView add_record_image_symbol1;
    @FXML
    private TextField search_application_id_text_2_processed;
    @FXML
    private Button delete_button_2_processed;
    @FXML
    private Button search_clear_button_2_processed;
    @FXML
    private AnchorPane student_registration_anchorpane_middle;
    @FXML
    private AnchorPane student_registration_anchorpane_right;
    @FXML
    private TableView<RegisteredStudentInformation> register_student_tableview_3;
    @FXML
    private TableColumn<RegisteredStudentInformation, String> student_id_col_3;
    @FXML
    private TableColumn<RegisteredStudentInformation, String> student_name_3_col;
    @FXML
    private TableColumn<RegisteredStudentInformation, String> address_col_3;
    @FXML
    private TableColumn<RegisteredStudentInformation, String> contact_no_col_3;
    @FXML
    private TableColumn<RegisteredStudentInformation, String> email_col_3;
    @FXML
    private TableView<AdmissionInformation> acceptance_admission_tableview_3;
    @FXML
    private TableColumn<AdmissionInformation, String> applicant_id_col_3;
    @FXML
    private TableColumn<AdmissionInformation, String> full_name_col_3;
    @FXML
    private TableColumn<AdmissionInformation, String> admission_type_col_3;
    @FXML
    private TableColumn<AdmissionInformation, String> selected_program_col_3;
    @FXML
    private TextField student_id_text_3_search_reg;
    @FXML
    private Button delete_button_3;
    @FXML
    private Button clear_button_3_search_reg;
    @FXML
    private ComboBox<Integer> DOB_year_combo_3;
    @FXML
    private ComboBox<Integer> DOB_month_combo_3;
    @FXML
    private ComboBox<Integer> DOB_day_combo_3;
    @FXML
    private RadioButton gender_male_radio_3;
    @FXML
    private RadioButton gender_female_radio_3;
    @FXML
    private TextField guardian_name_text_3;
    @FXML
    private RadioButton gender_other_radio_3;
    @FXML
    private TextField contact_no_text_3;
    @FXML
    private TextField bank_ac_text_3;
    @FXML
    private TextField bank_name_text_3;
    @FXML
    private TextField pan_no_text_3;
    @FXML
    private ComboBox<Integer> enrolment_year_combo_3;
    @FXML
    private ComboBox<Integer> enrolment_month_combo_3;
    @FXML
    private ComboBox<Integer> enrolment_day_combo_3;
    @FXML
    private TextField applicant_id_text_3;
    @FXML
    private Button register_button_3;
    @FXML
    private Button clear_button_3;
    @FXML
    private TextField student_id_text_3;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOani
        conn=DBMSConnector_login.connect_Database();
        
        enquiry_form_anchorpane_middle.setVisible(true);
        enquiry_form_anchorpane_right.setVisible(true);
        application_process_anchorpane_middle.setVisible(false);
        application_process_anchorpane_right.setVisible(false);
        student_registration_anchorpane_middle.setVisible(false);
        student_registration_anchorpane_right.setVisible(false);
        
        nationality_combo_1.setItems(FXCollections.observableArrayList("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan",
            "Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivi","Bosnia Herzegovina","Botswana",
            "Brazil","Brunei","Bulgaria","Burkina","Burundi",
            "Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia",
            "Comoros","Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti",
            "Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea",
            "Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece",
            "Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India",
            "Indonesia","Iran","Iraq","Ireland {Republic}","Israel","Italy","Ivory Coast","Jamaica","Japan",
            "Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait",
            "Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania",
            "Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands",
            "Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro",
            "Morocc","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua",
            "Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru",
            "Philippines","Poland","Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia",
            "Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal",
            "Serbia","Seychelles","Sierra Leon","Singapore","Slovakia","Slovenia","Solomon Islands",
            "Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland",
            "Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago",
            "Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom",
            "United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen",
            "Zambia","Zimbabwe"));
      
        nationality_combo_2.setItems(FXCollections.observableArrayList("Afghanistan","Albania","Algeria","Andorra","Angola","Antigua & Deps","Argentina","Armenia","Australia","Austria","Azerbaijan",
            "Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bhutan","Bolivi","Bosnia Herzegovina","Botswana",
            "Brazil","Brunei","Bulgaria","Burkina","Burundi",
            "Cambodia","Cameroon","Canada","Cape Verde","Central African Rep","Chad","Chile","China","Colombia",
            "Comoros","Congo","Congo {Democratic Rep}","Costa Rica","Croatia","Cuba","Cyprus","Czech Republic","Denmark","Djibouti",
            "Dominica","Dominican Republic","East Timor","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea",
            "Estonia","Ethiopia","Fiji","Finland","France","Gabon","Gambia","Georgia","Germany","Ghana","Greece",
            "Grenada","Guatemala","Guinea","Guinea-Bissau","Guyana","Haiti","Honduras","Hungary","Iceland","India",
            "Indonesia","Iran","Iraq","Ireland {Republic}","Israel","Italy","Ivory Coast","Jamaica","Japan",
            "Jordan","Kazakhstan","Kenya","Kiribati","Korea North","Korea South","Kosovo","Kuwait",
            "Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania",
            "Luxembourg","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands",
            "Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro",
            "Morocc","Mozambique","Myanmar, {Burma}","Namibia","Nauru","Nepal","Netherlands","New Zealand","Nicaragua",
            "Niger","Nigeria","Norway","Oman","Pakistan","Palau","Panama","Papua New Guinea","Paraguay","Peru",
            "Philippines","Poland","Portugal","Qatar","Romania","Russian Federation","Rwanda","St Kitts & Nevis","St Lucia",
            "Saint Vincent & the Grenadines","Samoa","San Marino","Sao Tome & Principe","Saudi Arabia","Senegal",
            "Serbia","Seychelles","Sierra Leon","Singapore","Slovakia","Slovenia","Solomon Islands",
            "Somalia","South Africa","South Sudan","Spain","Sri Lanka","Sudan","Suriname","Swaziland",
            "Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Togo","Tonga","Trinidad & Tobago",
            "Tunisia","Turkey","Turkmenistan","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom",
            "United States","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Yemen",
            "Zambia","Zimbabwe"));
        
        addmission_type_combo_2.setItems(FXCollections.observableArrayList("Adult Undergraduate Admission",
                                                "Continuing Education Admission",
                                                "Freshman Admission",
                                                "Graduate Admission",
                                                "International Admission",
                                                "Non-Degree Admission",
                                                "Returning Admission",
                                                "Transfer Admission",
                                                "Undergraduate Admission",
                                                "Visiting Undergraduate Admission",
                                                "Other"
                                            ));
        ToggleGroup tg=new ToggleGroup();
        choice_student_1.setToggleGroup(tg);
        choice_none_1.setToggleGroup(tg);
        choice_student_1.setSelected(true);
        nationality_combo_1.setValue("");
        degree_combo_1.setValue("");
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"enquiry_info_details",null);
            if(rs.next()){
            
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table enquiry_info_details(\n" +
                    "    enquiry_id varchar(100) primary key,\n" +
                    "    full_name varchar(200) not null,\n" +
                    "    email varchar(100) not null,\n" +
                    "    contact varchar(30) not null,\n" +
                    "    full_address varchar(200) not null,\n" +
                    "    status varchar(25) not null,\n" +
                    "    nationality varchar(40) not null,\n" +
                    "    type_of_degree varchar(100) not null,\n" +
                    "    intrested_in varchar(1000) not null\n" +
                    "    )");
                System.out.println("table Created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"student_registration_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table student_registration_info(\n" +
                        "	applicant_id varchar(50) not null,\n" +
                        "	student_id varchar(50) not null,\n" +
                        "	dob_year int not null,\n" +
                        "	dob_month int not null,\n" +
                        "	dob_day int not null,\n" +
                        "	gender varchar(30) not null,\n" +
                        "	guardian_name varchar(100) not null,\n" +
                        "	guardian_contact varchar(30) not null,\n" +
                        "	bank_name varchar(100),\n" +
                        "	bank_ac varchar(100),\n" +
                        "	PAN_no varchar(100),\n" +
                        "	enrolment_year int not null,\n" +
                        "	enrolment_month int not null,\n" +
                        "	enrolment_day int not null,\n" +
                        "       process_status int not null,\n" +
                        "       leave_date date,\n" +
                        "	primary key(student_id),\n" +
                        "	foreign key(applicant_id) references application_form_details(aid) on delete cascade on update cascade\n" +
                        "	);");
                System.out.println("table created");
            }
        }catch(SQLException ex){
            Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select title from program_info");
            ObservableList<String> list=FXCollections.observableArrayList();
            while(rs.next()){
                list.add(rs.getString("title"));
            }
            degree_combo_1.setItems(list);
            selected_program_combo_2.setItems(list);
        }catch(SQLException ex){
            Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);

        }
        tableFill();
        
        try{
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"application_form_details",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table application_form_details(\n" +
                    "	aid varchar(50) primary key,\n" +
                    "	full_name varchar(100) not null,\n" +
                    "	full_address varchar(200) not null,\n" +
                    "	nationality varchar(40) not null,\n" +
                    "	email varchar(100) not null,\n" +
                    "	contact_no varchar(50) not null,\n" +
                    "	admission_type varchar(100) not null,\n" +
                    "	selected_program varchar(100) not null,\n" +
                    "	marks_details varchar(1000) not null,\n" +
                    "	process_status int not null,\n" +
                    "	selection_status varchar(30),\n" +
                    "   accepted_status int not null"+
                    "	);");
                System.out.println("table created");
            }
        }catch(SQLException ex){
            Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ToggleGroup tm=new ToggleGroup();
        gender_male_radio_3.setToggleGroup(tm);
        gender_female_radio_3.setToggleGroup(tm);
        gender_other_radio_3.setToggleGroup(tm);
        gender_male_radio_3.setSelected(true);
        
        DOB_year_combo_3.setItems(FXCollections.observableArrayList(1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000
                ,2000,2001, 2002 ,2003, 2004 ,2005 ,2006, 2007, 2008, 2009,
                2010 ,2011, 2012 ,2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        enrolment_year_combo_3.setItems(FXCollections.observableArrayList(1980,1981,1982,1983,1984,1985,1986,1987,1988,1989,1990,1991,1992,1993,1994,1995,1996,1997,1998,1999,2000
                ,2000,2001, 2002 ,2003, 2004 ,2005 ,2006, 2007, 2008, 2009,
                2010 ,2011, 2012 ,2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        DOB_day_combo_3.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        enrolment_day_combo_3.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        DOB_month_combo_3.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        enrolment_month_combo_3.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
    }     
    
    //mainChooser ButtonClickedListener of enquiry, Application and Student Registration
    @FXML
    public void MainChooserOfEnquiryApplicationStudentReg(ActionEvent me){
        if(me.getTarget()==enquiry_form_button){
            enquiry_form_anchorpane_middle.setVisible(true);
            enquiry_form_anchorpane_right.setVisible(true);
            application_process_anchorpane_middle.setVisible(false);
            application_process_anchorpane_right.setVisible(false);
            student_registration_anchorpane_middle.setVisible(false);
            student_registration_anchorpane_right.setVisible(false);
        }
        if(me.getTarget()==application_process_button){
            enquiry_form_anchorpane_middle.setVisible(false);
            enquiry_form_anchorpane_right.setVisible(false);
            application_process_anchorpane_middle.setVisible(true);
            application_process_anchorpane_right.setVisible(true);
            student_registration_anchorpane_middle.setVisible(false);
            student_registration_anchorpane_right.setVisible(false);
            setApplicationToBeProcessedTableFill();
            ApplicationProcessedAlready();
            
            
        }
        if(me.getTarget()==student_registration_button){
            enquiry_form_anchorpane_middle.setVisible(false);
            enquiry_form_anchorpane_right.setVisible(false);
            application_process_anchorpane_middle.setVisible(false);
            application_process_anchorpane_right.setVisible(false);
            student_registration_anchorpane_middle.setVisible(true);
            student_registration_anchorpane_right.setVisible(true);
            fillAcceptanceTable();
            fillAcceptanceTableOfRegisteredStudent();
        }
    }
    
    
    //other related method for Student Registration
    
    
    
    private ObservableList<RegisteredStudentInformation> getAllValuesForRegisteredStudent(){
        ObservableList<RegisteredStudentInformation> list=FXCollections.observableArrayList();
        try {
                String query="select aid,full_name,full_address,contact_no,email from application_form_details where selection_status=\"Accept\" and accepted_status=1";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                   Statement stt=conn.createStatement();
                   ResultSet rss=stt.executeQuery("select student_id from student_registration_info where applicant_id=\""+rs.getString("aid")+"\"");
                   if(rss.next()){
                       list.add(new RegisteredStudentInformation(rs.getString("aid"),rss.getString("student_id"),rs.getString("full_name"),rs.getString("full_address"),rs.getString("contact_no"),rs.getString("email")));
                   }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private void fillAcceptanceTableOfRegisteredStudent(){
        student_id_col_3.setCellValueFactory(new PropertyValueFactory<>("sid"));
        student_name_3_col.setCellValueFactory(new PropertyValueFactory<>("sname"));
        address_col_3.setCellValueFactory(new PropertyValueFactory<>("saddress"));
        contact_no_col_3.setCellValueFactory(new PropertyValueFactory<>("contact"));
        email_col_3.setCellValueFactory(new PropertyValueFactory<>("email"));
        register_student_tableview_3.setItems(getAllValuesForRegisteredStudent());
        register_student_tableview_3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try{
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                            register_student_tableview_3.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");
                    Statement stt=conn.createStatement();
                    ResultSet rss=stt.executeQuery("select * from student_registration_info where student_id=\""+register_student_tableview_3.getSelectionModel().getSelectedItem().getSid().toString().toUpperCase()+"\"");                    
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
                    }
                }catch(SQLException ex){
                    
                }
            }
            
        });
    }
    private void fillAcceptanceTable(){
        applicant_id_col_3.setCellValueFactory(new PropertyValueFactory<>("aid"));
        full_name_col_3.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        admission_type_col_3.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        selected_program_col_3.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        acceptance_admission_tableview_3.setItems(getAllValuesForProcessedAcceptanceAdmission());
        acceptance_admission_tableview_3.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try{
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                            acceptance_admission_tableview_3.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                            + "Application ID : "+rs.getString("aid")+"\n"
                            + "Full Name : "+rs.getString("full_name")+"\n"
                            + "Full Address : "+rs.getString("full_address")+"\n"
                            + "Nationality : "+rs.getString("nationality")+"\n"
                            + "Email : "+rs.getString("email")+"\n"
                            + "Contact No. : "+rs.getString("contact_no")+"\n"
                            + "Admission Type : "+rs.getString("admission_type")+"\n"
                            + "Selected Program : "+rs.getString("selected_program")+"\n"
                            + "Marks Details : "+rs.getString("marks_details")+"\n"
                            + "Selection Status : "+rs.getString("selection_status"));
                        applicant_id_text_3.setText(acceptance_admission_tableview_3.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase());
                    }
                }catch(SQLException ex){
                    
                }
            }
            
        });
    }
    
    private ObservableList<AdmissionInformation> getAllValuesForProcessedAcceptanceAdmission(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select aid,full_name,admission_type,selected_program from application_form_details where selection_status=\"Accept\" and accepted_status=0";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("aid"),rs.getString("full_name"),rs.getString("admission_type")
                            ,rs.getString("selected_program")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    
    
    private boolean checkAllTextfieldApplicationStudentREG(){
        Pattern pat=Pattern.compile("^[A-Za-z][A-Za-z\\ ]{0,}");
        Matcher mat=pat.matcher(bank_name_text_3.getText().toString());
        boolean name_match=false;
        if(mat.matches()){
            name_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Bank Name Format is Invalid!");
            return false;
        }
        pat=Pattern.compile("^[A-Za-z][A-Za-z\\ ]{0,}");
        mat=pat.matcher(guardian_name_text_3.getText().toString());
        boolean email_match=false;
        if(mat.matches()){
            email_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Guardian Name Format is Invalid!");
            return false;
        }
        pat=Pattern.compile("^[0-9][0-9]{5,}");
        mat=pat.matcher(contact_no_text_3.getText().toString());
        boolean contact_match=false;
        if(mat.matches()){
            contact_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Contact No. should have :-\n * Must Contain more than 5 Digits.\n * Must Contain Numeric Digits only.");
            return false;
        }
        return email_match&&contact_match&&name_match;
    }
    private ObservableList<RegisteredStudentInformation> getAllValuesForRegisteredStudent(String value){
        ObservableList<RegisteredStudentInformation> list=FXCollections.observableArrayList();
        try {
                String query="select applicant_id,student_id from student_registration_info where student_id like \""+value+"%\"";                       
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                   Statement stt=conn.createStatement();
                   ResultSet rss=stt.executeQuery("select aid,full_name,full_address,contact_no,email from application_form_details where selection_status=\"Accept\" and accepted_status=1");
                   if(rss.next()){
                       list.add(new RegisteredStudentInformation(rss.getString("aid"),rs.getString("student_id"),rss.getString("full_name"),rss.getString("full_address"),rss.getString("contact_no"),rss.getString("email")));
                   }
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    
    
    
    
    
    
    
    
    //event occurs of the student registration for button clicked
    @FXML
    public void search3KeyPressedEventListener(Event ke){
        student_id_col_3.setCellValueFactory(new PropertyValueFactory<>("sid"));
        student_name_3_col.setCellValueFactory(new PropertyValueFactory<>("sname"));
        address_col_3.setCellValueFactory(new PropertyValueFactory<>("saddress"));
        contact_no_col_3.setCellValueFactory(new PropertyValueFactory<>("contact"));
        email_col_3.setCellValueFactory(new PropertyValueFactory<>("email"));
        register_student_tableview_3.setItems(getAllValuesForRegisteredStudent(student_id_text_3_search_reg.getText().toUpperCase()));
    }
    
    
    @FXML
    public void Register3ButtonClickedListener(ActionEvent ae){
        if(student_id_text_3.getText().equals("")||applicant_id_text_3.getText().equals("")||
                DOB_year_combo_3.getValue()==null||DOB_month_combo_3.getValue()==null||
                DOB_day_combo_3.getValue()==null||guardian_name_text_3.getText().equals("")||
                contact_no_text_3.getText().equals("")||bank_name_text_3.getText().equals("")||
                bank_ac_text_3.getText().equals("")||pan_no_text_3.getText().equals("")||
                enrolment_year_combo_3.getValue()==null||enrolment_month_combo_3.getValue()==null||
                enrolment_day_combo_3.getValue()==null){
                    JOptionPane.showMessageDialog(null,"Either of the Form field is blank!");
                }
        else{
            try {
                if(checkAllTextfieldApplicationStudentREG()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to register this Record?","Registration Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+applicant_id_text_3.getText().toString().toUpperCase()+"\" and selection_status=\"Accept\" and accepted_status=0");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            ResultSet rss=stt.executeQuery("select student_id from student_registration_info where student_id=\""+student_id_text_3.getText().toUpperCase()+"\"");
                            if(!rss.next()){
                                String value="";
                                if(gender_male_radio_3.isSelected()){
                                    value="Male";
                                }else if(gender_female_radio_3.isSelected()){
                                    value="Female";
                                }else{
                                    value="Other";
                                }
                                st.executeUpdate("INSERT INTO `student_registration_info`(`applicant_id`,"+
                                        "`student_id`, `dob_year`, `dob_month`, `dob_day`, `gender`, "+
                                        "`guardian_name`, `guardian_contact`, `bank_name`, `bank_ac`, "+
                                        "`PAN_no`, `enrolment_year`, `enrolment_month`, `enrolment_day`,process_status) "+
                                        "VALUES (\""+applicant_id_text_3.getText().toUpperCase()+"\","+
                                        "\""+student_id_text_3.getText().toUpperCase()+"\","+
                                        "\""+DOB_year_combo_3.getValue()+"\","+
                                        "\""+DOB_month_combo_3.getValue()+"\","+
                                        "\""+DOB_day_combo_3.getValue()+"\","+
                                        "\""+value+"\","+
                                        "\""+guardian_name_text_3.getText()+"\","+
                                        "\""+contact_no_text_3.getText()+"\","+
                                        "\""+bank_name_text_3.getText()+"\","+
                                        "\""+bank_ac_text_3.getText()+"\","+
                                        "\""+pan_no_text_3.getText()+"\","+
                                        "\""+enrolment_year_combo_3.getValue()+"\","+
                                        "\""+enrolment_month_combo_3.getValue()+"\","+
                                        "\""+enrolment_day_combo_3.getValue()+"\",0)");
                                st.executeUpdate("update application_form_details set accepted_status=1 where aid=\""+applicant_id_text_3.getText().toUpperCase()+"\"");
                                JOptionPane.showMessageDialog(null,"Student Registration Form is Sucessfully Registered!");
                                Clear3ButtonClickedListener(ae);
                                fillAcceptanceTableOfRegisteredStudent();
                                fillAcceptanceTable();
                            }else{
                                JOptionPane.showMessageDialog(null, "Student ID should be unique! Try new one!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Application ID is not valid or Application ID already Registered!");
                        }
                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void Clear3ButtonClickedListener(ActionEvent ae){
        student_id_text_3.setText("");
        applicant_id_text_3.setText("");
        DOB_year_combo_3.setValue(null);
        DOB_month_combo_3.setValue(null);
        DOB_day_combo_3.setValue(null);
        gender_male_radio_3.setSelected(true);
        guardian_name_text_3.setText("");
        contact_no_text_3.setText("");
        bank_name_text_3.setText("");
        bank_ac_text_3.setText("");
        pan_no_text_3.setText("");
        enrolment_year_combo_3.setValue(null);
        enrolment_month_combo_3.setValue(null);
        enrolment_day_combo_3.setValue(null);
        fillAcceptanceTableOfRegisteredStudent();
        fillAcceptanceTable();
    }
    @FXML
    public void Clear3SearchButtonClickedListener(ActionEvent ae){
        student_id_text_3_search_reg.setText("");
        fillAcceptanceTableOfRegisteredStudent();
        fillAcceptanceTable();
    }
    @FXML
    public void Delete3ButtonClickedListener(ActionEvent ae){
        if(student_id_text_3_search_reg.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Student ID is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to register this Record?","Registration Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select applicant_id,student_id from student_registration_info where student_id=\""+student_id_text_3_search_reg.getText().toString().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM student_registration_info WHERE student_id=\""+student_id_text_3_search_reg.getText().toString().toUpperCase()+"\"");
                        stt.executeUpdate("update application_form_details set accepted_status=0 where aid=\""+rs.getString("applicant_id").toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted Registered Student!");
                        fillAcceptanceTableOfRegisteredStudent();
                        fillAcceptanceTable();
                        Clear3SearchButtonClickedListener(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Student ID is invalid!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    //student registeration for button color changes
    
    @FXML
     public void Register3buttonEntered(MouseEvent me){
        register_button_3.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Register3buttonExited(MouseEvent me){
        register_button_3.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void clear3buttonEntered(MouseEvent me){
        clear_button_3.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clear3buttonExited(MouseEvent me){
        clear_button_3.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void clear3SearchbuttonEntered(MouseEvent me){
        clear_button_3_search_reg.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clear3SearchbuttonExited(MouseEvent me){
        clear_button_3_search_reg.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void Delete3buttonEntered(MouseEvent me){
        delete_button_3.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Delete3buttonExited(MouseEvent me){
        delete_button_3.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    
    //other function needed in the Application Process
    private boolean checkAllTextfieldApplication(){
        Pattern pat=Pattern.compile("^[A-Za-z][A-Za-z\\ ]{0,}");
        Matcher mat=pat.matcher(full_name_text_2.getText().toString());
        boolean name_match=false;
        if(mat.matches()){
            name_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Name Format is Invalid!");
            return false;
        }
        pat=Pattern.compile("^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$");
        mat=pat.matcher(email_text_2.getText().toString());
        boolean email_match=false;
        if(mat.matches()){
            email_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Email Format is Invalid!");
            return false;
        }
        pat=Pattern.compile("^[0-9][0-9]{5,}");
        mat=pat.matcher(contact_no_text_2.getText().toString());
        boolean contact_match=false;
        if(mat.matches()){
            contact_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Contact No. should have :-\n * Must Contain more than 5 Digits.\n * Must Contain Numeric Digits only.");
            return false;
        }
        return email_match&&contact_match&&name_match;
    }
    private ObservableList<AdmissionInformation> getAllValuesApplicationProcess(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select aid,full_name,admission_type,selected_program,marks_details from application_form_details where process_status=0";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("aid"),rs.getString("full_name"),rs.getString("admission_type")
                                ,rs.getString("selected_program"),rs.getString("marks_details")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private void setApplicationToBeProcessedTableFill(){
        applicant_id_col_2.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_col_2.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        admission_type_col_2.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        selected_program_col_2.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        marks_details_col_2.setCellValueFactory(new PropertyValueFactory<>("marks_details"));
        application_process_tableview_2.setItems(getAllValuesApplicationProcess());
        application_process_tableview_2.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try{
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                            application_process_tableview_2.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                            + "Application ID : "+rs.getString("aid")+"\n"
                            + "Full Name : "+rs.getString("full_name")+"\n"
                            + "Full Address : "+rs.getString("full_address")+"\n"
                            + "Nationality : "+rs.getString("nationality")+"\n"
                            + "Email : "+rs.getString("email")+"\n"
                            + "Contact No. : "+rs.getString("contact_no")+"\n"
                            + "Admission Type : "+rs.getString("admission_type")+"\n"
                            + "Selected Program : "+rs.getString("selected_program")+"\n"
                            + "Marks Details : "+rs.getString("marks_details")+"\n"
                            + "Selection Status : "+rs.getString("selection_status"));
                    }
                }catch(SQLException ex){
                    
                }
            }
            
        });
    }
    private ObservableList<AdmissionInformation> getAllValuesForSearch2(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select aid,full_name,admission_type,selected_program,marks_details from application_form_details where aid like \""+value+"%\" and process_status=0";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("aid"),rs.getString("full_name"),rs.getString("admission_type")
                                ,rs.getString("selected_program"),rs.getString("marks_details")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private ObservableList<AdmissionInformation> getAllValuesApplicationProcessedAlready(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select aid,selection_status from application_form_details where process_status=1";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("aid"),rs.getString("selection_status")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private void ApplicationProcessedAlready(){
        application_id_col_2_processed.setCellValueFactory(new PropertyValueFactory<>("aid"));
        selection_status_col_2_processed.setCellValueFactory(new PropertyValueFactory<>("selection_status"));
        
        processed_application_tableview.setItems(getAllValuesApplicationProcessedAlready());
        processed_application_tableview.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                            processed_application_tableview.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase()+"\"");
                    System.out.println(processed_application_tableview.getSelectionModel().getSelectedItem().getAid().toString().toUpperCase());
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                            + "Application ID : "+rs.getString("aid")+"\n"
                            + "Full Name : "+rs.getString("full_name")+"\n"
                            + "Full Address : "+rs.getString("full_address")+"\n"
                            + "Nationality : "+rs.getString("nationality")+"\n"
                            + "Email : "+rs.getString("email")+"\n"
                            + "Contact No. : "+rs.getString("contact_no")+"\n"
                            + "Admission Type : "+rs.getString("admission_type")+"\n"
                            + "Selected Program : "+rs.getString("selected_program")+"\n"
                            + "Marks Details : "+rs.getString("marks_details")+"\n"
                            + "Selection Status : "+rs.getString("selection_status"));
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
    }
    private ObservableList<AdmissionInformation> getAllValuesForSearch2ProcessedApplication(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select aid,selection_status from application_form_details where aid like \""+value+"%\" and process_status=1";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("aid"),rs.getString("selection_status")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    
    
    
    
    
    
    
    //event occurs of the Application Process Anchopane only
    @FXML
    public void refresh2ButtonClickedListener(MouseEvent me){
        ApplicationProcessedAlready();
        setApplicationToBeProcessedTableFill();
    }
    @FXML
    public void Edit2ButtonClickedListener(ActionEvent ae) throws IOException{
        if(search_application_id_text_2.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+"\" and process_status=0");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to update this Record?","Update Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        setProgramIddd(search_application_id_text_2.getText().toString());
                        Parent root = (Parent) FXMLLoader.load(getClass().getResource("EditApplicationProcessAdmission.fxml"));
                        Scene scene = new Scene(root);
                        Window existingWindow = ((Node) ae.getSource()).getScene().getWindow();

                        // create a new stage:
                        Stage stage = new Stage();
                        // make it modal:
                        stage.initModality(Modality.APPLICATION_MODAL);
                        // make its owner the existing window:
                        stage.initOwner(existingWindow);
                        stage.setTitle("Update Admission Form");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.sizeToScene();
                        stage.show();
                        search_application_id_text_2.setText("");
                        System.out.println("returned");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Either Applicant ID does not exits or Applicant ID already Processed! Try exist Enquiry ID");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProgramManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void showFullApplicationRecordButtonClickedListener(ActionEvent ae) throws IOException{
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("ShowFullAdmissionDetails.fxml"));
        Scene scene = new Scene(root);
        Window existingWindow = ((Node) ae.getSource()).getScene().getWindow();

        // create a new stage:
        Stage stage = new Stage();
        // make it modal:
        stage.initModality(Modality.APPLICATION_MODAL);
        // make its owner the existing window:
        stage.initOwner(existingWindow);
        stage.setTitle("Show Full Admission Details ");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }
    @FXML
    public void accept2ButtonClickedListener(ActionEvent ae){
        if(search_application_id_text_2.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try{
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+"\" and process_status=0");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Accept this Student?","Acception Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("update application_form_details set process_status=1, selection_status=\"Accept\" where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+ "\"");
                        JOptionPane.showMessageDialog(null, "Application is accepted for further Process!");
                        ApplicationProcessedAlready();
                        setApplicationToBeProcessedTableFill();
                        search_application_id_text_2.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Either Application ID does not exits or Applicatin ID already processed! Try exist Application ID.");
                }
            }catch(SQLException ex){
                
            }
        }
    }
    @FXML
    public void reject2ButtonClickedListener(ActionEvent ae){
        if(search_application_id_text_2.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try{
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+"\" and process_status=0");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Reject this Student?","Rejection Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("update application_form_details set process_status=1, selection_status=\"Reject\" where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+ "\"");
                        JOptionPane.showMessageDialog(null, "Sorry, Application is rejected for further Process!");
                        ApplicationProcessedAlready();
                        setApplicationToBeProcessedTableFill();
                        search_application_id_text_2.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Either Application ID does not exits or Applicatin ID already processed! Try exist Application ID.");
                }
            }catch(SQLException ex){
                
            }
        }
    }
    @FXML
    public void delete2ButtonClickedListener(ActionEvent ae){
        if(search_application_id_text_2.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+"\"and process_status=0");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Record?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("delete from application_form_details where aid=\""+search_application_id_text_2.getText().toString().toUpperCase()+"\" and process_status=0");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        search_application_id_text_2.setText("");
                        setApplicationToBeProcessedTableFill();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Either, Application ID does not exits or application ID is already Processed ! Try exist Application ID");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Application ID does not exits! Try exist Application ID");
            }
        }
    }
    @FXML
    public void delete2ProcessedButtonClickedListener(ActionEvent ae){
        if(search_application_id_text_2_processed.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+search_application_id_text_2_processed.getText().toString().toUpperCase()+"\" and process_status=1");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Record?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("delete from application_form_details where aid=\""+search_application_id_text_2_processed.getText().toString().toUpperCase()+"\" and process_status=1");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        search_application_id_text_2_processed.setText("");
                        ApplicationProcessedAlready();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Either, Application ID does not exits or Application ID does not Processed yet! Try exist Application ID");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Application ID does not exits! Try exist Application ID");
            }
        }
    }
    @FXML
    public void searchClear2ButtonClickedListener(ActionEvent ae){
        search_application_id_text_2.setText("");
        setApplicationToBeProcessedTableFill();
    }
    @FXML
    public void searchClear2ProcessedButtonClickedListener(ActionEvent ae){
        search_application_id_text_2_processed.setText("");
        ApplicationProcessedAlready();
    }
    @FXML
    public void Add2ButtonClickedListener(ActionEvent ae){
        if(application_id_text_2.getText().toString().equals("")||full_name_text_2.getText().toString().equals("")
                ||full_address_textarea_2.getText().toString().equals("")||email_text_2.getText().toString().equals("")
                ||contact_no_text_2.getText().toString().equals("")||marks_details_textarea_2.getText().toString().equals("")
                ||nationality_combo_2.getValue().toString().equals("")||addmission_type_combo_2.getValue().toString().equals("")
                ||selected_program_combo_2.getValue().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Application Form is not Completely Filled! Fill all the Blanks");
        }else{
            try {
                if(checkAllTextfieldApplication()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+application_id_text_2.getText().toString().toUpperCase()+"\"");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Application ID alredy existed! Try New One");
                        }else{
                            st.executeUpdate("insert into application_form_details("+
                                    " aid,full_name,full_address,nationality,email,contact_no,admission_type,"+
                                    " selected_program,marks_details,process_status,accepted_status)"+
                                    "values ("+
                                    "\""+application_id_text_2.getText().toString().toUpperCase()+"\","+
                                    "\""+full_name_text_2.getText().toString()+"\","+
                                    "\""+full_address_textarea_2.getText().toString()+"\","+
                                    "\""+nationality_combo_2.getValue().toString()+"\","+
                                    "\""+email_text_2.getText().toString()+"\","+
                                    "\""+contact_no_text_2.getText().toString()+"\","+
                                    "\""+addmission_type_combo_2.getValue().toString()+"\","+
                                    "\""+selected_program_combo_2.getValue().toString()+"\","+
                                    "\""+marks_details_textarea_2.getText().toString()+"\","+
                                    "0,0)");
                            JOptionPane.showMessageDialog(null,"Application Form is Sucessfully Inserted!");
                            clear2ButtonClickedListener(ae);
                            setApplicationToBeProcessedTableFill();
                        }
                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void clear2ButtonClickedListener(ActionEvent ae){
        application_id_text_2.setText("");
        full_name_text_2.setText("");
        full_address_textarea_2.setText("");
        email_text_2.setText("");
        contact_no_text_2.setText("");
        marks_details_textarea_2.setText("");
        nationality_combo_2.setValue("");
        addmission_type_combo_2.setValue("");
        selected_program_combo_2.setValue("");
    }
    @FXML
    public void search2KeyPressedEventListener(Event ke){
        applicant_id_col_2.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_col_2.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        admission_type_col_2.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        selected_program_col_2.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        marks_details_col_2.setCellValueFactory(new PropertyValueFactory<>("marks_details"));
        application_process_tableview_2.setItems(getAllValuesForSearch2(search_application_id_text_2.getText().toString().toUpperCase()));
    }
    @FXML
    public void search2KeyPressedOfProcessedApplicationEventListener(Event ke){
        application_id_col_2_processed.setCellValueFactory(new PropertyValueFactory<>("aid"));
        selection_status_col_2_processed.setCellValueFactory(new PropertyValueFactory<>("selection_status"));
        
        processed_application_tableview.setItems(getAllValuesForSearch2ProcessedApplication(search_application_id_text_2_processed.getText().toString().toUpperCase()));
    }
    //color change of the button and other pane of application process
    @FXML
    public void Edit2buttonEntered(MouseEvent me){
        edit_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit2buttonExited(MouseEvent me){
        edit_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Delete2buttonEntered(MouseEvent me){
        delete_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Delete2buttonExited(MouseEvent me){
        delete_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearSearch2buttonEntered(MouseEvent me){
        search_clear_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearSearch2buttonExited(MouseEvent me){
        search_clear_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Select2buttonEntered(MouseEvent me){
        select_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Select2buttonExited(MouseEvent me){
        select_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Reject2buttonEntered(MouseEvent me){
        reject_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Reject2buttonExited(MouseEvent me){
        reject_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ShowFullApplicationRecord2buttonEntered(MouseEvent me){
        show_full_application_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ShowFullApplicationRecord2buttonExited(MouseEvent me){
        show_full_application_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Add2buttonEntered(MouseEvent me){
        add_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Add2buttonExited(MouseEvent me){
        add_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear2buttonEntered(MouseEvent me){
        clear_button_2.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear2buttonExited(MouseEvent me){
        clear_button_2.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Refresh2ButtonEntered(MouseEvent me){
        refresh_pane2.setStyle("-fx-background-color:#ef1010;-fx-background-radius:3em;");
    }
    @FXML
    public void Refresh2ButtonExited(MouseEvent me){
        refresh_pane2.setStyle("-fx-background-color: #61ac53;-fx-background-radius:3em;");
    }
    @FXML
     public void Delete2ProcessedbuttonEntered(MouseEvent me){
        delete_button_2_processed.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Delete2ProcessedbuttonExited(MouseEvent me){
        delete_button_2_processed.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void ClearSearch2ProcessedbuttonEntered(MouseEvent me){
        search_clear_button_2_processed.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearSearch2ProcessedbuttonExited(MouseEvent me){
        search_clear_button_2_processed.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    
    
    
    
    
    
    
    //other related function of the enquiry form
    public void tableFill(){
        enquiry_id_col_first.setCellValueFactory(new PropertyValueFactory<>("eid"));
        full_name_col_first.setCellValueFactory(new PropertyValueFactory<>("name"));
        email_col_first.setCellValueFactory(new PropertyValueFactory<>("email"));
        contact_col_first.setCellValueFactory(new PropertyValueFactory<>("contact"));
        address_col_first.setCellValueFactory(new PropertyValueFactory<>("address"));
        enquiry_table_first.setItems(getAllValues());
        
        enquiry_id_col_second.setCellValueFactory(new PropertyValueFactory<>("eid"));
        nationality_col_second.setCellValueFactory(new PropertyValueFactory<>("nation"));
        type_of_degree_col_second.setCellValueFactory(new PropertyValueFactory<>("degree"));
        intrested_in_col_second.setCellValueFactory(new PropertyValueFactory<>("intrest"));
        status_col_second.setCellValueFactory(new PropertyValueFactory<>("status"));
        enquiry_table_second.setItems(getAllValues());
    }
    
    private ObservableList<EnquiryInformation> getAllValues(){
        ObservableList<EnquiryInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from enquiry_info_details";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new EnquiryInformation(rs.getString("enquiry_id"),rs.getString("full_name"),rs.getString("email")
                                ,rs.getString("contact"),rs.getString("full_address"),rs.getString("status"),rs.getString("nationality")
                                ,rs.getString("type_of_degree"),rs.getString("intrested_in")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private ObservableList<EnquiryInformation> getAllValuesForSearch(String value){
        ObservableList<EnquiryInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from enquiry_info_details where enquiry_id like \""+value+"%\"";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new EnquiryInformation(rs.getString("enquiry_id"),rs.getString("full_name"),rs.getString("email")
                                ,rs.getString("contact"),rs.getString("full_address"),rs.getString("status"),rs.getString("nationality")
                                ,rs.getString("type_of_degree"),rs.getString("intrested_in")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private static String prev_id;
    public void setProgramIddd(String value){
        prev_id=value;
    }
    public String getProgramIddd(){
        return prev_id;
    }
    //enquriy form button clicked listener of the enquiry form
    @FXML
    public void AddButtonEnquiryFormClickedListener(MouseEvent me){
        if(enquiry_id_text_1.getText().toString().equals("")||full_name_text_1.getText().toString().equals("")
                ||email_text_1.getText().toString().equals("")||contact_no_text_1.getText().toString().equals("")
                ||full_address_textArea_1.getText().toString().equals("")||intrested_in_textArea_1.getText().toString().equals("")
                ||nationality_combo_1.getValue().toString().equals("")||degree_combo_1.getValue().toString().equals("")){
            JOptionPane.showMessageDialog(null,"Either of the field is not completed!");
            System.out.println(nationality_combo_1.getValue().toString().equals(""));
        }else{
            try {
                if(checkAllTextfield()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select enquiry_id from enquiry_info_details where enquiry_id=\""+enquiry_id_text_1.getText().toString().toUpperCase()+"\"");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Enquiry ID alredy existed! Try New One");
                        }else{
                            String status="";
                            if(choice_student_1.isSelected()){
                                status="Student";
                            }else{
                                status="None";
                            }
                            st.executeUpdate("insert into enquiry_info_details(\n" +
                                "    enquiry_id,\n" +
                                "    full_name,\n" +
                                "    email,\n" +
                                "    contact,\n" +
                                "    full_address,\n" +
                                "    status,\n" +
                                "    nationality,\n" +
                                "    type_of_degree,\n" +
                                "    intrested_in) VALUES\n" +
                                "    (\""+enquiry_id_text_1.getText().toString().toUpperCase() +"\",\n" +
                                "     \""+full_name_text_1.getText().toString() +"\",\n" +
                                "     \""+email_text_1.getText().toString()+"\",\n" +
                                "     \""+contact_no_text_1.getText().toString()+"\",\n" +
                                "     \""+full_address_textArea_1.getText().toString()+"\",\n" +
                                "     \""+status+"\",\n" +
                                "     \""+nationality_combo_1.getValue().toString()+"\",\n" +
                                "     \""+degree_combo_1.getValue().toString()+"\",\n" +
                                "     \""+intrested_in_textArea_1.getText().toString()+"\")");
                            JOptionPane.showMessageDialog(null,"Enquiry Form is Sucessfully Inserted!");
                            clearButtonEnquiryFormClickedListener(me);
                            tableFill();
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Either Country Name or Types of degree is not choosed!");
            }
            
        }
    }
    @FXML
    public void clearButtonEnquiryFormClickedListener(MouseEvent me){
        enquiry_id_text_1.setText("");
        full_name_text_1.setText("");
        email_text_1.setText("");
        contact_no_text_1.setText("");
        full_address_textArea_1.setText("");
        choice_student_1.setSelected(true);
        nationality_combo_1.setValue("");
        degree_combo_1.setValue("");
        intrested_in_textArea_1.setText("");
    }
    @FXML
    public void searchIdKeyPressedListener(KeyEvent ke){
        enquiry_id_col_first.setCellValueFactory(new PropertyValueFactory<>("eid"));
        full_name_col_first.setCellValueFactory(new PropertyValueFactory<>("name"));
        email_col_first.setCellValueFactory(new PropertyValueFactory<>("email"));
        contact_col_first.setCellValueFactory(new PropertyValueFactory<>("contact"));
        address_col_first.setCellValueFactory(new PropertyValueFactory<>("address"));
        enquiry_table_first.setItems(getAllValuesForSearch(search_enquiry_id_text_1.getText().toString().toUpperCase()));
        
        enquiry_id_col_second.setCellValueFactory(new PropertyValueFactory<>("eid"));
        nationality_col_second.setCellValueFactory(new PropertyValueFactory<>("nation"));
        type_of_degree_col_second.setCellValueFactory(new PropertyValueFactory<>("degree"));
        intrested_in_col_second.setCellValueFactory(new PropertyValueFactory<>("intrest"));
        status_col_second.setCellValueFactory(new PropertyValueFactory<>("status"));
        enquiry_table_second.setItems(getAllValuesForSearch(search_enquiry_id_text_1.getText().toString().toUpperCase()));
    }
    @FXML
    public void clearSearchButtonClickedListener(MouseEvent me){
        search_enquiry_id_text_1.setText("");
        tableFill();
    }
    @FXML
    public void DeleteButtonClickedListener(MouseEvent me){
        if(search_enquiry_id_text_1.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select enquiry_id from enquiry_info_details where enquiry_id=\""+search_enquiry_id_text_1.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Record?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("delete from enquiry_info_details where enquiry_id=\""+search_enquiry_id_text_1.getText().toString().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        search_enquiry_id_text_1.setText("");
                        tableFill();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Enquiry ID does not exits! Try exist Enquiry ID");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Enquiry ID does not exits! Try exist Enquiry ID");
            }
        }
    }
    @FXML
    public void EditButtonClickedListener(MouseEvent me) throws IOException{
        if(search_enquiry_id_text_1.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select enquiry_id from enquiry_info_details where enquiry_id=\""+search_enquiry_id_text_1.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to update this Record?","Update Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        setProgramIddd(search_enquiry_id_text_1.getText().toString());
                        Parent root = (Parent) FXMLLoader.load(getClass().getResource("EditEnquiryForm.fxml"));
                        Scene scene = new Scene(root);
                        Window existingWindow = ((Node) me.getSource()).getScene().getWindow();

                        // create a new stage:
                        Stage stage = new Stage();
                        // make it modal:
                        stage.initModality(Modality.APPLICATION_MODAL);
                        // make its owner the existing window:
                        stage.initOwner(existingWindow);
                        stage.setTitle("Update Program");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.sizeToScene();
                        stage.show();
                        search_enquiry_id_text_1.setText("");
                        System.out.println("returned");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Enquiry ID does not exits! Try exist Enquiry ID");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProgramManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //checking regular Expression for textfield
    private boolean checkAllTextfield(){
        Pattern pat=Pattern.compile("^[A-Za-z][A-Za-z\\ ]{0,}");
        Matcher mat=pat.matcher(full_name_text_1.getText().toString());
        boolean name_match=false;
        if(mat.matches()){
            name_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Name Format is Invalid!");
            return false;
        }
        pat=Pattern.compile("^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$");
        mat=pat.matcher(email_text_1.getText().toString());
        boolean email_match=false;
        if(mat.matches()){
            email_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Email Format is Invalid!");
            return false;
        }
        pat=Pattern.compile("^[0-9][0-9]{5,}");
        mat=pat.matcher(contact_no_text_1.getText().toString());
        boolean contact_match=false;
        if(mat.matches()){
            contact_match=mat.matches();
        }else{
            JOptionPane.showMessageDialog(null,"Contact No. should have :-\n * Must Contain more than 5 Digits.\n * Must Contain Numeric Digits only.");
            return false;
        }
        return email_match&&contact_match&&name_match;
    }
    
    
    //color change of the button and other pane of enquiry form
    @FXML
    public void Edit1buttonEntered(MouseEvent me){
        edit_button_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit1buttonExited(MouseEvent me){
        edit_button_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Delete1buttonEntered(MouseEvent me){
        delete_button_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Delete1buttonExited(MouseEvent me){
        delete_button_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1buttonEntered(MouseEvent me){
        clear_button_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1buttonExited(MouseEvent me){
        clear_button_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Add1buttonEntered(MouseEvent me){
        add_button_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Add1buttonExited(MouseEvent me){
        add_button_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1FormbuttonEntered(MouseEvent me){
        clear_button_form_1.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1FormbuttonExited(MouseEvent me){
        clear_button_form_1.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    //color change of the button and other pane
    @FXML
    public void EnquiryFormbuttonEntered(MouseEvent me){
        enquiry_form_button.setStyle("-fx-background-color:#916c48;");
    }
    @FXML
    public void EnquiryFormbuttonExited(MouseEvent me){
        enquiry_form_button.setStyle("-fx-background-color:#6f1113;");
    }
    @FXML
    public void ApplicationProcessbuttonEntered(MouseEvent me){
        application_process_button.setStyle("-fx-background-color:#2cadaa;");
    }
    @FXML
    public void ApplicationProcessbuttonExited(MouseEvent me){
        application_process_button.setStyle("-fx-background-color:#6f1113;");
    }
    @FXML
    public void StudentRegisterbuttonEntered(MouseEvent me){
        student_registration_button.setStyle("-fx-background-color:#1a7120;");
    }
    @FXML
    public void StudentRegisterbuttonExited(MouseEvent me){
        student_registration_button.setStyle("-fx-background-color:#6f1113;");
    }

    @FXML
    public void refreshPaneButtonClickedListener(MouseEvent event) {
        tableFill();
    }

    @FXML
    public void RefreshbuttonEntered(MouseEvent me){
        refresh_pane.setStyle("-fx-background-color:#edcc12;-fx-background-radius:3em;");
    }
    @FXML
    public void RefreshbuttonExited(MouseEvent me){
        refresh_pane.setStyle("-fx-background-color:#38baaa;-fx-background-radius:3em;");
    }

}

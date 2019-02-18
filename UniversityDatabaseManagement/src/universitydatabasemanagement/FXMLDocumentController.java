/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import com.mysql.jdbc.PreparedStatement;
import com.sun.glass.ui.Screen;
import java.awt.geom.Rectangle2D;
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
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import universitydatabasemanagement.FirstLoadingBarFXMLController;
/**
 *
 * @author Mathew_Anish
 */
public class FXMLDocumentController implements Initializable {
    
    private static boolean errorCheck=false;
    private static boolean execptionCheck=false;
    private Connection conn=null;
  @FXML
    public AnchorPane back_view;

    @FXML
    private ImageView signin_pointer_view;

    @FXML
    private ImageView login_pointer_view;

    @FXML
    private ImageView close_pointer_view;

    @FXML
    private AnchorPane initial_view;

    @FXML
    private ImageView login_view_top;

    @FXML
    private ImageView exit_view_top;

    @FXML
    private ImageView signin_view;

    @FXML
    private AnchorPane login_view;

    @FXML
    private Label label_login_loginpane;

    @FXML
    private ImageView email_view_loginpane;

    @FXML
    private TextField email_textfield_loginpane;

    @FXML
    private ImageView password_view_loginpane;

    @FXML
    private PasswordField password_field_loginpane;

    @FXML
    private Button button_login_loginpane;

    @FXML
    private Button button_cancel_loginpane1;

    @FXML
    private AnchorPane sign_view;

    @FXML
    private Label label_signin;

    @FXML
    private ImageView email_view;

    @FXML
    private TextField username_textfield;

    @FXML
    private ImageView password_view;

    @FXML
    private PasswordField password_field;

    @FXML
    private ImageView retype_pass_view,error_image_signin3,error_image_signin4;

    @FXML
    private PasswordField password_field_retype;

    @FXML
    private ImageView gender_view,error_image_signin2,correct_image_email3,correct_image_email4;

    @FXML
    private RadioButton gender_male_radio;

    @FXML
    private RadioButton gender_female_radio;

    @FXML
    private RadioButton gender_other_radio;

    @FXML
    private Button button_submit;

    @FXML
    private Button button_cancel;

    @FXML
    private ImageView email_view1,correct_image_email1,error_image_signin1,correct_image_email2;

    @FXML
    private TextField email_textfield;
    @FXML
    private TextField firstname_textfield;
    @FXML
private TextField lastname_textfield;
    @FXML
    private ImageView nameView_name;
    @FXML
    private ImageView correct_image_firstlastname;
    @FXML
    private ImageView error_image_signin_name;
    @FXML
    private Pane Pane_collection;
    @FXML
    private Pane back_layoutPane;
    boolean name_check;
    boolean email_check;
    boolean username_check;
    boolean password_check;
    @FXML
    private ImageView correct_image_username;
    @FXML
    private ImageView correct_image_password;
    @FXML
    private ImageView error_image_username;
    @FXML
    private ImageView error_image_password;
    
    @FXML
    public void handleButtonAction(MouseEvent event) throws InterruptedException {
        //Anchor Pane handler 
        if(event.getTarget()==signin_view){
            sign_view.setVisible(true);
            login_view.setVisible(false);
            signin_pointer_view.setVisible(true);
            login_pointer_view.setVisible(false);
            close_pointer_view.setVisible(false);
            signin_view.toFront();
            login_view.toBack();
           // sign_view.setMouseTransparent(false);
           // login_view.setPickOnBounds(false);
           // login_view.setMouseTransparent(true);
        }
        if(event.getTarget()==login_view_top){
            sign_view.setVisible(false);
            login_view.setVisible(true);
            signin_pointer_view.setVisible(false);
            login_pointer_view.setVisible(true);
            close_pointer_view.setVisible(false);
            login_view.toFront();
            signin_view.toBack();
            //signin_view.setMouseTransparent(true);
        }
        if(event.getTarget()==exit_view_top){
            FadeTransition fade=new FadeTransition();
            fade.setNode(back_view);
            fade.setDuration(Duration.seconds(2));
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished((ActionEvent ae)->{
                System.exit(0);
            });
            fade.play();
        }
    }
    
    @FXML
    public void ButtonClickedSubmit(ActionEvent event) throws IOException{
        name_check=false;
        email_check=false;
        username_check=false;
        password_check=false;
        signin_view.toFront();
        if(event.getTarget()==button_submit){
            //submit button clicked of Sign in Panel
                String email_name,user_name,password,retypepass,gendergender="",hashcode;
                String firstname,lastname;
                Matcher mat,mat1;
                Pattern pat,pat1;
                boolean found,found1;
                
                firstname=firstname_textfield.getText();
                lastname=lastname_textfield.getText();
                pat=Pattern.compile("^[A-Z][a-z]{2,}");
                mat=pat.matcher(firstname);
                pat1=Pattern.compile("^[A-Z][a-z]{2,}");
                mat1=pat1.matcher(lastname);
                found1=mat1.matches();
                found=mat.matches();
                if(found&&found1){
                    correct_image_firstlastname.setVisible(true);
                    error_image_signin_name.setVisible(false);
                    name_check=true;
                }else{
                    correct_image_firstlastname.setVisible(false);
                    error_image_signin_name.setVisible(true);
                }
                email_name=email_textfield.getText();
                pat=Pattern.compile("^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.(com)$"); //regular expression for checking the email
                mat=pat.matcher(email_name);
                found=mat.matches();
                if(found){
                    correct_image_email1.setVisible(true);
                    error_image_signin1.setVisible(false);
                    email_check=true;
                }
                else{
                    correct_image_email1.setVisible(false);
                    error_image_signin1.setVisible(true);
                    email_name="";
                }
                user_name=username_textfield.getText();
                pat=Pattern.compile("^[a-zA-Z](\\w)+{5,}");
                mat=pat.matcher(user_name);
                found=mat.matches();
                if(found){
                    correct_image_email2.setVisible(true);
                    error_image_signin2.setVisible(false);
                    username_check=true;
                }else{
                    correct_image_email2.setVisible(false);
                    error_image_signin2.setVisible(true);
                    user_name="";
                }
                password=password_field.getText();
                retypepass=password_field_retype.getText();
                pat=Pattern.compile("^[\\w]{5,30}");
                mat=pat.matcher(password);
                found=mat.matches();
                pat1=Pattern.compile("^[\\w]{5,30}");
                mat1=pat1.matcher(retypepass);
                found1=mat1.matches();
                if(found==true&&found1==true&&password.equals(retypepass)==true){
                    correct_image_email3.setVisible(true);
                    correct_image_email4.setVisible(true);
                    error_image_signin3.setVisible(false);
                    error_image_signin4.setVisible(false);
                    password_check=true;
                }
                else{
                    correct_image_email3.setVisible(false);
                    correct_image_email4.setVisible(false);
                    error_image_signin3.setVisible(true);
                    error_image_signin4.setVisible(true);
                }
                if(gender_male_radio.isSelected()==true){
                    gendergender="male";
                }
                if(gender_female_radio.isSelected()==true){
                    gendergender="female";
                }
                if(gender_other_radio.isSelected()==true){
                    gendergender="other";
                }
                hashcode=String.valueOf(password.hashCode());
                
                
                //condition should be checked
                PreparedStatement prep=null;
                if(name_check==true&&email_check==true&&username_check==true&&password_check==true){
                    try{
                        int check=0;
                        String query="insert into account_info(username,firstname,lastname,pass,gender,hashcode,email) values(?,?,?,?,?,?,?)";
                        prep=(PreparedStatement) conn.prepareStatement(query);
                        prep.setString(1, user_name);
                        prep.setString(2, firstname);
                        prep.setString(3, lastname);
                        prep.setString(4, password);
                        prep.setString(5, gendergender);
                        prep.setString(6, hashcode);
                        prep.setString(7, email_name);
                        check=prep.executeUpdate();
                       
                        Parent ptt;
                        ptt=(AnchorPane)FXMLLoader.load(getClass().getResource("ProcessingMessageLayout.fxml"));
                        Scene scene=new Scene(ptt);
                        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                        Stage stg=(Stage)back_view.getScene().getWindow();
                        stg.setScene(scene);
                        stg.show();
                        
                        if(check>0){
                            //successfully executed
                            errorCheck=true;
                            execptionCheck=false;
                        }else{
                            //stuck in the middle
                            errorCheck=false;
                            execptionCheck=false;
                        }
                        
                    }catch(SQLException e){
                        execptionCheck=true;
                        Parent ptt;
                        ptt=(AnchorPane)FXMLLoader.load(getClass().getResource("ProcessingMessageLayout.fxml"));
                        Scene scene=new Scene(ptt);
                        scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
                        Stage stg=(Stage)back_view.getScene().getWindow();
                        stg.setScene(scene);
                        stg.show();
                        System.out.println("Duplicate occurs");
                    }
                }
        }
        if(event.getTarget()==button_cancel){
            //cancel button clicked of Sign in Panel
            sign_view.setVisible(false);
            login_view.setVisible(true);
            signin_pointer_view.setVisible(false);
            login_pointer_view.setVisible(true);
            close_pointer_view.setVisible(false);
            login_view.toFront();
            signin_view.toBack();
        }
    }
    @FXML
    public void LoginButtonClicked(ActionEvent event) throws IOException{
        String Username,Password;
        Pattern pat;
        Matcher mat;
        
        
        if(event.getTarget()==button_login_loginpane){
            Username=email_textfield_loginpane.getText();
            Password=password_field_loginpane.getText();
            pat=Pattern.compile("^[a-zA-Z](\\w)+{5,}");
            mat=pat.matcher(Username);
            if(mat.matches()==true){
                correct_image_username.setVisible(true);
                error_image_username.setVisible(false);
            }else{
                correct_image_username.setVisible(false);
                error_image_username.setVisible(true);
            }
            pat=Pattern.compile("^[\\w]{5,30}");
            mat=pat.matcher(Password);
            if(mat.matches()==true){
                correct_image_password.setVisible(true);
                error_image_password.setVisible(false);
            }else{
                correct_image_password.setVisible(false);
                error_image_password.setVisible(true); 
            }
            Statement st=null;
            try {
                String query="SELECT * from account_info where username=\""+Username+"\"";
                st=conn.createStatement();
                ResultSet rest=st.executeQuery(query);
                while(rest.next()){
                    if(rest.getString("username").equals(Username)&&rest.getString("pass").equals(Password)){
                        //true statement in here Execute or set the boolean variable to procceds
                        FadeTransition fade=new FadeTransition();
                        fade.setNode(back_view);
                        fade.setDuration(Duration.seconds(2));
                        fade.setFromValue(1.0);
                        fade.setToValue(0.0);
                        fade.setOnFinished((ActionEvent ev)->{
                            try {
                                LoginSucessfullLoader();
                            } catch (IOException ex) {
                                System.out.println("Exception");
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });
                        fade.play();
                    }else{
                        
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
        }
        if(event.getTarget()==button_cancel_loginpane1){
            email_textfield_loginpane.setText(null);
            password_field_loginpane.setText(null);
        }
        
    }
    private void LoginSucessfullLoader() throws IOException{
        Parent ppt;
        ppt=(AnchorPane)FXMLLoader.load(getClass().getResource("MainChooser.fxml"));
        String css=this.getClass().getResource("mainchooser.css").toExternalForm();
        Scene scene=new Scene(ppt);
        scene.getStylesheets().add(css);
        Stage stg=(Stage)back_view.getScene().getWindow();
        stg.setScene(scene);
        stg.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"account_info",null);
            if(rs.next()){
                //true part
                System.out.println("true");
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table account_info("
                                +"username varchar(50) PRIMARY KEY,"
                                +" firstname varchar(30) not null,"
                                +" lastname varchar(30) not null,"
                                +" pass varchar(35) not null,"
                                +" gender varchar(10) not null,"
                                +" hashcode varchar(50) not null,"
                                +" email varchar(50) not null)");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        try{
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"program_info",null);
            if(rs.next()){
            
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table program_info(\n" +
                    "    program_id varchar(30) PRIMARY KEY,\n" +
                    "    title varchar(100) not null\n" +
                    "    );");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }


 try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"librarian_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table librarian_info(\n" +
                    "    librarian_id varchar(50) PRIMARY KEY,\n" +
                    "    librarian_name varchar(100) not null,\n" +
                    "    shift varchar(40) not null\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"book_record_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table book_record_info(\n" +
                    "    book_id varchar(50) PRIMARY KEY,\n" +
                    "    book_title varchar(200) not null,\n" +
                    "    publisher varchar(200) not null,\n" +
                    "    author varchar(200) not null,\n" +
                    "    no_of_pieces int not null,\n" +
                    "    no_of_pieces_left int not null,\n" +
                    "    book_location varchar(200) not null\n" +
                    "    );\n" +
                    "    ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"employee_information_record",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table employee_information_record(\n" +
                "    eid varchar(50) primary key,\n" +
                "    name varchar(100) not null,\n" +
                "    contact varchar(40) not null,\n" +
                "    email varchar(50),\n" +
                "    job_title varchar(75) not null,\n" +
                "    department varchar(50) not null,\n" +
                "    employee_type varchar(50) not null,\n" +
                "    start_date date not null,\n" +
                "    end_date date,\n"+
                "    education_details varchar(4000),\n" +
                "    termination_reason varchar(4000),\n" +
                "    work_history varchar(4000),\n" +
                "    salary int not null,\n" +
                "    status varchar(20) not null\n"+
                "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"employee_attendance_record",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table employee_attendance_record(\n" +
                    "    edate date,\n" +
                    "  	eid varchar(50),\n" +
                    "    primary key(edate,eid),\n" +
                    "    foreign key(eid) REFERENCES employee_information_record(eid) on update CASCADE on DELETE CASCADE\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"employee_salary_record",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table employee_salary_record(\n" +
                    "    eid varchar(50),\n" +
                    "    amt_to_be_given int not null,\n" +
                    "    total_amt_given int not null,\n" +
                    "    FOREIGN key(eid) REFERENCES employee_information_record(eid) on DELETE CASCADE on UPDATE CASCADE\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
            // TODO
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null, null, "fees_structure_information_record", null);
            if(rs.next()){
                
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table fees_structure_information_record(\n" +
                    "    pid varchar(50),\n" +
                    "    pname varchar(100) not null,\n" +
                    "    academic_fees int,\n" +
                    "    research_fees int,\n" +
                    "    student_services int,\n" +
                    "    student_health int,\n" +
                    "    cost_of_living int,\n" +
                    "    FOREIGN KEY(pid) REFERENCES program_info(program_id) on DELETE CASCADE on UPDATE CASCADE\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"course_info",null);
            if(rs.next()){
                //true part
                System.out.println("true");
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table course_info(\n" +
                    "    course_id varchar(100),\n" +
                    "    program_id varchar(100) not null,\n" +
                    "    course_name varchar(200) not null,\n" +
                    "    credit_hour float not null,\n" +
                    "    primary key(course_id,program_id),\n"+
                    "    foreign key(program_id) REFERENCES program_info(program_id) on delete CASCADE on UPDATE CASCADE\n" +
                    "    )");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }

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

try {
            // TODO
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null, null, "student_transaction_record_system", null);
            if(rs.next()){
                
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table student_transaction_record_system(\n" +
                    "    std_id varchar(50),\n" +
                    "    amount_to_be_paid int,\n" +
                    "    total_paid_amount int,\n" +
                    "    FOREIGN KEY(std_id) REFERENCES student_registration_info(student_id) on DELETE CASCADE on UPDATE CASCADE\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
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

try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"book_lending_return_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table book_lending_return_info(\n" +
                    "    b_id varchar(50),\n" +
                    "    std_id varchar(50),\n" +
                    "    issue_date date,\n" +
                    "    given_by varchar(100),\n" +
                    "    return_date date,\n" +
                    "    return_to varchar(100),\n" +
                    "    primary key(b_id,std_id),\n"+
                    "    FOREIGN key(std_id) REFERENCES student_registration_info(student_id) on DELETE cascade on UPDATE CASCADE,\n" +
                    "    FOREIGN KEY(b_id) REFERENCES book_record_info(book_id) on delete cascade on update cascade,\n" +
                    "    FOREIGN key(given_by) REFERENCES librarian_info(librarian_id) on delete cascade on update cascade,\n" +
                    "        FOREIGN key(return_to) REFERENCES librarian_info(librarian_id) on delete cascade on update cascade\n" +
                    "\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"book_returned_info",null);
            if(!rs.next()){
                Statement st=conn.createStatement();
                st.executeUpdate("create table book_returned_info(\n" +
                    "    b_id varchar(50),\n" +
                    "    std_id varchar(50),\n" +
                    "    issue_date date,\n" +
                    "    given_by varchar(100),\n" +
                    "    return_date date,\n" +
                    "    return_to varchar(100),\n" +
                    "    FOREIGN key(std_id) REFERENCES student_registration_info(student_id) on DELETE cascade on UPDATE CASCADE,\n" +
                    "    FOREIGN KEY(b_id) REFERENCES book_record_info(book_id) on delete cascade on update cascade,\n" +
                    "    FOREIGN key(given_by) REFERENCES librarian_info(librarian_id) on delete cascade on update cascade,\n" +
                    "        FOREIGN key(return_to) REFERENCES librarian_info(librarian_id) on delete cascade on update cascade\n" +
                    "\n" +
                    "    );");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        randomCheck();
        
        ToggleGroup tg=new ToggleGroup();
        gender_male_radio.setToggleGroup(tg);
        gender_male_radio.setSelected(true);
        gender_female_radio.setToggleGroup(tg);
        gender_other_radio.setToggleGroup(tg);
        login_view.toFront();
        signin_view.toBack();
    }    
    private void randomCheck(){
        FadeTransition ft=new FadeTransition();
        ft.setNode(back_view);
        ft.setDuration(Duration.seconds(2));
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
    }
    public boolean errorCheckReturn(){
        return errorCheck;
    }
    public boolean exceptionCheckReturn(){
        return execptionCheck;
    }
}

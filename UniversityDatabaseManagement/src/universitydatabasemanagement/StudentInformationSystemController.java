/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.WritableImage;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * FXML Controller class
 *
 * @author Solar
 */
public class StudentInformationSystemController implements Initializable {

    @FXML
    private TableView<AdmissionInformation> Student_information_tableview;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_tablecolumn_student_information;
    @FXML
    private TableColumn<AdmissionInformation, String> name_tablecolumn_student_information;
    @FXML
    private TableColumn<AdmissionInformation, String> contact_no_tablecolumn_student_information;
    @FXML
    private TableColumn<AdmissionInformation, String> hostel_status_tablecolumn_student_information;
    @FXML
    private TableColumn<AdmissionInformation, String> enrollment_date_tablecolumn_student_information;
    @FXML
    private TableColumn<AdmissionInformation, String> selected_program_tablecolumn_student_information;
    @FXML
    private Label University_name_label_ID_Card;
    @FXML
    private Label address_label_ID_Card;
    @FXML
    private Label contact_no_label_ID_Card;
    @FXML
    private Rectangle photos_rectangle;
    @FXML
    private Label student_name_label_ID_Card;
    @FXML
    private Label student_id_label_ID_Card;
    @FXML
    private Label contact_label_ID_Card;
    @FXML
    private Label issued_date_label_ID_Card;
    @FXML
    private Label selected_program_label_ID_Card;
    @FXML
    private TextField university_name_textfield_id;
    @FXML
    private TextField student_id_textfield_id;
    @FXML
    private ComboBox<Integer> issued_date_year_combo_3_BL;
    @FXML
    private ComboBox<Integer> issued_date_month_combo_3_BL;
    @FXML
    private ComboBox<Integer> issued_date_day_combo_3_BL;
    @FXML
    private Button clear_button_id;
    @FXML
    private Button generate_button_id;
    @FXML
    private TextField university_address_textfield_id;
    @FXML
    private TextField university_contact_textfield_id;
    @FXML
    private Button print_button_ID;
    @FXML
    private TextField student_name_textfield_id;
    @FXML
    private Button clear_button_id_searchby;
    private Connection conn;
    @FXML
    private AnchorPane icard_anchorpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        issued_date_year_combo_3_BL.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        issued_date_day_combo_3_BL.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        issued_date_month_combo_3_BL.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        
        
        StudentInformationTableviewFillingOfStudentInformationSystem();
    }    
  
    private boolean checkPaymentAmountValue(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    @FXML
    public void ClearButtonIDButtonClickedListener(ActionEvent ae){
        university_name_textfield_id.setText("");
        student_id_textfield_id.setText("");
        university_address_textfield_id.setText("");
        university_contact_textfield_id.setText("");
    }
    @FXML
    public void GenerateButtonIDButtonClickedListener(ActionEvent ae){
        if(university_name_textfield_id.getText().equals("")||student_id_textfield_id.getText().equals("")||
                university_address_textfield_id.getText().equals("")||university_contact_textfield_id.getText().equals("")||
                String.valueOf(issued_date_year_combo_3_BL.getValue()).equals("null")||String.valueOf(issued_date_month_combo_3_BL.getValue()).equals("null")||
                String.valueOf(issued_date_day_combo_3_BL.getValue()).equals("null")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to generate I-Card?","I-Card Generation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(university_contact_textfield_id.getText())){
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from student_registration_info where student_id=\""+student_id_textfield_id.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            ResultSet rss=stt.executeQuery("SELECT * FROM `application_form_details` where aid=\""+rs.getString("applicant_id")+"\"");
                            if(rss.next()){
                                University_name_label_ID_Card.setText(university_name_textfield_id.getText().toUpperCase());
                                address_label_ID_Card.setText("Address : "+university_address_textfield_id.getText());
                                contact_no_label_ID_Card.setText("Contact No. : "+university_contact_textfield_id.getText());
                                student_name_label_ID_Card.setText(rss.getString("full_name"));
                                student_id_label_ID_Card.setText(rs.getString("student_id"));
                                contact_label_ID_Card.setText(rss.getString("contact_no"));
                                issued_date_label_ID_Card.setText(String.valueOf(issued_date_year_combo_3_BL.getValue())+"-"+String.valueOf(issued_date_month_combo_3_BL.getValue())+"-"+String.valueOf(issued_date_day_combo_3_BL.getValue()));
                                selected_program_label_ID_Card.setText(rss.getString("selected_program"));
                                JOptionPane.showMessageDialog(null, "I-Card Successfully Generated!");
                                ClearButtonIDButtonClickedListener(ae);
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Invalid Student ID!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(StudentInformationSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    @FXML
    public void PrintButtonIDButtonClickedListener(ActionEvent ae) throws IOException{
        int val=JOptionPane.showConfirmDialog(null,"Do you want to save I-Card generation for the further print process?","I-Card Generation",JOptionPane.YES_NO_OPTION);
        if(val==0){
                FileNameExtensionFilter filter = new FileNameExtensionFilter("png files (*.png)", "png");
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Save I-Card Image as :");
               // chooser.addChoosableFileFilter("png");
                chooser.setFileFilter(filter);
                int userselection=chooser.showSaveDialog(null);
                if(userselection==JFileChooser.APPROVE_OPTION){
                    File path=chooser.getSelectedFile();
                    System.out.println(path.getAbsolutePath());
                    WritableImage image = icard_anchorpane.snapshot(new SnapshotParameters(), null);
                    File file = new File(path.getAbsolutePath()+".png");
                    ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);
                    JOptionPane.showMessageDialog(null, "Successfully Saved as Image Form!");
                }
        }
    }
    
    
    @FXML
    public void ClearSearchByButtonClickedListener(ActionEvent ae){
        student_name_textfield_id.setText("");
        StudentInformationTableviewFillingOfStudentInformationSystem();
    }
    
    @FXML
    public void SearchByStudentTextFieldIDKeyPressedEventListenerSearchBy(KeyEvent ke){
        student_id_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        contact_no_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        hostel_status_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        enrollment_date_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("email"));
        selected_program_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        Student_information_tableview.setItems(getValuesForStudentInformationSystem(student_name_textfield_id.getText()));
    }
    
    private ObservableList<AdmissionInformation> getValuesForStudentInformationSystem(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `application_form_details` where full_name like \""+value+"%\"");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("SELECT * FROM `student_registration_info` where applicant_id=\""+rs.getString("aid")+"\"");
                
                if(rss.next()){
                    Statement stv=conn.createStatement();
                    ResultSet rsv=stv.executeQuery("SELECT * FROM `room_assignation_leaving_details` where std_id=\""+rss.getString("student_id")+"\"");
                    String status="";
                    if(rsv.next()){
                        status="Yes";
                    }else{
                        status="No";
                    }
                    
                    list.add(new AdmissionInformation(rss.getString("student_id"),rs.getString("full_name"),rs.getString("contact_no"),status,String.valueOf(rss.getInt("enrolment_year"))+"-"+String.valueOf(rss.getInt("enrolment_month"))+"-"+String.valueOf(rss.getInt("enrolment_day")),rs.getString("selected_program"))); 
                }              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private ObservableList<AdmissionInformation> getValuesForStudentInformationSystem(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `student_registration_info`");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("SELECT * FROM `application_form_details` where aid=\""+rs.getString("applicant_id")+"\"");
                Statement stv=conn.createStatement();
                ResultSet rsv=stv.executeQuery("SELECT * FROM `room_assignation_leaving_details` where std_id=\""+rs.getString("student_id")+"\"");
                String status="";
                if(rsv.next()){
                    status="Yes";
                }else{
                    status="No";
                }
                if(rss.next()){
                   list.add(new AdmissionInformation(rs.getString("student_id"),rss.getString("full_name"),rss.getString("contact_no"),status,String.valueOf(rs.getInt("enrolment_year"))+"-"+String.valueOf(rs.getInt("enrolment_month"))+"-"+String.valueOf(rs.getInt("enrolment_day")),rss.getString("selected_program"))); 
                }              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void StudentInformationTableviewFillingOfStudentInformationSystem(){
        student_id_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        contact_no_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        hostel_status_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        enrollment_date_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("email"));
        selected_program_tablecolumn_student_information.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        Student_information_tableview.setItems(getValuesForStudentInformationSystem());
        Student_information_tableview.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
               try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM `student_registration_info` where student_id=\""+Student_information_tableview.getSelectionModel().getSelectedItem().getAid().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("SELECT * FROM `application_form_details` where aid=\""+rs.getString("applicant_id")+"\"");
                        if(rss.next()){
                            Statement stv=conn.createStatement();
                            ResultSet rsv=stv.executeQuery("SELECT * FROM `room_assignation_leaving_details` where std_id=\""+rs.getString("student_id")+"\"");
                            if(!rsv.next()){
                                JOptionPane.showMessageDialog(null, "Student Information:\n"
                                        + "Application ID : "+rss.getString("aid")+"          Student ID : "+rs.getString("student_id")+"\n"
                                                + "Name : "+rss.getString("full_name")+"          Gender : "+rs.getString("gender")+"\n"
                                                        + "DOB : "+rs.getInt("dob_year")+"-"+rs.getInt("dob_month")+"-"+rs.getInt("dob_day")+"          Full Address : "+rss.getString("full_address")+"\n"
                                                                + "Nationality : "+rss.getString("nationality")+"\n"
                                                                        + "Email : "+rss.getString("email")+"          Contact No. : "+rss.getString("contact_no")+"\n"
                                                                                + "Selected Program : "+rss.getString("selected_program")+"          Admission Type : "+rss.getString("admission_type")+"\n"
                                                                                        + "Status : "+rss.getString("selection_status")+"\n"
                                                                                                + "Guardian Name : "+rs.getString("guardian_name")+"          Guardian Contact : "+rs.getString("guardian_contact")+"\n"
                                                                                                        + "Bank Name : "+rs.getString("bank_name")+"          Bank A/C : "+rs.getString("bank_ac")+"\n"
                                                                                                                + "PAN No. : "+rs.getString("PAN_no"));
                            }else{
                                if(rsv.getString("leavedate")==null){
                                    JOptionPane.showMessageDialog(null, "Student Information:\n\n"
                                        + "Application ID : "+rss.getString("aid")+"          Student ID : "+rs.getString("student_id")+"\n"
                                                + "Name : "+rss.getString("full_name")+"          Gender : "+rs.getString("gender")+"\n"
                                                        + "DOB : "+rs.getInt("dob_year")+"-"+rs.getInt("dob_month")+"-"+rs.getInt("dob_day")+"          Full Address : "+rss.getString("full_address")+"\n"
                                                                + "Nationality : "+rss.getString("nationality")+"\n"
                                                                        + "Email : "+rss.getString("email")+"          Contact No. : "+rss.getString("contact_no")+"\n"
                                                                                + "Selected Program : "+rss.getString("selected_program")+"          Admission Type : "+rss.getString("admission_type")+"\n"
                                                                                        + "Status : "+rss.getString("selection_status")+"\n"
                                                                                                + "Guardian Name : "+rs.getString("guardian_name")+"          Guardian Contact : "+rs.getString("guardian_contact")+"\n"
                                                                                                        + "Bank Name : "+rs.getString("bank_name")+"          Bank A/C : "+rs.getString("bank_ac")+"\n"
                                                                                                                + "PAN No. : "+rs.getString("PAN_no")+"\n\n"
                                                                                                                        + "Hostel Information : \n\n"
                                                                                                                        + "Hostel ID : "+rsv.getString("hostel_id")+"          Room ID : "+rsv.getString("r_id")+"\n"
                                                                                                                                + "Join Date : "+rsv.getDate("joindate")+"          Current Status : Currently Enrolled\n");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Student Information:\n\n"
                                        + "Application ID : "+rss.getString("aid")+"          Student ID : "+rs.getString("student_id")+"\n"
                                                + "Name : "+rss.getString("full_name")+"          Gender : "+rs.getString("gender")+"\n"
                                                        + "DOB : "+rs.getInt("dob_year")+"-"+rs.getInt("dob_month")+"-"+rs.getInt("dob_day")+"          Full Address : "+rss.getString("full_address")+"\n"
                                                                + "Nationality : "+rss.getString("nationality")+"\n"
                                                                        + "Email : "+rss.getString("email")+"          Contact No. : "+rss.getString("contact_no")+"\n"
                                                                                + "Selected Program : "+rss.getString("selected_program")+"          Admission Type : "+rss.getString("admission_type")+"\n"
                                                                                        + "Status : "+rss.getString("selection_status")+"\n"
                                                                                                + "Guardian Name : "+rs.getString("guardian_name")+"          Guardian Contact : "+rs.getString("guardian_contact")+"\n"
                                                                                                        + "Bank Name : "+rs.getString("bank_name")+"          Bank A/C : "+rs.getString("bank_ac")+"\n"
                                                                                                                + "PAN No. : "+rs.getString("PAN_no")+"\n\n"
                                                                                                                        + "Hostel Information : \n\n"
                                                                                                                        + "Hostel ID : "+rsv.getString("hostel_id")+"          Room ID : "+rsv.getString("r_id")+"\n"
                                                                                                                                + "Join Date : "+rsv.getDate("joindate")+"          Leave Date : "+rsv.getDate("leavedate")
                                                                                                                                        + "\nCurrent Status : Leave\n");
                                }
                            }
                        }
                        student_id_textfield_id.setText(Student_information_tableview.getSelectionModel().getSelectedItem().getAid().toUpperCase());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    

    @FXML
    public void clearButtonIDButtonEntered(MouseEvent me){
        clear_button_id.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clearButtonIDButtonExited(MouseEvent me){
        clear_button_id.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void generateButtonIDButtonEntered(MouseEvent me){
        generate_button_id.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void generateButtonIDButtonExited(MouseEvent me){
        generate_button_id.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void printButtonIDButtonEntered(MouseEvent me){
        print_button_ID.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void printButtonIDButtonExited(MouseEvent me){
        print_button_ID.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void clearButtonIDSearchByButtonEntered(MouseEvent me){
        clear_button_id_searchby.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clearButtonIDSearchByButtonExited(MouseEvent me){
        clear_button_id_searchby.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    
    
    
    
    
}

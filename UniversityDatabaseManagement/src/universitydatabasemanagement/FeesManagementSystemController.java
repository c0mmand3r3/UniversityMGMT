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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Solar
 */
public class FeesManagementSystemController implements Initializable {

    @FXML
    private Button fees_structure_button_from_main_chooser;
    @FXML
    private Button transaction_button_from_main_chooser;
    @FXML
    private AnchorPane fees_structure_anchorpane_middle;
    @FXML
    private TableView<AdmissionInformation> fees_information_per_year_tableview_middle_fee_structure;
    @FXML
    private TableColumn<AdmissionInformation , String> program_id_tablecolumn_middle_fees_information_per_year;
    @FXML
    private TableColumn<AdmissionInformation , String> name_tablecolumn_middle_fees_information_per_year;
    @FXML
    private TableColumn<AdmissionInformation , String> academic_fees_tablecolumn_fees_information_per_year;
    @FXML
    private TableColumn<AdmissionInformation , String> research_fees_tablecolumn_fees_information_per_year;
    @FXML
    private TableColumn<AdmissionInformation , String> student_services_tablecolumn_fees_information_per_year;
    @FXML
    private TableColumn<AdmissionInformation , String> student_health_tablecolumn_fees_information_per_year;
    @FXML
    private TableColumn<AdmissionInformation , String> cost_of_living_tablecolumn_fees_information_per_year;
    @FXML
    private ChoiceBox<String> program_id_plus_name_choose_for_edit_fees;
    @FXML
    private ChoiceBox<String> fees_types_choose_for_edit_fees;
    @FXML
    private TextField amount_tution_fee_textfield_for_edit_fees;
    @FXML
    private Button edit_button_for_edit_fees;
    @FXML
    private Button clear_button_for_edit_fees;
    @FXML
    private TextField search_by_program_name_textfield_middle_fees_structure;
    @FXML
    private Button clear_search_by_program_name_middle_fees_structure;
    @FXML
    private TableView<AdmissionInformation> transaction_tableview_of_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_tablecolumn_of_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> student_name_tablecolumn_for_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> program_id_tablecolumn_for_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> program_name_tablecolumn_for_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> hostel_status_tablecolumn_for_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> amount_to_be_paid_for_transaction_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> paid_amount_tablecolumn_for_transaction_middle;
    @FXML
    private TextField search_by_student_name_textfield_for_table_of_transaction_middle;
    @FXML
    private Button reset_button_for_student_id_of_transaction_middle;
    @FXML
    private Button clear_button_of_search_by_student_name_of_transaction_middle;
    @FXML
    private TextField student_id_textfield_for_transaction_table_of_transaction_middle;
    @FXML
    private Button clear_button_for_student_id_of_transaction_middle;
    @FXML
    private Button insert_corresponding_amount_to_the_table_button_of_transaction_middle;
    @FXML
    private Button clear_all_the_table_payment_button_of_transaction_middle;
    @FXML
    private AnchorPane fees_structure_anchorpane_right;
    @FXML
    private ChoiceBox<String> academic_fees_per_year_program_id_plus_name_choose_AFPY;
    @FXML
    private TextField tution_fees_textfield_for_academic_fees_per_year;
    @FXML
    private TextField research_fees_textfield_for_research_fees_per_year;
    @FXML
    private Button add_button_for_academic_fees_per_year;
    @FXML
    private Button clear_button_for_academic_fees_per_year;
    @FXML
    private ChoiceBox<String> program_id_plus_name_choose_for_research_fees_per_year;
    @FXML
    private Button add_button_for_research_fees_per_year;
    @FXML
    private Button clear_button_for_research_fees_per_year;
    @FXML
    private TextField student_services_fee_textfield_for_student_services_and_amenties_fees_per_year;
    @FXML
    private ChoiceBox<String> program_id_plus_name_choose_student_services_and_amenies_fees_per_year;
    @FXML
    private Button add_button_for_student_services_and_amenties_fees_per_year;
    @FXML
    private Button clear_button_for_student_services_and_amenties_fees_per_year;
    @FXML
    private TextField health_services_fee_textfield_for_student_health_cover_per_year;
    @FXML
    private ChoiceBox<String> program_id_plus_name_choose_for_student_health_cover_per_year;
    @FXML
    private Button add_button_for_student_health_cover_per_year;
    @FXML
    private Button clear_button_for_student_health_cover_per_year;
    @FXML
    private TextField hostel_fee_textfield_for_cost_of_living_or_hostel_fees_per_year;
    @FXML
    private ChoiceBox<String> program_id_plus_name_choose_for_cost_of_living_or_hostel_fees_per_year;
    @FXML
    private Button add_button_for_cost_of_living_or_hostel_fees_per_year;
    @FXML
    private Button clear_button_for_cost_of_living_or_hostel_fees_per_year;
    @FXML
    private TextField student_id_textfield_for_payment_of_transaction_right;
    @FXML
    private TextField amount_textfield_for_payment_of_transaction_right;
    @FXML
    private Button pay_button_for_payment_of_transaction_right;
    @FXML
    private Button clear_button_for_payment_of_transaction_right;
    @FXML
    private TextField student_id_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right;
    @FXML
    private TextField amount_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right;
    @FXML
    private Button insert_button_for_insert_extra_amount_to_be_paid_of_transaction_right;
    @FXML
    private Button clear_button_for_insert_extra_amount_to_be_paid_of_transaction_right;
    @FXML
    private AnchorPane transaction_anchorpane_middle;
    @FXML
    private AnchorPane transaction_anchorpane_right;
    private Connection conn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn=DBMSConnector_login.connect_Database();
        fees_structure_anchorpane_middle.setVisible(true);
        fees_structure_anchorpane_right.setVisible(true);
        transaction_anchorpane_middle.setVisible(false);
        transaction_anchorpane_right.setVisible(false);
        fees_types_choose_for_edit_fees.setItems(FXCollections.observableArrayList("Academic Fees",
                "Research Fees",
                "Student Services and Amenties Fees",
                "Student Health Cover fees",
                "Cost of Living or Hostel Fees"
                ));
        program_id_plus_name_choose_for_edit_fees.setItems(GetAlltheProgramPlusID());
        academic_fees_per_year_program_id_plus_name_choose_AFPY.setItems(GetAlltheProgramPlusID());
        program_id_plus_name_choose_for_research_fees_per_year.setItems(GetAlltheProgramPlusID());
        program_id_plus_name_choose_student_services_and_amenies_fees_per_year.setItems(GetAlltheProgramPlusID());
        program_id_plus_name_choose_for_student_health_cover_per_year.setItems(GetAlltheProgramPlusID());
        program_id_plus_name_choose_for_cost_of_living_or_hostel_fees_per_year.setItems(GetAlltheProgramPlusID());
        
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
        
        FillTableInitiallyIfNoInputIsMade();
        FillFeesInformationTablePerYear();
        FillTableTransactionInitiallyIfNoInputIsMade();
        FillTransactionInformationTable();
    }    

    
    private boolean checkPaymentAmountValue(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
 
     
    @FXML
    public void ChooseEventListenerButtonClickedListener(ActionEvent ae){
        if(ae.getSource()==fees_structure_button_from_main_chooser){
            fees_structure_anchorpane_middle.setVisible(true);
            fees_structure_anchorpane_right.setVisible(true);
            transaction_anchorpane_middle.setVisible(false);
            transaction_anchorpane_right.setVisible(false);
            FillFeesInformationTablePerYear();
            
        }
        if(ae.getSource()==transaction_button_from_main_chooser){
            fees_structure_anchorpane_middle.setVisible(false);
            fees_structure_anchorpane_right.setVisible(false);
            transaction_anchorpane_middle.setVisible(true);
            transaction_anchorpane_right.setVisible(true);
            
        }
    }
    
    //transaction methods and events
    
    
    public void insertCorrespondingAmountToTheTableButtonOfTransactionMiddleButtonClickedListener(ActionEvent ae){
        int val=JOptionPane.showConfirmDialog(null,"Do you want to Insert Corresponding amount of With Selected Program?","Student Transaction Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM `student_transaction_record_system`");
                    while(rs.next()){
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("SELECT * FROM `student_registration_info` where student_id=\""+rs.getString("std_id")+"\"");
                        if(rss.next()){
                            Statement stv=conn.createStatement();
                            ResultSet rsv=stv.executeQuery("SELECT * FROM `application_form_details` where aid=\""+rss.getString("applicant_id")+"\"");
                            if(rsv.next()){
                                Statement stm=conn.createStatement();
                                ResultSet rsm=stm.executeQuery("SELECT * FROM `fees_structure_information_record` where pname=\""+rsv.getString("selected_program")+"\"");
                                if(rsm.next()){
                                    int total=rsm.getInt("academic_fees")+rsm.getInt("research_fees")+rsm.getInt("student_services")+rsm.getInt("student_health")+rsm.getInt("cost_of_living");
                                    Statement stst=conn.createStatement();
                                    stst.executeUpdate("UPDATE `student_transaction_record_system` SET `amount_to_be_paid`=amount_to_be_paid+"+total+" where std_id=\""+rs.getString("std_id")+"\"");
                                    
                                    FillTransactionInformationTable();
                                }
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Sucessfully Inserted!");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    public void clearAllTheTablePaymentButtonOfTransactionMiddleButtonClickedListener(ActionEvent ae){
        int val=JOptionPane.showConfirmDialog(null,"Do you want to Clear all the amount?","Student Transaction Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {                    
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("UPDATE `student_transaction_record_system` SET `amount_to_be_paid`=0,`total_paid_amount`=0");
                        JOptionPane.showMessageDialog(null, "Sucessfully Cleared!");
                        FillTransactionInformationTable();
                } catch (SQLException ex) {
                    Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    public void insertButtonForInsertExtraAmountToBePaidOfTransactionRightButtonClickedListener(ActionEvent ae){
        if(student_id_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.getText().equals("")||amount_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Insert Extra amount to the given student ID?","Student Transaction Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(amount_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.getText())){
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `student_transaction_record_system` where std_id=\""+student_id_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `student_transaction_record_system` SET `amount_to_be_paid`=amount_to_be_paid+"+amount_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.getText()+" WHERE std_id=\""+student_id_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.getText().toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Inserted!");
                            clearButtonForInsertExtraAmountToBePaidOfTransactionRightButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Sorry! Student ID is not in the record!\n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Amount Must be in Number!");
                }
            }
        }
    }
    public void clearButtonForInsertExtraAmountToBePaidOfTransactionRightButtonClickedListener(ActionEvent ae){
        student_id_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.setText("");
        amount_textfield_for_insert_extra_amount_to_be_paid_of_transaction_right.setText("");
        FillTransactionInformationTable();
    }
    
    
    
    
    
    
    
    
    
    public void payButtonForPaymentOfTransactionRightButtonClickedListener(ActionEvent ae){
        if(student_id_textfield_for_payment_of_transaction_right.getText().equals("")||amount_textfield_for_payment_of_transaction_right.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to pay amount of given student ID?","Student Transaction Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(amount_textfield_for_payment_of_transaction_right.getText())){
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `student_transaction_record_system` where std_id=\""+student_id_textfield_for_payment_of_transaction_right.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `student_transaction_record_system` SET `amount_to_be_paid`=amount_to_be_paid-"+amount_textfield_for_payment_of_transaction_right.getText()+",`total_paid_amount`=total_paid_amount+"+amount_textfield_for_payment_of_transaction_right.getText()+" WHERE std_id=\""+student_id_textfield_for_payment_of_transaction_right.getText().toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Paid!");
                            clearButtonForPayementOfTransactionRightButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Sorry! Student ID is not in the record!\n");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Amount Must be in Number!");
                }
            }
        }
    }
    public void clearButtonForPayementOfTransactionRightButtonClickedListener(ActionEvent ae){
        student_id_textfield_for_payment_of_transaction_right.setText("");
        amount_textfield_for_payment_of_transaction_right.setText("");
        FillTransactionInformationTable();
    }
    
    
    
    
    
    
    public void resetButtonForStudentIDOfTransactionMiddleButtonClickedListener(ActionEvent ae){
        if(student_id_textfield_for_transaction_table_of_transaction_middle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to reset amount of given student ID?","Student Transaction Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM `student_transaction_record_system` where std_id=\""+student_id_textfield_for_transaction_table_of_transaction_middle.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("UPDATE `student_transaction_record_system` SET `amount_to_be_paid`=0,`total_paid_amount`=0 WHERE std_id=\""+student_id_textfield_for_transaction_table_of_transaction_middle.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Reset!");
                        clearButtonForStudentIDOfTransactionMiddleButtonClickedListener(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry! Student ID is not in the record!\n");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void clearButtonForStudentIDOfTransactionMiddleButtonClickedListener(ActionEvent ae){
        student_id_textfield_for_transaction_table_of_transaction_middle.setText("");
        FillTransactionInformationTable();
    }
    
    
    
    
    public void clearButtonOfSearchByStudentNameOfTransactionMiddleButtonClickedListener(ActionEvent ae){
        search_by_student_name_textfield_for_table_of_transaction_middle.setText("");
        FillTransactionInformationTable();
    }
            
            
    public void SearchByStudentNameTextfieldForTableOfTransactionMiddleKeyPressedListener(KeyEvent ke){
        student_id_tablecolumn_of_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_name_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        program_id_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        program_name_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        hostel_status_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        amount_to_be_paid_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        paid_amount_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        transaction_tableview_of_transaction_middle.setItems(getValuesForTransactionInformation(search_by_student_name_textfield_for_table_of_transaction_middle.getText().toUpperCase()));
    }
    
    private ObservableList<AdmissionInformation> getValuesForTransactionInformation(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `student_registration_info` where leave_date is null and student_id like \""+value+"%\"");
            while(rs.next()){          
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("SELECT * FROM `application_form_details` where aid=\""+rs.getString("applicant_id")+"\"");
                if(rss.next()){
                    Statement stv=conn.createStatement();
                    ResultSet rsv=stv.executeQuery("select * from program_info where title=\""+rss.getString("selected_program")+"\"");
                    Statement stst=conn.createStatement();
                    ResultSet rsrs=stst.executeQuery("select * from room_assignation_leaving_details where std_id=\""+rs.getString("student_id")+"\"");
                    String status="";
                    if(rsrs.next()){
                        status="Yes";
                    }else{
                        status="No";
                    }
                    if(rsv.next()){
                        Statement stm=conn.createStatement();
                        ResultSet rtm=stm.executeQuery("SELECT * FROM `student_transaction_record_system` where std_id=\""+rs.getString("student_id")+"\"");
                        if(rtm.next()){
                            list.add(new AdmissionInformation(rs.getString("student_id"),rss.getString("full_name"),rsv.getString("program_id"),rsv.getString("title"),status,String.valueOf(rtm.getInt("amount_to_be_paid")),String.valueOf(rtm.getInt("total_paid_amount"))));                   
                        }                      
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
    
    
    
    private void FillTransactionInformationTable(){
        student_id_tablecolumn_of_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_name_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        program_id_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        program_name_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        hostel_status_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        amount_to_be_paid_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        paid_amount_tablecolumn_for_transaction_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        transaction_tableview_of_transaction_middle.setItems(getValuesForTransactionInformation());
        transaction_tableview_of_transaction_middle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
               try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM `student_registration_info` where student_id=\""+transaction_tableview_of_transaction_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase()+"\"");
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

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    private void FillTableTransactionInitiallyIfNoInputIsMade(){      
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from student_transaction_record_system");
            if(!rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("SELECT * FROM `student_registration_info`");
                while(rss.next()){
                    Statement stv=conn.createStatement();
                    stv.executeUpdate("INSERT INTO `student_transaction_record_system`(`std_id`, `amount_to_be_paid`, `total_paid_amount`) VALUES ("
                            + "\""+rss.getString("student_id")+"\",0,0);");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private ObservableList<AdmissionInformation> getValuesForTransactionInformation(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `student_registration_info` where leave_date is null");
            while(rs.next()){          
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("SELECT * FROM `application_form_details` where aid=\""+rs.getString("applicant_id")+"\"");
                if(rss.next()){
                    Statement stv=conn.createStatement();
                    ResultSet rsv=stv.executeQuery("select * from program_info where title=\""+rss.getString("selected_program")+"\"");
                    Statement stst=conn.createStatement();
                    ResultSet rsrs=stst.executeQuery("select * from room_assignation_leaving_details where std_id=\""+rs.getString("student_id")+"\"");
                    String status="";
                    if(rsrs.next()){
                        status="Yes";
                    }else{
                        status="No";
                    }
                    if(rsv.next()){
                        Statement stm=conn.createStatement();
                        ResultSet rtm=stm.executeQuery("SELECT * FROM `student_transaction_record_system` where std_id=\""+rs.getString("student_id")+"\"");
                        if(rtm.next()){
                            list.add(new AdmissionInformation(rs.getString("student_id"),rss.getString("full_name"),rsv.getString("program_id"),rsv.getString("title"),status,String.valueOf(rtm.getInt("amount_to_be_paid")),String.valueOf(rtm.getInt("total_paid_amount"))));                   
                        }                      
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
    
    @FXML
    public void ResetButtonForStudentIDofTransactionMiddleForTransactionbuttonEntered(MouseEvent me){
        reset_button_for_student_id_of_transaction_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ResetButtonForStudentIDofTransactionMiddleForTransactionbuttonExited(MouseEvent me){
        reset_button_for_student_id_of_transaction_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void ClearButtonOfSearchByStudentNameofTransactionMiddleForTransactionbuttonEntered(MouseEvent me){
        clear_button_of_search_by_student_name_of_transaction_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonOfSearchByStudentNameofTransactionMiddleForTransactionbuttonExited(MouseEvent me){
        clear_button_of_search_by_student_name_of_transaction_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void ClearButtonForStudentIDofTransactionMiddleForTransactionbuttonEntered(MouseEvent me){
        clear_button_for_student_id_of_transaction_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForStudentIDofTransactionMiddleForTransactionbuttonExited(MouseEvent me){
        clear_button_for_student_id_of_transaction_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void InsertCorrespondingAmountToTheTableButtonofTransactionMiddleForTransactionbuttonEntered(MouseEvent me){
        insert_corresponding_amount_to_the_table_button_of_transaction_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void InsertCorrespondingAmountToTheTableButtonofTransactionMiddleForTransactionbuttonExited(MouseEvent me){
        insert_corresponding_amount_to_the_table_button_of_transaction_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void ClearAllTheTablePaymentButtonofTransactionMiddleForTransactionbuttonEntered(MouseEvent me){
        clear_all_the_table_payment_button_of_transaction_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearAllTheTablePaymentButtonofTransactionMiddleForTransactionbuttonExited(MouseEvent me){
        clear_all_the_table_payment_button_of_transaction_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void PayButtonForPaymentofTransactionRightForTransactionbuttonEntered(MouseEvent me){
        pay_button_for_payment_of_transaction_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void PayButtonForPaymentofTransactionRightForTransactionbuttonExited(MouseEvent me){
        pay_button_for_payment_of_transaction_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void ClearButtonForPaymentofTransactionRightForTransactionbuttonEntered(MouseEvent me){
        clear_button_for_payment_of_transaction_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForPaymentofTransactionRightForTransactionbuttonExited(MouseEvent me){
        clear_button_for_payment_of_transaction_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void InsertButtonForInsertExtraAmountToBePaidofTransactionRightForTransactionbuttonEntered(MouseEvent me){
        insert_button_for_insert_extra_amount_to_be_paid_of_transaction_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void InsertButtonForInsertExtraAmountToBePaidofTransactionRightForTransactionbuttonExited(MouseEvent me){
        insert_button_for_insert_extra_amount_to_be_paid_of_transaction_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    @FXML
    public void ClearButtonForInsertExtraAmountToBePaidofTransactionRightForTransactionbuttonEntered(MouseEvent me){
        clear_button_for_insert_extra_amount_to_be_paid_of_transaction_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForInsertExtraAmountToBePaidofTransactionRightForTransactionbuttonExited(MouseEvent me){
        clear_button_for_insert_extra_amount_to_be_paid_of_transaction_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    } 
    
    
    
    
    
    
    
    
    
    
    
    //fees structure methods and events 
    
    
    
    public void editButtonForEditFeesForFeesStructureMiddleButtonClickedListener(ActionEvent ae){
        if(program_id_plus_name_choose_for_edit_fees.getValue()==null||fees_types_choose_for_edit_fees.getValue()==null||amount_tution_fee_textfield_for_edit_fees.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to edit the student fees per year?","Fees Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(amount_tution_fee_textfield_for_edit_fees.getText())){
                    try {
                        String str=new String(program_id_plus_name_choose_for_edit_fees.getValue());
                        String[] spt=str.split("\\+");
                        System.out.println(spt[0]);
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pid=\""+spt[0].toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            if(fees_types_choose_for_edit_fees.getValue().equals("Academic Fees")){
                                stt.executeUpdate("UPDATE `fees_structure_information_record` SET `academic_fees`=\""+amount_tution_fee_textfield_for_edit_fees.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            }
                            if(fees_types_choose_for_edit_fees.getValue().equals("Research Fees")){
                                stt.executeUpdate("UPDATE `fees_structure_information_record` SET `research_fees`=\""+amount_tution_fee_textfield_for_edit_fees.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            }
                            if(fees_types_choose_for_edit_fees.getValue().equals("Student Services and Amenties Fees")){
                                stt.executeUpdate("UPDATE `fees_structure_information_record` SET `student_services`=\""+amount_tution_fee_textfield_for_edit_fees.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            }
                            if(fees_types_choose_for_edit_fees.getValue().equals("Student Health Cover fees")){
                                stt.executeUpdate("UPDATE `fees_structure_information_record` SET `student_health`=\""+amount_tution_fee_textfield_for_edit_fees.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            }
                            if(fees_types_choose_for_edit_fees.getValue().equals("Cost of Living or Hostel Fees")){
                                stt.executeUpdate("UPDATE `fees_structure_information_record` SET `cost_of_living`=\""+amount_tution_fee_textfield_for_edit_fees.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            }
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the Database");
                            clearButtonForEditFeesForFeesStructureMiddleButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Program ID doesn't found!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Amount must be in Number!");
                }
            }
        }
    }
    public void clearButtonForEditFeesForFeesStructureMiddleButtonClickedListener(ActionEvent ae){
        amount_tution_fee_textfield_for_edit_fees.setText("");
        FillFeesInformationTablePerYear();
    }
    
    public void addButtonForCostOfLivingOrHostelFeesPerYearButtonClickedListener(ActionEvent ae){
        if(program_id_plus_name_choose_for_cost_of_living_or_hostel_fees_per_year.getValue()==null||hostel_fee_textfield_for_cost_of_living_or_hostel_fees_per_year.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to add the student cost of living fees per year?","Fees Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(hostel_fee_textfield_for_cost_of_living_or_hostel_fees_per_year.getText())){
                    try {
                        String str=new String(program_id_plus_name_choose_for_cost_of_living_or_hostel_fees_per_year.getValue());
                        String[] spt=str.split("\\+");
                        System.out.println(spt[0]);
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pid=\""+spt[0].toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `fees_structure_information_record` SET `cost_of_living`=cost_of_living+\""+hostel_fee_textfield_for_cost_of_living_or_hostel_fees_per_year.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the Database");
                            clearButtonForCostOfLivingOrHostelFeesPerYearButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Program ID doesn't found!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Research fees must be in Number!");
                }
            }
        }
    }
    public void clearButtonForCostOfLivingOrHostelFeesPerYearButtonClickedListener(ActionEvent ae){
        hostel_fee_textfield_for_cost_of_living_or_hostel_fees_per_year.setText("");
        FillFeesInformationTablePerYear();
    }
    

    public void addButtonForStudentHealthCoverPerYearButtonClickedListener(ActionEvent ae){
        if(program_id_plus_name_choose_for_student_health_cover_per_year.getValue()==null||health_services_fee_textfield_for_student_health_cover_per_year.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to add the student health cover fees per year?","Fees Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(health_services_fee_textfield_for_student_health_cover_per_year.getText())){
                    try {
                        String str=new String(program_id_plus_name_choose_for_student_health_cover_per_year.getValue());
                        String[] spt=str.split("\\+");
                        System.out.println(spt[0]);
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pid=\""+spt[0].toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `fees_structure_information_record` SET `student_health`=student_health+\""+health_services_fee_textfield_for_student_health_cover_per_year.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the Database");
                            clearButtonForStudentHealthCoverPerYearButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Program ID doesn't found!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Research fees must be in Number!");
                }
            }
        }
    }
    public void clearButtonForStudentHealthCoverPerYearButtonClickedListener(ActionEvent ae){
        health_services_fee_textfield_for_student_health_cover_per_year.setText("");
        FillFeesInformationTablePerYear();
    }
    
    public void addButtonForStudentServicesAndAmentiesFeesPerYearButtonClickedListener(ActionEvent ae){
        if(program_id_plus_name_choose_student_services_and_amenies_fees_per_year.getValue()==null||student_services_fee_textfield_for_student_services_and_amenties_fees_per_year.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to add the student services and amenties fees per year?","Fees Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(student_services_fee_textfield_for_student_services_and_amenties_fees_per_year.getText())){
                    try {
                        String str=new String(program_id_plus_name_choose_student_services_and_amenies_fees_per_year.getValue());
                        String[] spt=str.split("\\+");
                        System.out.println(spt[0]);
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pid=\""+spt[0].toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `fees_structure_information_record` SET `student_services`=student_services+\""+student_services_fee_textfield_for_student_services_and_amenties_fees_per_year.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the Database");
                            clearButtonForStudentServicesAndAmentiesFeesPerYearButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Program ID doesn't found!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Research fees must be in Number!");
                }
            }
        }
    }
    public void clearButtonForStudentServicesAndAmentiesFeesPerYearButtonClickedListener(ActionEvent ae){
        student_services_fee_textfield_for_student_services_and_amenties_fees_per_year.setText("");
        FillFeesInformationTablePerYear();
    }
            
            
    public void addButtonForResearchFeesPerYearButtonClickedListener(ActionEvent ae){
        if(program_id_plus_name_choose_for_research_fees_per_year.getValue()==null||research_fees_textfield_for_research_fees_per_year.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to add the research fees per year?","Fees Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(research_fees_textfield_for_research_fees_per_year.getText())){
                    try {
                        String str=new String(program_id_plus_name_choose_for_research_fees_per_year.getValue());
                        String[] spt=str.split("\\+");
                        System.out.println(spt[0]);
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pid=\""+spt[0].toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `fees_structure_information_record` SET `research_fees`=research_fees+\""+research_fees_textfield_for_research_fees_per_year.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the Database");
                            clearButtonForResearchFeesPerYearButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Program ID doesn't found!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Research fees must be in Number!");
                }
            }
        }
    }
    public void clearButtonForResearchFeesPerYearButtonClickedListener(ActionEvent ae){
        research_fees_textfield_for_research_fees_per_year.setText("");
        FillFeesInformationTablePerYear();
    }
            
            
    public void addButtonForAcademicFeesPerYearButtonClickedListener(ActionEvent ae){
        if(tution_fees_textfield_for_academic_fees_per_year.getText().equals("")||academic_fees_per_year_program_id_plus_name_choose_AFPY.getValue()==null){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to add the academic fees per year?","Fees Information Record",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(tution_fees_textfield_for_academic_fees_per_year.getText())){
                    try {
                        String str=new String(academic_fees_per_year_program_id_plus_name_choose_AFPY.getValue());
                        String[] spt=str.split("\\+");
                        System.out.println(spt[0]);
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pid=\""+spt[0].toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `fees_structure_information_record` SET `academic_fees`=academic_fees+\""+tution_fees_textfield_for_academic_fees_per_year.getText()+"\" WHERE pid=\""+spt[0].toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the Database");
                            clearButtonForAcademicFeesPerYearButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "Program ID doesn't found!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Tution fees must be in Number!");
                }
            }
        }
    }
    public void clearButtonForAcademicFeesPerYearButtonClickedListener(ActionEvent ae){
        tution_fees_textfield_for_academic_fees_per_year.setText("");
        FillFeesInformationTablePerYear();
    }
    
    public void ClearSearchByProgramNameMiddleFeesStructureButtonClickedListener(ActionEvent ae){
        search_by_program_name_textfield_middle_fees_structure.setText("");
        FillFeesInformationTablePerYear();
    }
    
    @FXML
    public void SearchByProgramNameMiddleFeesStructurSearchKeyPressedEventListener(KeyEvent ke){
        program_id_tablecolumn_middle_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_middle_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        academic_fees_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        research_fees_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        student_services_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("email"));
        student_health_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        cost_of_living_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        fees_information_per_year_tableview_middle_fee_structure.setItems(getValuesForFeesInformationPerYear(search_by_program_name_textfield_middle_fees_structure.getText()));
    }
    
    private ObservableList<AdmissionInformation> getValuesForFeesInformationPerYear(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record` where pname like \""+value+"%\"");
            while(rs.next()){             
                list.add(new AdmissionInformation(rs.getString("pid"),rs.getString("pname"),String.valueOf(rs.getInt("academic_fees")),String.valueOf(rs.getInt("research_fees")),String.valueOf(rs.getInt("student_services")),String.valueOf(rs.getInt("student_health")),String.valueOf(rs.getInt("cost_of_living"))));                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void FillFeesInformationTablePerYear(){
        program_id_tablecolumn_middle_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_middle_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        academic_fees_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        research_fees_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        student_services_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("email"));
        student_health_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        cost_of_living_tablecolumn_fees_information_per_year.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        fees_information_per_year_tableview_middle_fee_structure.setItems(getValuesForFeesInformationPerYear());
    }
    
    private ObservableList<AdmissionInformation> getValuesForFeesInformationPerYear(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `fees_structure_information_record`");
            while(rs.next()){             
                list.add(new AdmissionInformation(rs.getString("pid"),rs.getString("pname"),String.valueOf(rs.getInt("academic_fees")),String.valueOf(rs.getInt("research_fees")),String.valueOf(rs.getInt("student_services")),String.valueOf(rs.getInt("student_health")),String.valueOf(rs.getInt("cost_of_living"))));                              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    private void FillTableInitiallyIfNoInputIsMade(){      
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from fees_structure_information_record");
            if(!rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select * from program_info");
                while(rss.next()){
                    Statement stv=conn.createStatement();
                    stv.executeUpdate("INSERT INTO `fees_structure_information_record`(`pid`, `pname`, `academic_fees`, `research_fees`, `student_services`, `student_health`, `cost_of_living`) VALUES ("
                            + "\""+rss.getString("program_id")+"\",\""+rss.getString("title")+"\",0,0,0,0,0)");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private ObservableList<String> GetAlltheProgramPlusID(){
        ObservableList<String> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from program_info");
            while(rs.next()){
                list.add(rs.getString("program_id")+"+"+rs.getString("title"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeesManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
   
    
    @FXML
    public void FeesStructureButtonFromMainChooserbuttonEntered(MouseEvent me){
        fees_structure_button_from_main_chooser.setStyle("-fx-background-color:#530488;");
    }
    @FXML
    public void FeesStructureButtonFromMainChooserbuttonExited(MouseEvent me){
        fees_structure_button_from_main_chooser.setStyle("-fx-background-color:#408080;");
    }
    @FXML
    public void TransactionButtonFromMainChooserbuttonEntered(MouseEvent me){
        transaction_button_from_main_chooser.setStyle("-fx-background-color:#530488;");
    }
    @FXML
    public void TransactionButtonFromMainChooserbuttonExited(MouseEvent me){
        transaction_button_from_main_chooser.setStyle("-fx-background-color:#408080;");
    }
    
    
    
    @FXML
    public void EditButtonForEditFeesbuttonEntered(MouseEvent me){
        edit_button_for_edit_fees.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void EditButtonForEditFeesbuttonExited(MouseEvent me){
        edit_button_for_edit_fees.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForEditFeesbuttonEntered(MouseEvent me){
        clear_button_for_edit_fees.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForEditFeesbuttonExited(MouseEvent me){
        clear_button_for_edit_fees.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForAcademicFeesPerYearForFeesStructurebuttonEntered(MouseEvent me){
        add_button_for_academic_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForAcademicFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        add_button_for_academic_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForAcademicFeesPerYearForFeesStructurebuttonEntered(MouseEvent me){
        clear_button_for_academic_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForAcademicFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        clear_button_for_academic_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForResearchFeesPerYearForFeesStructurebuttonEntered(MouseEvent me){
        add_button_for_research_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForResearchFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        add_button_for_research_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForResearchFeesPerYearForFeesStructurebuttonEntered(MouseEvent me){
        clear_button_for_research_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForResearchFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        clear_button_for_research_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForStudentServicesAndAmentiesFeesPerYearFeesStructurebuttonEntered(MouseEvent me){
        add_button_for_student_services_and_amenties_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForStudentServicesAndAmentiesFeesPerYearFeesStructurebuttonExited(MouseEvent me){
        add_button_for_student_services_and_amenties_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForStudentServicesAndAmentiesFeesPerYearFeesStructurebuttonEntered(MouseEvent me){
        clear_button_for_student_services_and_amenties_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForStudentServicesAndAmentiesFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        clear_button_for_student_services_and_amenties_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForStudentHealthCoverPerYearForFeesStructurebuttonEntered(MouseEvent me){
        add_button_for_student_health_cover_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForStudentHealthCoverPerYearForFeesStructurebuttonExited(MouseEvent me){
        add_button_for_student_health_cover_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForStudentHealthCoverPerYearForFeesStructurebuttonEntered(MouseEvent me){
        clear_button_for_student_health_cover_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForStudentHealthCoverPerYearForFeesStructurebuttonExited(MouseEvent me){
        clear_button_for_student_health_cover_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForCostOfLivingOrHostelFeesPerYearForFeesStructurebuttonEntered(MouseEvent me){
        add_button_for_cost_of_living_or_hostel_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonForCostOfLivingOrHostelFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        add_button_for_cost_of_living_or_hostel_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForCostOfLivingOrHostelFeesPerYearForFeesStructurebuttonEntered(MouseEvent me){
        clear_button_for_cost_of_living_or_hostel_fees_per_year.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonForCostOfLivingOrHostelFeesPerYearForFeesStructurebuttonExited(MouseEvent me){
        clear_button_for_cost_of_living_or_hostel_fees_per_year.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
   
    @FXML
    public void ClearSearchByProgramNameMiddleForFeesStructurebuttonEntered(MouseEvent me){
        clear_search_by_program_name_middle_fees_structure.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearSearchByProgramNameMiddleForFeesStructurebuttonExited(MouseEvent me){
        clear_search_by_program_name_middle_fees_structure.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }      
}

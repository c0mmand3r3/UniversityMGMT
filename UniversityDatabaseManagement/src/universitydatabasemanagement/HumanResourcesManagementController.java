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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
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
public class HumanResourcesManagementController implements Initializable {

    @FXML
    private Button employee_button_choosefirst;
    @FXML
    private Button attendance_button_choosefirst;
    @FXML
    private Button status_button_choosefirst;
    @FXML
    private Button salary_button_choosefirst;
    @FXML
    private AnchorPane employee_anchorpane_middle;
    @FXML
    private TableView<AdmissionInformation> employee_table_tableview_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> id_tablecolumn_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> name_tablecolumn_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> contact_tablecolumn_tableview_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> email_tablecolumn_tableview_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> job_tablecolumn_tableview_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> department_tablecolumn_tableview_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> type_tablecolumn_tableview_employee_table_employee_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> status_tablecolumn_tableview_employee_table_employee_middle;
    @FXML
    private TextField search_employee_name_textfield_employee_middle;
    private Button edit_button_employee_middle;
    @FXML
    private Button delete_button_employee_middle;
    @FXML
    private Button clear_button_employee_middle_search;
    @FXML
    private TextField employee_id_textfield_employee_middle;
    @FXML
    private Button clear_button_employee_middle_EID;
    @FXML
    private AnchorPane employee_anchorpane_right;
    @FXML
    private TextField first_name_textfield_employee_right;
    @FXML
    private TextField last_name_textfield_employee_right;
    @FXML
    private TextField employee_id_no_textfield_employee_right;
    @FXML
    private TextField contact_no_textfield_employee_right;
    @FXML
    private TextField email_textfield_employee_right;
    @FXML
    private TextField job_title_textfield_employee_right;
    @FXML
    private TextField department_textfield_employee_right;
    @FXML
    private ChoiceBox<String> employee_type_choose_employee_right;
    @FXML
    private ComboBox<Integer> start_date_year_employee_right;
    @FXML
    private ComboBox<Integer> start_date_month_employee_right;
    @FXML
    private ComboBox<Integer> start_date_day_employee_right;
    @FXML
    private TextArea education_details_textarea_employee_right;
    @FXML
    private TextArea work_history_textarea_employee_right;
    @FXML
    private Button clear_button_employee_right;
    @FXML
    private Button add_button_employee_right;
    @FXML
    private TableView<AdmissionInformation> attendance_record_tableview_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> date_tablecolumn_attendance_record_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> id_tablecolumn_attendance_record_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> employee_name_tablecolumn_attendance_record_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> status_tablecolumn_attendance_record_attendance_middle;
    @FXML
    private TableView<AdmissionInformation> employee_list_tableview_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> id_tablecolumn_employee_list_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> fullname_tablecolumn_employee_list_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> jobtitle_tablecolumn_employee_list_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> department_tablecolumn_employee_list_attendance_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> type_tablecolumn_employee_list_attendance_middle;
    @FXML
    private TextField search_by_employee_name_text_attendance_middle;
    @FXML
    private Button delete_button_attendance_middle;
    @FXML
    private Button clear_button_attendance_middle_dateplusemployee;
    @FXML
    private TextField dateplusemployeeid_text_attendance_middle;
    @FXML
    private Button clear_button_attendance_middle_searchby;
    @FXML
    private Button clear_button_attendance_middle;
    @FXML
    private ComboBox<Integer> attendance_year_choose_attendance_right;
    @FXML
    private ComboBox<Integer> attendance_month_choose_attendance_right;
    @FXML
    private ComboBox<Integer> attendance_day_choose_attendance_right;
    @FXML
    private TextArea absent_list_textarea_attendance_right;
    @FXML
    private Button procced_button_attendance_right;
    @FXML
    private Button clear_button_attendance_right;
    @FXML
    private AnchorPane attendance_anchorpane_middle;
    @FXML
    private AnchorPane status_anchorpane_middle;
    @FXML
    private TableView<AdmissionInformation> employee_table_tableview_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> id_tablecolumn_employee_table_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> name_tablecolumn_employee_table_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> contact_tablecolumn_employee_table_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> job_title_tablecolumn_employee_table_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> department_tablecolumn_employee_table_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> type_tablecolumn_employee_table_status_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> status_tablecolumn_employee_table_status_middle;
    @FXML
    private TextField search_by_employee_name_textfield_status_middle;
    @FXML
    private Button clear_button_status_middle;
    @FXML
    private AnchorPane attendance_anchorpane_right;
    @FXML
    private AnchorPane status_anchorpane_right;
    @FXML
    private TextField employee_id_textfield_status_right;
    @FXML
    private Button terminate_button_status_right;
    @FXML
    private ComboBox<Integer> year_choose_status_right;
    @FXML
    private ComboBox<Integer> month_choose_status_right;
    @FXML
    private ComboBox<Integer> day_choose_status_right;
    @FXML
    private Button clear_button_status_right;
    @FXML
    private TextArea termination_reason_textarea_status_right;
    @FXML
    private AnchorPane salary_anchorpane_middle;
    @FXML
    private TableView<AdmissionInformation> employee_salary_list_tableview_salary_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> id_tablecolumn_employee_salary_list_salary_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> name_tablecolumn_employee_salary_list_salary_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> status_tablecolumn_employee_salary_list_salary_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> salary_tablecolumn_employee_salary_list_salary_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> amount_to_be_given_tablecolumn_employee_salary_list_salary_middle;
    @FXML
    private TableColumn<AdmissionInformation, String> total_given_amount_tablecolumn_employee_salary_list_salary_middle;
    @FXML
    private TextField search_by_employee_name_textfield_salary_middle;
    @FXML
    private Button clear_button_salary_middle_searchby;
    @FXML
    private Button add_corresponding_salary_for_payment_button_salary_middle;
    @FXML
    private TextField employee_id_textfield_payment_salary_middle;
    @FXML
    private TextField pay_textfield_payment_salary_middle;
    @FXML
    private Button clear_button_payment_salary_middle_payment;
    @FXML
    private Button pay_button_payment_salary_middle;
    @FXML
    private TextField salary_per_month_textfield_employee_right;
    @FXML
    private AnchorPane salary_anchorpane_right;
    @FXML
    private TextField employee_id_textfield_salary_right;
    @FXML
    private TextField salary_textfield_salary_right;
    @FXML
    private Button clear_button_salary_right;
    @FXML
    private Button edit_button_salary_right;
    private Connection conn;
    @FXML
    private TextField search_by_employee_name_text_attendance_middle1;
    @FXML
    private TextField employee_id_textfield_salary_right_Add_Certain_amount;
    @FXML
    private TextField amount_textfield_salary_right_add_certain_amount;
    @FXML
    private Button clear_button_salary_right_add_certain_amount;
    @FXML
    private Button add_button_salary_right;
    /**
     * initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        employee_anchorpane_middle.setVisible(true);
        employee_anchorpane_right.setVisible(true);

        attendance_anchorpane_middle.setVisible(false);
        attendance_anchorpane_right.setVisible(false);

        status_anchorpane_middle.setVisible(false);
        status_anchorpane_right.setVisible(false);

        salary_anchorpane_middle.setVisible(false);
        salary_anchorpane_right.setVisible(false);
        
        
        start_date_year_employee_right.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        start_date_day_employee_right.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        start_date_month_employee_right.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        attendance_year_choose_attendance_right.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        attendance_day_choose_attendance_right.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        attendance_month_choose_attendance_right.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        year_choose_status_right.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        day_choose_status_right.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        month_choose_status_right.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        employee_type_choose_employee_right.setItems(FXCollections.observableArrayList("Academic Staff","Employee-in-Training","Faculty","Limited Appointee","University Staff",
                    "Regular Classified Staff Employee",
                    "Extended Temporary Employee (ETE)",
                    "Temporary Employee",
                    "Part-Time Employee",
                    "On-Call Employee",
                    "Appointed Personnel Employee",
                    "Administrator",
                    "Faculty Member",
                    "Limited-Term Adjunct Faculty",
                    "Academic Professional",
                    "Service Professional",
                    "Postdoctoral Scholar"));
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
        FillEmployeeTableEmployeeMiddle();
        FillEmployeeListTableAttendanceMiddle();
    }    
    
    @FXML
    public void EmployeeButtonClickedListener(ActionEvent ae){
        employee_anchorpane_middle.setVisible(true);
        employee_anchorpane_right.setVisible(true);

        attendance_anchorpane_middle.setVisible(false);
        attendance_anchorpane_right.setVisible(false);

        status_anchorpane_middle.setVisible(false);
        status_anchorpane_right.setVisible(false);

        salary_anchorpane_middle.setVisible(false);
        salary_anchorpane_right.setVisible(false);
        FillEmployeeTableEmployeeMiddle();
    }
    @FXML
    public void AttendanceButtonClickedListener(ActionEvent ae){
        employee_anchorpane_middle.setVisible(false);
        employee_anchorpane_right.setVisible(false);

        attendance_anchorpane_middle.setVisible(true);
        attendance_anchorpane_right.setVisible(true);

        status_anchorpane_middle.setVisible(false);
        status_anchorpane_right.setVisible(false);

        salary_anchorpane_middle.setVisible(false);
        salary_anchorpane_right.setVisible(false);
        FillEmployeeListTableAttendanceMiddle();
        FillAttendanceTableAttendanceMiddle();
    }
    @FXML
    public void StatusButtonClickedListener(ActionEvent ae){
        employee_anchorpane_middle.setVisible(false);
        employee_anchorpane_right.setVisible(false);

        attendance_anchorpane_middle.setVisible(false);
        attendance_anchorpane_right.setVisible(false);

        status_anchorpane_middle.setVisible(true);
        status_anchorpane_right.setVisible(true);

        salary_anchorpane_middle.setVisible(false);
        salary_anchorpane_right.setVisible(false);
        FillEmployeeTableStatusMiddle();
    }
    @FXML
    public void SalaryButtonClickedListener(ActionEvent ae){
        employee_anchorpane_middle.setVisible(false);
        employee_anchorpane_right.setVisible(false);

        attendance_anchorpane_middle.setVisible(false);
        attendance_anchorpane_right.setVisible(false);

        status_anchorpane_middle.setVisible(false);
        status_anchorpane_right.setVisible(false);

        salary_anchorpane_middle.setVisible(true);
        salary_anchorpane_right.setVisible(true);
        FillEmployeeSalaryListTableSalaryMiddle();
        
    }
    
    
    //salary components and methods 
    
    public void AddButtonSalaryRightButtonClickedListenerSalaryRight(ActionEvent ae){
        if(employee_id_textfield_salary_right_Add_Certain_amount.getText().equals("")||amount_textfield_salary_right_add_certain_amount.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to edit the employee salary?","Employee Payment Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(amount_textfield_salary_right_add_certain_amount.getText())){
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from employee_salary_record where eid=\""+employee_id_textfield_salary_right_Add_Certain_amount.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `employee_salary_record` SET `amt_to_be_given`=amt_to_be_given+"+amount_textfield_salary_right_add_certain_amount.getText()+" where eid=\""+employee_id_textfield_salary_right_Add_Certain_amount.getText().toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Successfully Added!");
                            ClearButtonSalaryRightAddCertainAmountButtonClickedListenerSalaryRight(ae);
                            FillEmployeeSalaryListTableSalaryMiddle();
                        }else{
                            JOptionPane.showMessageDialog(null, "Employee ID doesn't existed in salary record!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Amount Format is not valid!");
                }
            }
        }
    }
    public void ClearButtonSalaryRightAddCertainAmountButtonClickedListenerSalaryRight(ActionEvent ae){
        employee_id_textfield_salary_right_Add_Certain_amount.setText("");
        amount_textfield_salary_right_add_certain_amount.setText("");
    }
    
    
   
    public void EditButtonSalaryRightButtonClickedListenerSalaryRight(ActionEvent ae){
        if(salary_textfield_salary_right.getText().equals("")||employee_id_textfield_salary_right.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to edit the employee salary?","Employee Payment Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(salary_textfield_salary_right.getText())){
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_id_textfield_salary_right.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `employee_information_record` SET salary="+salary_textfield_salary_right.getText()+" where eid=\""+employee_id_textfield_salary_right.getText().toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Salary Successfully Edited!");
                            ClearButtonSalaryRightButtonClickedListenerSalaryRight(ae);
                            FillEmployeeSalaryListTableSalaryMiddle();
                        }else{
                            JOptionPane.showMessageDialog(null, "Employee ID doesn't existed!");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Salary Format is not valid!");
                }
            }
        }
    }
    public void ClearButtonSalaryRightButtonClickedListenerSalaryRight(ActionEvent ae){
        employee_id_textfield_salary_right.setText("");
        salary_textfield_salary_right.setText("");
    }
    
    
    
    
    
    private boolean checkPaymentAmountValue(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    
    @FXML
    public void PayButtonPaymentSalaryMiddleButtonClickedListenerSalaryMiddle(ActionEvent ae){
        if(employee_id_textfield_payment_salary_middle.getText().equals("")||pay_textfield_payment_salary_middle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to pay the employee?","Employee Payment Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkPaymentAmountValue(pay_textfield_payment_salary_middle.getText())){
                    try{                       
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from employee_salary_record where eid=\""+employee_id_textfield_payment_salary_middle.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("UPDATE `employee_salary_record` SET `total_amt_given`=total_amt_given+"+pay_textfield_payment_salary_middle.getText()+",amt_to_be_given=amt_to_be_given-"+pay_textfield_payment_salary_middle.getText()+ " where eid=\""+employee_id_textfield_payment_salary_middle.getText().toUpperCase()+"\"");
                            JOptionPane.showMessageDialog(null, "Successfully Paid to the employee!");
                            FillEmployeeSalaryListTableSalaryMiddle();
                            ClearButtonPaymentSalaryMiddleButtonClickedListenerSalaryMiddle(ae);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }else{
                    JOptionPane.showMessageDialog(null, "Pay Amount must be in number!");
                }
            }
        }
    }
    
    
    @FXML
    public void ClearButtonPaymentSalaryMiddleButtonClickedListenerSalaryMiddle(ActionEvent ae){
        employee_id_textfield_payment_salary_middle.setText("");
        pay_textfield_payment_salary_middle.setText("");
    }
    
    
    
    
    @FXML
    public void AddCorrespondingSalaryForPaymentButtonClickedListenerSalaryMiddle(ActionEvent ae){
        int val=JOptionPane.showConfirmDialog(null,"Do you want to add corresponding salary to amount to\n be given column of recruited status employee?","Employee Salary Record Information",JOptionPane.YES_NO_OPTION);
        if(val==0){
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select * from employee_information_record");
                while(rs.next()){
                    if(rs.getDate("end_date")==null){
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("select * from employee_salary_record where eid=\""+rs.getString("eid")+"\"");
                        if(rss.next()){
                            Statement stv=conn.createStatement();
                            stv.executeUpdate("UPDATE `employee_salary_record` SET `amt_to_be_given`=amt_to_be_given+"+rs.getInt("salary")+" where eid=\""+rs.getString("eid")+"\"");
                            JOptionPane.showMessageDialog(null, "Process Completed!");
                            FillEmployeeSalaryListTableSalaryMiddle();
                        }
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    @FXML
    public void ClearButtonSalaryMiddleSearchByButtonClickedListenerSalaryMiddle(ActionEvent ae){
        search_by_employee_name_textfield_salary_middle.setText("");
        FillEmployeeSalaryListTableSalaryMiddle();
    }
    
    
    
    @FXML
    public void SearchByEmployeeNameEmployeeSalaryTableFillKeyPressedEventListenerTextfieldSalaryMiddle(KeyEvent ke){
        id_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        status_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        salary_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        amount_to_be_given_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        total_given_amount_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        employee_salary_list_tableview_salary_middle.setItems(getValuesForEmployeeSalaryListSalaryMiddle(search_by_employee_name_textfield_salary_middle.getText()));
    }
    
    
    
    
    private ObservableList<AdmissionInformation> getValuesForEmployeeSalaryListSalaryMiddle(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement stt=conn.createStatement();
            ResultSet rss=stt.executeQuery("select * from employee_information_record where name like \""+value+"%\"");
            while(rss.next()){
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("SELECT * FROM `employee_salary_record` where eid=\""+rss.getString("eid")+"\"");
                
                if(rs.next()){
                   list.add(new AdmissionInformation(rs.getString("eid"),rss.getString("name"),rss.getString("status"),String.valueOf(rss.getInt("salary")),String.valueOf(rs.getInt("amt_to_be_given")),String.valueOf(rs.getInt("total_amt_given")))); 
                }              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private ObservableList<AdmissionInformation> getValuesForEmployeeSalaryListSalaryMiddle(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_salary_record`");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select * from employee_information_record where eid=\""+rs.getString("eid")+"\"");
                if(rss.next()){
                   list.add(new AdmissionInformation(rs.getString("eid"),rss.getString("name"),rss.getString("status"),String.valueOf(rss.getInt("salary")),String.valueOf(rs.getInt("amt_to_be_given")),String.valueOf(rs.getInt("total_amt_given")))); 
                }              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void FillEmployeeSalaryListTableSalaryMiddle(){
        id_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        status_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        salary_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        amount_to_be_given_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        total_given_amount_tablecolumn_employee_salary_list_salary_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        employee_salary_list_tableview_salary_middle.setItems(getValuesForEmployeeSalaryListSalaryMiddle());
        employee_salary_list_tableview_salary_middle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
               try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_salary_list_tableview_salary_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase()+"\"");
                    if(rs.next()){
                        if(rs.getDate("end_date")==null){
                            JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                    + "Employee ID : "+rs.getString("eid")+"\n"
                                    + "Employee Name : "+rs.getString("name")+"\n"
                                    + "Contact No. : "+rs.getString("contact")+"\n"
                                    + "Email : "+rs.getString("Email")+"\n"
                                    + "Job Title : "+rs.getString("job_title")+"\n"
                                    + "Department : "+rs.getString("department")+"\n"
                                    + "Employement Type : "+rs.getString("employee_type")+"\n"
                                    + "Employement Date :  "+rs.getString("start_date").toString()+"\n"
                                    + "Education Details : "+rs.getString("education_details")+"\n"
                                    + "Work History : "+rs.getString("work_history")+"\n"
                                    + "Salary : "+rs.getString("salary")+"\n"
                                    + "Status : "+rs.getString("status")+"\n"
                                );
                        }else{
                            JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                    + "Employee ID : "+rs.getString("eid")+"\n"
                                    + "Employee Name : "+rs.getString("name")+"\n"
                                    + "Contact No. : "+rs.getString("contact")+"\n"
                                    + "Email : "+rs.getString("Email")+"\n"
                                    + "Job Title : "+rs.getString("job_title")+"\n"
                                    + "Department : "+rs.getString("department")+"\n"
                                    + "Employement Type : "+rs.getString("employee_type")+"\n"
                                    + "Employement Date :  "+rs.getString("start_date").toString()+"\n"
                                    + "Termination Date :  "+rs.getString("end_date").toString()+"\n"
                                    + "Termination Reason :  "+rs.getString("termination_reason").toString()+"\n"
                                    + "Education Details : "+rs.getString("education_details")+"\n"
                                    + "Work History : "+rs.getString("work_history")+"\n"
                                    + "Salary : "+rs.getString("salary")+"\n"
                                    + "Status : "+rs.getString("status")+"\n"
                                );
                        }    
                        employee_id_textfield_payment_salary_middle.setText(employee_salary_list_tableview_salary_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase());
                        employee_id_textfield_salary_right.setText(employee_salary_list_tableview_salary_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase());
                        employee_id_textfield_salary_right_Add_Certain_amount.setText(employee_salary_list_tableview_salary_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    
    
    
    
    
    
    
    
    
    @FXML
     public void ClearButtonSalaryRightbuttonEnteredSalaryRight(MouseEvent me){
        clear_button_salary_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonSalaryRightbuttonExitedSalaryRight(MouseEvent me){
        clear_button_salary_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void EditButtonSalaryRightbuttonEnteredSalaryRight(MouseEvent me){
        edit_button_salary_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void EditButtonSalaryRightbuttonExitedSalaryRight(MouseEvent me){
        edit_button_salary_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonSalaryRightAddCertainAmountbuttonEnteredSalaryRight(MouseEvent me){
        clear_button_salary_right_add_certain_amount.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonSalaryRightAddCertainAmountbuttonExitedSalaryRight(MouseEvent me){
        clear_button_salary_right_add_certain_amount.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonSalaryRightbuttonEnteredSalaryRight(MouseEvent me){
        add_button_salary_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddButtonSalaryRightbuttonExitedSalaryRight(MouseEvent me){
        add_button_salary_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    @FXML
     public void ClearButtonSearchBySalaryMiddlebuttonEnteredSalaryMiddle(MouseEvent me){
        clear_button_salary_middle_searchby.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonSearchBySalaryMiddlebuttonExitedSalaryMiddle(MouseEvent me){
        clear_button_salary_middle_searchby.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void AddCorrespondingSalaryForPaymentSalaryMiddlebuttonEnteredSalaryMiddle(MouseEvent me){
        add_corresponding_salary_for_payment_button_salary_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddCorrespondingSalaryForPaymentSalaryMiddlebuttonExitedSalaryMiddle(MouseEvent me){
        add_corresponding_salary_for_payment_button_salary_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonPaymentSalaryMiddlebuttonEnteredSalaryMiddle(MouseEvent me){
        clear_button_payment_salary_middle_payment.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearButtonPaymentSalaryMiddlebuttonExitedSalaryMiddle(MouseEvent me){
        clear_button_payment_salary_middle_payment.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void PayButtonPayementSalaryMiddlebuttonEnteredSalaryMiddle(MouseEvent me){
        pay_button_payment_salary_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void PayButtonPaymentSalaryMiddlebuttonExitedSalaryMiddle(MouseEvent me){
        pay_button_payment_salary_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //status components and methods
    
    
    @FXML
    public void terminateButtonStatusRightButtonClickedListenerStatusRight(ActionEvent ae){
        if(employee_id_textfield_status_right.getText().equals("")||termination_reason_textarea_status_right.getText().equals("")||
                String.valueOf(year_choose_status_right.getValue()).equals("null")||String.valueOf(month_choose_status_right.getValue()).equals("null")||
                String.valueOf(day_choose_status_right.getValue()).equals("null")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Terminate the Employee?","Employee Termination Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_id_textfield_status_right.getText().toUpperCase()+"\" and end_date is null");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("UPDATE `employee_information_record` SET `end_date`=\'"+year_choose_status_right.getValue().toString()+"-"+month_choose_status_right.getValue().toString()+"-"+day_choose_status_right.getValue().toString()+"\',`termination_reason`=\""
                                + termination_reason_textarea_status_right.getText()+"\",`status`=\"Terminated\" WHERE eid=\""+employee_id_textfield_status_right.getText().toUpperCase()+"\" and end_date is null");
                        JOptionPane.showMessageDialog(null, "Sucessfully Terminated!");
                        FillEmployeeTableStatusMiddle();
                        clearButtonStatusRightButtonClickedListenerStatusRight(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Employee ID may be invalid or Employee is already Terminated!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButtonStatusRightButtonClickedListenerStatusRight(ActionEvent ae){
        employee_id_textfield_status_right.setText("");
        termination_reason_textarea_status_right.setText("");
    }
    
    
    
    @FXML
    public void clearButtonStatusMiddleButtonClickedListenerStatusMiddle(ActionEvent ae){
        search_by_employee_name_textfield_status_middle.setText("");
        FillEmployeeTableStatusMiddle();
    }
    
    
    @FXML
    public void searchByEmployeeNameTextFieldStatusMiddleKeyPressedListenerStatusMiddle(KeyEvent ke){
        id_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        contact_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        job_title_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        department_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        type_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        status_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        employee_table_tableview_status_middle.setItems(getValuesForEmployeeListStatusMiddle(search_by_employee_name_textfield_status_middle.getText()));
    }
    
    
    private ObservableList<AdmissionInformation> getValuesForEmployeeListStatusMiddle(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_information_record` where name like \""+value+"%\"");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("eid"),rs.getString("name"),rs.getString("contact"),rs.getString("job_title"),rs.getString("department"),rs.getString("employee_type"),rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private ObservableList<AdmissionInformation> getValuesForEmployeeListStatusMiddle(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_information_record`");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("eid"),rs.getString("name"),rs.getString("contact"),rs.getString("job_title"),rs.getString("department"),rs.getString("employee_type"),rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void FillEmployeeTableStatusMiddle(){
        id_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        contact_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        job_title_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        department_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        type_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        status_tablecolumn_employee_table_status_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        employee_table_tableview_status_middle.setItems(getValuesForEmployeeListStatusMiddle());
        employee_table_tableview_status_middle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
               try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_table_tableview_status_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase()+"\"");
                    if(rs.next()){
                        if(rs.getDate("end_date")==null){
                            JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                    + "Employee ID : "+rs.getString("eid")+"\n"
                                    + "Employee Name : "+rs.getString("name")+"\n"
                                    + "Contact No. : "+rs.getString("contact")+"\n"
                                    + "Email : "+rs.getString("Email")+"\n"
                                    + "Job Title : "+rs.getString("job_title")+"\n"
                                    + "Department : "+rs.getString("department")+"\n"
                                    + "Employement Type : "+rs.getString("employee_type")+"\n"
                                    + "Employement Date :  "+rs.getString("start_date").toString()+"\n"
                                    + "Education Details : "+rs.getString("education_details")+"\n"
                                    + "Work History : "+rs.getString("work_history")+"\n"
                                    + "Salary : "+rs.getString("salary")+"\n"
                                    + "Status : "+rs.getString("status")+"\n"
                                );
                        }else{
                            JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                    + "Employee ID : "+rs.getString("eid")+"\n"
                                    + "Employee Name : "+rs.getString("name")+"\n"
                                    + "Contact No. : "+rs.getString("contact")+"\n"
                                    + "Email : "+rs.getString("Email")+"\n"
                                    + "Job Title : "+rs.getString("job_title")+"\n"
                                    + "Department : "+rs.getString("department")+"\n"
                                    + "Employement Type : "+rs.getString("employee_type")+"\n"
                                    + "Employement Date :  "+rs.getString("start_date").toString()+"\n"
                                    + "Termination Date :  "+rs.getString("end_date").toString()+"\n"
                                    + "Termination Reason :  "+rs.getString("termination_reason").toString()+"\n"
                                    + "Education Details : "+rs.getString("education_details")+"\n"
                                    + "Work History : "+rs.getString("work_history")+"\n"
                                    + "Salary : "+rs.getString("salary")+"\n"
                                    + "Status : "+rs.getString("status")+"\n"
                                );
                        }
                        employee_id_textfield_status_right.setText(employee_table_tableview_status_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase());
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    
    
    
    
    
    
    
    
    @FXML
    public void clearbuttonEnteredStatusMiddle(MouseEvent me){
        clear_button_status_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clearbuttonExitedStatusMiddle(MouseEvent me){
        clear_button_status_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void terminatebuttonEnteredStatusRight(MouseEvent me){
        terminate_button_status_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void terminatebuttonExitedStatusRight(MouseEvent me){
        terminate_button_status_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void clearbuttonEnteredStatusRight(MouseEvent me){
        clear_button_status_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clearbuttonExitedStatusRight(MouseEvent me){
        clear_button_status_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    
    
    
    
    
    
    
    //attendance components and methods
    
    @FXML
    public void DeleteButtonClickedListenerAttendanceMiddle(ActionEvent ae){
        if(dateplusemployeeid_text_attendance_middle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please click the table value for the textfield to fill!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete the attendance?","Attendance Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    String str=dateplusemployeeid_text_attendance_middle.getText();
                    String[] words=str.split("\\+");
                    Statement st=conn.createStatement();
                    st.executeUpdate("DELETE FROM `employee_attendance_record` WHERE edate=\'"
                            +words[0]+ "\' and eid=\'"+words[1]+"\'");
                    JOptionPane.showMessageDialog(null, "Successfully Deleted from the record!");
                    FillAttendanceTableAttendanceMiddle();
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @FXML
    public void ClearButtonSearchByButtonClickedListenerAttendanceMiddle1(ActionEvent ae){
        search_by_employee_name_text_attendance_middle1.setText("");
        FillAttendanceTableAttendanceMiddle();
    }
    
    
    
    
    @FXML
    public void ClearButtonDatePlusEmployeeButtonClickedListenerAttendanceMiddle(ActionEvent ae){
        dateplusemployeeid_text_attendance_middle.setText("");
        FillAttendanceTableAttendanceMiddle();
    }
    
    @FXML
    public void FillAttendanceTableKeyPressedEventListenerAttendanceMiddle(KeyEvent ke){
        date_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        id_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        employee_name_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        status_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        attendance_record_tableview_attendance_middle.setItems(getValuesForAttendanceRecordAttendanceMiddle(search_by_employee_name_text_attendance_middle1.getText().toUpperCase()));
    }
    private ObservableList<AdmissionInformation> getValuesForAttendanceRecordAttendanceMiddle(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_attendance_record` where eid like \""+value+"%\"");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select name,status from employee_information_record where eid=\""
                        +rs.getString("eid")+ "\"");
                if(rss.next()){
                    list.add(new AdmissionInformation(rs.getDate("edate").toString(),rs.getString("eid"),rss.getString("name"),rss.getString("status")));
                }              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    private void FillAttendanceTableAttendanceMiddle(){
        date_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        id_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        employee_name_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        status_tablecolumn_attendance_record_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        attendance_record_tableview_attendance_middle.setItems(getValuesForAttendanceRecordAttendanceMiddle());
        attendance_record_tableview_attendance_middle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                dateplusemployeeid_text_attendance_middle.setText(attendance_record_tableview_attendance_middle.getSelectionModel().getSelectedItem().getAid()+"+"+attendance_record_tableview_attendance_middle.getSelectionModel().getSelectedItem().getFullname());
            }
        });
    }
    
    
    private ObservableList<AdmissionInformation> getValuesForAttendanceRecordAttendanceMiddle(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_attendance_record`");
            while(rs.next()){
                Statement stt=conn.createStatement();
                ResultSet rss=stt.executeQuery("select name,status from employee_information_record where eid=\""
                        +rs.getString("eid")+ "\"");
                if(rss.next()){
                    list.add(new AdmissionInformation(rs.getDate("edate").toString(),rs.getString("eid"),rss.getString("name"),rss.getString("status")));
                }              
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    private boolean checkTextAreaNow(String value){
        Pattern pat=Pattern.compile("^[a-zA-Z0-9][a-zA-Z0-9]{1,}(\\,[a-zA-Z0-9]{1,})*");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    
    @FXML
    public void proceedButtonClickedListenerAttendanceRight(ActionEvent ae){
        if(String.valueOf(attendance_year_choose_attendance_right.getValue()).equals("null")||String.valueOf(attendance_month_choose_attendance_right.getValue()).equals("null")||
                String.valueOf(attendance_day_choose_attendance_right.getValue()).equals("null")||absent_list_textarea_attendance_right.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Procced the attendance?","Attendance Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkTextAreaNow(absent_list_textarea_attendance_right.getText())){
                    String str=absent_list_textarea_attendance_right.getText().toUpperCase();
                    String[] words=str.split(",");
                    String status="Error Status :\n";
                    for(String s:words){
                        try {
                            Statement st=conn.createStatement();
                            ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+s+"\" and end_date is null");
                            if(rs.next()){
                                Statement stt=conn.createStatement();
                                stt.executeUpdate("INSERT INTO `employee_attendance_record`(`edate`, `eid`) VALUES (\'"
                                        + attendance_year_choose_attendance_right.getValue().toString()+"-"+attendance_month_choose_attendance_right.getValue().toString()+"-"+attendance_day_choose_attendance_right.getValue().toString()+"\',\""
                                                +s+ "\")");
                            }else{
                                status=status+"ID No. : "+s+"\n";
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Record of the given date is already existed! Try new Date!");
                        }
                    }
                    JOptionPane.showMessageDialog(null, status+"\nProceed Completed!\n");
                    FillAttendanceTableAttendanceMiddle();
                }else{
                    JOptionPane.showMessageDialog(null, "Absent Employee ID Format Invalid!"
                            + "\n\t-Space not allowed."
                            + "\n\t-Should seperate ID by comma.");
                }
            }
        }
    }
    @FXML
    public void clearButtonClickedListenerAttendanceRight(ActionEvent ae){
        absent_list_textarea_attendance_right.setText("");
    }
    
    
    
    @FXML
    public void clearButtonSearhByButtonClickedListenerAttendanceMiddle(ActionEvent ae){
        search_by_employee_name_text_attendance_middle.setText("");
        FillEmployeeListTableAttendanceMiddle();
    }
    
    @FXML
    public void FillEmployeeListKeyPressedEventListenerAttendanceMiddle(KeyEvent ke){
        id_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        fullname_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        jobtitle_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        department_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        type_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("marks_details"));
        employee_list_tableview_attendance_middle.setItems(getValuesForEmployeeListAttendanceMiddle(search_by_employee_name_text_attendance_middle.getText()));
    }
    private ObservableList<AdmissionInformation> getValuesForEmployeeListAttendanceMiddle(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_information_record` where name like \""+value+"%\" and end_date is null");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("eid"),rs.getString("name"),rs.getString("job_title"),rs.getString("department"),rs.getString("employee_type")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private ObservableList<AdmissionInformation> getValuesForEmployeeListAttendanceMiddle(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_information_record` where end_date is null");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("eid"),rs.getString("name"),rs.getString("job_title"),rs.getString("department"),rs.getString("employee_type")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void FillEmployeeListTableAttendanceMiddle(){
        id_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        fullname_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        jobtitle_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        department_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        type_tablecolumn_employee_list_attendance_middle.setCellValueFactory(new PropertyValueFactory<>("marks_details"));
        employee_list_tableview_attendance_middle.setItems(getValuesForEmployeeListAttendanceMiddle());
        employee_list_tableview_attendance_middle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_list_tableview_attendance_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase()+"\"");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                + "Employee ID : "+rs.getString("eid")+"\n"
                                + "Employee Name : "+rs.getString("name")+"\n"
                                + "Contact No. : "+rs.getString("contact")+"\n"
                                + "Email : "+rs.getString("Email")+"\n"
                                + "Job Title : "+rs.getString("job_title")+"\n"
                                + "Department : "+rs.getString("department")+"\n"
                                + "Employement Type : "+rs.getString("employee_type")+"\n"
                                + "Employement Date :  "+rs.getString("start_date").toString()+"\n"
                                + "Education Details : "+rs.getString("education_details")+"\n"
                                + "Work History : "+rs.getString("work_history")+"\n"
                                + "Salary : "+rs.getString("salary")+"\n"
                                + "Status : "+rs.getString("status")+"\n"
                            );
                        employee_id_textfield_employee_middle.setText(rs.getString("eid"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
     }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
     public void DeletebuttonEnteredAttendanceMiddle(MouseEvent me){
        delete_button_attendance_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeletebuttonExitedAttendanceMiddle(MouseEvent me){
        delete_button_attendance_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void ClearDateplusEmployeebuttonEnteredAttendanceMiddle(MouseEvent me){
        clear_button_attendance_middle_dateplusemployee.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearDatePlusEmployeebuttonExitedAttendanceMiddle(MouseEvent me){
        clear_button_attendance_middle_dateplusemployee.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void ClearSearchBybuttonEnteredAttendanceMiddle(MouseEvent me){
        clear_button_attendance_middle_searchby.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearSearchBybuttonExitedAttendanceMiddle(MouseEvent me){
        clear_button_attendance_middle_searchby.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void ClearbuttonEnteredAttendanceMiddle(MouseEvent me){
        clear_button_attendance_middle.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearbuttonExitedAttendanceMiddle(MouseEvent me){
        clear_button_attendance_middle.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void ProccedbuttonEnteredAttendanceRight(MouseEvent me){
        procced_button_attendance_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ProccedbuttonExitedAttendanceRight(MouseEvent me){
        procced_button_attendance_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
     public void ClearbuttonEnteredAttendanceRight(MouseEvent me){
        clear_button_attendance_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearbuttonExitedAttendanceRight(MouseEvent me){
        clear_button_attendance_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    
    
    
    
    
    
    
    
    
    //employee components and methods 
    //employee
    
    
    
    @FXML
    public void searchByEmployeeNameKeyPressedEventListenerEmployeeMiddle(KeyEvent ke){
        id_tablecolumn_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        contact_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        email_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        job_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        department_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        type_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        status_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        employee_table_tableview_employee_middle.setItems(getValueForEmployeeTableEmployeeMiddle(search_employee_name_textfield_employee_middle.getText()));
    }
    private ObservableList<AdmissionInformation> getValueForEmployeeTableEmployeeMiddle(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_information_record` where name like \""+value+"%\"");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("eid"),rs.getString("name"),rs.getString("contact"),rs.getString("email"),rs.getString("job_title"),rs.getString("department"),rs.getString("employee_type"),rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private void FillEmployeeTableEmployeeMiddle(){
        id_tablecolumn_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("aid"));
        name_tablecolumn_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        contact_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        email_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        job_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("email"));
        department_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        type_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        status_tablecolumn_tableview_employee_table_employee_middle.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        employee_table_tableview_employee_middle.setItems(getValueForEmployeeTableEmployeeMiddle());
        employee_table_tableview_employee_middle.setOnMouseClicked(new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_table_tableview_employee_middle.getSelectionModel().getSelectedItem().getAid().toUpperCase()+"\"");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Details Information : \n\n"
                                + "Employee ID : "+rs.getString("eid")+"\n"
                                + "Employee Name : "+rs.getString("name")+"\n"
                                + "Contact No. : "+rs.getString("contact")+"\n"
                                + "Email : "+rs.getString("Email")+"\n"
                                + "Job Title : "+rs.getString("job_title")+"\n"
                                + "Department : "+rs.getString("department")+"\n"
                                + "Employement Type : "+rs.getString("employee_type")+"\n"
                                + "Employement Date :  "+rs.getString("start_date").toString()+"\n"
                                + "Education Details : "+rs.getString("education_details")+"\n"
                                + "Work History : "+rs.getString("work_history")+"\n"
                                + "Salary : "+rs.getString("salary")+"\n"
                                + "Status : "+rs.getString("status")+"\n"
                            );
                        employee_id_textfield_employee_middle.setText(rs.getString("eid"));
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
     }
    @FXML
    public void DeleteButtonClickedListenerEmployeeMiddle(ActionEvent ae){
        if(employee_id_textfield_employee_middle.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete the employee record?","Employee Add Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_id_textfield_employee_middle.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM `employee_information_record` WHERE eid=\""+employee_id_textfield_employee_middle.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted from the record!");
                        FillEmployeeTableEmployeeMiddle();
                        ClearButtonMiddleEIDButtonClickedListenerEmployeeMiddle(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Employee ID to delete!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @FXML
    public void ClearButtonMiddleEIDButtonClickedListenerEmployeeMiddle(ActionEvent ae) {
        employee_id_textfield_employee_middle.setText("");
    }

    @FXML
    public void ClearButtonMiddleSearchButtonClickedListenerEmployeeMiddle(ActionEvent ae) {
        search_employee_name_textfield_employee_middle.setText("");
        FillEmployeeTableEmployeeMiddle();
    }
    
    private ObservableList<AdmissionInformation> getValueForEmployeeTableEmployeeMiddle(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `employee_information_record`");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("eid"),rs.getString("name"),rs.getString("contact"),rs.getString("email"),rs.getString("job_title"),rs.getString("department"),rs.getString("employee_type"),rs.getString("status")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    @FXML
    public void AddButtonClickedListenerEmployeeRight(ActionEvent ae){
        if(first_name_textfield_employee_right.getText().equals("")||last_name_textfield_employee_right.getText().equals("")||
                employee_id_no_textfield_employee_right.getText().equals("")||contact_no_textfield_employee_right.getText().equals("")||
                email_textfield_employee_right.getText().equals("")||job_title_textfield_employee_right.getText().equals("")||
                department_textfield_employee_right.getText().equals("")||education_details_textarea_employee_right.getText().equals("")||
                work_history_textarea_employee_right.getText().equals("")||employee_type_choose_employee_right.getValue().equals("null")||
                String.valueOf(start_date_year_employee_right.getValue()).equals("null")||String.valueOf(start_date_month_employee_right.getValue()).equals("null")||
                String.valueOf(start_date_day_employee_right.getValue()).equals("null")||salary_per_month_textfield_employee_right.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Add the employee record?","Employee Add Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                if(checkWithRegularExpressionForAddingEmployeeRecord(contact_no_textfield_employee_right.getText(),email_textfield_employee_right.getText(),
                        salary_per_month_textfield_employee_right.getText())){
                    try {
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from employee_information_record where eid=\""+employee_id_no_textfield_employee_right.getText().toUpperCase()+"\"");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null, "Employee ID already Exist! Try Unique one!");
                        }else{
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("INSERT INTO `employee_information_record`(`eid`, `name`, `contact`, `email`, `job_title`, `department`, `employee_type`, `start_date`, `education_details`, `work_history`, `salary`,`status`) VALUES ("
                                    + "\""+employee_id_no_textfield_employee_right.getText().toUpperCase()+"\",\""+(first_name_textfield_employee_right.getText()+" "+last_name_textfield_employee_right.getText())+"\",\""
                                            + contact_no_textfield_employee_right.getText()+"\",\""+email_textfield_employee_right.getText()+"\",\""
                                                    + job_title_textfield_employee_right.getText()+"\",\""+department_textfield_employee_right.getText()+"\",\""
                                                            + employee_type_choose_employee_right.getValue()+"\",\'"+(start_date_year_employee_right.getValue().toString()+"-"+start_date_month_employee_right.getValue().toString()+"-"+start_date_day_employee_right.getValue().toString())+"\',\""
                                                                    + education_details_textarea_employee_right.getText()+"\",\""+work_history_textarea_employee_right.getText()+"\","+String.valueOf(salary_per_month_textfield_employee_right.getText())+",\"Recruited\")");
                            Statement stv=conn.createStatement();
                            stv.executeUpdate("INSERT INTO `employee_salary_record`(`eid`, `amt_to_be_given`, `total_amt_given`) VALUES (\""
                            +employee_id_no_textfield_employee_right.getText().toUpperCase()+ "\",0,0)");
                            
                            JOptionPane.showMessageDialog(null,"Successfully Added to the Database!");
                            ClearButtonClickedListenerEmployeeRight(ae);
                            FillEmployeeTableEmployeeMiddle();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(HumanResourcesManagementController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Either, email, contact or salary format is invalid!");
                }
            }
        }
    }
    @FXML
    public void ClearButtonClickedListenerEmployeeRight(ActionEvent ae){
        first_name_textfield_employee_right.setText("");
        last_name_textfield_employee_right.setText("");
        employee_id_no_textfield_employee_right.setText("");
        contact_no_textfield_employee_right.setText("");
        email_textfield_employee_right.setText("");
        job_title_textfield_employee_right.setText("");
        department_textfield_employee_right.setText("");
        education_details_textarea_employee_right.setText("");
        work_history_textarea_employee_right.setText("");
        salary_per_month_textfield_employee_right.setText("");
    }
    
    public boolean checkWithRegularExpressionForAddingEmployeeRecord(String contact,String email,String salary){
        Pattern pat=Pattern.compile("^[0-9][0-9]{3,}");
        Matcher mat=pat.matcher(contact);
        boolean first=mat.matches();
        pat=Pattern.compile("^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$");
        mat=pat.matcher(email);
        boolean second=mat.matches();
        pat=Pattern.compile("^[0-9][0-9]{0,}");
        mat=pat.matcher(salary);
        return first&&second&&mat.matches();
    }
    
    
    
    
    
    
    
    
    
     @FXML
    public void AddbuttonEnteredEmployeeRight(MouseEvent me){
        add_button_employee_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddbuttonExitedEmployeeRight(MouseEvent me){
        add_button_employee_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
     @FXML
    public void ClearbuttonEnteredEmployeeRight(MouseEvent me){
        clear_button_employee_right.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearbuttonExitedEmployeeRight(MouseEvent me){
        clear_button_employee_right.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    
    @FXML
    public void EmployeeButtonEntered(MouseEvent ae){
        employee_button_choosefirst.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void EmployeeButtonExited(MouseEvent ae){
        employee_button_choosefirst.setStyle("-fx-background-color:#408080;");
    }
    
    @FXML
    public void AttendanceButtonEntered(MouseEvent ae){
        attendance_button_choosefirst.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void AttendanceButtonExited(MouseEvent ae){
        attendance_button_choosefirst.setStyle("-fx-background-color:#408080;");
    }
    @FXML
    public void StatusButtonEntered(MouseEvent ae){
        status_button_choosefirst.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void StatusButtonExited(MouseEvent ae){
        status_button_choosefirst.setStyle("-fx-background-color:#408080;");
    }
    @FXML
    public void SalaryButtonEntered(MouseEvent ae){
        salary_button_choosefirst.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void SalaryButtonExited(MouseEvent ae){
        salary_button_choosefirst.setStyle("-fx-background-color:#408080;");
    }
    
    public void EditButtonEnteredEmployeeMiddle(MouseEvent ae){
        edit_button_employee_middle.setStyle("-fx-background-color:#4f4778;");
    }
    public void EditButtonExitedEmployeeMiddle(MouseEvent ae){
        edit_button_employee_middle.setStyle("-fx-background-color:#408080;");
    }
    @FXML
    public void DeleteButtonEnteredEmployeeMiddle(MouseEvent ae){
        delete_button_employee_middle.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void DeleteButtonExitedEmployeeMiddle(MouseEvent ae){
        delete_button_employee_middle.setStyle("-fx-background-color:#408080;");
    }
    @FXML
    public void ClearButtonEnteredEmployeeMiddleSearch(MouseEvent ae){
        clear_button_employee_middle_search.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void ClearButtonExitedEmployeeMiddleSearch(MouseEvent ae){
        clear_button_employee_middle_search.setStyle("-fx-background-color:#408080;");
    }
    @FXML
    public void ClearButtonEnteredEmployeeMiddleEID(MouseEvent ae){
        clear_button_employee_middle_EID.setStyle("-fx-background-color:#4f4778;");
    }
    @FXML
    public void ClearButtonExitedEmployeeMiddleEID(MouseEvent ae){
        clear_button_employee_middle_EID.setStyle("-fx-background-color:#408080;");
    }


    @FXML
    private void SearchByLibrarianIDTextMiddleLLTKeyPressedReleaseEventListener(InputMethodEvent event) {
    }

    @FXML
    private void SearchByLibrarianIDTextMiddleLLTKeyPressedReleaseEventListener(KeyEvent event) {
    }


    @FXML
    private void clearButtonMiddleLLTButtonClickedListener(ActionEvent event) {
    }



    @FXML
    private void searchByBookTitleMiddleBLiTKeyPressedEventListener(InputMethodEvent event) {
    }

    @FXML
    private void searchByBookTitleMiddleBLiTKeyPressedEventListener(KeyEvent event) {
    }



    @FXML
    private void deleteButtonClickedListener(MouseEvent event) {
    }

    

    


  
   
  
  

}

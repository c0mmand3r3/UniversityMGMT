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
public class LibraryManagementController implements Initializable {

    @FXML
    private TextField librarian_id_text_1_LM;
    @FXML
    private TextField librarian_name_text_1_LM;
    @FXML
    private ComboBox<String> librarian_shift_combo_1_LM;
    @FXML
    private Button add_button_1_LM;
    @FXML
    private Button clear_button_1_LM;
    @FXML
    private TextField book_id_text_2_BI;
    @FXML
    private TextField book_title_text_2_BI;
    @FXML
    private TextField pubisher_text_2_BI;
    @FXML
    private TextField author_text_2_BI;
    @FXML
    private TextField no_of_book_text_2_BI;
    @FXML
    private Button add_button_2_BI;
    @FXML
    private Button clear_button_2_BI;
    @FXML
    private TextField book_location_text_2_BI;
    @FXML
    private TextField book_id_text_3_BL;
    @FXML
    private TextField student_id_text_3_BL;
    @FXML
    private ComboBox<Integer> issued_date_year_combo_3_BL;
    @FXML
    private ComboBox<Integer> issued_date_month_combo_3_BL;
    @FXML
    private ComboBox<Integer> issued_date_day_combo_3_BL;
    @FXML
    private Button lend_button_3_BL;
    @FXML
    private Button clear_button_3_BL;
    @FXML
    private TextField given_by_text_3_BL;
    @FXML
    private TableView<AdmissionInformation> librarian_list_table_tableview_middle_LLT;
    @FXML
    private TableColumn<AdmissionInformation, String> librarian_id_col_middle_LLT;
    @FXML
    private TableColumn<AdmissionInformation, String> librarian_name_col_middle_LLT;
    @FXML
    private TableColumn<AdmissionInformation, String> shift_col_middle_LLT;
    @FXML
    private TableView<EnquiryInformation> book_list_table_tableview_middle_BLiT;
    @FXML
    private TableColumn<EnquiryInformation, String> book_id_col_BLiT;
    @FXML
    private TableColumn<EnquiryInformation, String> title_col_BLiT;
    @FXML
    private TableColumn<EnquiryInformation, String> publisher_col_BLiT;
    @FXML
    private TableColumn<EnquiryInformation, String> author_col_BLiT;
    @FXML
    private TableColumn<EnquiryInformation, Integer> book_quantity_col_BLiT;
    @FXML
    private TableColumn<EnquiryInformation, String> book_location_col_BLiT;
    @FXML
    private TableView<AdmissionInformation> book_returned_table_tableview_BRI;
    @FXML
    private TableColumn<AdmissionInformation, String> book_id_col_BRT;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_col_BRT;
    @FXML
    private TableColumn<AdmissionInformation, String> issued_date_col_BRT;
    @FXML
    private TableColumn<AdmissionInformation, String> returned_date_col_BRT;
    @FXML
    private TableColumn<AdmissionInformation, String> given_by_col_BRT;
    @FXML
    private TableColumn<AdmissionInformation, String> returned_to_col_BRT;
    @FXML
    private TextField search_by_librarian_id_text_middle_LLT;
    @FXML
    private Button delete_button_middle_LLT;
    @FXML
    private TextField search_by_book_title_text_middle_BLiT;
    @FXML
    private Button delete_button_middle_BLiT;
    @FXML
    private Button clear_button_middle_BLiT;
    @FXML
    private TextField search_by_book_id_text_middle_BLT;
    @FXML
    private Button delete_button_middle_BLT;
    @FXML
    private Button clear_button_middle_BLT;
    @FXML
    private Button delete_whole_record_button_middle_BRT;
    @FXML
    private TextField librarian_id_text_4_ELM;
    @FXML
    private TextField librarian_name_text_4_ELM;
    @FXML
    private ComboBox<String> shift_combo_4_ELM;
    @FXML
    private TextField old_librarian_id_text_4_ELM;
    @FXML
    private Button edit_button_4_ELM;
    @FXML
    private Button clear_button_4_ELM;
    @FXML
    private TextField book_id_text_5_BRE;
    @FXML
    private TextField book_title_text_5_BRE;
    @FXML
    private TextField publisher_text_5_BRE;
    @FXML
    private TextField author_text_5_BRE;
    @FXML
    private TextField no_of_book_text_5_BRE;
    @FXML
    private Button edit_button_5_BRE;
    @FXML
    private Button clear_button_5_BRE;
    @FXML
    private TextField book_location_text_5_BRE;
    @FXML
    private TextField old_book_id_text_5_BRE;
    @FXML
    private TextField book_id_text_6_BR;
    @FXML
    private TextField student_id_text_6_BR;
    @FXML
    private ComboBox<Integer> returned_date_year_combo_6_BR;
    @FXML
    private ComboBox<Integer> join_date_month_combo_3_RA1;
    @FXML
    private ComboBox<Integer> returned_date_day_combo_6_BR;
    @FXML
    private Button return_button_6_BR;
    @FXML
    private Button clear_button_6_BR;
    @FXML
    private TextField return_to_librarian_id_text_6_BR;
    @FXML
    private Button clear_button_middle_LLT;
    private Connection conn;
    @FXML
    private TableColumn<EnquiryInformation, Integer> book_left_col_BLT;
    @FXML
    private TableView<AdmissionInformation> book_lending_table_middle_tableview_BLTT;
    @FXML
    private TableColumn<AdmissionInformation, String> book_id_col_middle_BLTT;
    @FXML
    private TableColumn<AdmissionInformation, String> student_id_col_middle_BLTT;
    @FXML
    private TableColumn<AdmissionInformation, String> issued_date_col_middle_BLTT;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        librarian_shift_combo_1_LM.setItems(FXCollections.observableArrayList("Morning Shift","Mid-Day Shift","Evening Shift","Overnight Shift","Full-Day Shift","Full-Night Shift"));
        shift_combo_4_ELM.setItems(FXCollections.observableArrayList("Morning Shift","Mid-Day Shift","Evening Shift","Overnight Shift","Full-Day Shift","Full-Night Shift"));
        issued_date_year_combo_3_BL.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        returned_date_year_combo_6_BR.setItems(FXCollections.observableArrayList(2013, 2014, 2015 ,2016 ,2017, 2018 ,2019,
                2020 ,2021, 2022 ,2023, 2024 ,2025 ,2026 ,2027, 2028 ,2029,
                2030, 2031, 2032 ,2033 ,2034, 2035 ,2036 ,2037, 2038, 2039,
                2040 ,2041, 2042 ,2043 ,2044 ,2045 ,2046 ,2047, 2048, 2049
                ));
        issued_date_day_combo_3_BL.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        returned_date_day_combo_6_BR.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31
                ));
        issued_date_month_combo_3_BL.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
        join_date_month_combo_3_RA1.setItems(FXCollections.observableArrayList(1,2,3,4,5,6,7,8,9,10,11,12
                ));
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
        FillStudentTableST();
        FillStudentTableBLT();
        FillStudentTableBLTT();
        FillStudentTableBRT();
    }
    
    public void deleteWholeButtonMiddleBRTButtonClickedListener(ActionEvent ae){
        int val=JOptionPane.showConfirmDialog(null,"Do you want to delete the whole returned book?","Book Record Information Returned",JOptionPane.YES_NO_OPTION);
        if(val==0){
            try {
                Statement st=conn.createStatement();
                st.executeUpdate("DELETE FROM `book_returned_info` WHERE 1");
                FillStudentTableBRT();
            } catch (SQLException ex) {
                Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //book return methods
    private ObservableList<AdmissionInformation> getValuesForBookReturnedTableListBRT(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `book_returned_info`");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("b_id"),rs.getString("std_id"),rs.getDate("issue_date").toString(),rs.getString("given_by"),rs.getDate("return_date").toString(),rs.getString("return_to")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    private void FillStudentTableBRT(){
        book_id_col_BRT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_id_col_BRT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        issued_date_col_BRT.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        returned_date_col_BRT.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        given_by_col_BRT.setCellValueFactory(new PropertyValueFactory<>("email"));
        returned_to_col_BRT.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        book_returned_table_tableview_BRI.setItems(getValuesForBookReturnedTableListBRT());
     }
    
    //book return information event occurs and methods
    public void returnButton6ButtonClickedListener(ActionEvent ae){
        if(book_id_text_6_BR.getText().equals("")||student_id_text_6_BR.getText().equals("")||
                return_to_librarian_id_text_6_BR.getText().equals("")||returned_date_year_combo_6_BR.getValue().equals("")||
                join_date_month_combo_3_RA1.getValue().equals("")||returned_date_day_combo_6_BR.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Return the book?","Book Record Information Returning",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from book_lending_return_info where b_id=\""+book_id_text_6_BR.getText().toUpperCase()+"\" and return_date is null and std_id=\""+student_id_text_6_BR.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stv=conn.createStatement();
                        ResultSet rsv=stv.executeQuery("SELECT * FROM `librarian_info` where librarian_id=\""+return_to_librarian_id_text_6_BR.getText().toUpperCase()+"\"");
                        if(rsv.next()){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("INSERT INTO `book_returned_info`(`b_id`, `std_id`, `issue_date`, `given_by`, `return_date`, `return_to`) VALUES (\""+rs.getString("b_id")+"\",\""+rs.getString("std_id")+"\",\""+rs.getDate("issue_date")+"\",\""+rs.getString("given_by")+"\",\""+returned_date_year_combo_6_BR.getValue()+"-"+join_date_month_combo_3_RA1.getValue()+"-"+returned_date_day_combo_6_BR.getValue()+"\",\""+return_to_librarian_id_text_6_BR.getText().toUpperCase()+"\")");
                            Statement sttv=conn.createStatement();
                            sttv.executeUpdate("DELETE FROM `book_lending_return_info` WHERE "
                             + "b_id=\""+book_id_text_6_BR.getText().toUpperCase()+"\" and return_date is null and std_id=\""+student_id_text_6_BR.getText().toUpperCase()+"\"");
                            Statement stsm=conn.createStatement();
                            stsm.executeUpdate("UPDATE `book_record_info` SET `no_of_pieces_left`=no_of_pieces_left+1 where book_id=\""+book_id_text_6_BR.getText().toUpperCase()+"\"");
                            clearButton6ButtonClickedListener(ae);
                            FillStudentTableBLT();
                            FillStudentTableBLTT();
                            FillStudentTableBRT();
                        }else{
                            JOptionPane.showMessageDialog(null, "Return to Librarian ID is invalid!");
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "One Student can't lend two same book!");
                }
            }
        }
    }
    public void clearButton6ButtonClickedListener(ActionEvent ae){
        book_id_text_6_BR.setText("");
        student_id_text_6_BR.setText("");
        return_to_librarian_id_text_6_BR.setText("");
    }
    
    
    
    
    //book edit information edit event occurs and methods 
    public void editButton5BREButtonClickedListener(ActionEvent ae){
        if(old_book_id_text_5_BRE.getText().equals("")||book_id_text_5_BRE.getText().equals("")||book_title_text_5_BRE.getText().equals("")||
                publisher_text_5_BRE.getText().equals("")||author_text_5_BRE.getText().equals("")||
                no_of_book_text_5_BRE.getText().equals("")||book_location_text_5_BRE.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Edit Book Record Information?","Book Record Information Edit",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from book_record_info where book_id=\""+old_book_id_text_5_BRE.getText().toUpperCase()+"\"");
                    if(!rs.next()){
                        JOptionPane.showMessageDialog(null, "Book ID not found!");
                    }else{
                        Statement stvs=conn.createStatement();
                        ResultSet rssv=stvs.executeQuery("select * from book_record_info where book_id=\""+book_id_text_5_BRE.getText().toUpperCase()+"\"");
                        if(rssv.next()){
                            JOptionPane.showMessageDialog(null, "New Book ID already Existed!");
                        }else{
                            if(returnStatusNumeric(no_of_book_text_5_BRE.getText())){
                                Statement stt=conn.createStatement();
                                int lefttot=rs.getInt("no_of_pieces_left");
                                int tot=rs.getInt("no_of_pieces");
                                if((tot-lefttot)<=Integer.parseInt((no_of_book_text_5_BRE.getText()))){
                                    stt.executeUpdate("UPDATE `book_record_info` SET `book_id`="
                                        + "\""+book_id_text_5_BRE.getText().toUpperCase()+"\",`book_title`=\""+book_title_text_5_BRE.getText()+"\",`publisher`=\""
                                                + publisher_text_5_BRE.getText()+"\",`author`=\""+author_text_5_BRE.getText()+"\",`no_of_pieces`=\""
                                                        + Integer.parseInt(no_of_book_text_5_BRE.getText())+"\",`no_of_pieces_left`=\""+(Integer.parseInt(no_of_book_text_5_BRE.getText())-(tot-lefttot))+"\",`book_location`=\""
                                                                + book_location_text_5_BRE.getText()+"\" where book_id=\""+old_book_id_text_5_BRE.getText().toUpperCase()+"\"");
                                    JOptionPane.showMessageDialog(null, "Sucessfully Added to the database!");
                                    FillStudentTableBLT();
                                    clearButton2BIButtonClickedListener(ae);
                                    FillStudentTableBLTT();
                                    clearButton5BREButtonClickedListener(ae);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Book Can't be edited! Books are already owned and it's capacity is low than leaded book total.");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "No of Book should be numeric!");
                            }
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    public void clearButton5BREButtonClickedListener(ActionEvent ae){
        old_book_id_text_5_BRE.setText("");
        book_id_text_5_BRE.setText("");
        book_title_text_5_BRE.setText("");
        publisher_text_5_BRE.setText("");
        author_text_5_BRE.setText("");
        no_of_book_text_5_BRE.setText("");     
        book_location_text_5_BRE.setText("");
    }
    
    
    
    
    
    //edit librarian manager events 
    public void editButton4ELMButtonClickedListener(ActionEvent ae){
        if(old_librarian_id_text_4_ELM.getText().equals("")||librarian_id_text_4_ELM.getText().equals("")||
                librarian_name_text_4_ELM.getText().equals("")||shift_combo_4_ELM.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Edit the Librarian Record?","Librarian Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from librarian_info where librarian_id=\""+old_librarian_id_text_4_ELM.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("UPDATE `librarian_info` SET `librarian_id`=\""+librarian_id_text_4_ELM.getText().toUpperCase()+"\",`librarian_name`=\""+
                                librarian_name_text_4_ELM.getText()+"\",`shift`=\""+shift_combo_4_ELM.getValue()+"\" WHERE librarian_id=\""+old_librarian_id_text_4_ELM.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Edited!");
                        clearButton4ELMButtonClickedListener(ae);
                        FillStudentTableBLT();
                        FillStudentTableBLTT();
                        FillStudentTableST();
                    }else{
                        JOptionPane.showMessageDialog(null,"Librarian Information is invalid!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void clearButton4ELMButtonClickedListener(ActionEvent ae){
        librarian_id_text_4_ELM.setText("");
        librarian_name_text_4_ELM.setText("");
        old_librarian_id_text_4_ELM.setText("");
    }
    
    
    //book_lending table filling event occurs
    public void deleteButtonMiddleBLTClickedListener(ActionEvent ae){
        if(search_by_book_id_text_middle_BLT.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete the Book Lend Record?","Book Lend Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("SELECT * FROM `book_lending_return_info` where return_date is null and b_id=\""+search_by_book_id_text_middle_BLT.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM `book_lending_return_info` WHERE b_id=\""+search_by_book_id_text_middle_BLT.getText().toUpperCase()+"\"");
                        stt.executeUpdate("UPDATE `book_record_info` SET `no_of_pieces_left`=no_of_pieces_left+1 WHERE book_id=\""+search_by_book_id_text_middle_BLT.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        FillStudentTableBLT();
                        clearButtonMiddleBLTClickedListener(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Select column of the table to select the book that you want to delete!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public void clearButtonMiddleBLTClickedListener(ActionEvent ae){
        search_by_book_id_text_middle_BLT.setText("");
        FillStudentTableBLTT();
    }
    
    
    public void searchByBookIDMiddleBLTKeyPressedEventListener(KeyEvent ke){
        book_id_col_middle_BLTT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_id_col_middle_BLTT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        issued_date_col_middle_BLTT.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        book_lending_table_middle_tableview_BLTT.setItems(getValuesForBookLendingTableListBLTT(search_by_book_id_text_middle_BLT.getText().toUpperCase()));
    }
    
    
    //book lending table filling methods
    private ObservableList<AdmissionInformation> getValuesForBookLendingTableListBLTT(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `book_lending_return_info` where return_date is null and std_id like \""+value+"%\"");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("b_id"),rs.getString("std_id"),rs.getDate("issue_date").toString()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private ObservableList<AdmissionInformation> getValuesForBookLendingTableListBLTT(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `book_lending_return_info` where return_date is null");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("b_id"),rs.getString("std_id"),rs.getDate("issue_date").toString()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     private void FillStudentTableBLTT(){
        book_id_col_middle_BLTT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        student_id_col_middle_BLTT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        issued_date_col_middle_BLTT.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        book_lending_table_middle_tableview_BLTT.setItems(getValuesForBookLendingTableListBLTT());
        book_lending_table_middle_tableview_BLTT.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
               try {
                    Statement smt=conn.createStatement();
                    ResultSet rst=smt.executeQuery("select applicant_id from student_registration_info where student_id=\""+book_lending_table_middle_tableview_BLTT.getSelectionModel().getSelectedItem().getFullname().toString().toUpperCase()+"\"");
                    if(rst.next()){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select * from application_form_details where aid=\""+
                                rst.getString("applicant_id")+"\"");
                        Statement stt=conn.createStatement();
                        ResultSet rss=stt.executeQuery("select * from student_registration_info where student_id=\""+book_lending_table_middle_tableview_BLTT.getSelectionModel().getSelectedItem().getFullname().toString().toUpperCase()+"\"");                    
                        Statement svvt=conn.createStatement();
                        ResultSet rvvs=svvt.executeQuery("select * from book_lending_return_info where std_id=\""+book_lending_table_middle_tableview_BLTT.getSelectionModel().getSelectedItem().getFullname()+"\"");                       
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
                                + "\n\n\nBook Issued Date : "+rvvs.getDate("issue_date")+"\n"+
                                                            "Book Given By : "+rvvs.getString("given_by"));
                            search_by_book_id_text_middle_BLT.setText(book_lending_table_middle_tableview_BLTT.getSelectionModel().getSelectedItem().getAid());
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HostelManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        });
     }
    
    //book_lending events 
    @FXML
    public void lendButton3BLButtonClickedListener(ActionEvent ae){
        if(book_id_text_3_BL.getText().equals("")||student_id_text_3_BL.getText().equals("")||
                issued_date_year_combo_3_BL.getValue().equals("")||issued_date_month_combo_3_BL.getValue().equals("")||
                issued_date_day_combo_3_BL.getValue().equals("")||given_by_text_3_BL.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Lend the Book?","Book Lend Record Information",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from book_record_info where book_id=\""+book_id_text_3_BL.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        if(rs.getInt("no_of_pieces_left")>0){
                            Statement stt=conn.createStatement();
                            ResultSet rss=stt.executeQuery("select * from student_registration_info where student_id=\""+student_id_text_3_BL.getText().toUpperCase()+"\"");
                            if(rss.next()){
                                Statement stg=conn.createStatement();
                                ResultSet rsg=stg.executeQuery("select * from librarian_info where librarian_id=\""+given_by_text_3_BL.getText().toUpperCase()+"\"");
                                if(rsg.next()){
                                    Statement sttv=conn.createStatement();
                                    sttv.executeUpdate("INSERT INTO `book_lending_return_info`(`b_id`, `std_id`, `issue_date`, `given_by`) VALUES ("
                                            + "\""+book_id_text_3_BL.getText().toUpperCase()+"\",\""+student_id_text_3_BL.getText().toUpperCase()+"\",\""+
                                            String.valueOf(issued_date_year_combo_3_BL.getValue())+"-"+String.valueOf(issued_date_month_combo_3_BL.getValue())+"-"+
                                            String.valueOf(issued_date_day_combo_3_BL.getValue())+"\",\""+given_by_text_3_BL.getText().toUpperCase()+"\")");
                                    sttv.executeUpdate("UPDATE `book_record_info` SET `no_of_pieces_left`=no_of_pieces_left-1 WHERE book_id=\""+book_id_text_3_BL.getText().toUpperCase()+"\"");
                                    JOptionPane.showMessageDialog(null, "Sucessfully Lended!");
                                    FillStudentTableBLT();
                                    FillStudentTableBLTT();
                                    clearButton3BLButtonClickedListener(ae);
                                }else{
                                    JOptionPane.showMessageDialog(null, "Given To Librarian ID invalid!");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Student ID invalid!");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "There is no book left in the library! Come Back Later!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Book ID invalid!");
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "One Student can't lend two same book!");
                }
            }
        }
    }
    @FXML
    public void clearButton3BLButtonClickedListener(ActionEvent ae){
        book_id_text_3_BL.setText("");
        student_id_text_3_BL.setText("");
        given_by_text_3_BL.setText("");
    }
    
    
    
    
    
    
    
    
    
    //search book list table events methods
    @FXML
    public void deleteButtonMiddleBLiTButtonClickedListener(ActionEvent ae){
        if(search_by_book_title_text_middle_BLiT.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to delete Book Record Information?","Book Record Information Deletion",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from book_record_info where book_id=\""+search_by_book_title_text_middle_BLiT.getText().toUpperCase()+"\"");
                    if(!rs.next()){
                        JOptionPane.showMessageDialog(null, "Clicked table row to select the Book! Invalid Book ID");
                    }else{
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM `book_record_info` WHERE book_id=\""+search_by_book_title_text_middle_BLiT.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Delete!");
                        clearButtonMiddleBLiTButtonClickedListener(ae);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButtonMiddleBLiTButtonClickedListener(ActionEvent ae){
        search_by_book_title_text_middle_BLiT.setText("");
        FillStudentTableBLT();
    }
    
    @FXML
    public void searchByBookTitleMiddleBLiTKeyPressedEventListener(KeyEvent ke){
        book_id_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("eid"));
        title_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("name"));
        publisher_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("email"));
        author_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("contact"));
        book_quantity_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("book_quant"));
        book_location_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("address"));
        book_left_col_BLT.setCellValueFactory(new PropertyValueFactory<>("book_left"));
        book_list_table_tableview_middle_BLiT.setItems(getValuesForLibrarianTableListBLT(search_by_book_title_text_middle_BLiT.getText()));
    }
    
    
    //book insertion event methods
    private ObservableList<EnquiryInformation> getValuesForLibrarianTableListBLT(String value){
        ObservableList<EnquiryInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `book_record_info` where book_title like \""+value+"%\"");
            while(rs.next()){
                list.add(new EnquiryInformation(rs.getString("book_id"),rs.getString("book_title"),rs.getString("publisher"),rs.getString("author"),Integer.parseInt(rs.getString("no_of_pieces")),rs.getString("book_location"),Integer.parseInt(rs.getString("no_of_pieces_left"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    private boolean returnStatusNumeric(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    private ObservableList<EnquiryInformation> getValuesForLibrarianTableListBLT(){
        ObservableList<EnquiryInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM `book_record_info`");
            while(rs.next()){
                list.add(new EnquiryInformation(rs.getString("book_id"),rs.getString("book_title"),rs.getString("publisher"),rs.getString("author"),Integer.parseInt(rs.getString("no_of_pieces")),rs.getString("book_location"),Integer.parseInt(rs.getString("no_of_pieces_left"))));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     private void FillStudentTableBLT(){
        book_id_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("eid"));
        title_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("name"));
        publisher_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("email"));
        author_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("contact"));
        book_quantity_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("book_quant"));
        book_location_col_BLiT.setCellValueFactory(new PropertyValueFactory<>("address"));
        book_left_col_BLT.setCellValueFactory(new PropertyValueFactory<>("book_left"));
        book_list_table_tableview_middle_BLiT.setItems(getValuesForLibrarianTableListBLT());
            book_list_table_tableview_middle_BLiT.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                search_by_book_title_text_middle_BLiT.setText(book_list_table_tableview_middle_BLiT.getSelectionModel().getSelectedItem().getEid());
            }
            
        });
     }
    //book insertion event occurs 
    @FXML
    public void addButton2BIButtonClickedListener(ActionEvent ae){
        if(book_id_text_2_BI.getText().equals("")||book_title_text_2_BI.getText().equals("")||
                pubisher_text_2_BI.getText().equals("")||author_text_2_BI.getText().equals("")||
                no_of_book_text_2_BI.getText().equals("")||book_location_text_2_BI.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Add Book Record Information?","Book Record Information Insertion",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from book_record_info where book_id=\""+book_id_text_2_BI.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Book ID already Existed!");
                    }else{
                        if(returnStatusNumeric(no_of_book_text_2_BI.getText())){
                            Statement stt=conn.createStatement();
                            stt.executeUpdate("INSERT INTO `book_record_info`(`book_id`, `book_title`, `publisher`, `author`, `no_of_pieces`, `no_of_pieces_left`, `book_location`) VALUES ("
                                    + "\""+book_id_text_2_BI.getText().toUpperCase()+"\",\""+book_title_text_2_BI.getText()+"\",\""
                                            + pubisher_text_2_BI.getText()+"\",\""+author_text_2_BI.getText()+"\",\""
                                                    + Integer.parseInt(no_of_book_text_2_BI.getText())+"\",\""+Integer.parseInt(no_of_book_text_2_BI.getText())+"\",\""
                                                            + book_location_text_2_BI.getText()+"\")");
                            JOptionPane.showMessageDialog(null, "Sucessfully Added to the database!");
                            FillStudentTableBLT();
                            clearButton2BIButtonClickedListener(ae);
                        }else{
                            JOptionPane.showMessageDialog(null, "No of Book should be numeric!");
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }
    }
    @FXML
    public void clearButton2BIButtonClickedListener(ActionEvent ae){
        book_id_text_2_BI.setText("");
        book_title_text_2_BI.setText("");
        pubisher_text_2_BI.setText("");
        author_text_2_BI.setText("");
        no_of_book_text_2_BI.setText("");
        book_location_text_2_BI.setText("");        
    }
    
    
    
    
    //Librarian Table List FIll Events during Search
    @FXML
    public void deleteButtonMiddleLLTButtonClickedListener(ActionEvent ae){
        if(search_by_librarian_id_text_middle_LLT.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to delete Librarian Information?","Librarian Information Deletion",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from librarian_info where librarian_id=\""+search_by_librarian_id_text_middle_LLT.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("DELETE FROM `librarian_info` WHERE librarian_id=\""+search_by_librarian_id_text_middle_LLT.getText().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        clearButtonMiddleLLTButtonClickedListener(ae);
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Librarian ID!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clearButtonMiddleLLTButtonClickedListener(ActionEvent ae){
        search_by_librarian_id_text_middle_LLT.setText("");
        FillStudentTableST();
    }
    
    @FXML
    public void SearchByLibrarianIDTextMiddleLLTKeyPressedReleaseEventListener(KeyEvent ke){
        librarian_id_col_middle_LLT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        librarian_name_col_middle_LLT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        shift_col_middle_LLT.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        librarian_list_table_tableview_middle_LLT.setItems(getValuesForLibrarianTableListLLT(search_by_librarian_id_text_middle_LLT.getText().toUpperCase()));
    }
    
    //Librarian Table List FIll Methods 
    private ObservableList<AdmissionInformation> getValuesForLibrarianTableListLLT(String value){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from librarian_info where librarian_id like \""+value+"%\"");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("librarian_id"),rs.getString("librarian_name"),rs.getString("shift")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
     private void FillStudentTableST(){
        librarian_id_col_middle_LLT.setCellValueFactory(new PropertyValueFactory<>("aid"));
        librarian_name_col_middle_LLT.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        shift_col_middle_LLT.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        librarian_list_table_tableview_middle_LLT.setItems(getValuesForLibrarianTableListLLT());
     }
    
    
    private ObservableList<AdmissionInformation> getValuesForLibrarianTableListLLT(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select * from librarian_info");
            while(rs.next()){
                list.add(new AdmissionInformation(rs.getString("librarian_id"),rs.getString("librarian_name"),rs.getString("shift")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcademicRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    
    
    //Library Manager Event Occurs
    @FXML
    public void add1LMButtonClickedListener(ActionEvent ae){
        if(librarian_id_text_1_LM.getText().equals("")||librarian_name_text_1_LM.getText().equals("")
                ||librarian_shift_combo_1_LM.getValue().equals("")){
            JOptionPane.showMessageDialog(null, "Either of the textfield is empty!");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to add Librarian Information?","Librarian Information Insertion",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from librarian_info where librarian_id=\""+librarian_id_text_1_LM.getText().toUpperCase()+"\"");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Librarian ID already exist! Try Unique one!");
                    }else{
                        Statement stt=conn.createStatement();
                        stt.executeUpdate("INSERT INTO `librarian_info`(`librarian_id`, `librarian_name`, `shift`) VALUES (\""+librarian_id_text_1_LM.getText().toUpperCase()+"\","
                        +"\""+librarian_name_text_1_LM.getText()+"\",\""+librarian_shift_combo_1_LM.getValue()+"\")");
                        JOptionPane.showMessageDialog(null, "Sucessfully Inserted!");
                        FillStudentTableST();
                        clear1LMButtonClickedListener(ae);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(LibraryManagementController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    @FXML
    public void clear1LMButtonClickedListener(ActionEvent ae){
        librarian_id_text_1_LM.setText("");
        librarian_name_text_1_LM.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    @FXML
    private void add1HMButtonClickedListener(ActionEvent event) {
    }


    @FXML
    private void clear1HMButtonClickedListener(ActionEvent event) {
    }
    
    
    
    
    
    
    //all button color change events
    @FXML
    public void Add1LMbuttonEntered(MouseEvent me){
        add_button_1_LM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Add1LMbuttonExited(MouseEvent me){
        add_button_1_LM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1LMbuttonEntered(MouseEvent me){
        clear_button_1_LM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear1LMbuttonExited(MouseEvent me){
        clear_button_1_LM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Add2BIbuttonEntered(MouseEvent me){
        add_button_2_BI.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Add2BIbuttonExited(MouseEvent me){
        add_button_2_BI.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear2BIbuttonEntered(MouseEvent me){
        clear_button_2_BI.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear2BIbuttonExited(MouseEvent me){
        clear_button_2_BI.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Lend3BLbuttonEntered(MouseEvent me){
        lend_button_3_BL.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Lend3BLbuttonExited(MouseEvent me){
        lend_button_3_BL.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear3BLbuttonEntered(MouseEvent me){
        clear_button_3_BL.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear3BLbuttonExited(MouseEvent me){
        clear_button_3_BL.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit4ELMbuttonEntered(MouseEvent me){
        edit_button_4_ELM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit4ELMbuttonExited(MouseEvent me){
        edit_button_4_ELM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear4ELMbuttonEntered(MouseEvent me){
        clear_button_4_ELM.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear4ELMbuttonExited(MouseEvent me){
        clear_button_4_ELM.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit5BREbuttonEntered(MouseEvent me){
        edit_button_5_BRE.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Edit5BREbuttonExited(MouseEvent me){
        edit_button_5_BRE.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear5BREbuttonEntered(MouseEvent me){
        clear_button_5_BRE.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    public void Clear5BREbuttonExited(MouseEvent me){
        clear_button_5_BRE.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Return6BRbuttonEntered(MouseEvent me){
        return_button_6_BR.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Return6BRbuttonExited(MouseEvent me){
        return_button_6_BR.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear6BRbuttonEntered(MouseEvent me){
        clear_button_6_BR.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void Clear6BRbuttonExited(MouseEvent me){
        clear_button_6_BR.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleLLTbuttonEntered(MouseEvent me){
        delete_button_middle_LLT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleLLTbuttonExited(MouseEvent me){
        delete_button_middle_LLT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleLLTbuttonEntered(MouseEvent me){
        clear_button_middle_LLT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleLLTbuttonExited(MouseEvent me){
        clear_button_middle_LLT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleBLTbuttonEntered(MouseEvent me){
        delete_button_middle_BLT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleBLTbuttonExited(MouseEvent me){
        delete_button_middle_BLT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleBLTbuttonEntered(MouseEvent me){
        clear_button_middle_BLT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleBLTbuttonExited(MouseEvent me){
        clear_button_middle_BLT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleBLiTbuttonEntered(MouseEvent me){
        delete_button_middle_BLiT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteMiddleBLiTbuttonExited(MouseEvent me){
        delete_button_middle_BLiT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleBLiTbuttonEntered(MouseEvent me){
        clear_button_middle_BLiT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearMiddleBLiTbuttonExited(MouseEvent me){
        clear_button_middle_BLiT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteWholeRecordMiddleBRTbuttonEntered(MouseEvent me){
        delete_whole_record_button_middle_BRT.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void DeleteWholeRecordMiddleBRTbuttonExited(MouseEvent me){
        delete_whole_record_button_middle_BRT.setStyle("-fx-background-color:#408080;-fx-background-radius:3em;");
    }

}

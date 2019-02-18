/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class EditEnquiryFormController implements Initializable {

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
    private Button add_button_1;
    @FXML
    private Button clear_button_form_1;
    @FXML
    private RadioButton choice_student_1;
    @FXML
    private RadioButton choice_none_1;
    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
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
        ToggleGroup tg=new ToggleGroup();
        choice_student_1.setToggleGroup(tg);
        choice_none_1.setToggleGroup(tg);
        choice_student_1.setSelected(true);
        nationality_combo_1.setValue("");
        degree_combo_1.setValue("");
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select title from program_info");
            ObservableList<String> list=FXCollections.observableArrayList();
            while(rs.next()){
                list.add(rs.getString("title"));
            }
            degree_combo_1.setItems(list);
        }catch(SQLException ex){
            Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);

        }
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

    @FXML
    public void AddButtonEnquiryFormClickedListener(MouseEvent event) {
        if(enquiry_id_text_1.getText().toString().equals("")||full_name_text_1.getText().toString().equals("")
                ||email_text_1.getText().toString().equals("")||contact_no_text_1.getText().toString().equals("")
                ||full_address_textArea_1.getText().toString().equals("")||intrested_in_textArea_1.getText().toString().equals("")
                ||nationality_combo_1.getValue().toString().equals("")||degree_combo_1.getValue().toString().equals("")){
            JOptionPane.showMessageDialog(null,"Either of the field is not completed!");
            System.out.println(nationality_combo_1.getValue().toString().equals(""));
        }else{
            try {
                if(checkAllTextfield()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Update this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select enquiry_id from enquiry_info_details where enquiry_id=\""+enquiry_id_text_1.getText().toString().toUpperCase()+"\"");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Enquiry ID alredy existed! Try New One");
                        }else{
                            AdmissionManagementController amc=new AdmissionManagementController();
                            String status="";
                            if(choice_student_1.isSelected()){
                                status="Student";
                            }else{
                                status="None";
                            }
                            st.executeUpdate("update enquiry_info_details set "+ 
                                "     enquiry_id=\""+enquiry_id_text_1.getText().toString().toUpperCase() +"\",\n" +
                                "     full_name=\""+full_name_text_1.getText().toString() +"\",\n" +
                                "     email=\""+email_text_1.getText().toString()+"\",\n" +
                                "     contact=\""+contact_no_text_1.getText().toString()+"\",\n" +
                                "     full_address=\""+full_address_textArea_1.getText().toString()+"\",\n" +
                                "     status=\""+status+"\",\n" +
                                "     nationality=\""+nationality_combo_1.getValue().toString()+"\",\n" +
                                "     type_of_degree=\""+degree_combo_1.getValue().toString()+"\",\n" +
                                "     intrested_in=\""+intrested_in_textArea_1.getText().toString()+"\" where enquiry_id=\""+amc.getProgramIddd().toString()+"\"");
                            JOptionPane.showMessageDialog(null,"Enquiry Form is Sucessfully Updated!");
                            final Node source = (Node) event.getSource();
                            final Stage stage = (Stage) source.getScene().getWindow();
                            stage.close();
                        }
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Either Country Name or Types of degree is not choosed!");
            }
        }
    }

    @FXML
    public void clearButtonEnquiryFormClickedListener(MouseEvent event) {
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
}

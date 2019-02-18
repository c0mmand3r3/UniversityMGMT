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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class EditApplicationProcessAdmissionController implements Initializable {

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
    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
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
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("select title from program_info");
            ObservableList<String> list=FXCollections.observableArrayList();
            while(rs.next()){
                list.add(rs.getString("title"));
            }
            selected_program_combo_2.setItems(list);
        }catch(SQLException ex){
            Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);

        }
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
    public void Add2ButtonClickedListener(ActionEvent event) {
        if(application_id_text_2.getText().toString().equals("")||full_name_text_2.getText().toString().equals("")
                ||full_address_textarea_2.getText().toString().equals("")||email_text_2.getText().toString().equals("")
                ||contact_no_text_2.getText().toString().equals("")||marks_details_textarea_2.getText().toString().equals("")
                ||nationality_combo_2.getValue().toString().equals("")||addmission_type_combo_2.getValue().toString().equals("")
                ||selected_program_combo_2.getValue().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Application Form is not Completely Filled! Fill all the Blanks");
        }else{
            try {
                if(checkAllTextfieldApplication()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Update this Record?","Update Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        Statement st=conn.createStatement();
                        ResultSet rs=st.executeQuery("select aid from application_form_details where aid=\""+application_id_text_2.getText().toString().toUpperCase()+"\"");
                        if(rs.next()){
                            JOptionPane.showMessageDialog(null,"Application ID alredy existed! Try New One");
                        }else{
                            AdmissionManagementController amc=new AdmissionManagementController();
                            st.executeUpdate("update application_form_details set "+
                                    "aid=\""+application_id_text_2.getText().toString().toUpperCase()+"\","+
                                    "full_name=\""+full_name_text_2.getText().toString()+"\","+
                                    "full_address=\""+full_address_textarea_2.getText().toString()+"\","+
                                    "nationality=\""+nationality_combo_2.getValue().toString()+"\","+
                                    "email=\""+email_text_2.getText().toString()+"\","+
                                    "contact_no=\""+contact_no_text_2.getText().toString()+"\","+
                                    "admission_type=\""+addmission_type_combo_2.getValue().toString()+"\","+
                                    "selected_program=\""+selected_program_combo_2.getValue().toString()+"\","+
                                    "marks_details=\""+marks_details_textarea_2.getText().toString()+"\","+
                                    "process_status=0 where aid=\""+amc.getProgramIddd()+"\"");
                            JOptionPane.showMessageDialog(null,"Application Form is Sucessfully Updated!");
                            clear2ButtonClickedListener(event);
                            final Node source = (Node) event.getSource();
                            final Stage stage = (Stage) source.getScene().getWindow();
                            stage.close();
                        }
                    }
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdmissionManagementController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    public void clear2ButtonClickedListener(ActionEvent event) {
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
}

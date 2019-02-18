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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class CourseEditPanelController implements Initializable {

    @FXML
    private Button update_button_program;
    private Connection conn;
    @FXML
    private TextField course_id_textfield;
    @FXML
    private TextField course_name_textfield;
    @FXML
    private TextField credit_hours_textfield;
    @FXML
    private Button clear_button_program;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
    }  
    public boolean testCreditHourValidity(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}(\\.[0-9]{0,}){0,1}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
    }
    @FXML
    public void updateButtonClickedListener(MouseEvent me){
        if(course_id_textfield.getText().toString().equals("")
                ||course_name_textfield.getText().toString().equals("")||credit_hours_textfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Either one of the Text field is empty");
        }else{
            try {
                        CourseManagementSystemController mv=new CourseManagementSystemController();
                        int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
                        if(val==0){
                            if(testCreditHourValidity(credit_hours_textfield.getText().toString())){
                                Statement stt=conn.createStatement();
                                stt.executeUpdate("update course_info set"
                                        + " course_id=\""+course_id_textfield.getText().toString().toUpperCase()+"\","+
                                                 " course_name=\""+course_name_textfield.getText().toString()+"\",credit_hour="+Float.parseFloat(credit_hours_textfield.getText().toString())+"where"
                                                        + " course_id=\""+ mv.getProgramIddd().toUpperCase() +"\"");  
                                course_id_textfield.setText("");
                                course_name_textfield.setText("");
                                credit_hours_textfield.setText("");
                                JOptionPane.showMessageDialog(null, "Sucessfully added to the Database!");
                                final Node source = (Node) me.getSource();
                                final Stage stage = (Stage) source.getScene().getWindow();
                                stage.close();
                            }else{
                                JOptionPane.showMessageDialog(null, "Credit Hours Should be Positive Number");
                            }
                        }
                   
            } catch (SQLException ex) {
                Logger.getLogger(CourseManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void clearButtonClickedListener(MouseEvent me){
        course_id_textfield.setText("");
        course_name_textfield.setText("");
        credit_hours_textfield.setText("");
    }
    
    @FXML
    public void updateButtonEntered(MouseEvent me){
        update_button_program.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void updateButtonExited(MouseEvent me){
        update_button_program.setStyle("-fx-background-color:#620031;-fx-background-radius:3em;");
    }
    @FXML
    public void clearButtonEntered(MouseEvent me){
        clear_button_program.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void clearButtonExited(MouseEvent me){
        clear_button_program.setStyle("-fx-background-color:#620031;-fx-background-radius:3em;");
    }
}

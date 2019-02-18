/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class ProgramEditPanelController implements Initializable {

    @FXML
    private TextField program_id_text;
    @FXML
    private TextField title_text;
    @FXML
    private Button update_button_program;
    @FXML
    private Button clear_button_program;
    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
    }    

    @FXML
    public void updateButtonClickedListener(MouseEvent me){
        if(program_id_text.getText().toString().equals("")||title_text.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Textfield is Empty");
        }else{
            try {
                ProgramManagementSystemController mv=new ProgramManagementSystemController();
                Statement st=conn.createStatement();
                st.executeUpdate("update program_info set program_id=\""+program_id_text.getText().toString().toUpperCase()+
                        "\",title=\""+title_text.getText().toString()+ "\" where program_id=\""+mv.getProgramIddd().toUpperCase()+ "\"");
                JOptionPane.showMessageDialog(null, "Sucessfully Updated!");
                final Node source = (Node) me.getSource();
                final Stage stage = (Stage) source.getScene().getWindow();
                stage.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Occur! Can't Update. Try Again!");
            }
        }
    }
    @FXML
    public void clearButtonClickedListner(MouseEvent me){
        program_id_text.setText("");
        title_text.setText("");
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

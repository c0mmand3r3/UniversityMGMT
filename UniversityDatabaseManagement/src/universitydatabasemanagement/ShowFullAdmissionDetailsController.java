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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class ShowFullAdmissionDetailsController implements Initializable {

    @FXML
    private TableView<AdmissionInformation> full_application_tableview;
    @FXML
    private TableColumn<AdmissionInformation, String> id_col;
    @FXML
    private TableColumn<AdmissionInformation, String> full_name_col;
    @FXML
    private TableColumn<AdmissionInformation, String> address_col;
    @FXML
    private TableColumn<AdmissionInformation, String> nationality_col;
    @FXML
    private TableColumn<AdmissionInformation, String> email_col;
    @FXML
    private TableColumn<AdmissionInformation, String> contact_col;
    @FXML
    private TableColumn<AdmissionInformation, String> admission_type_col;
    @FXML
    private TableColumn<AdmissionInformation, String> selected_program_col;
    @FXML
    private TableColumn<AdmissionInformation, String> marks_details_col;
    @FXML
    private TableColumn<AdmissionInformation, String> selection_status_col;

    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        FillTableNow();
    }    
    private ObservableList<AdmissionInformation> getAllValuesForSearch2(){
        ObservableList<AdmissionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from application_form_details";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){  
                    list.add(new AdmissionInformation(rs.getString("aid"),rs.getString("full_name"),rs.getString("full_address"),rs.getString("nationality"),rs.getString("email"),rs.getString("contact_no"),rs.getString("admission_type")
                                ,rs.getString("selected_program"),rs.getString("marks_details"),rs.getString("selection_status")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    private void FillTableNow(){
        id_col.setCellValueFactory(new PropertyValueFactory<>("aid"));
        full_name_col.setCellValueFactory(new PropertyValueFactory<>("fullname"));
        address_col.setCellValueFactory(new PropertyValueFactory<>("fulladdress"));
        nationality_col.setCellValueFactory(new PropertyValueFactory<>("nationality"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        contact_col.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
        admission_type_col.setCellValueFactory(new PropertyValueFactory<>("admission_type"));
        selected_program_col.setCellValueFactory(new PropertyValueFactory<>("selected_program"));
        marks_details_col.setCellValueFactory(new PropertyValueFactory<>("marks_details"));
        selection_status_col.setCellValueFactory(new PropertyValueFactory<>("selection_status"));
        full_application_tableview.setItems(getAllValuesForSearch2());
    }
}

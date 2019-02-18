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
public class ShowCampusDetailsController implements Initializable {

    @FXML
    private TableView<CollegeCollectionInformation> show_tableview;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> cid_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> name_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> type_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> address_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> town_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> district_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> state_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> country_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> website_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> contact_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> email_col;
    @FXML
    private TableColumn<CollegeCollectionInformation, String> postbox_col;
    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        
        cid_col.setCellValueFactory(new PropertyValueFactory<>("cid"));
        name_col.setCellValueFactory(new PropertyValueFactory<>("college_name"));
        type_col.setCellValueFactory(new PropertyValueFactory<>("college_type"));
        address_col.setCellValueFactory(new PropertyValueFactory<>("full_address"));
        town_col.setCellValueFactory(new PropertyValueFactory<>("town"));
        district_col.setCellValueFactory(new PropertyValueFactory<>("district"));
        state_col.setCellValueFactory(new PropertyValueFactory<>("state"));
        country_col.setCellValueFactory(new PropertyValueFactory<>("country"));
        website_col.setCellValueFactory(new PropertyValueFactory<>("website"));
        contact_col.setCellValueFactory(new PropertyValueFactory<>("contact"));
        email_col.setCellValueFactory(new PropertyValueFactory<>("email"));
        postbox_col.setCellValueFactory(new PropertyValueFactory<>("post"));
        
        show_tableview.setItems(getAllValues());
    }    
    public ObservableList<CollegeCollectionInformation> getAllValues(){
        ObservableList<CollegeCollectionInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from affiliated_college,campus_address,campus_other_info "+
                        "where affiliated_college.campus_id=campus_address.campus_id and "+
                        "campus_other_info.campus_id=affiliated_college.campus_id";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                    list.add(new CollegeCollectionInformation(rs.getString("campus_id").toString(),
                        rs.getString("campus_name").toString(),rs.getString("campus_type").toString(),
                        rs.getString("full_address").toString(),rs.getString("town_name").toString(),
                        rs.getString("district_name").toString(),rs.getString("state_name").toString(),
                        rs.getString("country_name").toString(),rs.getString("website_name").toString(),
                        rs.getString("contact_number").toString(),rs.getString("email_address").toString(),
                        rs.getString("postbox_number").toString()));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
}

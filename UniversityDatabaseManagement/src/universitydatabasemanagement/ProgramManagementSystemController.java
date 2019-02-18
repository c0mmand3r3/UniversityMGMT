/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class ProgramManagementSystemController implements Initializable {

    @FXML
    private Button edit_button;
    @FXML
    private TextField program_id_text;
    @FXML
    private TextField title_text;
    @FXML
    private Button add_button_program;
    @FXML
    private Button clear_button_program;
  
    @FXML
    private TableView<ProgramInformation> program_information_table;
    @FXML
    private TableColumn<ProgramInformation, String> program_id_col;
    @FXML
    private TableColumn<ProgramInformation, String> program_title_col;
    @FXML
    private TableView<?> student_information_table;
    @FXML
    private TableColumn<?, ?> student_id_col;
    @FXML
    private TableColumn<?, ?> name_col;
    @FXML
    private TableColumn<?, ?> status_col;
    @FXML
    private TextField program_id_text_search;
    @FXML
    private Button delete_button;
    @FXML
    private Pane refresh_pane_program;
    @FXML
    private ImageView refresh_image_program;
    @FXML
    private Pane refresh_pane_student;
    @FXML
    private ImageView refresh_image_student;
    
    Connection conn;
    @FXML
    private Button clear_button_search;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        try{
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"program_info",null);
            if(rs.next()){
            
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table program_info(\n" +
                    "    program_id varchar(30) PRIMARY KEY,\n" +
                    "    title varchar(100) not null\n" +
                    "    );");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        program_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        program_title_col.setCellValueFactory(new PropertyValueFactory<>("title"));
        program_information_table.setItems(getAllValues());
    }    
    
    @FXML
    public void AddButtonClickedListener(MouseEvent mev){
        if(program_id_text.getText().toString().equals("")||title_text.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Text Field is Empty");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    st.executeUpdate("insert into program_info(program_id,title) VALUES (\""+
                            program_id_text.getText().toString().toUpperCase()+"\",\""+title_text.getText().toString()+ "\")");
                    program_id_text.setText("");
                    title_text.setText("");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Program ID already exits! Try new Program ID");
                }
            }
        }
        program_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        program_title_col.setCellValueFactory(new PropertyValueFactory<>("title"));
        program_information_table.setItems(getAllValues());
    }
    private static String programIddd;
    public void setProgramIddd(String programIddd){
        this.programIddd=programIddd;
        System.out.println("set ==="+this.programIddd);
    }
    public String getProgramIddd(){
        System.out.println("prev="+programIddd);
        return programIddd;
    }
    @FXML
    public void EditButtonClickedListener(MouseEvent mev) throws IOException{
        if(program_id_text_search.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select program_id from program_info where program_id=\""+program_id_text_search.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to update this Record?","Update Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        setProgramIddd(program_id_text_search.getText().toString());
                        Parent root = (Parent) FXMLLoader.load(getClass().getResource("ProgramEditPanel.fxml"));
                        Scene scene = new Scene(root);
                        Window existingWindow = ((Node) mev.getSource()).getScene().getWindow();

                        // create a new stage:
                        Stage stage = new Stage();
                        // make it modal:
                        stage.initModality(Modality.APPLICATION_MODAL);
                        // make its owner the existing window:
                        stage.initOwner(existingWindow);
                        stage.setTitle("Update Program");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.sizeToScene();
                        stage.show();
                        program_id_text_search.setText("");
                        System.out.println("returned");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Program ID does not exits! Try exist Program ID");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProgramManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    public void clearButtonSearchClickedListener(MouseEvent me){
        program_id_text_search.setText("");
    }
    @FXML
    public void EditRefresh(MouseEvent mev){
        program_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
        program_title_col.setCellValueFactory(new PropertyValueFactory<>("title"));
        program_information_table.setItems(getAllValues());
    }
    @FXML
    public void DeleteButtonClickedListener(MouseEvent mev){
        if(program_id_text_search.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Search Text Field is Empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select program_id from program_info where program_id=\""+program_id_text_search.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Record?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("delete from program_info where program_id=\""+program_id_text_search.getText().toString().toUpperCase()+"\"");
                        JOptionPane.showMessageDialog(null, "Sucessfully Deleted!");
                        program_id_text_search.setText("");
                        program_id_col.setCellValueFactory(new PropertyValueFactory<>("id"));
                        program_title_col.setCellValueFactory(new PropertyValueFactory<>("title"));
                        program_information_table.setItems(getAllValues());
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Program ID does not exits! Try exist Program ID");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Program ID does not exits! Try exist Program ID");
            }
        }
    }
    @FXML
    public void ClearButtonClickedListener(MouseEvent mev){
        program_id_text.setText("");
        title_text.setText("");
    }
    
    private ObservableList<ProgramInformation> getAllValues(){
        ObservableList<ProgramInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from program_info";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                String id="";
                String title="";
                while(rs.next()){
                    id=rs.getString("program_id").toString();
                    title=rs.getString("title").toString();
                    list.add(new ProgramInformation(id,title));
                //    System.out.println(id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
    }
    @FXML
    public void AddbuttonEntered(MouseEvent me){
        add_button_program.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void AddbuttonExited(MouseEvent me){
        add_button_program.setStyle("-fx-background-color:#620031;-fx-background-radius:3em;");
    }
    @FXML
     public void ClearbuttonEntered(MouseEvent me){
        clear_button_program.setStyle("-fx-background-color:#530488;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearbuttonExited(MouseEvent me){
        clear_button_program.setStyle("-fx-background-color:#620031;-fx-background-radius:3em;");
    }
    @FXML
     public void EditbuttonEntered(MouseEvent me){
        edit_button.setStyle("-fx-background-color:#530488;");
    }
    @FXML
    public void EditbuttonExited(MouseEvent me){
        edit_button.setStyle("-fx-background-color:#38baaa;");
    }
    @FXML
     public void DeletebuttonEntered(MouseEvent me){
        delete_button.setStyle("-fx-background-color:#530488;");
    }
    @FXML
    public void DeletebuttonExited(MouseEvent me){
        delete_button.setStyle("-fx-background-color:#38baaa;");
    }
    @FXML
    public void RefreshbuttonExited(MouseEvent event) {
        refresh_pane_program.setStyle("-fx-background-color:#38baaa;-fx-background-radius:1em;");

    }

    @FXML
    public void RefreshbuttonEntered(MouseEvent event) {
        refresh_pane_program.setStyle("-fx-background-color:#e0d11f;-fx-background-radius:1em;");

    }
    @FXML
    public void RefreshbuttonExitedStudent(MouseEvent event) {
        refresh_pane_student.setStyle("-fx-background-color:#38baaa;-fx-background-radius:1em;");

    }

    @FXML
    public void RefreshbuttonEnteredStudent(MouseEvent event) {
        refresh_pane_student.setStyle("-fx-background-color:#e0d11f;-fx-background-radius:1em;");

    }
    @FXML
     public void ClearSearchbuttonEntered(MouseEvent me){
        clear_button_search.setStyle("-fx-background-color:#530488;");
    }
    @FXML
    public void ClearSearchbuttonExited(MouseEvent me){
        clear_button_search.setStyle("-fx-background-color:#38baaa;");
    }
}

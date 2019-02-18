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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
public class CourseManagementSystemController implements Initializable {

    @FXML
    private TextField program_id_textfield;
    @FXML
    private TextField course_id_textfield;
    @FXML
    private TextField course_name_textfield;
    @FXML
    private TextField credit_hours_textfield;
    @FXML
    private Button add_button;
    @FXML
    private Button clear_button;
    @FXML
    private Button preview_button;
    @FXML
    private TableView<CourseInformation> course_information_tableview;
    @FXML
    private TableColumn<CourseInformation, String> program_id_column;
    @FXML
    private TableColumn<CourseInformation, String> course_id_column;
    @FXML
    private TableColumn<CourseInformation, String> course_name_column;
    @FXML
    private TableColumn<CourseInformation, Float> credit_hours_column;
    @FXML
    private TableView<ProgramInformation> program_information_tableview;
    @FXML
    private TableColumn<ProgramInformation,String> program_id_column_program;
    @FXML
    private TableColumn<ProgramInformation,String> program_name_column_program;
    @FXML
    private TextField search_course_id_textfield;
    @FXML
    private Button edit_button;
    @FXML
    private Button delete_button;
    @FXML
    private Pane refresh_pane;
    @FXML
    private ImageView add_record_image_symbol;
    @FXML
    private Button add_to_next_program_button;
    private Connection conn;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        conn=DBMSConnector_login.connect_Database();
        program_id_column_program.setCellValueFactory(new PropertyValueFactory<>("id"));
        program_name_column_program.setCellValueFactory(new PropertyValueFactory<>("title"));
        program_information_tableview.setItems(getAllValues());
        
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"course_info",null);
            if(rs.next()){
                //true part
                System.out.println("true");
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table course_info(\n" +
                    "    course_id varchar(100),\n" +
                    "    program_id varchar(100) not null,\n" +
                    "    course_name varchar(200) not null,\n" +
                    "    credit_hour float not null,\n" +
                    "    primary key(course_id,program_id),\n"+
                    "    foreign key(program_id) REFERENCES program_info(program_id) on delete CASCADE on UPDATE CASCADE\n" +
                    "    )");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        program_id_column.setCellValueFactory(new PropertyValueFactory<>("pid"));
        course_id_column.setCellValueFactory(new PropertyValueFactory<>("cid"));
        course_name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
        credit_hours_column.setCellValueFactory(new PropertyValueFactory<>("credit"));
        course_information_tableview.setItems(getAllValuesCourse());
        
    }    
    public boolean testCreditHourValidity(String value){
        Pattern pat=Pattern.compile("^[0-9][0-9]{0,}(\\.[0-9]{0,}){0,1}");
        Matcher mat=pat.matcher(value);
        return mat.matches();
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
    public void addButtonClickedListener(MouseEvent me){
        if(program_id_textfield.getText().toString().equals("")||course_id_textfield.getText().toString().equals("")
                ||course_name_textfield.getText().toString().equals("")||credit_hours_textfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Either one of the Text field is empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select program_id from program_info where program_id=\""+program_id_textfield.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    //true statement
                    ResultSet ps=st.executeQuery("select course_id from course_info where course_id=\""+course_id_textfield.getText().toString().toUpperCase()+"\"");
                    if(!ps.next()){
                        int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
                        if(val==0){
                            if(testCreditHourValidity(credit_hours_textfield.getText().toString())){
                                Statement stt=conn.createStatement();
                                stt.executeUpdate("insert into course_info(course_id,program_id,course_name,credit_hour)"
                                        + " VALUES(\""+course_id_textfield.getText().toString().toUpperCase()+"\",\""+program_id_textfield.getText().toString().toUpperCase()
                                                + "\",\""+course_name_textfield.getText().toString()+"\","+Float.parseFloat(credit_hours_textfield.getText().toString())+")");  
                                program_id_column.setCellValueFactory(new PropertyValueFactory<>("pid"));
                                course_id_column.setCellValueFactory(new PropertyValueFactory<>("cid"));
                                course_name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                                credit_hours_column.setCellValueFactory(new PropertyValueFactory<>("credit"));
                                course_information_tableview.setItems(getAllValuesCourse());
                                program_id_textfield.setText("");
                                course_id_textfield.setText("");
                                course_name_textfield.setText("");
                                credit_hours_textfield.setText("");
                                JOptionPane.showMessageDialog(null, "Sucessfully added to the Database!");
                            }else{
                                JOptionPane.showMessageDialog(null, "Credit Hours Should be Positive Number");
                            }
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Course ID should be Unique! Try new unique ID");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Program ID doesn't match! Try valid Program ID");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void clearButtonClickedListener(MouseEvent me){
        program_id_textfield.setText("");
        course_id_textfield.setText("");
        course_name_textfield.setText("");
        credit_hours_textfield.setText("");
    }
    public void previewButtonClickedListener(MouseEvent me){
        if(program_id_textfield.getText().toString().equals("")||course_id_textfield.getText().toString().equals("")
                ||course_name_textfield.getText().toString().equals("")||credit_hours_textfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Either one of the Text field is empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select program_id from program_info where program_id=\""+program_id_textfield.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Program ID : "+program_id_textfield.getText().toString()
                    + "\nCourse ID : "+course_name_textfield.getText().toString()
                    + "\nCourse Name : "+course_name_textfield.getText().toString()
                    + "\nCredit Hours : "+credit_hours_textfield.getText().toString());
                }
                else{
                    JOptionPane.showMessageDialog(null, "Program ID doesn't matched! Try Existed Program ID!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void refreshPaneButtonClickedListener(MouseEvent me){
        program_id_column.setCellValueFactory(new PropertyValueFactory<>("pid"));
        course_id_column.setCellValueFactory(new PropertyValueFactory<>("cid"));
        course_name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
        credit_hours_column.setCellValueFactory(new PropertyValueFactory<>("credit"));
        course_information_tableview.setItems(getAllValuesCourse());
    }
    public void deleteButtonClickedListener(MouseEvent me){
        if(search_course_id_textfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Course ID is empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select course_id from course_info where course_id=\""+search_course_id_textfield.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Record?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        st.executeUpdate("delete from course_info where course_id=\""+search_course_id_textfield.getText().toString().toUpperCase()+"\"");
                        program_id_column.setCellValueFactory(new PropertyValueFactory<>("pid"));
                        course_id_column.setCellValueFactory(new PropertyValueFactory<>("cid"));
                        course_name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                        credit_hours_column.setCellValueFactory(new PropertyValueFactory<>("credit"));
                        course_information_tableview.setItems(getAllValuesCourse());
                        search_course_id_textfield.setText("");
                        JOptionPane.showMessageDialog(null, "Successfully Deleted!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Course ID doesn't matched");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void editButtonClickedListener(MouseEvent me) throws IOException{
        if(search_course_id_textfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Course ID is empty");
        }else{
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery("select course_id from course_info where course_id=\""+search_course_id_textfield.getText().toString().toUpperCase()+"\"");
                if(rs.next()){
                    int val=JOptionPane.showConfirmDialog(null,"Do you want to Edit this Record?","Edit Confirmation",JOptionPane.YES_NO_OPTION);
                    if(val==0){
                        setProgramIddd(search_course_id_textfield.getText().toString());
                        Parent root = (Parent) FXMLLoader.load(getClass().getResource("CourseEditPanel.fxml"));
                        Scene scene = new Scene(root);
                        Window existingWindow = ((Node) me.getSource()).getScene().getWindow();

                        // create a new stage:
                        Stage stage = new Stage();
                        // make it modal:
                        stage.initModality(Modality.APPLICATION_MODAL);
                        // make its owner the existing window:
                        stage.initOwner(existingWindow);
                        stage.setTitle("Update Course");
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.sizeToScene();
                        stage.show();
                        search_course_id_textfield.setText("");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Course ID is Invalid!");
                }
            } catch (SQLException ex) {
                Logger.getLogger(CourseManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void addToProgramClickedListener(MouseEvent me){
        if(search_course_id_textfield.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Course ID is empty");
        }else{
            int val=JOptionPane.showConfirmDialog(null,"Do you want to Add this Record?","Add Confirmation",JOptionPane.YES_NO_OPTION);
            if(val==0){
                try {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select * from course_info where course_id=\""+search_course_id_textfield.getText().toString().toUpperCase()+"\"");
                    if(rs.next()){
                        String prog_id=JOptionPane.showInputDialog("Add to\nProgram ID : ");
                        try{
                            Statement stt=conn.createStatement();
                            ResultSet rss=stt.executeQuery("select program_id from program_info where program_id=\""+prog_id.toString().toUpperCase()+"\"");
                            if(rss.next()){
                                stt.executeUpdate("insert into course_info(course_id,program_id,course_name,credit_hour)"
                                        + " VALUES(\""+rs.getString("course_id").toString()+"\",\""+prog_id.toString().toUpperCase()
                                                + "\",\""+rs.getString("course_name").toString()+"\","+rs.getFloat("credit_hour")+")");
                                program_id_column.setCellValueFactory(new PropertyValueFactory<>("pid"));
                                course_id_column.setCellValueFactory(new PropertyValueFactory<>("cid"));
                                course_name_column.setCellValueFactory(new PropertyValueFactory<>("coursename"));
                                credit_hours_column.setCellValueFactory(new PropertyValueFactory<>("credit"));
                                course_information_tableview.setItems(getAllValuesCourse()); 
                                search_course_id_textfield.setText("");
                                JOptionPane.showMessageDialog(null, "Sucessfully Added!");
                            }else{
                                JOptionPane.showMessageDialog(null, "Program ID Invalid!");
                            }
                        }catch (SQLException exx) {
                            JOptionPane.showMessageDialog(null, "Course Already Added!");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Course ID!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CourseManagementSystemController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    private ObservableList<CourseInformation> getAllValuesCourse(){
        ObservableList<CourseInformation> list=FXCollections.observableArrayList();
        try {
                String query="select * from course_info";
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);
                while(rs.next()){
                    list.add(new CourseInformation(rs.getString("program_id"),rs.getString("course_id"),
                        rs.getString("course_name"),rs.getFloat("credit_hour")));
                //    System.out.println(id);
                }
            } catch (SQLException ex) {
                Logger.getLogger(ShowCampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        return list;
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
    public void AddbuttonEntered(MouseEvent me){
        add_button.setStyle("-fx-background-color:#625aa5;-fx-background-radius:3em;");
    }
    @FXML
    public void AddbuttonExited(MouseEvent me){
        add_button.setStyle("-fx-background-color:#38baaa;-fx-background-radius:3em;");
    }
    public void PreviewbuttonEntered(MouseEvent me){
        preview_button.setStyle("-fx-background-color:#625aa5;-fx-background-radius:3em;");
    }
    @FXML
    public void PreviewbuttonExited(MouseEvent me){
        preview_button.setStyle("-fx-background-color:#38baaa;-fx-background-radius:3em;");
    }
    public void ClearbuttonEntered(MouseEvent me){
        clear_button.setStyle("-fx-background-color:#625aa5;-fx-background-radius:3em;");
    }
    @FXML
    public void ClearbuttonExited(MouseEvent me){
        clear_button.setStyle("-fx-background-color:#38baaa;-fx-background-radius:3em;");
    }
    
    public void EditbuttonEntered(MouseEvent me){
        edit_button.setStyle("-fx-background-color:#625aa5;");
    }
    @FXML
    public void EditbuttonExited(MouseEvent me){
        edit_button.setStyle("-fx-background-color:#38baaa;");
    }
    public void DeletebuttonEntered(MouseEvent me){
        delete_button.setStyle("-fx-background-color:#e2351d;");
    }
    @FXML
    public void DeletebuttonExited(MouseEvent me){
        delete_button.setStyle("-fx-background-color:#38baaa;");
    }
    public void AddTobuttonEntered(MouseEvent me){
        add_to_next_program_button.setStyle("-fx-background-color:#625aa5;");
    }
    @FXML
    public void AddTobuttonExited(MouseEvent me){
        add_to_next_program_button.setStyle("-fx-background-color:#38baaa;");
    }
    public void RefreshbuttonEntered(MouseEvent me){
        refresh_pane.setStyle("-fx-background-color:#edcc12;-fx-background-radius:3em;");
    }
    @FXML
    public void RefreshbuttonExited(MouseEvent me){
        refresh_pane.setStyle("-fx-background-color:#38baaa;-fx-background-radius:3em;");
    }
}

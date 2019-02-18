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
import java.sql.PreparedStatement;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class CampusDetailsController implements Initializable {

    @FXML
    private AnchorPane Background_view;
    @FXML
    private Button Add_record_pane;
    @FXML
    private Button update_record_pane;
    @FXML
    private Button search_record_pane;
    @FXML
    private Button delete_record_pane;
    @FXML
    private Button show_record_pane;
    @FXML
    private Pane go_back_image_pane;
    private Pane close_image_pane;
    @FXML
    private Pane minimize_image_pane;
    @FXML
    private ImageView minimize_image_view;
    @FXML
    private ImageView go_back_image_view;
    @FXML
    private TextField campus_id_text;
    @FXML
    private TextField campus_name_text;
    @FXML
    private ChoiceBox<String> college_type_choice;
    @FXML
    private TextField full_address_text;
    @FXML
    private TextField district_name_text;
    @FXML
    private TextField state_name_text;
    @FXML
    private TextField country_name_text;
    @FXML
    private TextField website_name_text;
    @FXML
    private TextField contact_number_text;
    @FXML
    private TextField email_address_text;
    @FXML
    private TextField post_box_number_text;
    @FXML
    private Pane Add_record_pane_whole;
    @FXML
    private Pane cancel_record_pane_whole;
    @FXML
    private TextField town_name_text;
    @FXML
    private ImageView correct_campus_name_image;
    @FXML
    private ImageView error_campus_name_image;
    @FXML
    private ImageView correct_full_address_images;
    @FXML
    private ImageView correct_town_name_images;
    @FXML
    private ImageView correct_district_images;
    @FXML
    private ImageView correct_state_image;
    @FXML
    private ImageView correct_country_images;
    @FXML
    private ImageView correct_website_images;
    @FXML
    private ImageView correct_contact_images;
    @FXML
    private ImageView correct_email_images;
    @FXML
    private ImageView correct_postbox_images;
    @FXML
    private ImageView error_full_address_image;
    @FXML
    private ImageView error_town_name_images;
    @FXML
    private ImageView error_district_images;
    @FXML
    private ImageView error_state_images;
    @FXML
    private ImageView error_country_images;
    @FXML
    private ImageView error_website_images;
    @FXML
    private ImageView error_contact_image;
    @FXML
    private ImageView error_email_images;
    @FXML
    private ImageView error_postbox_images;
    @FXML
    private ImageView add_image_click;
    @FXML
    private Label add_label;
    @FXML
    private ImageView cancel_image_click;
    @FXML
    private Label cancel_label;

    /**
     * Initializes the controller class.
     */
    Connection conn;
    String last_id=null;
    int id_key;
    private Label message_show;
    @FXML
    private AnchorPane add_record_anchorpane;
    @FXML
    private AnchorPane update_record_anchorpane;
    @FXML
    private ComboBox<String> update_campus_choose_combo;
    @FXML
    private Pane find_button_update;
    @FXML
    private ImageView search_image_update;
    @FXML
    private Label find_tag_label_update;
    @FXML
    private AnchorPane update_anchorpane;
    private TextField campus_id_text_update;
    @FXML
    private ImageView correct_campus_name_image1;
    @FXML
    private ImageView error_campus_name_image1;
    @FXML
    private ImageView correct_full_address_images1;
    @FXML
    private ImageView correct_town_name_images1;
    @FXML
    private ImageView correct_district_images1;
    @FXML
    private ImageView correct_state_image1;
    @FXML
    private ImageView correct_country_images1;
    @FXML
    private ImageView correct_website_images1;
    @FXML
    private ImageView correct_contact_images1;
    @FXML
    private ImageView correct_email_images1;
    @FXML
    private ImageView correct_postbox_images1;
    @FXML
    private ImageView error_full_address_image1;
    @FXML
    private ImageView error_town_name_images1;
    @FXML
    private ImageView error_district_images1;
    @FXML
    private ImageView error_state_images1;
    @FXML
    private ImageView error_country_images1;
    @FXML
    private ImageView error_website_images1;
    @FXML
    private ImageView error_contact_image1;
    @FXML
    private ImageView error_email_images1;
    @FXML
    private ImageView error_postbox_images1;
    @FXML
    private TextField campus_id_text1;
    @FXML
    private TextField campus_name_text1;
    @FXML
    private ChoiceBox<String> college_type_choice1;
    @FXML
    private TextField full_address_text1;
    @FXML
    private TextField town_name_text1;
    @FXML
    private TextField district_name_text1;
    @FXML
    private TextField state_name_text1;
    @FXML
    private TextField country_name_text1;
    @FXML
    private TextField website_name_text1;
    @FXML
    private TextField contact_number_text1;
    @FXML
    private TextField email_address_text1;
    @FXML
    private TextField post_box_number_text1;
    @FXML
    private Pane Add_record_pane_whole1;
    @FXML
    private ImageView add_image_click1;
    @FXML
    private Label add_label1;
    @FXML
    private Pane cancel_record_pane_whole1;
    @FXML
    private ImageView cancel_image_click1;
    @FXML
    private Label cancel_label1;
    @FXML
    private AnchorPane search_record_anchorpane;
    private ImageView add_record_image_symbol;
    private Label add_record_label;
    private ImageView update_record_image_symbol;
    private Label update_record_label;
    private ImageView search_record_image_symbol;
    private Label search_record_label;
    @FXML
    private TableView<CollegeInformation> college_information_tableview;
    @FXML
    private TableColumn<CollegeInformation, String> campus_id_column;
    @FXML
    private TableColumn<CollegeInformation, String> college_name_column;
    @FXML
    private TableColumn<CollegeInformation, String> college_type_column;
    @FXML
    private TableView<LocationInformation> location_information_tableview;
    @FXML
    private TableColumn<LocationInformation, String> full_address_column;
    @FXML
    private TableColumn<LocationInformation, String> town_city_village_column;
    @FXML
    private TableColumn<LocationInformation, String> district_column;
    @FXML
    private TableColumn<LocationInformation, String> state_column;
    @FXML
    private TableColumn<LocationInformation, String> country_column;
    @FXML
    private TableView<AdditionalInformation> additional_information_tableview;
    @FXML
    private TableColumn<AdditionalInformation, String> website_column;
    @FXML
    private TableColumn<AdditionalInformation, String> contact_number_column;
    @FXML
    private TableColumn<AdditionalInformation, String> email_column;
    @FXML
    private TableColumn<AdditionalInformation, String> postbox_column;
    @FXML
    private Pane okay_pane_search;
    @FXML
    private ImageView search_okay_image_pane;
    @FXML
    private Label search_okay_label_pane;
    private AnchorPane search_another_anchorpane;
    @FXML
    private Pane search_button_pane_search;
    @FXML
    private ComboBox<String> search_campus_choose_combo;
    private ImageView delete_image_record_imageView;
    private Label delete_record_label;
    @FXML
    private ImageView search_image_search;
    @FXML
    private Label find_tag_label_search;
    @FXML
    private AnchorPane delete_record_anchorpane;
    private ComboBox<?> delete_campus_choose_combo;
    @FXML
    private Pane delete_button_pane;
    @FXML
    private ImageView delete_image_imageView;
    @FXML
    private Label delete_label_of_pane;
    @FXML
    private AnchorPane delete_anchorpane_show;
    @FXML
    private Label delete_record_information_label;
    @FXML
    private Button yes_button;
    @FXML
    private ComboBox<String> delete_campus_choose_combo_ComboBox;
    @FXML
    private AnchorPane search_result_anchorpane;
    @FXML
    private Button show_record_button_show;
    @FXML
    private AnchorPane show_record_anchorpane_show;
    private ImageView show_record_image;
    private Label show_record_label;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      //  Background_view.setLayoutX(-200);
       // Background_view.setLayoutY(-100);
       search_result_anchorpane.setVisible(false);
       show_record_anchorpane_show.setVisible(false);
        update_anchorpane.setVisible(false);
        setcolor(Add_record_pane);
        college_type_choice.getItems().addAll("Private","Government","Private+Government");
        college_type_choice.setValue("Private");
        conn=DBMSConnector_login.connect_Database();
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"Affiliated_college",null);
            if(rs.next()){
                //true part
                Statement st=conn.createStatement();
                ResultSet result=st.executeQuery("select campus_id from affiliated_college");
                while(result.next()){
                    last_id=result.getString("campus_id");
                    System.out.println(last_id);
                }
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table Affiliated_college(\n" +
                    "    campus_id varchar(30) PRIMARY KEY,\n" +
                    "    campus_name varchar(100) not null,\n" +
                    "    campus_type varchar(30) not null\n" +
                    "    )");
                last_id=null;
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"campus_address",null);
            if(rs.next()){
                //true part
                System.out.println("true");
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table campus_address(\n" +
                    "    campus_id varchar(30),\n" +
                    "    full_address varchar(100) not null,\n" +
                    "    town_name varchar(50) not null,\n" +
                    "    district_name varchar(50) not null,\n" +
                    "    state_name varchar(50) not null,\n" +
                    "    country_name varchar(50) not null,\n" +
                    "    primary key(campus_id),\n" +
                    "    foreign key(campus_id) references Affiliated_college(campus_id) on delete cascade on update cascade\n" +
                    "    )");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            DatabaseMetaData db=conn.getMetaData();
            ResultSet rs=db.getTables(null,null,"campus_other_info",null);
            if(rs.next()){
                //true part
                System.out.println("true");
            }else{
                Statement st=conn.createStatement();
                st.executeUpdate("create table campus_other_info(\n" +
                    "    campus_id varchar(30),\n" +
                    "    website_name varchar(100)not null,\n" +
                    "    contact_number varchar(30) not null,\n" +
                    "    email_address varchar(50) not null unique,\n" +
                    "    postbox_number varchar(30) not null,\n" +
                    "    primary key(campus_id),\n" +
                    "    foreign key(campus_id) references Affiliated_college(campus_id) on delete cascade on update cascade\n" +
                    "    )");
                System.out.println("table created");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Sucessfull executed");
        if(last_id==null){
            last_id="ca101";
        }else{
            last_id=last_id.substring(2);
            id_key=Integer.parseInt(last_id);
            id_key++;
            last_id=String.valueOf("ca"+id_key);
        }
        campus_id_text.setText(last_id);
        add_record_anchorpane.toFront();
        add_record_anchorpane.setVisible(true);
        update_record_anchorpane.setVisible(false);
        search_record_anchorpane.setVisible(false);
        search_record_anchorpane.toBack();
        update_record_anchorpane.toBack();
        delete_record_anchorpane.setVisible(false);
        delete_record_anchorpane.toBack();
        Add_record_pane.setStyle("-fx-background-color:#817ccb;");
    }    
    @FXML
    public void mouseEntered(MouseEvent ev){
        
        
        if(ev.getTarget()==go_back_image_pane){
            go_back_image_pane.setStyle("-fx-background-color:#0078d7;");
        }
        if(ev.getTarget()==close_image_pane){
            close_image_pane.setStyle("-fx-background-color:#df4928;");
        }
        if(ev.getTarget()==minimize_image_pane){
            minimize_image_pane.setStyle("-fx-background-color:#cdcdcd;");
        }
        if(ev.getTarget()==Add_record_pane_whole){
            Add_record_pane_whole.setStyle("-fx-background-color:#3c3f41; -fx-background-radius:3em;");
        }
        if(ev.getTarget()==cancel_record_pane_whole){
            cancel_record_pane_whole.setStyle("-fx-background-color:#3c3f41; -fx-background-radius:3em;");
        }
        
    }
    
    @FXML
    public void mouseEnteredRight(MouseEvent ev){
        if(ev.getTarget()==Add_record_pane){
            setcolor(Add_record_pane);
        }
        if(ev.getTarget()==update_record_pane){
            setcolor(update_record_pane);
        }
        if(ev.getTarget()==search_record_pane){
            setcolor(search_record_pane);
        }
        if(ev.getTarget()==delete_record_pane){
            setcolor(delete_record_pane);
        }
        if(ev.getTarget()==show_record_pane){
            setcolor(show_record_pane);
        }
    }
    @FXML
    public void mouseExitedRight(MouseEvent ev){
        if(ev.getTarget()==Add_record_pane){
            resetcolor(Add_record_pane);
        }
        if(ev.getTarget()==update_record_pane){
            resetcolor(update_record_pane);
        }
        if(ev.getTarget()==search_record_pane){
            resetcolor(search_record_pane);
        }
        if(ev.getTarget()==delete_record_pane){
            resetcolor(delete_record_pane);
        }
        if(ev.getTarget()==show_record_pane){
            resetcolor(show_record_pane);
        }
    }
    
    @FXML
    public void mouseExited(MouseEvent ev){
        
        if(ev.getTarget()==go_back_image_pane){
            go_back_image_pane.setStyle("-fx-background-color:#393582;");
        }
        if(ev.getTarget()==close_image_pane){
            close_image_pane.setStyle("-fx-background-color:#f4f4f4;");
        }
         if(ev.getTarget()==minimize_image_pane){
            minimize_image_pane.setStyle("-fx-background-color:#f4f4f4;");
        }
        if(ev.getTarget()==Add_record_pane_whole){
            Add_record_pane_whole.setStyle("-fx-background-color:#d1d1d1; -fx-background-radius:3em;");
        }
        if(ev.getTarget()==cancel_record_pane_whole){
            cancel_record_pane_whole.setStyle("-fx-background-color:#d1d1d1; -fx-background-radius:3em;");
        }
    }
    private void setcolor(Button pa){
        pa.setStyle("-fx-background-color:#0078d7;");
    }
    private void resetcolor(Button pa){
        pa.setStyle("-fx-background-color:#4f49b4;");
    }
    @FXML
    public void actionEventOnEachPane(MouseEvent mev) throws IOException{
        
        
        if(mev.getTarget()==minimize_image_pane||mev.getTarget()==minimize_image_view){
            Stage stg=(Stage)Background_view.getScene().getWindow();
            stg.setIconified(true);
        }
        if(mev.getTarget()==go_back_image_pane||mev.getTarget()==go_back_image_view){
            Parent pp;
            pp=(AnchorPane)FXMLLoader.load(getClass().getResource("MainChooser.fxml"));
            String css=this.getClass().getResource("mainchooser.css").toExternalForm();
            Scene scene=new Scene(pp);
            scene.getStylesheets().add(css);
            Stage stg=(Stage)Background_view.getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        }
    }
    @FXML
    public void showRecordButtonClickedListenerCampus(MouseEvent mev) throws IOException{
        Parent pp=(AnchorPane)FXMLLoader.load(getClass().getResource("ShowCampusDetails.fxml"));
        Scene scene=new Scene(pp);
        Stage stage=new Stage();
        stage.setScene(scene);
        stage.setTitle("Campus Details Record");
        stage.show();
    }
    @FXML
    public void MouseOnDragWithWindow(MouseEvent mev){
        //window drag
        if(mev.getTarget()==Background_view){
            Stage stg=(Stage)Background_view.getScene().getWindow();
            stg.setX(mev.getX());
            stg.setY(mev.getY());
            stg.show();
        }
    }
    @FXML
    public void checkwhileTypingEveryTextfieldCampusName(KeyEvent keyev){
        if(stringCheck(campus_name_text,"^[A-Za-z][A-Za-z\\s]{0,}")){
            correct_campus_name_image.setVisible(true);
            error_campus_name_image.setVisible(false);
        }else{
            error_campus_name_image.setVisible(true);
            correct_campus_name_image.setVisible(false);
        }
    }
    @FXML
    public void addressMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(full_address_text,"^[a-zA-Z0-9][a-zA-Z0-9\\,\\-\\s]{0,}")){
            error_full_address_image.setVisible(false);
            correct_full_address_images.setVisible(true);
        }else{
            error_full_address_image.setVisible(true);
            correct_full_address_images.setVisible(false);
        }
    }
    @FXML
    public void townVillageCityMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(town_name_text,"^[a-zA-Z][a-zA-Z\\-]{0,}")){
            error_town_name_images.setVisible(false);
            correct_town_name_images.setVisible(true);
        }else{
            error_town_name_images.setVisible(true);
            correct_town_name_images.setVisible(false);
        }
    }
    @FXML
    public void DistrictMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(district_name_text,"^[a-zA-Z][a-zA-Z]{0,}")){
            error_district_images.setVisible(false);
            correct_district_images.setVisible(true);
        }else{
            error_district_images.setVisible(true);
            correct_district_images.setVisible(false);
        }
    }
    @FXML
    public void StateMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(state_name_text,"^[a-zA-Z][a-zA-Z]{0,}")){
            error_state_images.setVisible(false);
            correct_state_image.setVisible(true);
        }else{
            error_state_images.setVisible(true);
            correct_state_image.setVisible(false);
        }
    }
    @FXML
    public void CountryMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(country_name_text,"^[a-zA-Z][a-zA-Z]{0,}")){
            error_country_images.setVisible(false);
            correct_country_images.setVisible(true);
        }else{
            error_country_images.setVisible(true);
            correct_country_images.setVisible(false);
        }
    }
    @FXML
    public void WebsiteMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(website_name_text,"^[a-zA-Z][a-zA-Z]{0,}\\.[a-zA-Z]{1,}(\\.[a-zA-Z]{1,})*")){
            error_website_images.setVisible(false);
            correct_website_images.setVisible(true);
        }else{
            error_website_images.setVisible(true);
            correct_website_images.setVisible(false);
        }
    }
    @FXML
    public void ContactMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(contact_number_text,"^[0-9][0-9]{5,}")){
            error_contact_image.setVisible(false);
            correct_contact_images.setVisible(true);
        }else{
            error_contact_image.setVisible(true);
            correct_contact_images.setVisible(false);
        }
    }
    @FXML
    public void EmailMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(email_address_text,"^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$")){
            error_email_images.setVisible(false);
            correct_email_images.setVisible(true);
        }else{
            error_email_images.setVisible(true);
            correct_email_images.setVisible(false);
        }
    }
    @FXML
    public void PostBoxMatchKeyPressedReleasedListener(KeyEvent keyev){
        if(stringCheck(post_box_number_text,"^[0-9][0-9]{3,}")){
            error_postbox_images.setVisible(false);
            correct_postbox_images.setVisible(true);
        }else{
            error_postbox_images.setVisible(true);
            correct_postbox_images.setVisible(false);
        }
    }
    String campus_id,campus_name,campus_type,full_address,city_name,district,state,country;
    String website,contact_number,email_address,postbox;
    boolean check_campus_name=false,check_full_address=false,check_city_name=false;
    boolean check_website_name=false,check_contact_number=false,check_email_address=false;
    boolean check_district_name=false,check_state_name=false,check_country_name=false;
    boolean check_postbox_number=false;
    @FXML
    public void add_cancel_ButtonPaneCheck(MouseEvent me){
        
        if(me.getTarget()==Add_record_pane_whole||me.getTarget()==add_image_click||me.getTarget()==add_label){
            check_campus_name=check_full_address=check_city_name=false;
            check_website_name=check_contact_number=check_email_address=false;
            check_district_name=check_state_name=check_country_name=false;
            check_postbox_number=false; 
            System.out.println("entered add");
            //System.out.println(stringCheck(campus_name_text,"^[A-Za-z][A-Za-z\\s]{0,}"));
            if(stringCheck(campus_name_text,"^[A-Za-z][A-Za-z\\s]{0,}")){
                campus_name=campus_name_text.getText();
                check_campus_name=true;
                correct_campus_name_image.setVisible(true);
                error_campus_name_image.setVisible(false);
                System.out.println(campus_name);
            }
            else{
                correct_campus_name_image.setVisible(false);
                error_campus_name_image.setVisible(true);
                check_campus_name=false;
                System.out.println("else ");
            }
            System.out.println("whey");
            if(stringCheck(full_address_text,"^[a-zA-Z0-9][a-zA-Z0-9\\,\\-\\s]{0,}")){
                full_address=full_address_text.getText();
                check_full_address=true;
                error_full_address_image.setVisible(false);
                correct_full_address_images.setVisible(true);
                System.out.println(full_address);
            }else{
                error_full_address_image.setVisible(true);
                correct_full_address_images.setVisible(false);
                check_full_address=false;
            }
            if(stringCheck(town_name_text,"^[a-zA-Z][a-zA-Z\\-]{0,}")){
                city_name=town_name_text.getText();
                check_city_name=true;
                error_town_name_images.setVisible(false);
                correct_town_name_images.setVisible(true);
                System.out.println(city_name);
            }else{
                error_town_name_images.setVisible(true);
                correct_town_name_images.setVisible(false);
                check_city_name=false;
            }
            if(stringCheck(district_name_text,"^[a-zA-Z][a-zA-Z]{0,}")){
                district=district_name_text.getText();
                check_district_name=true;
                System.out.println(district);
                error_district_images.setVisible(false);
                correct_district_images.setVisible(true);
            }else{
                error_district_images.setVisible(true);
                correct_district_images.setVisible(false);
                check_district_name=false;
            }
            if(stringCheck(state_name_text,"^[a-zA-Z][a-zA-Z]{0,}")){
                state=state_name_text.getText();
                check_state_name=true;
                error_state_images.setVisible(false);
                correct_state_image.setVisible(true);
                System.out.println(state);
            }else{
                error_state_images.setVisible(true);
                correct_state_image.setVisible(false);
                check_state_name=false;
            }
            if(stringCheck(country_name_text,"^[a-zA-Z][a-zA-Z]{0,}")){
                country=country_name_text.getText();
                check_country_name=true;
                error_country_images.setVisible(false);
                correct_country_images.setVisible(true);
                System.out.println(country);
            }else{
                error_country_images.setVisible(true);
                correct_country_images.setVisible(false);
                check_country_name=false;
            }
            if(stringCheck(website_name_text,"^[a-zA-Z][a-zA-Z]{0,}\\.[a-zA-Z]{1,}(\\.[a-zA-Z]{1,})*")){
                website=website_name_text.getText();
                check_website_name=true;
                error_website_images.setVisible(false);
                correct_website_images.setVisible(true);
                System.out.println(website);
            }else{
                error_website_images.setVisible(true);
                correct_website_images.setVisible(false);
                check_website_name=false;
            }
            if(stringCheck(contact_number_text,"^[0-9][0-9]{5,}")){
                contact_number=contact_number_text.getText();
                check_contact_number=true;
                error_contact_image.setVisible(false);
                correct_contact_images.setVisible(true);
                System.out.println(contact_number);
            }else{
                error_contact_image.setVisible(true);
                correct_contact_images.setVisible(false);
                check_contact_number=false;
            }
            if(stringCheck(email_address_text,"^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$")){
                email_address=email_address_text.getText();
                check_email_address=true;
                error_email_images.setVisible(false);
                correct_email_images.setVisible(true);
                System.out.println(email_address);
            }else{
                error_email_images.setVisible(true);
                correct_email_images.setVisible(false);
                check_email_address=false;
            }
            if(stringCheck(post_box_number_text,"^[0-9][0-9]{3,}")){
                postbox=post_box_number_text.getText();
                check_postbox_number=true;
                error_postbox_images.setVisible(false);
                correct_postbox_images.setVisible(true);
                System.out.println(postbox);
            }else{
                error_postbox_images.setVisible(true);
                correct_postbox_images.setVisible(false);
                check_postbox_number=false;
            }
            campus_id=campus_id_text.getText();
            campus_type=college_type_choice.getValue();
            PreparedStatement prep=null,prepAdd=null,prepOther=null;
            System.out.println("Entered Database statement");
            if(check_campus_name==true&&check_full_address==true&&check_city_name==true&&check_district_name==true&&check_state_name==true&&check_country_name==true&&check_website_name==true&&check_contact_number==true&&check_email_address==true&&check_postbox_number==true){
                   String query1="insert into affiliated_college(campus_id,campus_name,campus_type) values(?,?,?)";
                   String query2="insert into campus_address(campus_id,full_address,town_name,district_name,state_name,country_name) values(?,?,?,?,?,?)";
                   String query3="insert into campus_other_info(campus_id,website_name,contact_number,email_address,postbox_number) values(?,?,?,?,?)";
                   System.out.println("Entered IF also");
                try {
                    int check1=0,check2=0,check3=0;
                    prep=(PreparedStatement)conn.prepareStatement(query1);
                    prep.setString(1,campus_id);
                    prep.setString(2,campus_name);
                    prep.setString(3,campus_type);
                    check1=prep.executeUpdate();
                    prepAdd=(PreparedStatement)conn.prepareStatement(query2);
                    prepAdd.setString(1,campus_id);
                    prepAdd.setString(2,full_address);
                    prepAdd.setString(3,city_name);
                    prepAdd.setString(4,district);
                    prepAdd.setString(5,state);
                    prepAdd.setString(6,country);
                    check2=prepAdd.executeUpdate();
                    prepOther=(PreparedStatement)conn.prepareStatement(query3);
                    prepOther.setString(1,campus_id);
                    prepOther.setString(2,website);
                    prepOther.setString(3,contact_number);
                    prepOther.setString(4,email_address);
                    prepOther.setString(5,postbox);
                    check3=prepOther.executeUpdate();
                    if(check1!=0&&check2!=0&&check3!=0){
                        //sucessfully executed
                        JOptionPane.showMessageDialog(null, "Information is added sucessfully!\nClicked Cancel to clear the field");
                        
                    }else{
                        //unsucessfull to execute
                        JOptionPane.showMessageDialog(null, "Information is not added sucessfully!\nDuplicate in email may occur!\nAttribute should not be null");
                        
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Information is not added Sucessfully!\nBlank Space will not be accepted.");
                
            }
            
        }
        if(me.getTarget()==cancel_record_pane_whole||me.getTarget()==cancel_image_click||me.getTarget()==cancel_label){
            try {
                Statement st=conn.createStatement();
                ResultSet result=st.executeQuery("select campus_id from affiliated_college");
                while(result.next()){
                    last_id=result.getString("campus_id");
                    System.out.println(last_id);
                }
               
                campus_name_text.setText("");
                full_address_text.setText("");
                town_name_text.setText("");
                district_name_text.setText("");
                state_name_text.setText("");
                country_name_text.setText("");
                website_name_text.setText("");
                contact_number_text.setText("");
                email_address_text.setText("");
                post_box_number_text.setText("");
                invisibleWork();
            } catch (SQLException ex) {
                Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Sucessfull executed");
        if(last_id==null){
            last_id="ca101";
        }else{
            last_id=last_id.substring(2);
            id_key=Integer.parseInt(last_id);
            id_key++;
            last_id=String.valueOf("ca"+id_key);
        }
        campus_id_text.setText(last_id);
        System.out.println("cancel completed");
        campus_id=campus_name=campus_type=full_address=city_name=district=state=country=null;
        website=contact_number=email_address=postbox=null;
        }
    }
    private boolean stringCheck(TextField fieldname,String expression){
        String str=fieldname.getText();
        Pattern pat=Pattern.compile(expression);
        Matcher mat=pat.matcher(str);
        return mat.matches();
    }
    private void invisibleWork(){
        correct_campus_name_image.setVisible(false);
        error_campus_name_image.setVisible(false);
        error_full_address_image.setVisible(false);
        correct_full_address_images.setVisible(false);
        error_town_name_images.setVisible(false);
        correct_town_name_images.setVisible(false);
        error_district_images.setVisible(false);
        correct_district_images.setVisible(false);
        error_state_images.setVisible(false);
        correct_state_image.setVisible(false);
        error_country_images.setVisible(false);
        correct_country_images.setVisible(false);
        error_website_images.setVisible(false);
        correct_website_images.setVisible(false);
        error_contact_image.setVisible(false);
        correct_contact_images.setVisible(false);
        error_email_images.setVisible(false);
        correct_email_images.setVisible(false);
        error_postbox_images.setVisible(false);
        correct_postbox_images.setVisible(false);
    }
    public void AddLabelClickedListener(ActionEvent mv){
        add_record_anchorpane.toFront();
            add_record_anchorpane.setVisible(true);
            update_record_anchorpane.setVisible(false);
            search_record_anchorpane.setVisible(false);
            update_record_anchorpane.toBack();
            search_record_anchorpane.toBack();
            delete_record_anchorpane.setVisible(false);
            delete_record_anchorpane.toBack();
            show_record_anchorpane_show.setVisible(false);
            show_record_anchorpane_show.toBack();
            Add_record_pane.setStyle("-fx-background-color:#817ccb;");
    }
    @FXML
    public void ChooseSidePane(ActionEvent mv){
        if(mv.getTarget()==Add_record_pane||mv.getTarget()==add_record_image_symbol||mv.getTarget()==add_record_label){
            add_record_anchorpane.toFront();
            add_record_anchorpane.setVisible(true);
            update_record_anchorpane.setVisible(false);
            search_record_anchorpane.setVisible(false);
            update_record_anchorpane.toBack();
            search_record_anchorpane.toBack();
            delete_record_anchorpane.setVisible(false);
            delete_record_anchorpane.toBack();
            show_record_anchorpane_show.setVisible(false);
            show_record_anchorpane_show.toBack();
            Add_record_pane.setStyle("-fx-background-color:#817ccb;");
        }
        if(mv.getTarget()==update_record_pane||mv.getTarget()==update_record_image_symbol||mv.getTarget()==update_record_label){
            college_type_choice1.getItems().addAll("Private","Government","Private+Government");
            college_type_choice1.setValue("Private");
            update_anchorpane.setVisible(false);
            update_record_pane.toFront();
            update_record_anchorpane.setVisible(true);
            add_record_anchorpane.setVisible(false);
            search_record_anchorpane.setVisible(false);
            search_record_anchorpane.toBack();
            add_record_anchorpane.toBack();
            delete_record_anchorpane.setVisible(false);
            delete_record_anchorpane.toBack();
            show_record_anchorpane_show.setVisible(false);
            show_record_anchorpane_show.toBack();
            update_record_pane.setStyle("-fx-background-color:#817ccb;");
            String query="select campus_name from affiliated_college";
            int value=0;
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);               
                while(rs.next()){
                    value++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println(value);
             comboBoxFilledWithCampusInfo(update_campus_choose_combo,value);
        }
        if(mv.getTarget()==search_record_pane||mv.getTarget()==search_record_image_symbol||mv.getTarget()==search_record_label){
            //search record clicked
            add_record_anchorpane.setVisible(false);
            add_record_anchorpane.toBack();
            update_record_anchorpane.setVisible(false);
            update_record_anchorpane.toBack();
            search_record_anchorpane.setVisible(true);
            search_record_anchorpane.toFront();
            delete_record_anchorpane.setVisible(false);
            delete_record_anchorpane.toBack();
            show_record_anchorpane_show.setVisible(false);
            show_record_anchorpane_show.toBack();
            // search_another_anchorpane.setVisible(true);
            String query="select campus_name from affiliated_college";
            int value=0;
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);               
                while(rs.next()){
                    value++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println(value);
             comboBoxFilledWithCampusInfo(search_campus_choose_combo,value);
        }
        if(mv.getTarget()==delete_record_pane||mv.getTarget()==delete_image_record_imageView||mv.getTarget()==delete_record_label){
            //delete pane clicked
            delete_anchorpane_show.setVisible(false);
            add_record_anchorpane.setVisible(false);
            add_record_anchorpane.toBack();
            update_record_anchorpane.setVisible(false);
            update_record_anchorpane.toBack();
            search_record_anchorpane.setVisible(false);
            search_record_anchorpane.toBack();
            delete_record_anchorpane.setVisible(true);
            delete_record_anchorpane.toFront();
            show_record_anchorpane_show.setVisible(false);
            show_record_anchorpane_show.toBack();
            
                   String query="select campus_name from affiliated_college";
            int value=0;
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);               
                while(rs.next()){
                    value++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println(value);
             comboBoxFilledWithCampusInfo(delete_campus_choose_combo_ComboBox,value);
        }
        if(mv.getTarget()==show_record_pane||mv.getTarget()==show_record_image||mv.getTarget()==show_record_label){
            delete_anchorpane_show.setVisible(false);
            add_record_anchorpane.setVisible(false);
            add_record_anchorpane.toBack();
            update_record_anchorpane.setVisible(false);
            update_record_anchorpane.toBack();
            search_record_anchorpane.setVisible(false);
            search_record_anchorpane.toBack();
            delete_record_anchorpane.setVisible(false);
            delete_record_anchorpane.toBack();
            show_record_anchorpane_show.setVisible(true);
            show_record_anchorpane_show.toFront();
        }
    }
    @FXML
    public void searchButtonClickedListener(MouseEvent ev){
          //  campus_id_column=new TableColumn<>("College ID");
          //  college_name_column=new TableColumn<>("College Name");
           // college_type_column=new TableColumn<>("College Type");
           if(search_campus_choose_combo.getValue()==null){
               search_result_anchorpane.setVisible(false);
           }else{
                search_result_anchorpane.setVisible(true);
                campus_id_column.setCellValueFactory(new PropertyValueFactory<>("cid"));
                college_name_column.setCellValueFactory(new PropertyValueFactory<>("college_name"));
                college_type_column.setCellValueFactory(new PropertyValueFactory<>("college_type"));
              //  college_information_tableview.setItems(null);
                college_information_tableview.setItems(getCollegeInfo());
              //  college_information_tableview.getColumns().addAll(campus_id_column,college_name_column,college_type_column);
                full_address_column.setCellValueFactory(new PropertyValueFactory<>("full_address"));
                town_city_village_column.setCellValueFactory(new PropertyValueFactory<>("town"));
                district_column.setCellValueFactory(new PropertyValueFactory<>("district"));
                state_column.setCellValueFactory(new PropertyValueFactory<>("state"));
                country_column.setCellValueFactory(new PropertyValueFactory<>("country"));

                location_information_tableview.setItems(getLocationInfo());

                website_column.setCellValueFactory(new PropertyValueFactory<>("website"));
                contact_number_column.setCellValueFactory(new PropertyValueFactory<>("contact"));
                email_column.setCellValueFactory(new PropertyValueFactory<>("email"));
                postbox_column.setCellValueFactory(new PropertyValueFactory<>("post"));

                additional_information_tableview.setItems(getAdditionalInfo());
            }
    }
    @FXML
    public void hideButtonClickedListener(MouseEvent me){
        search_result_anchorpane.setVisible(false);
        college_information_tableview.setItems(null);
        location_information_tableview.setItems(null);
        additional_information_tableview.setItems(null);
    }
    public ObservableList<AdditionalInformation> getAdditionalInfo(){
        String text=search_campus_choose_combo.getValue().toString();
        String parts[]=text.split("\\+");
        String website="",contact="",email="",post="";
        try {
            String query="select * from campus_other_info where campus_id=\'"+parts[0]+"\'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                website=rs.getString("website_name");
                contact=rs.getString("contact_number");
                email=rs.getString("email_address");
                post=rs.getString("postbox_number");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<AdditionalInformation> list=FXCollections.observableArrayList();
        list.add(new AdditionalInformation(website,contact,email,post));
        return list;
    }
    public ObservableList<LocationInformation> getLocationInfo(){
        String text=search_campus_choose_combo.getValue().toString();
        String parts[]=text.split("\\+");
        String full_address="",town_name="",district_name="",state_name="",country_name="";
        try {
            String query="select * from campus_address where campus_id=\'"+parts[0]+"\'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                full_address=rs.getString("full_address");
                town_name=rs.getString("town_name");
                district_name=rs.getString("district_name");
                state_name=rs.getString("state_name");
                country_name=rs.getString("country_name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<LocationInformation> list=FXCollections.observableArrayList();
        list.add(new LocationInformation(full_address,town_name,district_name,state_name,country_name));
        return list;
    }
    public ObservableList<CollegeInformation> getCollegeInfo(){
        String text=search_campus_choose_combo.getValue().toString();
        String parts[]=text.split("\\+");
        String id="",name="",type="";
        try {
            String query="select * from affiliated_college where campus_id=\'"+parts[0]+"\'";
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                id=rs.getString("campus_id");
                name=rs.getString("campus_name");
                type=rs.getString("campus_type");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ObservableList<CollegeInformation> list=FXCollections.observableArrayList();
        list.add(new CollegeInformation(id.toString(),name.toString(),type.toString()));
        return list;
    }
    @FXML
    public void deleteButtonClickedListener(MouseEvent me){
        String combo_value=delete_campus_choose_combo_ComboBox.getValue();
        String id="";
        for(int i=0;i<combo_value.length();i++){
            if(combo_value.charAt(i)=='+'){
                break;
            }else{
                id=id+combo_value.charAt(i);
            }
        }
        String cid ="",cname="",ctype="",cadd="",ctown="",cdistrict="",cstate="",country="";
        String cwebsite="",contact="",email="",postbox="";
        String query1="SELECT * from affiliated_college where campus_id=\'"+id+"\'";
        String query2="select * from campus_address where campus_id=\'"+id+"\'";
        String query3="select * from campus_other_info where campus_id=\'"+id+"\'";
        try {
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query1);
            if(rs.next()){
                cid=rs.getString("campus_id");
                cname=rs.getString("campus_name");
                ctype=rs.getString("campus_type");
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query2);
            if(rs.next()){
                cadd=rs.getString("full_address");
                ctown=rs.getString("town_name");
                cdistrict=rs.getString("district_name");
                cstate=rs.getString("state_name");
                country=rs.getString("country_name");
            }
            rs.close();
            st.close();
        }catch(SQLException ex){
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE,null,ex);
        }
        try{
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query3);
            if(rs.next()){
                cwebsite=rs.getString("website_name");
                contact=rs.getString("contact_number");
                email=rs.getString("email_address");
                postbox=rs.getString("postbox_number");
            }
            rs.close();
            st.close();
        }catch(SQLException ex){
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE,null,ex);
        }
        delete_record_information_label.setText("Campus ID : "+cid+"\n"+ 
                "Campus Name : "+cname+"\n"+
                "Campus Type : "+ctype+"\n"+
                "Full Address : "+cadd+"\n"+
                "Town : "+ctown+"\n"+
                "District : "+cdistrict+"\n"+
                "State : "+cstate+"\n"+
                "Country : "+country+"\n"+
                "Website : "+cwebsite+"\n"+
                "Contact No. : "+contact+"\n"+
                "E-mail : "+email+"\n"+
                "Postbox No. : "+postbox);
        delete_anchorpane_show.setVisible(true);
    }
    @FXML
    public void yesButtonClickedOfDeleteRecordAnchorPane(MouseEvent me){
        int val=JOptionPane.showConfirmDialog(null,"Do you want to Delete this Record?","Delete Confirmation",JOptionPane.YES_NO_OPTION);
        if(val==0){
            String combo_value=delete_campus_choose_combo_ComboBox.getValue();
            String id="";
            for(int i=0;i<combo_value.length();i++){
                if(combo_value.charAt(i)=='+'){
                    break;
                }else{
                    id=id+combo_value.charAt(i);
                }
            }
            String query="delete from affiliated_college where campus_id=\'"+id+"\'";
            try {
                Statement st=conn.createStatement();
                st.executeUpdate(query);
                st.close();

            } catch (SQLException ex) {
                Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             delete_anchorpane_show.setVisible(false);
            add_record_anchorpane.setVisible(false);
            add_record_anchorpane.toBack();
            update_record_anchorpane.setVisible(false);
            update_record_anchorpane.toBack();
            search_record_anchorpane.setVisible(false);
            search_record_anchorpane.toBack();
            delete_record_anchorpane.setVisible(true);
            delete_record_anchorpane.toFront();
            query="select campus_name from affiliated_college";
            int value=0;
            try {
                Statement st=conn.createStatement();
                ResultSet rs=st.executeQuery(query);               
                while(rs.next()){
                    value++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
            }
             System.out.println(value);
             comboBoxFilledWithCampusInfo(delete_campus_choose_combo_ComboBox,value);
            
        }else{
            delete_anchorpane_show.setVisible(false);
        }
        
        
    }
    private int length_campus_id=0;
    private void comboBoxFilledWithCampusInfo(ComboBox<String> com,int limit){
        com.getItems().clear();
        length_campus_id=0;
        String query="select * from affiliated_college";
        try {
            String[] campus_items=new String[limit];
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery(query);
            int value=0;
            while(rs.next()){
                length_campus_id=rs.getString("campus_id").length();
                campus_items[value]=rs.getString("campus_id")+"+"+rs.getString("campus_name");
                value++;
            }
            ObservableList<String> items = FXCollections.observableArrayList(campus_items);
            com.getItems().addAll(items);
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void FindButtonOfCollegeInformation(MouseEvent mev){
        if(mev.getTarget()==find_button_update||mev.getTarget()==find_tag_label_update||mev.getTarget()==search_image_update){
           String campus=update_campus_choose_combo.getValue();
           campus=campus.substring(0,length_campus_id);
           System.out.println("id="+campus);
           if(campus==null){
               return;
           }else{
               try {
                   String query="select * from affiliated_college where campus_id=\'"+campus+"\'";
                   Statement st=conn.createStatement();
                   ResultSet rs=st.executeQuery(query);
                   while(rs.next()){
                       campus_id_text1.setText(rs.getString("campus_id"));
                       break;
                   }
                   update_anchorpane.setVisible(true);
                   
               } catch (SQLException ex) {
                   Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        }
    }
    @FXML
    public void findbuttonEntered(MouseEvent me){
        find_button_update.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
    }
    @FXML
    public void findbuttonExited(MouseEvent me){
        find_button_update.setStyle("-fx-background-color:#c7c7c7;-fx-background-radius:3em;");
    }
    @FXML
    public void showRecordButtonEntered(MouseEvent me){
        show_record_button_show.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
    }
    @FXML
    public void showRecordButtonExited(MouseEvent me){
        show_record_button_show.setStyle("-fx-background-color:#c7c7c7;-fx-background-radius:3em;");
    }
     @FXML
    public void findOkaybuttonEntered(MouseEvent me){
        okay_pane_search.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
    }
    @FXML
    public void findOkaybuttonExited(MouseEvent me){
        okay_pane_search.setStyle("-fx-background-color:#c7c7c7;-fx-background-radius:3em;");
    }
    @FXML
    public void searchbuttonEntered(MouseEvent me){
        search_button_pane_search.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
    }
    @FXML
    public void searchbuttonExited(MouseEvent me){
        search_button_pane_search.setStyle("-fx-background-color:#c7c7c7;-fx-background-radius:3em;");
    }
    @FXML
     public void deletebuttonEntered(MouseEvent me){
        delete_button_pane.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
    }
    @FXML
    public void deletebuttonExited(MouseEvent me){
        delete_button_pane.setStyle("-fx-background-color:#c7c7c7;-fx-background-radius:3em;");
    }
    @FXML
    public void yesbuttonEntered(MouseEvent me){
        yes_button.setStyle("-fx-background-color:#14cda4;-fx-background-radius:3em;");
    }
    @FXML
    public void yesbuttonExited(MouseEvent me){
        yes_button.setStyle("-fx-background-color:#717171;-fx-background-radius:3em;");
    }
    @FXML
     public void checkwhileTypingEveryTextfieldCampusName1(KeyEvent keyev){
        if(stringCheck(campus_name_text1,"^[A-Za-z][A-Za-z\\s]{0,}")){
            correct_campus_name_image1.setVisible(true);
            error_campus_name_image1.setVisible(false);
        }else{
            error_campus_name_image1.setVisible(true);
            correct_campus_name_image1.setVisible(false);
        }
    }
    @FXML
    public void addressMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(full_address_text1,"^[a-zA-Z0-9][a-zA-Z0-9\\,\\-\\s]{0,}")){
            error_full_address_image1.setVisible(false);
            correct_full_address_images1.setVisible(true);
        }else{
            error_full_address_image1.setVisible(true);
            correct_full_address_images1.setVisible(false);
        }
    }
    @FXML
    public void townVillageCityMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(town_name_text1,"^[a-zA-Z][a-zA-Z\\-]{0,}")){
            error_town_name_images1.setVisible(false);
            correct_town_name_images1.setVisible(true);
        }else{
            error_town_name_images1.setVisible(true);
            correct_town_name_images1.setVisible(false);
        }
    }
    @FXML
    public void DistrictMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(district_name_text1,"^[a-zA-Z][a-zA-Z]{0,}")){
            error_district_images1.setVisible(false);
            correct_district_images1.setVisible(true);
        }else{
            error_district_images1.setVisible(true);
            correct_district_images1.setVisible(false);
        }
    }
    @FXML
    public void StateMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(state_name_text1,"^[a-zA-Z][a-zA-Z]{0,}")){
            error_state_images1.setVisible(false);
            correct_state_image1.setVisible(true);
        }else{
            error_state_images1.setVisible(true);
            correct_state_image1.setVisible(false);
        }
    }
    @FXML
    public void CountryMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(country_name_text1,"^[a-zA-Z][a-zA-Z]{0,}")){
            error_country_images1.setVisible(false);
            correct_country_images1.setVisible(true);
        }else{
            error_country_images1.setVisible(true);
            correct_country_images1.setVisible(false);
        }
    }
    @FXML
    public void WebsiteMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(website_name_text1,"^[a-zA-Z][a-zA-Z]{0,}\\.[a-zA-Z]{1,}(\\.[a-zA-Z]{1,})*")){
            error_website_images1.setVisible(false);
            correct_website_images1.setVisible(true);
        }else{
            error_website_images1.setVisible(true);
            correct_website_images1.setVisible(false);
        }
    }
    @FXML
    public void ContactMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(contact_number_text1,"^[0-9][0-9]{5,}")){
            error_contact_image1.setVisible(false);
            correct_contact_images1.setVisible(true);
        }else{
            error_contact_image1.setVisible(true);
            correct_contact_images1.setVisible(false);
        }
    }
    @FXML
    public void EmailMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(email_address_text1,"^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$")){
            error_email_images1.setVisible(false);
            correct_email_images1.setVisible(true);
        }else{
            error_email_images1.setVisible(true);
            correct_email_images1.setVisible(false);
        }
    }
    @FXML
    public void PostBoxMatchKeyPressedReleasedListener1(KeyEvent keyev){
        if(stringCheck(post_box_number_text1,"^[0-9][0-9]{3,}")){
            error_postbox_images1.setVisible(false);
            correct_postbox_images1.setVisible(true);
        }else{
            error_postbox_images1.setVisible(true);
            correct_postbox_images1.setVisible(false);
        }
    }
    @FXML
    public void mouseEntered1(MouseEvent me){
        if(me.getTarget()==Add_record_pane_whole1){
            Add_record_pane_whole1.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
        }
        if(me.getTarget()==cancel_record_pane_whole1){
            cancel_record_pane_whole1.setStyle("-fx-background-color:#04b398;-fx-background-radius:3em;");
        }      
    }
    @FXML
    public void mouseExited1(MouseEvent me){
        if(me.getTarget()==Add_record_pane_whole1){
            Add_record_pane_whole1.setStyle("-fx-background-color:#d1d1d1;-fx-background-radius:3em;");
        }
        if(me.getTarget()==cancel_record_pane_whole1){
            cancel_record_pane_whole1.setStyle("-fx-background-color:#d1d1d1;-fx-background-radius:3em;");
        }
    }
    @FXML
    public void update_cancel_workClickedPane(MouseEvent mev){
        if(mev.getTarget()==Add_record_pane_whole1||mev.getTarget()==add_label1||mev.getTarget()==add_image_click1){
            //update clicked
            System.out.println("Update Clicked");
            
            if(stringCheck(campus_name_text1,"^[A-Za-z][A-Za-z\\s]{0,}")){
                campus_name=campus_name_text1.getText();
                check_campus_name=true;
                correct_campus_name_image1.setVisible(true);
                error_campus_name_image1.setVisible(false);
                System.out.println(campus_name);
            }
            else{
                correct_campus_name_image1.setVisible(false);
                error_campus_name_image1.setVisible(true);
                check_campus_name=false;
            }
            if(stringCheck(full_address_text1,"^[a-zA-Z0-9][a-zA-Z0-9\\,\\-\\s]{0,}")){
                full_address=full_address_text1.getText();
                check_full_address=true;
                error_full_address_image1.setVisible(false);
                correct_full_address_images1.setVisible(true);
                System.out.println(full_address);
            }else{
                error_full_address_image1.setVisible(true);
                correct_full_address_images1.setVisible(false);
                check_full_address=false;
            }
            if(stringCheck(town_name_text1,"^[a-zA-Z][a-zA-Z\\-]{0,}")){
                city_name=town_name_text1.getText();
                check_city_name=true;
                error_town_name_images1.setVisible(false);
                correct_town_name_images1.setVisible(true);
                System.out.println(city_name);
            }else{
                error_town_name_images1.setVisible(true);
                correct_town_name_images1.setVisible(false);
                check_city_name=false;
            }
            if(stringCheck(district_name_text1,"^[a-zA-Z][a-zA-Z]{0,}")){
                district=district_name_text1.getText();
                check_district_name=true;
                System.out.println(district);
                error_district_images1.setVisible(false);
                correct_district_images1.setVisible(true);
            }else{
                error_district_images1.setVisible(true);
                correct_district_images1.setVisible(false);
                check_district_name=false;
            }
            if(stringCheck(state_name_text1,"^[a-zA-Z][a-zA-Z]{0,}")){
                state=state_name_text1.getText();
                check_state_name=true;
                error_state_images1.setVisible(false);
                correct_state_image1.setVisible(true);
                System.out.println(state);
            }else{
                error_state_images1.setVisible(true);
                correct_state_image1.setVisible(false);
                check_state_name=false;
            }
            if(stringCheck(country_name_text1,"^[a-zA-Z][a-zA-Z]{0,}")){
                country=country_name_text1.getText();
                check_country_name=true;
                error_country_images1.setVisible(false);
                correct_country_images1.setVisible(true);
                System.out.println(country);
            }else{
                error_country_images1.setVisible(true);
                correct_country_images1.setVisible(false);
                check_country_name=false;
            }
            if(stringCheck(website_name_text1,"^[a-zA-Z][a-zA-Z]{0,}\\.[a-zA-Z]{1,}(\\.[a-zA-Z]{1,})*")){
                website=website_name_text1.getText();
                check_website_name=true;
                error_website_images1.setVisible(false);
                correct_website_images1.setVisible(true);
                System.out.println(website);
            }else{
                error_website_images1.setVisible(true);
                correct_website_images1.setVisible(false);
                check_website_name=false;
            }
            if(stringCheck(contact_number_text1,"^[0-9][0-9]{5,}")){
                contact_number=contact_number_text1.getText();
                check_contact_number=true;
                error_contact_image1.setVisible(false);
                correct_contact_images1.setVisible(true);
                System.out.println(contact_number);
            }else{
                error_contact_image1.setVisible(true);
                correct_contact_images1.setVisible(false);
                check_contact_number=false;
            }
            if(stringCheck(email_address_text1,"^[a-zA-Z](\\.?[\\w]){5,}@[a-z]+\\.([a-z]{1,})$")){
                email_address=email_address_text1.getText();
                check_email_address=true;
                error_email_images1.setVisible(false);
                correct_email_images1.setVisible(true);
                System.out.println(email_address);
            }else{
                error_email_images1.setVisible(true);
                correct_email_images1.setVisible(false);
                check_email_address=false;
            }
            if(stringCheck(post_box_number_text1,"^[0-9][0-9]{3,}")){
                postbox=post_box_number_text1.getText();
                check_postbox_number=true;
                error_postbox_images1.setVisible(false);
                correct_postbox_images1.setVisible(true);
                System.out.println(postbox);
            }else{
                error_postbox_images1.setVisible(true);
                correct_postbox_images1.setVisible(false);
                check_postbox_number=false;
            }
            campus_id=campus_id_text1.getText();
            campus_type=college_type_choice1.getValue();
            
            PreparedStatement prep=null,prepAdd=null,prepOther=null;
            if(check_campus_name==true&&check_full_address==true&&check_city_name==true&&check_district_name==true&&check_state_name==true&&check_country_name==true&&check_website_name==true&&check_contact_number==true&&check_email_address==true&&check_postbox_number==true){
                   String query1="update affiliated_college set campus_id=?, campus_name=?,campus_type=? where campus_id=\'"+campus_id+"\'";
                   String query2="update campus_address set campus_id=?, full_address=?, town_name=?, district_name=?, state_name=?, country_name=? where campus_id=\'"+campus_id+"\'";
                   String query3="update campus_other_info set campus_id=?, website_name=?, contact_number=?, email_address=?, postbox_number=? where campus_id=\'"+campus_id+"\'";
                try {
                    int check1=0,check2=0,check3=0;
                    prep=(PreparedStatement)conn.prepareStatement(query1);
                    prep.setString(1,campus_id);
                    prep.setString(2,campus_name);
                    prep.setString(3,campus_type);
                    check1=prep.executeUpdate();
                    prepAdd=(PreparedStatement)conn.prepareStatement(query2);
                    prepAdd.setString(1,campus_id);
                    prepAdd.setString(2,full_address);
                    prepAdd.setString(3,city_name);
                    prepAdd.setString(4,district);
                    prepAdd.setString(5,state);
                    prepAdd.setString(6,country);
                    check2=prepAdd.executeUpdate();
                    prepOther=(PreparedStatement)conn.prepareStatement(query3);
                    prepOther.setString(1,campus_id);
                    prepOther.setString(2,website);
                    prepOther.setString(3,contact_number);
                    prepOther.setString(4,email_address);
                    prepOther.setString(5,postbox);
                    check3=prepOther.executeUpdate();
                    if(check1!=0&&check2!=0&&check3!=0){
                        //sucessfully executed
                        JOptionPane.showMessageDialog(null, "Information is updated sucessfully!\nClicked Cancel to clear the field");
                        
                    }else{
                        //unsucessfull to execute
                        JOptionPane.showMessageDialog(null, "Information is not updated sucessfully!\nDuplicate in email may occur!\nAttribute should not be null");
                       
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(CampusDetailsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Information is not updated Sucessfully!\nBlank Space will not be accepted.");
                
            }
            
        }
        if(mev.getTarget()==cancel_record_pane_whole1||mev.getTarget()==cancel_label1||mev.getTarget()==cancel_image_click1){
            //cancel clicked
            System.out.println("cancel clicked");
         
            campus_name_text1.setText("");
            full_address_text1.setText("");
            town_name_text1.setText("");
            district_name_text1.setText("");
            state_name_text1.setText("");
            country_name_text1.setText("");
            website_name_text1.setText("");
            contact_number_text1.setText("");
            email_address_text1.setText("");
            post_box_number_text1.setText("");
            correct_campus_name_image1.setVisible(false);
            error_campus_name_image1.setVisible(false);
            error_full_address_image1.setVisible(false);
            correct_full_address_images1.setVisible(false);
            error_town_name_images1.setVisible(false);
            correct_town_name_images1.setVisible(false);
            error_district_images1.setVisible(false);
            correct_district_images1.setVisible(false);
            error_state_images1.setVisible(false);
            correct_state_image1.setVisible(false);
            error_country_images1.setVisible(false);
            correct_country_images1.setVisible(false);
            error_website_images1.setVisible(false);
            correct_website_images1.setVisible(false);
            error_contact_image1.setVisible(false);
            correct_contact_images1.setVisible(false);
            error_email_images1.setVisible(false);
            correct_email_images1.setVisible(false);
            error_postbox_images1.setVisible(false);
            correct_postbox_images1.setVisible(false);     
            campus_id_text1.setText(null);
            update_anchorpane.setVisible(false);
        }
    }

  
  
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class MainChooserController implements Initializable {

    @FXML
    private AnchorPane Top_back_view;
    @FXML
    private JFXButton campus_details_button;
    @FXML
    private JFXButton project_management_button;
    @FXML
    private JFXButton course_management_button;
    @FXML
    private JFXButton admission_management_button;
    @FXML
    private JFXButton student_info_system_button;
    @FXML
    private JFXButton academic_registration_button;
    private JFXButton committee_management_button;
    private JFXButton security_gate_management_button;
    private JFXButton attendance_record_management_button;
    @FXML
    private JFXButton library_management_button;
    private JFXButton exam_and_mark_sheet_management_button;
    @FXML
    private JFXButton fees_management_button;
    private JFXButton certificate_and_document_management_button;
    @FXML
    private JFXButton human_resource_management_button;
    @FXML
    private JFXButton hostel_management_button;
    @FXML
    private ImageView close_imageview;
    @FXML
    private ImageView minimize_imageview;
    @FXML
    private Label Multi_line_label;
    @FXML
    private Pane pane_wel;
    @FXML
    private Label heading_label;
    @FXML
    private JFXButton go_button;
    @FXML
    private AnchorPane Top_back;
    @FXML
    private JFXButton logout_button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        go_button.setVisible(false);
        String str="Objectives\n"+
                "  1. To became a one-stop data center\n"+
                "  2. To reduce complex works in mind\n"+
                "  3. To make people happier and more confident\n"+
                "  4. To record the data digitally\n"+
                "  5. To help management deparment of the university\n";
        Multi_line_label.setText(str);
        designWork(pane_wel,4,0.0,1.0);
    }    
    
    public void logoutButtonClickedListener(ActionEvent ae) throws IOException{
            Parent ptt;
            ptt=(AnchorPane)FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            
            Scene scene=new Scene(ptt);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            Stage stg=(Stage)Top_back_view.getScene().getWindow();
            stg.setScene(scene);
            stg.show();
    }
    
    @FXML
    public void closeButtonImageEvent(MouseEvent event){
        if(event.getTarget()==close_imageview){
            FadeTransition fade=new FadeTransition();
            fade.setNode(Top_back_view);
            fade.setDuration(Duration.seconds(0.5));
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished((e)->{
                System.exit(0);
            });
            fade.play();
        }
        if(event.getTarget()==minimize_imageview){
            Stage stg=(Stage)Top_back_view.getScene().getWindow();
            stg.setIconified(true);
        }
    }
    private void designWork(Pane img,double secs,double fromVal,double toVal){
        FadeTransition fade=new FadeTransition();
        fade.setNode(img);
        fade.setDuration(Duration.seconds(secs));
        fade.setFromValue(fromVal);
        fade.setToValue(toVal);
        fade.play();
    }
    static int button_Check;
    @FXML
    public void buttonMenuClicked(ActionEvent mev){
        if(mev.getTarget()==academic_registration_button){
            String str="• Map students to specific programs and courses\n"+
                    "• Enrolment in semester.\n"+
                    "• Enrol faculty to department & courses\n";
            ButtonStringAllSet("Academic Registration",str);
            button_Check=1;
        }
        if(mev.getTarget()==admission_management_button){
            String str="• Manage database of Enquiries and prospective students and follow ups.\n" +
                        "• Manage application process.\n" +
                        "• Student registration information.\n" +
                        "• Website, Email & SMS integration\n";
            ButtonStringAllSet("Admisson Management",str);
            button_Check=2;
        }
        if(mev.getTarget()==attendance_record_management_button){
            String str="• Integration with time table to generate session (periods) details for attendance.\n" +
                "• Course section wise student’s attendance marking.\n" +
                "• Integration with Biometric based student class attendance solution (optional).\n" +
                "• Class Roster, Attendance reports, Email/SMS alerts.";
            ButtonStringAllSet("Attendance Record Management",str);
            button_Check=3;
        }
        if(mev.getTarget()==campus_details_button){
            String str="• Set up campus details.";
            ButtonStringAllSet("Campus Details",str);
            button_Check=4;
        }
        if(mev.getTarget()==certificate_and_document_management_button){
            String str="• Student /Faculty/Employee can request certificates that he/she wants to get issued. Auto approval, manual approval; rejection and complete certificate/document issue management can be done.\n" +
                        "• Generate document using document generator and print the certificates/documents directly on Institute stationary or pre-defined format is also present.\n" +
                        "• Documents handed over at time of admission.\n" +
                        "• These could include: Domicile Certificate, Birth Certificate, Mark Sheets, Entrance Exam Certificate";
            ButtonStringAllSet("Certificate & Document Management",str);
            button_Check=5;
        }
        if(mev.getTarget()==committee_management_button){
            String str="• Using committee management, a user can create committee, associated event, invite members and send message/email to participants\n" +
                "• A new committee can be created using Add button\n" +
                "• User can define committee code, committee name, its coordinator and academy location\n" +
                "• Committee validity (From Date and To Date), its status and description can also be added\n" +
                "• More information such as users, programs, courses, faculties, facilities, equipment and external resources can be added using ADD MEETING button";
            ButtonStringAllSet("Committee Management",str);
            button_Check=6;
        }
        if(mev.getTarget()==course_management_button){
            String str="• Create and manage Courses.\n" +
                "• Define the credits, hours and sections for the Courses.";
            ButtonStringAllSet("Course Management",str);
            button_Check=7;
        }
        if(mev.getTarget()==exam_and_mark_sheet_management_button){
            String str="• Pre-Examinations Preparation\n" +
                "   1. Exam Notifications\n" +
                "   2. Exam courses and student registration\n" +
                "   3. Exam Schedule\n" +
                "• Exam Day\n" +
                "   1. Exam Student Attendance Management\n" +
                "• Post Exam\n" +
                "   1. Student performance and mark entries\n" +
                "   2. Grade, Percentage, GPA, CGPA management\n" +
                "   3. Result preparation\n" +
                "   4. Reports for result analysis\n" +
                "• Overall Reports for exam and Marksheet management";
            ButtonStringAllSet("Exam & Mark Sheet Management",str);
            button_Check=8;
        }
        if(mev.getTarget()==fees_management_button){
            String str="• Multiple fee plans creation.\n" +
                "• Enrol student in single/multiple fee plan.\n" +
                "• Generate fee submit and receipt.\n" +
                "• Fee related reports, Fee head breakups for ex Outstanding report, Collection report (Head wise/Student wise).\n" +
                "• Sponsor and student invoicing.";
            ButtonStringAllSet("Fees Management",str);
            button_Check=9;
        }
        if(mev.getTarget()==hostel_management_button){
            String str="• Maintain details about hostels, floors, rooms, room type, bed number, warden, manager.\n" +
                "• Manage bed reservation.\n" +
                "• Store and retrieve student information that avail hostel facility.\n" +
                "• Link hostel management with fees and inventory management module.\n" +
                "• Manage hostel attendance.\n" +
                "• Email and SMS integration on Bed allotment/DE allotment and hostel attendance.\n" +
                "• Hostel announcement feature for students, guest and faculties.";
            ButtonStringAllSet("Hostel Management",str);
            button_Check=10;
        }
        if(mev.getTarget()==human_resource_management_button){
            String str="• Manage integrated and centralized employee database with filtered search capabilities.\n" +
                "• Maintain comprehensive employee profiles covering a wide range of essential workforce data – dependents information, contact details, educational details, work history and more.\n" +
                "• Configure all master settings and sub-fields like company, department, sub department, employee hierarchy etc.\n" +
                "• Configure employee working hours and employee leaves for “Leave & Timesheet management”.\n" +
                "• Manage multi-level leave approval.\n" +
                "• Mark attendance daily and direct import from biometric machine.\n" +
                "• Manage employee timesheet. View, approve or reject employee timesheet details.\n" +
                "• Various standard reports, which will satisfy even the most, sophisticated reporting requirements.";
            ButtonStringAllSet("Human Resource Management",str);
            button_Check=11;
        }
        if(mev.getTarget()==library_management_button){
            String str="• Create and manage book/periodicals/journal/CD-DVD and other media records.\n" +
                "• Generate Library Cards for Student, faculties and library books.\n" +
                "• Issue/receive library items to students/faculties.\n" +
                "• Online book reservation by students/faculties.\n" +
                "• Enquiries, Tenders, Offer Comparison, Purchase orders and Purchase bills.\n" +
                "• Integrate RFID/Barcode";
            ButtonStringAllSet("Library Management",str);
            button_Check=12;
        }
        if(mev.getTarget()==project_management_button){
            String str="• Create and manage the different programs/degrees that run in the institute.\n" +
                "• Enrol/Un-enrol students in a program/degree.";
            ButtonStringAllSet("Program Management",str);
            button_Check=13;
        }
        if(mev.getTarget()==security_gate_management_button){
            String str="• Using security gate management, Visitor entry or appointments can be managed\n" +
                "• Security management can be used to create & manage appointments and visitors\n" +
                "• User can also define visitor category and unique booking id will be auto generated\n" +
                "• Visitor's details such as name, contact details, email etc can be captured in the system\n" +
                "• Visitor's reason for visit, in and out time, appointment date and person to meet can be captured in the system";
            ButtonStringAllSet("Security Gate Management",str);
            button_Check=14;
        }
        if(mev.getTarget()==student_info_system_button){
            String str="• Maintain detailed student profile.\n" +
                "• Generate student ID card and barcode.\n" +
                "• Aggregate student information from all other modules.";
            ButtonStringAllSet("Student Information System",str);
            button_Check=15;
        }
    }
    private void ButtonStringAllSet(String heading,String str){
            designWork(pane_wel,1,1.0,0.0);
            heading_label.setText(heading);
            Multi_line_label.setText(str);
            go_button.setVisible(true);
            designWork(pane_wel,1,0.0,1.0);
    }
    @FXML
    public void AnchorPaneChoose(ActionEvent aev){
        if(aev.getTarget()==go_button&&button_Check==9){
            try {
                AdvanceLinkerAnchorPane("FeesManagementSystem.fxml",aev,"Fees Management System");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==15){
            try {
                AdvanceLinkerAnchorPane("StudentInformationSystem.fxml",aev,"Student Information System");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if(aev.getTarget()==go_button&&button_Check==11){
            try {
                AdvanceLinkerAnchorPane("HumanResourcesManagement.fxml",aev,"Human Resource Management");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==4){
            try {
                linkerAnchorPane("CampusDetails.fxml");
            } catch (IOException ex) {
                System.out.println("Exception occurs");
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==7){
            try {
               // linkerAnchorPane("CourseManagementSystem.fxml");
               
                AdvanceLinkerAnchorPane("CourseManagementSystem.fxml",aev,"Course Management System");

            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==13){
            try {
                AdvanceLinkerAnchorPane("ProgramManagementSystem.fxml",aev,"Program Management System");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==2){
            try {
                AdvanceLinkerAnchorPane("AdmissionManagement.fxml",aev,"Admission Management System");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if(aev.getTarget()==go_button&&button_Check==1){
            try {
                AdvanceLinkerAnchorPane("AcademicRegistration.fxml",aev,"Academic Registration");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==10){
            try {
                AdvanceLinkerAnchorPane("HostelManagementSystem.fxml",aev,"Hostel Management System");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(aev.getTarget()==go_button&&button_Check==12){
            try {
                AdvanceLinkerAnchorPane("LibraryManagement.fxml",aev,"Library Management System");
            } catch (IOException ex) {
                Logger.getLogger(MainChooserController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void AdvanceLinkerAnchorPane(String filename,ActionEvent aev,String title) throws IOException{
                Parent root = (Parent) FXMLLoader.load(getClass().getResource(filename));
                Scene scene = new Scene(root);
                Window existingWindow = ((Node) aev.getSource()).getScene().getWindow();

                // create a new stage:
                Stage stage = new Stage();
                // make it modal:
                stage.initModality(Modality.APPLICATION_MODAL);
                // make its owner the existing window:
                stage.initOwner(existingWindow);
                stage.setTitle(title);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.sizeToScene();
                stage.show();
    }
    public void linkerAnchorPane(String filename) throws IOException{
        Parent ppt;
        ppt=(AnchorPane)FXMLLoader.load(getClass().getResource(filename));
        //String css=this.getClass().getResource(cssfilename).toExternalForm();
        Scene scene=new Scene(ppt);
        //scene.getStylesheets().add(css);
        Stage stg;
        stg = (Stage)Top_back_view.getScene().getWindow();
        stg.setX(100);
        stg.setY(0);
        stg.setScene(scene);
        stg.show();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

import com.jfoenix.controls.JFXProgressBar;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import universitydatabasemanagement.FXMLDocumentController;
import universitydatabasemanagement.FirstLoadingBarFXMLController;
/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class ProcessingMessageLayoutController implements Initializable {

    @FXML
    private JFXProgressBar processing_bars;
    @FXML
    private Label Message_pass;
    @FXML
    private Button Okay_processing_bt;
    @FXML
    private AnchorPane Process_anchor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        new Stucker().start();
    }    

    @FXML
    public void okayButtonClicked(MouseEvent event) throws IOException{
        if(event.getTarget()==Okay_processing_bt){
            Parent ptt;
            ptt=(AnchorPane)FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            
            Scene scene=new Scene(ptt);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            Stage stg=(Stage)Process_anchor.getScene().getWindow();
            stg.setScene(scene);
            stg.show();
        }
    }

    public class Stucker extends Thread{
        public void run(){
            try {
                // TODO
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProcessingMessageLayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
            FadeTransition fade=new FadeTransition();
            fade.setNode(Okay_processing_bt);
            fade.setDuration(Duration.seconds(2));
            fade.setFromValue(0.0);
            fade.setToValue(1.0);
            fade.setOnFinished((e)->{
                FXMLDocumentController fxl=new FXMLDocumentController();
                processing_bars.setVisible(false);
                if(fxl.errorCheckReturn()==true&&fxl.exceptionCheckReturn()==false){
                    //success
                    Message_pass.setText("Account Sucessfully Created!!");
                }
                if(fxl.errorCheckReturn()==false&&fxl.exceptionCheckReturn()==false){
                    Message_pass.setText("Account Creation Failed");
                }
                if(fxl.exceptionCheckReturn()==true){
                    Message_pass.setText("Username Already Exist!!");
                }
            });
            fade.play();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universitydatabasemanagement;

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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
/**
 * FXML Controller class
 *
 * @author Mathew_Anish
 */
public class FirstLoadingBarFXMLController implements Initializable {
    @FXML
    private AnchorPane rootPane;
    
    @FXML
    private ImageView SlideSecond;

    @FXML
    private ImageView SlideThird;

    @FXML
    private ImageView SlideFirst;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SlideShowAnimationWithPath();
    }   
    public void runN() throws IOException{
            Parent ptt;
            ptt=(AnchorPane)FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            
            Scene scene=new Scene(ptt);
            scene.setFill(javafx.scene.paint.Color.TRANSPARENT);
            Stage stg=(Stage)rootPane.getScene().getWindow();
            stg.setScene(scene);
            stg.show();
    }
    private void SlideShowAnimationWithPath(){
        //for(int i=0;i<2;i++){
            FadeTransition fade=new FadeTransition();
            fade.setNode(SlideFirst);
            fade.setDuration(Duration.seconds(1));
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished((ActionEvent e)->{
                SecondImageView();
            });
            fade.play();
        
    }
    private void SecondImageView(){
        FadeTransition fade=new FadeTransition();
        SlideFirst.setVisible(false);
        SlideSecond.setVisible(true);
        fade.setNode(SlideSecond);
        fade.setDuration(Duration.seconds(1));
        fade.setFromValue(0.0);
        fade.setToValue(1.0);
        fade.setOnFinished((ActionEvent e)->{
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished((ActionEvent e1)->{
                SlideSecond.setVisible(false);
                SlideThird.setVisible(true);
                fade.setNode(SlideThird);
                fade.setDuration(Duration.seconds(1));
                fade.setFromValue(0.0);
                fade.setToValue(1.0);
                fade.setOnFinished((ActionEvent e2)->{
                   fade.setFromValue(1.0);
                   fade.setToValue(0.0);
                   fade.setOnFinished((ActionEvent e3)->{
                        try {
                            runN();
                        } catch (IOException ex) {
                            Logger.getLogger(FirstLoadingBarFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                   });
                   fade.play();
                });
                fade.play();
            });
            fade.play();
        });
        fade.play();
    }
}

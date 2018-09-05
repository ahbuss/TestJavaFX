/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import com.sun.javafx.font.freetype.HBGlyphLayout;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author ahbuss
 */
public class Login extends Application {
    
    private Text actionTarget;
    
    private TextField userTextField;
        
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Welcome - Please Log In");
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        Text sceneTitle = new Text("Welcome!");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(sceneTitle, 0, 0, 2, 1);
        
        Label userName = new Label("User Name:");
        gridPane.add(userName, 0, 1);
        
        userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);
        
        Label passwordLabel = new Label("Password:");
        gridPane.add(passwordLabel, 0, 2);
        
        PasswordField passwordField = new PasswordField();
        gridPane.add(passwordField, 1, 2);
        
        Button button = new Button("Sign In");
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.getChildren().add(button);
        gridPane.add(buttonBox, 1, 4);
        
        button.setOnAction(new SignInAction());
        
        actionTarget = new Text();
        actionTarget.setFill(Color.FIREBRICK);
        gridPane.add(actionTarget, 1, 6);

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }

    private class SignInAction implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String userName = userTextField.getText();
            actionTarget.setText("Welcome " + userName + "!");
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tutorial;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author ahbuss
 */
public class HelloJavaFX extends Application {

    private final SayHelloAction sayHelloAction;

    private final Button helloButton;

    public HelloJavaFX() {
        String message = "Hello JavaFX!";
        sayHelloAction = new SayHelloAction(message);
        helloButton = new Button("Say Hello");
        helloButton.setOnAction(sayHelloAction);
    }


    @Override
    public void start(Stage primaryStage) {

        StackPane root = new StackPane();
        root.getChildren().addAll(helloButton);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private class SayHelloAction implements EventHandler<ActionEvent> {

        private String message;

        public SayHelloAction(String message) {
            this.message = message;
        }

        @Override
        public void handle(ActionEvent event) {
            System.out.println(message);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

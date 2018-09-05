package test;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ahbuss
 */
public class Test1 extends JFrame  implements Runnable {

    private static Test1 instance;
    
    private JFXPanel jfxPanel;
    
    public Test1() {
        setSize(300, 200);
        jfxPanel = new JFXPanel();
        getContentPane().add(jfxPanel);
        Platform.runLater(new CreateAndSetScene());
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        instance = new Test1();
        SwingUtilities.invokeLater(instance);
    }

    @Override
    public void run() {
        instance.setTitle("Testing Swing and JavaFX");
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.setVisible(true);
    }
    
    private class CreateAndSetScene implements Runnable {

        private Scene scene;
        
        @Override
        public void run() {
            this.createScene();
            jfxPanel.setScene(scene);
        }
        
        private void createScene() {
            Group root = new Group();
            this.scene = new Scene(root, Color.ALICEBLUE);
            Text text = new Text();
            
            text.setX(40);
            text.setY(100);
            text.setFont(new Font(25));
            text.setText("Welcome JavaFX!");
            
            root.getChildren().add(text);
        }
        
    }
    
}

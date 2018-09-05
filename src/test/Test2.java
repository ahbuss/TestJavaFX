package test;

import java.awt.BorderLayout;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author ahbuss
 */
public class Test2 extends JFrame implements Runnable {

    private static Test2 instance;

    private JFXPanel jfxPanel;

    public Test2() {
        jfxPanel = new JFXPanel();
        getContentPane().add(jfxPanel, BorderLayout.CENTER);
        CreateAndSetScene createAndSetScene = new CreateAndSetScene();
        Platform.runLater(createAndSetScene);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        instance = new Test2();
        SwingUtilities.invokeLater(instance);
    }

    @Override
    public void run() {
        instance.setTitle("Testing Swing and JavaFX");
        instance.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        instance.setSize(500, 425);
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
            this.scene = new Scene(root, 450, 400);

            ObservableList<PieChart.Data> piechartData;
            piechartData = FXCollections.observableArrayList();
            piechartData.add(new PieChart.Data("Cat Toys", 3));
            piechartData.add(new PieChart.Data("The Packaging", 97));

            PieChart pieChart = new PieChart(piechartData);
            pieChart.setTitle("Things My Cat Loves to Play With");

            root.getChildren().add(pieChart);

        }

        /**
         * @return the scene
         */
        public Scene getScene() {
            return scene;
        }

    }

}

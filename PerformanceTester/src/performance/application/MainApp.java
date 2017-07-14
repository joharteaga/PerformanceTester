/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.application;

import java.io.IOException;
import java.util.Arrays;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import performance.data.IntArrayGenerator;
import performance.data.StringArrayGenerator;
import performance.sorting.AlgorithmInterface;
import performance.sorting.BubbleSortClassic;
import performance.sorting.BubbleSortOptimised;
import performance.sorting.InsertionSort;
import performance.sorting.MergeSort;
import performance.sorting.QuickSort;
import performance.sorting.SelectionSort;

/**
 *
 * @author joharteaga
 */
public class MainApp extends Application {
    private Stage primaryStage;
    private BorderPane rootLayout;
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Performance Tester");
        
        initializeRoot();
        
        displayMainScene();
    }

    private void initializeRoot() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/performance/gui/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayMainScene() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/performance/gui/MainLayout.fxml"));
            
            AnchorPane mainLayout = (AnchorPane) loader.load();
            
            rootLayout.setCenter(mainLayout);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

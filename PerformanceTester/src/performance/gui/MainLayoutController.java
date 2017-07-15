/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.gui;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import performance.application.MainApp;
import performance.data.TestResults;
import performance.sorting.AlgorithmInterface;
import performance.sorting.BubbleSortClassic;
import performance.sorting.BubbleSortOptimised;
import performance.sorting.InsertionSort;
import performance.sorting.MergeSort;
import performance.sorting.QuickSort;
import performance.sorting.SelectionSort;

/**
 * FXML Controller class
 *
 * @author ru5h
 */
public class MainLayoutController {
    @FXML
    private TextArea testResults;
    
    @FXML
    private CheckBox bubbleSortClassic;
    @FXML
    private CheckBox bubbleSortOptimised;
    @FXML
    private CheckBox selectionSort;
    @FXML
    private CheckBox insertionSort;
    @FXML
    private CheckBox mergeSort;
    @FXML
    private CheckBox quickSort;
    
    //int or string buttons
    @FXML
    private RadioButton intArray;
    @FXML
    private RadioButton stringArray;
    
    @FXML
    private TextField arraySize;
    
    @FXML
    private Button runTests;
    
    private MainApp mainApp;
    
    private ArrayList<CheckBox> algorithms;

    public MainLayoutController() {
        algorithms = new ArrayList<>();
    }
    
    
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        // TODO
        
        storeButtons();

        this.testResults.setText("Press 'RUN TESTS' to begin after making selections.");
        
        this.runTests.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {

                
                
                Set<AlgorithmInterface> algSelection = getAlgorithmSelections();
                String arrayType = getArrayType();
                int size = getArraySize();
                
                if (algSelection == null || algSelection.isEmpty()
                                         || arrayType == null
                                         || size == -1) {
                    testResults.setText("Invaid Selections. Please correct.");
                } else {
                    testResults.setText("Tests Running. Please wait...");
                    TestResults test = new TestResults();
                    test.addTest(algSelection);
                    String results = test.runTests(arrayType, size);
                    testResults.setText(results);
                }
            } 

        });
    }    
    
    private Set<AlgorithmInterface> getAlgorithmSelections() {
        Set<AlgorithmInterface> chosen = new HashSet<AlgorithmInterface>();
        
        for (CheckBox checkbox : algorithms) {
            if (checkbox.isSelected()) {
                String name = checkbox.getId();
                
                if (name.equals("bubbleSortClassic")) {
                    chosen.add(new BubbleSortClassic());
                }
                if (name.equals("bubbleSortOptimised")) {
                    chosen.add(new BubbleSortOptimised());
                }
                if (name.equals("selectionSort")) {
                    chosen.add(new SelectionSort());
                }
                if (name.equals("insertionSort")) {
                    chosen.add(new InsertionSort());
                }
                if (name.equals("mergeSort")) {
                    chosen.add(new MergeSort());
                }
                if (name.equals("quickSort")) {
                    chosen.add(new QuickSort());
                }
            }
        }

        return chosen;
    }
    
    private String getArrayType() {
        if (intArray.isSelected()) {
            return "int[]";
        } else if (stringArray.isSelected()){
            return "String[]";
        }
        return null;
    }
    
    private int getArraySize() {
        try {
            return Integer.parseInt(arraySize.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public void setMainApp(MainApp aThis) {
        this.mainApp = aThis;
    }

    private void storeButtons() {
        algorithms.add(bubbleSortClassic);
        algorithms.add(bubbleSortOptimised);
        algorithms.add(selectionSort);
        algorithms.add(insertionSort);
        algorithms.add(mergeSort);
        algorithms.add(quickSort);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.data;


import java.util.Set;
import performance.sorting.AlgorithmInterface;

/**
 *
 * @author joharteaga
 */
public class TestResults {
    Set<AlgorithmInterface> tests;
    IntArrayGenerator intArrayGenerator;
    StringArrayGenerator stringArrayGenerator;
    
    
    public TestResults() {
        this.intArrayGenerator = new IntArrayGenerator();
        this.stringArrayGenerator = new StringArrayGenerator();
    }
    
    public void addTest(Set<AlgorithmInterface> tests) {
        if (tests == null || tests.isEmpty()) {
            return;
        }
        
        this.tests = tests;
    }
    
    public String runTests(String type, int size) {
        if (type.equals("int[]")) {
            int[] data = generateInt(size);
            return runBenchMark(data);
            
        } else if (type.equals("String[]")) {
            String[] data = generateString(size);
            return runBenchMark(data);
            
        } 
        
        return "Invalid test.";
  
    }

    private int[] generateInt(int size) {
        return intArrayGenerator.getRandomIntArray(size);
    }

    //no bounds given
    private String[] generateString(int size) {
        return stringArrayGenerator.getRandomStringArray(size);
    }

    private String runBenchMark(int[] data) {
        if (data == null || data.length == 0) {
            return "No data.";
        }
        
        BenchMark bench = new BenchMark(data, tests);
        bench.run();
        
        return bench.getResults();
    }
    
    private String runBenchMark(String[]data) {
        if (data == null || data.length == 0) {
            return "No data.";
        }
        
        BenchMark bench = new BenchMark(data, tests);
        bench.run();
        return bench.getResults();
    }
        
}

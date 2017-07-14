/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package performance.data;


import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import performance.sorting.AlgorithmInterface;

/**
 *
 * @author joharteaga
 */
class BenchMark {
    ConcurrentLinkedDeque<AlgorithmInterface> testList;
    ConcurrentLinkedDeque<String> finalResults;

    private int[] dataInt;
    private String[] dataString;

    public BenchMark(Set<AlgorithmInterface> testList) {
        this.testList = new ConcurrentLinkedDeque<>(testList);
        this.finalResults = new ConcurrentLinkedDeque<>();
    }

    
    public BenchMark(String[] dataString, Set<AlgorithmInterface> testList) {
        this(testList);
        this.dataString = dataString;
    }

    public BenchMark(int[] dataInt, Set<AlgorithmInterface> testList) {
        this(testList);
        this.dataInt = dataInt;
    }
    
    public void run() {
        System.out.println("starting run");
        if (dataString == null) {
            ExecutorService threadPool = Executors.newFixedThreadPool(testList.size());
            runIntTest(threadPool);
            try {
                while(!threadPool.awaitTermination(1, TimeUnit.MINUTES));
            } catch (InterruptedException ex) {
                Logger.getLogger(BenchMark.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (dataInt == null) {
            ExecutorService threadPool = Executors.newFixedThreadPool(testList.size());
            runStringTest(threadPool);
            try {
                while(!threadPool.awaitTermination(1, TimeUnit.MINUTES));
            } catch (InterruptedException ex) {
                Logger.getLogger(BenchMark.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }

    private void runIntTest(ExecutorService threadPool) {
        System.out.println("starting int threads");
        
        for (int i = 0; i < testList.size(); i++) {
            threadPool.submit(new Runnable() {
                public void run() {
                    // create thread and run sort 20 times, store average
                    AlgorithmInterface test = testList.pop();
                    
                    
                    long sum = 0;
                    for (int i = 0; i < 20; i++) {
                        int[] copy = Arrays.copyOf(dataInt, dataInt.length);
                        long startTime = System.currentTimeMillis();
                        test.sort(copy);
                        long endTime = System.currentTimeMillis();
                        
                        sum += endTime - startTime;
                        
                    }
                    
                    double average = sum / (double)20;
                    String result = test.getName() + ":\tAverage Sort Time: " 
                            + average;
                    
                    finalResults.addLast(result);
                }
            });
        }
        threadPool.shutdown();

        
    }

    private void runStringTest(ExecutorService threadPool) {
        
        for (int i = 0; i < testList.size(); i++) {
            threadPool.submit(new Runnable() {
                public void run() {
                    // create thread and run sort 20 times, store average
                    AlgorithmInterface test = testList.pop();
                    
                    
                    long sum = 0;
                    for (int i = 0; i < 20; i++) {
                        String[] copy = Arrays.copyOf(dataString, dataString.length);
                        long startTime = System.nanoTime();
                        test.sort(copy);
                        long endTime = System.nanoTime();
                        
                        sum += endTime/1000000 - startTime/1000000;
                        
                    }
                    
                    double average = sum / (double)20;
                    String result = test.getName() + ":\tAverage Sort Time (ms): " 
                            + average;
                    
                    finalResults.addLast(result);
                }
            });
        }
        threadPool.shutdown();
        try {
            while(!threadPool.awaitTermination(1, TimeUnit.MINUTES));
        } catch (InterruptedException ex) {
            Logger.getLogger(BenchMark.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    String getResults() {
        StringBuilder sb = new StringBuilder();
        
        sb.append("Sorting Performance Results:\n");
        sb.append("============================\n\n");

        String[] results = new String[finalResults.size()];
        finalResults.toArray(results);
        for (int i = 0; i < results.length; i++) {
            sb.append(results[i]);
            sb.append("\n");
        }
        
        return sb.toString();
    }
    

    
    
}

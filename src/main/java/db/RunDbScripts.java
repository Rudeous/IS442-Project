package db;

import java.util.concurrent.*;
import java.io.IOException;

public class RunDbScripts implements Runnable {
    static Process process;

    public void run() {
        System.out.println("Thread is running...");
        try {
            process = Runtime.getRuntime().exec("src\\main\\resources\\mongodb\\windows\\mongod\\startMongod.bat");
            // ProcessBuilder processBuilder = new ProcessBuilder("src\\main\\resources\\mongodb\\windows\\mongod\\startMongod.bat");
            // processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void runBatchFile() {
        // start a thread pool of 2 so that db script can continue running in background
        // without obstructing main code
        // ExecutorService executor = Executors.newFixedThreadPool(2);
        // ProcessBuilder processBuilder = new ProcessBuilder("src\\main\\resources\\mongodb\\windows\\mongod\\startMongod.bat");

        // Main thread creating a child thread
        RunDbScripts runnableObj1 = new RunDbScripts(); // runnable object/target
        Thread thread1 = new Thread(runnableObj1);
        thread1.start();

        // executor.execute(new Runnable() { // run mongodb server process in a
        // subthread
        // public void run() { // override run method in runnable interface
        // try {
        // // process =
        // Runtime.getRuntime().exec("src\\main\\resources\\mongodb\\windows\\mongod\\startMongod.bat");
        // processBuilder.start();
        // } catch(IOException e) {
        // e.printStackTrace();
        // }
        // }
        // });

    }

    public static void runBashScript() {
        ProcessBuilder processBuilder = new ProcessBuilder("src\\main\\resources\\mongodb\\mac\\installMongodb.sh");
        // check how mac directories work if needed
    }
}

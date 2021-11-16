package db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunWindowsDbScripts implements Runnable {

    public void run() {

        // Displaying the thread that is running
        System.out.println(
            "Thread " + Thread.currentThread().getId()
            + " is running");
        
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", System.getProperty("user.dir")+"\\src\\main\\resources\\mongodb\\windows\\mongod\\startMongod.bat");
        System.out.println(System.getProperty("user.dir")+"\\src\\main\\resources\\mongodb\\windows\\mongod\\startMongod.bat");

        try {
            // executes windows batch file to start mongodb server in this new thread
            // processBuilder.redirectErrorStream(true);
            Process p = processBuilder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) { break; }
                System.out.println(line);
            }
        } catch(IOException e) {
            System.out.println("Mongodb server not started successfully since batch file could not be run");
        }


    }

    public static void runBatchFile() {
        // start a thread pool of 2 so that db script can continue running in background
        // without obstructing main code
        // ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread obj = new Thread(new RunWindowsDbScripts());
        obj.start();
        System.out.println("Thread with mongoDb server running has been created");
    }
}

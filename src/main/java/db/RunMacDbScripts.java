package db;

import java.util.concurrent.atomic.AtomicBoolean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunMacDbScripts implements Runnable {

    public void run() {
        // Displaying the thread that is running
        System.out.println("Thread " + Thread.currentThread().getId() + " is running");

        String cmd = System.getProperty("user.dir")+"/src/main/resources/mongodb/mac/startMongod.sh";
        // String cmd = "D://script.bat" //for windows
        ProcessBuilder pb = new ProcessBuilder(cmd);
        try {
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            String result = builder.toString();
            System.out.print(result);
            System.out.println("end of script execution");
        } catch (IOException e) {
            System.out.print("Mongodb server not started successfully since bash script file could not be run");
            e.printStackTrace();
        }

    }

    public static void runBashScript() {
        // check how mac directories work if needed
        Thread obj = new Thread(new RunMacDbScripts());
        obj.start();
        System.out.println("Thread with mongoDb server running has been created");
    }
}

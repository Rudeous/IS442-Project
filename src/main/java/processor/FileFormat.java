package processor;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import selenium.HSCodes;
import java.util.concurrent.TimeUnit;


public class FileFormat {
    public static void call(String fileName, String folderName) {
        String script = System.getProperty("user.dir")+"\\src\\main\\resources\\change_file_format.vbs ";
        String filepath =
                System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+folderName+"\\"+fileName+" ";
        try {
            System.out.println("Converting file format of "+filepath);
            Runtime.getRuntime().exec( "wscript " + script + filepath );
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void change_file_format(String folderName) throws InterruptedException {
        ArrayList<String> fileNames = HSCodes.getExcelFileNames();
        for (String fileName : fileNames){
            call(fileName, folderName);
        }
        TimeUnit.SECONDS.sleep(20);
    }
//    public static void call(){
//        File file = new File(System.getProperty("user.dir")+"\\src\\main" +
//                "\\resources\\testingexcel\\change_file_format.xlsm");
//        String macroName = "file_format";
//        callExcelMacro(file, macroName);
//    }
//
//    private static void callExcelMacro(File file, String macroName) {
//        ComThread.InitSTA(true);
//        final ActiveXComponent excel = new ActiveXComponent("Excel.Application");
//        try{
//            excel.setProperty("EnableEvents", new Variant(false));
//
//            Dispatch workbooks = excel.getProperty("Workbooks")
//                    .toDispatch();
//
//            Dispatch workBook = Dispatch.call(workbooks, "Open",
//                    file.getAbsolutePath()).toDispatch();
//
//            // Calls the macro
//            Variant V1 = new Variant( file.getName() + macroName);
//            Variant result = Dispatch.call(excel, "Run", V1);
//
//            // Saves and closes
//            Dispatch.call(workBook, "Save");
//
//            com.jacob.com.Variant f = new com.jacob.com.Variant(true);
//            Dispatch.call(workBook, "Close", f);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            excel.invoke("Quit", new Variant[0]);
//            ComThread.Release();
//        }
//    }
}

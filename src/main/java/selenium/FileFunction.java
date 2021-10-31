package selenium;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class FileFunction {
        public static void rename(String originalPath, String finalPath){
            // Create an object of the File class
            // Replace the file path with path of the directory
            java.io.File file = new java.io.File(originalPath);

            // Create an object of the File class
            // Replace the file path with path of the directory
            java.io.File rename =
                    new java.io.File(finalPath);

            // store the return value of renameTo() method in
            // flag
            System.out.println("Renaming file "+originalPath+" to "+finalPath);
            boolean flag = file.renameTo(rename);

            // if renameTo() return true then if block is
            // executed
            if (flag) {
                System.out.println("File Successfully Rename");
            }
            // if renameTo() return false then else block is
            // executed
            else {
                System.out.println("Operation Failed");
            }
        }

        public static File[] getFiles(String folderName){
            java.io.File dir =
                    new java.io.File(System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+folderName);
            java.io.File[] files = dir.listFiles();

            //Sort files in ascending order base on last modification date
            assert files != null;
            Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
//            for (File file : files) {
//                System.out.printf("File: %s - " + new Date(file.lastModified()) + "\n", file.getName());
//            }
            return files;
        }

        public static void renameFiles(String folderName){
            File[] sortedFiles = getFiles(folderName);
            ArrayList<String> productList = HSCodes.getProductNames();
            for (int i=0;i<sortedFiles.length-7;i++) {
                System.out.println(sortedFiles[i].getAbsolutePath());
                rename(sortedFiles[i].getAbsolutePath(),
                        System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+folderName+"\\EXPORT_"+productList.get(i)+
                                ".xls");
            }
            int productCodeIndex=0;
            for (int i=7;i<sortedFiles.length;i++) {
                System.out.println(sortedFiles[i].getName());
                rename(sortedFiles[i].getAbsolutePath(),
                        System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\"+folderName+"\\IMPORT_"+productList.get(productCodeIndex)+".xls");
                productCodeIndex++;
            }
        }
}

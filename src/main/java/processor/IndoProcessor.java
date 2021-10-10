package processor;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.*;
import java.io.*;

public class IndoProcessor {
    public static void process()
    {
        try
        {
            FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main\\resources\\testingexcel\\resources\\EXPORT_condensates.xls"));

            //Create Workbook instance holding reference to .xlsx file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            String countryIndicator = "not reached";//not reached, doing, null
            ArrayList<String> countries = new ArrayList<>();
            Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
            while (rowIterator.hasNext())
            {
                System.out.println("======New Row=========");
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //for putting the countries in a
                    if (Objects.equals(cell.toString(), "Negara") && countryIndicator.equals("not reached")){
                        countryIndicator = "doing";
                        continue;
                    }
                    if (!Objects.equals(cell.toString(),"") && countryIndicator.equals("doing")){
                        countries.add(cell.toString());
                        numbers.put(cell.toString(),1);
                    }
                    if (Objects.equals(cell.toString(),"Totals") && countryIndicator.equals("doing")){
                        countryIndicator = "done";
                    }
                    //Check the cell type and format accordingly
                    System.out.println(cell.toString());
                }
                System.out.println("");
            }
            System.out.println(countries);
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

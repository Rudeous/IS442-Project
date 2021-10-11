package processor;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellType;
import selenium.HSCodes;

import java.util.*;
import java.io.*;

public class IndoProcessor {
    public static void process()
    {
        try
        {
            FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\main" +
                    "\\resources\\testingexcel\\resources\\EXPORT_naphtha.xls"));

            //Create Workbook instance holding reference to .xlsx file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            int cellCount=0;
            String countryIndicator = "not reached";//to track processing of country names
            ArrayList<String> countries = new ArrayList<>(); //store order of countries processed
            String currentCountry=""; //country checker for country hashtable
            Hashtable<String, Integer> country = new Hashtable<String, Integer>();//track horizontal cells occupied
            ArrayList<String> countryRow = new ArrayList<>();

            int portCount=0;
            String portIndicator = "not reached";
            ArrayList<String> ports = new ArrayList<>();
            String currentPort="";
            Hashtable<String, Integer> port = new Hashtable<String, Integer>();
            ArrayList<String> portRow = new ArrayList<>();

            int monthCount=0;
            String monthIndicator = "not reached";
            ArrayList<String> months = new ArrayList<>();
            ArrayList<String> monthRow = new ArrayList<>();
            ArrayList<String> monthNames = HSCodes.getMonthNames();

            String yearIndicator = "not reached";

            ArrayList<ArrayList<String>> values = new ArrayList<>();


            while (rowIterator.hasNext())
            {
                int cellNumber = 0; // to keep track of which cell number when iterating columns
                System.out.println("======New Row=========");
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                ArrayList<String> valueRow = new ArrayList<>();


                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    //COUNTRY==================================================================
                    if (Objects.equals(cell.toString(), "Negara") && countryIndicator.equals("not reached")) {
                        countryIndicator = "doing";
                        continue;
                    }
                    if (Objects.equals(cell.toString(), "Totals") && countryIndicator.equals("doing")) {
                        countryIndicator = "done";
                    }
                    if (!Objects.equals(cell.toString(), "") && countryIndicator.equals("doing")) {//new country
                        // detected
                        countries.add(cell.toString());
                        currentCountry = cell.toString();
                        country.put(cell.toString(), 1);
                        cellCount++;
                        countryRow.add(currentCountry);
                    }
                    if (Objects.equals(cell.toString(), "") && countryIndicator.equals("doing")) {//blank space
                        int count = country.containsKey(currentCountry) ? country.get(currentCountry) : 0;
                        country.put(currentCountry, count + 1);
                        cellCount++;
                        countryRow.add(currentCountry);
                    }

                    //PORT===============================================================
                    if (Objects.equals(cell.toString(), "Pelabuhan") && portIndicator.equals("not reached")) {
                        portIndicator = "doing";
                        continue;
                    }
                    if (portCount == cellCount && portIndicator.equals("doing")) {
                        portIndicator = "done";
                    }
                    if (!Objects.equals(cell.toString(), "") && portIndicator.equals("doing")) {//new country
                        // detected
                        //ports.add(cell.toString());
                        //port.put(cell.toString(),1);
                        currentPort = cell.toString();
                        portRow.add(countryRow.get(portCount) + ":" + currentPort);
                        portCount++;

                    }
                    if (Objects.equals(cell.toString(), "") && portIndicator.equals("doing")) {//blank space
                        //int count = port.containsKey(currentPort) ? port.get(currentPort) : 0;
                        //port.put(currentPort, count + 1);
                        portRow.add(countryRow.get(portCount) + ":" + currentPort);
                        portCount++;
                    }

                    //MONTH==================================================================
                    if (Objects.equals(cell.toString(), "Bulan") && monthIndicator.equals("not reached")) {
                        monthIndicator = "doing";
                        continue;
                    }
                    if (monthCount == cellCount && monthIndicator.equals("doing")) {
                        monthIndicator = "done";
                        System.out.println("asdadad");
                    }
                    if (monthCount < cellCount && monthIndicator.equals("doing")) {
                        System.out.println("formatting : " + cell.toString());
                        monthRow.add(portRow.get(monthCount) + ":" + monthNames.get(Integer.parseInt(cell.toString().substring(1, 3))));
                        System.out.println(cellCount + " Monthcount :" + monthCount);
                        monthCount++;
                    }

                    //VALUES/READINGS==========================================================================
                    if (cell.toString().equals("Kode HS")) {//next numeric cell will be the first year
                        yearIndicator = "doing";
                        break;
                    }
                    if (cell.toString().equals("Totals") && yearIndicator.equals("doing")){
                        yearIndicator="done";
                    }
                    if (yearIndicator.equals("doing") && cell.toString().equals("") && cellNumber==0){
                        valueRow.add(values.get(values.size()-1).get(0));
                        continue;
                    }
                    if (yearIndicator.equals("doing")) {
                        valueRow.add(cell.toString());
                    }

                    //Check the cell type and format accordingly
                    System.out.println(cell.toString());
                    cellNumber++;
                }
                if (yearIndicator.equals("doing") && valueRow.size()>0){
                    valueRow.remove(2);
                    valueRow.remove(valueRow.size()-1);
                    values.add(valueRow);
                }
                System.out.println("");
            }
            System.out.println(country);
            System.out.println(countries);
            System.out.println(port);
            System.out.println(ports);
            System.out.println(countryRow);
            System.out.println(portRow);
            System.out.println(monthRow);
            System.out.println(values);
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

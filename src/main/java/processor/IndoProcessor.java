package processor;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Iterator;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CellType;
import org.w3c.dom.ranges.Range;
import scrapers.HSCodes;
import org.json.*;
import java.util.LinkedHashMap;

import java.util.*;
import java.io.*;

public class IndoProcessor {

    public static void processAll(){
        java.io.File dir =
                new java.io.File(System.getProperty("user.dir")+"\\src\\main\\resources\\indonesia\\");
        java.io.File[] files = dir.listFiles();

        //Sort files in ascending order base on last modification date
        assert files != null;
        Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
        String folderName = files[files.length-1].getAbsolutePath(); //get folder name


        ArrayList<String> fileNames = HSCodes.getExcelFileNames();
        String importExportFlag = "";
        JSONObject finalJSONFile = generateJSONObject();
        for (String fileName : fileNames){
            String[] arrOfStr = fileName.split("_", 2);
            String type = arrOfStr[0]; //import or export
            String productGroup = arrOfStr[1];
            JSONObject productGroupJsonObject = process(fileName,folderName);
            if (finalJSONFile.has(type)){
                finalJSONFile.getJSONObject(type).put(productGroup,productGroupJsonObject);
            }
            else{
                finalJSONFile.put(type,generateJSONObject().put(productGroup,productGroupJsonObject));
            }
        }
        printJson(finalJSONFile);
        writeJsonObjToFile(finalJSONFile,folderName+"\\indonesiaDataset.json");
    }

    public static void printJson(JSONObject jsonObj){
        int spacesToIndentEachLevel = 4;
        System.out.println(jsonObj.toString(spacesToIndentEachLevel));
    }

    public static JSONObject process(String productFile, String folderName)
    {
        try
        {
            FileInputStream file = new FileInputStream(new File(folderName+"\\"+productFile+".xls"));
            System.out.println("reading "+folderName);
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
            boolean totalsColumnExists = false; //some excel files are missing the last column: Totals

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

            ArrayList<ArrayList<BigDecimal>> values = new ArrayList<>();


            while (rowIterator.hasNext())
            {
                int cellNumber = 0; // to keep track of which cell number when iterating columns
                //System.out.println("======New Row=========");
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                ArrayList<BigDecimal> valueRow = new ArrayList<>();


                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    //COUNTRY==================================================================
                    if (Objects.equals(cell.toString(), "Negara") && countryIndicator.equals("not reached")) {
                        countryIndicator = "doing";
                        continue;
                    }
                    if (Objects.equals(cell.toString(), "Totals") && countryIndicator.equals("doing")) {
                        countryIndicator = "done";
                        totalsColumnExists = true;
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
                    }
                    if (monthCount < cellCount && monthIndicator.equals("doing")) {
                        //System.out.println("formatting : " + cell.toString());
                        monthRow.add(portRow.get(monthCount) + ":" + monthNames.get(Integer.parseInt(cell.toString().substring(1, 3))));
                        //System.out.println(cellCount + " Monthcount :" + monthCount);
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
                    if (yearIndicator.equals("doing") && cell.toString().equals("") && cellNumber==0){//copy previous
                        // year if product code doesn have year in the row
                        valueRow.add(values.get(values.size() - 1).get(0));
                        continue;
                    }
                    if (yearIndicator.equals("doing") && cell.toString().equals("")) {
                        valueRow.add(new BigDecimal(0));
                    }
                    if (yearIndicator.equals("doing") && !cell.toString().equals("")){
                        if (cell.getCellType().equals(CellType.NUMERIC)){
                            Double doubleValue = cell.getNumericCellValue();
                            //System.out.println("String value:"+doubleValue.toString());
                            BigDecimal bd = new BigDecimal(String.format("%.2f", doubleValue));
                            valueRow.add(bd);
                        }
                    }

                    //Check the cell type and format accordingly
                    //System.out.println(cell.toString());
                    cellNumber++;
                }
                if (countryIndicator.equals("doing")) {
                    countryIndicator = "done";
                }
                if (yearIndicator.equals("doing") && valueRow.size()>0){
                    if (totalsColumnExists) {
                        valueRow.remove(valueRow.size() - 1);
                    }
                    valueRow.remove(1);//remove the merged empty cell between year and first reading
                    values.add(valueRow);
                }
                //System.out.println("");
            }
//            System.out.println(country);
//            System.out.println(countries);
//            System.out.println(port);
//            System.out.println(ports);
//            System.out.println(countryRow);
//            System.out.println(portRow);
//            System.out.println(monthRow); //ARRAYLIST CONTAINING ALL COUNTRY,PORT,MONTH CORRESPONDING TO EACH READING
//            System.out.println(values);
//            for (ArrayList<BigDecimal> valueRow: values){
//                System.out.println("values size:"+valueRow.size());
//            }
//            System.out.println("monthRow size: "+monthRow.size());
            file.close();

            //TRANSFORM values arraylist to sum up all product groups in the same year
            ArrayList<ArrayList<BigDecimal>> newValues = new ArrayList<>();//
            BigDecimal currentYear = new BigDecimal(0);
            for (ArrayList<BigDecimal> eachValueRow: values){
                if ( Objects.equals(currentYear, new BigDecimal(0))|| !Objects.equals(eachValueRow.get(0),
                        currentYear)){
                    currentYear = eachValueRow.get(0);
                    newValues.add(new ArrayList<BigDecimal>(eachValueRow));
                }
                else{
                    for (int i=1; i<eachValueRow.size();i++){
                        BigDecimal sum = newValues.get(newValues.size()-1).get(i).add(eachValueRow.get(i));
                        newValues.get(newValues.size()-1).set(i,sum);
                    }
                }
            }
//            System.out.println(monthRow);
//            System.out.println(newValues);


            //WRITE INTO JSON FILE
            return convertToJson(monthRow,newValues);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return generateJSONObject().put("Error","error in reading and generating .json file");
    }

    public static JSONObject generateJSONObject(){ // allows json key value pair to be inserted in order
        JSONObject jsonProductObject = new JSONObject();
        try {
            Field changeMap = jsonProductObject.getClass().getDeclaredField("map");
            changeMap.setAccessible(true);
            changeMap.set(jsonProductObject, new LinkedHashMap<>());
            changeMap.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonProductObject;
    }

    public static JSONObject convertToJson(ArrayList<String> monthRow, ArrayList<ArrayList<BigDecimal>> newValues){
        //int spacesToIndentEachLevel = 2;
        //new JSONObject(jsonString).toString(spacesToIndentEachLevel);

        JSONObject jsonProductObject = generateJSONObject(); //final json product object

        for (ArrayList<BigDecimal> eachValueRow: newValues){
            JSONObject jsonYearObject = generateJSONObject(); //store all readings in a year into a json object
            String currentYear = String.format("%.0f", eachValueRow.get(0));
            for (int i=1; i<eachValueRow.size();i++){
                String[] arrOfStr = monthRow.get(i-1).split(":", 3);
                String country = arrOfStr[0];
                String port = arrOfStr[1];
                String month = arrOfStr[2];
                BigDecimal value = eachValueRow.get(i);
                if (!jsonYearObject.has(country)){ //country not inside yet
                    jsonYearObject.put(country,generateJSONObject().put(port,generateJSONObject().put(month,value)));
                    continue;
                }
                JSONObject jsonPortObject = jsonYearObject.getJSONObject(country);
                if (!jsonPortObject.has(port)){ //port not inside
                    jsonPortObject.put(port,generateJSONObject().put(month,value));
                    continue;
                }
                jsonPortObject.getJSONObject(port).put(month,value); //add in
            }
            jsonProductObject.put(currentYear,jsonYearObject);
        }
//        int spacesToIndentEachLevel = 4;
//        System.out.println(jsonProductObject.toString(spacesToIndentEachLevel));
        return jsonProductObject;
    }

    public static void writeJsonObjToFile(JSONObject jsonObj, String filePathAndName ) {
        // File outFile = new File(filePathAndName);
        try ( FileWriter fw = new FileWriter(filePathAndName) ) {
            // FileWriter fw = new FileWriter(filePathAndName);
            System.out.println("Printing now \n ---------------\n");
            System.out.println(jsonObj.toString());
            fw.write(jsonObj.toString(4));
            // fw.flush();
            System.out.println("Successfully written json object to json file");
        } catch (IOException e) {
            System.out.println("filepath + filename provided is a directory or file cannot be created in directory");
        }

    }
}

package processor;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

//  ASSUMPTIONS
// - row structure and line positioning remain constant

public class Processor {
//    private static final String CURRENTEXCEL = "./src/main/resources/PT_import.xls";
//    private static final String HISTORICALEXCEL = "./src/main/resources/PT_import_H.xls";

    // configurations to specify file object and open file in a workbook to process
    static DataFormatter dataFormatter = new DataFormatter(); // format data in cells
    // static File outputFile = new File("./src/main/resources/India1OilData.json");
    static JSONObject processedJsonObj = new JSONObject();
    static int monthsArrRowNum = 0;
    static int importProdStart = 0;
    static int importProdEnd = 0;
    static int exportProdStart = 0;
    static int exportProdEnd = 0;
    static int netImportRowNum = 0;

    public static void ProcessIndia1(String xlsPathAndFile) {
        try {
            FileInputStream file = new FileInputStream(xlsPathAndFile);
            Workbook workbook = new HSSFWorkbook(file); // HSSF for .xls, XSSF for xlsx

            // monthsArr to display in monthly time series
            // json.put("monthsArr", new JSONArray("[\"April\",\"May\",\"June\",\"July\",\"August\",\"September\",\"October\",\"November\",\"December\",\"January\",\"February\",\"March\"]"));

            // iterate over data in excel sheet
            Iterator<Sheet> sheets = workbook.sheetIterator();
            while(sheets.hasNext()) {
                Sheet sheet = sheets.next();
                System.out.println("Sheet name is " + sheet.getSheetName());
                System.out.println("----------------------------");

                // process each sheet and get overall json
                if (sheet.getSheetName().equals("PT_IMPORT_H")) {
                    continue; // no need for import/exports collected into years
                }
                if (sheet.getSheetName().equals("PT_IMPORT_2016-17")) {
                    break; // stop loop, only need monthly timeseries until 2017, error getting sheet for 2013-14 + earlier
                }
                processedJsonObj.put( sheet.getSheetName(), processSingleSheet(sheet,workbook) );
            }
            workbook.close();
            // finished iterating through every sheet in xls file -> write resultant json obj to json file
            writeJsonObjToFile(processedJsonObj, "./src/main/resources/processedJSON.json");
        } catch (FileNotFoundException e) {
            System.out.printf("File with the filepath %s cannot be found%n", xlsPathAndFile );
        } catch (IOException e) {
            System.out.printf("I/O operations on file %s cannot be executed successfully%n", xlsPathAndFile );
        }
    }

    static JSONObject processSingleSheet( Sheet sheet, Workbook workbook ) {
        JSONObject sheetJsonObj = new JSONObject();
        Iterator<Row> iterator = sheet.iterator();
        // iterate through rows in sheet to get relevant rows indexes to add
        while (iterator.hasNext()) {
            Row row = iterator.next();
            Iterator<Cell> cellIterator = row.iterator();

            // check content of first cell in row for decision
            Cell cell = cellIterator.next();
            switch (cell.getStringCellValue()) {
                case "IMPORT/EXPORT":
                    monthsArrRowNum = cell.getRowIndex();
                    System.out.println("Row number is " + monthsArrRowNum);
                    break;
                case "IMPORT^":
                    importProdStart = cell.getRowIndex() + 1; // import label row not needed
                    System.out.println("row start " + importProdStart);
                    break;
                case "TOTAL IMPORT":
                    importProdEnd = cell.getRowIndex();
                    System.out.println("row end " + importProdEnd);
                    break;
                case " PRODUCT EXPORT @":
                    exportProdStart = cell.getRowIndex() + 1; // export label row not needed
                    System.out.println("row start " + exportProdStart);
                    break;
                case "TOTAL  PRODUCT EXPORT":
                    exportProdEnd = cell.getRowIndex();
                    System.out.println("row end " + exportProdEnd);
                    break;
                case "NET IMPORT":
                    netImportRowNum = cell.getRowIndex();
                    System.out.println("Row number is " + netImportRowNum);
                    break;
                default:
                    continue;
            }
        }


        sheetJsonObj.put("Periods", getSingleRowString(monthsArrRowNum, sheet) );
        sheetJsonObj.put("Imports", getMultipleRows(importProdStart, importProdEnd, sheet, workbook) );
        sheetJsonObj.put("Exports", getMultipleRows(exportProdStart, exportProdEnd, sheet, workbook) );
        sheetJsonObj.put("Net Import", getSingleRowNumbers(netImportRowNum, sheet) );
        System.out.println(sheetJsonObj);
        return sheetJsonObj;
    }


    static JSONArray getSingleRowString(int rowNum, Sheet sh) {
        Row row = sh.getRow(rowNum);
        ArrayList<String> valueList = new ArrayList<>();
        for (Cell cell : row) {
            if (cell.getColumnIndex() == 0) {
                continue; // first column not needed
            }
            valueList.add(cell.getStringCellValue());
        }
        JSONArray jsonArr = new JSONArray(valueList);
        return jsonArr;
    }

    static JSONArray getSingleRowNumbers(int rowNum, Sheet sh) {
        Row row = sh.getRow(rowNum);
        ArrayList<Integer> valueList = new ArrayList<>();
        for (Cell cell : row) {
            if (cell.getColumnIndex() == 0) {
                continue; // first column not needed
            }
            valueList.add((int)cell.getNumericCellValue());
        }
        JSONArray jsonArr = new JSONArray(valueList);
        return jsonArr;
    }

    static JSONArray getMultipleRows(int rowStartIndex, int rowEndIndex, Sheet sh, Workbook workbook) {
        JSONArray jsonArr = new JSONArray(); // to store product:monthValueList pairs
        // iterate through each row to add relevant imports
        for (int i = rowStartIndex; i <= rowEndIndex ; i++) {
            Row row = sh.getRow(i);

            String rowKey = "";
            ArrayList<Integer> rowArrList = new ArrayList<>();
            for (Cell cell : row) {

                // get first column -> key
                if (cell.getColumnIndex() == 0) {
                    rowKey = cell.getStringCellValue(); // first column not needed
                    rowKey = rowKey.replaceAll("[^a-zA-Z0-9/ ]", "");
                    System.out.println(cell.getCellType());
                    System.out.println(rowKey);
                    continue;
                }

                switch (cell.getCellType()) {
                    case BLANK:
                        rowKey = "";
                        break; // irrelevant row
                    case NUMERIC:
                        rowArrList.add( (int)cell.getNumericCellValue() );
                        break;
                    case FORMULA:
                        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                        rowArrList.add( (int) evaluator.evaluate(cell).getNumberValue() );
                        break;
                }
            }
            // iterated through all cells in current row -> add rowKey:valueList to json arr
            JSONObject impJsonObj = new JSONObject();
            if (rowKey.equals("")) {
                continue; // row is irrelevant -> don't add to json arr
            }
//            impJsonObj.put("type", rowKey);
            impJsonObj.put(rowKey, rowArrList);
            jsonArr.put(impJsonObj);
        }
        //iterated through every row in import section
        // processedJsonObj.put("Imports", jsonArr);
        // System.out.println(jsonArr);
        // System.out.println(processedJsonObj);
        return jsonArr;
    }

    static void writeJsonObjToFile(JSONObject jsonObj, String filePathAndName ) {
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

package com.example.servingwebcontent.repository;


import db.MongoDbConnect;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class IndonesiaRepository{

    public static void printJson(JSONObject jsonObj){
        int spacesToIndentEachLevel = 4;
        // System.out.println(jsonObj.toString(spacesToIndentEachLevel));
    }

    public static BigDecimal convertToBigDecimal(Object monthsValue){
        BigDecimal monthValue = new BigDecimal(0);
        if (monthsValue instanceof Integer){
            Integer IntegerValue = (Integer) monthsValue;
            monthValue = BigDecimal.valueOf(IntegerValue);
        }
        else if (monthsValue instanceof BigDecimal){
            monthValue = (BigDecimal) monthsValue;
        }
        return monthValue;
    }

    public static ArrayList<Map<String, Map<String, Map<String, BigDecimal>>>> getAll() throws IOException {
        try {
//            InputStream is = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\example" +
//                    "\\servingwebcontent\\repository\\indonesiaDataset.json");
//            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
//            JSONObject json = new JSONObject(jsonTxt);
            ////
            JSONObject json = MongoDbConnect.retrieve("IndoOilData", "IS442");
            // System.out.println(json);

            JSONObject imports = (JSONObject) json.get("IMPORT");
            JSONObject exports = (JSONObject) json.get("EXPORT");

            // how the model object should look like:
//             {
//                 IMPORT:{
//                     (year):{
//                         (product_group):{ jan to dec values}
//                         (product_group):{ jan to dec values}
//                     }
//                 },
//                 EXPORT:{
//                     ...
//                 }
//             }
            Map<String, Map<String, Map<String, BigDecimal>>> importFinalMap = new HashMap<>();
            Map<String, Map<String, Map<String,BigDecimal>>> exportFinalMap = new HashMap<>();
            for (int i=0;i<2;i++){
                Map<String, Map<String, Map<String,BigDecimal>>> finalMap = new HashMap<>();
                JSONObject Types = null;
                if (i==0){
                    Types = imports;
                }
                else{
                    Types = exports;
                }
                Iterator<String> productGroups = Types.keys(); //productgroup 'crudeoil' key
                while(productGroups.hasNext()){
                    String productGroupKey = productGroups.next();
                    //System.out.println(productGroupKey);
                    if (imports.get(productGroupKey) instanceof JSONObject){
                        JSONObject productGroup = (JSONObject) Types.get(productGroupKey);
                        Iterator<String> productGroupYears = productGroup.keys(); //productgroupyear '2017' key

                        while (productGroupYears.hasNext()){
                            String productGroupYearKey = productGroupYears.next();
                            //System.out.println(productGroupYearKey);
                            //add year and country if not in map
                            if (!finalMap.containsKey(productGroupYearKey)){
                                finalMap.put(productGroupYearKey,new HashMap<String, Map<String,BigDecimal>>());
                            }
                            if (!finalMap.get(productGroupYearKey).containsKey(productGroupKey)){
                                finalMap.get(productGroupYearKey).put(productGroupKey, new HashMap<String,BigDecimal>());
                            }

                            if (productGroup.get(productGroupYearKey) instanceof JSONObject){
                                JSONObject productGroupCountry = (JSONObject) productGroup.get(productGroupYearKey);
                                Iterator<String> productGroupCountries = productGroupCountry.keys(); //productgroupcountry
                                // 'Algeria' key

                                while(productGroupCountries.hasNext()){
                                    String productGroupCountryKey = productGroupCountries.next();
                                    //System.out.println(productGroupCountryKey);
                                    if (productGroupCountry.get(productGroupCountryKey) instanceof JSONObject){
                                        JSONObject countryPort =
                                                (JSONObject) productGroupCountry.get(productGroupCountryKey);
                                        Iterator<String> countryPorts = countryPort.keys(); //countryport 'CILACAP' key

                                        while (countryPorts.hasNext()){
                                            String countryPortKey = countryPorts.next();
                                            //System.out.println(countryPortKey);
                                            if (countryPort.get(countryPortKey) instanceof JSONObject){
                                                JSONObject monthsValue = (JSONObject) countryPort.get(countryPortKey);
                                                // 'january: 100, feb: 122'
                                                Iterator<String> months = monthsValue.keys();

                                                while (months.hasNext()){
                                                    String monthNameKey = months.next();
                                                    //System.out.println("Key: "+monthNameKey);
                                                    //System.out.println("Value: "+monthsValue.get(monthNameKey));
                                                    //System.out.println(monthsValue.get(monthNameKey).getClass().getName
                                                    // ());
                                                    BigDecimal monthValue = new BigDecimal(0);
                                                    if (monthsValue.get(monthNameKey) instanceof Integer){
                                                        Integer IntegerValue = (Integer) monthsValue.get(monthNameKey);
                                                        monthValue = BigDecimal.valueOf(IntegerValue);
                                                    }
                                                    else if (monthsValue.get(monthNameKey) instanceof BigDecimal){
                                                        monthValue = (BigDecimal) monthsValue.get(monthNameKey);
                                                    }
                                                    BigDecimal currentValue =
                                                            finalMap.get(productGroupYearKey).get(productGroupKey).containsKey(monthNameKey) ? finalMap.get(productGroupYearKey).get(productGroupKey).get(monthNameKey) : new BigDecimal(0);
                                                    finalMap.get(productGroupYearKey).get(productGroupKey).put(monthNameKey, currentValue.add(monthValue));
                                                }

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (i==0){
                    importFinalMap = finalMap;
                }
                else{
                    exportFinalMap = finalMap;
                }
            }
            //traversing json object


            //System.out.println(json);
            // System.out.println(importFinalMap);
            // MapUtils.debugPrint(System.out, "myMap", importFinalMap);
            ArrayList<Map<String, Map<String, Map<String, BigDecimal>>>> returnList = new ArrayList<>();
            returnList.add(importFinalMap);
            returnList.add(exportFinalMap);
            return returnList;
            //printJson(json);
        }
        catch(Exception e){
            e.printStackTrace();
//            throw new IOException();
            throw new RuntimeException("Error in Indonesia Repo Get All");
        }

    }

    public static ArrayList<Map<String, Map<String, Map<String, Map<String,BigDecimal>>>>> additional() throws IOException{

        try {
//            InputStream is = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\example" +
//                    "\\servingwebcontent\\repository\\indonesiaDataset.json");
//            String jsonTxt = IOUtils.toString(is, StandardCharsets.UTF_8);
//            JSONObject json = new JSONObject(jsonTxt);
            ////
            JSONObject json = MongoDbConnect.retrieve("IndoOilData", "IS442");
            // System.out.println(json);


            JSONObject imports = (JSONObject) json.get("IMPORT");
            JSONObject exports = (JSONObject) json.get("EXPORT");

            // how the model object should look like:
//             {
//                 IMPORT:{
//                     (year):{
//                         (product_group):{
//                            (month):{
//                              (country): value,
//                              (country2): value,
//                              ...
//                              total: value
//                              }
//                          }
//                         (product_group):{ jan to dec values}
//                     }
//                 },
//                 EXPORT:{
//                     ...
//                 }
//             }
            Map<String, Map<String, Map<String, Map<String,BigDecimal>>>> importFinalMap = new HashMap<>();
            Map<String, Map<String, Map<String, Map<String,BigDecimal>>>> exportFinalMap = new HashMap<>();
            for (int i=0;i<2;i++){
                Map<String, Map<String, Map<String, Map<String,BigDecimal>>>> finalMap = new HashMap<>();
                JSONObject Types = null;
                if (i==0){
                    Types = imports;
                }
                else{
                    Types = exports;
                }
                Iterator<String> productGroups = Types.keys(); //productgroup 'crudeoil' key
                while(productGroups.hasNext()){
                    String productGroupKey = productGroups.next();
                    //System.out.println(productGroupKey);
                    if (imports.get(productGroupKey) instanceof JSONObject){
                        JSONObject productGroup = (JSONObject) Types.get(productGroupKey);
                        Iterator<String> productGroupYears = productGroup.keys(); //productgroupyear '2017' key

                        while (productGroupYears.hasNext()){
                            String productGroupYearKey = productGroupYears.next();
                            //System.out.println(productGroupYearKey);
                            //add year and country if not in map
                            if (!finalMap.containsKey(productGroupYearKey)){
                                finalMap.put(productGroupYearKey,new HashMap<String, Map<String,Map<String,BigDecimal>>>());
                            }
                            if (!finalMap.get(productGroupYearKey).containsKey(productGroupKey)){
                                finalMap.get(productGroupYearKey).put(productGroupKey, new HashMap<String,Map<String,BigDecimal>>());
                            }

                            if (productGroup.get(productGroupYearKey) instanceof JSONObject){
                                JSONObject productGroupCountry = (JSONObject) productGroup.get(productGroupYearKey);
                                Iterator<String> productGroupCountries = productGroupCountry.keys(); //productgroupcountry
                                // 'Algeria' key
                                while(productGroupCountries.hasNext()) {
                                    String productGroupCountryKey = productGroupCountries.next();
                                    //System.out.println(productGroupCountryKey);
                                    if (productGroupCountry.get(productGroupCountryKey) instanceof JSONObject) {
                                        JSONObject countryPort =
                                                (JSONObject) productGroupCountry.get(productGroupCountryKey);
                                        Iterator<String> countryPorts = countryPort.keys();

                                        while (countryPorts.hasNext()){
                                            String countryPortKey = countryPorts.next();
                                            //System.out.println(countryPortKey);
                                            if (countryPort.get(countryPortKey) instanceof JSONObject){
                                                JSONObject monthsValue = (JSONObject) countryPort.get(countryPortKey);
                                                // 'january: 100, feb: 122'
                                                Iterator<String> months = monthsValue.keys();

                                                while (months.hasNext()){
                                                    String monthNameKey = months.next();
                                                    if (!finalMap.get(productGroupYearKey).get(productGroupKey).containsKey(monthNameKey)){
                                                        finalMap.get(productGroupYearKey).get(productGroupKey).put(monthNameKey, new HashMap<String, BigDecimal>());//country:monthvalue
                                                        finalMap.get(productGroupYearKey).get(productGroupKey).get(monthNameKey).put(productGroupCountryKey, convertToBigDecimal(monthsValue.get(monthNameKey)));
                                                    }
                                                    else{
                                                        if (!finalMap.get(productGroupYearKey).get(productGroupKey).get(monthNameKey).containsKey(productGroupCountryKey)) {
                                                            finalMap.get(productGroupYearKey).get(productGroupKey).get(monthNameKey).put(productGroupCountryKey, convertToBigDecimal(monthsValue.get(monthNameKey)));
                                                        }
                                                        else{
                                                            BigDecimal currentValue =
                                                                    finalMap.get(productGroupYearKey).get(productGroupKey).get(monthNameKey).get(productGroupCountryKey);
                                                            finalMap.get(productGroupYearKey).get(productGroupKey).get(monthNameKey).put(productGroupCountryKey, currentValue.add(convertToBigDecimal(monthsValue.get(monthNameKey))));
                                                        }
                                                    }
                                                }

                                            }
                                        }

                                    }
                                }
                            }
                        }
                    }
                }
                if (i==0){
                    importFinalMap = finalMap;
                }
                else{
                    exportFinalMap = finalMap;
                }
            }

            ArrayList<Map<String, Map<String, Map<String, Map<String, BigDecimal>>>>> returnList = new ArrayList<>();
            returnList.add(importFinalMap);
            returnList.add(exportFinalMap);
//            for (Map<String, Map<String, Map<String, Map<String, BigDecimal>>>> mapping: returnList){
//                for (String year: mapping.keySet()){
//                    for (String productGroup: mapping.get(year).keySet()){
//                        for (String month: mapping.get(year).get(productGroup).keySet()){
//                            for (String country: mapping.get(year).get(productGroup).get(month).keySet()){
//                                if (mapping.get(year).get(productGroup).get(month).get(country).compareTo(new BigDecimal(0))==0){
//                                    mapping.get(year).get(productGroup).get(month).remove(country);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
            // System.out.println(returnList.get(0));
            // System.out.println(returnList);
            return returnList;
        }
        catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error in Indonesia Repository Additional");
        }

    }


}


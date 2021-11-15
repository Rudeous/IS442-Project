package com.example.servingwebcontent.service;

import com.example.servingwebcontent.repository.IndiaRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class IndiaService {

    private final IndiaRepository indiaRepository;

    public IndiaService(IndiaRepository indiaRepository) {
        this.indiaRepository = indiaRepository;
    }

    public HashMap<String, HashMap<String, ArrayList>> getIndiaValues() {

        HashMap<String, HashMap<String, ArrayList>> processedJson = new HashMap<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            JSONObject indiaJsonObj = indiaRepository.getIndiaDataFromMongo();
            String indiaJsonString = indiaJsonObj.toString();
            TypeReference<HashMap<String, HashMap<String, ArrayList>>> typeReference = new TypeReference<HashMap<String, HashMap<String, ArrayList>>>() {
            };
            processedJson = mapper.readValue(indiaJsonString, typeReference);

        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // label of chart
//        ArrayList<String> sheetNamesList = new ArrayList<>();
//        for (String sheetName : processedJson.keySet()) {
//            sheetNamesList.add(sheetName);
//        }
        // System.out.println(sheetNamesList);

//        ArrayList<String> periodList = new ArrayList<>();
//        ArrayList<String> monthsList = new ArrayList<>();
//        periodList = processedJson.get(sheetNamesList.get(0)).get("Periods");
//
//        for (int i = 0; i < periodList.size() - 1; i++) {
//            monthsList.add(periodList.get(i));
//        }
//        System.out.print(monthsList);

//        ArrayList<String> netImport = new ArrayList<>();
//        HashMap<String, HashMap<String, ArrayList<HashMap<String, ArrayList<Integer>>>>> data = new HashMap<>();


        return processedJson;

    }



}

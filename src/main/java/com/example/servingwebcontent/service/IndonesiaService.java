package com.example.servingwebcontent.service;

import com.example.servingwebcontent.repository.IndonesiaRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class IndonesiaService {

    public static ArrayList<Map<String, Map<String, Map<String, Map<String,BigDecimal>>>>> getByOriginAndDestination() throws IOException {
        ArrayList<Map<String, Map<String, Map<String, Map<String,BigDecimal>>>>> Types = IndonesiaRepository.additional();
        return Types;
    }

    public static Map<String, Map<String, Map<String, BigDecimal>>> getNetValues() throws IOException {

        ArrayList<Map<String, Map<String, Map<String, BigDecimal>>>> Types = IndonesiaRepository.getAll();

        Map<String, Map<String, Map<String, BigDecimal>>> imports = Types.get(0);

        Map<String, Map<String, Map<String, BigDecimal>>> exports = Types.get(1);

        for (String year: imports.keySet()){
            for (String productGroup: imports.get(year).keySet()){
                for (String month: imports.get(year).get(productGroup).keySet()){
                    if ( exports.containsKey(year) && exports.get(year).containsKey(productGroup) && exports.get(year).get(productGroup).containsKey(month)){
                        BigDecimal monthimport = imports.get(year).get(productGroup).get(month);
                        BigDecimal monthexport = exports.get(year).get(productGroup).get(month);
                        // System.out.println("imports for "+month+": "+monthimport);
                        // System.out.println("exports for "+month+": "+monthexport);
                        BigDecimal diff = monthimport.subtract(monthexport);
                        // System.out.println("diff: "+diff);
                        imports.get(year).get(productGroup).put(month,diff);
                    }
                }
            }
        }

        for (String year: exports.keySet()){
            for (String productGroup: exports.get(year).keySet()){
                for (String month: exports.get(year).get(productGroup).keySet()){
                    if ( imports.containsKey(year) && imports.get(year).containsKey(productGroup) && !imports.get(year).get(productGroup).containsKey(month)){
                        imports.get(year).get(productGroup).put(month,
                                exports.get(year).get(productGroup).get(month).negate());
                        // System.out.println("Month: "+month);
                        // System.out.println("Exports: "+ imports.get(year).get(productGroup).get(month));
                    }
//                    else{
//                        System.out.println("ERRORR");
//                    }
                }
            }
        }

        return imports;

    }


}

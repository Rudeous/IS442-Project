package demo;

import demo.selenium.*;
import demo.Model.*;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import java.io.*;

@SpringBootApplication
public class MainJob {
    public static void main(String[] args) throws InterruptedException {

//        Scraper.seleniumScrapeIndia1();

//		SpringApplication.run(ThymeLeafJavascriptApplication.class, args);

//		List<String> periods = new ArrayList<String>();
//		periods.add("APRIL");
//		periods.add("MAY");
//		periods.add("JUNE");
//		periods.add("JULY");
//		periods.add("AUGUST");
//		periods.add("SEPTEMBER");
//		periods.add("OCTOBER");
//		periods.add("NOVEMBER");
//		periods.add("DECEMBER");
//		periods.add("JANUARY");
//		periods.add("FEBRUARY");
//		periods.add("MARCH");
//		periods.add("TOTAL");
//
//		List<Integer> crudeOilImValues = new ArrayList<Integer>();
//		crudeOilImValues.add(19711);
//		crudeOilImValues.add(18869);
//		crudeOilImValues.add(16865);
//		crudeOilImValues.add(19411);
//		crudeOilImValues.add(19786);
//		crudeOilImValues.add(16821);
//		crudeOilImValues.add(19303);
//		crudeOilImValues.add(19171);
//		crudeOilImValues.add(18714);
//		crudeOilImValues.add(20138);
//		crudeOilImValues.add(18646);
//		crudeOilImValues.add(19515);
//		crudeOilImValues.add(226954);
//
//		Product crudeOilIm = new Product(crudeOilImValues);
//
//		List<Product> imports = new ArrayList<Product>();
//		imports.add(crudeOilIm);
//
//		List<Integer> lpgExValues = new ArrayList<Integer>();
//		lpgExValues.add(37);
//		lpgExValues.add(35);
//		lpgExValues.add(33);
//		lpgExValues.add(37);
//		lpgExValues.add(31);
//		lpgExValues.add(40);
//		lpgExValues.add(36);
//		lpgExValues.add(42);
//		lpgExValues.add(41);
//		lpgExValues.add(39);
//		lpgExValues.add(41);
//		lpgExValues.add(45);
//		lpgExValues.add(463);
//
//		Product lpgEx = new Product(lpgExValues);
//
//		List<Product> exports = new ArrayList<Product>();
//		exports.add(lpgEx);
//
//		Sheet testSheet = new Sheet(
//				periods,
//				imports,
//				exports
//		);
//
//		ProcessedJson processed = new ProcessedJson(testSheet);
//
//		for (Product prod: processed.getSheet19_20().getExports()) {
//			for (int monthly: prod.getValuesPerMonth()) {
//				System.out.println(monthly);
//			}
//		}
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new FileInputStream(
                    new File("src/main/resources/processedJSON.json"));
            TypeReference<ProcessedJson> typeReference = new TypeReference<ProcessedJson>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            };
            ProcessedJson processedJson = mapper.readValue(inputStream, typeReference);
            for (Product prod: processedJson.getSheet19_20().getExports()) {
                for (int monthly : prod.getValuesPerMonth()) {
                    System.out.println(monthly);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//		String currentDirectory = System.getProperty("user.dir");
//		System.out.println("The current working directory is " + currentDirectory);
    }

}


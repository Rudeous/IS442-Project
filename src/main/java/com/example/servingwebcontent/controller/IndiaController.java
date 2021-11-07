package com.example.servingwebcontent.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/india")
public class IndiaController {

	@RequestMapping("/monthly")
	public String showPage(Model model) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(
					new File("src/main/resources/processedJSON.json"));
			TypeReference<HashMap<String, HashMap<String, ArrayList>>> typeReference = new TypeReference<HashMap<String, HashMap<String, ArrayList>>>() {
			};
			HashMap<String, HashMap<String, ArrayList>> processedJson = mapper.readValue(inputStream, typeReference);
			model.addAttribute("data", processedJson);
//            for (Product prod: processedJson.getSheet19_20().getExports()) {
//                for (int monthly : prod.getValuesPerMonth()) {
//                    System.out.println(monthly);
//                }
//            }

			for (String sheetName: processedJson.keySet()
				 ) {
				System.out.println(sheetName);
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

		return "india"; // name of HTML file
	}

}

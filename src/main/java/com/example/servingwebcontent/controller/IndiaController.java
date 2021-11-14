package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.service.IndiaService;
import org.springframework.beans.factory.annotation.Autowired;
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

	private final IndiaService indiaService;

	@Autowired
	public IndiaController(IndiaService indiaService) {
		this.indiaService = indiaService;
	}

	@RequestMapping("/monthly")
	public String showPage(Model model) {

		HashMap<String, HashMap<String, ArrayList>> processedJson = indiaService.getIndiaValues();
		model.addAttribute("data", processedJson);
//            for (Product prod: processedJson.getSheet19_20().getExports()) {
//                for (int monthly : prod.getValuesPerMonth()) {
//                    System.out.println(monthly);
//                }
//            }

//		for (String sheetName: processedJson.keySet()
//			 ) {
//			System.out.println(sheetName);
//		}

		return "india"; // name of HTML file
	}

}

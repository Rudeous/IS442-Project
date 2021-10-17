package demo.Controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import demo.Model.*;

import java.io.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/demo")
public class MyController {

	@RequestMapping("/template")
	public String showPage(Model model) {

		try {
			ObjectMapper mapper = new ObjectMapper();
			InputStream inputStream = new FileInputStream(
					new File("src/main/resources/processedJSON.json"));
			TypeReference<ProcessedJson> typeReference = new TypeReference<ProcessedJson>() {
			};
			ProcessedJson processedJson = mapper.readValue(inputStream, typeReference);
			model.addAttribute("data", processedJson);
//            for (Product prod: processedJson.getSheet19_20().getExports()) {
//                for (int monthly : prod.getValuesPerMonth()) {
//                    System.out.println(monthly);
//                }
//            }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "first-success"; // name of HTML file
	}

}

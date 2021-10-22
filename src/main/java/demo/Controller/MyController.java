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

	@RequestMapping("/import1920")
	public String showImport1920(Model model) {

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

		return "import1920"; // name of HTML file
	}

	@RequestMapping("/export1920")
	public String showExport1920(Model model) {

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

		return "export1920"; // name of HTML file
	}

	@RequestMapping("/import1819")
	public String showImport1819(Model model) {

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

		return "import1819"; // name of HTML file
	}

	@RequestMapping("/export1819")
	public String showExport1819(Model model) {

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

		return "export1819"; // name of HTML file
	}

	@RequestMapping("/import2021")
	public String showImport2021(Model model) {

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

		return "import2021"; // name of HTML file
	}

	@RequestMapping("/export2021")
	public String showExport2021(Model model) {

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

		return "export2021"; // name of HTML file
	}

	@RequestMapping("/import2122")
	public String showImport2122(Model model) {

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

		return "import2122"; // name of HTML file
	}

	@RequestMapping("/export2122")
	public String showExport2122(Model model) {

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

		return "export2122"; // name of HTML file
	}

}

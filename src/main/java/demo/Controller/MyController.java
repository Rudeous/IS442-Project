package demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import demo.Model.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/demo")
public class MyController {

	@RequestMapping("/template")
	public String showPage(Model model) {

		// populating an OilProduct Object to pass to Thmyeleaf Template Engine
		ArrayList<Integer> exportValuesList = new ArrayList<Integer>();
		exportValuesList.add(1358);
		exportValuesList.add(1487);
		exportValuesList.add(1218);
		exportValuesList.add(993);
		exportValuesList.add(1240);
		exportValuesList.add(1643);
		exportValuesList.add(1428);
		exportValuesList.add(1396);
		exportValuesList.add(1510);
		exportValuesList.add(1366);
		exportValuesList.add(1527);
		exportValuesList.add(1359);

		OilProduct Lpgx = new OilProduct("LPGexport", exportValuesList);
		model.addAttribute("LPGX", Lpgx);

		// populating an OilProduct Object to pass to Thmyeleaf Template Engine
		ArrayList<Integer> importValuesList = new ArrayList<Integer>();
		importValuesList.add(1340);
		importValuesList.add(1440);
		importValuesList.add(1239);
		importValuesList.add(1005);
		importValuesList.add(1340);
		importValuesList.add(1443);
		importValuesList.add(1128);
		importValuesList.add(1196);
		importValuesList.add(1610);
		importValuesList.add(1566);
		importValuesList.add(1327);
		importValuesList.add(1559);

		OilProduct Lpgm = new OilProduct("LPGimport", importValuesList);
		model.addAttribute("LPGM", Lpgm);

		// creating an arraylist of Months for x-axis labels
		ArrayList<String> monthsList = new ArrayList<String>();
		monthsList.add("Jan");
		monthsList.add("Feb");
		monthsList.add("Mar");
		monthsList.add("Apr");
		monthsList.add("May");
		monthsList.add("Jun");
		monthsList.add("Jul");
		monthsList.add("Aug");
		monthsList.add("Sep");
		monthsList.add("Oct");
		monthsList.add("Nov");
		monthsList.add("Dec");

		model.addAttribute("months", monthsList);

		return "template"; // name of HTML file
	}

}

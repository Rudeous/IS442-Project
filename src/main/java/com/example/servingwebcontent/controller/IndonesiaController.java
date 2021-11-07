package com.example.servingwebcontent.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import com.example.servingwebcontent.repository.IndonesiaRepository;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/indonesia")
public class IndonesiaController {

    @RequestMapping("/monthly")
    public String hello2(Model model) throws IOException {
        // line represents the product group
        // x axis is jan to dec
        // y axis is values

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
        ArrayList<Map<String, Map<String, Map<String, BigDecimal>>>> Types = IndonesiaRepository.getAll();
        Map<String, String> productGroup = new HashMap<String, String>() {{
            put("a", "b");
            put("c", "d");
        }};

        String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};

        model.addAttribute("months",months);
        model.addAttribute("import",Types.get(0));
        model.addAttribute("export",Types.get(1));
        //model.addAttribute("productGroup",productGroup);
        return "indonesia";
    }

}


package de.truckplatooning.controlservice;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Control {

    @GetMapping
    public String showController() {

        return "controller";

    }

  /* @PostMapping("/add")
    public ModelAndView add(@RequestParam("acc-value") int value, HttpServletRequest request, HttpServletResponse response) {


    }*/

}

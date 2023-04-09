package go.it.springlessons.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestControler {
    @GetMapping("/test")
    public String getSomething(Model model) {
        model.addAttribute("name", "John");

        return "test";
    }
}

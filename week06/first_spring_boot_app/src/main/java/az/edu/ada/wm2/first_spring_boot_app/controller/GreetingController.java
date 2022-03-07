package az.edu.ada.wm2.first_spring_boot_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class GreetingController {

    @GetMapping("/greeting")
    public String getGreetings(Model model) {
        model.addAttribute("message", "This is the message returned by the controller");
        return "greeting";
    }

}

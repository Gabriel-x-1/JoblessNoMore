package com.example.mvcproducts.controllers;

import com.example.mvcproducts.dto.RegisterRequest;
import com.example.mvcproducts.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final UserService userService;

    public CompanyController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "company-login";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        RegisterRequest request = new RegisterRequest();
        request.setRole("COMPANY");
        model.addAttribute("registerRequest", request);
        return "company-register";
    }

    @PostMapping("/register")
    public String registerCompany(RegisterRequest request) {
        request.setRole("COMPANY");
        userService.register(request);
        return "redirect:/company/login?registered";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Add any necessary model attributes for the company dashboard
        return "company-dashboard";
    }
}

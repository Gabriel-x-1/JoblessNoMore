package com.example.mvcproducts.controllers;

import com.example.mvcproducts.dto.RegisterRequest;
import com.example.mvcproducts.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "user-register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute RegisterRequest request, 
                         BindingResult result, 
                         RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "user-register";
        }

        try {
            userService.register(request);
            return "redirect:/login?registered";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }

    @GetMapping("/company/register")
    public String showCompanyRegisterForm(Model model) {
        model.addAttribute("registerRequest", new RegisterRequest());
        return "company-register";
    }

    @PostMapping("/company/register")
    public String registerCompany(@Valid @ModelAttribute RegisterRequest request, 
                                BindingResult result, 
                                RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "company-register";
        }

        try {
            request.setRole("ROLE_COMPANY");
            userService.register(request);
            return "redirect:/company/login?registered";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/company/register";
        }
    }
}

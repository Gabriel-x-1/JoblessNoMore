package com.example.mvcproducts.controllers;

import com.example.mvcproducts.dto.LoginRequest;
import com.example.mvcproducts.dto.LoginResponse;
import com.example.mvcproducts.services.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@Controller
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "user-login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, 
                             @RequestParam String password, 
                             RedirectAttributes redirectAttributes) {
        try {
            LoginRequest request = new LoginRequest();
            request.setEmail(email);
            request.setPassword(password);
            LoginResponse response = authService.login(request);
            
            if ("ROLE_COMPANY".equals(response.getUserType())) {
                return "redirect:/company/dashboard";
            } else {
                return "redirect:/dashboard";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Invalid credentials");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        authService.logout();
        new SecurityContextLogoutHandler().logout(request, response, null);
        return "redirect:/login?logout";
    }
}

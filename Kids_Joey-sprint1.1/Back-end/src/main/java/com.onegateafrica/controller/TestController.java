package com.onegateafrica.controller;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('PARENT') or hasRole('ENSEIGNAT') or hasRole('PARENT') or hasRole('DOCTEUR')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/parent")
    @PreAuthorize("hasRole('PARENT')")
    public String parentAccess() {
        return "PARENT Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "admin Board.";
    }

    @GetMapping("/enseignant")
    @PreAuthorize("hasRole('ANSEIGNANT')")
    public String enseignantAccess() {
        return "enseignant Board.";
    }


    @GetMapping("/docteur")
    @PreAuthorize("hasRole('DOCTEUR')")
    public String docteurAccess() {
        return "docteur Board.";
    }

}
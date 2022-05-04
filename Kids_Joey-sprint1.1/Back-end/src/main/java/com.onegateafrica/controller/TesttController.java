/* package com.onegateafrica.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/test")
public class TesttController {

    @RequestMapping(value = "/anonymous", method = RequestMethod.GET)
    public ResponseEntity<String> getAnonymous() {
        return ResponseEntity.ok("Hello Anonymous");
    }
    @RolesAllowed("user")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<String> getUser() {
        return ResponseEntity.ok("Hello User");
    }
    @RolesAllowed("admin")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ResponseEntity<String> getAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }
    @RolesAllowed("manager")
    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    public ResponseEntity<String> getManager() {
        return ResponseEntity.ok("Hello manager");
    }
    @RolesAllowed({ "admin", "user" , "manager","all" })
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<String> getAll() {
        return ResponseEntity.ok("Hello All User");
    }} */
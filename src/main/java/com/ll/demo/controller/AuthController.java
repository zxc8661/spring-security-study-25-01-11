package com.ll.demo.controller;

import com.ll.demo.model.SiteUser;
import com.ll.demo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<SiteUser> authenticate(@RequestBody SiteUser siteUser){
        return ResponseEntity.ok(authService.authenticate(siteUser));
    }


}

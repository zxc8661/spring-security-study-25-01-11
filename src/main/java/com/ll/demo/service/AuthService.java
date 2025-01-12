package com.ll.demo.service;


import com.ll.demo.config.service.JwtService;
import com.ll.demo.controller.dto.AuthResponse;
import com.ll.demo.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public AuthResponse authenticate(SiteUser siteUser) {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(siteUser.getEmail(), siteUser.getPassword())
      );
      return new AuthResponse(jwtService.generateToken(siteUser));
    }
}

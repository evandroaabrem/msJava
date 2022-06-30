package br.com.otima.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.otima.payload.request.LoginRequest;
import br.com.otima.payload.request.LogoutRequest;
import br.com.otima.payload.response.JwtResponse;
import br.com.otima.payload.response.MessageResponse;
import br.com.otima.service.AuthService;


@RestController
@RequestMapping("/api-auth")
public class AuthController {
  @Autowired
  private AuthService authService;
  
  
  @PostMapping("/login")
  public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
	    return ResponseEntity.ok(authService.loginUser(loginRequest));
  }
  
  @PostMapping("/logout")
  public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody LogoutRequest signUpRequest) {
	  
	  return ResponseEntity.ok(authService.logoutUser(signUpRequest));
  }

}

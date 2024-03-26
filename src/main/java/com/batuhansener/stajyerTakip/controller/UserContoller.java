package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.request.auth.AuthRequest;
import com.batuhansener.stajyerTakip.dto.request.auth.CreateUserRequest;
import com.batuhansener.stajyerTakip.model.User;
import com.batuhansener.stajyerTakip.service.JwtService;
import com.batuhansener.stajyerTakip.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserContoller {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserContoller(UserService userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    @GetMapping("/welcome")
    public String welcome(){
        return "hosgeldin";
    }

    @PostMapping("/register")
    public User addUSer(@RequestBody CreateUserRequest request){
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public String generateToken(@RequestBody AuthRequest request){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        if (authentication.isAuthenticated()){
            return jwtService.generateToken(request.username());
        }else {
            throw new UsernameNotFoundException("hatalı kullanıcı adı"+ request.username());
        }
    }

    @GetMapping("/user")
    public String getUSerString(){
        return "this is user";
    }

    @GetMapping("/admin")
    public String getAdminString(){
        return "this is admin";
    }
}

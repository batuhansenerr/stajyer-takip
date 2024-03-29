package com.batuhansener.stajyerTakip.controller;

import com.batuhansener.stajyerTakip.dto.response.UserDto;
import com.batuhansener.stajyerTakip.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/intern")
@RequiredArgsConstructor
public class InternController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllIntern(){
        return ResponseEntity.ok(userService.getAllInterns());
    }
}

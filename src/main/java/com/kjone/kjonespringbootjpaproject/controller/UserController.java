package com.kjone.kjonespringbootjpaproject.controller;


import com.kjone.kjonespringbootjpaproject.domain.user.SignRequest;
import com.kjone.kjonespringbootjpaproject.domain.user.SignResponse;
import com.kjone.kjonespringbootjpaproject.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<Boolean> register(@RequestBody SignRequest request) throws Exception{
//        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
//    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody SignRequest request) throws Exception {
        boolean registrationResult = userService.register(request);
        if (registrationResult) {
            return ResponseEntity.ok().body("Registration successful");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Registration failed. Email may already exist.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<SignResponse> login(@RequestBody SignRequest request) throws Exception{
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }


    @GetMapping("/get")
    public ResponseEntity<String> getUser(@RequestBody SignRequest request) throws Exception {
        if(request.getEmail() == null || request.getPassword() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not Found User");
        }
        return ResponseEntity.ok().body("ok");
    }




}

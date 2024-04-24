package com.kjone.kjonespringbootjpaproject.controller;


import com.kjone.kjonespringbootjpaproject.domain.email.Email;
import com.kjone.kjonespringbootjpaproject.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/email")
public class MailController {

    private EmailService emailService;

    @PostMapping("/send")
    public String SendEmail(@RequestBody Email email){
        int num = emailService.sendEmail(email.getEmail());
        return "코드 발급" + num;
    }

}

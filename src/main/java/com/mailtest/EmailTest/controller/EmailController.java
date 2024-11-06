package com.mailtest.EmailTest.controller;

import com.mailtest.EmailTest.model.EmailDetails;
import com.mailtest.EmailTest.service.EmailService;
import com.mailtest.EmailTest.serviceImpl.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendEmail")
    public String sendEmail(@RequestBody EmailDetails emailDetails) {
        String status = emailService.sendSimpleEmail(emailDetails);
        return status;
    }
}

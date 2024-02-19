package com.DWR.DWR_Record.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DWR.DWR_Record.dto.GeneratedLetterEmailDto;
import com.DWR.DWR_Record.service.EmailLogDetailsService;
import com.DWR.DWR_Record.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/DWR/Email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailLogDetailsService emailLogDetailsService;

    @PostMapping("send")
    public ResponseEntity<String> sendEmail(@RequestBody GeneratedLetterEmailDto generatedLetterEmailDto) {
        try {
            emailService.sendMail(generatedLetterEmailDto);
            emailLogDetailsService.addLog(generatedLetterEmailDto.getTo(), generatedLetterEmailDto.getAttachment(), generatedLetterEmailDto.getSubject(), generatedLetterEmailDto.getName());
            return ResponseEntity.ok("Email sent successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
        }
    }
}

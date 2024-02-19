package com.DWR.DWR_Record.serviceIMPL;

import com.DWR.DWR_Record.dto.GeneratedLetterEmailDto;
import com.DWR.DWR_Record.entity.SmtpConfigEntity;
import com.DWR.DWR_Record.repository.SmtpConfigRepository;
import com.DWR.DWR_Record.service.EmailService;
import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private SmtpConfigRepository smtpConfigRepository;

    @Override
    public void sendMail(GeneratedLetterEmailDto generatedLetterEmailDto) {
        try {
            // Fetch SMTP configuration from repository
            SmtpConfigEntity smtpConfig = smtpConfigRepository.findById(1L)
                    .orElseThrow(() -> new RuntimeException("SMTP configuration not found"));

            // Create a JavaMailSenderImpl instance
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            
            // Set JavaMailSenderImpl properties for Gmail SMTP
            mailSender.setHost("sandbox.smtp.mailtrap.io");
            mailSender.setPort(2525);
            mailSender.setUsername("f153642d0f1b38");
            mailSender.setPassword("dc8255df0fbe32");
            mailSender.setProtocol("smtp");
            mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
            mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");

            // Create a MimeMessage
            MimeMessage message = mailSender.createMimeMessage();

            // Use MimeMessageHelper to set properties
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(smtpConfig.getUsername());
            helper.setTo(generatedLetterEmailDto.getTo());
            helper.setSubject(generatedLetterEmailDto.getSubject());
            helper.setText(generatedLetterEmailDto.getBody(), true);

            // Create the attachment DataSource
            DataSource attachment = new ByteArrayDataSource(generatedLetterEmailDto.getAttachment(), "application/pdf");

            // Add the attachment to the message
            helper.addAttachment("attachment.pdf", attachment);

            // Send the email
            mailSender.send(message);
        } catch (MessagingException e) {
            // Handle the messaging exception
            e.printStackTrace(); // Or log the exception
            // You might want to throw a custom exception or handle it in another way
        }
    }
}

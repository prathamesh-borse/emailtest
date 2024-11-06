package com.mailtest.EmailTest.serviceImpl;

import com.mailtest.EmailTest.model.EmailDetails;
import com.mailtest.EmailTest.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Override
    public String sendSimpleEmail(EmailDetails emailDetails) {

        try {

            String subject = "Need approval and merge for sonarqube integration: " + emailDetails.getRepositoryUrl();

            String emailBody = String.format("Hello,\n\nWe need your approval for merging the SonarQube PR:\nRepository: %s\nPR: %s \n\nContributors: %s\n\nThanks and Regards,\nSonarQube Team", emailDetails.getRepositoryUrl(), emailDetails.getPrUrl(), emailDetails.getContributors());

            // creating a simple mail message
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailDetails.getContributors().toArray(new String[0]));
            simpleMailMessage.setText(emailBody);
            simpleMailMessage.setSubject(subject);

            javaMailSender.send(simpleMailMessage);
            return "Mail sent successfully..!";
        }// Catch block to handle the exceptions
        catch (Exception e) {
            return "Error while Sending Mail";
        }
    }
}

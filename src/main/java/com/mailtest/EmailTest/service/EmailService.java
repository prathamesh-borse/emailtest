package com.mailtest.EmailTest.service;

import com.mailtest.EmailTest.model.EmailDetails;

public interface EmailService {
    String sendSimpleEmail(EmailDetails emailDetails);
}

package com.feljtech.istudybucket.business.service;

import com.feljtech.istudybucket.api.dto.email.VerificationEmail;
import org.springframework.scheduling.annotation.Async;

public interface MailService {

    @Async
    void sendVerificationEmail(VerificationEmail verificationEmail);
    // TODO refine all delaying methods using asynchronous programming
    // TODO research on rabbitMQ

}

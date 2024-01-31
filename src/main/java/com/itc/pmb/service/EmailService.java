package com.itc.pmb.service;

import com.itc.pmb.enumeration.VerificationType;

public interface EmailService {
    void sendVerificationEmail(String fullName,
                               String email,
                               String verificationUrl,
                               VerificationType verificationType);
}

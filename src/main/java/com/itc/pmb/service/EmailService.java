package com.vialfinaz.sisteminforklinik.service;

import com.vialfinaz.sisteminforklinik.Enumeration.VerificationType;

public interface EmailService {
    void sendVerificationEmail(String firstName,
                               String email,
                               String verificationUrl,
                               VerificationType verificationType);
}

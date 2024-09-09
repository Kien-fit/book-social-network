package com.kienjd.profile.service;

import com.kienjd.profile.dto.request.EmailRequest;
import com.kienjd.profile.dto.request.SendEmailRequest;
import com.kienjd.profile.dto.request.Sender;
import com.kienjd.profile.dto.response.EmailResponse;
import com.kienjd.profile.exception.AppException;
import com.kienjd.profile.exception.ErrorCode;
import com.kienjd.profile.repository.httpclient.EmailClient;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;

    String apiKey = "your-brevo-apikey";

    public EmailResponse sendEmail(SendEmailRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("KienJavaDev")
                        .email("kienjd@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (FeignException e){
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}

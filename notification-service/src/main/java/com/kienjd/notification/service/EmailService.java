package com.kienjd.notification.service;

import com.kienjd.notification.dto.request.EmailRequest;
import com.kienjd.notification.dto.request.SendEmailRequest;
import com.kienjd.notification.dto.request.Sender;
import com.kienjd.notification.dto.response.EmailResponse;
import com.kienjd.notification.exception.AppException;
import com.kienjd.notification.exception.ErrorCode;
import com.kienjd.notification.repository.httpclient.EmailClient;
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

package com.kienjd.identity.repository.httpclient;

import com.kienjd.identity.configuration.AuthenticationRequestInterceptor;
import com.kienjd.identity.dto.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.kienjd.identity.dto.request.ProfileCreationRequest;
import com.kienjd.identity.dto.response.UserProfileResponse;

@FeignClient(name = "profile-service", url = "${app.services.profile}",
        configuration = {AuthenticationRequestInterceptor.class})
public interface ProfileClient {
    @PostMapping(value = "/internal/users", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserProfileResponse> createProfile(@RequestBody ProfileCreationRequest request);

}

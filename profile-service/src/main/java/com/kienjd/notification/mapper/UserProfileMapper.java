package com.kienjd.notification.mapper;

import org.mapstruct.Mapper;

import com.kienjd.notification.dto.request.ProfileCreationRequest;
import com.kienjd.notification.dto.response.UserProfileResponse;
import com.kienjd.notification.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}

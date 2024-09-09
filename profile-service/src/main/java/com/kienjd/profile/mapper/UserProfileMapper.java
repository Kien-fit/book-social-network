package com.kienjd.profile.mapper;

import org.mapstruct.Mapper;

import com.kienjd.profile.dto.request.ProfileCreationRequest;
import com.kienjd.profile.dto.response.UserProfileResponse;
import com.kienjd.profile.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(ProfileCreationRequest request);

    UserProfileResponse toUserProfileReponse(UserProfile entity);
}

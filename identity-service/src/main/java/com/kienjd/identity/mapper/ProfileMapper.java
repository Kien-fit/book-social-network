package com.kienjd.identity.mapper;

import org.mapstruct.Mapper;

import com.kienjd.identity.dto.request.ProfileCreationRequest;
import com.kienjd.identity.dto.request.UserCreationRequest;

@Mapper(componentModel = "spring")
public interface ProfileMapper {
    ProfileCreationRequest toProfileCreationRequest(UserCreationRequest request);
}

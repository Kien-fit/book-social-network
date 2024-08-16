package com.kienjd.identity.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.kienjd.identity.dto.request.RoleRequest;
import com.kienjd.identity.dto.response.RoleResponse;
import com.kienjd.identity.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}

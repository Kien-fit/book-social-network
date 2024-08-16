package com.kienjd.identity.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.kienjd.identity.dto.ApiResponse;
import com.kienjd.identity.dto.request.RoleRequest;
import com.kienjd.identity.dto.response.RoleResponse;
import com.kienjd.identity.service.RoleService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class RoleController {
    RoleService roleService;

    @PostMapping
    ApiResponse<RoleResponse> create(@RequestBody RoleRequest request) {
        return ApiResponse.<RoleResponse>builder()
                .result(roleService.create(request))
                .build();
    }

    @GetMapping
    ApiResponse<List<RoleResponse>> getAll() {
        return ApiResponse.<List<RoleResponse>>builder()
                .result(roleService.getAll())
                .build();
    }

    @DeleteMapping("/{role}")
    ApiResponse<Void> delete(@PathVariable String role) {
        roleService.delete(role);
        return ApiResponse.<Void>builder().build();
    }
}

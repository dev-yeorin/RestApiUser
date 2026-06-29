package com.example.restapiuser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateRequest(
        @Size(max=100, message="비밀번호는 100자리 이하입니다")
        String  passwd,

        @NotBlank(message = "이름은 필수입니다")
        @Size(max=100, message="이름은 100자리 이하입니다")
        String  username,

        @Email( message = "이메일 형식이 올바르지 않습니다" )
        @Size(max=200, message="이메일은 200자리 이하입니다")
        String  email
) {
}
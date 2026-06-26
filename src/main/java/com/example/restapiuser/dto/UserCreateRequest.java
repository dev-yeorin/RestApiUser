package com.example.restapiuser.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
// record 는 생성자를 만들어 준다
//          getUserid() -> userid() todtj: getter 역할 수핼
//          setter는 비생성
public record UserCreateRequest (
    @NotBlank(message = "아이디는 필수입니다")
    @Size(max = 50, message = "아이디는 최대 50자입니다")
    String userid,

    @NotBlank(message = "비밀번호는 필수입니다")
    @Size(max = 100, message = "비밀번호는 100자 이하입니다")
    String passwd,

    @NotBlank(message = "이름은 필수입니다")
    @Size(max = 50, message = "이름은 50자 이하입니다")
    String username,

    @Email(message = "이메일  형식이 올바르지 않습니다")
    @Size(max = 200, message = "이메일은 200자 이하입니다")
    String email
) {

}

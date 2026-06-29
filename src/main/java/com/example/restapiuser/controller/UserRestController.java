package com.example.restapiuser.controller;

import com.example.restapiuser.dto.DeleteResponse;
import com.example.restapiuser.dto.UserCreateRequest;
import com.example.restapiuser.dto.UserResponse;
import com.example.restapiuser.dto.UserUpdateRequest;
import com.example.restapiuser.entity.UserEntity;
import com.example.restapiuser.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController      // @Controler + @ResonseBody
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;
    public  UserRestController(UserService userService) {
        this.userService = userService;
    }

    // GET http://localhost:8080/api/users
    // GET http://localhost:8080/api/users?keyword=user
    @GetMapping
    public List<UserResponse> list(
            @RequestParam(required = false) String keyword) {
        return  userService.findUsers(keyword);
    }

    // 회원가입 : Create : Insert
    // POST http://localhost:8080/api/users
    // @RequestBody : js 에서 넘어오는 파라미터는 json 이다
    @PostMapping
    public ResponseEntity<UserResponse> create(
            @Valid @RequestBody UserCreateRequest request) {
        UserResponse  response = userService.createUser( request );
        // URI location = URI.create("http://localhost:8080/api/users/foo");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{userid}")
                .buildAndExpand( response.userid() )   // record 는 getUserid() -> response.userid()
                .toUri();
        return ResponseEntity.created(location).body(response);
        /* ResponseEntity : 저장된 data 와 location, 상태코드 를 반환해줌
        HTTP/1.1 201 Created                             // 201 : insert 성공
        Location: http://localhost:8080/api/users/admin  // .created(location)
        Content-Type: application/json
        // .body(response) :  생성된 사용자 정보를 JSON으로 응답
         */
    }

    // 회원삭제  DELETE   DELETE(SQL)
    // DELETE  http://localhost:8080/api/users/test1
    @DeleteMapping("/{userid}")
    public DeleteResponse delete(@PathVariable String userid) {
        userService.deleteUser( userid );
        return new DeleteResponse(userid, true);
    }

    // 회원수정  UPDATE
    // PATCH   PATCH http://localhost:8080/api/users/test01
    @PatchMapping("/{userid}")
    public UserResponse update(
            @PathVariable("userid")  String userid,
            @Valid @RequestBody UserUpdateRequest request
    ) {
        return  userService.updateUser( userid, request );
    }



}








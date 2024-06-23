package com.travelgo.backend.domain.user.controller;

import com.travelgo.backend.domain.user.dto.Request.UserRequest;
import com.travelgo.backend.domain.user.dto.Response.UserResponse;
import com.travelgo.backend.domain.user.exception.UserNotFoundException;
import com.travelgo.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "유저", description = "유저 API (#7)")
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Operation(summary = "회원가입", description = "회원가입 후 닉네임과 기본 값들 설정")
    @PostMapping("/signup/{email}")
    public ResponseEntity<UserResponse> signupUser(@Valid @RequestBody UserRequest.SignUp request){
        return new ResponseEntity<>(userService.signUp(request), HttpStatusCode.valueOf(200));
    }

    @Operation(summary = "닉네임 중복 체크", description = "DB 대조를 통한 닉네임 가능 여부 체크")
    @PostMapping("/check-nickname/{nickname}")
    public ResponseEntity<Void> checkNickname(@Valid @RequestBody UserRequest.CheckNickname request){
        boolean exists = userService.CheckNicknameExists(request);
        if(exists){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @Operation(summary = "로그인", description = "이메일로 로그인 시도")
    @PostMapping("/login/{email}")
    public ResponseEntity<UserResponse> login(@Valid @RequestBody UserRequest.login request){
        try{
            UserResponse response = userService.login(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch(UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

}

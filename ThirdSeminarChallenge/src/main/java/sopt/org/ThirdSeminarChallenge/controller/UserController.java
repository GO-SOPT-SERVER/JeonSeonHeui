package sopt.org.ThirdSeminarChallenge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sopt.org.ThirdSeminarChallenge.common.dto.ApiResponseDto;
import sopt.org.ThirdSeminarChallenge.controller.dto.request.UserRequestDto;
import sopt.org.ThirdSeminarChallenge.controller.dto.response.UserResponseDto;
import sopt.org.ThirdSeminarChallenge.exception.SuccessStatus;
import sopt.org.ThirdSeminarChallenge.service.UserService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody @Valid final UserRequestDto request) {
        return ApiResponseDto.success(SuccessStatus.SIGNUP_SUCCESS, userService.create(request));
    }
}

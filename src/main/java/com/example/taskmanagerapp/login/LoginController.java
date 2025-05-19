package com.example.taskmanagerapp.login;

import com.example.taskmanagerapp.entity.Author;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/login")
public class LoginController {
    private final LoginService loginService;
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping()
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletRequest httpServletRequest) throws AuthenticationException {

        Author author = loginService.login(loginRequestDto);
        //로그인 후 세션 없으면 생성, 있으면 세션 반환
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setAttribute("sessionKey", author.getId());
        return new ResponseEntity<>("로그인에 성공했습니다.",HttpStatus.OK);
    }
}

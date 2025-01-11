package com.ll.demo.service;


import com.ll.demo.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    public SiteUser authenticate(SiteUser siteUser) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            siteUser.getEmail(),
                            siteUser.getPassword()
                    )
//   password를 인코딩 없이 넘겨도 되는 이유는
//   UsernamePasswordAuthenticationToken이
//   AuthenticationManager를 거쳐 DaoAuthenticationProvider로
//   전달되며, 이때 DaoAuthenticationProvider가
//   자동으로 비밀번호를 인코딩하여 DB에 저장된 비밀번호와 비교하기 때문입니다.
            );
            return siteUser;
        } catch (Exception e) {
            throw new IllegalArgumentException("인증 실패");
        }
    }
}

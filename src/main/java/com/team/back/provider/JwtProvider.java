package com.team.back.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
    @Value("${secret-key}") //? todo : 이거 현직에선 어떤 방법을 쓰는지.
    private String secretKey;

    public String create(String employeeCode){

        
        // 토큰 만료 기간 : 8시간 //
        Date expiredDate = Date.from(Instant.now().plus(8, ChronoUnit.HOURS));

        // JWT 생성 //
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, secretKey)
                            .setSubject(employeeCode).setIssuedAt(new Date()).setExpiration(expiredDate).compact();

        return jwt;
    }

    public String validate(String jwt){
        Claims payload= null;
        try{
            // JWT 검증 //
            payload = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwt).getBody();

        }catch(Exception exception){
            exception.printStackTrace();
            return null;
        }

        String subject = payload.getSubject();
        return subject;
    }
}

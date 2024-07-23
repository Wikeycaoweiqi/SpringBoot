package com.wikeyspringboot.springboot03_demo01;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wikeyspringboot.springboot03_demo01.utils.JWTUtil;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-14 18:06
 * @Description:
 */
public class JwtTest {
    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "jack123456");
        String token = JWTUtil.generateToken(claims);
        System.out.println(token);
    }

    @Test
    public void testParse() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7ImlkIjoxLCJ1c2VybmFtZSI6ImphY2sxMjM0NTYifSwiZXhwIjoxNzIxNDY3NTAxfQ.H-wn8urKE37dSKUKgZNMzS_HS5vs1Kx7uYORGJvpEno";
        DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
        Claim user = decodedJWT.getClaims().get("user");
        System.out.println(user);
    }
}
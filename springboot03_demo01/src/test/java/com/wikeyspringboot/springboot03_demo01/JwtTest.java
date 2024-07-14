package com.wikeyspringboot.springboot03_demo01;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
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
        claims.put("userId", 1);
        claims.put("username", "wikey");
        String token = JWT.create().withClaim("user", claims).withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)).sign(Algorithm.HMAC256("wikey"));
        System.out.println(token);
    }

    @Test
    public void testParse() {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjp7InVzZXJJZCI6MSwidXNlcm5hbWUiOiJ3aWtleSJ9LCJleHAiOjE3MjA5OTUyNTd9.VJnmHgRpvZ3xJ2w96_xy7F6sAr0Pm4_zLn0FpED44Vs";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("wikey")).build();
        DecodedJWT decodedJWT = jwtVerifier.verify(token);
        Map<String, Claim> claims = decodedJWT.getClaims();
        Claim user = claims.get("user");
        System.out.println(user);
    }
}
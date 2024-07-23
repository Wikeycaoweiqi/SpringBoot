package com.wikeyspringboot.springboot03_demo01.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-14 18:18
 * @Description:
 */
public class JWTUtil {
    private static final String SECRET = "wikey"; // 密钥
    private static final long EXPIRE_TIME = 3600L; // JWT过期时间，单位为秒

    /**
     * 使用HS256算法生成JWT。
     *
     * @param claims 包含所有JWT声明的Map，如subject、issuer、expiration等。
     * @return 签名后的JWT字符串。
     */
    public static String generateToken(Map<String, Object> claims) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME * 1000);

        return JWT.create()
                .withClaim("user", claims)
                .withExpiresAt(expiresAt)
                .sign(algorithm);
    }

    /**
     * 验证JWT。
     *
     * @param token JWT字符串。
     * @return 解码后的JWT对象。
     * @throws JWTDecodeException 如果JWT格式不正确或签名验证失败。
     */
    public static DecodedJWT verifyToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        return JWT.require(algorithm).build().verify(token);
    }

    /**
     * 解码JWT（不验证签名）。
     *
     * @param token JWT字符串。
     * @return 解码后的JWT对象。
     */
    public static DecodedJWT decodeToken(String token) {
        try {
            return JWT.decode(token);
        } catch (JWTDecodeException e) {
            throw new RuntimeException("Invalid JWT token", e);
        }
    }
}
package com.wikeyspringboot.springboot03_demo01.interceptors;

import com.auth0.jwt.interfaces.Claim;
import com.wikeyspringboot.springboot03_demo01.utils.JWTUtil;
import com.wikeyspringboot.springboot03_demo01.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @author: wikey
 * @create: 2024-07-14 18:49
 * @Description:
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            Map<String, Claim> claims = JWTUtil.verifyToken(token).getClaims();
            Map<String, Object> userMap = claims.get("user").asMap();
            ThreadLocalUtil.set(userMap);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }
}
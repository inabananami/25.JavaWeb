package com.inabananami.japanesedemo.utils;

import com.inabananami.japanesedemo.vo.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    //密钥
    private static final String SECRET = "super_secret_key_1234567890_super_secret_key";
    private static final SecretKey KEY = Keys.hmacShaKeyFor(SECRET.getBytes());

    //过期时间: 1天
    private static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24;

    //生成Jwt
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(KEY, SignatureAlgorithm.HS256)
                .compact();
    }
//    解析JWT
    public static Claims parseToken(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new JwtException("JWT无效或已过期");
        }
    }
}

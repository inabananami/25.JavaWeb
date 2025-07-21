package com.itheima;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {

    @Test
    public void testGen() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("username", "张三");
        //生成jwt的代码
        String token = JWT.create()
                .withClaim("user", claims)   //添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*12))      //添加过期时间
                .sign(Algorithm.HMAC256("uehara_ayumu"));

        System.out.println(token);
    }

    @Test
    public void testParse() {
        //定义字符串，模拟用户传递过来的Token
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9" +
                                ".eyJ1c2VyIjp7ImlkIjoiMSIsInVzZXJuYW1lIjoi5byg5LiJIn0sImV4cCI6MTc1MzEyNjU1Nn0" +
                                ".-gvF0ZBLiXRi7YSQxeXJUFwwMZX-ESzjl_J8EYqmzww";
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256("uehara_ayumu")).build();

        DecodedJWT decodedJWT = jwtVerifier.verify(token);  //验证token，生成一个解析后的JWT对象
        Map<String, Claim> claims = decodedJWT.getClaims();
        System.out.println(claims.get("user"));

        //如果篡改了头部和载荷部分的数据，那么验证失败
        //如果密钥改了，验证失败
    }
}
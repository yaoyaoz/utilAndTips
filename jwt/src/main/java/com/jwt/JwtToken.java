package com.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: JwtToken
 * Description:
 * Date: 2020年08月07日
 *
 * @author yaoyao
 * @version 1.0.0
 * @since 1.8
 */
public class JwtToken {

    //加密
    public static String createToken() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("name", "xiaoming")//payload
                .withClaim("age", "18")
                .sign(Algorithm.HMAC256("secret"));//加密
        return token;
    }

    //验证
    public static void verifyToken(String token,String key) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key))
                .build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("name").asString());
    }

    @Test
    public void testCreateToken() throws Exception {
        System.out.println("token:" + createToken());
    }

    @Test
    public void testVerifyToken() throws Exception {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoieGlhb21pbmciLCJhZ2UiOiIxOCJ9.97hE9s9_QocivdBRvE8kCDtqqGUtyrqjOKNcdkBLNZo";
        verifyToken(token, "secret");
    }

}

package com.tom.lib;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.ImmutableMap;
import com.tom.example2.model.UserTokenDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * JWTUtil
 *
 * @author TomLuo
 * @date 2023年04月22日 16:33
 */
@Slf4j
public class JWTUtil {


    //私钥
    private static final String TOKEN_SECRET = "123456";

    /**
     * 生成token，自定义过期时间 毫秒
     *
     * @param userTokenDTO
     * @return
     */
    public static String generateToken(UserTokenDTO userTokenDTO) {
        try {
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = ImmutableMap.of("Type", "Jwt","alg", "HS256");

            return JWT.create()
                    .withHeader(header)
                    .withClaim("token", JSONObject.toJSONString(userTokenDTO))
                    //.withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error("generate token occur error, error is:{}", e);
            return null;
        }
    }

    /**
     * 检验token是否正确
     *
     * @param token
     * @return
     */
    public static UserTokenDTO parseToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        String tokenInfo = jwt.getClaim("token").asString();
        return JSON.parseObject(tokenInfo, UserTokenDTO.class);
    }
}
package com.xxxx.server.common.config.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JwtToken的工具类
 * 1、根据用户名生成token
 * 2、根据token获取用户名
 * 3、验证token是否失效
 *
 * @author : liuke
 * @date : 2022-07-14 17:00
 **/
@Component
public class JwtTokenUtill {

    // 定义荷载
    private static final String CLAIM_KEY_USERNAME = "sub";

    private static final String CLAIM_KEY_CREATED = "created";


    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;


    /**
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);

    }


    private String generateToken(Map<String, Object> claims) {

        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }


    public String getUseNameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
        }catch (Exception e) {
            username  = null;
        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims;
    }

    /**
     * 返回 true 未失效 ; false失效了
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateTokenIsExpiration(String token,UserDetails userDetails){
        String useNameFromToken = getUseNameFromToken(token);
        return useNameFromToken.equals(userDetails.getUsername()) && ! isTokenExpiration(token);
    }


    private boolean isTokenExpiration(String token) {
        Claims claims = getClaimsFromToken(token);
        Date expiration = claims.getExpiration();
        //如果 失效时间在当前时间之前就代表失效了
        return expiration.before(new Date());
    }



}

package org.example.jwtdemo;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 这边是手写的一个JWT的模版
public class JwtDemo {

    // 密钥，生产环境中应该妥善保管，不应该硬编码在代码中
    private static final String SECRET_KEY = "yourVeryLongAndSecureSecretKey1234567890abcdefghijklmnopqrstuvwxyz";
    // JWT的过期时间，这里设置为1小时
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

    /**
     * 生成JWT
     * @param subject 主题，可以是用户名或ID等
     * @param claims 自定义声明
     * @return JWT字符串
     */
    public static String generateToken(String subject, Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * 解析JWT
     * @param token JWT字符串
     * @return 解析后的Claims
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public static void main(String[] args) {
        // 创建自定义声明
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", "admin");
        claims.put("email", "example@example.com");

        // 生成JWT
        String token = generateToken("user123", claims);
        System.out.println("生成的JWT: " + token);

        // 解析JWT
        Claims claimsFromToken = parseToken(token);
        System.out.println("主题: " + claimsFromToken.getSubject());
        System.out.println("角色: " + claimsFromToken.get("role"));
        System.out.println("邮箱: " + claimsFromToken.get("email"));
        System.out.println("签发时间: " + claimsFromToken.getIssuedAt());
        System.out.println("过期时间: " + claimsFromToken.getExpiration());
    }
}    
package com.keller.im.core.auth;

import com.keller.im.core.constant.GlobalConstant;
import com.keller.im.core.enums.RoleEnums;
import com.keller.im.core.constant.GlobalConstant;
import com.keller.im.core.enums.RoleEnums;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 * JWT中主要存储用户ID和角色，签发JWT后，将用户信息存放在Redis中，各服务通过Redis获取用户信息
 * @author yangkaile
 * @date 2020-12-11 21:37:01
 */
@Slf4j
public class JwtUtil {

    /**
     * 用户角色
     */
    private static final String ROLE = "Role";

    /**
     * Token类型
     */
    private static final String TYPE = "Type";

    /**
     * 用户ID
     */
    private static final String USER_ID = "UserId";

    /**
     * 用户名
     */
    private static final String USER_NAME = "UserName";

    /**
     * 验证码，重置密码类型的Token中会带有验证码
     */
    private static final String CODE = "Code";

    public static String buildLoginToken(Long userId,String userName,RoleEnums role){
        long now=System.currentTimeMillis();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(UUID.randomUUID().toString())
                //设置应用名
                .setSubject(GlobalConstant.APPLICATION_NAME)
                //签发时间
                .setIssuedAt( new Date() )
                //过期时间
                .setExpiration( new Date( now + GlobalConstant.TOKEN_EXPIRATION_TIME) )
                //token类型：登录
                .claim(TYPE,JwtEnums.login.name())
                //设置角色
                .claim(ROLE,role.name())
                //设置用户ID
                .claim(USER_ID,userId)
                //设置用户名
                .claim(USER_NAME,userName)
                //签名 密钥
                .signWith(SignatureAlgorithm.HS256, GlobalConstant.TOKEN_SIGN_KEY);
        return jwtBuilder.compact();
    }

    /**
     * 解析登录Token
     * @param token
     * @return
     */
    public static JwtEntity readLoginToken(String token){
        JwtEntity entity = new JwtEntity();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(GlobalConstant.TOKEN_SIGN_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            String subject = claims.getSubject();
            //校验应用名
            if(!subject.equals(GlobalConstant.APPLICATION_NAME)){
                return null;
            }
            //校验 JWT 类型
            String type = claims.get(TYPE,String.class);
            if(!JwtEnums.login.name().equals(type)){
                return null;
            }
            entity.setType(type);
            entity.setUserId(claims.get(USER_ID,Long.class));
            entity.setUserName(claims.get(USER_NAME,String.class));
            entity.setRole(claims.get(ROLE,String.class));
            if(entity.getUserId() == null || entity.getRole() == null){
                return null;
            }
            return entity;

        }catch (Exception e){
            log.error("readLoginToken Token解析失败,{}",e.getMessage());
            return null;
        }
    }

    /**
     * 读取UserId
     * @param token
     * @return
     */
    public static Long readUserId(String token){
        JwtEntity entity = readLoginToken(token);
        if(entity == null || entity.getUserId() == null){
            return null;
        }
        return entity.getUserId();
    }


    public static void main(String[] args) {
        String token = buildLoginToken(1001L,"地瓜炖土豆",RoleEnums.Admin);
//String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJlZmY4OTllYy1iOWUwLTRhMDQtYWYxZi1mODU2ODZkM2MwZjQiLCJzdWIiOiJLZWxsZXJfSU0iLCJpYXQiOjE2MDc3OTQxOTEsImV4cCI6MTYwNzc5NDIzNCwiVHlwZSI6ImxvZ2luIiwiUm9sZSI6IkFkbWluIiwiVXNlcklkIjoxMDAxfQ.Tx4V6IhSvCLwNr-sUogXhKHuvF7VY9UVmFIqCKgeS60";
        System.out.println(token);

        JwtEntity entity = readLoginToken(token);
        System.out.println(entity);
    }

}


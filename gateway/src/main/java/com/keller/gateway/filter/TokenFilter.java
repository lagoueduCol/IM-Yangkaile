package com.keller.gateway.filter;

import com.keller.core.auth.JwtEntity;
import com.keller.core.auth.JwtUtil;
import com.keller.core.constant.RequestConstant;
import com.keller.core.enums.RequestHeaderEnums;
import com.keller.core.enums.RoleEnums;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 全局Token过滤器
 *
 * @author yangkaile
 * @date 2020-12-11 15:59:29
 */
@Slf4j
@Component
public class TokenFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //取出Header中的Token
        String token = exchange.getRequest().getHeaders().getFirst(RequestHeaderEnums.Token.name);

        ServerHttpRequest request = exchange.getRequest();

        log.info("当前请求的url:{}, method:{}", request.getURI().getPath(), request.getMethodValue());

        String prefix = getPrefixRequestPath(request);


        //无Token，只能访问开放接口
        if (Strings.isBlank(token)) {
            if (RequestConstant.OPEN_URL.equals(prefix)) {
                return chain.filter(exchange);
            }else {
                //TODO 记录异常请求（无Token访问需要鉴权的接口）
                log.error("TokenError: Empty...");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        }else {
            //有Token，先校验Token
            JwtEntity jwtEntity = JwtUtil.readLoginToken(token);
            //校验失败，非法访问，记录请求IP
            if (jwtEntity == null ){
                // TODO 记录异常请求（Token校验失败）
                log.error("TokenError: Empty...");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            //如果是管理员，允许访问所有接口
            else if(RoleEnums.Admin.name().equals(jwtEntity.getRole())){
                return chain.filter(exchange);
            }
            //如果是普通用户，允许访问除管理员接口之外的其他接口
            else if(RoleEnums.User.name().equals(jwtEntity.getRole())){
                if(RequestConstant.ADMIN_URL.equals(prefix)){
                    // TODO 记录异常请求（普通用户Token访问管理员接口）
                    log.error("TokenError: Access denied...");
                    exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                    return exchange.getResponse().setComplete();
                }else {
                    return chain.filter(exchange);
                }
            }else {
                //TODO 记录异常请求（Token被篡改）
                log.error("TokenError: Illegal...");
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
        }
    }

    @Override
    public int getOrder() {
        return -100;
    }

    /**
     * 获取请求路径的前缀
     * 请求路径结构为  /服务名/第一个RequestMapping[/]
     * "/"分割后，数组第一个是空字符串，第二个是服务名，第三个是请求前缀
     *
     * @param request
     * @return
     */
    private String getPrefixRequestPath(ServerHttpRequest request) {
        String path = request.getPath().toString();
        log.info("getFirstRequestMapping,path:{}", path);
        if (Strings.isBlank(path)) {
            return null;
        }
        //path结构为  /服务名/第一个RequestMapping[/]
        String[] paths = path.split("/");
        if (paths == null || paths.length < 3) {
            return null;
        }
        //只要不是免鉴权接口，都需要鉴权
        return paths[2];
    }

    public static void main(String[] args) {
        for (String s : "/User/open/login".split("/")) {

            System.out.println("==" + s);
        }
    }
}

package com.keller.im.message.websocket;


import com.keller.im.core.jwt.JwtUtil;
import com.keller.im.message.util.MessageBuilder;
import com.keller.im.core.constant.RequestConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * WebSocket服务
 *
 * @author yangkaile
 * @date 2021-01-21 11:30:26
 */
@ServerEndpoint("/" + RequestConstant.WEB_SOCKET_URL + "/{token}")
@Component
@Slf4j
public class WebSocketServer {
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static AtomicInteger onlineNum = new AtomicInteger();

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
     */
    private static ConcurrentHashMap<Long, Session> sessionPools = new ConcurrentHashMap<>();

    /**
     * 发送消息
     *
     * @param userId
     * @param message
     * @throws IOException
     */
    public Boolean sendMessage(Long userId, String message) {
        Session session = sessionPools.get(userId);
        if (session != null) {
            synchronized (session) {
                log.info("==sendMessage==userId:{},message:{}", userId, message);
                try {
                    session.getBasicRemote().sendText(message);
                    return true;
                } catch (IOException e) {
                    e.printStackTrace();
                    setOffline(userId);
                    return false;
                }
            }
        }

        log.warn("==sendMessage error 没有找到Session==userId,{}", userId);
        return false;

    }


    /**
     * 打开连接
     *
     * @param session
     * @param token
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("token") String token) {
        Long userId = JwtUtil.readUserId(token);
        if (userId == null) {
            log.warn("==onOpen userId null ==");
            return;
        }
        log.info("==onOpen session=={}", session.getId());
        setOnline(userId,session);
        System.out.println(userId + " 加入webSocket！当前人数为 " + onlineNum);
        sendMessage(userId, MessageBuilder.hello(userId));
    }

    /**
     * 关闭连接
     *
     * @param token
     */
    @OnClose
    public void onClose(@PathParam("token") String token) {
        Long userId = JwtUtil.readUserId(token);
        if (userId == null) {
            log.warn("==onClose userId null ==");
            return;
        }
        setOffline(userId);
        System.out.println(userId + " 断开webSocket连接！当前人数为 " + onlineNum);
    }

    /**
     * 收到用户消息
     *
     * @param message
     * @param session
     * @param token
     * @throws IOException
     */
    @OnMessage
    public void onMessage(String message, Session session, @PathParam("token") String token) throws IOException {
        log.info("==onMessage session:{},token:{},message:{}", session.getId(), token, message);
    }

    /**
     * 出错
     *
     * @param session
     * @param throwable
     */
    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void setOnline(Long userId,Session session) {
        sessionPools.put(userId, session);
        onlineNum.incrementAndGet();
    }

    public static void setOffline(Long userId) {
        sessionPools.remove(userId);
        onlineNum.decrementAndGet();
    }
}
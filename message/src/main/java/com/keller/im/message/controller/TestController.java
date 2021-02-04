package com.keller.im.message.controller;

import com.keller.im.core.constant.RequestConstant;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.message.websocket.WebSocketServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(RequestConstant.OPEN_URL)
public class TestController {
    @Resource
    private WebSocketServer webSocketServer;

    @GetMapping("/test")
    public ServiceResponse test(){
        try {
            webSocketServer.sendMessage(10010L,"你好");
            return ServiceResponse.success();
        }catch (Exception e){
            e.printStackTrace();
            return ServiceResponse.error(ServiceResponseEnum.CommonNoService);
        }

    }

}

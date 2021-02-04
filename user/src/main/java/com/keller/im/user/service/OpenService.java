package com.keller.im.user.service;

import com.keller.im.core.enums.UserActionTypeEnums;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.util.UserNameFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * RegisterInfoService
 *
 * @author yangkaile
 * @date 2020-12-25 10:55:58
 */
@Service
@Slf4j
public class OpenService {


    /**
     * 注册信息
     */
    @Resource
    private RegisterInfoService registerInfoService;

    /**
     * 邮件发送服务
     */
    @Resource
    private MailSenderService mailSenderService;

    /**
     * 查询用户名是否可被注册
     * @param userName
     * @return
     */
    public ServiceResponse checkRegister(String userName) {
        Boolean checkRegister = registerInfoService.getByKey(userName) == null;
        return ServiceResponse.success(checkRegister);
    }

    /**
     * 发送注册验证码
     * @param name
     * @return
     */
    public ServiceResponse sendRegisterCode(String name) {
        //发送邮件验证码
        if(UserNameFormatUtil.isMail(name)){
            mailSenderService.sendCode(UserActionTypeEnums.Register,name);
            return ServiceResponse.success();
        }
        //TODO 发送短信验证码
        return ServiceResponse.error(ServiceResponseEnum.CommonErrorParams);
    }
}

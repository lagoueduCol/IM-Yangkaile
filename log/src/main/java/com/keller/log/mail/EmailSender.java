package com.keller.log.mail;

import com.alibaba.fastjson.JSON;

import com.keller.core.constant.GlobalConstant;
import com.keller.core.enums.StatusEnums;
import com.keller.core.enums.UserActionTypeEnums;
import com.keller.core.po.log.MailSendLog;
import com.keller.core.util.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.Resource;

/**
 * 邮件发送工具类
 * @author yangkaile
 * @date 2021-01-28 14:02:31
 */
@Slf4j
public class EmailSender {

    /**
     * 邮件验证码标题
     */
    public static final String TITLE ="【From】" + GlobalConstant.APPLICATION_NAME;

    /**
     * 邮件验证码正文内容
     */
    public static final String RegisterBody =
            "验证码:%1$s，用于账号： %2$s 注册，泄露有风险。"
                    + GlobalConstant.EMAIL_CODE_EXPIRATION_TIME + "分钟内使用有效。";

    public static final String LoginBody =
            "验证码:%1$s，用于账号： %2$s 登录，泄露有风险。"
                    + GlobalConstant.EMAIL_CODE_EXPIRATION_TIME + "分钟内使用有效。";

    public static final String ResetPasswordBody =
            "验证码:%1$s，用于账号： %2$s 找回密码，泄露有风险。"
                    + GlobalConstant.EMAIL_CODE_EXPIRATION_TIME + "分钟内使用有效。";

    public static final String ResetPasswordLinkBody =
            "您好！我们已收到您的账号： %1$s 重置密码的申请，" +
                    "请点击链接重置密码： " + GlobalConstant.APPLICATION_URL +
                    "/ResetPassword/%2$s ，该链接使用一次后失效";


    @Resource
    private MailProperties mailProperties;
    @Resource
    private JavaMailSender javaMailSender;

    /**
     * 发送邮件验证码
     * 1.随机生成指定位数的验证码
     * 2.创建邮件实体类，设置收件人地址、邮件标题、邮件内容、验证码
     * 3.发送邮件并记录发送结果
     * 4.返回包含发送结果的邮件实体类
     * @param email 收件人邮箱
     * @return 邮件实体类EmailEntity
     */
    public boolean sendCode(UserActionTypeEnums type, String email){
        String code = RandomUtils.getAllCharString(GlobalConstant.EMAIL_CODE_LENGTH);
        MailSendLog mailSendLog = new MailSendLog();
        mailSendLog.setToMail(email);
        mailSendLog.setType(type.name());
        mailSendLog.setTitle(TITLE);
        String body;
        if(UserActionTypeEnums.Register.equals(type)){
            body = String.format(RegisterBody,code,email);
        }else if(UserActionTypeEnums.Login.equals(type)){
            body = String.format(LoginBody,code,email);
        }else if(UserActionTypeEnums.ResetPwd.equals(type)){
            body = String.format(ResetPasswordBody,code,email);
        }else {
            return false;
        }

        mailSendLog.setContent(body);
        mailSendLog.setCode(code);
        mailSendLog.setCodeStatus(StatusEnums.Available.name());
        boolean result = true;
        try {
            result = sendSimpleMail(mailSendLog.getToMail(),mailSendLog.getTitle(),mailSendLog.getContent());
        }catch (Exception e){
            result = false;
            log.error("send sendVerificationCode error :{}",e.getMessage());
            mailSendLog.setSendResult(e.getMessage());
            mailSendLog.setSendStatus(StatusEnums.Exception.name());
        }finally {

            return result;
        }
    }

    /**
     * 发送简单邮件
     * @param to    接收人
     * @param title 标题
     * @param content   内容
     * @return
     */
    public  boolean sendSimpleMail(String to,String title,String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        // 邮件发送来源
        simpleMailMessage.setFrom(mailProperties.getUsername());
        // 邮件发送目标
        simpleMailMessage.setTo(to);
        // 设置标题
        simpleMailMessage.setSubject(title);
        // 设置内容
        simpleMailMessage.setText(content);

        try {
            // 发送
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

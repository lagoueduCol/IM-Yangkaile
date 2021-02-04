package com.keller.im.user.controller;

import com.keller.im.core.constant.RequestConstant;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.util.UserNameFormatUtil;
import com.keller.im.user.service.OpenService;
import com.keller.im.user.vo.LoginVo;
import io.swagger.annotations.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 免鉴权接口：注册、登录、找回密码
 *
 * @author yangkaile
 * @date 2020-12-11 19:11:55
 */
@RestController
@Api(value = "open",tags = {"不需要登录就可以访问"})
@RequestMapping(RequestConstant.OPEN_URL)
public class OpenController {

    @Resource
    private OpenService service;

    /**
     * 查询用户名是否可注册
     * @param name 可以是邮箱、手机号、用户名
     * @return
     */
    @ApiOperation(value = "查询用户名是可注册",tags = {"注册"},notes = "如果可以注册,返回 true；否则，返回 false")
    @ApiImplicitParam(name="name",value="手机号、邮箱、用户名",required = true, dataType="string", paramType = "query",example="guyexing@foxmail.com")
    @GetMapping("/checkRegister")
    public ServiceResponse checkRegister(String name) {
        if(!StringUtils.hasText(name)){
            return ServiceResponse.NoParams();
        }
        if(UserNameFormatUtil.notAvailable(name)){
            return ServiceResponse.error(ServiceResponseEnum.UserUserNameNotAvailable);
        }
        return service.checkRegister(name);
    }

    /**
     * 发送注册验证码
     * @param name 可以是邮箱、手机号
     * @return
     */
    @ApiOperation(value = "发送注册验证码",tags = {"注册","验证码"},notes = "")
    @GetMapping("/sendRegisterCode")
    public ServiceResponse sendRegisterCode(String name) {
        if(!StringUtils.hasText(name)){
            return ServiceResponse.NoParams();
        }
        if(!UserNameFormatUtil.isMailOrPhoneNo(name)){
            return ServiceResponse.error(ServiceResponseEnum.CommonErrorParams);
        }

        return service.sendRegisterCode(name);
    }

    /**
     *  通过验证码注册
     * @param vo
     *  name,code
     * @return
     */
    @ApiOperation(value = "通过验证码注册",tags = {"注册","验证码"},notes = "")
    @PostMapping("/registerByCode")
    public ServiceResponse registerByCode(@RequestBody LoginVo vo) {
        return ServiceResponse.success();
    }

    /**
     * 发送登录验证码
     * @param name
     * @return
     */
    @ApiOperation(value = "发送登录验证码",tags = {"登录","验证码"},notes = "")
    @GetMapping("/sendLoginCode")
    public ServiceResponse sendLoginMail(String name) {
        return ServiceResponse.success();
    }

    /**
     * 通过验证码登录
     * @param vo
     *  name,code
     * @return
     */
    @ApiOperation(value = "通过验证码登录",tags = {"登录","验证码"},notes = "")
    @PostMapping("/loginByCode")
    public ServiceResponse loginByCode(@RequestBody LoginVo vo) {
        return ServiceResponse.success();
    }

    /**
     * 用户名密码登录
     * @param vo
     *  name,password
     * @return
     */
    @ApiOperation(value = "用户名密码登录",tags = {"登录","密码"},notes = "")
    @PostMapping("/loginByPwd")
    public ServiceResponse loginByPwd(@RequestBody LoginVo vo) {
        return ServiceResponse.success();
    }

    /**
     * 发送重置密码验证码
     * @param name
     * @return
     */
    @ApiOperation(value = "发送重置密码验证码",tags = {"密码","验证码"},notes = "")
    @GetMapping("/sendResetCode")
    public ServiceResponse sendResetCode(String name) {
        return ServiceResponse.success();
    }

    /**
     * 发送重置密码链接
     * @param name
     * @return
     */
    @ApiOperation(value = "发送重置密码链接",tags = {"密码","链接"},notes = "")
    @GetMapping("/sendResetLink")
    public ServiceResponse sendResetLink(String name) {
        return ServiceResponse.success();
    }

    /**
     * 通过验证码重置密码
     * @param vo
     *  name,code,password
     * @return
     */
    @ApiOperation(value = "通过验证码重置密码",tags = {"密码","验证码"},notes = "")
    @PostMapping("/resetByCode")
    public ServiceResponse resetByCode(@RequestBody LoginVo vo) {
        return ServiceResponse.success();
    }

    /**
     * 通过链接重置密码
     * @param vo
     *  name 邮箱、手机号
     *  code Md5串，对应邮件发送记录中的一条数据
     *  password Base64加密后的新密码
     * @return
     */
    @ApiOperation(value = "通过链接重置密码",tags = {"密码","链接"},notes = "")
    @PostMapping("/resetByLink")
    public ServiceResponse resetByLink(@RequestBody LoginVo vo) {
        return ServiceResponse.success();
    }
}

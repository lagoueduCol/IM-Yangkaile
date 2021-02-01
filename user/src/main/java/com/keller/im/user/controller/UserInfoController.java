package com.keller.im.user.controller;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.po.user.UserInfo;
import com.keller.im.user.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  UserInfoController
 * @author yangkaile
 * @date 2020-12-25 10:57:08
 */
@Slf4j
@RestController
@Api(value = "userInfo",tags = {"用户详情"})
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService service;

    /**
     * 保存数据
     * @param userInfo
     * @return
     */
    @PostMapping
    @ApiOperation(value = "保存用户详情",notes = "必填参数有***",tags = {"保存"},response = Integer.class)
    public ServiceResponse save(@RequestBody UserInfo userInfo){
        log.info("====== save userInfo====== {}",userInfo);
        return service.save(userInfo);
    }

    /**
     * 修改数据
     * @param userInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody UserInfo userInfo){
        log.info("====== update ====== {}",userInfo);
        return service.update(userInfo);
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public ServiceResponse getById(@PathVariable Long id){
        log.info("====== getById ====== {}",id);
        return service.getById(id);
    }

    /**
     * 查询列表
     * @param userInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(UserInfo userInfo){
        log.info("======queryListByPage ====== {}",userInfo);
        return service.queryListByPage(userInfo);
    }

    /**
     * 查询总数
     * @param userInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(UserInfo userInfo){
        log.info("======queryCount ====== {}",userInfo);
        return service.queryCount(userInfo);
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ServiceResponse deleteById(@PathVariable Long id){
        log.info("====== deleteById ======  {}",id);
        return service.delete(id);
    }
}

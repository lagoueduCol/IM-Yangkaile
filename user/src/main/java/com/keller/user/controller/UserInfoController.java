package com.keller.user.controller;

import com.keller.core.response.ServiceResponse;
import com.keller.core.po.user.UserInfo;
import com.keller.user.service.UserInfoService;
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

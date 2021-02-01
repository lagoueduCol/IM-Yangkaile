package com.keller.im.user.controller;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.po.user.RegisterInfo;
import com.keller.im.user.service.RegisterInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  RegisterInfoController
 * @author yangkaile
 * @date 2020-12-25 10:55:58
 */
@Slf4j
@RestController
@RequestMapping("/registerInfo")
public class RegisterInfoController {

    @Resource
    private RegisterInfoService service;

    /**
     * 保存数据
     * @param registerInfo
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody RegisterInfo registerInfo){
        log.info("====== save registerInfo====== {}",registerInfo);
        return service.save(registerInfo);
    }

    /**
     * 修改数据
     * @param registerInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody RegisterInfo registerInfo){
        log.info("====== update ====== {}",registerInfo);
        return service.update(registerInfo);
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
     * @param registerInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(RegisterInfo registerInfo){
        log.info("======queryListByPage ====== {}",registerInfo);
        return service.queryListByPage(registerInfo);
    }

    /**
     * 查询总数
     * @param registerInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(RegisterInfo registerInfo){
        log.info("======queryCount ====== {}",registerInfo);
        return service.queryCount(registerInfo);
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

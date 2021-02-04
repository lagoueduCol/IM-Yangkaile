package com.keller.im.log.controller;

import com.keller.im.core.po.log.LoginLog;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.log.service.LoginLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  LoginLogController
 * @author yangkaile
 * @date 2020-12-25 10:58:21
 */
@Slf4j
@RestController
@RequestMapping("/loginLog")
public class LoginLogController {

    @Resource
    private LoginLogService service;

    /**
     * 保存数据
     * @param loginLog
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody LoginLog loginLog){
        log.info("====== save loginLog====== {}",loginLog);
        return service.save(loginLog);
    }

    /**
     * 修改数据
     * @param loginLog
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody LoginLog loginLog){
        log.info("====== update ====== {}",loginLog);
        return service.update(loginLog);
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
     * @param loginLog
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(LoginLog loginLog){
        log.info("======queryListByPage ====== {}",loginLog);
        return service.queryListByPage(loginLog);
    }

    /**
     * 查询总数
     * @param loginLog
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(LoginLog loginLog){
        log.info("======queryCount ====== {}",loginLog);
        return service.queryCount(loginLog);
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

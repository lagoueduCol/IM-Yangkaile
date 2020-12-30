package com.keller.log.controller;

import com.keller.core.response.ServiceResponse;
import com.keller.core.po.log.RegisterLog;
import com.keller.log.service.RegisterLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  RegisterLogController
 * @author yangkaile
 * @date 2020-12-25 10:58:40
 */
@Slf4j
@RestController
@RequestMapping("/registerLog")
public class RegisterLogController {

    @Resource
    private RegisterLogService service;

    /**
     * 保存数据
     * @param registerLog
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody RegisterLog registerLog){
        log.info("====== save registerLog====== {}",registerLog);
        return service.save(registerLog);
    }

    /**
     * 修改数据
     * @param registerLog
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody RegisterLog registerLog){
        log.info("====== update ====== {}",registerLog);
        return service.update(registerLog);
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
     * @param registerLog
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(RegisterLog registerLog){
        log.info("======queryListByPage ====== {}",registerLog);
        return service.queryListByPage(registerLog);
    }

    /**
     * 查询总数
     * @param registerLog
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(RegisterLog registerLog){
        log.info("======queryCount ====== {}",registerLog);
        return service.queryCount(registerLog);
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

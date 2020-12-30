package com.keller.log.controller;

import com.keller.core.response.ServiceResponse;
import com.keller.core.po.log.SystemLog;
import com.keller.log.service.SystemLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  SystemLogController
 * @author yangkaile
 * @date 2020-12-25 10:59:11
 */
@Slf4j
@RestController
@RequestMapping("/systemLog")
public class SystemLogController {

    @Resource
    private SystemLogService service;

    /**
     * 保存数据
     * @param systemLog
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody SystemLog systemLog){
        log.info("====== save systemLog====== {}",systemLog);
        return service.save(systemLog);
    }

    /**
     * 修改数据
     * @param systemLog
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody SystemLog systemLog){
        log.info("====== update ====== {}",systemLog);
        return service.update(systemLog);
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
     * @param systemLog
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(SystemLog systemLog){
        log.info("======queryListByPage ====== {}",systemLog);
        return service.queryListByPage(systemLog);
    }

    /**
     * 查询总数
     * @param systemLog
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(SystemLog systemLog){
        log.info("======queryCount ====== {}",systemLog);
        return service.queryCount(systemLog);
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

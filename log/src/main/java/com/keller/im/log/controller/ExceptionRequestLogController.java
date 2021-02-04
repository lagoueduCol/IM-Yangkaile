package com.keller.im.log.controller;

import com.keller.im.core.po.log.ExceptionRequestLog;
import com.keller.im.log.service.ExceptionRequestLogService;
import com.keller.im.core.response.ServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  ExceptionRequestLogController
 * @author yangkaile
 * @date 2020-12-25 11:00:54
 */
@Slf4j
@RestController
@RequestMapping("/exceptionRequestLog")
public class ExceptionRequestLogController {

    @Resource
    private ExceptionRequestLogService service;

    /**
     * 保存数据
     * @param exceptionRequestLog
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody ExceptionRequestLog exceptionRequestLog){
        log.info("====== save exceptionRequestLog====== {}",exceptionRequestLog);
        return service.save(exceptionRequestLog);
    }

    /**
     * 修改数据
     * @param exceptionRequestLog
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody ExceptionRequestLog exceptionRequestLog){
        log.info("====== update ====== {}",exceptionRequestLog);
        return service.update(exceptionRequestLog);
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
     * @param exceptionRequestLog
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(ExceptionRequestLog exceptionRequestLog){
        log.info("======queryListByPage ====== {}",exceptionRequestLog);
        return service.queryListByPage(exceptionRequestLog);
    }

    /**
     * 查询总数
     * @param exceptionRequestLog
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(ExceptionRequestLog exceptionRequestLog){
        log.info("======queryCount ====== {}",exceptionRequestLog);
        return service.queryCount(exceptionRequestLog);
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

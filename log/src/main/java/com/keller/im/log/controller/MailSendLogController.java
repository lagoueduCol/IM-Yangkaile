package com.keller.im.log.controller;

import com.keller.im.core.po.log.MailSendLog;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.log.service.MailSendLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  MailSendLogController
 * @author yangkaile
 * @date 2020-12-25 10:59:33
 */
@Slf4j
@RestController
@RequestMapping("/mailSendLog")
public class MailSendLogController {

    @Resource
    private MailSendLogService service;

    /**
     * 保存数据
     * @param mailSendLog
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody MailSendLog mailSendLog){
        log.info("====== save mailSendLog====== {}",mailSendLog);
        return service.save(mailSendLog);
    }

    /**
     * 修改数据
     * @param mailSendLog
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody MailSendLog mailSendLog){
        log.info("====== update ====== {}",mailSendLog);
        return service.update(mailSendLog);
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
     * @param mailSendLog
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(MailSendLog mailSendLog){
        log.info("======queryListByPage ====== {}",mailSendLog);
        return service.queryListByPage(mailSendLog);
    }

    /**
     * 查询总数
     * @param mailSendLog
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(MailSendLog mailSendLog){
        log.info("======queryCount ====== {}",mailSendLog);
        return service.queryCount(mailSendLog);
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

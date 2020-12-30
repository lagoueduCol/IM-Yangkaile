package com.keller.message.controller;

import com.keller.core.response.ServiceResponse;
import com.keller.core.po.message.MessageInfo;
import com.keller.message.service.MessageInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  MessageInfoController
 * @author yangkaile
 * @date 2020-12-25 11:03:57
 */
@Slf4j
@RestController
@RequestMapping("/messageInfo")
public class MessageInfoController {

    @Resource
    private MessageInfoService service;

    /**
     * 保存数据
     * @param messageInfo
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody MessageInfo messageInfo){
        log.info("====== save messageInfo====== {}",messageInfo);
        return service.save(messageInfo);
    }

    /**
     * 修改数据
     * @param messageInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody MessageInfo messageInfo){
        log.info("====== update ====== {}",messageInfo);
        return service.update(messageInfo);
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
     * @param messageInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(MessageInfo messageInfo){
        log.info("======queryListByPage ====== {}",messageInfo);
        return service.queryListByPage(messageInfo);
    }

    /**
     * 查询总数
     * @param messageInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(MessageInfo messageInfo){
        log.info("======queryCount ====== {}",messageInfo);
        return service.queryCount(messageInfo);
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

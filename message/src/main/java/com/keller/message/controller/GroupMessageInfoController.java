package com.keller.message.controller;

import com.keller.core.response.ServiceResponse;
import com.keller.core.po.message.GroupMessageInfo;
import com.keller.message.service.GroupMessageInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  GroupMessageInfoController
 * @author yangkaile
 * @date 2020-12-25 11:04:15
 */
@Slf4j
@RestController
@RequestMapping("/groupMessageInfo")
public class GroupMessageInfoController {

    @Resource
    private GroupMessageInfoService service;

    /**
     * 保存数据
     * @param groupMessageInfo
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody GroupMessageInfo groupMessageInfo){
        log.info("====== save groupMessageInfo====== {}",groupMessageInfo);
        return service.save(groupMessageInfo);
    }

    /**
     * 修改数据
     * @param groupMessageInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody GroupMessageInfo groupMessageInfo){
        log.info("====== update ====== {}",groupMessageInfo);
        return service.update(groupMessageInfo);
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
     * @param groupMessageInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(GroupMessageInfo groupMessageInfo){
        log.info("======queryListByPage ====== {}",groupMessageInfo);
        return service.queryListByPage(groupMessageInfo);
    }

    /**
     * 查询总数
     * @param groupMessageInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(GroupMessageInfo groupMessageInfo){
        log.info("======queryCount ====== {}",groupMessageInfo);
        return service.queryCount(groupMessageInfo);
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

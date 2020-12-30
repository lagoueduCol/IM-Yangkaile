package com.keller.group.controller;

import com.keller.core.response.ServiceResponse;
import com.keller.core.po.group.GroupInfo;
import com.keller.group.service.GroupInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  GroupInfoController
 * @author yangkaile
 * @date 2020-12-25 11:02:00
 */
@Slf4j
@RestController
@RequestMapping("/groupInfo")
public class GroupInfoController {

    @Resource
    private GroupInfoService service;

    /**
     * 保存数据
     * @param groupInfo
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody GroupInfo groupInfo){
        log.info("====== save groupInfo====== {}",groupInfo);
        return service.save(groupInfo);
    }

    /**
     * 修改数据
     * @param groupInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody GroupInfo groupInfo){
        log.info("====== update ====== {}",groupInfo);
        return service.update(groupInfo);
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
     * @param groupInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(GroupInfo groupInfo){
        log.info("======queryListByPage ====== {}",groupInfo);
        return service.queryListByPage(groupInfo);
    }

    /**
     * 查询总数
     * @param groupInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(GroupInfo groupInfo){
        log.info("======queryCount ====== {}",groupInfo);
        return service.queryCount(groupInfo);
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

package com.keller.im.group.controller;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.po.group.GroupMemberInfo;
import com.keller.im.group.service.GroupMemberInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  GroupMemberInfoController
 * @author yangkaile
 * @date 2020-12-25 11:02:19
 */
@Slf4j
@RestController
@RequestMapping("/groupMemberInfo")
public class GroupMemberInfoController {

    @Resource
    private GroupMemberInfoService service;

    /**
     * 保存数据
     * @param groupMemberInfo
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody GroupMemberInfo groupMemberInfo){
        log.info("====== save groupMemberInfo====== {}",groupMemberInfo);
        return service.save(groupMemberInfo);
    }

    /**
     * 修改数据
     * @param groupMemberInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody GroupMemberInfo groupMemberInfo){
        log.info("====== update ====== {}",groupMemberInfo);
        return service.update(groupMemberInfo);
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
     * @param groupMemberInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(GroupMemberInfo groupMemberInfo){
        log.info("======queryListByPage ====== {}",groupMemberInfo);
        return service.queryListByPage(groupMemberInfo);
    }

    /**
     * 查询总数
     * @param groupMemberInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(GroupMemberInfo groupMemberInfo){
        log.info("======queryCount ====== {}",groupMemberInfo);
        return service.queryCount(groupMemberInfo);
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

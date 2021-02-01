package com.keller.im.friend.controller;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.po.friend.FriendRelation;
import com.keller.im.friend.service.FriendRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  FriendRelationController
 * @author yangkaile
 * @date 2020-12-25 11:03:02
 */
@Slf4j
@RestController
@RequestMapping("/friendRelation")
public class FriendRelationController {

    @Resource
    private FriendRelationService service;

    /**
     * 保存数据
     * @param friendRelation
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody FriendRelation friendRelation){
        log.info("====== save friendRelation====== {}",friendRelation);
        return service.save(friendRelation);
    }

    /**
     * 修改数据
     * @param friendRelation
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody FriendRelation friendRelation){
        log.info("====== update ====== {}",friendRelation);
        return service.update(friendRelation);
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
     * @param friendRelation
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(FriendRelation friendRelation){
        log.info("======queryListByPage ====== {}",friendRelation);
        return service.queryListByPage(friendRelation);
    }

    /**
     * 查询总数
     * @param friendRelation
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(FriendRelation friendRelation){
        log.info("======queryCount ====== {}",friendRelation);
        return service.queryCount(friendRelation);
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

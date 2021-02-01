package com.keller.im.message.controller;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.po.message.SystemMessageInfo;
import com.keller.im.message.service.SystemMessageInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  SystemMessageInfoController
 * @author yangkaile
 * @date 2020-12-25 11:04:49
 */
@Slf4j
@RestController
@RequestMapping("/systemMessageInfo")
public class SystemMessageInfoController {

    @Resource
    private SystemMessageInfoService service;

    /**
     * 保存数据
     * @param systemMessageInfo
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody SystemMessageInfo systemMessageInfo){
        log.info("====== save systemMessageInfo====== {}",systemMessageInfo);
        return service.save(systemMessageInfo);
    }

    /**
     * 修改数据
     * @param systemMessageInfo
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody SystemMessageInfo systemMessageInfo){
        log.info("====== update ====== {}",systemMessageInfo);
        return service.update(systemMessageInfo);
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
     * @param systemMessageInfo
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(SystemMessageInfo systemMessageInfo){
        log.info("======queryListByPage ====== {}",systemMessageInfo);
        return service.queryListByPage(systemMessageInfo);
    }

    /**
     * 查询总数
     * @param systemMessageInfo
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(SystemMessageInfo systemMessageInfo){
        log.info("======queryCount ====== {}",systemMessageInfo);
        return service.queryCount(systemMessageInfo);
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

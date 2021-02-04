package com.keller.im.log.controller;

import com.keller.im.core.po.log.FileUploadLog;
import com.keller.im.log.service.FileUploadLogService;
import com.keller.im.core.response.ServiceResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  FileUploadLogController
 * @author yangkaile
 * @date 2020-12-25 11:00:23
 */
@Slf4j
@RestController
@RequestMapping("/fileUploadLog")
public class FileUploadLogController {

    @Resource
    private FileUploadLogService service;

    /**
     * 保存数据
     * @param fileUploadLog
     * @return
     */
    @PostMapping
    public ServiceResponse save(@RequestBody FileUploadLog fileUploadLog){
        log.info("====== save fileUploadLog====== {}",fileUploadLog);
        return service.save(fileUploadLog);
    }

    /**
     * 修改数据
     * @param fileUploadLog
     * @return
     */
    @PutMapping
    public ServiceResponse update(@RequestBody FileUploadLog fileUploadLog){
        log.info("====== update ====== {}",fileUploadLog);
        return service.update(fileUploadLog);
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
     * @param fileUploadLog
     * @return
     */
    @GetMapping
    public ServiceResponse queryListByPage(FileUploadLog fileUploadLog){
        log.info("======queryListByPage ====== {}",fileUploadLog);
        return service.queryListByPage(fileUploadLog);
    }

    /**
     * 查询总数
     * @param fileUploadLog
     * @return
     */
    @GetMapping("/count")
    public ServiceResponse queryCount(FileUploadLog fileUploadLog){
        log.info("======queryCount ====== {}",fileUploadLog);
        return service.queryCount(fileUploadLog);
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

package com.keller.log.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.log.FileUploadLog;
import com.keller.log.mapper.FileUploadLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  FileUploadLogService
 * @author yangkaile
 * @date 2020-12-25 11:00:23
 */
@Service
@Slf4j
public class FileUploadLogService{


    @Resource
    private FileUploadLogMapper mapper;

    /**
     * 保存数据
     * @param fileUploadLog
     * @return
     */
    public ServiceResponse save(FileUploadLog fileUploadLog){
        Integer result = mapper.baseInsert(fileUploadLog);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param fileUploadLog
     * @return
     */
    public ServiceResponse update(FileUploadLog fileUploadLog){
        if(fileUploadLog.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(fileUploadLog);
        return ServiceResponse.success(result);
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    public ServiceResponse getById(Long id){
        if(id == null){
            return ServiceResponse.error(ServiceResponseEnum.NoParams);
        }
        FileUploadLog fileUploadLog = new FileUploadLog();
        fileUploadLog.setId(id);
        fileUploadLog = mapper.baseSelectById(fileUploadLog);
        return ServiceResponse.success(fileUploadLog);
    }

    /**
     * 查询列表，可指定查询条件
     * @param fileUploadLog
     * @return
     */
    public ServiceResponse queryListByPage(FileUploadLog fileUploadLog){
        List<FileUploadLog> list = mapper.baseSelectPageList(fileUploadLog);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param fileUploadLog
     * @return
     */
    public ServiceResponse queryCount(FileUploadLog fileUploadLog){
        Integer result = mapper.baseSelectCount(fileUploadLog);
        return ServiceResponse.success(result);
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    public ServiceResponse delete(Long id){
        if(id == null){
            return ServiceResponse.error(ServiceResponseEnum.NoParams);
        }
        FileUploadLog fileUploadLog = new FileUploadLog();
        fileUploadLog.setId(id);
        Integer result = mapper.baseDeleteById(fileUploadLog);
        return ServiceResponse.success(result);
    }

}

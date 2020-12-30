package com.keller.log.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.log.SystemLog;
import com.keller.log.mapper.SystemLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  SystemLogService
 * @author yangkaile
 * @date 2020-12-25 10:59:11
 */
@Service
@Slf4j
public class SystemLogService{


    @Resource
    private SystemLogMapper mapper;

    /**
     * 保存数据
     * @param systemLog
     * @return
     */
    public ServiceResponse save(SystemLog systemLog){
        Integer result = mapper.baseInsert(systemLog);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param systemLog
     * @return
     */
    public ServiceResponse update(SystemLog systemLog){
        if(systemLog.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(systemLog);
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
        SystemLog systemLog = new SystemLog();
        systemLog.setId(id);
        systemLog = mapper.baseSelectById(systemLog);
        return ServiceResponse.success(systemLog);
    }

    /**
     * 查询列表，可指定查询条件
     * @param systemLog
     * @return
     */
    public ServiceResponse queryListByPage(SystemLog systemLog){
        List<SystemLog> list = mapper.baseSelectPageList(systemLog);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param systemLog
     * @return
     */
    public ServiceResponse queryCount(SystemLog systemLog){
        Integer result = mapper.baseSelectCount(systemLog);
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
        SystemLog systemLog = new SystemLog();
        systemLog.setId(id);
        Integer result = mapper.baseDeleteById(systemLog);
        return ServiceResponse.success(result);
    }

}

package com.keller.im.log.service;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.po.log.ExceptionRequestLog;
import com.keller.im.core.mapper.log.ExceptionRequestLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  ExceptionRequestLogService
 * @author yangkaile
 * @date 2020-12-25 11:00:54
 */
@Service
@Slf4j
public class ExceptionRequestLogService{


    @Resource
    private ExceptionRequestLogMapper mapper;

    /**
     * 保存数据
     * @param exceptionRequestLog
     * @return
     */
    public ServiceResponse save(ExceptionRequestLog exceptionRequestLog){
        Integer result = mapper.baseInsert(exceptionRequestLog);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param exceptionRequestLog
     * @return
     */
    public ServiceResponse update(ExceptionRequestLog exceptionRequestLog){
        if(exceptionRequestLog.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.CommonNoId);
        }
        Integer result = mapper.baseUpdateById(exceptionRequestLog);
        return ServiceResponse.success(result);
    }

    /**
     * 查询数据
     * @param id
     * @return
     */
    public ServiceResponse getById(Long id){
        if(id == null){
            return ServiceResponse.error(ServiceResponseEnum.CommonNoParams);
        }
        ExceptionRequestLog exceptionRequestLog = new ExceptionRequestLog();
        exceptionRequestLog.setId(id);
        exceptionRequestLog = mapper.baseSelectById(exceptionRequestLog);
        return ServiceResponse.success(exceptionRequestLog);
    }

    /**
     * 查询列表，可指定查询条件
     * @param exceptionRequestLog
     * @return
     */
    public ServiceResponse queryListByPage(ExceptionRequestLog exceptionRequestLog){
        List<ExceptionRequestLog> list = mapper.baseSelectPageList(exceptionRequestLog);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param exceptionRequestLog
     * @return
     */
    public ServiceResponse queryCount(ExceptionRequestLog exceptionRequestLog){
        Integer result = mapper.baseSelectCount(exceptionRequestLog);
        return ServiceResponse.success(result);
    }

    /**
     * 删除数据
     * @param id
     * @return
     */
    public ServiceResponse delete(Long id){
        if(id == null){
            return ServiceResponse.error(ServiceResponseEnum.CommonNoParams);
        }
        ExceptionRequestLog exceptionRequestLog = new ExceptionRequestLog();
        exceptionRequestLog.setId(id);
        Integer result = mapper.baseDeleteById(exceptionRequestLog);
        return ServiceResponse.success(result);
    }

}

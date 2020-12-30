package com.keller.log.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.log.RegisterLog;
import com.keller.log.mapper.RegisterLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  RegisterLogService
 * @author yangkaile
 * @date 2020-12-25 10:58:40
 */
@Service
@Slf4j
public class RegisterLogService{


    @Resource
    private RegisterLogMapper mapper;

    /**
     * 保存数据
     * @param registerLog
     * @return
     */
    public ServiceResponse save(RegisterLog registerLog){
        Integer result = mapper.baseInsert(registerLog);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param registerLog
     * @return
     */
    public ServiceResponse update(RegisterLog registerLog){
        if(registerLog.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(registerLog);
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
        RegisterLog registerLog = new RegisterLog();
        registerLog.setId(id);
        registerLog = mapper.baseSelectById(registerLog);
        return ServiceResponse.success(registerLog);
    }

    /**
     * 查询列表，可指定查询条件
     * @param registerLog
     * @return
     */
    public ServiceResponse queryListByPage(RegisterLog registerLog){
        List<RegisterLog> list = mapper.baseSelectPageList(registerLog);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param registerLog
     * @return
     */
    public ServiceResponse queryCount(RegisterLog registerLog){
        Integer result = mapper.baseSelectCount(registerLog);
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
        RegisterLog registerLog = new RegisterLog();
        registerLog.setId(id);
        Integer result = mapper.baseDeleteById(registerLog);
        return ServiceResponse.success(result);
    }

}

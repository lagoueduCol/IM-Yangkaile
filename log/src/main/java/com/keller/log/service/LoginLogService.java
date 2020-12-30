package com.keller.log.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.log.LoginLog;
import com.keller.log.mapper.LoginLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  LoginLogService
 * @author yangkaile
 * @date 2020-12-25 10:58:21
 */
@Service
@Slf4j
public class LoginLogService{


    @Resource
    private LoginLogMapper mapper;

    /**
     * 保存数据
     * @param loginLog
     * @return
     */
    public ServiceResponse save(LoginLog loginLog){
        Integer result = mapper.baseInsert(loginLog);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param loginLog
     * @return
     */
    public ServiceResponse update(LoginLog loginLog){
        if(loginLog.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(loginLog);
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
        LoginLog loginLog = new LoginLog();
        loginLog.setId(id);
        loginLog = mapper.baseSelectById(loginLog);
        return ServiceResponse.success(loginLog);
    }

    /**
     * 查询列表，可指定查询条件
     * @param loginLog
     * @return
     */
    public ServiceResponse queryListByPage(LoginLog loginLog){
        List<LoginLog> list = mapper.baseSelectPageList(loginLog);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param loginLog
     * @return
     */
    public ServiceResponse queryCount(LoginLog loginLog){
        Integer result = mapper.baseSelectCount(loginLog);
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
        LoginLog loginLog = new LoginLog();
        loginLog.setId(id);
        Integer result = mapper.baseDeleteById(loginLog);
        return ServiceResponse.success(result);
    }

}

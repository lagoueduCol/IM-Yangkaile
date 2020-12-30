package com.keller.message.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.message.SystemMessageInfo;
import com.keller.message.mapper.SystemMessageInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  SystemMessageInfoService
 * @author yangkaile
 * @date 2020-12-25 11:04:49
 */
@Service
@Slf4j
public class SystemMessageInfoService{


    @Resource
    private SystemMessageInfoMapper mapper;

    /**
     * 保存数据
     * @param systemMessageInfo
     * @return
     */
    public ServiceResponse save(SystemMessageInfo systemMessageInfo){
        Integer result = mapper.baseInsert(systemMessageInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param systemMessageInfo
     * @return
     */
    public ServiceResponse update(SystemMessageInfo systemMessageInfo){
        if(systemMessageInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(systemMessageInfo);
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
        SystemMessageInfo systemMessageInfo = new SystemMessageInfo();
        systemMessageInfo.setId(id);
        systemMessageInfo = mapper.baseSelectById(systemMessageInfo);
        return ServiceResponse.success(systemMessageInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param systemMessageInfo
     * @return
     */
    public ServiceResponse queryListByPage(SystemMessageInfo systemMessageInfo){
        List<SystemMessageInfo> list = mapper.baseSelectPageList(systemMessageInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param systemMessageInfo
     * @return
     */
    public ServiceResponse queryCount(SystemMessageInfo systemMessageInfo){
        Integer result = mapper.baseSelectCount(systemMessageInfo);
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
        SystemMessageInfo systemMessageInfo = new SystemMessageInfo();
        systemMessageInfo.setId(id);
        Integer result = mapper.baseDeleteById(systemMessageInfo);
        return ServiceResponse.success(result);
    }

}

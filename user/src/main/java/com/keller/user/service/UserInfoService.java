package com.keller.user.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.user.UserInfo;
import com.keller.user.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  UserInfoService
 * @author yangkaile
 * @date 2020-12-25 10:57:08
 */
@Service
@Slf4j
public class UserInfoService{


    @Resource
    private UserInfoMapper mapper;

    /**
     * 保存数据
     * @param userInfo
     * @return
     */
    public ServiceResponse save(UserInfo userInfo){
        Integer result = mapper.baseInsert(userInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param userInfo
     * @return
     */
    public ServiceResponse update(UserInfo userInfo){
        if(userInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(userInfo);
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
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo = mapper.baseSelectById(userInfo);
        return ServiceResponse.success(userInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param userInfo
     * @return
     */
    public ServiceResponse queryListByPage(UserInfo userInfo){
        List<UserInfo> list = mapper.baseSelectPageList(userInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param userInfo
     * @return
     */
    public ServiceResponse queryCount(UserInfo userInfo){
        Integer result = mapper.baseSelectCount(userInfo);
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
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        Integer result = mapper.baseDeleteById(userInfo);
        return ServiceResponse.success(result);
    }

}

package com.keller.group.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.group.GroupInfo;
import com.keller.group.mapper.GroupInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  GroupInfoService
 * @author yangkaile
 * @date 2020-12-25 11:02:00
 */
@Service
@Slf4j
public class GroupInfoService{


    @Resource
    private GroupInfoMapper mapper;

    /**
     * 保存数据
     * @param groupInfo
     * @return
     */
    public ServiceResponse save(GroupInfo groupInfo){
        Integer result = mapper.baseInsert(groupInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param groupInfo
     * @return
     */
    public ServiceResponse update(GroupInfo groupInfo){
        if(groupInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(groupInfo);
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
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setId(id);
        groupInfo = mapper.baseSelectById(groupInfo);
        return ServiceResponse.success(groupInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param groupInfo
     * @return
     */
    public ServiceResponse queryListByPage(GroupInfo groupInfo){
        List<GroupInfo> list = mapper.baseSelectPageList(groupInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param groupInfo
     * @return
     */
    public ServiceResponse queryCount(GroupInfo groupInfo){
        Integer result = mapper.baseSelectCount(groupInfo);
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
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setId(id);
        Integer result = mapper.baseDeleteById(groupInfo);
        return ServiceResponse.success(result);
    }

}

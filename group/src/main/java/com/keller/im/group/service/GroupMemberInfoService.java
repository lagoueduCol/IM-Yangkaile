package com.keller.im.group.service;

import com.keller.im.core.mapper.group.GroupMemberInfoMapper;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.po.group.GroupMemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  GroupMemberInfoService
 * @author yangkaile
 * @date 2020-12-25 11:02:19
 */
@Service
@Slf4j
public class GroupMemberInfoService{


    @Resource
    private GroupMemberInfoMapper mapper;

    /**
     * 保存数据
     * @param groupMemberInfo
     * @return
     */
    public ServiceResponse save(GroupMemberInfo groupMemberInfo){
        Integer result = mapper.baseInsert(groupMemberInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param groupMemberInfo
     * @return
     */
    public ServiceResponse update(GroupMemberInfo groupMemberInfo){
        if(groupMemberInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.CommonNoId);
        }
        Integer result = mapper.baseUpdateById(groupMemberInfo);
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
        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
        groupMemberInfo.setId(id);
        groupMemberInfo = mapper.baseSelectById(groupMemberInfo);
        return ServiceResponse.success(groupMemberInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param groupMemberInfo
     * @return
     */
    public ServiceResponse queryListByPage(GroupMemberInfo groupMemberInfo){
        List<GroupMemberInfo> list = mapper.baseSelectPageList(groupMemberInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param groupMemberInfo
     * @return
     */
    public ServiceResponse queryCount(GroupMemberInfo groupMemberInfo){
        Integer result = mapper.baseSelectCount(groupMemberInfo);
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
        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
        groupMemberInfo.setId(id);
        Integer result = mapper.baseDeleteById(groupMemberInfo);
        return ServiceResponse.success(result);
    }

}

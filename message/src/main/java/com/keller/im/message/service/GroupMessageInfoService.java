package com.keller.im.message.service;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.po.message.GroupMessageInfo;
import com.keller.im.core.mapper.message.GroupMessageInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  GroupMessageInfoService
 * @author yangkaile
 * @date 2020-12-25 11:04:15
 */
@Service
@Slf4j
public class GroupMessageInfoService{


    @Resource
    private GroupMessageInfoMapper mapper;

    /**
     * 保存数据
     * @param groupMessageInfo
     * @return
     */
    public ServiceResponse save(GroupMessageInfo groupMessageInfo){
        Integer result = mapper.baseInsert(groupMessageInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param groupMessageInfo
     * @return
     */
    public ServiceResponse update(GroupMessageInfo groupMessageInfo){
        if(groupMessageInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.CommonNoId);
        }
        Integer result = mapper.baseUpdateById(groupMessageInfo);
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
        GroupMessageInfo groupMessageInfo = new GroupMessageInfo();
        groupMessageInfo.setId(id);
        groupMessageInfo = mapper.baseSelectById(groupMessageInfo);
        return ServiceResponse.success(groupMessageInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param groupMessageInfo
     * @return
     */
    public ServiceResponse queryListByPage(GroupMessageInfo groupMessageInfo){
        List<GroupMessageInfo> list = mapper.baseSelectPageList(groupMessageInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param groupMessageInfo
     * @return
     */
    public ServiceResponse queryCount(GroupMessageInfo groupMessageInfo){
        Integer result = mapper.baseSelectCount(groupMessageInfo);
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
        GroupMessageInfo groupMessageInfo = new GroupMessageInfo();
        groupMessageInfo.setId(id);
        Integer result = mapper.baseDeleteById(groupMessageInfo);
        return ServiceResponse.success(result);
    }

}

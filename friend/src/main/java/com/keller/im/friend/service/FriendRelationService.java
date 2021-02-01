package com.keller.im.friend.service;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.po.friend.FriendRelation;
import com.keller.im.core.mapper.friend.FriendRelationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  FriendRelationService
 * @author yangkaile
 * @date 2020-12-25 11:03:02
 */
@Service
@Slf4j
public class FriendRelationService{


    @Resource
    private FriendRelationMapper mapper;

    /**
     * 保存数据
     * @param friendRelation
     * @return
     */
    public ServiceResponse save(FriendRelation friendRelation){
        Integer result = mapper.baseInsert(friendRelation);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param friendRelation
     * @return
     */
    public ServiceResponse update(FriendRelation friendRelation){
        if(friendRelation.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(friendRelation);
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
        FriendRelation friendRelation = new FriendRelation();
        friendRelation.setId(id);
        friendRelation = mapper.baseSelectById(friendRelation);
        return ServiceResponse.success(friendRelation);
    }

    /**
     * 查询列表，可指定查询条件
     * @param friendRelation
     * @return
     */
    public ServiceResponse queryListByPage(FriendRelation friendRelation){
        List<FriendRelation> list = mapper.baseSelectPageList(friendRelation);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param friendRelation
     * @return
     */
    public ServiceResponse queryCount(FriendRelation friendRelation){
        Integer result = mapper.baseSelectCount(friendRelation);
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
        FriendRelation friendRelation = new FriendRelation();
        friendRelation.setId(id);
        Integer result = mapper.baseDeleteById(friendRelation);
        return ServiceResponse.success(result);
    }

}

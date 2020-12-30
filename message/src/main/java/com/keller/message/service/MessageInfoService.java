package com.keller.message.service;

import com.keller.core.response.ServiceResponse;
import com.keller.core.response.ServiceResponseEnum;
import com.keller.core.po.message.MessageInfo;
import com.keller.message.mapper.MessageInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  MessageInfoService
 * @author yangkaile
 * @date 2020-12-25 11:03:57
 */
@Service
@Slf4j
public class MessageInfoService{


    @Resource
    private MessageInfoMapper mapper;

    /**
     * 保存数据
     * @param messageInfo
     * @return
     */
    public ServiceResponse save(MessageInfo messageInfo){
        Integer result = mapper.baseInsert(messageInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param messageInfo
     * @return
     */
    public ServiceResponse update(MessageInfo messageInfo){
        if(messageInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(messageInfo);
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
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setId(id);
        messageInfo = mapper.baseSelectById(messageInfo);
        return ServiceResponse.success(messageInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param messageInfo
     * @return
     */
    public ServiceResponse queryListByPage(MessageInfo messageInfo){
        List<MessageInfo> list = mapper.baseSelectPageList(messageInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param messageInfo
     * @return
     */
    public ServiceResponse queryCount(MessageInfo messageInfo){
        Integer result = mapper.baseSelectCount(messageInfo);
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
        MessageInfo messageInfo = new MessageInfo();
        messageInfo.setId(id);
        Integer result = mapper.baseDeleteById(messageInfo);
        return ServiceResponse.success(result);
    }

}

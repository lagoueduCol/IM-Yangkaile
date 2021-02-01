package com.keller.im.log.service;

import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.po.log.MailSendLog;
import com.keller.im.core.mapper.log.MailSendLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  MailSendLogService
 * @author yangkaile
 * @date 2020-12-25 10:59:33
 */
@Service
@Slf4j
public class MailSendLogService{


    @Resource
    private MailSendLogMapper mapper;

    /**
     * 保存数据
     * @param mailSendLog
     * @return
     */
    public ServiceResponse save(MailSendLog mailSendLog){
        Integer result = mapper.baseInsert(mailSendLog);
        return ServiceResponse.success(result);
    }


    /**
     * 修改数据
     * @param mailSendLog
     * @return
     */
    public ServiceResponse update(MailSendLog mailSendLog){
        if(mailSendLog.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(mailSendLog);
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
        MailSendLog mailSendLog = new MailSendLog();
        mailSendLog.setId(id);
        mailSendLog = mapper.baseSelectById(mailSendLog);
        return ServiceResponse.success(mailSendLog);
    }

    /**
     * 查询列表，可指定查询条件
     * @param mailSendLog
     * @return
     */
    public ServiceResponse queryListByPage(MailSendLog mailSendLog){
        List<MailSendLog> list = mapper.baseSelectPageList(mailSendLog);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param mailSendLog
     * @return
     */
    public ServiceResponse queryCount(MailSendLog mailSendLog){
        Integer result = mapper.baseSelectCount(mailSendLog);
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
        MailSendLog mailSendLog = new MailSendLog();
        mailSendLog.setId(id);
        Integer result = mapper.baseDeleteById(mailSendLog);
        return ServiceResponse.success(result);
    }

}

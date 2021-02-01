package com.keller.im.user.service;

import com.keller.im.core.enums.UserNameTypeEnums;
import com.keller.im.core.response.ServiceResponse;
import com.keller.im.core.response.ServiceResponseEnum;
import com.keller.im.core.po.user.RegisterInfo;
import com.keller.im.core.util.StringFormatUtil;
import com.keller.im.core.mapper.user.RegisterInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  RegisterInfoService
 * @author yangkaile
 * @date 2020-12-25 10:55:58
 */
@Service
@Slf4j
public class RegisterInfoService{


    @Resource
    private RegisterInfoMapper mapper;

    /**
     * 保存数据
     * @param registerInfo
     * @return
     */
    public ServiceResponse save(RegisterInfo registerInfo){
        Integer result = mapper.baseInsert(registerInfo);
        return ServiceResponse.success(result);
    }


    /**
     * 查询用户，
     * @param userName 用户名、手机号、邮箱
     * @return
     */
    public RegisterInfo getByKey(String userName){

        UserNameTypeEnums type = StringFormatUtil.matchesUserNameType(userName);

        if(UserNameTypeEnums.UserName.equals(type)){
            return mapper.getByUserName(userName);
        }

        if(UserNameTypeEnums.Mail.equals(type)){
            return mapper.getByMail(userName);
        }

        if(UserNameTypeEnums.Phone.equals(userName)){
            return mapper.getByPhoneNo(userName);
        }

        return null;
    }


    /**
     * 修改数据
     * @param registerInfo
     * @return
     */
    public ServiceResponse update(RegisterInfo registerInfo){
        if(registerInfo.getId() == null){
                return ServiceResponse.error(ServiceResponseEnum.NoId);
        }
        Integer result = mapper.baseUpdateById(registerInfo);
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
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setId(id);
        registerInfo = mapper.baseSelectById(registerInfo);
        return ServiceResponse.success(registerInfo);
    }

    /**
     * 查询列表，可指定查询条件
     * @param registerInfo
     * @return
     */
    public ServiceResponse queryListByPage(RegisterInfo registerInfo){
        List<RegisterInfo> list = mapper.baseSelectPageList(registerInfo);
        return ServiceResponse.success(list);
    }

    /**
     * 查询总数，可指定查询条件
     * @param registerInfo
     * @return
     */
    public ServiceResponse queryCount(RegisterInfo registerInfo){
        Integer result = mapper.baseSelectCount(registerInfo);
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
        RegisterInfo registerInfo = new RegisterInfo();
        registerInfo.setId(id);
        Integer result = mapper.baseDeleteById(registerInfo);
        return ServiceResponse.success(result);
    }

}

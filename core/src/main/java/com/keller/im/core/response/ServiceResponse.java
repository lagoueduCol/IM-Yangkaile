package com.keller.im.core.response;

import lombok.Data;

/**
 * 业务返回值
 * @author yangkaile
 * @date 2020-12-24 10:15:31
 */
@Data
public class ServiceResponse{
    /**
     * 业务代码
     */
    private String code;
    /**
     * 业务说明
     */
    private String message;
    /**
     * 业务数据
     */
    private Object data;



    public static ServiceResponse NoParams(){
        return error(ServiceResponseEnum.NoParams);
    }


    public static ServiceResponse error(ServiceResponseEnum response){
        return new ServiceResponse (response);
    }

    public static ServiceResponse success(){
        ServiceResponse result = new ServiceResponse(ServiceResponseEnum.Success);
        return result;
    }

    public static ServiceResponse success(Object data){
        ServiceResponse result = new ServiceResponse(ServiceResponseEnum.Success);
        result.setData(data);
        return result;
    }

    private ServiceResponse(ServiceResponseEnum response) {
        this.code = response.code;
        this.message = response.message;
    }
}

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

    /**
     * 缺少请求参数的应答
     * @return
     */
    public static ServiceResponse NoParams(){
        return error(ServiceResponseEnum.CommonNoParams);
    }

    /**
     * 找不到服务的应答
     * @return
     */
    public static ServiceResponse NoService(){
        return error(ServiceResponseEnum.CommonNoService);
    }


    /**
     * 错误应答
     * @param response
     * @return
     */
    public static ServiceResponse error(ServiceResponseEnum response){
        return new ServiceResponse (response);
    }

    /**
     * 成功应答，无返回参数
     * @return
     */
    public static ServiceResponse success(){
        ServiceResponse result = new ServiceResponse(ServiceResponseEnum.Success);
        return result;
    }

    /**
     * 成功应答，有返回参数
     * @param data
     * @return
     */
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

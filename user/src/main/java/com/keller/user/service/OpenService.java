package com.keller.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *  RegisterInfoService
 * @author yangkaile
 * @date 2020-12-25 10:55:58
 */
@Service
@Slf4j
public class OpenService {


    @Resource
    private RegisterInfoService registerInfoService;

   public Boolean checkRegister(String userName){
       return registerInfoService.getByKey(userName) == null;
   }

}

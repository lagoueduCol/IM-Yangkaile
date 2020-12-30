package com.keller.user;

import com.keller.core.util.Console;
import com.keller.user.mapper.RegisterInfoMapper;
import com.keller.core.po.user.RegisterInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
class BaseMapperTests {

    @Resource
    private RegisterInfoMapper registerInfoMapper;

    @Test
    void contextLoads() {
    }

    @Test
    void baseInsert(){
        RegisterInfo entity = new RegisterInfo();
        entity.setId(2L);
        entity.setUserName("abc");
        entity.setRegisterTime(System.currentTimeMillis());
        Integer result = registerInfoMapper.baseInsert(entity);
        log.info("result: {}",result);
    }

    @Test
    void baseInsertAndReturnKey(){
        RegisterInfo entity = new RegisterInfo();
        entity.setUserName("yang001");
        entity.setRegisterTime(System.currentTimeMillis());
        Integer result = registerInfoMapper.baseInsertAndReturnKey(entity);
        log.info("result: {}",result);
        log.info("RegisterInfo:{}",entity);
    }

    @Test
    void baseDeleteById(){
        RegisterInfo entity = new RegisterInfo();
        entity.setId(1L);
        Integer result = registerInfoMapper.baseDeleteById(entity);
        log.info("result: {}",result);
    }

    @Test
    void baseDeleteByCondition(){
        RegisterInfo entity = new RegisterInfo();
        entity.setUserName("abc");
        Integer result = registerInfoMapper.baseDeleteByCondition(entity);
        log.info("result:{}",result);
    }

    @Test
    void baseUpdateById(){
        RegisterInfo entity = new RegisterInfo();
        entity.setId(3L);
        entity.setUserName("杨先生");
        Integer result = registerInfoMapper.baseUpdateById(entity);
        Console.info("result",result);
        baseSelectList();
    }

    @Test
    void baseSelectById(){
        RegisterInfo entity = new RegisterInfo();
        entity.setId(3L);
        entity = registerInfoMapper.baseSelectById(entity);
        Console.info("entity",entity);
    }

    @Test
    void baseSelectByCondition(){
        RegisterInfo entity = new RegisterInfo();
        entity.setUserName("yang001");
        entity.setBaseCondition(RegisterInfoMapper.selectByUserName);
        List<RegisterInfo> list = registerInfoMapper.baseSelectByCondition(entity);
        for (RegisterInfo info : list) {
            Console.println("info",info);
        }
    }

    @Test
    void baseSelectList(){
        RegisterInfo entity = new RegisterInfo();
        List<RegisterInfo> list = registerInfoMapper.baseSelectList(entity);
        for (RegisterInfo info : list) {
            Console.println("info",info);
        }
    }

    @Test
    void baseSelectCount(){
        RegisterInfo entity = new RegisterInfo();
        entity.setMail("mail001");
        Integer count = registerInfoMapper.baseSelectCount(entity);
        log.info("count : {}",count);
    }

    @Test
    void baseSelectPageList(){
        RegisterInfo entity = new RegisterInfo();
        entity.setMail("mail001");
        List<RegisterInfo> list = registerInfoMapper.baseSelectPageList(entity);
        for (RegisterInfo info : list) {
            Console.println("info",info);
        }
    }

}

package com.keller.generator;

import com.keller.generator.beetl.service.TableService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class GeneratorApplicationTests {

    @Test
    void contextLoads() {
    }

    @Resource
    private TableService service;

    @Test
    public void showTable(){
        System.out.println("======");
        service.getTableList("import_export_task_info");
        System.out.println("======");

    }

    @Test
    public void showTemplate(){
        System.out.println(service.initTemplate());

    }

    @Test
    public void createPO(){
        service.createPO(service.initTemplate());
    }

    @Test
    public void createMapper(){
        service.createMapper(service.initTemplate());
    }

    @Test
    public void createService(){
        service.createService(service.initTemplate());
    }

    @Test
    public void createController(){
        service.createController(service.initTemplate());
    }

    @Test
    public void createAll(){
        service.createAll();
    }

}

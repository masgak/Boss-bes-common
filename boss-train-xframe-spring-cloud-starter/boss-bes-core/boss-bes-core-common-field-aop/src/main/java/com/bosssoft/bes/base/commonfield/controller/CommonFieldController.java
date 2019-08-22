package com.bosssoft.bes.base.commonfield.controller;

import com.bosssoft.bes.base.commonfield.entity.CommonFieldTest;
import com.bosssoft.bes.base.commonfield.service.ServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonFieldController {
    private final ServiceTest serviceTest;

    @Autowired
    public CommonFieldController(ServiceTest serviceTest) {
        this.serviceTest = serviceTest;
    }

    @RequestMapping("/insert")
    public void insert(){

        try {
            serviceTest.insert(new CommonFieldTest());
        }catch (Exception e){
            System.out.println("抛出到了controller层");
            e.printStackTrace();
        }
    }

    @RequestMapping("/update")
    public void update(){
        serviceTest.update(new CommonFieldTest());
    }

    @RequestMapping("delete")
    public void delete(){
        serviceTest.delete(new CommonFieldTest());
    }

    @RequestMapping("query")
    public void query(){
        serviceTest.query(new CommonFieldTest());
    }
}

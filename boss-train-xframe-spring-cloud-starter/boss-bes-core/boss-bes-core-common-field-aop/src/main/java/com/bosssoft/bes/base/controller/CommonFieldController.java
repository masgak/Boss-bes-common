package com.bosssoft.bes.base.controller;

import com.bosssoft.bes.base.entity.CommonFieldTest;
import com.bosssoft.bes.base.service.ServiceTest;
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
        serviceTest.insert(new CommonFieldTest());
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

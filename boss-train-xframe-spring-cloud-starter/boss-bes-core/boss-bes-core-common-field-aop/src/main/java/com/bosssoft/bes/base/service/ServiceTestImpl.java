package com.bosssoft.bes.base.service;

import com.bosssoft.bes.base.aspect.CommonFieldAspect;
import com.bosssoft.bes.base.annotation.SetCommonField;
import com.bosssoft.bes.base.entity.CommonFieldTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ServiceTestImpl implements ServiceTest{
    Logger logger = LoggerFactory.getLogger("CommonFieldAopTest");

    @SetCommonField(methodType = CommonFieldAspect.TYPE_INSERT)
    @Override
    public void insert(CommonFieldTest commonFieldTest) {
        logger.info(commonFieldTest.toString());
    }

    @SetCommonField(methodType = CommonFieldAspect.TYPE_UPDATE)
    @Override
    public void update(CommonFieldTest commonFieldTest) {
        logger.info(commonFieldTest.toString());
    }

    @SetCommonField(methodType = CommonFieldAspect.TYPE_DELETE)
    @Override
    public void delete(CommonFieldTest commonFieldTest) {
        logger.info(commonFieldTest.toString());
    }

    @SetCommonField(methodType = CommonFieldAspect.TYPE_QUERY)
    @Override
    public void query(CommonFieldTest commonFieldTest) {
        logger.info(commonFieldTest.toString());
    }
}

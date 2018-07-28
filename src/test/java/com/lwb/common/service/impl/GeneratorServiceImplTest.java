package com.lwb.common.service.impl;

import com.alibaba.druid.support.http.StatViewServlet;
import com.lwb.common.service.GeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneratorServiceImplTest {

    @Autowired
    GeneratorService generatorService;

    @Test
    public void generatorCode() throws Exception {
        String[] tableNames = new String[]{"sys_user"}; //要生成的表
        //包名
        String packageName = "com.lwb.system";
        //作者
        String author = "lwb";
        //邮箱信息
        String email = "lwbldy@163.com";
        //自动去除表前缀，默认是 true
        boolean autoRemovePre = true;
        //表前缀(类名不会包含表前缀)
        String tablePrefix = "sys_";
        String outputDir = "D:\\codeGen";
        generatorService.generatorCode(tableNames, packageName, author, email,
                autoRemovePre,tablePrefix,outputDir);

    }

}
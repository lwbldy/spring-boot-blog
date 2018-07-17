package com.lwb.common.service.impl;

import com.lwb.common.dao.GeneratorMapper;
import com.lwb.common.service.GeneratorService;
import com.lwb.common.util.GenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    @Autowired
    GeneratorMapper generatorMapper;


    @Override
    public List<Map<String, Object>> list() {
        List<Map<String, Object>> list = generatorMapper.list();
        return list;
    }

    @Override
    public byte[] generatorCode(String[] tableNames,
                                String packageName,
                                String author, String email,
                                boolean autoRemovePre, String tablePrefix,
                                String outputDir) {

        for(String tableName : tableNames){
            //查询表信息
            Map<String, String> table = generatorMapper.get(tableName);
            //查询列信息
            List<Map<String, String>> columns = generatorMapper.listColumns(tableName);
            //生成代码
            GenUtils.generatorCode(table, columns,packageName,
                    author,email,autoRemovePre,tablePrefix,outputDir);
        }

        return new byte[0];
    }
}

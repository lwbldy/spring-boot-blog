package com.lwb.common.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 代码自动生成
 */
public interface GeneratorService {
    List<Map<String, Object>> list();

    /**
     * 自动生成代码
     * @param tableNames 表名
     * @param packageName 包名
     * @param author 作者
     * @param email 邮箱
     * @param autoRemovePre 自动去除前缀
     * @param tablePrefix 表前缀
     * @param outputDir 输出到哪里
     * @return
     */
    byte[] generatorCode(String[] tableNames,
                         String packageName,
                         String author, String email,
                         boolean autoRemovePre, String tablePrefix,
                         String outputDir
    );
}

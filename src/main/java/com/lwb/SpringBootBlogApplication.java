package com.lwb;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import javax.sql.DataSource;


@SpringBootApplication
//开启缓存注解
@EnableCaching
@ServletComponentScan
//@ServletComponentScan(value = "com.lwb.common")
@ImportResource(locations = { "classpath:druid-bean.xml" })
public class SpringBootBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBlogApplication.class, args);
	}

}

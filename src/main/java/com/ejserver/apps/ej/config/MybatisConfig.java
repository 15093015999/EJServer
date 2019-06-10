package com.ejserver.apps.ej.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ejserver.apps.ej.dao")
public class MybatisConfig {

}

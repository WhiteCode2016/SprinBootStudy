package com.white.config;

import org.springframework.context.annotation.Configuration;

/**
 * 事务配置
 * 关于事务管理器，不管是JPA还是JDBC等都实现自接口 PlatformTransactionManager
 * 如果你添加的是 spring-boot-starter-jdbc 依赖，框架会默认注入 DataSourceTransactionManager 实例。
 * 如果你添加的是 spring-boot-starter-data-jpa 依赖，框架会默认注入 JpaTransactionManager 实例。
 *
 * @author: White
 * @date: 2018/6/1
 */
@Configuration
public class TransactionConfig {
}

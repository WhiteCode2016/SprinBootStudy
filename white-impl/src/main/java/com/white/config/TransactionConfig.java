package com.white.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;
import java.util.Properties;

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
    private static final Logger logger = LoggerFactory.getLogger(TransactionConfig.class);

   /* @Bean(name = "platformTransactionInterceptor")
    public TransactionInterceptor PlatformTransactionInterceptor(PlatformTransactionManager platformTransactionManager) {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        transactionInterceptor.setTransactionManager(platformTransactionManager);
        Properties props = new Properties();
        props.setProperty("insert*", "PROPAGATION_REQUIRED,-Throwable");
        props.setProperty("save*", "PROPAGATION_REQUIRED,-Exception");
        props.setProperty("update*", "PROPAGATION_REQUIRED,-Throwable");
        props.setProperty("delete*", "PROPAGATION_REQUIRED,-Throwable");
        props.setProperty("select*", "PROPAGATION_REQUIRED,-Throwable");
        transactionInterceptor.setTransactionAttributes(props);
        return transactionInterceptor;
    }

    @Bean
    public BeanNameAutoProxyCreator transactionAutoProxy() {
        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
        transactionAutoProxy.setProxyTargetClass(true);
        transactionAutoProxy.setBeanNames("*Service","*ServiceImpl");
        transactionAutoProxy.setInterceptorNames("platformTransactionInterceptor");
        return transactionAutoProxy;
    }*/

    private static final String CUSTOMIZE_TRANSACTION_INTERCEPTOR_NAME = "customizeTransactionInterceptor";

    // 默认的只读事务
    private static final String[] DEFAULT_READY_ONLY_METHOD_RULE_TRANSACTION_ATTRIBUTES = {
            "get*", "count*", "find*", "query*", "*"
    };

    // 默认的可传播事务
    private static final String[] DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES  = {
            "add*", "save*", "insert*", "delete*", "update*", "edit*", "batch*", "create*", "remove*"
    };

    // 默认只对 "*Service"、"*ServiceImpl" Bean进行事务管理
    private static final String[] DEFAULT_TRANSACTION_BEAN_NAMES = {"*Service", "*ServiceImpl"};

    @Bean(CUSTOMIZE_TRANSACTION_INTERCEPTOR_NAME)
    public TransactionInterceptor customizeTransactionInterceptor (PlatformTransactionManager platformTransactionManager) {
        NameMatchTransactionAttributeSource transactionAttributeSource = new NameMatchTransactionAttributeSource();
        RuleBasedTransactionAttribute readOnly = this.readOnlyTransactionRule();
        RuleBasedTransactionAttribute required = this.requiredTransactionRule();
        // 默认的只读事务配置
        for (String methodName : DEFAULT_READY_ONLY_METHOD_RULE_TRANSACTION_ATTRIBUTES) {
            transactionAttributeSource.addTransactionalMethod(methodName, readOnly);
        }
        // 默认的可传播事务配置
        for (String methodName : DEFAULT_REQUIRED_METHOD_RULE_TRANSACTION_ATTRIBUTES) {
            transactionAttributeSource.addTransactionalMethod(methodName, required);
        }
        return new TransactionInterceptor(platformTransactionManager, transactionAttributeSource);
    }

    @Bean
    public BeanNameAutoProxyCreator customizeTransactionBeanNameAutoProxyCreator () {
        BeanNameAutoProxyCreator transactionAutoProxy = new BeanNameAutoProxyCreator();
        // 设置定制的事务拦截器
        transactionAutoProxy.setInterceptorNames(CUSTOMIZE_TRANSACTION_INTERCEPTOR_NAME);
        // 默认
        for (String defaultTransactionBeanNameSuffix : DEFAULT_TRANSACTION_BEAN_NAMES) {
            transactionAutoProxy.setBeanNames(defaultTransactionBeanNameSuffix);
        }
        transactionAutoProxy.setProxyTargetClass(true);
        return transactionAutoProxy;
    }

    /**
     * 只读事务
     * @return
     */
    private RuleBasedTransactionAttribute readOnlyTransactionRule() {
        RuleBasedTransactionAttribute readOnly = new RuleBasedTransactionAttribute();
        readOnly.setReadOnly(true);
        readOnly.setPropagationBehavior(TransactionDefinition.PROPAGATION_NOT_SUPPORTED);
        return readOnly;
    }

    /**
     * 支持当前事务;如果不存在创建一个新的
     * @return
     */
    private RuleBasedTransactionAttribute requiredTransactionRule() {
        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        required.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        required.setTimeout(TransactionDefinition.TIMEOUT_DEFAULT);
        return required;
    }
}

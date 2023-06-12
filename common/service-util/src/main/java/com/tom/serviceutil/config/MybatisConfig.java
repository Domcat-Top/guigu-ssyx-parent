package com.tom.serviceutil.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Tom
 * @date: 2023/6/9 10:00
 * @description: mybatisPlus的配置类
 */
@Configuration
// 扫描 com.tom.业务包.mapper包
@MapperScan("com.tom.*.mapper")
public class MybatisConfig {

    /**
     * 新的分页插件，一级缓存和二级缓存遵循了Mybatis的规则
     * 需要设置MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor optimisticLockerInnerInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //向Mybatis过滤器链中添加分页拦截器
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    // 这个消费者都过时了，感觉可以有可无的样子
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}

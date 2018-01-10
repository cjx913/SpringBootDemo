package com.cjx913.springbootdemo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(basePackages = "com.cjx913.springbootdemo.repositories")
public class JpaConfiguration {
    //DataSource
    @Bean//告诉Spring框架方法返回值需要注册成Spring的bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/MOVIE?characterEncoding=utf8&useSSL=false");
        dataSource.setUsername("cjx913");
        dataSource.setPassword("cjx913");

        return dataSource;
    }

    //LOcalContainerEntityManagerFactoryBean
    /**
     * 管理EntityManager类对象，用于后续的CRUD操作
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan("com.cjx913.springbootdemo.entity");
        entityManagerFactoryBean.setJpaProperties(buildHibernateProperties());//设置jpa接口实现的厂商，一般用Hibernate
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter(){
            @Override
            public void setDatabase(Database database) {
                super.setDatabase(Database.MYSQL);
            }
        });
        return entityManagerFactoryBean;
    }

    /**
     * 针对Hibernate的配置
     * @return hibernateProperties Hibernate的配置对象
     */
    protected Properties buildHibernateProperties(){
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
        hibernateProperties.setProperty("hibernate.show_sql","true");
        hibernateProperties.setProperty("hibernate.format_sql","true");
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto","update");

        return hibernateProperties;
    }

    //事务管理器
    @Bean
    public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager();
    }

    /**
     * 看到Spring的异常体系，而不是底层的Hibernate的异常
     * @return
     */
    @Bean
    PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * 用于操作具体的sql语句
     * @return
     */
    @Bean
    public TransactionTemplate transactionTemplate(){
        return new TransactionTemplate(transactionManager());
    }
}

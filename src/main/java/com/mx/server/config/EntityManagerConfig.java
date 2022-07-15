/*
package com.mx.server.config;


import com.mx.server.util.EntityManagerUtil;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;


@SpringBootConfiguration
public class EntityManagerConfig {

    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DataSource dataSource() {
        return new HikariDataSource();
    }

    */
/**
     * 这一段没有用,直接装在entityManagerFactory就行了
     * @return
     *//*

    @Bean
    public LocalContainerEntityManagerFactoryBean exampleEntityManager()  {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        vendorAdapter.setShowSql(true);
        vendorAdapter.setDatabase(Database.valueOf("POSTGRESQL"));
        vendorAdapter.setGenerateDdl(false);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        // 更改为对应包名，包括 repository 及 pojo ，建议放到同级不同子目录
        factory.setPackagesToScan("com.royalnu.csis.ms.example.provider");
        factory.setDataSource(dataSource());
        factory.setJpaProperties(jpaProperties());
        return factory;
    }

    @Bean
    public Properties jpaProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        return properties;
    }

    @Bean
    public PlatformTransactionManager exampleTransactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();

    txManager.setEntityManagerFactory(EntityManagerUtil.getInstance().getEntityManagerFactory());
        return txManager;
    }

    @Bean
    @Primary
    public EntityManagerFactory entityManagerFactory(){
        EntityManagerFactory entityManagerFactory = EntityManagerUtil.getInstance().getEntityManagerFactory();
        return entityManagerFactory;
    }

}
*/

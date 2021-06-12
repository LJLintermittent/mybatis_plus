package com.learn.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/9/3 18:21<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MBGTest {

    @Test
    public void testGenerator(){
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(true)
                .setAuthor("LiJiaLe")
                .setOutputDir("D:\\mybatis_plus\\src\\main\\java")
                .setFileOverride(true)
                .setIdType(IdType.AUTO)
                .setServiceName("%sService")
                .setBaseResultMap(true)
                .setBaseColumnList(true);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUrl("jdbc:mysql://localhost:3306/mybatisplus?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true")
                .setUsername("root")
                .setPassword("1234");

        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("tbl_").setInclude("tbl_customer");

        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.learn")
                .setMapper("dao")
                .setController("controller")
                .setService("service")
                .setEntity("pojo")
                .setXml("dao");

        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        autoGenerator.execute();
    }


}

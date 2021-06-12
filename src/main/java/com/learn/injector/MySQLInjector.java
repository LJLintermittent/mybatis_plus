package com.learn.injector;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.AbstractSqlInjector;
import com.learn.pojo.Employee;
import org.apache.ibatis.builder.MapperBuilderAssistant;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/9/7 21:21<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class MySQLInjector extends AbstractSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        return null;
    }

    @Override
    public void inspectInject(MapperBuilderAssistant builderAssistant, Class<?> mapperClass) {

    }
}

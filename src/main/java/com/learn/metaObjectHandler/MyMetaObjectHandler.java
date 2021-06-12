package com.learn.metaObjectHandler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/9/8 18:51<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    public void insertFill(MetaObject metaObject) {

        Object gender = this.getFieldValByName("email", metaObject);
        if (gender == null) {
            //避免使用metaObject.setValue()
            this.setFieldValByName("email", "LJLJLJLJLJ@qq.com", metaObject);
        }

    }

    public void updateFill(MetaObject metaObject) {
        Object gender = this.getFieldValByName("email", metaObject);
        if (gender == null) {
            this.setFieldValByName("email", "XXXXXXXX@qq.com", metaObject);
        }
    }
}

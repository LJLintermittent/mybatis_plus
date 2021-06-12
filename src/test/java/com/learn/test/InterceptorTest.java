package com.learn.test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.dao.CustomerMapper;
import com.learn.dao.EmployeeMapper;
import com.learn.pojo.Customer;
import com.learn.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/9/3 20:39<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
public class InterceptorTest {
    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);
    private CustomerMapper customerMapper = context.getBean(CustomerMapper.class);


    @Test
    public void testOptimisticLocker(){
        Employee employee = new Employee();
        employee.setId(25);
        employee.setLastName("nuiwndinwqndwiqd");
        employee.setEmail("tom@atguigu.com");
        employee.setGender(1);
        employee.setAge(22);
        employee.setVersion(3);
        employeeMapper.updateById(employee);
    }

    @Test
    public void testSQLExplain(){
        employeeMapper.delete(null);
    }

    @Test
    public void testPage(){
        Page<Employee> page = employeeMapper.selectPage(new Page<Employee>(1, 3), null);
        List<Employee> records = page.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }
        System.out.println("总条数:"+page.getTotal());
        System.out.println("当前页码:"+page.getCurrent());
        System.out.println("总页码:"+page.getPages());
        System.out.println("每页显示的条数:"+page.getSize());
        System.out.println("是否有上一页:"+page.hasPrevious());
        System.out.println("是否有下一页:"+page.hasNext());

    }

    @Test
    public void testDemo(){
        List<Customer> list = customerMapper.selectList(null);
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }
}

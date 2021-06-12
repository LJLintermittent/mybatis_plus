package com.learn.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.dao.EmployeeMapper;
import com.learn.pojo.Employee;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/9/2 22:03<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@SuppressWarnings("all")
public class ARTest {
    private ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);

    @Test
    public void testARInsert() {
        Employee employee = new Employee();
        employee.setLastName("MMMM");
        employee.setEmail("MMM163@qq.com");
        employee.setGender(1);
        employee.setAge(20);
        boolean insert = employee.insert();
        System.out.println(insert);
    }

    @Test
    public void testARUpdate() {
        Employee employee = new Employee();
        employee.setId(13);
        employee.setLastName("MMMM");
        employee.setEmail("MMM163@qq.com");
        employee.setGender(1);
        employee.setAge(20);
        boolean b = employee.updateById();
        System.out.println(b);
    }

    @Test
    public void testARSelect() {
        Employee employee = new Employee();
//        Employee employee1 = employee.selectById(13);
//        System.out.println(employee1);

//        List<Employee> employeeList = employee.selectAll();
//        for (Employee employee1 : employeeList) {
//            System.out.println(employee1);
//        }

//        List<Employee> employeeList = employee.selectList(new QueryWrapper<Employee>().like("last_name", "MM"));
//        for (Employee employee1 : employeeList) {
//            System.out.println(employee1);
//        }

        Integer count = employee.selectCount(new QueryWrapper<Employee>().eq("gender", 0));
        System.out.println("gender=0的数量为:" + count);
    }

    @Test
    public void testARDelete() {
        Employee employee = new Employee();
//        boolean b = employee.deleteById(13);
//        System.out.println(b);
        boolean delete = employee.delete(new QueryWrapper<Employee>().like("last_name", "M"));
        System.out.println(delete);
    }

    @Test
    public void testARPage() {
        Employee employee = new Employee();
        Page<Employee> page = employee.selectPage(new Page<Employee>(1, 1),
                new QueryWrapper<Employee>().orderByDesc("age"));
        List<Employee> records = page.getRecords();
        for (Employee record : records) {
            System.out.println(record);
        }
    }


}

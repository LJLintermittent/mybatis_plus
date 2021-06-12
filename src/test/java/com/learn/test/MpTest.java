package com.learn.test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learn.dao.EmployeeMapper;
import com.learn.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/8/31 22:22<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@SuppressWarnings("all")
public class MpTest {

    private ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);

    @Test
    public void testDelete() {
//        int i = employeeMapper.deleteById(5);
//        System.out.println(i);

//        HashMap<String, Object> map = new HashMap<String, Object>();
//        map.put("last_name","emp5");
//        map.put("email","LJL163@qq.com");
//        int i = employeeMapper.deleteByMap(map);
//        System.out.println(i);
        ArrayList<Integer> idList = new ArrayList<Integer>();
        idList.add(6);
        idList.add(7);
        idList.add(8);
        idList.add(9);
        int i = employeeMapper.deleteBatchIds(idList);
        System.out.println(i);
    }

    @Test
    public void testSelect() {
        Employee employee = employeeMapper.selectById(2);
        System.out.println(employee);

//        ArrayList<Integer> idlist = new ArrayList<Integer>();
//        idlist.add(1);
//        idlist.add(2);
//        idlist.add(3);
//        idlist.add(4);
//        List<Employee> employeeList = employeeMapper.selectBatchIds(idlist);
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
//        }

//        HashMap<String, Object> columnMap = new HashMap<String, Object>();
//        columnMap.put("last_name","emp1");
//        columnMap.put("gender",1);
//        List<Employee> employeeList = employeeMapper.selectByMap(columnMap);
//        for (Employee employee : employeeList) {
//            System.out.println(employee);
//        }

//        Page<Employee> employeePage = employeeMapper.selectPage(new Page<Employee>(1, 4), null);
//        List<Employee> records = employeePage.getRecords();
//        for (Employee record : records) {
//            System.out.println(record);
//        }
    }

    @Test
    public void testUpdate() {
        Employee employee = new Employee();
        employee.setId(30);
        employee.setLastName("LJLJLJL");
        employee.setEmail("LJLJLJL163@qq.com");
        employee.setGender(0);
        employee.setAge(100);
        int i = employeeMapper.updateById(employee);
        System.out.println("对数据库的影响行数为:" + i);
    }

    @Test
    public void testInsert() {
        Employee employee = new Employee();
        employee.setLastName("emp5");
        employee.setEmail("LJL163@qq.com");
//        employee.setGender(2);
//        employee.setAge(21);
        employee.setSalary(20000.0);
        employeeMapper.insert(employee);
        Integer id = employee.getId();
        System.out.println("主键的id为" + id);

    }

    @Test
    public void testDatasource() throws SQLException {
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testEntityWrapperSelect() {
//        employeeMapper.selectPage(new Page<Employee>(1,2),new QueryWrapper<Employee>()
//                .between("age",18,50)
//                .eq("gender",1)
//                .eq("email","LJL163@qq.com"));

        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>()
                .eq("gender", 1)
                .like("email", "LJL")
                .or()
                .eq("gender", 0)
                .like("email", "atguigu")
        );
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }

    }

    @Test
    public void testEntityWrapperUpdate() {
        Employee employee = new Employee();
        employee.setGender(1);
        employee.setEmail("LJL163@atguigu.com");
        employee.setLastName("LJL");
        employeeMapper.update(employee, new QueryWrapper<Employee>()
                .eq("last_name", "LJLJLJL")
                .eq("age", 100)
        );
    }

    @Test
    public void testEntityWrapperDelete() {
        employeeMapper.delete(new QueryWrapper<Employee>()
                .eq("last_name", "Kd")
                .eq("age", 30)
        );
    }

    @Test
    public void testOrderBy() {
        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>()
                .eq("gender", 1)
                .orderByDesc("age")
                .last("limit 1,4")
        );
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testMetaObjectHandler() {
        Employee employee = new Employee();
        employee.setId(30);
//        employeeMapper.insert(employee);
        employeeMapper.updateById(employee);
    }


}

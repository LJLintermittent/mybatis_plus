package com.learn.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;

/**
 * 一些声明信息
 * Description: <br/>
 * date: 2020/8/31 21:49<br/>
 *
 * @author ${李佳乐}<br/>
 * @since JDK 1.8
 */
@TableName(value = "tbl_employee")
public class Employee extends Model<Employee> {
    /**
     *    id INT(11) PRIMARY KEY AUTO_INCREMENT,
     *    last_name VARCHAR(50),
     *    email VARCHAR(50),
     *    gender CHAR(1),
     *    age INT
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField(value = "last_name")
    private String lastName;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String email;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer gender;

    private Integer age;

    @TableField(exist = false)
    private Double salary;

    @Version
    private Integer version;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Integer age) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                '}';
    }


}

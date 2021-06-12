package com.learn.service.impl;

import com.learn.pojo.Customer;
import com.learn.dao.CustomerMapper;
import com.learn.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LiJiaLe
 * @since 2020-09-03
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

}

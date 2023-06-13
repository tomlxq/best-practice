package com.example.demo1.service.impl.user;

import com.example.entity.user.Account;
import com.example.mapper.user.AccountMapper;
import com.example.demo1.service.user.AccountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tomLuo
 * @since 2023-03-12
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {

}

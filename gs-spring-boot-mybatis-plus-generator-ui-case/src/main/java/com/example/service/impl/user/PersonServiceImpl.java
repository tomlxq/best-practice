package com.example.service.impl.user;

import com.example.entity.user.Person;
import com.example.mapper.user.PersonMapper;
import com.example.service.user.PersonService;
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
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}

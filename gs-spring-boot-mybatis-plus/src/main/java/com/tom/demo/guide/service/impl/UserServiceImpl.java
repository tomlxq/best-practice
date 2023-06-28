package com.tom.demo.guide.service.impl;

import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tom.demo.guide.mapper.UserMapper;
import com.tom.demo.guide.pojo.User;
import com.tom.demo.guide.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Objects;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author TomLuo
 * @since 2023-03-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * Mybatis-Plus方法saveOrUpdate可能导致死锁
     * 直接采用Mybatis-Plus提供的saveOrUpdate方法，
     * 但是根据源码发现，会有很多额外的反射操作，并且还添加了事务，
     * 大家都知道，MySQL单表操作完全不需要开事务，会增加额外的开销。
     *
     * @param entity
     * @return
     */
    @Transactional(
            rollbackFor = {Exception.class}
    )
    public boolean saveOrUpdate(User entity) {
        if (null == entity) {
            return false;
        }
        Class<?> cls = entity.getClass();
        TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
        Assert.notNull(tableInfo, "error: can not execute. because can not find cache of TableInfo for entity!", new Object[0]);
        String keyProperty = tableInfo.getKeyProperty();
        Assert.notEmpty(keyProperty, "error: can not execute. because can not find column for id from entity!", new Object[0]);
        Object idVal = ReflectionKit.getFieldValue(entity, tableInfo.getKeyProperty());
        return !StringUtils.checkValNull(idVal) && Objects.nonNull(this.baseMapper.selectById((Serializable) idVal)) ? this.baseMapper.updateById(entity) == 1 : this.baseMapper.insert(entity) == 1;
    }
}

package com.zzf.asyndemo.service;

import com.github.pagehelper.PageHelper;

import com.zzf.asyndemo.mapper.UserMapper;
import com.zzf.asyndemo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertUser() {
        long beginTime = System.currentTimeMillis();
        SqlSession session = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
        try{
            UserMapper insertMapper = session.getMapper(UserMapper.class);
            List<User> users = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                User user = new User();
                String index = new DecimalFormat("000000").format(i);
                user.setUserName("zzf"+index);
                user.setPassword("123456");
                user.setEmail("123@qq.com");
                users.add(user);
            }
            for (User user : users) {
                insertMapper.insertUser(user);
            }
            session.commit();
            session.clearCache();
        }catch (Exception e){
            session.rollback();
            throw e;
        }finally {
            session.close();
        }
        log.debug("插入时长为"+(System.currentTimeMillis() - beginTime));

    }

    @Override
    public List<User> getUser() {
        PageHelper.startPage(1, 5);
        return userMapper.getUser();
    }
}


package com.eh.exam.dev.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eh.exam.dev.model.User;
import com.eh.exam.dev.util.OffsetUtil;
import com.eh.exam.dev.mapper.UserMapper;
/**
 * @author   Md. Emran Hossain <emranhos1@gmail.com>
 * @version  1.0.00 EH
 * @since    1.0.00 EH
 */
@Service
@Transactional(readOnly=false)
public class UserServiceImpl implements UserService{

    @SuppressWarnings("unused")
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserMapper mapper;

    @Override
    public Long countAll() {
        return mapper.countAll();
    }

    @Override
    public Long pageCount(int size) {
        Long noOfRecords = mapper.countAll();
        Long pages = OffsetUtil.getPageCount(noOfRecords, size);
        return pages;
    }

    @Override
    public List<User> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public List<User> searchByOffset(Map<String, Object> param) {
        return mapper.searchByOffset(param);
    }

    @Override
    public User selectByCode(String code) {
        return mapper.selectByCode(code);
    }

    @Override
    public void insert(User user) {
        mapper.insert(user);
    }

    @Override
    public void update(User user) {
        mapper.update(user);
    }
}

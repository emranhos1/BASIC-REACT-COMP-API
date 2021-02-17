package com.eh.exam.dev.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.eh.exam.dev.model.User;
/**
 * @author   Md. Emran Hossain <emranhos1@gmail.com>
 * @version  1.0.00 EH
 * @since    1.0.00 EH
 */
@Mapper
public interface UserMapper {

    Long countAll();
    Long pageCount(int size);
    
    List<User> selectAll();
    List<User> searchByOffset(Map<String, Object> param);

    User selectByCode(String code);

    void insert(User user);
    void update(User user);
}

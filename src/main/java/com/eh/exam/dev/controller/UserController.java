package com.eh.exam.dev.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eh.exam.dev.model.User;
import com.eh.exam.dev.service.UserService;
/**
 * @author   Md. Emran Hossain <emranhos1@gmail.com>
 * @version  1.0.00 EH
 * @since    1.0.00 EH
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService service;

    @GetMapping("/all")
    public Map<String, Object> findAll() {
        Map<String, Object> res = new HashMap<String, Object>();

        List<User> users = service.selectAll();
        if(!CollectionUtils.isEmpty(users)){
            res.put("data", users);
        } else {
            res.put("data", null);
        }
        
        long total = service.countAll();
        String message = CollectionUtils.isEmpty(users) ? "No Record Found" : "Records Found";
        res.put("data", users);
        res.put("total", total);
        res.put("success", CollectionUtils.isEmpty(users) ? false : true);
        res.put("message", message);
        return res;
    }

    @GetMapping("/{code}")
    public Map<String, Object> findByCode(@PathVariable("code") String code) {
        Map<String, Object> res = new HashMap<String, Object>();
        User responseData = null;
        
        User user = service.selectByCode(code);
        if(!ObjectUtils.isEmpty(user)){
            responseData = user;
        } else {
            responseData = null;
        }

        String message = ObjectUtils.isEmpty(responseData) ? "No Record Found" : "One Record Found";
        res.put("data", responseData);
        res.put("total", ObjectUtils.isEmpty(responseData) ? 0 : 1);
        res.put("success", ObjectUtils.isEmpty(responseData) ? false : true);
        res.put("message", message);
        return res;
    }

    @PostMapping("/add")
    public Map<String, Object> create(@RequestBody User user) {

        Map<String, Object> response = new HashMap<String, Object>();
        
        user.setEntryDate(new Date());
        user.setEntryUser("SELF");
        service.insert(user);

        response.put("data", user);
        response.put("success", true);
        response.put("message", "One Record Inserted");
        return response;
    }

    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody User user) {

        Map<String, Object> response = new HashMap<String, Object>();
        user.setAmendDate(new Date());
        user.setAmendUser("SELF");
        service.update(user);

        response.put("data", user);
        response.put("success", true);
        response.put("message", "One Record Updated");
        return response;
    }
}

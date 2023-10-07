package com.sovava.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sovava.pojo.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface UserService extends IService<User> {
    User findUser(String name);

    void addHitsCount();

    Integer getHitsCount();


    Boolean login(Map<String, String> paramMap, HttpServletRequest httpServletRequest);

    void updateImg(String fileName);

    String getImg();
}

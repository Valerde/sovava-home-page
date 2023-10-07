package com.sovava.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.constant.LoginConstant;
import com.sovava.dao.UserDao;
import com.sovava.pojo.User;
import com.sovava.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Service("userService")
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public User findUser(String name) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getUsername, name);
        User user = this.baseMapper.selectOne(lqw);
        return user;
    }

    @Override
    public void addHitsCount() {
        redisTemplate.opsForValue().setIfAbsent(LoginConstant.HITS_COUNT, "0");
        String s = redisTemplate.opsForValue().get(LoginConstant.HITS_COUNT);
        log.debug("自增之前的redis数据：{}", s);
        redisTemplate.opsForValue().increment(LoginConstant.HITS_COUNT);
        s = redisTemplate.opsForValue().get(LoginConstant.HITS_COUNT);
        log.debug("自增之后的redis数据：{}", s);
    }

    @Override
    public Integer getHitsCount() {
        String hitsCount = redisTemplate.opsForValue().get(LoginConstant.HITS_COUNT);
        int temp = 0;
        if (!StringUtils.isEmpty(hitsCount)) temp = Integer.parseInt(hitsCount);
        return temp;
    }




    /**
     * description: TODO:
     *
     * @Author sovava
     * @Date 4/22/23 5:31 PM
     * @param: paramMap - [java.util.Map<java.lang.String]
     * @param: httpServletRequest - [java.lang.String>]
     * @return Boolean
     */
    @Override
    public Boolean login(Map<String, String> paramMap, HttpServletRequest httpServletRequest) {
        User user = new User();
        user.setUsername(paramMap.get("username"));
        user.setPassword(paramMap.get("password"));
//        HttpSession session = httpServletRequest.getSession();
//        session.setAttribute(LoginConstant.LOGIN_USER, user);
        User userFromDB = this.findUser(user.getUsername());
        log.debug(user.toString());
        if (userFromDB != null && userFromDB.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }

    }


    @Override
    public void updateImg(String fileName) {
        this.baseMapper.updateImg(fileName);
    }

    @Override
    public String getImg() {
        return this.getById(1L).getImg();
    }


}

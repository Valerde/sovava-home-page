package com.sovava.controller;

import com.sovava.constant.LoginConstant;
import com.sovava.pojo.User;
import com.sovava.service.UserService;
import com.sovava.util.R;
import lombok.extern.slf4j.Slf4j;
import org.apache.hc.core5.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login/{path1}/{path2}")
    public String login(@PathVariable("path1") String path1, @PathVariable("path2") String path2, Model model) {

        model.addAttribute("path1", path1);
        model.addAttribute("path2", path2);
        log.debug("传回的路径信息为：{},/,{}", path1, path2);
        return "loginPage";

    }

    @PostMapping("/login")
    public String validLogin(@RequestParam Map<String, String> paramMap, HttpServletRequest httpServletRequest) {
        log.debug("用户验证信息为：{}", paramMap.toString());
        Boolean flag = userService.login(paramMap, httpServletRequest);
        String path1 = paramMap.get("path1");
        String path2 = paramMap.get("path2");
        if (flag) {
            return "redirect:http://192.168.37.131:8081/" + path1 + "/" + path2;
        } else {
            return "redirect:http://192.168.37.131:8081/page/";
        }
    }

    @GetMapping("/updateImg")
    public String update() {
        return "uploadImg";
    }

    @Value("${file.upload.path}")
    private String imgPath;


    @PostMapping("/upload")
    public String create(@RequestPart MultipartFile file) throws IOException {
        String uuid = UUID.randomUUID().toString().substring(1, 11);
        String fileName = uuid + ".png";
        String oldFileName = userService.getImg();
        String filePath = imgPath + oldFileName;
        Path path1 = new File(filePath).toPath();
        Files.deleteIfExists(path1);
        filePath = imgPath + fileName;
        userService.updateImg(fileName);
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());

        return "redirect:http://192.168.37.131:8081/page/";
    }

}

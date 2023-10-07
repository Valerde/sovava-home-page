package com.sovava.controller;

import com.sovava.pojo.Experience;
import com.sovava.pojo.Location;
import com.sovava.service.ExperienceService;
import com.sovava.service.LocationService;
import com.sovava.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/page")
public class WebController {
    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ExperienceService experienceService;


    @GetMapping("/")
    public String getindex(Model model) {
        userService.addHitsCount();

        List<Location> list = locationService.list();
        Location location = list.get(0);
        model.addAttribute("location", location);

        List<Experience> experiences = experienceService.list();
        model.addAttribute("experiences", experiences);
        model.addAttribute("hitsCount", userService.getHitsCount());

        String img = userService.getImg();
        model.addAttribute("filename",img);
        return "index";
    }

}

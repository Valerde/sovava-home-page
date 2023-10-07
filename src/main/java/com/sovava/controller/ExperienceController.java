package com.sovava.controller;

import com.sovava.pojo.Experience;
import com.sovava.service.ExperienceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/exp")
@Slf4j
public class ExperienceController {
    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/editExp")
    public String editExp(Model model) {
        List<Experience> list = experienceService.list();

        model.addAttribute("experiences", list);
        return "editExp";
    }

    @GetMapping("/addExp")
    public String addExpPage() {
        return "addExp";
    }

    @PostMapping("/add")
    public String addExp(@RequestParam Map<String, String> paramMap) {
        Experience experience = new Experience();
        experience.setContent(paramMap.get("content"));
        experience.setTime(paramMap.get("time"));
        log.debug("新增的经历为：{}", experience.toString());
        experienceService.save(experience);
        return "redirect:http://192.168.37.131:8081/exp/editExp";
    }

    @GetMapping("/updateExp")
    public String updateExpPage(Long id, Model model) {
        log.debug("修改的id为{}", id);
        Experience experience = experienceService.getById(id);
        log.debug("修改的原数据为：{}", experience.toString());
        model.addAttribute("experience", experience);
        return "updateExp";
    }

    @GetMapping("/deleteExp")
    public String deleteExp(Long id) {
        boolean b = experienceService.removeById(id);
        return "redirect:http://192.168.37.131:8081/exp/editExp";
    }

    @PostMapping("/update")
    public String updateExp(@RequestParam Map<String, String> paramMap) {
        Experience experience = new Experience();
        log.debug("参数为：{}", paramMap.toString());
        log.debug("参数为id：{}", paramMap.get("id"));
        String id = paramMap.get("id");

        experience.setId(new Long(id));
        experience.setTime(paramMap.get("time"));
        experience.setContent(paramMap.get("content"));
        log.debug("修改后的经历为：{}", experience.toString());
        experienceService.updateById(experience);
        return "redirect:http://192.168.37.131:8081/exp/editExp";
    }
}

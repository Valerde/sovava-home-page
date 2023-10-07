package com.sovava.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sovava.pojo.Experience;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ExperienceService extends IService<Experience> {

    List<Experience> selectAll();
    Experience selectByContent(String content);

    void addExperience(Experience experience);

    void updateExperience(Experience experience);

    void deleteExperience(Experience experience);
}

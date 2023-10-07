package com.sovava.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.dao.ExperienceDao;
import com.sovava.pojo.Experience;
import com.sovava.service.ExperienceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("experienceService")
public class ExperienceServiceImpl extends ServiceImpl<ExperienceDao, Experience> implements ExperienceService {
    @Override
    public List<Experience> selectAll() {
        return null;
    }

    @Override
    public Experience selectByContent(String content) {
        return null;
    }

    @Override
    public void addExperience(Experience experience) {

    }

    @Override
    public void updateExperience(Experience experience) {

    }

    @Override
    public void deleteExperience(Experience experience) {

    }
}

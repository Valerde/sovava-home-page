package com.sovava.controller;

import com.sovava.pojo.Location;
import com.sovava.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.FloatControl;
import java.util.Map;

@Controller
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/editCity")
    public String editCity(Model model) {
        Location location = locationService.getById(1L);
        model.addAttribute("location", location);
        return "editCity";
    }


    /**
     *
     * @param paramMap
     * @return
     */
    @PostMapping("/update")
    public String updateCity(@RequestParam Map<String,String> paramMap) {
        Location location = new Location();
        location.setId(new Long(paramMap.get("id")));
        location.setProvince(paramMap.get("province"));
        location.setCity(paramMap.get("city"));
        locationService.updateById(location);
        return "redirect:http://192.168.37.131:8081/page/";
    }

}

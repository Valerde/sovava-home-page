package com.sovava.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sovava.pojo.Location;
import com.sovava.pojo.User;
import org.springframework.stereotype.Service;

public interface LocationService extends IService<Location> {
    Location findLocation(int id);
    void update(Location location);

}

package com.sovava.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sovava.dao.LocationDao;
import com.sovava.pojo.Location;
import com.sovava.pojo.User;
import com.sovava.service.LocationService;
import org.springframework.stereotype.Service;

@Service("locationService")
public class LocationServiceImpl extends ServiceImpl<LocationDao, Location> implements LocationService {
    @Override
    public Location findLocation(int id) {
        return null;
    }

    @Override
    public void update(Location location) {

    }

}

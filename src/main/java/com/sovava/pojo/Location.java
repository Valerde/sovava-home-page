package com.sovava.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
@Data
@TableName("tb_location")
public class Location implements Serializable {
    private Long id;
    private String province;
    private String city;
}

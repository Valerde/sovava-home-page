package com.sovava.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("tb_experience")
public class Experience implements Serializable {
    private Long id;
    private String time;
    private String content;
}

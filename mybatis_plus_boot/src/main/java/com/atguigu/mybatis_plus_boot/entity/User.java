package com.atguigu.mybatis_plus_boot.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class User {
//    @TableId(type = IdType.ID_WORKER)
//    @TableId(type = IdType.ID_WORKER_STR)
//    @TableId(type = IdType.AUTO)
//    @TableId(type = IdType.INPUT)
    private Long id;
    private String name;
    private int age;
    private String email;

    @TableField(fill = FieldFill.INSERT)//插入的时候可以被填充的字段
    private Date createTime;
    //@TableField(fill = FieldFill.UPDATE)//更新的时候可以被填充的字段
    @TableField(fill = FieldFill.INSERT_UPDATE)//插入和更新的时候可以被填充的字段
    private Date updateTime;

    @Version
    private Integer version;
}
